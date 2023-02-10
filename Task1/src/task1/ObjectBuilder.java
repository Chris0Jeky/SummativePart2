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

    public static Object[] createSportsAward(String data){

        int year = Integer.parseInt(data.substring(0, 4));
        String winnerName = data.substring(5, data.indexOf("("));
        String winnerNation = data.substring(data.indexOf("(") + 1, data.indexOf(")"));
        String winnerSport = data.substring(data.indexOf(",") + 1, data.indexOf("|"));
        SportsPerson winner = buildSportsPerson(winnerName, winnerSport, winnerNation);
        String secondName = data.substring(data.indexOf("|") + 1, data.indexOf("(", data.indexOf("|")));
        String secondNation = data.substring(data.indexOf("(", data.indexOf("|")) + 1, data.indexOf(")", data.indexOf("|")));
        String secondSport = data.substring(data.indexOf(",", data.indexOf("|")) + 1, data.indexOf("|", data.indexOf("|") + 1));
        SportsPerson second = buildSportsPerson(secondName, secondSport, secondNation);
        int beginIndex = data.indexOf("|", data.indexOf("|") + 1) + 1;
        int endIndex = data.indexOf("(", data.indexOf("|", data.indexOf("|") + 1));
        String thirdName = data.substring(beginIndex, endIndex);
        String thirdNation = data.substring(endIndex + 1, data.indexOf(")", data.indexOf("|", data.indexOf("|") + 1)));
        String thirdSport = data.substring(data.indexOf(",", data.indexOf("|", data.indexOf("|") + 1)) + 1, data.indexOf("|", beginIndex));
        SportsPerson third = buildSportsPerson(thirdName, thirdSport, thirdNation);
        String teamName = data.substring(data.indexOf("|", beginIndex) + 1, data.indexOf("(", data.indexOf("|", beginIndex)));
        int fromIndex = data.indexOf("|", data.indexOf("|", beginIndex) + 1);
        String teamSport = data.substring(data.indexOf(",", data.indexOf("|", beginIndex)) + 1, fromIndex);
        String teamNation = data.substring(data.indexOf("(", data.indexOf("|", beginIndex) + 1) + 1, data.indexOf(")", data.indexOf("|", beginIndex) + 1));
        String teamCaptain = data.substring(data.indexOf(",", fromIndex) + 1, data.length());
        SportsTeam team = buildSportsTeam(teamName, teamSport, teamNation, teamCaptain);
        SportsAward award = buildSportsAward(Integer.toString(year), winner, second, third, team);
        return new Object[]{award, winner, second, third, team};
    }
}
