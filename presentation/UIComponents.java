package cs.project.biomegenerator.presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class UIComponents {
    protected JFrame mainFrame;
    protected JSpinner biomeTemperatureSpinner;
    protected JPanel paramPanel;
    protected JSpinner biomeDownFallSpinner;
    protected JCheckBox biomePrecipitationCheckbox;
    protected JSpinner CreatureSpawnProbabilitySpinner;
    protected JPanel biomeEffectsPanel;
    protected JSpinner skyColorSpinner;
    protected JSpinner fogColorSpinner;
    protected JSpinner waterColorSpinner;
    protected JSpinner waterFogColorSpinner;
    protected JSpinner grassColorSpinner;
    protected JSpinner foliageColorSpinner;
    protected JPanel spawnerPanel;
    protected JComboBox MonsterTypeComboBox;
    protected JPanel temperaturePanel;
    protected JPanel downfallPanel;
    protected JPanel precipitationPanel;
    protected JPanel creatureSpawnPanel;
    protected JPanel carversPanel;
    protected JSpinner monsterWeightSpinner;
    protected JSpinner monsterMinCountSpinner;
    protected JSpinner monsterMaxCountSpinner;
    protected JPanel creatureSpawnCostPanel;
    protected JSpinner energyCostSpinner;
    protected JSpinner ChargeCostSpinner;
    protected JComboBox carversComboBox;
    private JButton saveButton;


    public UIComponents() {
        createUIComponents();
        createTitle();
        createParameters();
        createSaveButton();
    }

    protected void createUIComponents() {
        mainFrame = new JFrame("Minecraft Biome Generator");
        biomeTemperatureSpinner = new JSpinner(new SpinnerNumberModel(0.0, -1.0, 2.0, 0.1));
        paramPanel = new JPanel();
        paramPanel.setLayout(new BoxLayout(paramPanel, BoxLayout.Y_AXIS));
        biomeDownFallSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
        biomePrecipitationCheckbox = new JCheckBox();
        CreatureSpawnProbabilitySpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));

        biomeEffectsPanel = new JPanel();
        biomeEffectsPanel.setLayout(new BoxLayout(biomeEffectsPanel, BoxLayout.Y_AXIS));
        skyColorSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 16777215, 1));
        fogColorSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 16777215, 1));
        waterColorSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 16777215, 1));
        waterFogColorSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 16777215, 1));
        grassColorSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 16777215, 1));
        foliageColorSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 16777215, 1));


        /* Add option to select spawner on/off */
        spawnerPanel = new JPanel();
        spawnerPanel.setLayout(new BoxLayout(spawnerPanel, BoxLayout.Y_AXIS));
        MonsterTypeComboBox = new JComboBox<>(new String[]{
                "null",
                "minecraft:cave_spider",
                "minecraft:creeper",
                "minecraft:drowned",
                "minecraft:elder_guardian",
                "minecraft:enderman",
                "minecraft:evoker",
                "minecraft:guardian",
                "minecraft:husk",
                "minecraft:phantom",
                "minecraft:pillager",
                "minecraft:ravager",
                "minecraft:skeleton",
                "minecraft:slime",
                "minecraft:spider",
                "minecraft:stray",
                "minecraft:vex",
                "minecraft:vindicator",
                "minecraft:witch",
                "minecraft:zombie",
                "minecraft:zombie_villager"
        });

        monsterWeightSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        monsterMinCountSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        monsterMaxCountSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

        creatureSpawnCostPanel = new JPanel();
        creatureSpawnCostPanel.setLayout(new BoxLayout(creatureSpawnCostPanel, BoxLayout.Y_AXIS));
        energyCostSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
        ChargeCostSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));

        carversComboBox = new JComboBox<>(new String[]{
                "null",
                "minecraft:canyon",
                "minecraft:cave",
                "minecraft:cave_extra_underground",
                "minecraft:neither_cave"
        });

        saveButton = new JButton("Save Config");
    }
    protected void createTitle() {
        JLabel titleLabel = new JLabel("Minecraft Biome Generator");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        mainFrame.add(titleLabel, BorderLayout.NORTH);
    }

    private void createParameters() {
        createTemperaturePanel();
        createDownfallPanel();
        createPrecipitationPanel();
        createCreatureSpawnPanel();
        createBiomeEffectsPanel();
        createSpawnerPanel();
        createSpawnerCostPanel();
        createCarversPanel();
        createSaveButton();

        // Panel Setup for parameters
        paramPanel.add(temperaturePanel);
        paramPanel.add(Box.createVerticalStrut(3));
        paramPanel.add(downfallPanel);
        paramPanel.add(Box.createVerticalStrut(3));
        paramPanel.add(precipitationPanel);
        paramPanel.add(Box.createVerticalStrut(3));
        paramPanel.add(creatureSpawnPanel);
        paramPanel.add(Box.createVerticalStrut(3));
        paramPanel.add(biomeEffectsPanel);
        paramPanel.add(Box.createVerticalStrut(3));
        paramPanel.add(spawnerPanel);
        paramPanel.add(Box.createVerticalStrut(3));
        paramPanel.add(creatureSpawnCostPanel);
        paramPanel.add(Box.createVerticalStrut(3));
        paramPanel.add(carversPanel);
        paramPanel.add(Box.createVerticalStrut(3));
        paramPanel.add(saveButton);


        // Add Panel to the main frame
        mainFrame.add(paramPanel, BorderLayout.WEST);
    }

    private void createTemperaturePanel() {
        JPanel temperaturePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel biomeTemperature = new JLabel("Biome Temperature:");
        temperaturePanel.add(biomeTemperature);
        temperaturePanel.add(biomeTemperatureSpinner);
        this.temperaturePanel = temperaturePanel;
    }

    private void createDownfallPanel() {
        JPanel downfallPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel biomeDownfall = new JLabel("Biome Downfall:");
        downfallPanel.add(biomeDownfall);
        downfallPanel.add(biomeDownFallSpinner);
        this.downfallPanel = downfallPanel;
    }

    private void createPrecipitationPanel() {
        JPanel precipitationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel biomePrecipitation = new JLabel("Biome Precipitation:");
        precipitationPanel.add(biomePrecipitation);
        precipitationPanel.add(biomePrecipitationCheckbox);
        this.precipitationPanel = precipitationPanel;
    }

    private void createCreatureSpawnPanel() {
        JPanel creatureSpawnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel creatureSpawnProbability = new JLabel("Creature Spawn Probability:");
        creatureSpawnPanel.add(creatureSpawnProbability);
        creatureSpawnPanel.add(CreatureSpawnProbabilitySpinner);
        this.creatureSpawnPanel = creatureSpawnPanel;
    }

    private void createBiomeEffectsPanel() {
        // Biome Effects Label
        JLabel biomeEffects = new JLabel("Biome Effects:", SwingConstants.LEFT);
        biomeEffectsPanel.add(biomeEffects);
        
        // Create all color panels
        JPanel skyColorPanel = createColorPanel("Sky Color:", skyColorSpinner);
        JPanel fogColorPanel = createColorPanel("Fog Color:", fogColorSpinner);
        JPanel waterColorPanel = createColorPanel("Water Color:", waterColorSpinner);
        JPanel waterFogColorPanel = createColorPanel("Water Fog Color:", waterFogColorSpinner);
        JPanel grassColorPanel = createColorPanel("Grass Color:", grassColorSpinner);
        JPanel foliageColorPanel = createColorPanel("Foliage Color:", foliageColorSpinner);

        // Add sub-parameters to the biome effects panel
        biomeEffectsPanel.add(skyColorPanel);
        biomeEffectsPanel.add(Box.createVerticalStrut(3));
        biomeEffectsPanel.add(fogColorPanel);
        biomeEffectsPanel.add(Box.createVerticalStrut(3));
        biomeEffectsPanel.add(waterColorPanel);
        biomeEffectsPanel.add(Box.createVerticalStrut(3));
        biomeEffectsPanel.add(waterFogColorPanel);
        biomeEffectsPanel.add(Box.createVerticalStrut(3));
        biomeEffectsPanel.add(grassColorPanel);
        biomeEffectsPanel.add(Box.createVerticalStrut(3));
        biomeEffectsPanel.add(foliageColorPanel);
        biomeEffectsPanel.add(Box.createVerticalStrut(3));
    }

    private JPanel createColorPanel(String labelText, JSpinner spinner) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(spinner);
        return panel;
    }

    private void createSpawnerPanel() {
        // Spawner Panel Label
        JLabel spawnerPanelLabel = new JLabel("Monster Spawner:");
        spawnerPanel.add(spawnerPanelLabel);

        // Monster Type Panel
        JPanel monsterTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel monsterType = new JLabel("Monster Type:");
        monsterTypePanel.add(monsterType);
        monsterTypePanel.add(MonsterTypeComboBox);

        // Monster Weight Panel
        JPanel MonsterWeightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel monsterWeight = new JLabel("Monster Weight:");
        MonsterWeightPanel.add(monsterWeight);
        MonsterWeightPanel.add(monsterWeightSpinner);

        //Monster minCount panel
        JPanel MonsterMinCountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel monsterMinCount = new JLabel("Minimum Count:");
        MonsterMinCountPanel.add(monsterMinCount);
        MonsterMinCountPanel.add(monsterMinCountSpinner);

        //Monster maxCount panel
        JPanel MonsterMaxCountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel monsterMaxCount = new JLabel("Maximum Count:");
        MonsterMaxCountPanel.add(monsterMaxCount);
        MonsterMaxCountPanel.add(monsterMaxCountSpinner);


        // Add sub-parameters to the spawner panel
        spawnerPanel.add(monsterTypePanel);
        spawnerPanel.add(Box.createVerticalStrut(3));
        spawnerPanel.add(MonsterWeightPanel);
        spawnerPanel.add(Box.createVerticalStrut(3));
        spawnerPanel.add(MonsterMinCountPanel);
        spawnerPanel.add(Box.createVerticalStrut(3));
        spawnerPanel.add(MonsterMaxCountPanel);


    }

    private void createSpawnerCostPanel() {
        // Spawner Cost Panel Label
        JLabel spawnerCostPanelLabel = new JLabel("Monster Spawner Cost:");
        creatureSpawnCostPanel.add(spawnerCostPanelLabel);

        // Monster Type
        JPanel monsterTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel monsterType = new JLabel("Monster Type:");
        creatureSpawnPanel.add(monsterType);
        creatureSpawnPanel.add(MonsterTypeComboBox);

        // Monster Cost Panel
        JPanel MonsterCostPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel monsterCost = new JLabel("Energy Cost:");
        MonsterCostPanel.add(monsterCost);
        MonsterCostPanel.add(energyCostSpinner);

        // Monster Charge Panel
        JPanel MonsterChargePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel monsterCharge = new JLabel("Charge:");
        MonsterChargePanel.add(monsterCharge);
        MonsterChargePanel.add(ChargeCostSpinner);

        // Add sub-parameters to the spawner cost panel
        creatureSpawnCostPanel.add(monsterTypePanel);
        creatureSpawnCostPanel.add(Box.createVerticalStrut(3));
        creatureSpawnCostPanel.add(MonsterCostPanel);
        creatureSpawnCostPanel.add(Box.createVerticalStrut(3));
        creatureSpawnCostPanel.add(MonsterChargePanel);



    }

    private void createCarversPanel() {
        JPanel carversPanel = new JPanel(new FlowLayout((FlowLayout.LEFT)));
        JLabel carverLabel = new JLabel("Carver:");
        carversPanel.add(carverLabel);
        carversPanel.add(carversComboBox);
        this.carversPanel = carversPanel;
    }

    private void createSaveButton() {
        saveButton = new JButton("Save");
        saveButton.addActionListener(this::saveButtonClicked);
    }

    private void saveButtonClicked(ActionEvent actionEvent) {
        // Implement saving logic here
        System.out.println("Saving biome configuration...");
    }

}
