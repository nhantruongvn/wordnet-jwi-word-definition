# Generate Wordnet Definition

This is a Java program that reads a file containing words and their part-of-speech (POS) numbers, and writes another file containing the words and their definitions from Wordnet.

## Requirements

- Java 8 or higher
- Wordnet 3.0 or higher
- JWI (MIT Java Wordnet Interface) library

## Usage

- Download or clone this repository
- Download Wordnet 3.0 and extract it to the `src/resources/wordnet` folder
- Download JWI library (`edu.mit.jwi_2.4.0_jdk.jar`) and add it to the classpath
- Compile and run the `GenerateWordnetDefinition` class
- The input file should be in the format of `word_POS-number`, one per line. For example:

```
apple_1
deploy_2
cat_1
elegant_3
```

- The output file will be in the format of `word\tdefinition`, one per line. For example:

```
apple	fruit with red or yellow or green skin and sweet to tart crisp whitish flesh
deploy	to distribute systematically or strategically; "The U.S. deploys its weapons in the Middle East"
cat	feline mammal usually having thick soft fur and no ability to roar: domestic cats; wildcats
elegant	displaying effortless beauty and simplicity in movement or execution; "an elegant dancer"; "an elegant mathematical solution -- simple and precise"
```

## License

This project is licensed under the MIT License.