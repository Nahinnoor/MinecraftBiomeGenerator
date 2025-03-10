package cs.project.biomegenerator.datapackgeneration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import cs.project.biomegenerator.applicationlogic.ConfigurationManager;
import cs.project.biomegenerator.presentation.UIComponents;

public class DataPackGenerator {
    private ConfigurationManager configManager;
    private static final String DEFAULT_OUTPUT_DIR = "generated_biomes";
    
    public DataPackGenerator(ConfigurationManager configManager) {
        this.configManager = configManager;
    }
    
    /**
     * Generates a biome JSON file from the configuration
     * @param biomeName The name of the biome
     * @return true if generation was successful, false otherwise
     */
    public boolean generateBiomeJson(String biomeName) {
        try {
            // Create output directory if it doesn't exist
            File outputDir = new File(DEFAULT_OUTPUT_DIR);
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }
            
            // Create JSON object from configuration
            JSONObject biomeJson = createBiomeJson();
            
            // Write JSON to file
            File outputFile = new File(outputDir, biomeName + ".json");
            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write(biomeJson.toJSONString());
                System.out.println("Biome JSON saved to: " + outputFile.getAbsolutePath());
                return true;
            }
        } catch (IOException e) {
            System.err.println("Error generating biome JSON: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Creates a JSON object from the configuration values
     * @return JSONObject representing the biome configuration
     */
    @SuppressWarnings("unchecked")
    private JSONObject createBiomeJson() {
        Map<String, Object> config = configManager.getBiomeConfiguration();
        JSONObject biomeJson = new JSONObject();
        
        // Basic parameters
        biomeJson.put("temperature", config.get("temperature"));
        biomeJson.put("downfall", config.get("downfall"));
        biomeJson.put("has_precipitation", config.get("precipitation"));
        biomeJson.put("creature_spawn_probability", config.get("creature_spawn_probability"));
        
        // Effects
        JSONObject effects = new JSONObject();
        Map<String, Object> effectsConfig = (Map<String, Object>) config.get("effects");
        effects.put("sky_color", effectsConfig.get("sky_color"));
        effects.put("fog_color", effectsConfig.get("fog_color"));
        effects.put("water_color", effectsConfig.get("water_color"));
        effects.put("water_fog_color", effectsConfig.get("water_fog_color"));
        effects.put("grass_color", effectsConfig.get("grass_color"));
        effects.put("foliage_color", effectsConfig.get("foliage_color"));
        biomeJson.put("effects", effects);
        
        // Spawners
        JSONObject spawners = new JSONObject();
        JSONArray monsterArray = new JSONArray();
        
        String monsterType = (String) config.get("monster_type");
        if (monsterType != null && !monsterType.equals("null")) {
            JSONObject monster = new JSONObject();
            monster.put("type", monsterType);
            monster.put("weight", config.get("monster_weight"));
            monster.put("minCount", config.get("monster_min_count"));
            monster.put("maxCount", config.get("monster_max_count"));
            monsterArray.add(monster);
            spawners.put("monster", monsterArray);
            biomeJson.put("spawners", spawners);
        }
        
        // Spawn costs
        String spawnCostType = (String) config.get("spawn_cost_type");
        if (spawnCostType != null && !spawnCostType.equals("null")) {
            JSONObject spawnCosts = new JSONObject();
            JSONObject costDetails = new JSONObject();
            costDetails.put("energy_budget", config.get("energy_cost"));
            costDetails.put("charge", config.get("charge_cost"));
            spawnCosts.put(spawnCostType, costDetails);
            biomeJson.put("spawn_costs", spawnCosts);
        }
        
        // Carvers
        String carver = (String) config.get("carver");
        if (carver != null && !carver.equals("null")) {
            biomeJson.put("carvers", carver);
        }
        
        // Empty features array
        biomeJson.put("features", new JSONArray());
        
        return biomeJson;
    }
}