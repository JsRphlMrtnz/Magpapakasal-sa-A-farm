import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class GameView extends JFrame {
    private CardLayout cardLayout;
    private Container container;
  
    /*
      --------------FOR THE STARTUP----------------
    */
    private JButton startGame;

    /*
      --------------FOR THE GAME----------------
     */
    private JLabel  level, exp, objectCoins, day;
    private JButton farmerType;
    
    /*tools on top */
    private JButton[] tools; //harvest, plow, wateringCan, fertilizer, pickaxe, shovel

    //right
    private JPanel seedArea;
    private JButton[] seeds;//turnip, carrot, potato, rose, tulips, sunflower, mango, apple
    private JPopupMenu seedPopupMenu[]; //popup menu for each seed

    //middle
    private JPanel tileArea;
    private JButton[] tiles;
    private JPopupMenu popupMenu; //popup menu for each tile
    
    // bottom
    private JTextField feedback;
    private JButton advanceDay;

    /*
     * --------------FOR THE GAME OVER----------------
     */
    //game over buttton
    private JButton gameOverButtonYes;
    private JButton gameOverButtonNo;

    private int currIndex = -1;
    private int currSeedIndex = -1;

    public GameView(){

      /*
       * --------------STARTUP----------------
       */
      this.startGame = new JButton("Start Game");
      startGame.setBounds(560, 400, 100, 50);

      JPanel startUp = new JPanel(null);
      this.setSize(1280, 720);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      this.setResizable(false);
      this.setVisible(true);
      startUp.add(startGame);

    /*
      --------------PLAYER AREA----------------
    */

      //all about the player
      JPanel farmerPanel=new JPanel(); 
      JLabel farmerPic = new JLabel(new ImageIcon("farmer.png"));
      //this.farmerPic.setIcon(new ImageIcon("farmer.png"));
      farmerPanel.add(farmerPic);
      farmerPanel.setBounds(0, 0, 80, 100);

      JLabel nameLabel = new JLabel("Name : " );
      JLabel name = new JLabel("Dave");
      JLabel objectCoinsLabel = new JLabel("Object Coins : ");
      this.objectCoins = new JLabel("0");
      JLabel levelLabel =  new JLabel("Level : ");
      this.level = new JLabel("1");
      JLabel expLabel = new JLabel("Exp : ");
      this.exp = new JLabel("0");
      JLabel farmerTypeLabel = new JLabel("Farmer Type : ");
      this.farmerType = new JButton("Farmer");

      // holds player info
      JPanel playerInfo = new JPanel(new GridLayout(5,2, 0,0));
      playerInfo.setBounds(80, 0, 170, 100);
      playerInfo.add(nameLabel);
      playerInfo.add(name);
      playerInfo.add(objectCoinsLabel);
      playerInfo.add(this.objectCoins);
      playerInfo.add(levelLabel);
      playerInfo.add(this.level);
      playerInfo.add(expLabel);
      playerInfo.add(this.exp);
      playerInfo.add(farmerTypeLabel);
      playerInfo.add(this.farmerType);
      playerInfo.setBorder(BorderFactory.createLineBorder(Color.black));

      /*
       * --------------TOOL AREA----------------
       */
      //holds only tools
      
      JPanel toolArea = new JPanel(new GridLayout(6,1));
      toolArea.setBorder(BorderFactory.createLineBorder(Color.black));
      toolArea.setBounds(1105, 100, 160, 500);
      this.tools = new JButton[6];
      this.tools[0] = new JButton("Harvest");
      this.tools[1] = new JButton("Plow");
      this.tools[2] = new JButton("Watering Can");
      this.tools[3] = new JButton("Fertilizer");
      this.tools[4] = new JButton("Pickaxe");
      this.tools[5] = new JButton("Shovel");
      

      // toolArea
      for(int i = 0; i < this.tools.length; i++){
        toolArea.add(this.tools[i]);
      }


      /*
        --------------SEED AREA----------------
      */
      //region all about the seeds
      this.seeds = new JButton[8];
      this.seeds[0] = new JButton("Turnip");
      this.seeds[1] = new JButton("Carrot");
      this.seeds[2] = new JButton("Potato");
      this.seeds[3] = new JButton("Rose");
      this.seeds[4] = new JButton("Tulips");
      this.seeds[5] = new JButton("Sunflower");
      this.seeds[6] = new JButton("Mango");
      this.seeds[7] = new JButton("Apple");


      this.seedPopupMenu = new JPopupMenu[8];
      this.seedPopupMenu[0] = new JPopupMenu();
      this.seedPopupMenu[0].add(new JLabel("Turnip seed"));
      this.seedPopupMenu[0].add(new JLabel("Time : 2 days"));
      this.seedPopupMenu[0].add(new JLabel("Water : 1 (2)"));
      this.seedPopupMenu[0].add(new JLabel("Fertilizer : 0 (1)"));
      this.seedPopupMenu[0].add(new JLabel("Produce : 1-2"));
      this.seedPopupMenu[0].add(new JLabel("Cost : 5"));
      this.seedPopupMenu[0].add(new JLabel("Sell : 6"));
      this.seedPopupMenu[0].add(new JLabel("XP : 5"));

      this.seedPopupMenu[1] = new JPopupMenu();
      this.seedPopupMenu[1].add(new JLabel("Seed : Carrot"));
      this.seedPopupMenu[1].add(new JLabel("Time : 3 days"));
      this.seedPopupMenu[1].add(new JLabel("Water : 1 (2)"));
      this.seedPopupMenu[1].add(new JLabel("Fertilizer : 0 (1)"));
      this.seedPopupMenu[1].add(new JLabel("Produce : 1-2"));
      this.seedPopupMenu[1].add(new JLabel("Cost : 10"));
      this.seedPopupMenu[1].add(new JLabel("Sell : 9"));
      this.seedPopupMenu[1].add(new JLabel("XP : 7.5"));


      this.seedPopupMenu[2] = new JPopupMenu();
      this.seedPopupMenu[2].add(new JLabel("Seed : Potato"));
      this.seedPopupMenu[2].add(new JLabel("Time : 5 days"));
      this.seedPopupMenu[2].add(new JLabel("Water : 3 (4)"));
      this.seedPopupMenu[2].add(new JLabel("Fertilizer : 1 (2)"));
      this.seedPopupMenu[2].add(new JLabel("Produce : 1-10"));
      this.seedPopupMenu[2].add(new JLabel("Cost : 20"));
      this.seedPopupMenu[2].add(new JLabel("Sell : 3"));
      this.seedPopupMenu[2].add(new JLabel("XP : 12.5"));

      this.seedPopupMenu[3] = new JPopupMenu();
      this.seedPopupMenu[3].add(new JLabel("Seed : Rose"));
      this.seedPopupMenu[3].add(new JLabel("Time : 1 day"));
      this.seedPopupMenu[3].add(new JLabel("Water : 1 (2)"));
      this.seedPopupMenu[3].add(new JLabel("Fertilizer : 0 (1)"));
      this.seedPopupMenu[3].add(new JLabel("Produce : 1"));
      this.seedPopupMenu[3].add(new JLabel("Cost : 5"));
      this.seedPopupMenu[3].add(new JLabel("Sell : 5"));
      this.seedPopupMenu[3].add(new JLabel("XP : 2.5"));

      this.seedPopupMenu[4] = new JPopupMenu();
      this.seedPopupMenu[4].add(new JLabel("Seed : Tulips"));
      this.seedPopupMenu[4].add(new JLabel("Time : 2 days"));
      this.seedPopupMenu[4].add(new JLabel("Water : 2 (3)"));
      this.seedPopupMenu[4].add(new JLabel("Fertilizer : 0 (1)"));
      this.seedPopupMenu[4].add(new JLabel("Produce : 1"));
      this.seedPopupMenu[4].add(new JLabel("Cost : 10"));
      this.seedPopupMenu[4].add(new JLabel("Sell : 9"));
      this.seedPopupMenu[4].add(new JLabel("XP : 5"));


      this.seedPopupMenu[5] = new JPopupMenu();
      this.seedPopupMenu[5].add(new JLabel("Seed : Sunflower"));
      this.seedPopupMenu[5].add(new JLabel("Time : 3 days"));
      this.seedPopupMenu[5].add(new JLabel("Water : 2 (3)"));
      this.seedPopupMenu[5].add(new JLabel("Fertilizer : 1 (2)"));
      this.seedPopupMenu[5].add(new JLabel("Produce : 1"));
      this.seedPopupMenu[5].add(new JLabel("Cost : 20"));
      this.seedPopupMenu[5].add(new JLabel("Sell : 19"));
      this.seedPopupMenu[5].add(new JLabel("XP : 7.5"));

      this.seedPopupMenu[6] = new JPopupMenu();
      this.seedPopupMenu[6].add(new JLabel("Seed : Mango"));
      this.seedPopupMenu[6].add(new JLabel("Time : 10 days"));
      this.seedPopupMenu[6].add(new JLabel("Water : 7 (7)"));
      this.seedPopupMenu[6].add(new JLabel("Fertilizer : 4 (4)"));
      this.seedPopupMenu[6].add(new JLabel("Produce : 5-15"));
      this.seedPopupMenu[6].add(new JLabel("Cost : 100"));
      this.seedPopupMenu[6].add(new JLabel("Sell : 8"));
      this.seedPopupMenu[6].add(new JLabel("XP : 25"));

      this.seedPopupMenu[7] = new JPopupMenu();
      this.seedPopupMenu[7].add(new JLabel("Seed : Apple"));
      this.seedPopupMenu[7].add(new JLabel("Time : 10 days"));
      this.seedPopupMenu[7].add(new JLabel("Water : 7 (7)"));
      this.seedPopupMenu[7].add(new JLabel("Fertilizer : 5 (5)"));
      this.seedPopupMenu[7].add(new JLabel("Produce : 10-15"));
      this.seedPopupMenu[7].add(new JLabel("Cost : 200"));
      this.seedPopupMenu[7].add(new JLabel("Sell : 5"));
      this.seedPopupMenu[7].add(new JLabel("XP : 25"));

      // holds the seeds
      this.seedArea = new JPanel();
      this.seedArea.setBorder(BorderFactory.createLineBorder(Color.black));
      this.seedArea.setLayout(new GridLayout(1,8));
      for(int j = 0; j < this.seeds.length; j++){
        this.seedArea.add(seeds[j]);
      }
      this.seedArea.setBounds(250, 0, 810, 100); 
      //endregion

      /*
        --------------TILE AREA----------------
      */

      // all about the tiles
      this.tiles = new JButton[50];

      for(int l = 0; l < this.tiles.length; l++){
        this.tiles[l] = new JButton("tile");
      }


      //holds the tiles
      tileArea = new JPanel(new GridLayout(10,5));
      tileArea.setBorder(BorderFactory.createLineBorder(Color.black));
      tileArea.setBounds(250, 300, 450, 300);
      
      for(int k = 0; k < this.tiles.length; k++){
        tileArea.add(this.tiles[k]);
      }

      //popup menu
      this.popupMenu = new JPopupMenu();

      /*
        --------------BOTTOM AREA----------------
      */
      this.advanceDay = new JButton("Advance Day");
      this.advanceDay.setBounds(1140, 635, 120, 40);


      /*
        --------------DAY AREA----------------
      */
      JPanel dayPanel = new JPanel();
      dayPanel.setLayout(new FlowLayout());
      JLabel dayLabel = new JLabel("Day : ");
      dayLabel.setFont(new Font("Serif", Font.PLAIN, 40));
      this.day = new JLabel("1");
      this.day.setFont(new Font("Serif", Font.PLAIN, 40));
      dayPanel.add(dayLabel);
      dayPanel.add(this.day);
      dayPanel.setBounds(1060, 0, 205, 100);
      dayPanel.setBorder(BorderFactory.createLineBorder(Color.black));

      /*
       * -----------------FEEDBACK AREA----------------
       */

      this.feedback = new JTextField();
      this.feedback.setBounds(340, 660, 500, 20);
      this.feedback.setEditable(false);
      this.feedback.setBorder(BorderFactory.createLineBorder(Color.black));
      
      //gameArea
      JPanel gameArea = new JPanel(null);
      gameArea.add(farmerPanel);
      gameArea.add(playerInfo);
      gameArea.add(farmerPanel);
      gameArea.add(toolArea);
      gameArea.add(tileArea);
      gameArea.add(this.seedArea);
      gameArea.add(this.advanceDay);
      gameArea.add(dayPanel);
      gameArea.add(feedback);
      


      /*
       * GAME OVER
      */

      JPanel gameOverButtonPanel = new JPanel();
      gameOverButtonPanel.setLayout(new GridLayout(1,2, 10, 10));
      this.gameOverButtonNo = new JButton("No");
      this.gameOverButtonYes = new JButton("Yes");
      gameOverButtonPanel.add(gameOverButtonYes);
      gameOverButtonPanel.add(gameOverButtonNo);
      gameOverButtonPanel.setBounds(540, 400, 125, 30);

      JPanel centerGameOverSign = new JPanel();
      centerGameOverSign.setLayout(new FlowLayout());
      centerGameOverSign.add(new JLabel ("Game Over"));
      centerGameOverSign.setBounds(540, 150, 125, 30);

      JPanel centerPlayAgainSign = new JPanel();
      centerPlayAgainSign.setLayout(new FlowLayout());
      centerPlayAgainSign.add(new JLabel ("Do you want to play again?"));
      centerPlayAgainSign.setBounds(500, 250, 200, 30);
      centerPlayAgainSign.setBorder(BorderFactory.createLineBorder(Color.black));



      JPanel gameOver = new JPanel(null);
      
      gameOver.add(gameOverButtonPanel);
      gameOver.add(centerGameOverSign);
      gameOver.add(centerPlayAgainSign);

      this.cardLayout = new CardLayout();
      this.container = getContentPane();
      this.container.setLayout(cardLayout);
      this.container.add("1", startUp);
      this.container.add("2", gameArea);
      this.container.add("3", gameOver);
      

      for(int i = 0; i < this.seeds.length; i++){
        addActionListeneronSeed(seeds[i], i);
      }

  }

    //methods for buttons
    public int currTileIndex(JButton b) {
    
      for (int i = 0; i < this.tiles.length; i++) {
        if (b == this.tiles[i] && currIndex != i) {
          return i;
        }
      }
      
      return -1;
    }
  
  public int rightClickIndex(JButton b) {
    for (int i = 0; i < this.tiles.length; i++) {
      if (b == this.tiles[i]) {
        return i;
      }
    }
    return -1;
  }
    public int currSeedIndex(JButton b) {
      
      for (int i = 0; i < this.seeds.length; i++) {
        if (b == this.seeds[i]) {
          return i;
        }
      }
      
      return -1;
    }
  
  // region getters and setters

  public void setGameOverButtonYesActionListener(ActionListener listener) {
    this.gameOverButtonYes.addActionListener(listener);
  }

  public void setGameOverButtonNoActionListener(ActionListener listener) {
    this.gameOverButtonNo.addActionListener(listener);
  }

  public void setFeedbackText(String text) {
    this.feedback.setText(text);
  }

  public void setStartActionListener(ActionListener listener) {
    this.startGame.addActionListener(listener);
  }

  public void setAdvanceDayActionListener(ActionListener listener) {
    this.advanceDay.addActionListener(listener);
  }

  public void setFarmerTypeActionListener(ActionListener listener) {
    this.farmerType.addActionListener(listener);
  }
  public CardLayout getCardLayout() {
    return this.cardLayout;
  }
  
  public Container getCont() {
    return this.container;
  }
  public int getCurrSeedIndex() {
    return this.currSeedIndex;
  }
  
    public int setCurrSeedIndex(int index) {
      return this.currSeedIndex = index;
    }
  
    public int getCurrTileIndex() {
      return this.currIndex;
    }
  
    public void setCurrTileIndex(int index) {
      this.currIndex = index;
    }
  
    public void toggleButtons() {
      
      if (this.currIndex == -1) {
        for (JButton b : this.seeds) {
          b.setEnabled(false);
        }
        for (JButton b : this.tools) {
          b.setEnabled(false);
        }
      }
      else {
        for (JButton b : this.seeds) {
          b.setEnabled(true);
        }
        for (JButton b : this.tools) {
          b.setEnabled(true);
        }
      }
    }
    
    public void setButtonText(int index, String text) {
      this.tiles[index].setText(text);
    }

    public void setDayLabel(String text){
      this.day.setText(text);
    }

    public void setPopupMenu(JPopupMenu popupMenu, int i, int x, int y){
      this.popupMenu = popupMenu;
      this.popupMenu.show(tiles[i], x, y);
    }
    
    public void setObjectCoins(String coins){
      this.objectCoins.setText(coins);
    }

    public void setLevel(String level){
      this.level.setText(level);
    }

    public void setFarmerType(String farmerType){
      this.farmerType.setText(farmerType);
    }

    public void setExp(String exp){
      this.exp.setText(exp);
    }

    //method for tiles btns
    public void setAddTileBtnListener(ActionListener listener){
      for(int i = 0; i < this.tiles.length; i++){
        this.tiles[i].addActionListener(listener);
      }
    }

    public void setAddSeedBtnListener(int i, ActionListener listener){
      this.seeds[i].addActionListener(listener);
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
    //endregion

    //this method is to show the panel where it displays the types of farmer statuses that the player can buy
    public void setFarmerTypeBtnListener(ActionListener listener){
      this.farmerType.addActionListener(listener);
    }
    
  public void addActionListeneronTiles(int i, MouseListener listener) {
      tiles[i].addMouseListener(listener);
  }

  public void addActionListeneronSeed(JButton seeds, int number)
  {
      seeds.addMouseListener((MouseListener) new MouseListener()
      {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
          // TODO Auto-generated method stub
          if(SwingUtilities.isRightMouseButton(e)){
            seedPopupMenu[number].show(seeds, e.getX(), e.getY());
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

}

