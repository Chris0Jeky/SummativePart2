package task1;

public class ObjectBuilder {
    public static SportsPerson buildSportsPerson(String name, String sport, String nation){
        SportsPerson person = new SportsPerson(name, sport, nation);
        return person;
    }

    public static SportsTeam buildSportsTeam(String teamName, String sport, String nation, String teamCaptain){
        SportsTeam team = new SportsTeam(teamName, sport, nation, teamCaptain);
        return team;
    }

    public static SportsAward buildSportsAward(String year, SportsPerson winner, SportsPerson second, SportsPerson third, SportsTeam team){
        SportsAward award = new SportsAward(year, winner, second, third, team);
        return award;
    }

    /*1995|Jonathan Edwards (ENG),Athletics|Frank Bruno (ENG),Boxing|Colin McRae (SCO),Rallying|Ryder Cup team (EU),Golf,Bernard Gallacher
    1996|Damon Hill (ENG),Formula One|Steve Redgrave (ENG),Rowing|Frankie Dettori (ITA),Horse racing|Olympic rowing pairs (UK),Rowing,N/A
    1997|Greg Rusedski (ENG),Tennis|Tim Henman (ENG),Tennis|Steve Redgrave (ENG),Rowing|British & Irish Lions squad (UK),Rugby union,Martin Johnson
*/

    public static SportsAward createSportsAward(String data){
        return null;
    }
}
