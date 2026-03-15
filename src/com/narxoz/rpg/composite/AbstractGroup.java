package com.narxoz.rpg.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractGroup implements CombatNode {
    protected final String name;
    protected final List<CombatNode> children = new ArrayList<>();

    protected AbstractGroup(String name) {
        this.name = name;
    }

    public void add(CombatNode node) {
        if (node != null) {
            children.add(node);
        }
    }

    public void remove(CombatNode node) {
        children.remove(node);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<CombatNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public int getAttackPower() {
        int sum = 0;
        for (CombatNode child : children) {
            if (child.isAlive()) {
                sum += child.getAttackPower();
            }
        }
        return sum;
    }

    @Override
    public void takeDamage(int amount) {
        List<CombatNode> alive = collectAliveLeaves();
        if (alive.isEmpty()) return;

        int perTarget = amount / alive.size();
        int remainder = amount % alive.size();

        for (int i = 0; i < alive.size(); i++) {
            int dmg = perTarget + (i < remainder ? 1 : 0);
            alive.get(i).takeDamage(dmg);
        }
    }

    @Override
    public boolean isAlive() {
        for (CombatNode child : children) {
            if (child.isAlive()) return true;
        }
        return false;
    }

    @Override
    public String printTree(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent)
                .append("+ ")
                .append(getClass().getSimpleName())
                .append(": ")
                .append(name)
                .append("\n");

        for (CombatNode child : children) {
            sb.append(child.printTree(indent + "  "));
        }
        return sb.toString();
    }
}
