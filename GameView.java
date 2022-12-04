import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;
import java.awt.Dimension;

import java.util.Arrays;

public class GameView {
    private JFrame mainFrame;

    //top
    private JPanel topArea; // puts playerArea and seedArea together

    
    private JPanel playerArea;//PlayerArea = includes player info(name,level,objectCoins,farmerPic) 
    private JPanel playerInfo;
    private JPanel toolArea;
    private JLabel farmerPic, name, level, objectCoins;
    private JButton farmerType;
    
    /*tools on top */
    private JButton[] tools; //harvest, plow, wateringCan, fertilizer, pickaxe, shovel


    //right
    private JPanel seedArea;
    private JButton[] seeds;//turnip, carrot, potato, rose, tulips, sunflower, mango, apple


    //middle
    private JPanel tileArea;
    private JButton[] tiles;
    private JPopupMenu popupMenu[];
    private JMenuItem tileStatus[];
    
    


    
    public GameView(String name){

      //all about the player
      this.farmerPic = new JLabel();
      this.farmerPic.setBorder(BorderFactory.createLineBorder(Color.black));

      this.farmerPic.setIcon(new ImageIcon("farmer.png"));


      this.farmerPic.setMinimumSize(new Dimension(50, 100));
      this.farmerPic.setMaximumSize(new Dimension(50, 100));
      this.name = new JLabel(name);
      this.level =  new JLabel("Level 1");
      this.farmerType = new JButton("Farmer");
      this.objectCoins = new JLabel("ObjectCoins: 0");

      // holds player info
      this.playerInfo = new JPanel(new GridLayout(4,0));
      this.playerInfo.setMaximumSize(new Dimension(100, 100));
      this.playerInfo.setMinimumSize(new Dimension(100, 100));
      this.playerInfo.add(this.name);
      this.playerInfo.add(this.level);
      this.playerInfo.add(this.objectCoins);
      this.playerInfo.add(this.farmerType);

      // hold player info and picture
      this.playerArea = new JPanel(new GridLayout(0,2));
      this.playerArea.setMaximumSize(new Dimension(150, 100));
      this.playerArea.setMinimumSize(new Dimension(150, 100));
      this.playerArea.add(this.farmerPic);
      this.playerArea.add(this.playerInfo);


      //holds only tools
      this.toolArea = new JPanel(new GridLayout(1,6));
      this.toolArea.setBorder(BorderFactory.createLineBorder(Color.black));
      this.toolArea.setMaximumSize(new Dimension(1150, 100));
      this.toolArea.setMinimumSize(new Dimension(1150, 100));
      this.tools = new JButton[6];
      this.tools[0] = new JButton("Harvest");
      this.tools[1] = new JButton("Plow");
      this.tools[2] = new JButton("Watering Can");
      this.tools[3] = new JButton("Fertilizer");
      this.tools[4] = new JButton("Pickaxe");
      this.tools[5] = new JButton("Shovel");
      

      // toolArea
      for(int i = 0; i < this.tools.length; i++){
        this.toolArea.add(this.tools[i]);
      }

      //topArea holds tools and player info
      this.topArea = new JPanel(new BorderLayout());
      this.topArea.setMaximumSize(new Dimension(1300,100));
      this.topArea.setMinimumSize(new Dimension(1300,50));
      this.topArea.setBounds(0,0, 1300,100);
      this.topArea.setBorder(BorderFactory.createLineBorder(Color.black));
      this.topArea.add(this.playerArea, BorderLayout.WEST);
      this.topArea.add(this.toolArea, BorderLayout.CENTER);
      

      //all about the seeds
      this.seeds = new JButton[8];
      this.seeds[0] = new JButton("Turnip");
      this.seeds[1] = new JButton("Carrot");
      this.seeds[2] = new JButton("Potato");
      this.seeds[3] = new JButton("Rose");
      this.seeds[4] = new JButton("Tulips");
      this.seeds[5] = new JButton("Sunflower");
      this.seeds[6] = new JButton("Mango");
      this.seeds[7] = new JButton("Apple");
      

      // holds the seeds
      this.seedArea = new JPanel();
      this.seedArea.setBorder(BorderFactory.createLineBorder(Color.black));
      this.seedArea.setLayout(new BoxLayout(this.seedArea, BoxLayout.Y_AXIS));
      this.seedArea.setBounds(0,0, 300, 990);
      this.seedArea.setMinimumSize(new Dimension(300,990));
      this.seedArea.setMaximumSize(new Dimension(300,990));

      for(int j = 0; j < this.seeds.length; j++){
        this.seeds[j].setMinimumSize(new Dimension(300,125));
        this.seeds[j].setMaximumSize(new Dimension(300,125));
        this.seedArea.add(seeds[j]);
      }

      // all about the tiles
      this.tiles = new JButton[50];

      for(int l = 0; l < this.tiles.length; l++){
        this.tiles[l] = new JButton("tile");
      }


      //holds the tiles
      this.tileArea = new JPanel(new GridLayout(10,5, 10, 10));

      for(int k = 0; k < this.tiles.length; k++){
        this.tileArea.add(this.tiles[k]);
      }

      //popup menu
      this.popupMenu = new JPopupMenu[50];
      for(int i = 0; i < this.popupMenu.length; i++){
        this.popupMenu[i] = new JPopupMenu();
      }



      

      

      this.mainFrame = new JFrame("Magpapakasal-sa-A-farm");
      this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.mainFrame.setLayout(new BorderLayout(10, 10));
      this.mainFrame.setSize(1500,1000);
      this.mainFrame.setResizable(false);
      this.mainFrame.setVisible(true);

      this.mainFrame.add(this.topArea, BorderLayout.NORTH);
      this.mainFrame.add(this.tileArea, BorderLayout.CENTER);
      this.mainFrame.add(this.seedArea, BorderLayout.EAST);

      this.mainFrame.setVisible(true);

      farmerType.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
        //call the object of NewWindow and set visible true
          BuyView frame = new BuyView();
          frame.setVisible(true);
          //set default close operation
        }
      });
    }










    //methods for buttons


    //method for tiles btns
    public void setAddTileBtnListener(ActionListener listener){
      for(int i = 0; i < this.tiles.length; i++){
        this.tiles[i].addActionListener(listener);
      }
    }


    //method for seeds btns
    public void setAddSeedBtnListener(ActionListener listener){
      for(int i = 0; i < this.seeds.length; i++){
        this.seeds[i].addActionListener(listener);
      }
    }


    //methods for tools
    public void setAddHarvestBtnListener(ActionListener listener){
      this.tools[0].addActionListener(listener);
    }

    public void setAddPlowBtnListener(ActionListener listener){
      this.tools[1].addActionListener(listener);
    }

    public void setAddWateringCanBtnListener(ActionListener listener){
      this.tools[2].addActionListener(listener);
    }

    public void setAddFertilizerBtnListener(ActionListener listener){
      this.tools[3].addActionListener(listener);
    }

    public void setAddPickaxeBtnListener(ActionListener listener){
      this.tools[4].addActionListener(listener);
    }

    public void setAddShovelBtnListener(ActionListener listener){
      this.tools[5].addActionListener(listener);
    }

    //methods for player info
    public void setPlayerLevel(int level){
      this.level.setText("Level: " + level);
    }

    public void addPlayerMoney(int objectCoins){
      this.objectCoins.setText("ObjectCoins: " + objectCoins);
    }

    //this method is to show the panel where it displays the types of farmer statuses that the player can buy
    public void setFarmerTypeBtnListener(ActionListener listener){
      this.farmerType.addActionListener(listener);
    }
    
    public void setFarmerType(String farmerType){
      this.farmerType.setText("Farmer Type: " + farmerType);
    }








  
  public static void main (String args[]){
    GameView farm = new GameView("Farmer");
  }



}

