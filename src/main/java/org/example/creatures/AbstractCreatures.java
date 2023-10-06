package org.example.creatures;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

public abstract class AbstractCreatures implements Creatures {
    private static final BiFunction<Integer, Integer, Integer> ATTACK_MODIFIER_FUNCTION = (attack, defense) -> attack - defense + 1;
    private static final int MINIMUM_DICE_ROLLS = 1;
    private static final int MINIMUM_DICE_VALUE = 1;
    private static final int MAXIMUM_DICE_VALUE = 6;
    private static final int MINIMUM_VALUE_FOR_WIN = 5;
    private static final int MAX_ATTACK = 30;
    private static final int MAX_DEFENSE = 30;
    private final int maxDamage;
    private final int minDamage;
    private final int defense;
    private final int attack;
    protected int health;

    protected AbstractCreatures(int minDamage, int maxDamage, int defense, int attack, int health) throws Exception {
        validateParam(null, minDamage);
        validateParam(null, maxDamage);
        validateParam(MAX_ATTACK, attack);
        validateParam(MAX_DEFENSE, health);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.defense = defense;
        this.attack = attack;
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Creatures creatures) throws Exception {
        creatures.damage(attack, ThreadLocalRandom.current().nextInt(minDamage, maxDamage));
    }

    public void damage(int attack, int damage) throws Exception {
        int modAttack = ATTACK_MODIFIER_FUNCTION.apply(attack, defense);
        if (checkAttack(modAttack)) {
            damage(damage);
        }
    }

    protected void heal(int healValue) throws Exception {
        if (health == 0) {
            throw new Exception("You can't cure the dead");
        }
        health += healValue;
    }

    protected void damage(int damage) throws Exception {
        if (!isAlive()) {
            throw new Exception("Cannot deal damage to a dead person\n");
        }
        if (health <= damage) {
            health = 0;
            return;
        }
        health -= damage;
    }

    private boolean checkAttack(int modAttack) {
        int numberOfThrows = Math.max(modAttack, MINIMUM_DICE_ROLLS);
        for (int i = 0; i < numberOfThrows; i++) {
            int value = ThreadLocalRandom.current().nextInt(
                    MINIMUM_DICE_VALUE, MAXIMUM_DICE_VALUE);
            if (value >= MINIMUM_VALUE_FOR_WIN) {
                return true;
            }
        }
        return false;
    }

    private void validateParam(Integer maxValue, int value) throws Exception {
        if (value < 1
                || maxValue != null && value > maxValue) {
            throw new Exception("Parameters are out of range");
        }
    }

}
