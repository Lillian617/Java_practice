/* Bulls and cows which named 1A2B in chinese. There is a four-digits secret number writen by computer. And the digits are all different.
    這個遊戲的秘密數字為4位數，其中此4個數字皆不相同。
*/

import java.util.Scanner;
import java.util.Random;

public class Bulls_and_Cows{
    public static void main(String[] args){
        boolean play = true;

        // Welcome words
        System.out.println("Welcome to Bulls and Cows!");
        System.out.println("Now we have a 4-digits number with different number in each digits.");

        while(play){
            // Random 4-digits number
            int[] ans = new int[4];
            int count = 0;
            Random r = new Random();

            while(count<4){
                boolean exists = false;
                int n = r.nextInt(10); // 0~9

                // First digit cannot be 0
                if(count == 0 && n == 0){   
                    continue;
                }
                // Each digits are different
                for(int i = 0; i < count; i++){
                    if(n == ans[i]){
                        exists = true;
                        break;
                    }
                }
                if(!exists){
                    ans[count] = n;
                    count++;
                    System.out.print(n);
                }
            }
            System.out.println(" ");

            // Game start!
            System.out.println(" ");
            System.out.println("New game!");
            
            Scanner s = new Scanner(System.in);

            while(true){
                int[] digits = new int[4];
                System.out.println("Please enter your answer: ");
                String inNum = s.next();
                if(inNum.length() != 4){
                    System.out.println("Not a 4-digits number. Please try again.");
                    continue;
                }
                else{
                    for(int i = 0; i < 4; i++){
                        digits[i] = inNum.charAt(i) - '0'; // char turn to num
                    }
                }
                
                // Compare whether input number same as answer
                int A = 0;
                int B = 0;
                for(int i = 0; i < 4; i++){
                    for(int j = 0; j < 4; j++){
                        if(digits[i] == ans[j]){
                            if(i == j){
                                A++;
                            }
                            else{
                                B++;
                            }
                        }
                    }
                }

                // Output result
                if(A == 4){
                    System.out.println("Congratulations! You got the right answer!");
                    break;
                }
                else{
                    System.out.println(A+"A"+B+"B");
                    continue;
                }
            }
            
            while(true){
                System.out.println("Would you want to play again? y/n");
                String in = s.next();
                if(in.equalsIgnoreCase("n")){
                    play = false;
                    System.out.println("Bye~ See you next time!");
                    break;
                }
                else if(in.equalsIgnoreCase("y")){
                    play = true;
                    break;
                }
                else{
                    System.out.println("You must kick the wrong key. Try again~");
                    continue;
                }
            }
        } 
    }
}
