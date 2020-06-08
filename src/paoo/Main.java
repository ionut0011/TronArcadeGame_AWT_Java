package paoo;
import java.sql.*;
import paoo.Game.GameView;
import paoo.Game.Board;
import paoo.Game.DataBase;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // DREAPTA ESTE PLAYER 2 BAAA
        // STANGA ESTE PLAYER 1 BAAAA

        boolean run = false, iwantrestart = false;
        boolean runningthegame = false;
        int doinsert=0,here=0,firstgame=1;
        Connection con = null;
        Statement state = null;
        GameView theView = new GameView();
        Board panel = new Board();

        theView.MainMenu();
        theView.setVisible(true);
        DataBase data = new DataBase(con,state);
        //data.newDatabase();

        while (!runningthegame) {
           // System.out.println("ajung 1");

            if(doinsert==1)
            {
                data.InsertEverywhere(here,panel.winneris,theView.colorp1,theView.colorp2,theView.mapchoiced,0,panel.rwins,panel.bwins);
                doinsert=0; panel.winneris=0;

            }

            if (iwantrestart) {
                panel = new Board();
                theView.MainMenu();
                theView.colorp1c.setBackground(null);
                theView.colorp2c.setBackground(null);
                theView.setVisible(true);
                iwantrestart = false;
            }

            System.out.checkError();
            if (theView.gameisready2go) {
                theView.Destroy();
                panel.level = theView.mapchoiced - 1;
                panel = new Board(panel.level, theView.colorp1 - 1, theView.colorp2 - 1);
                run = true;
               // System.out.println("Ajung aici");
                theView.gameisready2go = false;
            }

           // System.out.println("ajung 3");
            //System.out.println("here= "+here);

            int justone = 1;
            here=0;
            while (run) {
                panel.requestFocusInWindow();
                if (here != 0 && justone != 0) {
             //     System.out.println("sunt la here");
                    panel.initALL(panel.backgn);
                    panel.InitImages();
                    justone = 0;
                }
                if(doinsert==1)
                {
                    if(firstgame==1) {
                        data.InsertEverywhere(here, panel.winneris, theView.colorp1 , theView.colorp2 , theView.mapchoiced, firstgame,panel.rwins,panel.bwins);
                        firstgame=0;
                    }
                    else {
                        data.InsertEverywhere(here, panel.winneris, theView.colorp1, theView.colorp2, theView.mapchoiced, 0,panel.rwins,panel.bwins);
                    }
                    System.out.println("am facut insert");
                    doinsert=0;
                    panel.winneris=0;
                }
                while (panel.running) {
                    //panel.runningspace = false;
                    panel.revalidate();
                    panel.repaint();
                    theView.getPanel().add(panel);
                    panel.requestFocusInWindow();
                    theView.setVisible(true);
                 //  System.out.println("main running panel");
                    panel.move();
                }
                panel.SetScore();

                if (panel.runningspace == true) {
                  //  System.out.println("sunt in if main");
                    panel.running = true;
                    justone = 2;
                    here++;
                    System.out.println("here= "+here);
                    doinsert=1;
                    if (panel.rwins == 3 || panel.bwins == 3) {
                        run = false;
                        iwantrestart = true;
                        theView.getPanel().remove(panel);
                    }
                }
            }
        }
    }
}
