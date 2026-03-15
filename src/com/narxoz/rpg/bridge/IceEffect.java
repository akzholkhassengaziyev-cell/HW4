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
        return baseDamage;
    }
}
