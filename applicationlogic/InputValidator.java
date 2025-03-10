package cs.project.biomegenerator.applicationlogic;

import java.awt.Color;
import java.util.Map;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    // Constants for validation
    private static final double MIN_TEMPERATURE = -2.0;
    private static final double MAX_TEMPERATURE = 2.0;
    private static final double MIN_DOWNFALL = 0.0;
    private static final double MAX_DOWNFALL = 1.0;
    private static final double MIN_SPAWN_PROBABILITY = 0.0;
    private static final double MAX_SPAWN_PROBABILITY = 1.0;
    private static final int MIN_COLOR_VALUE = 0;
    private static final int MAX_COLOR_VALUE = 16777215; 
    private static final int MIN_SPAWN_WEIGHT = 1;
    private static final int MAX_SPAWN_WEIGHT = 100;
    private static final int MIN_SPAWN_COUNT = 1;
    private static final int MAX_SPAWN_COUNT = 50;
    private static final double MIN_ENERGY_COST = 0.0;
    private static final double MAX_ENERGY_COST = 1000.0;
    private static final double MIN_CHARGE = 0.0;
    private static final double MAX_CHARGE = 100.0;
    
    private static final Set<String> VALID_MONSTER_TYPES = new HashSet<>(Arrays.asList(
        "minecraft:zombie", "minecraft:skeleton", "minecraft:spider", "minecraft:creeper",
        "minecraft:enderman", "minecraft:witch", "minecraft:slime", "minecraft:phantom"
    ));
    
    private static final Set<String> VALID_CARVERS = new HashSet<>(Arrays.asList(
        "minecraft:cave", "minecraft:canyon", "minecraft:underwater_cave", "minecraft:underwater_canyon"
    ));

    /**
     * Validates all biome configuration parameters
     * @param config The configuration map to validate
     * @return true if all parameters are valid false otherwise
     */
    public static boolean validateConfiguration(Map<String, Object> config) {
        try {
            // Validate basic parameters
            if (!validateBasicParameters(config)) return false;
            
            // Validate effects
            if (!validateEffects((Map<String, Object>) config.get("effects"))) return false;
            
            // Validate spawner
            if (!validateSpawner((Map<String, Object>) config.get("spawner"))) return false;
            
            // Validate spawn costs
            if (!validateSpawnCosts((Map<String, Object>) config.get("spawn_costs"))) return false;
            
            // Validate carver
            if (!validateCarver(config.get("carver"))) return false;
            
            return true;
        } catch (Exception e) {
            System.err.println("Validation error: " + e.getMessage());
            return false;
        }
    }

    private static boolean validateBasicParameters(Map<String, Object> config) {
        double temperature = ((Number) config.get("temperature")).doubleValue();
        double downfall = ((Number) config.get("downfall")).doubleValue();
        double spawnProb = ((Number) config.get("creature_spawn_probability")).doubleValue();
        
        return isInRange(temperature, MIN_TEMPERATURE, MAX_TEMPERATURE) &&
               isInRange(downfall, MIN_DOWNFALL, MAX_DOWNFALL) &&
               isInRange(spawnProb, MIN_SPAWN_PROBABILITY, MAX_SPAWN_PROBABILITY);
    }

    private static boolean validateEffects(Map<String, Object> effects) {
        if (effects == null) return false;
        
        return validateColorValue(((Number) effects.get("sky_color")).intValue()) &&
               validateColorValue(((Number) effects.get("fog_color")).intValue()) &&
               validateColorValue(((Number) effects.get("water_color")).intValue()) &&
               validateColorValue(((Number) effects.get("water_fog_color")).intValue()) &&
               validateColorValue(((Number) effects.get("grass_color")).intValue()) &&
               validateColorValue(((Number) effects.get("foliage_color")).intValue());
    }

    private static boolean validateSpawner(Map<String, Object> spawner) {
        if (spawner == null) return true; // Spawner is optional
        
        String type = (String) spawner.get("type");
        int weight = ((Number) spawner.get("weight")).intValue();
        int minCount = ((Number) spawner.get("min_count")).intValue();
        int maxCount = ((Number) spawner.get("max_count")).intValue();
        
        return VALID_MONSTER_TYPES.contains(type) &&
               isInRange(weight, MIN_SPAWN_WEIGHT, MAX_SPAWN_WEIGHT) &&
               isInRange(minCount, MIN_SPAWN_COUNT, MAX_SPAWN_COUNT) &&
               isInRange(maxCount, MIN_SPAWN_COUNT, MAX_SPAWN_COUNT) &&
               minCount <= maxCount;
    }

    private static boolean validateSpawnCosts(Map<String, Object> spawnCosts) {
        if (spawnCosts == null) return true; // Spawn costs are optional
        
        double energyCost = ((Number) spawnCosts.get("energy_cost")).doubleValue();
        double charge = ((Number) spawnCosts.get("charge")).doubleValue();
        
        return isInRange(energyCost, MIN_ENERGY_COST, MAX_ENERGY_COST) &&
               isInRange(charge, MIN_CHARGE, MAX_CHARGE);
    }

    private static boolean validateCarver(Object carver) {
        if (carver == null) return true; // Carver is optional
        return VALID_CARVERS.contains((String) carver);
    }

    private static boolean validateColorValue(int color) {
        return isInRange(color, MIN_COLOR_VALUE, MAX_COLOR_VALUE);
    }

    private static boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }

    private static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
}
