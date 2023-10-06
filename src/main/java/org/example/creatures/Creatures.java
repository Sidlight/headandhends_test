package org.example.creatures;

public interface Creatures {

    boolean isAlive();
    void attack(Creatures creatures) throws Exception;
    void damage(int attack, int damage) throws Exception;
}
