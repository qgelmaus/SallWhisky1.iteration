package gui;

import application.controller.Controller;
import javafx.application.Application;

public class App {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createSomeObjects();
        Application.launch(MainPane.class);
    }
}
