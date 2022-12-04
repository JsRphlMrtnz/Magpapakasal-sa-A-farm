import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class BuyView extends JFrame{
   private JFrame mainFrame;
   private JButton buyButtons[];

   public BuyView() {
      

      // shows the type of farmer types to buy 
      JPanel[] farmerTypes = new JPanel[3];
      for (int i = 0; i < farmerTypes.length; i++){
        farmerTypes[i] = new JPanel(new GridLayout(6,1));
      }
      
      farmerTypes[0].add(new JLabel("Registered Farmer = 200 ObjectCoins"));
      farmerTypes[0].add(new JLabel("Level Requirement : 5"));
      farmerTypes[0].add(new JLabel("Bonus Earnings per Produce : +1"));
      farmerTypes[0].add(new JLabel("Seed Cost Reduction : -1"));
      farmerTypes[0].add(new JLabel("Water Bonus Limit Increase : +0"));
      farmerTypes[0].add(new JLabel("Fertilizer Bonus Limit Increase : +0"));

      farmerTypes[1].add(new JLabel("Distinguished Farmer = 300 ObjectCoins"));
      farmerTypes[1].add(new JLabel("Level Requirement : 10"));
      farmerTypes[1].add(new JLabel("Bonus Earnings per Produce : +2"));
      farmerTypes[1].add(new JLabel("Seed Cost Reduction : -2"));
      farmerTypes[1].add(new JLabel("Water Bonus Limit Increase : +1"));
      farmerTypes[1].add(new JLabel("Fertilizer Bonus Limit Increase : +0"));

      farmerTypes[2].add(new JLabel("Legendary Farmer = 400 ObjectCoins"));
      farmerTypes[2].add(new JLabel("Level Requirement : 15"));
      farmerTypes[2].add(new JLabel("Bonus Earnings per Produce : +4"));
      farmerTypes[2].add(new JLabel("Seed Cost Reduction : -3"));
      farmerTypes[2].add(new JLabel("Water Bonus Limit Increase : +2"));
      farmerTypes[2].add(new JLabel("Fertilizer Bonus Limit Increase : +1"));



      // holds all the farmer type panels only
      JPanel farmerTypePanels = new JPanel(new GridLayout(1,3));
      for(int i = 0; i < farmerTypes.length; i++){
        farmerTypePanels.add(farmerTypes[i]);
      }

      // holds all the buy buttons
      JPanel buyPanel = new JPanel(new GridLayout(1,3));
      this.buyButtons = new JButton[3];

      for (int i = 0; i < buyButtons.length; i++){
        this.buyButtons[i] = new JButton("Buy");
         buyPanel.add(this.buyButtons[i]);
      }



      

     this.mainFrame = new JFrame("Buy Farmer Types");
     this.mainFrame.setLayout(new BorderLayout(10, 10));
     this.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.mainFrame.setSize(1500,1000);
     this.mainFrame.setResizable(false);
     this.mainFrame.setVisible(true);

     this.mainFrame.add(farmerTypePanels, BorderLayout.CENTER);
     this.mainFrame.add(buyPanel, BorderLayout.SOUTH);

     this.mainFrame.setVisible(true);

   }

}
