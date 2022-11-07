package ru.javarush.cryptoanalyzer.khlopin.commands;

import ru.javarush.cryptoanalyzer.khlopin.constants.Constants;
import ru.javarush.cryptoanalyzer.khlopin.exception.ApplicationException;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

public interface Writable {

    default void writeEncryptResultInFile(char[] charArray) {
        final ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(charArray));
        byte[] result =  Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());

        try {
            Files.write(Constants.getCryptText(),result);
        } catch (IOException e) {
            throw new ApplicationException(e.getMessage());
        }
    }

    default void writeDecryptResultInFile(char[] charArray) {
        final ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(charArray));
        byte[] result =  Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());

        try {
            Files.write(Constants.getOriginalText(),result);
        } catch (IOException e) {
            throw new ApplicationException(e.getMessage());
        }
    }

}
