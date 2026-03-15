package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

import java.util.Random;

public class ShadowEffect implements EffectImplementor {
    @Override
    public String getName() {
        return "Shadow";
    }

    @Override
    public int applyEffect(int baseDamage, CombatNode attacker, CombatNode target, Random random) {
        int critChance = random.nextInt(100);
        if (critChance < 25) {
            return Math.max(1, baseDamage * 2);
        }
        return Math.max(1, baseDamage);
    }
}
