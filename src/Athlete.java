//Hannah Bernthal
public class Athlete extends Person {
    private String sport;
    private String level;

    public Athlete(String firstName, String lastName, String phoneNumber, String sport, String level) {
        super (firstName, lastName, phoneNumber);
        this.sport = sport;
        this.level = level;
    }

    //These are the getter and setter methods.
    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    //This toString() returns the athletes's first name, last name, and phone number calling the person's toString() with super.
    //It also returns the sport and level.
    @Override
    public String toString() {
        return super.toString() + " Sport: " + level + " " + sport;
    }
}
