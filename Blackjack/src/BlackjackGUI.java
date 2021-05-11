import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BlackjackGUI extends Blackjack implements ActionListener {
    
    public static void main(String[] args)
    {
        JButton bHit,bStand,bPlay,bStop;
        JLabel playerDisp,dealerDisp;
        JTextArea ruleDisp;
        JFrame f = new JFrame();
        f.setTitle("Blackjack");
        f.setSize(1000,1000);
        f.setLayout(null);
        bHit = new JButton("Hit");
        bStand = new JButton("Stand");
        bPlay = new JButton("New Game");
        bStop = new JButton("Stop playing");
        playerDisp = new JLabel();
        dealerDisp = new JLabel();
        ruleDisp = new JTextArea("the goal is to get to 21 points" 
        +"\n"+"you’ll be dealt two cards face up."
        +"\n"+" From here you’ve got two options:" 
        +"\n"+"If you want another card to try and"
        +"\n"+"get you closer to 21, you ‘Hit’"
        +"\n"+"To stick with what you’ve got, you \"Stand\"");
        bHit.setBounds(400, 850, 100, 50);
        bStand.setBounds(500, 850, 100, 50);
        bPlay.setBounds(850, 425, 100, 50);
        bStop.setBounds(850, 525, 100, 50);
        playerDisp.setBounds(400,750,200,50);
        dealerDisp.setBounds(400, 150, 200, 100);
        ruleDisp.setBounds(50, 455,250,90);
        ruleDisp.setEditable(false);
        ruleDisp.setFont(new Font("Arial",Font.PLAIN,12));
        f.add(bHit);
        f.add(bStand);
        f.add(bPlay);
        f.add(bStop);
        f.add(playerDisp);
        f.add(dealerDisp);
        f.add(ruleDisp);
        f.setVisible(true);
        setup();
        newGame();
        ActionListener hit = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                deal(playerHand);
                playerDisp.setText("hand: " + displayPlayer());
              }
        };
        ActionListener stop = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        };
        bHit.addActionListener(hit);
        

        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    
    
}
