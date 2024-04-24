public class Team {
    private Player[] players;
    private int total = 0;
    /*Constructor, getter and setter*/
    public Team (int size){
        players = new Player[size];
    }
    private boolean isFull(){
        return (total == players.length);
    }
    private boolean isEmpty(){
        return (total == 0);
    }
    public boolean add(Player player){
        if (isFull()){
            return false;
        }
        else{
            players[total] = player;
            total++;
            return true;
        }
    }
    /*Listing methods*/
    public String listPlayers(){
        if (isEmpty()){
            return "No players";
        }
        else{
            String listofPlayers = "";
            for (int i = 0; i < total; i++){
                listofPlayers += i + ": " + players[i] + "\n";
            }
            return listofPlayers;
        }
    }
    public String listCurrentPlayers(){
        if(isEmpty()){
            return "No players in the team ";
        }
        else{
            String listofPlayers = "";
            for (int i = 0; i < total; i++){
                if (players[i].isCurrentSquadMember())
                    listofPlayers += i + ": " + players[i] + "\n";
            }
            if(listofPlayers.equals("")){
                return "No Players are in our current team";
            }
            else{
                return listofPlayers;
            }
        }
    }
    public String listOfPlayerwithAverageRating() {
        if (isEmpty()) {
            return "No players are in the team";
        } else {
            String listofPlayers = "";
            for (int i = 0; i < total; i++) {
                listofPlayers += i + ": " + players[i].getName() +
                        " " + players[i].getAverage() + "\n";
            }
            return listofPlayers;
        }
    }
    public String listPlayersAboveGivenAverageRating(double rating){
        if (isEmpty()){
            return "No players in the team";
        }else{
            String str = "";
            for (int i = 0; i < total; i++){
                if (players[i].getAverage() > rating)
                    str += i + ": " + players[i] + "\n";
            }
            if (str.equals("")){
                return "No players are higher than: " + rating;
            }else {
                return str;
            }
        }
    }
    /*calculation methods*/
    public Player playerWithLowestAverageRating(){
        if(!isEmpty()){
            Player playerWithLowestAverageRating = players[0];
            for (int i = 1; i < total; i++){
                if(players[i].getAverage() < playerWithLowestAverageRating.getAverage())
                    playerWithLowestAverageRating = players[i];
            }
            return playerWithLowestAverageRating;
        }else{
            return null;
        }
    }
    public Player playerWithHighestAverageRating(){
        if(!isFull()){
            Player playerWithHighestAverageRating = players[0];
            for (int i = 1; i < total; i++){
                if(players[i].getAverage() > playerWithHighestAverageRating.getAverage())
                    playerWithHighestAverageRating = players[i];
            }
            return playerWithHighestAverageRating;
        }else{
            return null;
        }
    }
    public double averageofPlayersAvgRating(){
        if(!isEmpty()){
            double ratingsTotal = 0;
            for (int i = 0; i < total; i++){
                ratingsTotal += players[i].getAverage();
            }
            return ratingsTotal / total;
        }else{
            return -1;
        }
    }
    /*Other methods*/
    public boolean removePlayerFromSquad(int indexToDeRegister){
        if(indexToDeRegister >=0 && indexToDeRegister <total){
            Player foundPlayer = players[indexToDeRegister];
            foundPlayer.setCurrentSquadMember(false);
            return true;
        }
        else return false;
    }
    public boolean addPlayerToSquad(int indexToDeRegister){
        if(indexToDeRegister >=0 && indexToDeRegister <total){
            Player foundPlayer = players[indexToDeRegister];
            foundPlayer.setCurrentSquadMember(true);
            return true;
        }
        else return false;
    }
    public boolean addRatingsToPlayer(int indexToAddRating, int[] ratings){
        Player foundPlayer =players[indexToAddRating];
        if(foundPlayer != null){
            foundPlayer.setPlayerRatings(ratings);
            return true;
        }
        else return false;
    }
}
