package com.narxoz.rpg.raid;

import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.CombatNode;

import java.util.List;
import java.util.Random;

public class RaidEngine {
    private Random random = new Random(1L);

    public RaidEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public RaidResult runRaid(CombatNode teamA, Skill skillA, CombatNode teamB, Skill skillB) {
        RaidResult result = new RaidResult();
        int round = 0;

        result.addLog("=== RAID START ===");
        result.addLog("Team A: " + teamA.getName());
        result.addLog("Team B: " + teamB.getName());

        while (teamA.isAlive() && teamB.isAlive()) {
            round++;
            result.addLog("");
            result.addLog("-- Round " + round + " --");

            performAttacks(teamA.collectAliveLeaves(), teamB, skillA, result.getLog());
            if (!teamB.isAlive()) {
                break;
            }

            performAttacks(teamB.collectAliveLeaves(), teamA, skillB, result.getLog());
        }

        result.setRounds(round);
        result.setWinner(teamA.isAlive() ? "Team A" : "Team B");
        result.addLog("");
        result.addLog("=== RAID END ===");
        result.addLog("Winner: " + result.getWinner());

        return result;
    }

    private void performAttacks(List<CombatNode> attackers, CombatNode targetTeam, Skill skill, List<String> log) {
        for (CombatNode attacker : attackers) {
            if (!attacker.isAlive()) {
                continue;
            }
            if (!targetTeam.isAlive()) {
                break;
            }

            skill.use(attacker, targetTeam, random, log);
        }
    }
}
