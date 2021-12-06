package be.johannesroeder.challenge;

import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    @Test
    void makeListFromInput() {
        List<String> compareAgainst = Arrays.asList(new String[]{"hallo", "ich", "heisse", "johannes"});
        assertEquals(compareAgainst, InputReader.makeListFromInput(new StringReader("hallo\nich\nheisse\njohannes")));
    }
}