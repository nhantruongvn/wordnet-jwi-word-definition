import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class GenerateWordnetDefinition {
    // Use constants for file paths
    private static final String DICTIONARY_PATH = "./src/resources/wordnet";
    private static final String INPUT_FILE = "./src/resources/sample_wordlist_with_POS.txt";
    private static final String OUTPUT_FILE = "./src/resources/sample_wordlist_with_definitions_and_examples.txt";

    public static void main(String[] args) throws IOException {
        // Construct the dictionary object and open it
        IDictionary dict = new Dictionary(new URL("file", null, DICTIONARY_PATH));
        dict.open();

        // Create output file
        FileWriter fileWriter = new FileWriter(OUTPUT_FILE);

        // Read input file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
        String line = bufferedReader.readLine();

        while (line != null) {
            // Split each line into word and POS-number
            String[] parts = line.split("_");
            String word = parts[0];
            int pos = Integer.parseInt(parts[1]);

            // Write keyword-definition pairs in output file
            writeDefinitions(dict, fileWriter, word, pos);

            line = bufferedReader.readLine();
        }

        // Close the resources
        bufferedReader.close();
        fileWriter.close();
    }

    // Write definitions for a given word
    private static void writeDefinitions(IDictionary dict, FileWriter fileWriter, String word, int pos) throws IOException {
        // Get all senses of a word
        IIndexWord iIndexWord = dict.getIndexWord(word, POS.getPartOfSpeech(pos));
        if (iIndexWord == null) {
            fileWriter.write(word + "\n");
            return;
        }
        List<IWordID> iWordIdList = iIndexWord.getWordIDs();

        // Write keyword-definition pairs and example sentences in output file
        for (IWordID iWordId : iWordIdList) {
            String keyword = dict.getWord(iWordId).getLemma();
            String definition = dict.getWord(iWordId).getSynset().getGloss();
            fileWriter.write(keyword + "\t" + definition + "\n");
        }
    }
}