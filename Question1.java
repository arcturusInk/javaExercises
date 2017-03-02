package question1;

public class Question1 {

  public static void main(String[] args) {
    String[] fortunes = {
        "You will have great success",
        "Watch out for angry pandas",
        "Seek peace, not anger" };
    String naughtyFortune = makeNaughtyFortune(fortunes);
    System.out.println(naughtyFortune);
    System.out.println("That should have printed: " +
        "You will have great success, in bed. " +
        "Watch out for angry pandas, in bed. " +
        "Seek peace, not anger, in bed. ");
  }

  /**
    * function takes an array of Strings and combines them into
    * one long string.
    * @param text The array of strings to combine
    * @return The single, combined string.
    */
  public static String combineStrings(String[] text) {
    String oneLongStr = "";
    for (int i = 0 ; i < text.length; ++i){
        oneLongStr = oneLongStr + text[i];
    }
    return oneLongStr;
  }

  /**
    * Transforms a list of fortunes to make them naughty.
    * @param text The array of fortunes to change
    * @return The updated array.
    */
  public static String[] addNaughtyEndings(String[] text) {
    String[] updatedText = new String[text.length];
    for(int i = 0; i < text.length; i++) {
      updatedText[i] = text[i] + ", in bed. ";
    }
    return updatedText;
  }

  /**
    * function takes a bunch of separate fortunes, makes each one
    * naughty, and combines them all into one string.
    * @param text The array of fortunes to make naughty and combine
    * @return The single, combined string.
    */
  public static String makeNaughtyFortune(String[] text) {
    String[] naughtyStrings = addNaughtyEndings(text);
    String oneString = combineStrings(naughtyStrings);
    return oneString;
  }

}
