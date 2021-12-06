package be.johannesroeder.challenge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ListFilterTest {
    private ListFilter listFilter;

    @BeforeAll
    public void setListFilter() {
        this.listFilter = new ListFilter();
        listFilter.setLists(Arrays.asList(new String[]{"kar", "te", "brav", "e", "l", "amp", "frog", "frowns", "pearls"}));
        System.out.println("Test running");
    }

    @Test
    void setLists() {
        assertFalse(listFilter.getSixLetterWords().isEmpty(), "no six letter words in list");
        assertFalse(listFilter.getNonSixLetterWords().isEmpty(), "no non six letter words in list");
    }

    @Test
    void getSixLetterWords() {
        assertEquals(2, listFilter.getSixLetterWords().size());
    }

    @Test
    void getNonSixLetterWords() {
        assertEquals(7, listFilter.getNonSixLetterWords().size());
    }
}