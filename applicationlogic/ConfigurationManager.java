package cs.project.biomegenerator.applicationlogic;

import cs.project.biomegenerator.presentation.UIComponents;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    private Map<String, Object> biomeConfiguration;
    private UIComponents uiComponents;
    
    public ConfigurationManager() {
        biomeConfiguration = new HashMap<>();
    }
    
    public ConfigurationManager(UIComponents uiComponents) {
        this();
        this.uiComponents = uiComponents;
    }
    
    /**x
     * Collects all values from UI components and stores them in the configuration
     */
    public void collectUIValues() {
        // Basic biome parameters
        biomeConfiguration.put("temperature", uiComponents.getBiomeTemperatureSpinner().getValue());
        biomeConfiguration.put("downfall", uiComponents.getBiomeDownfallSpinner().getValue());
        biomeConfiguration.put("precipitation", uiComponents.getBiomePrecipitationCheckbox().isSelected());
        biomeConfiguration.put("creature_spawn_probability", uiComponents.getCreatureSpawnProbabilitySpinner().getValue());
        
        // Biome effects
        Map<String, Object> effects = new HashMap<>();
        effects.put("sky_color", uiComponents.getSkyColorSpinner().getValue());
        effects.put("fog_color", uiComponents.getFogColorSpinner().getValue());
        effects.put("water_color", uiComponents.getWaterColorSpinner().getValue());
        effects.put("water_fog_color", uiComponents.getWaterFogColorSpinner().getValue());
        effects.put("grass_color", uiComponents.getGrassColorSpinner().getValue());
        effects.put("foliage_color", uiComponents.getFoliageColorSpinner().getValue());
        biomeConfiguration.put("effects", effects);
        
        // Monster spawner
        Map<String, Object> spawner = new HashMap<>();
        spawner.put("type", uiComponents.getMonsterTypeComboBox().getSelectedItem());
        spawner.put("weight", uiComponents.getMonsterWeightSpinner().getValue());
        spawner.put("min_count", uiComponents.getMonsterMinCountSpinner().getValue());
        spawner.put("max_count", uiComponents.getMonsterMaxCountSpinner().getValue());
        biomeConfiguration.put("spawner", spawner);
        
        // Spawn costs
        Map<String, Object> spawnCosts = new HashMap<>();
        spawnCosts.put("energy_cost", uiComponents.getEnergyCostSpinner().getValue());
        spawnCosts.put("charge", uiComponents.getChargeCostSpinner().getValue());
        biomeConfiguration.put("spawn_costs", spawnCosts);
        
        // Carvers
        biomeConfiguration.put("carver", uiComponents.getCarversComboBox().getSelectedItem());
    }
    
    /**
     * Gets the complete biome configuration
     * @return Map containing all biome configuration values
     */
    public Map<String, Object> getBiomeConfiguration() {
        return biomeConfiguration;
    }
    
    /**
     * Saves the configuration to a file or database
     * @return true if save was successful, false otherwise
     */
    public boolean saveConfiguration() {
        collectUIValues();
        // Implement saving logic here (file I/O, database, etc.)
        System.out.println("Saving configuration: " + biomeConfiguration);
        return true;
    }
}