package ru.javarush.cryptoanalyzer.khlopin.commands;

import ru.javarush.cryptoanalyzer.khlopin.constants.Constants;

public interface Decryptable {

    default char[] decrypt(String text, int key) {
        char[] charArray = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            int temp = Constants.getALPHABET().indexOf(text.charAt(i)); // Получаем индекс символа в алфавите из входящего текста
            if (temp - key < 0) {
                int negativeTemp = temp - key;
                charArray[i] = Constants.getALPHABET().get(Constants.getALPHABET().size() + negativeTemp);
            } else {
                charArray[i] = Constants.getALPHABET().get((temp - key) % (Constants.getALPHABET().size()));
            }
        }
        return charArray;
    }
}
