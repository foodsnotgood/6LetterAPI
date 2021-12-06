package be.johannesroeder.challenge;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    public static List<String> makeListFromInput(Reader reader) {
        List<String> listOfStrings;
        BufferedReader bufferedReader = new BufferedReader(reader);
        listOfStrings = bufferedReader.lines().collect(Collectors.toList());
        return listOfStrings;
    }

}