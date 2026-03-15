package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

import java.util.List;
import java.util.Random;

public class AreaSkill extends Skill {
    public AreaSkill(String name, int baseDamage, EffectImplementor effect) {
        super(name, baseDamage, effect);
    }

    @Override
    public void use(CombatNode attacker, CombatNode target, Random random, List<String> log) {
        List<CombatNode> aliveTargets = target.collectAliveLeaves();
        if (aliveTargets.isEmpty()) return;

        log.add(attacker.getName() + " uses " + name + " [" + effect.getName() + "] as AOE");

        for (CombatNode realTarget : aliveTargets) {
            int damage = effect.applyEffect(calculateRawDamage(attacker), attacker, realTarget, random);
            realTarget.takeDamage(damage);

            log.add("  -> " + realTarget.getName() + " takes " + damage + " damage");
        }
    }
}
