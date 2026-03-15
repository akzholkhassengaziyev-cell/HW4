package com.narxoz.rpg.raid;

import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.CombatNode;

import java.util.Random;

public class RaidEngine {
    private Random random = new Random(1L);

    public RaidEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public RaidResult runRaid(CombatNode teamA, Skill skillA, CombatNode teamB, Skill skillB) {
        RaidResult result = new RaidResult();
        result.setWinner("TBD");
        result.setRounds(0);
        result.addLog("RaidEngine skeleton");
        return result;
    }
}
