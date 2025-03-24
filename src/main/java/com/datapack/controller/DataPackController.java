package com.datapack.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datapack.model.BiomeSettings;
import com.datapack.model.DataPack;
import com.datapack.service.DataPackGenerator;

@Controller
public class DataPackController {

    @Autowired
    private DataPackGenerator dataPackGenerator;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @PostMapping("/generate")
    @ResponseBody
    public ResponseEntity<?> generateDataPack(@RequestBody Map<String, Object> request) {
        try {
            String packFormat = (String) request.get("packFormat");
            String description = (String) request.get("description");
            
            DataPack dataPack = dataPackGenerator.generateDataPack(packFormat, description);
            
            // Handle biome settings
            if (request.containsKey("biomeSettings")) {
                @SuppressWarnings("unchecked")
                Map<String, Map<String, Object>> biomeSettingsMap = (Map<String, Map<String, Object>>) request.get("biomeSettings");
                
                for (Map.Entry<String, Map<String, Object>> entry : biomeSettingsMap.entrySet()) {
                    String biomeName = entry.getKey();
                    Map<String, Object> settings = entry.getValue();
                    
                    BiomeSettings biomeSettings = new BiomeSettings();
                    biomeSettings.setTemperature(((Number) settings.get("temperature")).floatValue());
                    biomeSettings.setDownfall(((Number) settings.get("downfall")).floatValue());
                    biomeSettings.setHasPrecipitation((Boolean) settings.get("hasPrecipitation"));
                    biomeSettings.setTemperatureModifier((String) settings.get("temperatureModifier"));
                    biomeSettings.setCreatureSpawnProbability(((Number) settings.get("creatureSpawnProbability")).floatValue());
                    biomeSettings.setSkyColor((String) settings.get("skyColor"));
                    biomeSettings.setFogColor((String) settings.get("fogColor"));
                    biomeSettings.setWaterColor((String) settings.get("waterColor"));
                    biomeSettings.setWaterFogColor((String) settings.get("waterFogColor"));
                    biomeSettings.setGrassColor((String) settings.get("grassColor"));
                    biomeSettings.setFoliageColor((String) settings.get("foliageColor"));
                    biomeSettings.setGrassColorModifier((String) settings.get("grassColorModifier"));
                    biomeSettings.setAmbientSound((String) settings.get("ambientSound"));
                    biomeSettings.setMoodSound((String) settings.get("moodSound"));
                    biomeSettings.setAdditionsSound((String) settings.get("additionsSound"));
                    biomeSettings.setMusic((String) settings.get("music"));
                    if (settings.get("musicVolume") != null) {
                        biomeSettings.setMusicVolume(((Number) settings.get("musicVolume")).floatValue());
                    }
                    biomeSettings.setParticle((String) settings.get("particle"));
                    
                    dataPackGenerator.addBiomeSettings(dataPack, biomeName, biomeSettings);
                }
            }
            
            // Save to file
            dataPackGenerator.saveDataPack(dataPack, "output/datapack.json");
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Data pack generated successfully");
            response.put("dataPack", dataPack);
            
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error generating data pack: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/download")
    public ResponseEntity<?> downloadDataPack() {
        try {
            DataPack dataPack = dataPackGenerator.loadDataPack("output/datapack.json");
            return ResponseEntity.ok(dataPack);
        } catch (IOException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error loading data pack: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
} 