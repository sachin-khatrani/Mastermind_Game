/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;
import java.awt.*;  
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import sun.net.www.content.image.jpeg;

/**
 *
 * @author ADMIN
 */
public class GameScreen extends JFrame{

 
    
    private JLabel label,correctPosition,correctNumber;
    private JTextField textField,positionTextField,numberTextField;
    private JPanel contentPane;
    private Model model;
    private JLabel result;
    private int health = 9;
    private JButton back;
    private static ImagePanel jPanel1;
    ImagePanel[] arr = new ImagePanel[10];
    public GameScreen() throws HeadlessException, IOException {
        
        
        model = new Model();
        
        CreateGui();
    }
    
    public void check(){
        
        String s = textField.getText();
        
        if(s.length() == 4){
            int flag = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    
                }else{
                    flag = 1;
                }
            }
            
            if(flag == 1){
                textField.setText("Enter Valid Number");
            }else{
                int userNumber = Integer.parseInt(s);
                int correct_position = model.checkPosition(userNumber);
                int correct_number = model.checkNumber(userNumber);
                
                positionTextField.setVisible(true);
                numberTextField.setVisible(true);
                positionTextField.setText(Integer.toString(correct_position));
                numberTextField.setText(Integer.toString(correct_number));
                
                if(correct_position == 4){

                    setEnabled(false);
                    setVisible(false);
                     WinnerScreen winnerScreen = new WinnerScreen("You Are Win!!!!");
                    winnerScreen.setVisible(true);
                    winnerScreen.setBounds(Common.getApplicationX() + 250, Common.getApplicationY() + 150, Common.getApplicationWidth() - 500, Common.getApplicationHeight() - 300);
                }else if(health == 0){
                    setEnabled(false);
                    setVisible(false);
                    WinnerScreen winnerScreen = new WinnerScreen("You Are Loss!!!!");
                    winnerScreen.setVisible(true);
                    winnerScreen.setBounds(Common.getApplicationX() + 250, Common.getApplicationY() + 150, Common.getApplicationWidth() - 500, Common.getApplicationHeight() - 300);
                }
                
                 arr[health].loadImage("E:\\education\\Lab_Manuals\\MasterMind\\src\\mastermind\\assets\\images.png");
                health-=1;
            }
        }else{
            textField.setText("Enter Valid Number");
        }
    }
    
    
    
    void CreateGui() throws IOException{
        
        contentPane = new JPanel();
        setUndecorated(true);
        setBackground(Color.lightGray);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	//set ContentPane
	setContentPane(contentPane);
	//set null
	contentPane.setLayout(null);
       
        
        
        int var = 200;
        for(int i=0;i<10;i++){
            jPanel1 = new ImagePanel();
            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1260, Short.MAX_VALUE)
            );
           jPanel1.setBounds((Common.getApplicationWidth() - var)/2,(Common.getApplicationHeight() - 560)/2, 40, 40);
           var-=100;
            contentPane.add(jPanel1);
            arr[i] = jPanel1;
        }
        
        BufferedImage image = ImageIO.read(new File("E:\\education\\Lab_Manuals\\MasterMind\\src\\mastermind\\assets\\back.jpg"));

        
        Image dimg = image.getScaledInstance(60, 60,Image.SCALE_SMOOTH);
        back = new JButton(new ImageIcon(dimg));
       
        back.setBounds((Common.getApplicationWidth() - 760)/2,(Common.getApplicationHeight() - 560)/2, 60 , 60);
        
        
        back.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    MasterMind masterMind = new MasterMind(800, 600);
                       masterMind.setVisible(true);
                       
            }
        });
        label = new JLabel("Enter 4 Digit Guess Number");
        label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        label.setBounds((Common.getApplicationWidth() - 340)/2,(Common.getApplicationHeight() - 320)/2, 340, 50);
        
        correctPosition = new JLabel("Number Of Correct Position");
        correctPosition.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        correctPosition.setBounds((Common.getApplicationWidth() - 780),(Common.getApplicationHeight() - 320), 340, 50);
        
        
        correctNumber = new JLabel("Number Of Correct Number");
        correctNumber.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        correctNumber.setBounds((Common.getApplicationWidth() - 390),(Common.getApplicationHeight() - 320), 340, 50);
        
        
        textField = new JTextField();
        textField.setBounds((Common.getApplicationWidth() - 240)/2,(Common.getApplicationHeight() - 200)/2, 250, 50);
        textField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        
        textField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });
        
        BasicArrowButton basicArrowButton = new BasicArrowButton(BasicArrowButton.NORTH);
        
        positionTextField = new JTextField();
        positionTextField.setBounds((Common.getApplicationWidth() - 650),(Common.getApplicationHeight() - 250), 100, 50);
        positionTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        positionTextField.setText("0");
        positionTextField.setEditable(false);
        positionTextField.setBackground(Color.DARK_GRAY);
        positionTextField.setBorder(new EmptyBorder(5, 5, 5, 5));
        positionTextField.setForeground(Color.white);
        positionTextField.setVisible(false);
        
        
        numberTextField = new JTextField();
        numberTextField.setBounds((Common.getApplicationWidth() - 280),(Common.getApplicationHeight() - 250), 100, 50);
        numberTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        numberTextField.setText("0");
        numberTextField.setEditable(false);
        numberTextField.setBackground(Color.DARK_GRAY);
        numberTextField.setBorder(new EmptyBorder(5, 5, 5, 5));
        numberTextField.setForeground(Color.white);
        numberTextField.setVisible(false);
        
//        String fileName = "images.png";
//        ImageIcon icon = new ImageIcon(fileName);
//        JLabel label1 = new JLabel(icon);
//        contentPane.add(label1);
        contentPane.add(back);
        contentPane.add(label);
        contentPane.add(textField);
        contentPane.add(correctPosition);
        contentPane.add(numberTextField);
        contentPane.add(correctNumber);
        contentPane.add(positionTextField);
        contentPane.add(basicArrowButton);
        
    }
    
    
    
    
}


class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
        this.loadImage("E:\\education\\Lab_Manuals\\MasterMind\\src\\images.png");
    }

    public void loadImage(String filename) {
         try {
          this.image = ImageIO.read(new File(filename));
          this.repaint();
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
            if (image != null) {
            // Scale it by width
            int scaledWidth = (int)((image.getWidth() * getHeight()/image.getHeight()));
            // If the image is not off the screen horizontally...
            if (scaledWidth < getWidth()) {
                // Center the left and right destination x coordinates.
                int leftOffset = getWidth() / 2 - scaledWidth / 2;
                int rightOffset = getWidth() / 2 + scaledWidth / 2;
                g.drawImage(image, leftOffset, 0, rightOffset, getHeight(), 0, 0, image.getWidth(), image.getHeight(), null);
            }
            // Otherwise, the image width is too much, even scaled
            // So we need to center it the other direction
            else {
                int scaledHeight = (image.getHeight() * getWidth()) / image.getWidth();
                int topOffset = getHeight() / 2 - scaledHeight / 2;
                int bottomOffset = getHeight() / 2 + scaledHeight / 2;
                g.drawImage(image, 0, topOffset, getWidth(), bottomOffset, 0, 0, image.getWidth(), image.getHeight(), null);
            }
        }
    }
}