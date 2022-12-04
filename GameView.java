import java.awt.*;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.concurrent.Flow;


public class GameView implements ActionListener {
    private JFrame mainFrame;

    //top
    private JPanel topArea; // puts playerArea and seedArea together

    
    private JPanel playerArea;//PlayerArea = includes player info(name,level,objectCoins,farmerPic) 
    private JPanel playerInfo;
    private JPanel toolArea;
    private JLabel  name, level, objectCoins, farmerPic;
    private JButton farmerType;
    
    /*tools on top */
    private JButton[] tools; //harvest, plow, wateringCan, fertilizer, pickaxe, shovel


    //right
    private JPanel seedArea;
    private JButton[] seeds;//turnip, carrot, potato, rose, tulips, sunflower, mango, apple


    //middle
    private JPanel tileArea;
    private JButton[] tiles;
    private JPopupMenu popupMenu[]; //popup menu for each tile
    
    // bottom
    private JPanel bottomArea;
    private JButton advanceDay;


    
    public GameView(String name){
    /*
      --------------TOP AREA----------------
    */

      //all about the player
      JPanel farmerPanel=new JPanel(); 
  
      farmerPanel.setBounds(0,0,50,100);
      JLabel farmerPic=new JLabel(new ImageIcon("farmer.png"));
      //this.farmerPic.setIcon(new ImageIcon("farmer.png"));
      farmerPanel.add(farmerPic);


      this.name = new JLabel(name);
      this.level =  new JLabel("Level : 1");
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
      this.playerArea = new JPanel(new GridLayout(1,2, 0, 0));
      this.playerArea.setMaximumSize(new Dimension(150, 100));
      this.playerArea.setMinimumSize(new Dimension(150, 100));
      this.playerArea.add(farmerPanel);
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
      this.topArea = new JPanel(new BorderLayout(10, 10));
      this.topArea.setMaximumSize(new Dimension(1300,100));
      this.topArea.setMinimumSize(new Dimension(1300,50));
      this.topArea.setBounds(0,0, 1300,100);
      this.topArea.setBorder(BorderFactory.createLineBorder(Color.black));
      this.topArea.add(this.playerArea, BorderLayout.WEST);
      this.topArea.add(this.toolArea, BorderLayout.CENTER);
      
      /*
        --------------RIGHT AREA----------------
      */
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
      this.seedArea.setMinimumSize(new Dimension(300,1000));
      this.seedArea.setMaximumSize(new Dimension(300,1000));

      for(int j = 0; j < this.seeds.length; j++){
        this.seeds[j].setMinimumSize(new Dimension(300,125));
        this.seeds[j].setMaximumSize(new Dimension(300,125));
        
        this.seedArea.add(seeds[j]);
      }


      /*
        --------------MIDDLE AREA----------------
      */

      // all about the tiles
      this.tiles = new JButton[50];

      for(int l = 0; l < this.tiles.length; l++){
        this.tiles[l] = new JButton("tile");
      }


      //holds the tiles
      this.tileArea = new JPanel(new GridLayout(10,5, 60, 10));

      for(int k = 0; k < this.tiles.length; k++){
        this.tileArea.add(this.tiles[k]);
      }

      //popup menu
      this.popupMenu = new JPopupMenu[50];
      for(int i = 0; i < this.popupMenu.length; i++){
        this.popupMenu[i] = new JPopupMenu();
        this.popupMenu[i].add(new JLabel("Plowed : No"));
        this.popupMenu[i].add(new JLabel("Rock : None"));
        this.popupMenu[i].add(new JLabel("Watered : 0"));
        this.popupMenu[i].add(new JLabel("Fertilized : 0"));
        this.popupMenu[i].add(new JLabel("Harvestable : No"));
      }

      /*
        --------------BOTTOM AREA----------------
      */
      this.bottomArea = new JPanel(new BorderLayout());
      this.advanceDay = new JButton("Advance Day");
      this.bottomArea.add(this.advanceDay, BorderLayout.EAST);

      

      

      this.mainFrame = new JFrame("Magpapakasal-sa-A-farm");
      this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.mainFrame.setLayout(new BorderLayout(30, 30));
      this.mainFrame.setSize(1500,1000);
      this.mainFrame.setResizable(false);
      this.mainFrame.setVisible(true);

      this.mainFrame.add(this.topArea, BorderLayout.NORTH);
      this.mainFrame.add(this.tileArea, BorderLayout.CENTER);
      this.mainFrame.add(this.seedArea, BorderLayout.EAST);
      this.mainFrame.add(this.bottomArea, BorderLayout.SOUTH);

      this.mainFrame.setVisible(true);


      /// add onto controller
      farmerType.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          BuyView frame = new BuyView();
          frame.setVisible(true);
        }
      });

      for(int i = 0; i < this.tiles.length; i++){
        addActionListeneronTiles(tiles[i], i);
      }


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


  //add onto controller
  public void addActionListeneronTiles(JButton tiles, int number)
  {
      tiles.addMouseListener((MouseListener) new MouseListener()
      {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          if(SwingUtilities.isRightMouseButton(e)){
            popupMenu[number].show(tiles, e.getX(), e.getY());
          }
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          
        }
      });
  }
















  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    
  }
  










}

