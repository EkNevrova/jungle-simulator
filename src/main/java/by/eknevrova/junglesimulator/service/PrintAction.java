package by.eknevrova.junglesimulator.service;

public class PrintAction {
    public static void printAction(String actionName, int energy, int health) {
        System.out.println(actionName + "Текущая энергия: " + energy + "; текущее здоровье: " + health);
    }
}
