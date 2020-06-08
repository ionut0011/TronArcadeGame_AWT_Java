package paoo.Game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.*;
import java.security.Key;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.TimerTask;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import paoo.Game.DataBase;
import paoo.Items.*;

import javax.swing.*;
import java.sql.*;
/**
 * Board class of the game
 */
public class Board extends JPanel implements ActionListener {

    Image scoreb = Toolkit.getDefaultToolkit().createImage("images/scoreboard.png");
    Image press = Toolkit.getDefaultToolkit().createImage("images/press2continue.png");
    Image progress = Toolkit.getDefaultToolkit().createImage("images/gameinprogress.png");
    Image backg;
    Image background = Toolkit.getDefaultToolkit().createImage("images/trongame.png");
    public ArrayList<Item> itemsRT = new ArrayList<>();
    public ArrayList<Item> itemsRed = new ArrayList<>();
    public ArrayList<Item> itemsBlue = new ArrayList<>();
    public ArrayList<Item> itemsBT = new ArrayList<>();
    public ArrayList<Item> itemsNR = new ArrayList<>();
    Statement x = null;
    Connection y = null;
    DataBase d = new DataBase(y,x);

    Red rL;
    Blue bL;
    Map map;
    public int winneris=0;
    public int backgn, level;
    public int colorp1, colorp2;
    public int dxr, dyr, dxb, dyb;
    public int xrs, yrs, xbs, ybs;
    public int nr;
    public int cr, cb, testtt;
    public int bwins = 0, rwins = 0, head = 0;
    public int removectr, waitForOverride;
    public boolean running = true, once, delete;
    public boolean redp, bluep, runningspace;
    public boolean testb, head2head, spacepressed;
    public int mainmenu=1;
    public Board(int level, int colorp1, int colorp2) {
        this.backgn = level;
        this.level = level;
        this.colorp1 = colorp1;
        this.colorp2 = colorp2;
        initBoard(level);
    }

    public Board() {
    }

    public void initALL(int level) {
        // System.out.println("sunt in initALL");
        itemsRed.clear();
        itemsBlue.clear();
        //itemsNR.clear();
        itemsBT.clear();
        itemsRT.clear();
        map = new Map();
        setMappp(level);
        // System.out.println("map in= " + map.is);
        if (bwins == 0 && rwins == 0) {
            rL = new Red(640, 320, colorp2);
            bL = new Blue(320, 320, colorp1);
        } else {
            rL.x = 640;
            rL.y = 320;
            bL.x = 320;
            bL.y = 320;
        }
        bL.bringLevel(level);
        nr = 0;
        testtt = 0;
        cr = 0;
        cb = 0;
        removectr = 0;
        waitForOverride = 0;
        once = false;
        delete = false;
        runningspace = false;
        redp = true;
        bluep = true;
        head2head = false;
        testb = false;
        rL.pressed = false;
        bL.pressed = false;
        rL.exit = false;
        bL.exit = false;
        rL.turbo=3;
        bL.turbo=3;
        spacepressed = false;
        rL.speed = 0;
        bL.speed = 0;

        map.setMap(level);
        rL.direction = 3;
        bL.direction = 1;
    }

