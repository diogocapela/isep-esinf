package morse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterTest {

   @Before
   public void setUp() {

   }

   @Test
   public void testCompareTo() {
      Character charROOT = new Character("", "", "ROOT");
      Character charA = new Character("._", "A", "Letter");
      Character charN = new Character("_.", "N", "Letter");
      Character charB = new Character("_...", "B", "Letter");
      Character charP = new Character(".__.", "P", "Letter");

      // Root
      assertEquals(1, charROOT.compareTo(charA));
      assertEquals(-1, charROOT.compareTo(charN));

      // Same
      assertEquals(0, charROOT.compareTo(charROOT));
      assertEquals(0, charA.compareTo(charA));
      assertEquals(0, charN.compareTo(charN));
   }

}
