/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

/**
 *
 * @author ADMIN
 */
public class Common {
    
    private static int applicationWidth;
    private static int applicationHeight;
    private static int applicationX;
    private static int applicationY;
    private static double screenWidth;
    private static double screenHeight;
    
    public Common(double screenWidth,double screenHeight,int applicationWidth,int applicationHeight) {
        
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.applicationWidth = applicationWidth;
        this.applicationHeight = applicationHeight;
    }
    
    
    
    
    public void Calculate(){
        applicationX = (int) ((screenWidth - applicationWidth)/2);
        applicationY = (int) ((screenHeight - applicationHeight)/2);
    }
    public static int getApplicationWidth() {
        return applicationWidth;
    }

    public static int getApplicationHeight() {
        return applicationHeight;
    }

    public static int getApplicationX() {
        return applicationX;
    }

    public static int getApplicationY() {
        return applicationY;
    }
    
    
}
