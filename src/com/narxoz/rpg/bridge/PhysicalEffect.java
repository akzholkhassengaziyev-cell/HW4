package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

import java.util.Random;

public class PhysicalEffect implements EffectImplementor {
    @Override
    public String getName() {
        return "Physical";
    }

    @Override
    public int applyEffect(int baseDamage, CombatNode attacker, CombatNode target, Random random) {
        double modifier = 0.9 + random.nextDouble() * 0.2; // 0.9..1.1
        return Math.max(1, (int) Math.round(baseDamage * modifier));
    }
}