    /**
     * Initialize the board.
     */
    private void initBoard(int level) {
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Map.BOARD_WIDTH, Map.BOARD_HEIGHT));
        initALL(level);
        InitImages();
        addKeyListener(new Apasat());
        //   initBlocks();

    }

    public void setMappp(int level) {
        if (level == 0) {
            backg = Toolkit.getDefaultToolkit().createImage("images/backg.png");
        } else if (level == 1) {
            backg = Toolkit.getDefaultToolkit().createImage("images/backg1.png");
        } else if (level == 2) {
            backg = Toolkit.getDefaultToolkit().createImage("images/backg2.png");
        } else if (level == 3) {
            backg = Toolkit.getDefaultToolkit().createImage("images/backg3.png");
        } else if (level == 4) {
            backg = Toolkit.getDefaultToolkit().createImage("images/backg4.png");
        }
        repaint();
    }

    public boolean running() {
        return running;
    }

    public void move() {
        if (bwins == 0 && rwins == 0 && head == 0) {
            itemsNR.add(2, new DeadandGame(205, 640, 1));
        } else {
            itemsNR.set(2, new DeadandGame(205, 640, 1));
        }
        System.out.println("move before while");
        while (rL.pressed == false && bL.pressed == false) {
            speed();
            requestFocusInWindow();
            System.out.println("move in while");
            try {
                TimeUnit.MILLISECONDS.sleep(60);
            } catch (InterruptedException ex) {
            }
            bL.DoMove();
            rL.DoMove();
            bL.Check(map);
            rL.Check(map);
            System.out.println("blexit= " + bL.exit + " rlexit= " + rL.exit);

            if (bL.exit == false && rL.exit == false) {
                revalidate();
                repaint();
                CheckBorder();
                RedAdd();
                BlueAdd();
                Gamewon();
            }
            System.out.println("dyb= " + dyb + " dyr= " + dyr + " dxb= " + dxb + " dxr= " + dxr);
            if (dyb == dyr && dxb == dxr) {
                bL.pressed = true;
                delete = true;
                head2head = true;
            }

        }

        if (bL.pressed == true && rL.pressed == false) {
            System.out.println("once= " + once);
            System.out.println("am intrat in conditia de bl pressed");
            System.out.println("head2head= " + head2head);
            if (!head2head) {
                itemsBlue.remove(0);
                // itemsBlue.remove(itemsBlue.size()-1);
                bwins++;
                winneris=2;
                itemsRed.remove(0);
                System.out.println("before add 1");
                itemsBlue.set(itemsBlue.size() - 1, new DeadandGame(xbs, ybs, colorp1 + 7));

                System.out.println("after add 1");
            } else {
                head++;
                winneris=3;
                itemsBlue.remove(0);
                itemsRed.remove(0);
                System.out.println("before add 2");
                itemsBlue.set(itemsBlue.size() - 1, new DeadandGame(xbs - 8, ybs, colorp1 + 7));
                System.out.println("after add 2");
                itemsRed.set(itemsRed.size() - 1, new DeadandGame(xrs, yrs, colorp2 + 2));
            }
            System.out.println("head2head= " + head2head);
            itemsNR.set(2, new DeadandGame(206, 640, 0));
            System.out.println("am facut set size si dead");

            System.out.println("once= " + once + " test= " + testb);
            if (testb) {
                once = true;
            }
            spacepressed = true;
            waitForOverride++;
            testb = true;


        } else if (rL.pressed == true && bL.pressed == false) {
            System.out.println("am intrat in conditia de rl pressed");
            rwins++;
            itemsBlue.remove(0);
            itemsRed.remove(0);
            itemsRed.set(itemsRed.size() - 1, new DeadandGame(xrs, yrs, colorp2 + 2));
            itemsNR.set(2, new DeadandGame(206, 640, 0));
            winneris=1;
            waitForOverride++;
            spacepressed = true;
        } else if (rL.pressed == true && bL.pressed == true) {
            head2head = true;
            System.out.println("once= " + once);
            winneris=3;
            System.out.println("am intrat in conditia de bl pressed");
            System.out.println("head2head= " + head2head);
            if (!head2head) {
                itemsBlue.remove(0);
                // itemsBlue.remove(itemsBlue.size()-1);
                bwins++;

                itemsRed.remove(0);
                System.out.println("before add 1");
                itemsBlue.set(itemsBlue.size() - 1, new DeadandGame(xbs, ybs, colorp1 + 7));

                System.out.println("after add 1");
            } else {
                head++;
                itemsBlue.remove(0);
                itemsRed.remove(0);
                System.out.println("before add 2");
                itemsBlue.set(itemsBlue.size() - 1, new DeadandGame(xbs, ybs, colorp1 + 7));
                System.out.println("after add 2");
                itemsRed.set(itemsRed.size() - 1, new DeadandGame(xrs, yrs, colorp2 + 2));
            }
            System.out.println("head2head= " + head2head);
            itemsNR.set(2, new DeadandGame(206, 640, 0));
            System.out.println("am facut set size si dead");

            System.out.println("once= " + once + " test= " + testb);
            if (testb) {
                once = true;
            }
            spacepressed = true;
            waitForOverride++;
            testb = true;
        }
        drawObjects(getGraphics(), 0);
        System.out.println("bwins= " + bwins + " rwins= " + rwins);
        System.out.println("waitforover= " + waitForOverride);
        // SetScore();
        validate();
        repaint();
        if (waitForOverride == 1) {
            running = false;
        }
        if (bwins == 3 || rwins == 3) {
            running = false;
        }

    }

    public class Apasat extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            try {
                int key = e.getKeyCode();
                System.out.println("in keypressed");
                rL.pressed = true;
                bL.pressed = true;
                rL.keyPresssed(key);
                bL.keyPresssed(key);
                Space(e);
            } catch (Exception e1) {
                System.out.println("exceptie in keypressed= " + e1);
            }
        }
    }

    public void Space(KeyEvent f) {

        int key = f.getKeyCode();
        System.out.println("space before if");
        if (key == KeyEvent.VK_SPACE && spacepressed == true && (rL.ok < 1 && bL.ok < 1)) {

            System.out.println("space in if");

            runningspace = true;
        }
    }

    /**
     * Initialize blocks according to the map.
     */
    public void CheckBorder() {
        System.out.println("sunt in checkborder");
        if (bL.x < 16)
            dxb = 1;
        else {
            System.out.println("bl.x= " + bL.x);
            dxb = bL.x / 8;
        }
        if (bL.y < 72)
            dyb = 8;
        else {
            System.out.println("bl.x= " + bL.y);
            dyb = bL.y / 8;
        }
        if (rL.x < 16)
            dxr = 1;
        else
            dxr = rL.x / 8;
        if (rL.y < 72)
            dyr = 8;
        else
            dyr = rL.y / 8;
    }

    public void initBlocks() {
        int type;

        for (int x = 0; x < map.level.length; x += 1) {
            for (int y = 0; y < map.level[x].length; y += 1) {
                type = map.level[x][y];
                BlockType bType = BlockType.getTypeFromInt(type);
                switch (bType) {
                    case backgrnd:
                        //itemsBlue.add(new Background(y * 32, x * 32));
                        break;
                    case red:
                        itemsRed.add(new RedImage(y * 8, x * 8, level));
                        break;
                    case blue:
                        itemsBlue.add(new BlueImage(y * 8, x * 8, level));
                    default:
                        break;
                }
            }
        }

    }


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(backg, 0, 64, null);
        g.drawImage(scoreb, 96, 0, null);
        drawObjects(g, 0);
        Toolkit.getDefaultToolkit().sync();

    }

    /**
     * Draw objects on the board.
     */
    private void drawObjects(Graphics g, int nr) {
        if (nr == 0) {
            try {

                for (Item b : itemsRT) {
                    if (b.isVisible()) {
                        g.drawImage(b.getImage(), b.getX(), b.getY(), this);
                        //System.out.println("x= " + a.getX() + "y= " + a.getY()+ "a= " + a);
                    }
                }
                for (Item c : itemsBT) {
                    if (c.isVisible()) {
                        g.drawImage(c.getImage(), c.getX(), c.getY(), this);
                        //System.out.println("x= " + a.getX() + "y= " + a.getY()+ "a= " + a);
                    }
                }
                for (Item d : itemsNR) {
                    if (d.isVisible()) {
                        g.drawImage(d.getImage(), d.getX(), d.getY(), this);
                        //System.out.println("x= " + a.getX() + "y= " + a.getY()+ "a= " + a);
                    }
                }
                for (Item d : itemsRed) {
                    if (d.isVisible()) {
                        g.drawImage(d.getImage(), d.getX(), d.getY(), this);
                        //  System.out.println("x= " + d.getX() + " y= " + d.getY() + " itemR= " + d);
                    }
                }
                for (Item d : itemsBlue) {
                    if (d.isVisible()) {
                        g.drawImage(d.getImage(), d.getX(), d.getY(), this);
                        //   System.out.println("x= " + d.getX() + " y= " + d.getY() + " itemB= " + d);
                    }
                }

            } catch (ConcurrentModificationException e1) {
            } catch (NullPointerException e1) {
            }
        } else if (nr == 1) {
            try {
                for (Item d : itemsNR) {
                    if (d.isVisible()) {
                        g.drawImage(d.getImage(), d.getX(), d.getY(), this);
                        //  System.out.println("x= " + d.getX() + " y= "+d.getY()+ " itemNR= " + d);
                    }
                }
            } catch (ConcurrentModificationException e1) {
            } catch (NullPointerException e1) {
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void RedAdd() {
        map.level[dyr][dxr] = 1;

        if (cr == 1 && rL.speed == 0) {
            itemsRed.remove(itemsRed.size() - 1);
            itemsRed.add(new RedImage(xrs, yrs, colorp2));
            // System.out.println("sunt in redadd");
            validate();


        } else if (cr == 1 && rL.speed != 0) {
            itemsRed.remove(itemsRed.size() - 1);
            itemsRed.add(new RedTurboPoint(xrs, yrs, colorp2));
            validate();
        }
        cr = 1;
        xrs = rL.x;
        yrs = rL.y;

        itemsRed.add(new RedH(rL.x, rL.y, colorp2));
        validate();
        System.out.println("last= " + map.level[dyr][dxr]);

        redp = true;
    }

    public void BlueAdd() {
        map.level[dyb][dxb] = 2;

        if (cb == 1 && bL.speed == 0) {
            itemsBlue.remove(itemsBlue.size() - 1);
            itemsBlue.add(new BlueImage(xbs, ybs, colorp1));
            System.out.println("sunt in blueadd");
            validate();
        } else if (cb == 1 && bL.speed != 0) {
            itemsBlue.remove(itemsBlue.size() - 1);
            itemsBlue.add(new BlueTurboPoint(xbs, ybs, colorp1));
            validate();
        }
        cb = 1;
        xbs = bL.x;
        ybs = bL.y;
        nr++;
        itemsBlue.add(new BlueH(bL.x, bL.y, colorp1));
        validate();
        bluep = true;
    }

    public void speed() {
        if (rL.speed != 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(15);
                rL.DoMove();
                rL.Check(map);
                revalidate();
                repaint();
                CheckBorder();
                RedAdd();
                rL.speed--;
                if (rL.speed == 9) {
                    itemsRT.remove(0);
                    removectr++;
                }
            } catch (InterruptedException ex) {
            }
        }
        if (bL.speed != 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(15);
                bL.DoMove();
                bL.Check(map);
                revalidate();
                repaint();
                CheckBorder();
                BlueAdd();
                bL.speed--;
                if (bL.speed == 9) {
                    itemsBT.remove(0);
                }
            } catch (InterruptedException ex) {
            }

        }
    }

    public void InitImages() {
        System.out.println("sunt in initimages");
        itemsRT.add(new RedTurboPoint(813, 41, colorp2 + 5));
        // validate();
        itemsRT.add(new RedTurboPoint(790, 41, colorp2 + 5));
        // validate();
        itemsRT.add(new RedTurboPoint(767, 41, colorp2 + 5));
        //  validate();
        itemsBT.add(new BlueTurboPoint(180, 41, colorp1 + 5));
        //  validate();
        itemsBT.add(new BlueTurboPoint(157, 41, colorp1 + 5));
        // validate();
        itemsBT.add(new BlueTurboPoint(134, 41, colorp1 + 5));
        // validate();
        itemsRed.add(rL);
        //  validate();
        itemsBlue.add(bL);
        //  validate();
        if (bwins == 0 && rwins == 0 && head == 0) {
            itemsNR.add(new Zero(269, 17));
            //     validate();
            itemsNR.add(new Zero(657, 17));
            //   validate();
        }
    }

    public void Gamewon() {
        if (bL.x - 8 < 0 && bL.direction == 3) {
            System.out.println("ai pierdut");
        } else if (bL.y - 8 < 64 && bL.direction == 0) {
            System.out.println("ai pierdut");
        } else if (bL.x + 8 > 952 && bL.direction == 1) {
            System.out.println("ai pierdut");
        } else if (bL.y + 8 > 624 && bL.direction == 2) {
            System.out.println("ai pierdut");
        }
        System.out.println("sunt in gamewon");
    }

    public void SetScore() {
        if (bwins == 1) {
            itemsNR.set(1, new Unu(657, 17));
        }
        if (bwins == 2) {
            itemsNR.set(1, new Doi(657, 17));
        }
        if (bwins == 3) {
            itemsNR.set(1, new Trei(657, 17));
        }
        if (rwins == 1) {
            itemsNR.set(0, new Unu(269, 17));
        }
        if (rwins == 2) {
            itemsNR.set(0, new Doi(269, 17));
        }
        if (rwins == 3) {
            itemsNR.set(0, new Trei(269, 17));
        }

        revalidate();
        repaint();

        //drawObjects(getGraphics(),1);
    }

}
