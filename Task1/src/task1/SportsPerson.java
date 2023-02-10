package task1;

public class SportsPerson {
    String name;
    String sport;
    String nation;

    SportsPerson(){

    }

    SportsPerson(String name, String sport, String nation){
        this.name = name;
        this.sport = sport;
        this.nation = nation;
    }

    public String getName(){
        return this.name;
    }

    public String getSport(){
        return this.sport;
    }

    public String getNation(){
        return this.nation;
    }

    public String toString(){
        return "Name: " + this.name + " Sport: " + this.sport + " Nation: " + this.nation;
    }
}
