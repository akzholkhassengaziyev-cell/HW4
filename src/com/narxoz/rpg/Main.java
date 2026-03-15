package com.narxoz.rpg;

import com.narxoz.rpg.bridge.*;
import com.narxoz.rpg.composite.*;
import com.narxoz.rpg.raid.RaidEngine;
import com.narxoz.rpg.raid.RaidResult;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HW4: Bridge + Composite ===\n");

        // ===== Composite demo =====
        HeroUnit warrior = new HeroUnit("Warrior", 120, 18);
        HeroUnit mage = new HeroUnit("Mage", 90, 24);
        HeroUnit archer = new HeroUnit("Archer", 100, 20);

        EnemyUnit goblin = new EnemyUnit("Goblin", 80, 15);
        EnemyUnit orc = new EnemyUnit("Orc", 110, 18);
        EnemyUnit lich = new EnemyUnit("Lich", 130, 22);
        EnemyUnit dragon = new EnemyUnit("Dragon", 180, 30);

        PartyComposite alphaParty = new PartyComposite("Alpha Party");
        alphaParty.add(warrior);
        alphaParty.add(mage);

        PartyComposite betaParty = new PartyComposite("Beta Party");
        betaParty.add(archer);

        RaidGroup heroRaid = new RaidGroup("Heroes Raid");
        heroRaid.add(alphaParty);
        heroRaid.add(betaParty);

        PartyComposite monsterFrontline = new PartyComposite("Monster Frontline");
        monsterFrontline.add(goblin);
        monsterFrontline.add(orc);

        RaidGroup monsterCore = new RaidGroup("Monster Core");
        monsterCore.add(lich);
        monsterCore.add(dragon);

        RaidGroup enemyRaid = new RaidGroup("Enemy Raid");
        enemyRaid.add(monsterFrontline);
        enemyRaid.add(monsterCore);

        System.out.println("== Composite structure ==");
        System.out.println(heroRaid.printTree(""));
        System.out.println(enemyRaid.printTree(""));

        // ===== Bridge demo =====
        Skill slashPhysical = new SingleTargetSkill("Slash", 8, new PhysicalEffect());
        Skill slashFire = new SingleTargetSkill("Slash", 8, new FireEffect());

        Skill meteorFire = new AreaSkill("Meteor", 12, new FireEffect());
        Skill meteorShadow = new AreaSkill("Meteor", 12, new ShadowEffect());

        Skill spearPhysical = new SingleTargetSkill("Spear", 10, new PhysicalEffect());
        Skill wavePhysical = new AreaSkill("Shockwave", 6, new PhysicalEffect());

        System.out.println("== Bridge combinations ==");
        System.out.println("Same skill, different effects:");
        System.out.println("- " + slashPhysical.getName() + " + " + slashPhysical.getEffect().getName());
        System.out.println("- " + slashFire.getName() + " + " + slashFire.getEffect().getName());

        System.out.println("Same effect, different skills:");
        System.out.println("- " + spearPhysical.getName() + " + " + spearPhysical.getEffect().getName());
        System.out.println("- " + wavePhysical.getName() + " + " + wavePhysical.getEffect().getName());
        System.out.println();

        // ===== Raid demo =====
        RaidEngine engine = new RaidEngine().setRandomSeed(2026L);
        RaidResult result = engine.runRaid(heroRaid, meteorFire, enemyRaid, meteorShadow);

        System.out.println("== Raid battle log ==");
        for (String line : result.getLog()) {
            System.out.println(line);
        }

        System.out.println();
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Winner: " + result.getWinner());
    }
}
