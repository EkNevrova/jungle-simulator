package by.eknevrova.junglesimulator.util;

import by.eknevrova.junglesimulator.model.KomodoVaranus;
import by.eknevrova.junglesimulator.service.PrintAction;

public class EventSimulator {
    //  0-20 // комодский варан поспал: +7en  +1hp
    // 20-30 // комодский варан сидел в засаде подкарауливая жертву: -2en
    // 30-40 // комодский варан напал и съел кабана: -3en  +3hp*coeff
    // 40-50 // комодский варан напал и съел оленя: -5en  +4hp*coeff
    // 50-55 // комодский варан нашёл и съел падаль: -1en  +3hp*coeff
    // 55-65 // комодский варан переплыл через реку: -15en
    // 65-70 // комодский варан в течение дня остался без добычи: -7en  -1hp
    // 70-80 // комодский варан убегает от крокодила: -15en
    // 80-90 // комодский варан подрался с сородичем: -20en  -15hp
    // 90-100// на комодского варана напали браконьеры: -20hp
    // при  en=0  -5hp

    private void sleepEvent(KomodoVaranus komodoVaranus) {
        int energy = komodoVaranus.getEnergy();
        energy += 7;
        energy = checkIndex(energy);
        int health = komodoVaranus.getHealth();
        health += 1;
        if (energy == 0) {
            health -= 5;
        }
        health = checkIndex(health);
        komodoVaranus.setEnergy(energy);
        komodoVaranus.setHealth(health);
        PrintAction.printAction("Комодский варан поспал: +7 энергии  +1 здоровья. ", energy, health);
    }

    private void stalkVictimEvent(KomodoVaranus komodoVaranus) {
        int energy = komodoVaranus.getEnergy();
        energy -= 2;
        energy = checkIndex(energy);
        int health = komodoVaranus.getHealth();
        if (energy == 0) {
            health -= 5;
        }
        health = checkIndex(health);
        komodoVaranus.setEnergy(energy);
        komodoVaranus.setHealth(health);
        PrintAction.printAction("Комодский варан сидел в засаде подкарауливая жертву: -2 энергии. ", energy, health);
    }

    private void eatBoarEvent(KomodoVaranus komodoVaranus) {
        int energy = komodoVaranus.getEnergy();
        energy -= 3;
        energy = checkIndex(energy);
        int health = komodoVaranus.getHealth();
        health += (int) (komodoVaranus.getFANGS() * 3);
        if (energy == 0) {
            health -= 5;
        }
        health = checkIndex(health);
        komodoVaranus.setEnergy(energy);
        komodoVaranus.setHealth(health);
        PrintAction.printAction("Комодский варан напал и съел кабана: -3 энергии  +3 здоровья * коэффициент. ", energy, health);
    }

    private void eatDeerEvent(KomodoVaranus komodoVaranus) {
        int energy = komodoVaranus.getEnergy();
        energy -= 5;
        energy = checkIndex(energy);
        int health = komodoVaranus.getHealth();
        health += (int) (komodoVaranus.getFANGS() * 4);
        if (energy == 0) {
            health -= 5;
        }
        health = checkIndex(health);
        komodoVaranus.setEnergy(energy);
        komodoVaranus.setHealth(health);
        PrintAction.printAction("Комодский варан напал и съел оленя: -5 энергии  +4 здоровья * коэффициент. ", energy, health);
    }

    private void eatCarrionEvent(KomodoVaranus komodoVaranus) {
        int energy = komodoVaranus.getEnergy();
        energy -= 1;
        energy = checkIndex(energy);
        int health = komodoVaranus.getHealth();
        health += (int) (komodoVaranus.getFANGS() * 3);
        if (energy == 0) {
            health -= 5;
        }
        health = checkIndex(health);
        komodoVaranus.setEnergy(energy);
        komodoVaranus.setHealth(health);
        PrintAction.printAction("Комодский варан нашёл и съел падаль: -1 энергии  +3 здоровья * коэффициент. ", energy, health);
    }

