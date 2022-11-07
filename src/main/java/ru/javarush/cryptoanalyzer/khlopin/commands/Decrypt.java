package ru.javarush.cryptoanalyzer.khlopin.commands;


public class Decrypt implements Writable, Decryptable {

    public void tryToDecrypt(String text, int key) {
        char[] decryptResult = decrypt(text, key);
        writeDecryptResultInFile(decryptResult);
    }
}
