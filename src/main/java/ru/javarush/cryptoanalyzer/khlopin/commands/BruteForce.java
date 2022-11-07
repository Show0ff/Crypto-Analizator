package ru.javarush.cryptoanalyzer.khlopin.commands;

import ru.javarush.cryptoanalyzer.khlopin.constants.Constants;
import ru.javarush.cryptoanalyzer.khlopin.Resources.Dictionary;
import ru.javarush.cryptoanalyzer.khlopin.view.View;

import java.util.*;


public class BruteForce implements Writable, Decryptable {

    private final View view = new View();
    private final Scanner console = new Scanner(System.in);

    private final Dictionary dictionary = new Dictionary();


    public void tryToHack(String text) {
        view.printMenuOfBruteForce();
        int key = console.nextInt();
        if (key == 1) {
            bruteForceByGrammatical(text);
        } else if (key == 2){
            bruteForceByDictionary(text);
        } else {
            view.printEncounterValue();
            tryToHack(text);
        }
    }

    private void bruteForceByDictionary(String text) {

        char[] charArray = tryToDecrypt(text);
        boolean successful = false;
        while (!successful) {
            String stringFromCharArray = new String(charArray);
            StringTokenizer tokenizer = new StringTokenizer(stringFromCharArray, " ");
            List<String> textTokenInList = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                textTokenInList.add(tokenizer.nextToken()); // делит стринг на токены по пробелам и добавляет их в список
            }
            for (int i = 0; i < textTokenInList.size(); i++) {
                for (int j = 0; j < dictionary.wordList.size(); j++) {
                    if (i > 0 && textTokenInList.get(i).equals(dictionary.wordList.get(j))) {
                        successful = true;
                        break;
                    }
                }
            }
            if (!successful) {
                charArray = tryToDecrypt(text);
            }
        }
        writeDecryptResultInFile(charArray);

    }

    private void bruteForceByGrammatical(String text) {
        char[] charArray = tryToDecrypt(text);
        boolean successful = false;
        while (!successful) {
            String stringFromCharArray = new String(charArray);
            StringTokenizer tokenizer = new StringTokenizer(stringFromCharArray, " ");
            List<String> textTokenInList = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                textTokenInList.add(tokenizer.nextToken()); // делит стринг на токены по пробелам и добавляет их в список
            }
            for (int i = 0; i < textTokenInList.size(); i++) {
                for (int j = 0; j < dictionary.introductoryWords.size(); j++) {
                    if (i > 0 && textTokenInList.get(i).equals(dictionary.introductoryWords.get(j)) && textTokenInList.get(i - 1).endsWith(",")) {
                        successful = true;
                        break;
                    }
                }
            }
            if (!successful) {
                charArray = tryToDecrypt(text);
            }
        }
        writeDecryptResultInFile(charArray);

    }


    private char[] tryToDecrypt(String text) {
         Random random = new Random();
        int key = random.nextInt(Constants.getALPHABET().size());
        view.printTryKey(key);
        return decrypt(text, key);
    }

}