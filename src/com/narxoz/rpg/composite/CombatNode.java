package com.narxoz.rpg.composite;

import java.util.ArrayList;
import java.util.List;

public interface CombatNode {
    String getName();
    int getAttackPower();
    void takeDamage(int amount);
    boolean isAlive();
    String printTree(String indent);

    default List<CombatNode> getChildren() {
        return List.of();
    }

    default List<CombatNode> collectAliveLeaves() {
        List<CombatNode> result = new ArrayList<>();
        if (getChildren().isEmpty()) {
            if (isAlive()) {
                result.add(this);
            }
            return result;
        }

        for (CombatNode child : getChildren()) {
            result.addAll(child.collectAliveLeaves());
        }
        return result;
    }
}
