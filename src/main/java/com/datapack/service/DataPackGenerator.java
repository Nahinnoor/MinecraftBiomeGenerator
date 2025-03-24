package com.datapack.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.datapack.model.BiomeSettings;
import com.datapack.model.DataPack;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class DataPackGenerator {
    private final ObjectMapper objectMapper;

    public DataPackGenerator() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public DataPack generateDataPack(String packFormat, String description) {
        DataPack dataPack = new DataPack();
        dataPack.setPackFormat(packFormat);
        dataPack.setDescription(description);
        dataPack.setBiomeSettings(new HashMap<>());
        
        // Initialize empty lists for all tag types
        dataPack.setTags(new ArrayList<>());
        dataPack.setRecipes(new ArrayList<>());
        dataPack.setAdvancements(new ArrayList<>());
        dataPack.setLootTables(new ArrayList<>());
        dataPack.setFunctions(new ArrayList<>());
        dataPack.setStructures(new ArrayList<>());
        dataPack.setWorldgen(new ArrayList<>());
        dataPack.setDimensions(new ArrayList<>());
        dataPack.setDimensionTypes(new ArrayList<>());
        dataPack.setBiomes(new ArrayList<>());
        dataPack.setBlockStates(new ArrayList<>());
        dataPack.setBlockTags(new ArrayList<>());
        dataPack.setItemTags(new ArrayList<>());
        dataPack.setEntityTypeTags(new ArrayList<>());
        dataPack.setFluidTags(new ArrayList<>());
        dataPack.setGameEventTags(new ArrayList<>());
        dataPack.setDamageTypeTags(new ArrayList<>());
        dataPack.setCatVariantTags(new ArrayList<>());
        dataPack.setWolfVariantTags(new ArrayList<>());
        dataPack.setFrogVariantTags(new ArrayList<>());
        dataPack.setPaintingVariantTags(new ArrayList<>());
        dataPack.setVillagerProfessionTags(new ArrayList<>());
        dataPack.setVillagerTypeTags(new ArrayList<>());
        dataPack.setWorldPresetTags(new ArrayList<>());
        dataPack.setTrimMaterialTags(new ArrayList<>());
        dataPack.setTrimPatternTags(new ArrayList<>());
        dataPack.setInstrumentTags(new ArrayList<>());
        dataPack.setStructureSetTags(new ArrayList<>());
        dataPack.setWorldgenTags(new ArrayList<>());
        dataPack.setBiomeTags(new ArrayList<>());
        dataPack.setFlatLevelGeneratorPresetTags(new ArrayList<>());
        dataPack.setMultiNoiseBiomeSourceParameterTags(new ArrayList<>());
        dataPack.setNoiseSettingsTags(new ArrayList<>());
        dataPack.setPlacedFeatureTags(new ArrayList<>());
        dataPack.setProcessorListTags(new ArrayList<>());
        dataPack.setStructureTags(new ArrayList<>());
        dataPack.setStructureProcessorTags(new ArrayList<>());
        dataPack.setTemplatePoolTags(new ArrayList<>());
        dataPack.setWorldgenBiomeTags(new ArrayList<>());
        dataPack.setWorldgenDensityFunctionTags(new ArrayList<>());
        dataPack.setWorldgenNoiseSettingsTags(new ArrayList<>());
        dataPack.setWorldgenPlacedFeatureTags(new ArrayList<>());
        dataPack.setWorldgenStructureTags(new ArrayList<>());
        dataPack.setWorldgenStructureSetTags(new ArrayList<>());
        dataPack.setWorldgenTemplatePoolTags(new ArrayList<>());
        dataPack.setWorldgenWorldPresetTags(new ArrayList<>());

        return dataPack;
    }

    public void saveDataPack(DataPack dataPack, String outputPath) throws IOException {
        // Create output directory if it doesn't exist
        File outputDir = new File("output");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        
        objectMapper.writeValue(new File(outputPath), dataPack);
    }

    public DataPack loadDataPack(String inputPath) throws IOException {
        return objectMapper.readValue(new File(inputPath), DataPack.class);
    }

    public void addBiomeSettings(DataPack dataPack, String biomeName, BiomeSettings settings) {
        Map<String, BiomeSettings> biomeSettings = dataPack.getBiomeSettings();
        if (biomeSettings == null) {
            biomeSettings = new HashMap<>();
            dataPack.setBiomeSettings(biomeSettings);
        }
        biomeSettings.put(biomeName, settings);
    }

    public void addTag(DataPack dataPack, String tagType, String tagValue) {
        switch (tagType.toLowerCase()) {
            case "block":
                dataPack.getBlockTags().add(tagValue);
                break;
            case "item":
                dataPack.getItemTags().add(tagValue);
                break;
            case "entity":
                dataPack.getEntityTypeTags().add(tagValue);
                break;
            case "fluid":
                dataPack.getFluidTags().add(tagValue);
                break;
            case "biome":
                dataPack.getBiomeTags().add(tagValue);
                break;
            // Add more cases as needed
        }
    }

    public void addRecipe(DataPack dataPack, String recipePath) {
        dataPack.getRecipes().add(recipePath);
    }

    public void addAdvancement(DataPack dataPack, String advancementPath) {
        dataPack.getAdvancements().add(advancementPath);
    }

    public void addLootTable(DataPack dataPack, String lootTablePath) {
        dataPack.getLootTables().add(lootTablePath);
    }

    public void addFunction(DataPack dataPack, String functionPath) {
        dataPack.getFunctions().add(functionPath);
    }

    public void addStructure(DataPack dataPack, String structurePath) {
        dataPack.getStructures().add(structurePath);
    }

    public void addWorldgen(DataPack dataPack, String worldgenPath) {
        dataPack.getWorldgen().add(worldgenPath);
    }
} 