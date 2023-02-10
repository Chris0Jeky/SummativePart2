package task1;

import java.awt.*;

public class SportsAward {
    String year;
    SportsPerson winner;
    SportsPerson second;
    SportsPerson third;
    SportsTeam team;

    SportsAward(){

    }

    SportsAward(String year, SportsPerson winner, SportsPerson second, SportsPerson third, SportsTeam team){
        this.year = year;
        this.winner = winner;
        this.second = second;
        this.third = third;
        this.team = team;
    }

    public String getYear(){
        return this.year;
    }

    public SportsPerson getWinner(){
        return this.winner;
    }

    public SportsPerson getSecond(){
        return this.second;
    }

    public SportsPerson getThird(){
        return this.third;
    }

    public SportsTeam getTeam(){
        return this.team;
    }


public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Year: ");
    sb.append(this.year);
    sb.append(" Winner: ");
    sb.append(this.winner);
    sb.append(" Second: ");
    sb.append(this.second);
    sb.append(" Third: ");
    sb.append(this.third);
    sb.append(" Team: ");
    sb.append(this.team);
    return sb.toString();
    }
}
