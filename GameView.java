import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class GameView extends JFrame {

  // layout 
    private CardLayout cardLayout;
    private Container container;
  
  // for all the sprites
    private ImageIcon rock, tile, plowed, withered;
    private ImageIcon[] seedSprites;


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
       * --------------SPRITES----------------
      */
      this.rock = new ImageIcon(new ImageIcon("stone.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
      this.tile = new ImageIcon(new ImageIcon("grass.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
      this.plowed = new ImageIcon(new ImageIcon("plowedTile.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
      this.withered = new ImageIcon(new ImageIcon("withered.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));

      this.seedSprites = new ImageIcon[8];
      this.seedSprites[0] = new ImageIcon(new ImageIcon("turnip.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
      this.seedSprites[1] = new ImageIcon(new ImageIcon("carrot.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
      this.seedSprites[2] = new ImageIcon(new ImageIcon("potato.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
      this.seedSprites[3] = new ImageIcon(new ImageIcon("rose.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
      this.seedSprites[4] = new ImageIcon(new ImageIcon("tulip.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
      this.seedSprites[5] = new ImageIcon(new ImageIcon("sunflower.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
      this.seedSprites[6] = new ImageIcon(new ImageIcon("mango.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
      this.seedSprites[7] = new ImageIcon(new ImageIcon("apple.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));

      
      /*
       * --------------STARTUP----------------
       */
      this.startGame = new JButton(new ImageIcon(new ImageIcon("startImg.jpg").getImage().getScaledInstance(350,220, Image.SCALE_DEFAULT)));
      startGame.setBounds(500, 550, 300, 80);

      ImageIcon startupPic = new ImageIcon(new ImageIcon("startupPic.jpg").getImage().getScaledInstance(1285,730, Image.SCALE_DEFAULT));
      JLabel startUpBg = new JLabel(startupPic);
      startUpBg.setBounds(0, 0 , 1280, 720);


      JPanel startUp = new JPanel(null);
      this.setSize(1280, 720);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      this.setResizable(false);
      this.setVisible(true);
      startUp.add(startGame);
      startUp.add(startUpBg);

    /*
      --------------PLAYER AREA----------------
    */
      // background 
      ImageIcon gameAreaPic = new ImageIcon(new ImageIcon("farm.jpg").getImage().getScaledInstance(1285,730, Image.SCALE_DEFAULT));
      JLabel gameAreaBg = new JLabel(gameAreaPic);
      gameAreaBg.setBounds(0, 0 , 1280, 720);

      JLabel objectCoinsLabel = new JLabel("Object Coins : ");
      this.objectCoins = new JLabel("0");
      JLabel levelLabel =  new JLabel("Level : ");
      this.level = new JLabel("1");
      JLabel expLabel = new JLabel("Exp : ");
      this.exp = new JLabel("0");
      JLabel farmerTypeLabel = new JLabel("Farmer Type : ");
      this.farmerType = new JButton("Farmer");

      // holds player info
      JPanel playerInfo = new JPanel(new GridLayout(4,2, 0,0));
      playerInfo.setBackground(new Color (102, 51, 0));
      playerInfo.setBounds(95, 0, 166, 96);
      playerInfo.add(objectCoinsLabel);
      playerInfo.add(this.objectCoins);
      playerInfo.add(levelLabel);
      playerInfo.add(this.level);
      playerInfo.add(expLabel);
      playerInfo.add(this.exp);
      playerInfo.add(farmerTypeLabel);
      playerInfo.add(this.farmerType);
      playerInfo.setBorder(BorderFactory.createLineBorder(Color.black));

      JLabel name = new JLabel("Dave");
      name.setBounds(35, 65, 100, 100);

      /*
       * --------------TOOL AREA----------------
       */
      //holds only tools
      
      JPanel toolArea = new JPanel(new GridLayout(6,1));
      toolArea.setBorder(BorderFactory.createLineBorder(Color.black));
      toolArea.setBounds(1130, 107, 140, 500);
      this.tools = new JButton[6];
      this.tools[0] = new JButton(new ImageIcon(new ImageIcon("Scythe.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT)));
      this.tools[1] = new JButton(new ImageIcon(new ImageIcon("Hoe.png").getImage().getScaledInstance(55,80, Image.SCALE_DEFAULT)));
      this.tools[2] = new JButton(new ImageIcon(new ImageIcon("Watering Can.png").getImage().getScaledInstance(55,80, Image.SCALE_DEFAULT)));
      this.tools[3] = new JButton(new ImageIcon(new ImageIcon("Seed Bag.png").getImage().getScaledInstance(55,80, Image.SCALE_DEFAULT)));
      this.tools[4] = new JButton(new ImageIcon(new ImageIcon("Pick.png").getImage().getScaledInstance(55,80, Image.SCALE_DEFAULT)));
      this.tools[5] = new JButton(new ImageIcon(new ImageIcon("Shovel.png").getImage().getScaledInstance(55,80, Image.SCALE_DEFAULT)));
      

      // toolArea
      for(int i = 0; i < this.tools.length; i++){
        toolArea.add(this.tools[i]);
      }


      /*
        --------------SEED AREA----------------
      */
      //region all about the seeds
      this.seeds = new JButton[8];
      this.seeds[0] = new JButton(new ImageIcon(new ImageIcon("turnipOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
      this.seeds[1] = new JButton(new ImageIcon(new ImageIcon("carrotOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
      this.seeds[2] = new JButton(new ImageIcon(new ImageIcon("potatoOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
      this.seeds[3] = new JButton(new ImageIcon(new ImageIcon("roseOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
      this.seeds[4] = new JButton(new ImageIcon(new ImageIcon("tulipOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
      this.seeds[5] = new JButton(new ImageIcon(new ImageIcon("sunflowerOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
      this.seeds[6] = new JButton(new ImageIcon(new ImageIcon("mangoOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
      this.seeds[7] = new JButton(new ImageIcon(new ImageIcon("appleOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));

      // holds the seeds
      this.seedArea = new JPanel();
      this.seedArea.setBorder(BorderFactory.createLineBorder(Color.black));
      this.seedArea.setLayout(new GridLayout(1,8));
      for(int j = 0; j < this.seeds.length; j++){
        this.seedArea.add(seeds[j]);
      }
      this.seedArea.setBounds(260, 0, 810, 96); 
      //endregion

      /*
        --------------TILE AREA----------------
      */

      // all about the tiles
      this.tiles = new JButton[50];

      for(int l = 0; l < this.tiles.length; l++){
        this.tiles[l] = new JButton(this.tile);
      }


      //holds the tiles
      tileArea = new JPanel(new GridLayout(5,10));
      tileArea.setBackground(new Color(0, 0, 0, 0));
      tileArea.setBounds(296, 250, 570, 400);
      
      for(int k = 0; k < this.tiles.length; k++){
        tileArea.add(this.tiles[k]);
      }

      //popup menu
      this.popupMenu = new JPopupMenu();

      /*
        --------------BOTTOM AREA----------------
      */
      this.advanceDay = new JButton(new ImageIcon(new ImageIcon("advancePic.jpg").getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT)));
      this.advanceDay.setBounds(1138, 635, 120, 40);


      /*
        --------------DAY AREA----------------
      */
      JPanel dayPanel = new JPanel( new BorderLayout(10, 10));
      JLabel dayLabel = new JLabel("Day : ");
      dayLabel.setFont(new Font("Stencil", Font.PLAIN, 35));
      this.day = new JLabel("1");
      this.day.setFont(new Font("Stencil", Font.PLAIN, 35));
      JPanel dayLabelNum = new JPanel(new FlowLayout());
      dayLabelNum.add(dayLabel);
      dayLabelNum.add(this.day);
      dayPanel.add(dayLabelNum, BorderLayout.CENTER);
      dayPanel.add(new JLabel(" "), BorderLayout.NORTH);
      dayPanel.setBounds(1060, 0, 205, 96);
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
      gameArea.add(playerInfo);
      gameArea.add(name);
      gameArea.add(toolArea);
      gameArea.add(tileArea);
      gameArea.add(this.seedArea);
      gameArea.add(this.advanceDay);
      gameArea.add(dayPanel);
      gameArea.add(feedback);
      gameArea.add(gameAreaBg);

      


      /*
       * GAME OVER
      */

      JPanel gameOverButtonPanel = new JPanel();
      gameOverButtonPanel.setLayout(new GridLayout(1,2, 40, 10));
      this.gameOverButtonNo = new JButton(new ImageIcon(new ImageIcon("no.jpg").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT)));
      this.gameOverButtonYes = new JButton(new ImageIcon(new ImageIcon("yes.jpg").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT)));
      gameOverButtonPanel.add(gameOverButtonYes);
      gameOverButtonPanel.add(gameOverButtonNo);
      gameOverButtonPanel.setBounds(440, 500, 400, 100);
      gameOverButtonPanel.setBackground(new Color(0, 0, 0, 0));

      ImageIcon gameOverPic = new ImageIcon(new ImageIcon("gameOver.jpg").getImage().getScaledInstance(1285,730, Image.SCALE_DEFAULT));
      JLabel gameOverBg = new JLabel(gameOverPic);
      gameOverBg.setBounds(0, 0 , 1280, 720);
      
      JPanel gameOver = new JPanel(null);
      gameOver.add(gameOverButtonPanel);
      gameOver.add(gameOverBg);

      this.cardLayout = new CardLayout();
      this.container = getContentPane();
      this.container.setLayout(cardLayout);
      this.container.add("1", startUp);
      this.container.add("2", gameArea);
      this.container.add("3", gameOver);

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
  
  public int rightClickIndex(JButton b, int mode) {
    if (mode == 1) {
      for (int i = 0; i < tiles.length; i++) {
        if (b == this.tiles[i]) {
          return i;
        }
      }
    }
    else if (mode == 2) {
      for (int i = 0; i < seeds.length; i++) {
        if (b == this.seeds[i]) {
          return i;
        }
      }
    }
    else if (mode == 3) {
      for (int i = 0; i < tools.length; i++) {
        if (b == this.tools[i]) {
          return i;
        }
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
    
    public void setButtonImage(int index, String text) {
      if(text == "Rock")
        this.tiles[index].setIcon(rock);
      else if (text == "Plowed")
        this.tiles[index].setIcon(plowed);
      else if (text == "Tile")
        this.tiles[index].setIcon(tile);
      else if (text == "Withered")
        this.tiles[index].setIcon(withered);
      else if (text == "Turnip")
        this.tiles[index].setIcon(seedSprites[0]);
      else if (text == "Carrot")
        this.tiles[index].setIcon(seedSprites[1]);
      else if (text == "Potato")
        this.tiles[index].setIcon(seedSprites[2]);
      else if (text == "Rose")
        this.tiles[index].setIcon(seedSprites[3]);
      else if (text == "Tulips")
        this.tiles[index].setIcon(seedSprites[4]);
      else if (text == "Sunflower")
        this.tiles[index].setIcon(seedSprites[5]);
      else if (text == "Mango")
        this.tiles[index].setIcon(seedSprites[6]);
      else if (text == "Apple")
        this.tiles[index].setIcon(seedSprites[7]);
    }

    public void setDayLabel(String text){
      this.day.setText(text);
    }

    public void setPopupMenu(JPopupMenu popupMenu, int i, int x, int y, int mode){
      this.popupMenu = popupMenu;
      if (mode == 1)
        this.popupMenu.show(tiles[i], x, y);
      else if (mode == 2)
        this.popupMenu.show(seeds[i], x, y);
      else if (mode == 3)
        this.popupMenu.show(tools[i], x, y);
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

  public void addActionListeneronSeed(int i, MouseListener listener) {
      seeds[i].addMouseListener(listener);
  }

  public void addActionListeneronTools(int i, MouseListener listener) {
      tools[i].addMouseListener(listener);
  }
  
}

