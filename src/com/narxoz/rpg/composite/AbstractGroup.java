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
        int total = 0;
        for (CombatNode child : children) {
            if (child.isAlive()) {
                total += child.getAttackPower();
            }
        }
        return total;
    }

    @Override
    public void takeDamage(int amount) {
        List<CombatNode> aliveLeaves = collectAliveLeaves();
        if (aliveLeaves.isEmpty()) return;

        int perLeaf = amount / aliveLeaves.size();
        int remainder = amount % aliveLeaves.size();

        for (int i = 0; i < aliveLeaves.size(); i++) {
            int damage = perLeaf + (i < remainder ? 1 : 0);
            aliveLeaves.get(i).takeDamage(damage);
        }
    }

    @Override
    public boolean isAlive() {
        for (CombatNode child : children) {
            if (child.isAlive()) {
                return true;
            }
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
                .append(" [ATK=")
                .append(getAttackPower())
                .append(", alive=")
                .append(isAlive())
                .append("]\n");

        for (CombatNode child : children) {
            sb.append(child.printTree(indent + "  "));
        }
        return sb.toString();
    }
}
