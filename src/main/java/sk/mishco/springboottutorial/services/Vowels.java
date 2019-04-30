package sk.mishco.springboottutorial.services;

public class Vowels {


    public static int getCount(String str) {
        int vowelsCount = 0;
        final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

        char[] charArray = str.toCharArray();
        for (char item : charArray) {
            for (char vowel : VOWELS) {
                if (item == vowel) {
                    vowelsCount++;
                }
            }
        }

        return vowelsCount;
    }

    // Cleaner version
    //    public static int getCount(String str) {
    //        return (int) str.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    //    }

}
