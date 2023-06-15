package core.java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class A {


    private static String getJsonFromUrl(String url) throws IOException {
        StringBuilder jsonContent = new StringBuilder();
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
        } finally {
            connection.disconnect();
        }

        return jsonContent.toString();
    }


    private static int getTotalGoalsForTeam(FootballSession footballSession, String teamKey) {
        int totalGoals = 0;

        for (Round round : footballSession.getRounds()) {
            for (Match match : round.getMatches()) {
                if (match.getTeam1().getKey().equals(teamKey)) {
                    totalGoals += match.getScore1();
                }
                if (match.getTeam2().getKey().equals(teamKey)) {
                    totalGoals += match.getScore2();
                }
            }
        }

        return totalGoals;
    }
}

class FootballSession {
    private String name;
    private Round[] rounds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Round[] getRounds() {
        return rounds;
    }

    public void setRounds(Round[] rounds) {
        this.rounds = rounds;
    }

    @Override
    public String toString() {
        return "FootballSession{" + "name='" + name + '\'' + ", rounds=" + Arrays.toString(rounds) + '}';
    }
}

class Round {
    private String name;
    private Match[] matches;

    // Add getters and setters for the fields

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Match[] getMatches() {
        return matches;
    }

    public void setMatches(Match[] matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        return "Round{" + "name='" + name + '\'' + ", matches=" + Arrays.toString(matches) + '}';
    }
}

class Match {
    private String date;
    private Team team1;
    private Team team2;
    private int score1;
    private int score2;

    // Add getters and setters for the fields

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    @Override
    public String toString() {
        return "Match{" + "date='" + date + '\'' + ", team1=" + team1 + ", team2=" + team2 + ", score1=" + score1 + ", score2=" + score2 + '}';
    }
}

class Team {
    private String key;
    private String name;
    private String code;

    // Add getters and setters for the fields

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Team{" + "key='" + key + '\'' + ", name='" + name + '\'' + ", code='" + code + '\'' + '}';
    }
}
