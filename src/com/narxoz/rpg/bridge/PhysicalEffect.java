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
        return baseDamage;
    }
}
