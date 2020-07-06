/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.Random;


/**
 *
 * @author ADMIN
 */
public class Model {
    
    private int[] randomNumber;
    Random rand = new Random(); 

    Model(){
        randomNumber = new int[4];
        generateRandomNumber();
    }
 
    public void generateRandomNumber(){
        
        for(int i=0;i<4;i++){
            randomNumber[i] = getNumber();
        }
        System.out.println("------------------------------------------");
        System.out.println(randomNumber[0] + " " + randomNumber[1] + " " + randomNumber[2] + " " + randomNumber[3]);
        System.out.println("------------------------------------------");
    }
    
    public int getNumber(){
        int num, i=0, count1;
        int[] d = new int[100];

        for(; ;)
        {
            num = (rand.nextInt(10) % 6) + 1;
            if(d[num]!=5)
            {
                d[num]=5;
                return num;
            }
        }
    }
    public int checkPosition(int number){
        
        int[] userNumber = new int[4];
        int i = 3,count1=0;
        while(number!=0){
            userNumber[i] = number%10;
            number = number/10;
            i--;
        }
        
        for(i=0 ; i<4 ; i++)
        {
            if(randomNumber[i]==userNumber[i])
		count1++;
        }
        return count1;
        
    }
    
    public int checkNumber(int number){
        
        int[] userNumber = new int[4];
        int i = 3,count1=0;
        while(number!=0){
            userNumber[i] = number%10;
            number = number/10;
            i--;
        }
        
        for(i=0 ; i<4 ; i++)
        {
            for(int j=0 ; j<4; j++)
            {
		if(userNumber[j]==randomNumber[j])		
                    continue;

		if(userNumber[i]==randomNumber[j])
                    count1++;
            }
        }
        return count1;
    }
}
