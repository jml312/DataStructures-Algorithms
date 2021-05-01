/** A class to implement a HashTable used to get compare two strings for if they are anagrams */
public class HashTable {

    /** An array of Entries representing the HashTable  */
    private Entry[] table;

    /** The number of items in the HashTable  */
    private int numItems;

    /** The size of the HashTable  */
    private int tableSize;

    /** The load factor of the HashTable  */
    private double loadFactor;

    /** Sets the size of the Hashtable
     * @param size The size of the HashTable */
    public HashTable(int size) {
        tableSize = size;
        table = new Entry[tableSize];
        numItems = 0;
        loadFactor = 0;
    }

    /** Checks if two strings are anagrams
     * @param X The first string to check
     * @param Y The second string to check
     * @return Returns true or false if the strings are anagrams or not */
    public static boolean isAnagram(String X, String Y) {
        // removes spaces and makes the strings lower case
        X = X.toLowerCase().replaceAll("\\s", "");
        Y = Y.toLowerCase().replaceAll("\\s", "");

        if (X.length() != Y.length()) return false;

        HashTable hashTable = new HashTable(1);

        // adds characters of X to the hashtable with the correct frequency
        for (char c : X.toCharArray()) hashTable.insert(c, hashTable.getFrequency(c) + 1);

        for (char c : Y.toCharArray()) {
            int frequency = hashTable.getFrequency(c);
            if (frequency == 0) return false;
            hashTable.insert(c, frequency - 1);
            if (frequency - 1 == 0) hashTable.remove(c); // removes the character from the hash table if its frequency is 0
        }
        return hashTable.numItems <= 0; // Checks if the hashtable is empty
    }

    /** Inserts a character with a given frequency into the hash table
     * @param c The character to be inserted
     * @param frequency The frequency of the character */
    public void insert(char c, int frequency) {
        // creates a hashed index from the word
        int hashIndex = hash(c);
        // if the hashed index is null, a new Entry is added to that index
        // the numbers of items and load factor are updated
        if (table[hashIndex] == null) {
            table[hashIndex] = new Entry(c, frequency);
            loadFactor = (double) ++numItems / tableSize;
        }
        // if the hashed index is not null
        else {
            Entry entry = table[hashIndex];
            // loops through each chained Entry at the index while the next Entry is not null and the current Entry's character is not equal to the input character
            while(entry.getNext() != null && entry.getCharacter() != c) entry = entry.getNext();
            // if the Entry's character is equal to the input character, the Entry's frequency is incremented
            if (entry.getCharacter() == c) entry.setFrequency(frequency);
            // the Entry's next Entry is set to the new Entry
            else entry.setNext(new Entry(c, frequency));
        }
        // checks if a rehashing of the table is necessary
        if (loadFactor > 0.8) rehashTable();
    }

    /** Removes a character from the hash table
     * @param c The character to remove */
    public void remove(char c) {
        Entry entry = table[hash(c)];
        // sets the hash index to null and decrements numItems if the character is the first and only Entry
        if (entry.getNext() == null && entry.getCharacter() == c) {
            table[hash(c)] = null;
            numItems--;
        }
        // sets the hash index to start at the next Entry if the character is the first Entry and the next Entry is not null
        else if (entry.getCharacter() == c && entry.getNext() != null) table[hash(c)] = entry.getNext();
        // If we must search the chain
        else {
            Entry curr = entry, next = entry.getNext();
            // Loops while the next entry is not null and the next character is not equal to the input character
            while (next != null && next.getCharacter() != c) {
                curr = curr.getNext();
                next = next.getNext();
            }
            // if the next is not null and the next character is equal to the input character, the next character is set to next's next Entry
            if (next != null && next.getCharacter() == c) curr.setNext(next.getNext());
        }
    }

    /** Returns the frequency of a character in a hash table
     * @param c The character to get the frequency of
     * @return An integer representing the frequency of the character */
    public int getFrequency(char c) {
        Entry entry = table[hash(c)];
        if (entry == null) return 0;
        // loops while the next entry is not null and the character is not equal to the input character
        while(entry.getNext() != null && entry.getCharacter() != c) entry = entry.getNext();
        return entry.getCharacter() == c ? entry.getFrequency() : 0;
    }

    /** Returns a hashed index for a character
     * @param c The character to hash
     * @return the hashed index for a character */
    public int hash(char c) { return c % tableSize; }

    /** Rehashes the table with a new HashTable that is twice the size */
    public void rehashTable() {
        // doubles the table size
        tableSize *= 2;
        // creates a new Hashtable that is twice the size of the current one
        HashTable newHashTable = new HashTable(tableSize);
        // loops over each Entry in the table
        for (Entry entry : table) {
            // loops while the current Entry is not null
            while (entry != null) {
                // hash index of new table hash
                int hashIndex = hash(entry.getCharacter());
                // front of the new hashtable
                Entry front = newHashTable.table[hashIndex];
                // sets the hash index to a new Entry
                newHashTable.table[hashIndex] = new Entry(entry.getCharacter(), entry.getFrequency());
                if (front != null) {
                    newHashTable.table[hashIndex].setNext(front);
                }
                entry = entry.getNext();
            }
        }
        // sets the new table
        table = newHashTable.table;
    }
}
