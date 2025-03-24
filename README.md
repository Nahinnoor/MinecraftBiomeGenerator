# Minecraft Data Pack Generator

A Java-based tool for generating Minecraft data packs. This tool allows you to create, modify, and save data packs in JSON format, making it easier to create custom Minecraft data packs programmatically.

## Features

- Generate data packs with custom pack format and description
- Add various types of tags (blocks, items, entities, etc.)
- Add recipes, advancements, loot tables, functions, structures, and worldgen
- Save data packs to JSON files
- Load existing data packs from JSON files
- Easy to extend with new features

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/datapack-generator.git
```

2. Navigate to the project directory:
```bash
cd datapack-generator
```

3. Build the project:
```bash
mvn clean install
```

## Usage

### Basic Usage

```java
// Create a new DataPackGenerator instance
DataPackGenerator generator = new DataPackGenerator();

// Generate a new data pack
DataPack dataPack = generator.generateDataPack("15", "My Custom Data Pack");

// Add tags
generator.addTag(dataPack, "block", "minecraft:stone");
generator.addTag(dataPack, "item", "minecraft:diamond");

// Add recipes
generator.addRecipe(dataPack, "minecraft:crafting_table");

// Save the data pack
generator.saveDataPack(dataPack, "output/datapack.json");
```

### Running the Example

The project includes a `Main` class with example usage. To run it:

```bash
mvn exec:java -Dexec.mainClass="com.datapack.Main"
```

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── datapack/
│               ├── Main.java
│               ├── model/
│               │   └── DataPack.java
│               └── service/
│                   └── DataPackGenerator.java
└── test/
    └── java/
        └── com/
            └── datapack/
                └── service/
                    └── DataPackGeneratorTest.java
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Inspired by [Misode's Data Pack Generator](https://github.com/misode/misode.github.io)
- Uses Jackson for JSON processing 