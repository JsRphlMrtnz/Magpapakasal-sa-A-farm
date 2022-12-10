import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * 
 * Magpapakasal-sa-A-farm is farming simulation game that runs on Java.
 * 
 * @author Don Laude A. Aspecto
 * @author Jose Raphael E. Martinez
 * @version 2.0
 */
public class Controller {
    MyFarm myFarm;      // the model
    GameView farmView;  // the view
   
    /**
     * This constructor runs the game.
     */
    public Controller() {
        this.run();
    }

    /**
     * This method adds action listeners to the buttons
     * and initializes the view.
     */
    private void initializeView() {
        addActionListeners();
        updateFarmerLabels();
        for (int i = 0; i < myFarm.getTiles().length; i++) {
            if (myFarm.getTiles()[i].getHasRock())
                farmView.setButtonImage(i, "Rock");
        }
    }

    /**
     * This method updates the farmer info labels on the view.
     */
    private void updateFarmerLabels() {
        farmView.setObjectCoins(String.format("%.2f", myFarm.getPlayer().getCoins()));
        farmView.setLevel(String.valueOf(myFarm.getPlayer().getLevel()));
        farmView.setExp(String.format("%.2f", myFarm.getPlayer().getXp()));
        farmView.setFarmerType(String.valueOf(myFarm.getPlayer().getType()));
    }

