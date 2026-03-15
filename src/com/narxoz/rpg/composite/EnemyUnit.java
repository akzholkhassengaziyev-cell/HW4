package com.narxoz.rpg.composite;

public class EnemyUnit implements CombatNode {
    private final String name;
    private int hp;
    private final int attackPower;

    public EnemyUnit(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAttackPower() {
        return isAlive() ? attackPower : 0;
    }

    @Override
    public void takeDamage(int amount) {
        hp -= Math.max(0, amount);
        if (hp < 0) hp = 0;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String printTree(String indent) {
        return indent + "- EnemyUnit: " + name + " [HP=" + hp + ", ATK=" + attackPower + "]\n";
    }

    public int getHp() {
        return hp;
    }
}
