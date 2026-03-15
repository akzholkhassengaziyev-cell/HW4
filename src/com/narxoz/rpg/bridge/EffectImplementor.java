package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

import java.util.Random;

public interface EffectImplementor {
    String getName();
    int applyEffect(int baseDamage, CombatNode attacker, CombatNode target, Random random);
}
