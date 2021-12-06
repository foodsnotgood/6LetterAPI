package be.johannesroeder.challenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListFilter {
    private List<String> sixLetterWords;
    private List<String> nonSixLetterWords;

    public ListFilter() {
        this.nonSixLetterWords = new ArrayList<>();
        this.sixLetterWords = new ArrayList<>();
    }

    public void setLists(List<String> listToFilter) {
        Iterator<String> it = listToFilter.iterator();
        while (it.hasNext()) {
            String nextLine = it.next();
            if (nextLine.length() == 6) {
                this.sixLetterWords.add(nextLine);
            } else if (nextLine.length() < 6) {
                this.nonSixLetterWords.add(nextLine);
            }
        }
    }

    public List<String> getSixLetterWords() {
        return sixLetterWords;
    }

    public List<String> getNonSixLetterWords() {
        return nonSixLetterWords;
    }
}
