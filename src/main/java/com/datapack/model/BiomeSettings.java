package com.datapack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BiomeSettings {
    private float temperature;
    private float downfall;
    private boolean hasPrecipitation;
    private String temperatureModifier;
    private float creatureSpawnProbability;
    
    // Effects
    private String skyColor;
    private String fogColor;
    private String waterColor;
    private String waterFogColor;
    private String grassColor;
    private String foliageColor;
    private String grassColorModifier;
    private String ambientSound;
    private String moodSound;
    private String additionsSound;
    private String music;
    private float musicVolume;
    private String particle;
    
    // Spawners
    private String spawnerSettings;

    // Getters and setters
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getDownfall() {
        return downfall;
    }

    public void setDownfall(float downfall) {
        this.downfall = downfall;
    }

    @JsonProperty("has_precipitation")
    public boolean isHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    @JsonProperty("temperature_modifier")
    public String getTemperatureModifier() {
        return temperatureModifier;
    }

    public void setTemperatureModifier(String temperatureModifier) {
        this.temperatureModifier = temperatureModifier;
    }

    @JsonProperty("creature_spawn_probability")
    public float getCreatureSpawnProbability() {
        return creatureSpawnProbability;
    }

    public void setCreatureSpawnProbability(float creatureSpawnProbability) {
        this.creatureSpawnProbability = creatureSpawnProbability;
    }

    @JsonProperty("sky_color")
    public String getSkyColor() {
        return skyColor;
    }

    public void setSkyColor(String skyColor) {
        this.skyColor = skyColor;
    }

    @JsonProperty("fog_color")
    public String getFogColor() {
        return fogColor;
    }

    public void setFogColor(String fogColor) {
        this.fogColor = fogColor;
    }

    @JsonProperty("water_color")
    public String getWaterColor() {
        return waterColor;
    }

    public void setWaterColor(String waterColor) {
        this.waterColor = waterColor;
    }

    @JsonProperty("water_fog_color")
    public String getWaterFogColor() {
        return waterFogColor;
    }

    public void setWaterFogColor(String waterFogColor) {
        this.waterFogColor = waterFogColor;
    }

    @JsonProperty("grass_color")
    public String getGrassColor() {
        return grassColor;
    }

    public void setGrassColor(String grassColor) {
        this.grassColor = grassColor;
    }

    @JsonProperty("foliage_color")
    public String getFoliageColor() {
        return foliageColor;
    }

    public void setFoliageColor(String foliageColor) {
        this.foliageColor = foliageColor;
    }

    @JsonProperty("grass_color_modifier")
    public String getGrassColorModifier() {
        return grassColorModifier;
    }

    public void setGrassColorModifier(String grassColorModifier) {
        this.grassColorModifier = grassColorModifier;
    }

    @JsonProperty("ambient_sound")
    public String getAmbientSound() {
        return ambientSound;
    }

    public void setAmbientSound(String ambientSound) {
        this.ambientSound = ambientSound;
    }

    @JsonProperty("mood_sound")
    public String getMoodSound() {
        return moodSound;
    }

    public void setMoodSound(String moodSound) {
        this.moodSound = moodSound;
    }

    @JsonProperty("additions_sound")
    public String getAdditionsSound() {
        return additionsSound;
    }

    public void setAdditionsSound(String additionsSound) {
        this.additionsSound = additionsSound;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    @JsonProperty("music_volume")
    public float getMusicVolume() {
        return musicVolume;
    }

    public void setMusicVolume(float musicVolume) {
        this.musicVolume = musicVolume;
    }

    public String getParticle() {
        return particle;
    }

    public void setParticle(String particle) {
        this.particle = particle;
    }

    @JsonProperty("spawner_settings")
    public String getSpawnerSettings() {
        return spawnerSettings;
    }

    public void setSpawnerSettings(String spawnerSettings) {
        this.spawnerSettings = spawnerSettings;
    }
} 