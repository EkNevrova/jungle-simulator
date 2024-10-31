package by.eknevrova.junglesimulator._main;
import by.eknevrova.junglesimulator.model.KomodoVaranus;
import by.eknevrova.junglesimulator.util.EventSimulator;

public class _Main {
    public static void main(String[] args) {
        KomodoVaranus komodoVaranus = new KomodoVaranus();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(komodoVaranus);
    }
}
