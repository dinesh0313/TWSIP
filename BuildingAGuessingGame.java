package topperworldintership;
import java.util.Random;
import java.util.Scanner;
public class BuildingAGuessingGame {
    
    public static void main(String[] args) {
        /* 
        Create a class game,which allows a user to play "guess the number"
        game once. Game should have folloeing methods:
        1.Constructor to generate the random number
        2.takeUserInput() to take a user input of number
        3.isCorrectNumber() to detect whether the entered by the user is true 
        4.getter and setter for noOfGuesses
        Use properties such as noOfGuesses(int),etc to get this task done!
        */
        System.out.println("Welcome to Guess Number Game");
        System.out.println("");
        System.out.println("You have maximum 5 attemp limit");
        Game g=new Game();
        boolean b=false;
        while(!b)//it executed when it true
        {
        g.takeUserInput();
        b=g.isCorrectNumber();
        }
    }
    
}
class Game
{
    public int number;
    public int inputNumber;
    public int noOfGuesses=0;
    public void setNoOfGuesses(int noOfGuesses)
    { 
        this.noOfGuesses =noOfGuesses;
    }
    public int getNoOfGuesses()
    {
       return noOfGuesses; 
    }
     Game()//system will generate randome number
    {
        Random rand=new Random();
        this.number=rand.nextInt(100);
    }
    void takeUserInput()//it take input from user
    {
        System.out.println("Guess the number in range 1 to 100");
        Scanner sc=new Scanner(System.in);
        inputNumber=sc.nextInt();
    }
    boolean isCorrectNumber()//it check the number is match or not 
    {
        noOfGuesses++;
        if(noOfGuesses>4)
        {
            System.out.println("Oopss.......You exceeded the no. of 5 attemp");
            return true;
        }
        if(inputNumber==number){
            System.out.format("you guessed it right, it was %d\nyou passed it in %d attemps ",number,noOfGuesses);
            System.out.println();
            System.out.println("Game is Over!!");
            return true;
        }
        else if(inputNumber<number)
            System.out.println("number is too less");
        else if(inputNumber>number)
            System.out.println("number is too high");
        return false;
    }
}
