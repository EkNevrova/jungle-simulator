package by.eknevrova.junglesimulator.util;

import by.eknevrova.junglesimulator.model.KomodoVaranus;
import by.eknevrova.junglesimulator.util.CheckIndex;
import by.eknevrova.junglesimulator.service.PrintAction;

public class EventSimulator {
    //  0-20 // комодский варан поспал: +7en  +1hp
    // 20-30 // комодский варан сидит в засаде, подкарауливая жертву: -2en
    // 30-40 // комодский варан напал и съел кабана: -3en  +3hp
    // 40-50 // комодский варан напал и съел оленя: -5en  +5hp
    // 50-55 // комодский варан переплыл через реку: -15en
    // 55-60 // комодский варан в течение дня остался без добычи: -5en  -1hp
    // 60-70 // комодский варан убегает от крокодила: -7en
    // 70-90 // комодский варан подрался с сородичем: -20en  -15hp
    // 90-100// на комодского варана напали браконьеры: -20hp
    // при  en=0  -5hp

    private void sleepEvent(KomodoVaranus komodoVaranus) {
        int energy = komodoVaranus.getEnergy();
        energy += 7;
        energy = CheckIndex.check(energy);
        int health = komodoVaranus.getHealth();
        health += 1;
        if (energy == 0) {
            health -= 5;
        }
        health = CheckIndex.check(health);
        PrintAction.printAction("Комодский варан поспал: +7 энергии  +1 здоровья. ", energy, health);
        komodoVaranus.setEnergy(energy);
        komodoVaranus.setHealth(health);
    }

}
