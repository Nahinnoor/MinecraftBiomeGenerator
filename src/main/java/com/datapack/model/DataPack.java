package com.datapack.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataPack {
    private String packFormat;
    private String description;
    private List<String> tags;
    private List<String> recipes;
    private List<String> advancements;
    private List<String> lootTables;
    private List<String> functions;
    private List<String> structures;
    private List<String> worldgen;
    private List<String> dimensions;
    private List<String> dimensionTypes;
    private List<String> biomes;
    private Map<String, BiomeSettings> biomeSettings;
    private List<String> blockStates;
    private List<String> blockTags;
    private List<String> itemTags;
    private List<String> entityTypeTags;
    private List<String> fluidTags;
    private List<String> gameEventTags;
    private List<String> damageTypeTags;
    private List<String> catVariantTags;
    private List<String> wolfVariantTags;
    private List<String> frogVariantTags;
    private List<String> paintingVariantTags;
    private List<String> villagerProfessionTags;
    private List<String> villagerTypeTags;
    private List<String> worldPresetTags;
    private List<String> trimMaterialTags;
    private List<String> trimPatternTags;
    private List<String> instrumentTags;
    private List<String> structureSetTags;
    private List<String> worldgenTags;
    private List<String> biomeTags;
    private List<String> flatLevelGeneratorPresetTags;
    private List<String> multiNoiseBiomeSourceParameterTags;
    private List<String> noiseSettingsTags;
    private List<String> placedFeatureTags;
    private List<String> processorListTags;
    private List<String> structureTags;
    private List<String> structureProcessorTags;
    private List<String> templatePoolTags;
    private List<String> worldgenBiomeTags;
    private List<String> worldgenDensityFunctionTags;
    private List<String> worldgenNoiseSettingsTags;
    private List<String> worldgenPlacedFeatureTags;
    private List<String> worldgenStructureTags;
    private List<String> worldgenStructureSetTags;
    private List<String> worldgenTemplatePoolTags;
    private List<String> worldgenWorldPresetTags;

    // Getters and Setters
    @JsonProperty("pack_format")
    public String getPackFormat() {
        return packFormat;
    }

    public void setPackFormat(String packFormat) {
        this.packFormat = packFormat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("biome_settings")
    public Map<String, BiomeSettings> getBiomeSettings() {
        return biomeSettings;
    }

    public void setBiomeSettings(Map<String, BiomeSettings> biomeSettings) {
        this.biomeSettings = biomeSettings;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<String> recipes) {
        this.recipes = recipes;
    }

    public List<String> getAdvancements() {
        return advancements;
    }

    public void setAdvancements(List<String> advancements) {
        this.advancements = advancements;
    }

    public List<String> getLootTables() {
        return lootTables;
    }

    public void setLootTables(List<String> lootTables) {
        this.lootTables = lootTables;
    }

    public List<String> getFunctions() {
        return functions;
    }

    public void setFunctions(List<String> functions) {
        this.functions = functions;
    }

    public List<String> getStructures() {
        return structures;
    }

    public void setStructures(List<String> structures) {
        this.structures = structures;
    }

    public List<String> getWorldgen() {
        return worldgen;
    }

    public void setWorldgen(List<String> worldgen) {
        this.worldgen = worldgen;
    }

    public List<String> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<String> dimensions) {
        this.dimensions = dimensions;
    }

    public List<String> getDimensionTypes() {
        return dimensionTypes;
    }

    public void setDimensionTypes(List<String> dimensionTypes) {
        this.dimensionTypes = dimensionTypes;
    }

    public List<String> getBiomes() {
        return biomes;
    }

    public void setBiomes(List<String> biomes) {
        this.biomes = biomes;
    }

    public List<String> getBlockStates() {
        return blockStates;
    }

    public void setBlockStates(List<String> blockStates) {
        this.blockStates = blockStates;
    }

    public List<String> getBlockTags() {
        return blockTags;
    }

    public void setBlockTags(List<String> blockTags) {
        this.blockTags = blockTags;
    }

    public List<String> getItemTags() {
        return itemTags;
    }

    public void setItemTags(List<String> itemTags) {
        this.itemTags = itemTags;
    }

    public List<String> getEntityTypeTags() {
        return entityTypeTags;
    }

    public void setEntityTypeTags(List<String> entityTypeTags) {
        this.entityTypeTags = entityTypeTags;
    }

    public List<String> getFluidTags() {
        return fluidTags;
    }

    public void setFluidTags(List<String> fluidTags) {
        this.fluidTags = fluidTags;
    }

    public List<String> getGameEventTags() {
        return gameEventTags;
    }

    public void setGameEventTags(List<String> gameEventTags) {
        this.gameEventTags = gameEventTags;
    }

    public List<String> getDamageTypeTags() {
        return damageTypeTags;
    }

    public void setDamageTypeTags(List<String> damageTypeTags) {
        this.damageTypeTags = damageTypeTags;
    }

    public List<String> getCatVariantTags() {
        return catVariantTags;
    }

    public void setCatVariantTags(List<String> catVariantTags) {
        this.catVariantTags = catVariantTags;
    }

    public List<String> getWolfVariantTags() {
        return wolfVariantTags;
    }

    public void setWolfVariantTags(List<String> wolfVariantTags) {
        this.wolfVariantTags = wolfVariantTags;
    }

    public List<String> getFrogVariantTags() {
        return frogVariantTags;
    }

    public void setFrogVariantTags(List<String> frogVariantTags) {
        this.frogVariantTags = frogVariantTags;
    }

    public List<String> getPaintingVariantTags() {
        return paintingVariantTags;
    }

    public void setPaintingVariantTags(List<String> paintingVariantTags) {
        this.paintingVariantTags = paintingVariantTags;
    }

    public List<String> getVillagerProfessionTags() {
        return villagerProfessionTags;
    }

    public void setVillagerProfessionTags(List<String> villagerProfessionTags) {
        this.villagerProfessionTags = villagerProfessionTags;
    }

    public List<String> getVillagerTypeTags() {
        return villagerTypeTags;
    }

    public void setVillagerTypeTags(List<String> villagerTypeTags) {
        this.villagerTypeTags = villagerTypeTags;
    }

    public List<String> getWorldPresetTags() {
        return worldPresetTags;
    }

    public void setWorldPresetTags(List<String> worldPresetTags) {
        this.worldPresetTags = worldPresetTags;
    }

    public List<String> getTrimMaterialTags() {
        return trimMaterialTags;
    }

    public void setTrimMaterialTags(List<String> trimMaterialTags) {
        this.trimMaterialTags = trimMaterialTags;
    }

    public List<String> getTrimPatternTags() {
        return trimPatternTags;
    }

    public void setTrimPatternTags(List<String> trimPatternTags) {
        this.trimPatternTags = trimPatternTags;
    }

    public List<String> getInstrumentTags() {
        return instrumentTags;
    }

    public void setInstrumentTags(List<String> instrumentTags) {
        this.instrumentTags = instrumentTags;
    }

    public List<String> getStructureSetTags() {
        return structureSetTags;
    }

    public void setStructureSetTags(List<String> structureSetTags) {
        this.structureSetTags = structureSetTags;
    }

    public List<String> getWorldgenTags() {
        return worldgenTags;
    }

    public void setWorldgenTags(List<String> worldgenTags) {
        this.worldgenTags = worldgenTags;
    }

    public List<String> getBiomeTags() {
        return biomeTags;
    }

    public void setBiomeTags(List<String> biomeTags) {
        this.biomeTags = biomeTags;
    }

    public List<String> getFlatLevelGeneratorPresetTags() {
        return flatLevelGeneratorPresetTags;
    }

    public void setFlatLevelGeneratorPresetTags(List<String> flatLevelGeneratorPresetTags) {
        this.flatLevelGeneratorPresetTags = flatLevelGeneratorPresetTags;
    }

    public List<String> getMultiNoiseBiomeSourceParameterTags() {
        return multiNoiseBiomeSourceParameterTags;
    }

    public void setMultiNoiseBiomeSourceParameterTags(List<String> multiNoiseBiomeSourceParameterTags) {
        this.multiNoiseBiomeSourceParameterTags = multiNoiseBiomeSourceParameterTags;
    }

    public List<String> getNoiseSettingsTags() {
        return noiseSettingsTags;
    }

    public void setNoiseSettingsTags(List<String> noiseSettingsTags) {
        this.noiseSettingsTags = noiseSettingsTags;
    }

    public List<String> getPlacedFeatureTags() {
        return placedFeatureTags;
    }

    public void setPlacedFeatureTags(List<String> placedFeatureTags) {
        this.placedFeatureTags = placedFeatureTags;
    }

    public List<String> getProcessorListTags() {
        return processorListTags;
    }

    public void setProcessorListTags(List<String> processorListTags) {
        this.processorListTags = processorListTags;
    }

    public List<String> getStructureTags() {
        return structureTags;
    }

    public void setStructureTags(List<String> structureTags) {
        this.structureTags = structureTags;
    }

    public List<String> getStructureProcessorTags() {
        return structureProcessorTags;
    }

    public void setStructureProcessorTags(List<String> structureProcessorTags) {
        this.structureProcessorTags = structureProcessorTags;
    }

    public List<String> getTemplatePoolTags() {
        return templatePoolTags;
    }

    public void setTemplatePoolTags(List<String> templatePoolTags) {
        this.templatePoolTags = templatePoolTags;
    }

    public List<String> getWorldgenBiomeTags() {
        return worldgenBiomeTags;
    }

    public void setWorldgenBiomeTags(List<String> worldgenBiomeTags) {
        this.worldgenBiomeTags = worldgenBiomeTags;
    }

    public List<String> getWorldgenDensityFunctionTags() {
        return worldgenDensityFunctionTags;
    }

    public void setWorldgenDensityFunctionTags(List<String> worldgenDensityFunctionTags) {
        this.worldgenDensityFunctionTags = worldgenDensityFunctionTags;
    }

    public List<String> getWorldgenNoiseSettingsTags() {
        return worldgenNoiseSettingsTags;
    }

    public void setWorldgenNoiseSettingsTags(List<String> worldgenNoiseSettingsTags) {
        this.worldgenNoiseSettingsTags = worldgenNoiseSettingsTags;
    }

    public List<String> getWorldgenPlacedFeatureTags() {
        return worldgenPlacedFeatureTags;
    }

    public void setWorldgenPlacedFeatureTags(List<String> worldgenPlacedFeatureTags) {
        this.worldgenPlacedFeatureTags = worldgenPlacedFeatureTags;
    }

    public List<String> getWorldgenStructureTags() {
        return worldgenStructureTags;
    }

    public void setWorldgenStructureTags(List<String> worldgenStructureTags) {
        this.worldgenStructureTags = worldgenStructureTags;
    }

    public List<String> getWorldgenStructureSetTags() {
        return worldgenStructureSetTags;
    }

    public void setWorldgenStructureSetTags(List<String> worldgenStructureSetTags) {
        this.worldgenStructureSetTags = worldgenStructureSetTags;
    }

    public List<String> getWorldgenTemplatePoolTags() {
        return worldgenTemplatePoolTags;
    }

    public void setWorldgenTemplatePoolTags(List<String> worldgenTemplatePoolTags) {
        this.worldgenTemplatePoolTags = worldgenTemplatePoolTags;
    }

    public List<String> getWorldgenWorldPresetTags() {
        return worldgenWorldPresetTags;
    }

    public void setWorldgenWorldPresetTags(List<String> worldgenWorldPresetTags) {
        this.worldgenWorldPresetTags = worldgenWorldPresetTags;
    }
} 