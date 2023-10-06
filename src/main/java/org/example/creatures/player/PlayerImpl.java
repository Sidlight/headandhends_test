package org.example.creatures.player;

import org.example.creatures.AbstractCreatures;

public class PlayerImpl extends AbstractCreatures implements Player {

    private final static double MAX_HEAL_COEFFICIENT = 0.3;
    private final static int MAX_HEAL_COUNT = 4;
    private final static double MINIMUM_VALUE_FOR_HEAL = 0.7;
    private final int maxHealth;
    private int healCount;

    public PlayerImpl(int minDamage, int maxDamage, int defense, int attack, int health) throws Exception {
        super(minDamage, maxDamage, defense, attack, health);
        this.maxHealth = health;
        this.healCount = MAX_HEAL_COUNT;
    }

    @Override
    public void heal() throws Exception {
        if (healCount == 0) {
            return;
        }
        super.heal((int) (maxHealth * MAX_HEAL_COEFFICIENT));
        healCount--;
    }

    @Override
    public void damage(int attack, int damage) throws Exception {
        super.damage(attack, damage);
        if (isAlive() && (double) super.health / maxHealth < MINIMUM_VALUE_FOR_HEAL) {
            heal();
        }
    }

}
