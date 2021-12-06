package be.johannesroeder.challenge;

import picocli.CommandLine;

import java.io.*;
import java.util.HashSet;

@CommandLine.Command(
        name = "challenge"
)
public class Challenge implements Runnable {

    private ListFilter listFilter;

    @CommandLine.Option(names = {"-i", "-input"}, required = true)
    private String input;
    @CommandLine.Option(names = {"-o", "-output"}, required = true)
    private String output;

    public Challenge() {
        this.listFilter = new ListFilter();
    }

    public HashSet<String> getAssembledAndComparedFrom(String inputFile) throws FileNotFoundException {
        listFilter.setLists(InputReader.makeListFromInput(new FileReader(inputFile)));
        HashSet<String> assembledStrings = new HashSet<>();

        for (int i = 0; i < listFilter.getNonSixLetterWords().size(); i++) {
            String currentString = listFilter.getNonSixLetterWords().get(i);
            for (int j = 0; j < listFilter.getNonSixLetterWords().size(); ) {
                if (i == j) {
                    j++;
                    continue;
                }
                String assembledString = currentString + listFilter.getNonSixLetterWords().get(j);
                if (assembledString.length() == 6 && listFilter.getSixLetterWords().contains(assembledString)) {
                    assembledStrings.add(assembledString);
                }
                j++;
            }
        }

        return assembledStrings;
    }

    public void writeToFile(String input, String output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        for (String str : getAssembledAndComparedFrom(input)) {
            writer.append(str);
            writer.newLine();
        }
        writer.close();
    }

    public static void main(String[] args) {
        CommandLine.run(new Challenge(), args);
    }

    @Override
    public void run() {
        try {
            writeToFile(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
