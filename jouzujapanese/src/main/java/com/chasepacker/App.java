package com.chasepacker;

import com.chasepacker.ConjugationCode.*;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void print(String s)
    {
        System.out.println(s);
    }


    public static void main(String[] args )
    {

        boolean endProgram = false;

        print("*****************************************************");
        print("Welcome to the Jouzu Japanese Conjugation Practice Text-Based Application!\n");

        while(!endProgram)
        {
            
            
            print("*****************************************************");
            print("Please select the type of Practice you would like to practice:");
            print("1. Verb Conjugation Practice");
            print("2. Adjective Conjugation Practice");
            print("3. End Program");
            print("*****************************************************");

            Scanner scanner = new Scanner(System.in);

            int choice = 0;

            try{

                switch(scanner.nextInt())
                {
                    case 1:
                        VerbConjugationPractice verbPractice = new VerbConjugationPractice();
                        verbPractice.startPractice();
                        break;
                    case 2:
                        AdjectiveConjugationPractice adjPractice = new AdjectiveConjugationPractice();
                        adjPractice.startPractice();
                        break;
                    case 3:
                        endProgram = true;
                        break;
                    default:
                        print("Error: Please enter a valid integer");
                        break;
                }

            }
            catch(InputMismatchException e)//In case User doesn't give an integer
            {
                print("Error: Plese enter a valid integer");
            }
        }
      
    }
}
