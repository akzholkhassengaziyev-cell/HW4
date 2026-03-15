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
        List<CombatNode> leaves = target.collectAliveLeaves();
        for (CombatNode leaf : leaves) {
            int damage = effect.applyEffect(baseDamage + attacker.getAttackPower(), attacker, leaf, random);
            leaf.takeDamage(damage);
            log.add(attacker.getName() + " uses " + name + " [" + effect.getName() + "] on "
                    + leaf.getName() + " for " + damage + " damage");
        }
    }
}
