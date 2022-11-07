package ru.javarush.cryptoanalyzer.khlopin.commands;

import ru.javarush.cryptoanalyzer.khlopin.constants.Constants;

public class Encrypt implements Writable {

    public void tryToCrypt(String text, int key) { //метод шифрования
            char[] charArray = text.toCharArray();
            for (int i = 0; i < text.length(); i++) {
                int temp = Constants.getALPHABET().indexOf(text.charAt(i)); // Получаем индекс символа в алфавите из входящего текста
                charArray[i] = Constants.getALPHABET().get((temp + key) % (Constants.getALPHABET().size()));
            }
        writeEncryptResultInFile(charArray);
    }
}
