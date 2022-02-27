package morse;

public class Character implements Comparable<Character> {

   private String morseCode;
   private String letter;
   private CharacterType type;

   public Character(String morseCode, String letter, String characterType) {
      this.morseCode = morseCode;
      this.letter = letter;
      this.setType(characterType);
   }

   public String getMorseCode() {
      return morseCode;
   }

   public void setMorseCode(String morseCode) {
      this.morseCode = morseCode;
   }

   public String getLetter() {
      return letter;
   }

   public void setLetter(String letter) {
      this.letter = letter;
   }

   public CharacterType getType() {
      return type;
   }

   public void setType(String characterType) {
      switch (characterType.trim().toUpperCase()) {
         case "LETTER":
            this.type = CharacterType.LETTER;
            break;
         case "NON-ENGLISH":
            this.type = CharacterType.NON_ENGLISH;
            break;
         case "NUMBER":
            this.type = CharacterType.NUMBER;
            break;
         case "PUNCTUATION":
            this.type = CharacterType.PUNCTUATION;
            break;
         case "PROSIGN":
            this.type = CharacterType.PROSIGN;
            break;
         case "ROOT":
            this.type = CharacterType.ROOT;
            break;
         default:
            this.type = CharacterType.UNKNOWN;
            break;
      }
   }

   @Override
   public String toString() {
      return getLetter();
   }

   @Override
   public int compareTo(Character o) {
      // Get the morse code strings
      String thisCode = this.getMorseCode();
      String otherCode = o.getMorseCode();

      // If the morse code is equal return 0
      if (thisCode.equals(otherCode)) return 0;

      // Get the min length from the 2 source codes
      int codeMinLength = Math.min(thisCode.length(), otherCode.length());

      for(int i = 0; i < codeMinLength; i++) {
         char thisChar = thisCode.charAt(i);
         char otherChar = otherCode.charAt(i);

         if (thisChar != otherChar) {
            if (thisChar == '.') return -1;
            return 1;
         }
      }

      if (thisCode.length() > codeMinLength) {
         char thisChar = thisCode.charAt(codeMinLength);

         if (thisChar == '.') return -1;
         return 1;
      }

      char otherChar = otherCode.charAt(codeMinLength);

      if (otherChar == '.') return 1;
      return -1;
   }

}
