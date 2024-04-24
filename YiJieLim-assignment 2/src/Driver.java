import java.util.Scanner;

public class Driver {
    private Scanner input = new Scanner(System.in);
    private Team team;
    public static void main(String[] args){
        new Driver();
    }
    public Driver(){
        team =new Team(40);
        runMenu();
    }
    private int mainMenu(){
        System.out.println("""
                Team System
                ________________________
                  1) Add a player
                  2) Add player ratings
                  3) Add a player to the squad
                  4) Remove a player from the squad
                  5) List all players
                  6) List the players currently on this season's squad
                  7) List players whose average rating is
                     greater than a given rating
                  8) List the players names with their average rating
                  9) Display average player rating
                  10) Display player with the lowest average rating
                  11) Display player with the highest average rating
                  0) Exit    
                ==>>""");
        int option = input.nextInt();
        return option;
    }

    private void runMenu(){
        int option = mainMenu();

        while (option != 0){

            switch (option){
                case 1 -> addPlayer();
                case 2 -> addPlayerRatings();
                case 3 -> addPlayertoSquad();
                case 4 -> removePlayerFromtheSquad();
                case 5 -> printPlayers();
                case 6 -> printCurrentPlayers();
                case 7 -> printPlayersWithAverageRatingAboveAGivenRating();
                case 8 -> printPlayersWithAverageRating();
                case 9 -> printAveragePlayerRating();
                case 10 -> printPlayersWithLowestAverageRating();
                case 11 -> printPlayersWithHighestAverageRating();
                default -> System.out.println("Invalid option entered: " + option);
            }

            System.out.println("\n Press enter key to continue...");
            input.nextLine();
            input.nextLine();

            option = mainMenu();
        }

        System.out.println("Exiting...bye");
        System.exit(0);
    }
    private void addPlayer(){
        input.nextLine();

        System.out.println("Enter the Player Name: ");
        String playerName = input.nextLine();
        System.out.println("Enter the Player Number: ");
        int playerNumber = input.nextInt();
        System.out.println("Is this product in your current team (y/n): ");
        char currentSquad = input.next().charAt(0);
        boolean isCurrentSquadMember = false;
        if ((currentSquad == 'y') || (currentSquad == 'Y'))
            isCurrentSquadMember = true;

        boolean isAdded = team.add(new Player(playerName, playerNumber, isCurrentSquadMember));
        if (isAdded){
            System.out.println("Player added successfully");
        }
        else{
            System.out.println("No player added");
        }
    }
    private void addPlayerRatings(){
        input.nextLine();
        printPlayers();
        System.out.println("Enter the index number of player to be rated");
        int indexToDeRegister = input.nextInt();
        int[] rating = new int[6];
        for(int i = 0; i<6; i++){
            System.out.println("Enter the rating " + i + ":");
            rating[i] = input.nextInt();
        }
        boolean didAdd = team.addRatingsToPlayer(indexToDeRegister,rating);
        if (didAdd)
            System.out.println("added rating");
        else System.out.println("didn't add");

    }
    private void addPlayertoSquad(){
        printPlayers();
        System.out.println("Enter the index number they wish to add to the squad: ");
        int indexAddPlayertoSquad = input.nextInt();
        boolean didAdded = team.addPlayerToSquad(indexAddPlayertoSquad);
        if(didAdded)
            System.out.println("Added Successfully");
        else System.out.println("Added Unsuccessful");
    }
    private void removePlayerFromtheSquad(){
        printPlayers();
        System.out.println("Enter the index number of the player to wish to remove: ");
        int indexRemovePlayerfromSquad = input.nextInt();
        boolean didRemoved = team.removePlayerFromSquad(indexRemovePlayerfromSquad);
        if(didRemoved)
            System.out.println("Remove Successfully");
        else System.out.println("Remove Unsuccessful");
    }
    private void printPlayers(){
        System.out.println("List of Players are: ");
        System.out.println(team.listPlayers());
    }
    private void printCurrentPlayers(){
        System.out.println("List of Current Players are: ");
        System.out.println(team.listCurrentPlayers());
    }
    private void printPlayersWithAverageRatingAboveAGivenRating(){
        System.out.println("View the players rating higher than the given rating: ");
        double rating = input.nextDouble();
        System.out.println(team.listPlayersAboveGivenAverageRating(rating));
    }
    private void printPlayersWithAverageRating(){
        System.out.println("List of Players with Average Rating are: ");
        System.out.println(team.listOfPlayerwithAverageRating());
    }
    private void printAveragePlayerRating(){
        double averageRatings = team.averageofPlayersAvgRating();
        if (averageRatings != -1){
            System.out.println("The average of players rating is: " + averageRatings);
        }
        else{
            System.out.println("There are no players in the team.");
        }
    }
    private void printPlayersWithLowestAverageRating(){
        Player lowestRanking = team.playerWithLowestAverageRating();
        if(lowestRanking != null){
            System.out.println("The lowest ranking player is: " + lowestRanking.getName());
        }
        else{
            System.out.println("There are no players in the team.");
        }
    }
    private void printPlayersWithHighestAverageRating(){
        Player highestRanking = team.playerWithHighestAverageRating();
        if (highestRanking != null){
            System.out.println("The highest ranking player is: " + highestRanking.getName());
        }
        else{
            System.out.println("There are no players in the team.");
        }
    }
}
