package ru.javarush.cryptoanalyzer.khlopin;


import ru.javarush.cryptoanalyzer.khlopin.view.ConsoleMenu;
import ru.javarush.cryptoanalyzer.khlopin.view.View;


public class Runner {
    public static void main(String[] args) {
        View view = new View();
        ConsoleMenu controller = new ConsoleMenu();
        view.startText();
        controller.run();
    }
}
