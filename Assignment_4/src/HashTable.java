/** A class to implement a HashTable used to get word count of a given input */
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
        numItems  = 0;
        loadFactor = 0;
    }

    /** Prints out each word in a String input and its respective frequency
     * @param input The String input */
    public static void wordCount(String input) {
        // returns nothing if the string is empty
        if (input.isEmpty()) {
            return;
        }

        // Creates a HashTable of size 1
        HashTable hashTable = new HashTable(1);

        // iterates through an array created from splitting the input string by words (any string between 2 non-alphabetical characters)
        // inserts each word into a the HashTable with a frequency of 1
        for (String word : input.toLowerCase().split("\\P{Alpha}+")) {
            hashTable.insert(word, 1);
        }
        hashTable.printTable();
    }

    /** Inserts an Entry into the HashTable. Uses separate chaining if there is a collision
     * @param word The word of the Entry
     * @param frequency The frequency of an Entry */
    public void insert(String word, int frequency) {
        // creates a hashed index from the word
        int hashIndex = hash(word);
        // if the hashed index is null, a new Entry is added to that index
        // the numbers of items and load factor are updated
        if (table[hashIndex] == null) {
            table[hashIndex] = new Entry(word, frequency);
            numItems++;
            loadFactor = (double) numItems / tableSize;
        }
        // if the hashed index is not null
        else {
            Entry entry = table[hashIndex];
            // loops through each chained Entry at the index while the next Entry is not null and the current Entry's word is not equal to the input word
            while(entry.getNext() != null && !entry.getWord().equals(word)) {
                entry = entry.getNext();
            }
            // if the Entry's word is equal to the input word, the Entry's frequency is incremented
            if (entry.getWord().equals(word)) {
                entry.setFrequency(entry.getFrequency() + 1);
            }
            // the Entry's next Entry is set to the new Entry
            else {
                entry.setNext(new Entry(word, frequency));
            }
        }
        // checks if a rehashing of the table is necessary
        if (rehash()) {
            rehashTable();
        }
    }

    /** Returns a hashed index for a given word
     * @param word The word to be hashed
     * @return An integer for the hashed index */
    public int hash(String word) { return Math.abs(word.hashCode()) % tableSize; }

    /** Checks if the load factor is greater than 0.8
     * @return True or False based off the load factor being greater than 0.8 */
    public boolean rehash() { return loadFactor > 0.8; }

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
                // inserts the Entry into the new HashTable
                newHashTable.insert(entry.getWord(), entry.getFrequency());
                entry = entry.getNext();
            }
        }
        // sets the new table
        table = newHashTable.table;
    }

    /** Prints the HashTable */
    public void printTable() {
        // loops over each Entry in the table
        for (Entry entry : table) {
            // loops while the Entry is not null and prints the Entry
            while (entry != null) {
                System.out.println(entry.toString());
                entry = entry.getNext();
            }
        }
    }
}