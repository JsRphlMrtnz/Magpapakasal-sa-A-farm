import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Controller {
    MyFarm myFarm;
   public Controller(){
    myFarm = new MyFarm();
   }

   private void initializeView(GameView farmView) {
    addActionListeners(farmView);
    updateFarmerLabels(farmView);
    //add filestreaming for rocks and setting rocks
   }

   private void updateFarmerLabels(GameView farmView) {
    farmView.setObjectCoins(String.valueOf(myFarm.getPlayer().getCoins()));
    farmView.setLevel(String.valueOf(myFarm.getPlayer().getLevel()));
    farmView.setExp(String.valueOf(myFarm.getPlayer().getXp()));
    farmView.setFarmerType(String.valueOf(myFarm.getPlayer().getType()));
   }

   private void addActionListeners(GameView farmView) {

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
            if (myFarm.getPlayer().plow(myFarm.getTool()[0], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                farmView.setButtonText(farmView.getCurrTileIndex(), "Plowed");
                farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                farmView.setCurrTileIndex(-1);
                farmView.toggleButtons();
                updateFarmerLabels(farmView);
            }
        }
    });

    farmView.setAddWateringCanBtnListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (myFarm.getPlayer().water(myFarm.getTool()[01], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                farmView.setCurrTileIndex(-1);
                farmView.toggleButtons();
                updateFarmerLabels(farmView);
            }
        }
    });

    farmView.setAddFertilizerBtnListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (myFarm.getPlayer().fertilize(myFarm.getTool()[2], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                farmView.setCurrTileIndex(-1);
                farmView.toggleButtons();
                updateFarmerLabels(farmView);
            }
        }
    });

    farmView.setAddShovelBtnListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (myFarm.getPlayer().dig(myFarm.getTool()[3], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                farmView.setButtonText(farmView.getCurrTileIndex(), "tile");
                farmView.setCurrTileIndex(-1);
                farmView.toggleButtons();
                updateFarmerLabels(farmView);
            }
        }
    });

    farmView.setAdvanceDayActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            myFarm.endDay();
            //game over
            if (!myFarm.gameOver()) {
                farmView.setCurrTileIndex(-1);
                farmView.toggleButtons();
                farmView.setDayLabel(String.valueOf(myFarm.getDay()));
                
                for (int i = 0; i < myFarm.getTiles().length; i++) {
                    if (myFarm.getTiles()[i].getIsWithered()) {
                        farmView.setButtonText(i, "Withered");
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
              updateFarmerLabels(farmView);
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
                updateFarmerLabels(farmView);
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
                updateFarmerLabels(farmView);
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
                farmView.setButtonText(farmView.getCurrTileIndex(), "tile");
                farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                myFarm.getTiles()[farmView.getCurrTileIndex()].reset();
                farmView.setCurrTileIndex(-1);
                farmView.toggleButtons();
                updateFarmerLabels(farmView);
            }
        }
    });

    farmView.setAddPickaxeBtnListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (myFarm.getPlayer().mine(myFarm.getTool()[4], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                farmView.setButtonText(farmView.getCurrTileIndex(), "tile");
                farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                farmView.setCurrTileIndex(-1);
                farmView.toggleButtons();
                updateFarmerLabels(farmView);
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
                        farmView.setButtonText(farmView.getCurrTileIndex(), myFarm.getSeeds()[farmView.getCurrSeedIndex()].getName());
                        farmView.setFeedbackText(myFarm.getPlayer().getFeedbackString());
                        farmView.setCurrTileIndex(-1);
                        farmView.toggleButtons();
                        updateFarmerLabels(farmView);
                    }
                }
            }
        });
    }

    for (int i = 0; i < myFarm.getTiles().length; i++) {
        farmView.addActionListeneronTiles(i, new MouseListener()
        {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            if(SwingUtilities.isRightMouseButton(e)){
            JPopupMenu popup = new JPopupMenu();
            popup.add(new JLabel("Plowed: " + myFarm.getTiles()[farmView.rightClickIndex((JButton) e.getSource())].getPlowed()));
            popup.add(new JLabel("Times Watered: " + myFarm.getTiles()[farmView.rightClickIndex((JButton) e.getSource())].getWater()));
            popup.add(new JLabel("Times Fertilized: " + myFarm.getTiles()[farmView.rightClickIndex((JButton) e.getSource())].getFert()));
            popup.add(new JLabel("Days until harvest: " + myFarm.getTiles()[farmView.rightClickIndex((JButton) e.getSource())].getTime()));
            farmView.setPopupMenu(popup, farmView.rightClickIndex((JButton) e.getSource()), e.getX(), e.getY());
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
    
    farmView.toggleButtons();
  }

  private void run() {
      GameView view = new GameView();
      initializeView(view);
  }
   public static void main(String[] args){
        Controller controller = new Controller();
        controller.run();
   }

}
