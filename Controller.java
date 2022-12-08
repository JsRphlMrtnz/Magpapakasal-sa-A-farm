import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    MyFarm myFarm;
   public Controller(){
        myFarm = new MyFarm("temp");
   }

   private void addEventListeners(GameView farmView) {
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
                  farmView.setCurrTileIndex(-1);
                  farmView.toggleButtons();
              }
          }
      });

      farmView.setAddWateringCanBtnListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (myFarm.getPlayer().water(myFarm.getTool()[01], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                  farmView.setCurrTileIndex(-1);
                  farmView.toggleButtons();
              }
          }
      });

      farmView.setAddFertilizerBtnListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (myFarm.getPlayer().fertilize(myFarm.getTool()[2], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                  farmView.setCurrTileIndex(-1);
                  farmView.toggleButtons();
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
              }
          }
      });

      for (int i = 0; i < 1; i++) {
          farmView.setAddSeedBtnListener(i, new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  farmView.setCurrSeedIndex(farmView.currSeedIndex((JButton) e.getSource()));
                  if (myFarm.getPlayer().plant(myFarm.getSeeds()[farmView.getCurrSeedIndex()], myFarm.getTiles()[farmView.getCurrTileIndex()])) {
                      farmView.setButtonText(farmView.getCurrTileIndex(), myFarm.getSeeds()[farmView.getCurrSeedIndex()].getName());
                      farmView.setCurrTileIndex(-1);
                      farmView.toggleButtons();
                  }
              }
          });
      }

      farmView.toggleButtons();
  }

  private void run() {
      GameView view = new GameView();
      addEventListeners(view);
  }
   public static void main(String[] args){
        Controller controller = new Controller();
        controller.run();
   }

}
