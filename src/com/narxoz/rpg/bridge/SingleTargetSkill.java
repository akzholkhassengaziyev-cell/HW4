package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

import java.util.List;
import java.util.Random;

public class SingleTargetSkill extends Skill {
    public SingleTargetSkill(String name, int baseDamage, EffectImplementor effect) {
        super(name, baseDamage, effect);
    }

    @Override
    public void use(CombatNode attacker, CombatNode target, Random random, List<String> log) {
        int damage = effect.applyEffect(baseDamage + attacker.getAttackPower(), attacker, target, random);
        target.takeDamage(damage);
        log.add(attacker.getName() + " uses " + name + " [" + effect.getName() + "] on " + target.getName()
                + " for " + damage + " damage");
    }
}
