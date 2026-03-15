package com.narxoz.rpg.raid;

import java.util.ArrayList;
import java.util.List;

public class RaidResult {
    private String winner;
    private int rounds;
    private final List<String> log = new ArrayList<>();

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public List<String> getLog() {
        return log;
    }

    public void addLog(String line) {
        log.add(line);
    }
}
