package CarGame;

import javax.swing.*;
import java.awt.*;

public class TheGame extends JFrame {
    private CardLayout  cardLayout;
    private JPanel contentPanel;
    private JLayeredPane layeredPane;
    public String gameMode;
//    main
    public static void main(String[] args) {
        SwingUtilities.invokeLater( () -> new TheGame());
    }
    public TheGame() {
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        HomePage homePage = new HomePage();
//        باقي الpages


//
        homePage.setButtonAction(e ->{
            String command = e.getActionCommand();
            if("Exit".equals(command)){
               dispose();
            }
        });



        contentPanel.add(homePage, "HomePage"   );

//        باقي الpages
        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.setPreferredSize(new Dimension(800,600));
        layeredPane.add(contentPanel,JLayeredPane.DEFAULT_LAYER);
        contentPanel.setBounds(0,0,800,600);

        setTitle("Car Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        getContentPane().add(layeredPane);
        setVisible(true);


    }

}
