package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

import java.util.Random;

public class FireEffect implements EffectImplementor {
    @Override
    public String getName() {
        return "Fire";
    }

    @Override
    public int applyEffect(int baseDamage, CombatNode attacker, CombatNode target, Random random) {
        return baseDamage;
    }
}
