import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class BuyView extends JFrame{
   private JFrame mainFrame;
   private JButton buyButtons[];

   public BuyView() {
      

      // shows the type of farmer types to buy 
      JPanel[] farmerTypes = new JPanel[3];
      this.buyButtons = new JButton[3];
      for (int i = 0; i < buyButtons.length; i++){
        this.buyButtons[i] = new JButton("Buy");
      }
      for (int i = 0; i < farmerTypes.length; i++){
        farmerTypes[i] = new JPanel(new GridLayout(8,1, 10, 0));
      }

      farmerTypes[0].add(new JLabel("Registered Farmer"));
      farmerTypes[0].add(new JLabel("Cost: 200 ObjectCoins"));
      farmerTypes[0].add(new JLabel("Level Requirement : 5"));
      farmerTypes[0].add(new JLabel("Bonus Earnings per Produce : +1"));
      farmerTypes[0].add(new JLabel("Seed Cost Reduction : -1"));
      farmerTypes[0].add(new JLabel("Water Bonus Limit Increase : +0"));
      farmerTypes[0].add(new JLabel("Fertilizer Bonus Limit Increase : +0"));
      farmerTypes[0].add(buyButtons[0]);

      farmerTypes[1].add(new JLabel("Distinguished Farmer"));
      farmerTypes[1].add(new JLabel("Cost : 300 ObjectCoins"));
      farmerTypes[1].add(new JLabel("Level Requirement : 10"));
      farmerTypes[1].add(new JLabel("Bonus Earnings per Produce : +2"));
      farmerTypes[1].add(new JLabel("Seed Cost Reduction : -2"));
      farmerTypes[1].add(new JLabel("Water Bonus Limit Increase : +1"));
      farmerTypes[1].add(new JLabel("Fertilizer Bonus Limit Increase : +0"));
      farmerTypes[1].add(buyButtons[1]);

      farmerTypes[2].add(new JLabel("Legendary Farmer"));
      farmerTypes[2].add(new JLabel("Cost 400 ObjectCoins"));
      farmerTypes[2].add(new JLabel("Level Requirement : 15"));
      farmerTypes[2].add(new JLabel("Bonus Earnings per Produce : +4"));
      farmerTypes[2].add(new JLabel("Seed Cost Reduction : -3"));
      farmerTypes[2].add(new JLabel("Water Bonus Limit Increase : +2"));
      farmerTypes[2].add(new JLabel("Fertilizer Bonus Limit Increase : +1"));
      farmerTypes[2].add(buyButtons[2]);




      

     this.mainFrame = new JFrame("Buy Farmer Types");
     this.mainFrame.setLayout(new GridLayout(1, 3));
     this.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.mainFrame.setSize(900,500);
     for (int i = 0; i < farmerTypes.length; i++){
      this.mainFrame.add(farmerTypes[i]);
    }
     this.mainFrame.setResizable(false);
     this.mainFrame.setVisible(true);


   }

   public void setRegisteredBtnActionListener(ActionListener listener){
    this.buyButtons[0].addActionListener(listener);
   }

    public void setDistinguishedBtnActionListener(ActionListener listener){
      this.buyButtons[1].addActionListener(listener);
    }

    public void setLegendaryBtnActionListener(ActionListener listener){
      this.buyButtons[2].addActionListener(listener);
    }

    public void disableButtons(int index) {
      this.buyButtons[index].setEnabled(false);
    }
}
