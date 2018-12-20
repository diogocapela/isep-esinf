package morse;

import tree.BST;

import java.util.*;

public class MorseTree extends BST<Character> {

   /* 2. Morse -> Alphabet
   ======================================================================== */

   public String decodeMorseCodeToPhrase(String morseCode) {
      if(morseCode == null || "".equals(morseCode)) return null;

      StringBuilder phrase = new StringBuilder();
      String[] morseWords = morseCode.split("/");
      for(String morseWord : morseWords) {
         String[] morseLetters = morseWord.split(" ");
         for(String morseLetter : morseLetters) {
            String letter = decodeMorseCharToLetterChar(morseLetter);
            phrase.append(letter);
         }
         phrase.append(" ");
      }
      return phrase.toString().trim();
   }

   public String decodeMorseCharToLetterChar(String morseChar) {
      if(morseChar == null || "".equals(morseChar)) return null;

      for(Character character : this.inOrder()) {
         String m = character.getMorseCode();
         if(morseChar.equals(m)) {
            return character.getLetter();
         }
      }
      return null;
   }

   /* 4. Alphabet -> Morse
   ======================================================================== */

   public String decodePhraseToMorseCode(String phrase) {
      if(phrase == null || "".equals(phrase)) return null;

      StringBuilder morseCode = new StringBuilder();
      String[] words = phrase.split(" ");
      for(String word : words) {
         String[] letters = word.split("");
         for(String letter : letters) {
            String morseChar = decodeLetterCharToMorseChar(letter);
            morseCode.append(morseChar);
            morseCode.append(" ");
         }
         // Delete last " "
         morseCode.deleteCharAt(morseCode.toString().length() - 1);
         morseCode.append("/");
      }
      // Delete last "/"
      morseCode.deleteCharAt(morseCode.toString().length() - 1);
      return morseCode.toString().trim();
   }

   public String decodeLetterCharToMorseChar(String letterChar) {
      if(letterChar == null || "".equals(letterChar)) return null;

      for(Character character : this.inOrder()) {
         String l = character.getLetter();
         if(letterChar.equals(l)) {
            return character.getMorseCode();
         }
      }
      return null;
   }

   /* 5. Find Initial Common Sequence
   ======================================================================== */

   public String findInitialCommonSequence(String code1, String code2) {
      if(code1 == null || code2 == null) return null;

      StringBuilder commonSequence = new StringBuilder();

      int minLength = Math.min(code1.length(), code2.length());

      for(int i = 0; i < minLength; i++) {
         char char1 = code1.charAt(i);
         char char2 = code2.charAt(i);

         if(char1 == char2) {
            commonSequence.append(char1);
         } else {
            return commonSequence.toString();
         }
      }

      return commonSequence.toString();
   }

   /* 6. Sort by Number of Occurrence of Character Type
   ======================================================================== */

   public List<String> sortByNumberOfOccurrenceOfCharacterType(List<String> morseCodes, CharacterType characterType) {
      Map<String, Integer> codesMap = new HashMap<>();

      for(String morseCode : morseCodes) {
         int numberOfOccurrencesOfType = 0;
         for(String morseChar : morseCode.split(" ")) {
            for(Character character : inOrder()) {
               if(morseChar.equals(character.getMorseCode())) {
                  if(characterType == character.getType()) {
                     numberOfOccurrencesOfType++;
                  }
               }
            }
         }
         String alphabetRepresentation = decodeMorseCodeToPhrase(morseCode);
         codesMap.put(alphabetRepresentation, numberOfOccurrencesOfType);
      }

      // Convert the map to a list of map
      List<Map.Entry<String, Integer>> list = new LinkedList<>(codesMap.entrySet());

      // Sort the list by value
      list.sort(Comparator.comparing(o -> (o.getValue())));

      // Loop the sorted list and put it into a new insertion order
      Map<String, Integer> sortedMap = new LinkedHashMap<>();
      for (Map.Entry<String, Integer> entry : list) {
         sortedMap.put(entry.getKey(), entry.getValue());
      }

      // Create the sorted list
      List<String> sortedList = new ArrayList<>();

      // Pass the values of the map to the sorted list
      for (Map.Entry<String, Integer> codeEntry : sortedMap.entrySet()) {
         sortedList.add(codeEntry.getKey());
      }

      // Invert the list order
      Collections.reverse(sortedList);

      return sortedList;
   }

}
