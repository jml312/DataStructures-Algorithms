/** A class for Entries in the HashTable */
public class Entry {

    /** The character that the Entry contains */
    private final char character;

    /** The frequency of the Entry */
    private int frequency;

    /** The next Entry (The Entry's next chain link) */
    private Entry next;

    /** Sets the word and frequency for an Entry and sets the next Entry to null
     * @param character The character in the Entry
     * @param frequency the frequency of the Entry */
    public Entry(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.next = null;
    }

    /** Returns the character for the Entry
     * @return The character of the Entry */
    public char getCharacter() { return character; }

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
}