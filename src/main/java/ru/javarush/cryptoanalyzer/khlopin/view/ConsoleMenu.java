package ru.javarush.cryptoanalyzer.khlopin.view;

import ru.javarush.cryptoanalyzer.khlopin.commands.BruteForce;
import ru.javarush.cryptoanalyzer.khlopin.commands.Decrypt;
import ru.javarush.cryptoanalyzer.khlopin.commands.Encrypt;
import ru.javarush.cryptoanalyzer.khlopin.controller.ResourcesController;
import ru.javarush.cryptoanalyzer.khlopin.exception.ApplicationException;

import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner console = new Scanner(System.in);
    private final View view = new View();
    private final BruteForce bruteForce = new BruteForce();
    private final Decrypt decrypt = new Decrypt();
    private final Encrypt encrypt = new Encrypt();

    private final ResourcesController resources = new ResourcesController();
    public void run() {
        view.menu();
        System.out.print("Введите цифру: ");
        int activator = console.nextInt();
        switch (activator) {
            case 1 -> {
                System.out.println("Выберите метод ввода текста");
                System.out.println("1 - Ввести текст через файл (Необходимо на этом этапе записать текст для шифровки в файл text.txt)");
                System.out.println("2 - Ввести текст через консоль и записать в файл.");
                int choose = console.nextInt();
                if (choose == 1) {
                    encrypt.tryToCrypt(resources.getTextFromFile(), resources.getKey());
                    System.out.println("Результат записан в файл crypt.txt");
                } else if (choose == 2) {
                    encrypt.tryToCrypt(resources.getTextFromConsole(), resources.getKey());
                    System.out.println("Результат шифровки: " + resources.getTextCrypt());
                } else {
                    finish(console);
                }
            }
            case 2 -> {
                decrypt.tryToDecrypt(resources.getTextCrypt(), resources.getKey());
                System.out.println("Результат дешифровки: " + resources.getTextDecrypt());
                System.out.println("Полный результат дешифровки находится в файле originalText.txt");
            }
            case 3 -> {
                bruteForce.tryToHack(resources.getTextCrypt());
                System.out.println("Результат взлома: " + resources.getTextDecrypt());
                System.out.println("Полный результат взлома находится в файле originalText.txt");
            }
            case 4 -> System.out.println("Последний зашифрованный текст: " + resources.getTextCrypt());
            case 5 -> System.out.println("Последний расшифрованный/взломанный текст: " + resources.getTextDecrypt());
            case 6 -> System.out.println("Последний введённый текст: " + resources.getTextFromFile());
            case 7 -> {
                System.out.println("Всё. Я ухожу.");
                System.exit(0);
            }
            default -> {
                view.printEncounterValue();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new ApplicationException(e.getMessage());
                }
                run();
            }
        }

        finish(console);
    }

    private void finish(Scanner console) {
        int activator;
        System.out.println("1 - Меню");
        System.out.println("Для закрытия программы - любой текст или нажмите enter");
        activator = console.nextInt();
        System.out.print("Введите: ");
        if (activator == 1) {
            run();
        } else {
            System.out.println("Всё. Я ухожу.");
            System.exit(0);
        }
    }
}
