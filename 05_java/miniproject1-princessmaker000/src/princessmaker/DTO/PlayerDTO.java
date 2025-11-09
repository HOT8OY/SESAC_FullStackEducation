package princessmaker.DTO;

public class PlayerDTO {
    // 필드(스텟)
    private static String pricessName;
    private int stamina;
    private int strength;
    private int intelligence;
    private int elegance;
    private int charm;
    private int morality;
    private int politic;
    private int socialSkills;
    private int willpower;
    private int fatigue;

    // getter,setter
    public static String getPricessName() {
        return pricessName;
    }
    public static void setPricessName(String pricessName) {
        PlayerDTO.pricessName = pricessName;
    }
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getElegance() {
        return elegance;
    }
    public void setElegance(int elegance) {
        this.elegance = elegance;
    }
    public int getCharm() {
        return charm;
    }
    public void setCharm(int charm) {
        this.charm = charm;
    }
    public int getMorality() {
        return morality;
    }
    public void setMorality(int morality) {
        this.morality = morality;
    }
    public int getPolitic() {
        return politic;
    }
    public void setPolitic(int politic) {
        this.politic = politic;
    }
    public int getSocialSkills() {
        return socialSkills;
    }
    public void setSocialSkills(int socialSkills) {
        this.socialSkills = socialSkills;
    }
    public int getWillpower() {
        return willpower;
    }
    public void setWillpower(int willpower) {
        this.willpower = willpower;
    }
    public int getFatigue() {
        return fatigue;
    }
    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }
}
