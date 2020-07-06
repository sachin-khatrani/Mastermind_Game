/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowEvent;

/**
 *
 * @author ADMIN
 */
public class MasterMind extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    //declare variable
    private JPanel contentPane;
    private JButton startButton,helpButton,exitButton;
    private Common common;
   
    public static void main(String[] args) {
        // TODO code application logic here
        
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
            
                try{     
                    MasterMind masterMindFrame = new MasterMind(800,600);
                    masterMindFrame.setVisible(true);
                                 
                }catch(Exception e){
                    System.err.println("dsfsdfsdf");
                    e.printStackTrace();
                }
            }
        });
    }
    
     MasterMind(int applicationWidth,int applicationHeight){
         
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        common = new Common(screenSize.getWidth(),screenSize.getHeight(),applicationWidth,applicationHeight);
        common.Calculate();
         //get screensize so we display intial frame
        
        
        setBounds(Common.getApplicationX() ,Common.getApplicationY(), applicationWidth, applicationHeight);
        
        setTitle("MasterMind Game");
	//set default close operation
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        contentPane = new JPanel();
        
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	//set ContentPane
	setContentPane(contentPane);
	//set null
	contentPane.setLayout(null);

        startButton = new JButton("START");
        
        startButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                GameScreen gameScreen;
                try {
                    gameScreen = new GameScreen();
                    gameScreen.setVisible(true);
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    gameScreen.setBounds(Common.getApplicationX(), Common.getApplicationY(), applicationWidth, applicationHeight);
                } catch (HeadlessException ex) {
                    Logger.getLogger(MasterMind.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MasterMind.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
            }
            
        });
        
        //set font of the Button
	startButton.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
	//set bounds of the Button
	startButton.setBounds((applicationWidth - 100)/2,(applicationHeight - 220)/2, 100, 50);
        
        helpButton = new JButton("HELP");
        
        helpButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                
            }
            
        });
        
        //set font of the Button
	helpButton.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
	//set bounds of the Button
	helpButton.setBounds((applicationWidth - 100)/2,(applicationHeight - 100)/2, 100, 50);
        
        
        exitButton = new JButton("EXIT");
        
        exitButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                MasterMind.this.processWindowEvent(
                        new WindowEvent(
                                MasterMind.this, WindowEvent.WINDOW_CLOSING));
                             
            }
            
        });
        
        //set font of the Button
	exitButton.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
	//set bounds of the Button
	exitButton.setBounds((applicationWidth - 100)/2,(applicationHeight+20)/2, 100, 50);
	//add Button into contentPane
	contentPane.add(startButton);
        contentPane.add(helpButton);
        contentPane.add(exitButton);
	
    }
    
}
