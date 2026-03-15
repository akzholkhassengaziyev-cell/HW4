package com.narxoz.rpg.composite;

public class HeroUnit implements CombatNode {
    private final String name;
    private int hp;
    private final int attackPower;

    public HeroUnit(String name, int hp, int attackPower) {
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
        return indent + "- Hero: " + name +
                " [HP=" + hp + ", ATK=" + attackPower + ", alive=" + isAlive() + "]\n";
    }

    public int getHp() {
        return hp;
    }
}
