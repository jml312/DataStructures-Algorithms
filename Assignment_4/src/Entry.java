/** A class for Entries in the HashTable */
public class Entry {

    /** The word that the Entry contains */
    private final String word;

    /** The frequency of the Entry */
    private int frequency;

    /** The next Entry (The Entry's next chain link) */
    private Entry next;

    /** Sets the word and frequency for an Entry and sets the next Entry to null
     * @param word The word in the Entry
     * @param frequency the frequency of the Entry */
    public Entry(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
        this.next = null;
    }

    /** Returns the word for the Entry
     * @return The word of the Entry */
    public String getWord() {
        return word;
    }

    /** Returns frequency of an Entry
     * @return The frequency of an Entry */
    public int getFrequency() {
        return frequency;
    }

    /** Sets the frequency of an Entry
     * @param frequency The frequency of an Entry  */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /** Returns an Entry's next Entry
     * @return An Entry's next Entry */
    public Entry getNext() {
        return next;
    }

    /** Sets the next Entry of an Entry
     * @param next The next Entry of an Entry */
    public void setNext(Entry next) {
        this.next = next;
    }

    /** Returns String representation of an Entry with the first letter capitalized
     * @return A String representation of an Entry */
    @Override
    public String toString() {
        return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase() + ": " + frequency;
    }
}