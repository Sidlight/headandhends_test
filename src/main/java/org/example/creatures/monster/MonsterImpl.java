package org.example.creatures.monster;

import org.example.creatures.AbstractCreatures;

public class MonsterImpl extends AbstractCreatures implements Monster {

    public MonsterImpl(int minDamage, int maxDamage, int defense, int attack, int health) throws Exception {
        super(minDamage, maxDamage, defense, attack, health);
    }
}
