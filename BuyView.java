import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class BuyView extends JFrame{
   private JFrame mainFrame;
   private JButton buyButtons[];

   public BuyView() {
      JLabel[] backgrounds = new JLabel[3];
      JPanel[] farmerTypes = new JPanel[3];
      this.buyButtons = new JButton[3];
      for (int i = 0; i < 3; i++){
        farmerTypes[i] = new JPanel(new GridLayout(8,1, 0, 0));
        backgrounds[i] = new JLabel(new ImageIcon(new ImageIcon("assets/woodBg.jpg").getImage().getScaledInstance(300,540, Image.SCALE_DEFAULT)));
        this.buyButtons[i] = new JButton(new ImageIcon(new ImageIcon("assets/buyPic.jpg").getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT)));
      }
      backgrounds[0].setBounds(0,0,290,530);
      backgrounds[1].setBounds(295,0,290,530);
      backgrounds[2].setBounds(595,0,290,530);


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

      farmerTypes[0].setBounds(0,0,290,476);
      farmerTypes[1].setBounds(296,0,290,476);
      farmerTypes[2].setBounds(596,0,290,476);

      farmerTypes[0].setBackground(new Color(0,0,0,0));
      farmerTypes[1].setBackground(new Color(0,0,0,0));
      farmerTypes[2].setBackground(new Color(0,0,0,0));
      
     this.mainFrame = new JFrame("Buy Farmer Types");
     this.mainFrame.setLayout(null);
     this.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.mainFrame.setSize(900,500);

     for (int i = 0; i < farmerTypes.length; i++){
        this.mainFrame.add(farmerTypes[i]);
        this.mainFrame.add(backgrounds[i]);
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
