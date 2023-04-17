package task1;

// methods for creating objects of the SportsPerson, SportsTeam and SportsAward classes from a String
public class ObjectBuilder {
    public static SportsPerson buildSportsPerson(String name, String sport, String nation){
        return new SportsPerson(name, sport, nation);
    }

    public static SportsTeam buildSportsTeam(String teamName, String sport, String nation, String teamCaptain){
        return new SportsTeam(teamName, sport, nation, teamCaptain);
    }

    public static SportsAward buildSportsAward(String year, SportsPerson winner, SportsPerson second, SportsPerson third, SportsTeam team){
        return new SportsAward(year, winner, second, third, team);
    }

    // example of data format
    /*1995|Jonathan Edwards (ENG),Athletics|Frank Bruno (ENG),Boxing|Colin McRae (SCO),Rallying|Ryder Cup team (EU),Golf,Bernard Gallacher
    1996|Damon Hill (ENG),Formula One|Steve Redgrave (ENG),Rowing|Frankie Dettori (ITA),Horse racing|Olympic rowing pairs (UK),Rowing,N/A
    1997|Greg Rusedski (ENG),Tennis|Tim Henman (ENG),Tennis|Steve Redgrave (ENG),Rowing|British & Irish Lions squad (UK),Rugby union,Martin Johnson
*/

    // slicing up the data string into the appropriate fields
    // and creating objects of the SportsPerson, SportsTeam and SportsAward classes
    // and returning an array of objects
    public static Object[] mkArrayOfData(String data){

        String[] fields = data.split("\\|");

        //error handling
        if (fields.length != 5) {
            System.err.println("Invalid data format: " + data);
            return null;
        }

        String year = fields[0];
        String winner = fields[1].split(",")[0];
        String winnerNation = fields[1].split("\\(")[1].split("\\)")[0];
        String winnerSport = fields[1].split(",")[1];
        String second = fields[2].split(",")[0];
        String secondNation = fields[2].split("\\(")[1].split("\\)")[0];
        String secondSport = fields[2].split(",")[1];
        String third = fields[3].split(",")[0];
        String thirdNation = fields[3].split("\\(")[1].split("\\)")[0];
        String thirdSport = fields[3].split(",")[1];
        String team = fields[4].split(",")[0];
        String teamNation = fields[4].split("\\(")[1].split("\\)")[0];
        String teamSport = fields[4].split(",")[1];
        String teamCaptain = fields[4].split(",")[2];

        SportsPerson winnerPerson = buildSportsPerson(winner, winnerSport, winnerNation);
        SportsPerson secondPerson = buildSportsPerson(second, secondSport, secondNation);
        SportsPerson thirdPerson = buildSportsPerson(third, thirdSport, thirdNation);
        SportsTeam teamPerson = buildSportsTeam(team, teamSport, teamNation, teamCaptain);
        SportsAward award = buildSportsAward(year, winnerPerson, secondPerson, thirdPerson, teamPerson);
        return new Object[]{year, winnerPerson, secondPerson, thirdPerson, teamPerson, award};
    }
}
