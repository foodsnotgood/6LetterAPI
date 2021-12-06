package be.johannesroeder.challenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ChallengeTest {

    @Test
    void getAssembledAndComparedFrom() throws Exception {
        Challenge challenge = new Challenge();
        assertThrows(FileNotFoundException.class, (Executable) challenge.getAssembledAndComparedFrom(""));
    }

    @Test
    void writeToFile() {
    }
}