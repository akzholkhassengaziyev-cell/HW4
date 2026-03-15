package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

import java.util.Random;

public class IceEffect implements EffectImplementor {
    @Override
    public String getName() {
        return "Ice";
    }

    @Override
    public int applyEffect(int baseDamage, CombatNode attacker, CombatNode target, Random random) {
        int reduction = 2 + random.nextInt(4); // 2..5
        return Math.max(1, baseDamage - reduction);
    }
}
