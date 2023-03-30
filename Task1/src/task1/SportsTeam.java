package task1;

public class SportsTeam {
    private String teamName;
    private String sport;
    private String nation;
    private String teamCaptain;

    SportsTeam(){

    }

    SportsTeam(String teamName, String sport, String nation, String teamCaptain){
        this.teamName = teamName;
        this.sport = sport;
        this.nation = nation;
        this.teamCaptain = teamCaptain;
    }

    public String getTeamName(){
        return this.teamName;
    }

    public String getSport(){
        return this.sport;
    }

    public String getNation(){
        return this.nation;
    }

    public String getTeamCaptain(){
        return this.teamCaptain;
    }

    public String toString(){
        return "Team Name: " + this.teamName + " Sport: " + this.sport + " Nation: " + this.nation + " Team Captain: " + this.teamCaptain;
    }

}