    private void swimRiverEvent(KomodoVaranus komodoVaranus) {
        int energy = komodoVaranus.getEnergy();
        energy -= 15;
        energy = checkIndex(energy);
        int health = komodoVaranus.getHealth();
        if (energy == 0) {
            health -= 5;
        }
        health = checkIndex(health);
        komodoVaranus.setEnergy(energy);
        komodoVaranus.setHealth(health);
        PrintAction.printAction("Комодский варан переплыл через реку: -15 энергии. ", energy, health);
    }

    private void fallPreyEvent(KomodoVaranus komodoVaranus) {
        int energy = komodoVaranus.getEnergy();
        energy -= 7;
        energy = checkIndex(energy);
        int health = komodoVaranus.getHealth();
        health -= 1;
        if (energy == 0) {
            health -= 5;
        }
        health = checkIndex(health);
        komodoVaranus.setEnergy(energy);
        komodoVaranus.setHealth(health);
        PrintAction.printAction("Комодский варан в течение дня остался без добычи: -7 энергии  -1 здоровья. ", energy, health);
    }

    private void escapeEvent(KomodoVaranus komodoVaranus) {
        int energy = komodoVaranus.getEnergy();
        energy -= 15;
        energy = checkIndex(energy);
        int health = komodoVaranus.getHealth();
        if (energy == 0) {
            health -= 5;
        }
        health = checkIndex(health);
        komodoVaranus.setEnergy(energy);
        komodoVaranus.setHealth(health);
        PrintAction.printAction("Комодский варан убегает от крокодила: -15 энергии. ", energy, health);
    }

    private void fightEvent(KomodoVaranus komodoVaranus) {
        int energy = komodoVaranus.getEnergy();
        energy -= 20;
        energy = checkIndex(energy);
        int health = komodoVaranus.getHealth();
        health -= 15;
        if (energy == 0) {
            health -= 5;
        }
        health = checkIndex(health);
        komodoVaranus.setEnergy(energy);
        komodoVaranus.setHealth(health);
        PrintAction.printAction("Комодский варан подрался с сородичем: -20 энергии  -15 здоровья. ", energy, health);
    }

    private void poacherAttackEvent(KomodoVaranus komodoVaranus) {
        int health = komodoVaranus.getHealth();
        health -= 20;
        health = checkIndex(health);
        komodoVaranus.setHealth(health);
        PrintAction.printAction("Hа комодского варана напали браконьеры: -20 здоровья. ", komodoVaranus.getEnergy(), health);
    }

    private int checkIndex(int index) {
        if (index > 100) {
            index = 100;
        } else if (index < 0) {
            index = 0;
        }
        return index;
    }

    private boolean checkStatus(KomodoVaranus komodoVaranus) {
        if (komodoVaranus.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void startSimulation(KomodoVaranus komodoVaranus) {
        while (checkStatus(komodoVaranus)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 20) {
                sleepEvent(komodoVaranus);
            } else if (eventNumber >= 20 && eventNumber < 30) {
                stalkVictimEvent(komodoVaranus);
            } else if (eventNumber >= 30 && eventNumber < 40) {
                eatBoarEvent(komodoVaranus);
            } else if (eventNumber >= 40 && eventNumber < 50) {
                eatDeerEvent(komodoVaranus);
            } else if (eventNumber >= 50 && eventNumber < 55) {
                eatCarrionEvent(komodoVaranus);
            } else if (eventNumber >= 55 && eventNumber < 65) {
                swimRiverEvent(komodoVaranus);
            } else if (eventNumber >= 65 && eventNumber < 70) {
                fallPreyEvent(komodoVaranus);
            } else if (eventNumber >= 70 && eventNumber < 80) {
                escapeEvent(komodoVaranus);
            } else if (eventNumber >= 80 && eventNumber < 90) {
                fightEvent(komodoVaranus);
            } else if (eventNumber >= 90 && eventNumber < 100) {
                poacherAttackEvent(komodoVaranus);
            }
            Thread.sleep(1000);
        }
        System.out.println("Оооо нееет! Комодский варан умер! The end!");
    }
}