    /**
     * This method adds action listeners to the buttons.
     */
    private void addActionListeners() {
        farmView.setStartActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                farmView.getCardLayout().next(farmView.getCont());
            }
        });

        farmView.setAddTileBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                farmView.setCurrTileIndex(farmView.currTileIndex((JButton) e.getSource()));
                farmView.toggleButtons();
            }
        });

        farmView.setAddPlowBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myFarm.getPlayer().plow(myFarm.getTools()[0], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                    farmView.setButtonImage(farmView.getCurrTileIndex(), "Plowed");
                    farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                    farmView.setCurrTileIndex(-1);
                    farmView.toggleButtons();
                    updateFarmerLabels();
                }
            }
        });

        farmView.setAddWateringCanBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myFarm.getPlayer().water(myFarm.getTools()[01], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                    farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                    farmView.setCurrTileIndex(-1);
                    farmView.toggleButtons();
                    updateFarmerLabels();
                }
            }
        });

        farmView.setAddFertilizerBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myFarm.getPlayer().fertilize(myFarm.getTools()[2], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                    farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                    farmView.setCurrTileIndex(-1);
                    farmView.toggleButtons();
                    updateFarmerLabels();
                }
            }
        });

        farmView.setAddShovelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myFarm.getPlayer().dig(myFarm.getTools()[3], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                    farmView.setButtonImage(farmView.getCurrTileIndex(), "Tile");
                    farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                    farmView.setCurrTileIndex(-1);
                    farmView.toggleButtons();
                    updateFarmerLabels();
                }
            }
        });

        farmView.setAdvanceDayActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFarm.endDay();
                //game over
                if (!myFarm.gameOver()) {
                    farmView.setButtonBorder(farmView.getCurrTileIndex(), 2);
                    farmView.setCurrTileIndex(-1);
                    farmView.toggleButtons();
                    farmView.setDayLabel(String.valueOf(myFarm.getDay()));
                    for (int i = 0; i < myFarm.getTiles().length; i++) {
                        if (myFarm.getTiles()[i].getIsWithered()) {
                            farmView.setButtonImage(i, "Withered");
                        }
                    }
                    farmView.setFeedbackText("");
                }
                else {
                    farmView.getCardLayout().next(farmView.getCont());
                }
            }
        });

        farmView.setFarmerTypeActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            BuyView frame = new BuyView();

            switch (myFarm.getPlayer().getType()) {
                case "Legendary Farmer": {
                    frame.disableButtons(2);
                }
                case "Distinguished Farmer": {
                    frame.disableButtons(1);
                }
                case "Registered Farmer": {
                    frame.disableButtons(0);
                }
                break;
                default:
                    break;
            }
            
            frame.setRegisteredBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (myFarm.getPlayer().updateFarmerType(myFarm.getFarmerTypes()[1])) {
                farmView.setFarmerType(myFarm.getPlayer().getType());
                farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                frame.disableButtons(0);
                updateFarmerLabels();
                }
                else {
                farmView.setFeedbackText("Not enough coins/xp");
                }
                frame.dispose();
            }
            });

            frame.setDistinguishedBtnActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                if (myFarm.getPlayer().updateFarmerType(myFarm.getFarmerTypes()[2])) {
                    farmView.setFarmerType(myFarm.getPlayer().getType());
                    farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                    frame.disableButtons(1);
                    updateFarmerLabels();
                }
                else {
                    farmView.setFeedbackText("Not enough coins/xp");
                }
                frame.dispose();
                }
            });

            frame.setLegendaryBtnActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                if (myFarm.getPlayer().updateFarmerType(myFarm.getFarmerTypes()[3])) {
                    farmView.setFarmerType(myFarm.getPlayer().getType());
                    farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                    frame.disableButtons(2);
                    updateFarmerLabels();
                }
                else {
                    farmView.setFeedbackText("Not enough coins/xp");
                }
                frame.dispose();
                }
            });
        }
        });

        farmView.setAddHarvestBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myFarm.getPlayer().harvest(myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                    farmView.setButtonImage(farmView.getCurrTileIndex(), "Tile");
                    farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                    myFarm.getTiles()[farmView.getCurrTileIndex()].reset();
                    farmView.setCurrTileIndex(-1);
                    farmView.toggleButtons();
                    updateFarmerLabels();
                }
            }
        });

        farmView.setAddPickaxeBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myFarm.getPlayer().mine(myFarm.getTools()[4], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                    farmView.setButtonImage(farmView.getCurrTileIndex(), "Tile");
                    farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                    farmView.setCurrTileIndex(-1);
                    farmView.toggleButtons();
                    updateFarmerLabels();
                }
            }
        });

        for (int i = 0; i < myFarm.getSeeds().length; i++) {
            farmView.setAddSeedBtnListener(i, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    farmView.setCurrSeedIndex(farmView.currSeedIndex((JButton) e.getSource()));
                    boolean canPlant = true;
                    if (myFarm.getSeeds()[farmView.getCurrSeedIndex()].getType() == "Fruit tree")
                        canPlant = myFarm.availableSurroundings(farmView.getCurrTileIndex());
                    if (canPlant) {
                        if (myFarm.getPlayer().plant(myFarm.getSeeds()[farmView.getCurrSeedIndex()], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                            farmView.setButtonImage(farmView.getCurrTileIndex(), myFarm.getSeeds()[farmView.getCurrSeedIndex()].getName());
                            farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                            farmView.setCurrTileIndex(-1);
                            farmView.toggleButtons();
                            updateFarmerLabels();
                        }
                    }
                }
            });

            farmView.setMouseListeneronSeed(i, (MouseListener) new MouseListener()
            {
    
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {            
            }
    
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                    JPopupMenu popup = new JPopupMenu();
                    popup.add(new JLabel("Seed : " + myFarm.getSeeds()[farmView.rightClickIndex((JButton) e.getSource(), 2)].getName()));
                    popup.add(new JLabel("Time : " + myFarm.getSeeds()[farmView.rightClickIndex((JButton) e.getSource(), 2)].getHarvestTime() + " days"));
                    popup.add(new JLabel("Water : " + myFarm.getSeeds()[farmView.rightClickIndex((JButton) e.getSource(), 2)].getMinWater() + " (" + myFarm.getSeeds()[farmView.rightClickIndex((JButton) e.getSource(), 2)].getMaxWater() + ")"));
                    popup.add(new JLabel("Fertilizer : " + myFarm.getSeeds()[farmView.rightClickIndex((JButton) e.getSource(), 2)].getMinFertilizer() + " (" + myFarm.getSeeds()[farmView.rightClickIndex((JButton) e.getSource(), 2)].getMaxFertilizer() + ")"));
                    popup.add(new JLabel("Produce : " + myFarm.getSeeds()[farmView.rightClickIndex((JButton) e.getSource(), 2)].getMinProduce() + "-" + myFarm.getSeeds()[farmView.rightClickIndex((JButton) e.getSource(), 2)].getMaxProduce()));
                    popup.add(new JLabel("Cost : " + myFarm.getSeeds()[farmView.rightClickIndex((JButton) e.getSource(), 2)].getCost()));
                    popup.add(new JLabel("Sell : " + myFarm.getSeeds()[farmView.rightClickIndex((JButton) e.getSource(), 2)].getSellingPrice()));
                    popup.add(new JLabel("XP : " + myFarm.getSeeds()[farmView.rightClickIndex((JButton) e.getSource(), 2)].getXp()));
                    
                    farmView.setPopupMenu(popup, farmView.rightClickIndex((JButton) e.getSource(), 2), e.getX(), e.getY(), 2);
                }
            }
    
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {            
            }
    
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {            
            }
    
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {            
            }
            });
        }

        for (int i = 0; i < myFarm.getTiles().length; i++) {
            farmView.setMouseListeneronTiles(i, new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                JPopupMenu popup = new JPopupMenu();
                if (myFarm.getTiles()[farmView.rightClickIndex((JButton) e.getSource(), 1)].getHasRock()) {
                    popup.add(new JLabel("Currently has a rock"));
                }
                else if (myFarm.getTiles()[farmView.rightClickIndex((JButton) e.getSource(), 1)].getIsWithered()) {
                    popup.add(new JLabel("Plant is withered"));
                }
                else {
                    popup.add(new JLabel("Plowed: " + myFarm.getTiles()[farmView.rightClickIndex((JButton) e.getSource(), 1)].getPlowed()));
                    popup.add(new JLabel("Times Watered: " + myFarm.getTiles()[farmView.rightClickIndex((JButton) e.getSource(), 1)].getWater()));
                    popup.add(new JLabel("Times Fertilized: " + myFarm.getTiles()[farmView.rightClickIndex((JButton) e.getSource(), 1)].getFert()));
                    popup.add(new JLabel("Days until harvest: " + myFarm.getTiles()[farmView.rightClickIndex((JButton) e.getSource(), 1)].getTime()));
                }
                farmView.setPopupMenu(popup, farmView.rightClickIndex((JButton) e.getSource(), 1), e.getX(), e.getY(), 1);
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                
            }
            });
        }
        
        for (int i = 0; i < myFarm.getTools().length; i++) {
            farmView.setMouseListeneronTools(i + 1, new MouseListener() {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                }
        
                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {
                    if(SwingUtilities.isRightMouseButton(e)){
                    JPopupMenu popup = new JPopupMenu();
                    popup.add(new JLabel("Name : " + myFarm.getTools()[farmView.rightClickIndex((JButton) e.getSource(), 3) - 1].getName()));
                    popup.add(new JLabel("Cost : " + myFarm.getTools()[farmView.rightClickIndex((JButton) e.getSource(), 3) - 1].getCost()));
                    popup.add(new JLabel("XP: " + myFarm.getTools()[farmView.rightClickIndex((JButton) e.getSource(), 3) - 1].getXp()));
                    farmView.setPopupMenu(popup, farmView.rightClickIndex((JButton) e.getSource(), 3), e.getX(), e.getY(), 3);
                    }
                }
        
                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) {
                }
        
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    
                }
        
                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    
                }
                });
        }

        farmView.setGameOverButtonNoActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        farmView.setGameOverButtonYesActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                farmView.dispose();
                run();
            }
        });
        farmView.toggleButtons();
    }

    /**
     * This method initializes the model and view and starts the game
     */
    private void run() {
        myFarm = new MyFarm();
        farmView = new GameView();
        initializeView();
    }
   public static void main(String[] args){
        Controller controller = new Controller();
   }

}
