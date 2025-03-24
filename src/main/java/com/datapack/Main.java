package com.datapack;

import java.io.IOException;

import com.datapack.model.DataPack;
import com.datapack.service.DataPackGenerator;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a new DataPackGenerator instance
            DataPackGenerator generator = new DataPackGenerator();

            // Generate a new data pack
            DataPack dataPack = generator.generateDataPack("15", "My Custom Data Pack");

            // Add some example tags
            generator.addTag(dataPack, "block", "minecraft:stone");
            generator.addTag(dataPack, "item", "minecraft:diamond");
            generator.addTag(dataPack, "entity", "minecraft:zombie");

            // Add some example recipes
            generator.addRecipe(dataPack, "minecraft:crafting_table");
            generator.addRecipe(dataPack, "minecraft:furnace");

            // Add some example advancements
            generator.addAdvancement(dataPack, "minecraft:story/root");
            generator.addAdvancement(dataPack, "minecraft:story/mine_diamond");

            // Add some example loot tables
            generator.addLootTable(dataPack, "minecraft:chests/simple_dungeon");
            generator.addLootTable(dataPack, "minecraft:chests/abandoned_mineshaft");

            // Add some example functions
            generator.addFunction(dataPack, "minecraft:load");
            generator.addFunction(dataPack, "minecraft:tick");

            // Add some example structures
            generator.addStructure(dataPack, "minecraft:stronghold");
            generator.addStructure(dataPack, "minecraft:mansion");

            // Add some example worldgen
            generator.addWorldgen(dataPack, "minecraft:overworld");
            generator.addWorldgen(dataPack, "minecraft:nether");

            // Save the data pack to a file
            generator.saveDataPack(dataPack, "output/datapack.json");

            System.out.println("Data pack generated successfully!");

            // Load the data pack back from the file
            DataPack loadedDataPack = generator.loadDataPack("output/datapack.json");
            System.out.println("Data pack loaded successfully!");

        } catch (IOException e) {
            System.err.println("Error generating data pack: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 