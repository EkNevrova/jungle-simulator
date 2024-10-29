package by.eknevrova.junglesimulator.model;

public class KomodoVaranus {

    // 100 hp
    // 100 энергия
    // коэффициент зубов - сколько энергии комодский варан получает, когда кого-то съест

    private int health = 100;
    private int energy = 100;
    private final double FANGS = 2.5;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getFANGS() {
        return this.FANGS;
    }

}
