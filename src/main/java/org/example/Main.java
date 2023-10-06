package org.example;

import org.example.creatures.monster.Monster;
import org.example.creatures.monster.MonsterFactory;
import org.example.creatures.player.Player;
import org.example.creatures.player.PlayerImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        Player player = new PlayerImpl(1, 4, 4, 4, 20);
        int monsterCount = 0;
        Monster monster = MonsterFactory.createMonster(monsterCount + 1);
        while (player.isAlive()) {
            player.attack(monster);
            if (monster.isAlive()) {
                monster.attack(player);
            } else {
                monster = MonsterFactory.createMonster(1 + monsterCount++);
            }
        }
        System.out.printf("Player won %d monsters\n", monsterCount);
    }
}