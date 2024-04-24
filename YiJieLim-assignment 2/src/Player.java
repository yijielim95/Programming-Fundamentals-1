import java.util.Arrays;
import java.util.Objects;

public class Player {
    private String name;
    private int[] ratings;
    private boolean isCurrentSquadMember = false;
    private int playerNumber = 23;
    public Player(String name, int playerNumber, boolean isCurrentSquadMember) {
        setName(name);
        setPlayerNumber(playerNumber);
        setCurrentSquadMember(isCurrentSquadMember);
        ratings = new int[6];
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        if (name.length() > 20) {
            this.name = name.substring(0, 20);
        }
        else {
            this.name = name;
        }

    }
    public void setPlayerNumber(int playerNumber){
        if ((playerNumber >= 1) && (playerNumber <= 23)){
            this.playerNumber = playerNumber;
        }
    }
    public void setPlayerRatings(int[] ratings){
        for (int i = 0; i < ratings.length; i++){
            if ((ratings[i]>=0) && (ratings[i]<=5)){
                this.ratings[i]=ratings[i];
            }else{
                this.ratings[i]=0;
            }
        }
    }
    public boolean isCurrentSquadMember() {
        return isCurrentSquadMember;
    }
    public int[] getRatings() {
        return ratings;
    }
    public String toString(){
        return "Name : " + name +
                ", player number: " + playerNumber +
                ", ratings: " + Arrays.toString(ratings)+
                ", currently in the squad: " + isCurrentSquadMember;
    }
    public int getPlayerNumber(){
        return playerNumber;
    }
    public double getAverage(){
        int ratingsTotal = 0;
        for (int i = 0; i<6; i++){
            ratingsTotal += ratings[i];
        }
        return ratingsTotal/6;
    }
    public void setCurrentSquadMember(boolean isCurrentSquadMember){
        this.isCurrentSquadMember = isCurrentSquadMember;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return isCurrentSquadMember == player.isCurrentSquadMember && playerNumber == player.playerNumber && Objects.equals(name, player.name) && Arrays.equals(ratings, player.ratings);
    }
}
