import static org.junit.Assert.*;
import org.junit.*;
public class Tester {
    @Test
    public void testIsAnagram() {
        assertTrue("", HashTable.isAnagram("Dormitory", "Dirty room"));
        assertTrue("", HashTable.isAnagram("Conversation", "Voices rant on"));
        assertTrue("", HashTable.isAnagram("The Morse Code", "Here come dots"));
        assertTrue("", HashTable.isAnagram("Funeral", "Real fun"));
        assertTrue("", HashTable.isAnagram("O Draconian devil", "Leonardo da Vinci"));
        assertTrue("", HashTable.isAnagram("Tar", "Rat"));
        assertTrue("", HashTable.isAnagram("Stressed", "Desserts"));
        assertFalse("", HashTable.isAnagram("abb", "aab"));
        assertTrue("", HashTable.isAnagram("!osh","hso!"));
        assertTrue("", HashTable.isAnagram("Joyful Fourth", "Fourth of July"));
    }
}
