package morse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileLoader {

   /* 1. Load Morse Tree
   ======================================================================== */

   public void loadMorseTreeFromFile(MorseTree tree, String filePath) {
      tree.insert(new Character("", "", "ROOT"));
      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
         br.lines().forEach(line -> {
            String[] lineData = line.trim().split(" ");
            String morseCode = lineData[0];
            String letter = lineData[1];
            String characterType = lineData[2];
            Character character = new Character(morseCode, letter, characterType);
            tree.insert(character);
         });
      } catch (IOException e) {
         Logger.getAnonymousLogger().log(Level.WARNING, e.getMessage());
      }
   }

   /* 4. Load Alphabet Tree
   ======================================================================== */

   public void loadLetterTreeFromFile(MorseTree tree, String filePath) {
      tree.insert(new Character("", "", "ROOT"));
      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
         br.lines().forEach(line -> {
            String[] lineData = line.trim().split(" ");
            String morseCode = lineData[0];
            String letter = lineData[1];
            String characterType = lineData[2];
            if("Letter".equals(characterType)) {
               Character character = new Character(morseCode, letter, characterType);
               tree.insert(character);
            }
         });
      } catch (IOException e) {
         Logger.getAnonymousLogger().log(Level.WARNING, e.getMessage());
      }
   }

}
