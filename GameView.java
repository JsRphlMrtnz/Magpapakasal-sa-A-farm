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


  private JButton startGame;

  private JLabel  level, exp, objectCoins, day;
  private JButton farmerType;
  
  // tools on top
  private JButton[] tools; // harvest, plow, wateringCan, fertilizer, pickaxe, shovel

  // right
  private JPanel seedArea;
  private JButton[] seeds; // turnip, carrot, potato, rose, tulips, sunflower, mango, apple

  //middle
  private JPanel tileArea;
  private JButton[] tiles;
  private JPopupMenu popupMenu; // popup menu for tiles
  
  // bottom
  private JTextField feedback;
  private JButton advanceDay;
    
  // game over butttons
  private JButton gameOverButtonYes;
  private JButton gameOverButtonNo;

  private int currIndex = -1;
  private int currSeedIndex = -1;

  /**
   * This constructor initializes all the components.
   */
  public GameView(){
    //region --------------SPRITES----------------
    this.rock = new ImageIcon(new ImageIcon("assets\\stone.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
    this.tile = new ImageIcon(new ImageIcon("assets\\grass.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
    this.plowed = new ImageIcon(new ImageIcon("assets\\plowedTile.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
    this.withered = new ImageIcon(new ImageIcon("assets\\withered.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));

    this.seedSprites = new ImageIcon[8];
    this.seedSprites[0] = new ImageIcon(new ImageIcon("assets\\turnip.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
    this.seedSprites[1] = new ImageIcon(new ImageIcon("assets\\carrot.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
    this.seedSprites[2] = new ImageIcon(new ImageIcon("assets\\potato.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
    this.seedSprites[3] = new ImageIcon(new ImageIcon("assets\\rose.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
    this.seedSprites[4] = new ImageIcon(new ImageIcon("assets\\tulip.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
    this.seedSprites[5] = new ImageIcon(new ImageIcon("assets\\sunflower.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
    this.seedSprites[6] = new ImageIcon(new ImageIcon("assets\\mango.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
    this.seedSprites[7] = new ImageIcon(new ImageIcon("assets\\apple.jpg").getImage().getScaledInstance(55, 80, Image.SCALE_DEFAULT));
    //endregion

    //region --------------STARTUP----------------
    this.startGame = new JButton(new ImageIcon(new ImageIcon("assets\\startImg.jpg").getImage().getScaledInstance(350,220, Image.SCALE_DEFAULT)));
    startGame.setBounds(500, 550, 300, 80);

    ImageIcon startupPic = new ImageIcon(new ImageIcon("assets\\startupPic.jpg").getImage().getScaledInstance(1285,730, Image.SCALE_DEFAULT));
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
    //endregion
  
    //region --------------PLAYER AREA----------------
    // background 
    ImageIcon gameAreaPic = new ImageIcon(new ImageIcon("assets\\farm.jpg").getImage().getScaledInstance(1285,730, Image.SCALE_DEFAULT));
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
    //endregion

    //region --------------TOOL AREA----------------
    //holds only tools
    JPanel toolArea = new JPanel(new GridLayout(6,1));
    toolArea.setBorder(BorderFactory.createLineBorder(Color.black));
    toolArea.setBounds(1130, 107, 140, 500);
    this.tools = new JButton[6];
    this.tools[0] = new JButton(new ImageIcon(new ImageIcon("assets\\Scythe.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT)));
    this.tools[1] = new JButton(new ImageIcon(new ImageIcon("assets\\Hoe.png").getImage().getScaledInstance(55,80, Image.SCALE_DEFAULT)));
    this.tools[2] = new JButton(new ImageIcon(new ImageIcon("assets\\Watering Can.png").getImage().getScaledInstance(55,80, Image.SCALE_DEFAULT)));
    this.tools[3] = new JButton(new ImageIcon(new ImageIcon("assets\\Seed Bag.png").getImage().getScaledInstance(55,80, Image.SCALE_DEFAULT)));
    this.tools[4] = new JButton(new ImageIcon(new ImageIcon("assets\\Pick.png").getImage().getScaledInstance(55,80, Image.SCALE_DEFAULT)));
    this.tools[5] = new JButton(new ImageIcon(new ImageIcon("assets\\Shovel.png").getImage().getScaledInstance(55,80, Image.SCALE_DEFAULT)));
    

    // toolArea
    for(int i = 0; i < this.tools.length; i++){
      toolArea.add(this.tools[i]);
    }
    //endregion
    
    //region --------------SEED AREA----------------
    this.seeds = new JButton[8];
    this.seeds[0] = new JButton(new ImageIcon(new ImageIcon("assets\\turnipOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
    this.seeds[1] = new JButton(new ImageIcon(new ImageIcon("assets\\carrotOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
    this.seeds[2] = new JButton(new ImageIcon(new ImageIcon("assets\\potatoOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
    this.seeds[3] = new JButton(new ImageIcon(new ImageIcon("assets\\roseOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
    this.seeds[4] = new JButton(new ImageIcon(new ImageIcon("assets\\tulipOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
    this.seeds[5] = new JButton(new ImageIcon(new ImageIcon("assets\\sunflowerOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
    this.seeds[6] = new JButton(new ImageIcon(new ImageIcon("assets\\mangoOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));
    this.seeds[7] = new JButton(new ImageIcon(new ImageIcon("assets\\appleOption.jpg").getImage().getScaledInstance(100,92, Image.SCALE_DEFAULT)));

    // holds the seeds
    this.seedArea = new JPanel();
    this.seedArea.setBorder(BorderFactory.createLineBorder(Color.black));
    this.seedArea.setLayout(new GridLayout(1,8));
    for(int j = 0; j < this.seeds.length; j++){
      this.seedArea.add(seeds[j]);
    }
    this.seedArea.setBounds(260, 0, 810, 96); 
    //endregion

    //region --------------TILE AREA----------------
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
    //endregion

    //region --------------BOTTOM AREA----------------
    this.advanceDay = new JButton(new ImageIcon(new ImageIcon("assets\\advancePic.jpg").getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT)));
    this.advanceDay.setBounds(1138, 635, 120, 40);
    //endregion

    //region --------------DAY AREA----------------
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
    //endregion

    //region -----------------FEEDBACK AREA----------------
    this.feedback = new JTextField();
    this.feedback.setBounds(340, 660, 500, 20);
    this.feedback.setEditable(false);
    this.feedback.setBorder(BorderFactory.createLineBorder(Color.black));
    this.popupMenu = new JPopupMenu();
    //endregion

    //region --------------GAME AREA----------------
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
    //endregion
    
    //region --------------GAME OVER----------------
    JPanel gameOverButtonPanel = new JPanel();
    gameOverButtonPanel.setLayout(new GridLayout(1,2, 40, 10));
    this.gameOverButtonNo = new JButton(new ImageIcon(new ImageIcon("assets\\no.jpg").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT)));
    this.gameOverButtonYes = new JButton(new ImageIcon(new ImageIcon("assets\\yes.jpg").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT)));
    gameOverButtonPanel.add(gameOverButtonYes);
    gameOverButtonPanel.add(gameOverButtonNo);
    gameOverButtonPanel.setBounds(440, 500, 400, 100);
    gameOverButtonPanel.setBackground(new Color(0, 0, 0, 0));

    ImageIcon gameOverPic = new ImageIcon(new ImageIcon("assets\\gameOver.jpg").getImage().getScaledInstance(1285,730, Image.SCALE_DEFAULT));
    JLabel gameOverBg = new JLabel(gameOverPic);
    gameOverBg.setBounds(0, 0 , 1280, 720);
    
    JPanel gameOver = new JPanel(null);
    gameOver.add(gameOverButtonPanel);
    gameOver.add(gameOverBg);
    //endregion

    //region --------------START UP----------------
    this.cardLayout = new CardLayout();
    this.container = getContentPane();
    this.container.setLayout(cardLayout);
    this.container.add("1", startUp);
    this.container.add("2", gameArea);
    this.container.add("3", gameOver);
    //endregion
  }
  
  //region --------------METHODS----------------
  
  /**
   * This method is used to get the index of the tile that is clicked
   * 
   * @param b the button that is clicked
   * @return the index of the button, -1 if tile is clicked again
   */
  public int currTileIndex(JButton b) {
    for (int i = 0; i < this.tiles.length; i++) {
      if (b == this.tiles[i] && currIndex != i) {
        return i;
      }
    }
    return -1;
  }
  
  /**
   * This method is used to get the index of the seed that is right clicked
   * 
   * @param b the button that is right clicked
   * @param mode 1 if tile, 2 if seed, 3 if tool
   * @return the index of the button, -1 if seed is clicked again
   */
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

  /**
   * This method is used to get the index of the seed that is clicked
   * @param b the button that is clicked
   * @return the index of the button, -1 if seed is clicked again
   */
  public int currSeedIndex(JButton b) {
    for (int i = 0; i < this.seeds.length; i++) {
      if (b == this.seeds[i]) {
        return i;
      }
    }
    return -1;
  }

  /**
   * This method is used to toggle the tool and seed buttons from
   * being enabled or disabled
   */
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
  //endregion

  //region --------------GETTERS & SETTERS----------------

  /**
   * This method is used to set an action listener to the "Yes" 
   * button in the game over screen
   * @param listener the action listener
   */
  public void setGameOverButtonYesActionListener(ActionListener listener) {
    this.gameOverButtonYes.addActionListener(listener);
  }

  /**
   * This method is used to set an action listener to the "No" 
   * button in the game over screen
   * @param listener the action listener
   */
  public void setGameOverButtonNoActionListener(ActionListener listener) {
    this.gameOverButtonNo.addActionListener(listener);
  }

  /**
   * This method is used to set the text of the feedback textfield
   * @param text the text to be set
   */
  public void setFeedbackText(String text) {
    this.feedback.setText(text);
  }

  /**
   * This method is used to set an action listener to the start game button
   * @param listener the action listener
   */
  public void setStartActionListener(ActionListener listener) {
    this.startGame.addActionListener(listener);
  }

  /**
   * This method is used to set an action listener to the Advance day button
   * in the game screen
   * @param listener the action listener
   */
  public void setAdvanceDayActionListener(ActionListener listener) {
    this.advanceDay.addActionListener(listener);
  }

  /**
   * This method is used to set an action listener to the Farmer type
   * button in the top left of the game screen
   * @param listener the action listener
   */
  public void setFarmerTypeActionListener(ActionListener listener) {
    this.farmerType.addActionListener(listener);
  }

  /**
   * This method gets the card layout of the game
   * @return the card layout
   */
  public CardLayout getCardLayout() {
    return this.cardLayout;
  }

  /**
   * This method gets the container of the game
   * @return the container
   */
  public Container getCont() {
    return this.container;
  }

  /**
   * This method gets the current index of the seed
   * @return the current index of the seed
   */
  public int getCurrSeedIndex() {
    return this.currSeedIndex;
  }
  
  /**
   * This method sets the current index of the seed
   * @param index the index to be set
   * @return the index that was set
   */
  public int setCurrSeedIndex(int index) {
    return this.currSeedIndex = index;
  }

  /**
   * This method gets the current index of the tile
   * @return the current index of the tile
   */
  public int getCurrTileIndex() {
    return this.currIndex;
  }

  /**
   * This method sets the current index of the tile
   * @param index the index to be set
   */
  public void setCurrTileIndex(int index) {
    this.currIndex = index;
  }

  /**
   * This method sets the images on each button
   * @param index the index of the button
   * @param text the text to be set
   */
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

  /**
   * This method sets the text of the current day label
   * @param text the text to be set
   */
  public void setDayLabel(String text){
    this.day.setText(text);
  }

  /**
   * This method sets the popup menu to be shown on the screen
   * @param popupMenu the popup menu to be shown
   * @param i the index of the button
   * @param x the x coordinate of the mouse
   * @param y the y coordinate of the mouse
   * @param mode 1 for tile, 2 for seed, 3 for tool
   */
  public void setPopupMenu(JPopupMenu popupMenu, int i, int x, int y, int mode){
    this.popupMenu = popupMenu;
    if (mode == 1)
      this.popupMenu.show(tiles[i], x, y);
    else if (mode == 2)
      this.popupMenu.show(seeds[i], x, y);
    else if (mode == 3)
      this.popupMenu.show(tools[i], x, y);
  }

  /**
   * This method sets the text of the current coins label
   * @param text the text to be set
   */
  public void setObjectCoins(String coins){
    this.objectCoins.setText(coins);
  }

  /**
   * This method sets the text of the current level label
   * @param text the text to be set
   */
  public void setLevel(String level){
    this.level.setText(level);
  }

  /**
   * This method sets the text of the current farmer type label
   * @param text the text to be set
   */
  public void setFarmerType(String farmerType){
    this.farmerType.setText(farmerType);
  }

  /**
   * This method sets the text of the current experience label
   * @param text the text to be set
   */
  public void setExp(String exp){
    this.exp.setText(exp);
  }

  /**
   * This method sets the action listener for the tile buttons
   * @param listener the action listener
   */
  public void setAddTileBtnListener(ActionListener listener){
    for(int i = 0; i < this.tiles.length; i++){
      this.tiles[i].addActionListener(listener);
    }
  }

  /**
   * This method sets the action listener for the seed buttons
   * @param listener the action listener
   */
  public void setAddSeedBtnListener(int i, ActionListener listener){
    this.seeds[i].addActionListener(listener);
  }

  /**
   * This method sets the action listener for the harvest button
   * @param listener the action listener
   */
  public void setAddHarvestBtnListener(ActionListener listener){
    this.tools[0].addActionListener(listener);
  }

  /**
   * This method sets the action listener for the plow button
   * @param listener the action listener
   */
  public void setAddPlowBtnListener(ActionListener listener){
    this.tools[1].addActionListener(listener);
  }

  /**
   * This method sets the action listener for the watering can button
   * @param listener the action listener
   */
  public void setAddWateringCanBtnListener(ActionListener listener){
    this.tools[2].addActionListener(listener);
  }

  /**
   * This method sets the action listener for the fertilizer button
   * @param listener the action listener
   */
  public void setAddFertilizerBtnListener(ActionListener listener){
    this.tools[3].addActionListener(listener);
  }

  /**
   * This method sets the action listener for the pickaxe button
   * @param listener the action listener
   */
  public void setAddPickaxeBtnListener(ActionListener listener){
    this.tools[4].addActionListener(listener);
  }

  /**
   * This method sets the action listener for the shovel button
   * @param listener the action listener
   */
  public void setAddShovelBtnListener(ActionListener listener){
    this.tools[5].addActionListener(listener);
  }

  /**
   * This method sets the action listener for the Farmer type button
   * @param listener the action listener
   */
  public void setFarmerTypeBtnListener(ActionListener listener){
    this.farmerType.addActionListener(listener);
  }

  /**
   * This method sets the mouse listeners for the tile buttons
   * @param i the index of the button
   * @param listener the mouse listener
   */
  public void setMouseListeneronTiles(int i, MouseListener listener) {
      tiles[i].addMouseListener(listener);
  }

  /**
   * This method sets the mouse listeners for the seed buttons
   * @param i the index of the button
   * @param listener the mouse listener
   */
  public void setMouseListeneronSeed(int i, MouseListener listener) {
      seeds[i].addMouseListener(listener);
  }

  /**
   * This method sets the mouse listeners for the tool buttons
   * @param i the index of the button
   * @param listener the mouse listener
   */
  public void setMouseListeneronTools(int i, MouseListener listener) {
      tools[i].addMouseListener(listener);
  }
  //endregion
}

