package CarGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomePage extends JPanel {
    private JButton singlePlayerButton = new JButton("Single Player");
    private JButton multiPlayerButton = new JButton("Multi Player");
    private JButton howToPlayButton = new JButton("How To Play");
    private JButton exitButton = new JButton("Exit");
    private JButton signInButton = new JButton("Sign In");
    private String PlayerName="";
    private Image BackGround;
    public HomePage() {
        BackGround = new ImageIcon("BackGround.jpg").getImage();
        setLayout(null);
        singlePlayerButton.setLocation(300,150);
        multiPlayerButton.setLocation(300,250);
        howToPlayButton.setLocation(300,300);
        signInButton.setLocation(10,10);
        exitButton.setLocation(10,250);

        add(singlePlayerButton);
        add(multiPlayerButton);
        add(howToPlayButton);
        add(signInButton);
        add(exitButton);


    }
    public void setButtonAction(ActionListener actionListener) {
        singlePlayerButton.addActionListener(actionListener);
        multiPlayerButton.addActionListener(actionListener);
        howToPlayButton.addActionListener(actionListener);
        signInButton.addActionListener(actionListener);
        exitButton.addActionListener(actionListener);

    }
    private  JButton createButton(String text){
        JButton button = new JButton(text);
        button.setSize(200, 60);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        return button;

    }
    private  JButton creatExitButton(String text){
        JButton button = new JButton(text);
        button.setSize(100, 40);
        button.setOpaque(true);
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }
    protected  void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (BackGround != null) {
            g.drawImage(BackGround, 0, 0, this.getWidth(), this.getHeight(), this);

        }
    if(!PlayerName.isEmpty()){
        g.setFont(new Font("Arial", Font.BOLD, 18));
        FontMetrics metrics = g.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth("Welcome, " + PlayerName + "!")) / 2;
        int y = metrics.getAscent() + 10;
        g.drawString("Welcome, " + PlayerName + "!", x, y);
      }
    }

    public void showSignInDialog(){
        String name = JOptionPane.showInputDialog(this, "Enter your name:", "Sign In", JOptionPane.PLAIN_MESSAGE);
        if (name != null && !name.trim().isEmpty()) {
            PlayerName = name.trim(); // Update the player's name
            JOptionPane.showMessageDialog(this, "Welcome, " + PlayerName + "!", "Sign In Successful", JOptionPane.INFORMATION_MESSAGE);
            repaint(); // Redraw the panel to show the updated name
        } else {
            JOptionPane.showMessageDialog(this, "You must enter a name to sign in.", "Sign In Failed", JOptionPane.WARNING_MESSAGE);
        }
    }

    }









