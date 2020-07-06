package mastermind;

// Java Program to create a message window, shape the window 
// add background color to it and also add 
// glossy appearance to the window by applying per pixel translucency 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
class WinnerScreen extends JFrame{ 
	// window 
	 

	// constructor 
	WinnerScreen(String s) 
	{ 
		// create a window 
                
                setUndecorated(true);
		// set background of window transparent 
		setBackground(Color.CYAN); 
               
		// create a label 
		JLabel l = new JLabel(s); 

		// create a new button 
		JButton menu = new JButton("Menu"); 
                menu.setBounds(Common.getApplicationX() + 270, Common.getApplicationY() + 300,30, 15);
                
                JButton newGame = new JButton("New Game");
                newGame.setBounds(Common.getApplicationX() + 250, Common.getApplicationY() + 150, Common.getApplicationWidth() - 500, Common.getApplicationHeight() - 300);
		// add action listener 
		menu.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       
                       
                       MasterMind masterMind = new MasterMind(800, 600);
                       masterMind.setVisible(true);
                        setVisible(false);
                    }
                }); 
                newGame.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameScreen gameScreen;
                        try {
                            gameScreen = new GameScreen();
                             gameScreen.setVisible(true);
                             // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            gameScreen.setBounds(Common.getApplicationX(), Common.getApplicationY(), Common.getApplicationWidth(), Common.getApplicationHeight());
                            setVisible(false);
                        } catch (HeadlessException ex) {
                            Logger.getLogger(WinnerScreen.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(WinnerScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                    }
                    
                });

		// create a panel 
//		JPanel p = new JPanel() { 
//			public void paintComponent(Graphics g) 
//			{ 
//
//				g.setColor(new Color(100, 100, 240)); 
//				g.fillRoundRect(0, 0, 200, 100, 20, 20); 
//                                
//				g.setColor(new Color(10, 10, 255)); 
//				g.drawRoundRect(0, 0, 200, 100, 20, 20); 
//
//				// create a glossy apperance 
//				for (int i = 0; i < 100; i++) { 
//					g.setColor(new Color(255, 255, 255, i)); 
//					g.drawLine(0, i, 200, i); 
//				} 
//			} 
//		}; 
                JPanel p = new JPanel();
		// create a font 
		Font f = new Font("BOLD", 1, 14); 

		l.setFont(f); 

		// add contents to panel 
		p.add(l); 
		p.add(menu);
                p.add(newGame);

		add(p);

		
	} 
	 
} 
