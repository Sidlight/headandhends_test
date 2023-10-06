package org.example.creatures.monster;

public class MonsterFactory {

    private static final double MIN_DAMAGE_MODIFIER = 1;
    private static final double MAX_DAMAGE_MODIFIER = 2;
    private static final double DEFENCE_MODIFIER = 1;
    private static final double ATTACK_MODIFIER = 1.2;
    private static final double HEALTH_MODIFIER = 5;

    public static Monster createMonster(int lvl) throws Exception {
        if (lvl < 1) {
            throw new Exception("Level must be >= 1");
        }
        return new MonsterImpl((int) (lvl * MIN_DAMAGE_MODIFIER),
                (int) (lvl * MAX_DAMAGE_MODIFIER),
                (int) (lvl * DEFENCE_MODIFIER),
                (int) (lvl * ATTACK_MODIFIER),
                (int) (lvl * HEALTH_MODIFIER));
    }

}
