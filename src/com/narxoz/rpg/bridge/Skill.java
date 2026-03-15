package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

import java.util.List;
import java.util.Random;

public abstract class Skill {
    protected final String name;
    protected final int baseDamage;
    protected final EffectImplementor effect;

    protected Skill(String name, int baseDamage, EffectImplementor effect) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public EffectImplementor getEffect() {
        return effect;
    }

    public abstract void use(CombatNode attacker, CombatNode target, Random random, List<String> log);
}
