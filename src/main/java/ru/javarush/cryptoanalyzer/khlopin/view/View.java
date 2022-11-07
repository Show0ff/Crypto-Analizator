package ru.javarush.cryptoanalyzer.khlopin.view;

public class View {
    public void startText() {
        System.out.println("**************************************************");
        System.out.println("Добро пожаловать в КриптоАнализатор!");
        System.out.println("**************************************************");
    }

    public void menu() {
        System.out.println("--------------------------------------------------");
        System.out.println("Выберите функцию: ");
        System.out.println("1. Зашифровать текст.");
        System.out.println("2. Расшифровать текст.");
        System.out.println("3. BruteForce (Предназначен для длинных текстов)");
        System.out.println("--------------------------------------------------");
        System.out.println("4. Посмотреть последний зашифрованный текст");
        System.out.println("5. Посмотреть последний расшифрованный текст");
        System.out.println("6. Посмотреть последний введённый текст");
        System.out.println("--------------------------------------------------");
        System.out.println("7. Закрыть программу");
        System.out.println("--------------------------------------------------");
    }

    public void printMenuOfBruteForce() {
        System.out.println("******************************************");
        System.out.println("Выберите метод взлома:");
        System.out.println("1 - Взлом по пунктуации");
        System.out.println("2 - Взлом по словарю");
        System.out.println("******************************************");
    }
    public void printEncounterValue() {
        System.out.println("Введено некоректное значение");
    }
    public void printTryKey(int key) {
        System.out.println("Пробуем ключ " + key);
    }

}
