package paoo.Items;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import paoo.Game.Map;
import paoo.Game.Board;

public class Red extends Item {
    private final int BOARD_WIDTH = Map.BOARD_WIDTH;
    private final int BOARD_HEIGHT = Map.BOARD_HEIGHT;
    public int dxr,dyr;
    public int direction = 3;
    public boolean exit=false;
    public int speed=0, turbo=3;
    public boolean pressed = false;
    public int ok=0;


    public Red(int x, int y, int color) {
        super(x, y);
        if(color==0) {
            loadImage("images/redhead.png");
        }
        else if(color==1)
        {
            loadImage("images/redhead1.png");
        }
        else if(color==2)
        {
            loadImage("images/redhead2.png");
        }
        else if(color==3)
        {
            loadImage("images/redhead3.png");
        }
        else if(color==4)
        {
            loadImage("images/redhead4.png");
        }
        getImageDimensions();

    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void DoMove()
    {

        if(direction==0)
        {
            if(y<64){exit=true; pressed=true;}
            else {
                y = y - 8;
                x = x + 0;
            }
            //System.out.println("directia0");

        }
        if(direction==1)
        {
            if(x>952){exit=true; pressed=true;}
            else {
                x = x + 8;
                y = y + 0;

            }
           // System.out.println("directia1");
        }
        if(direction==2)
        {
            if(y>632){exit=true; pressed=true;}
            else {
                y = y + 8;
                x = x + 0;

            }
           // System.out.println("directia2");
        }
        if(direction==3)
        {
            if(x<0)
            { exit=true; pressed=true;}
            else {
                x = x - 8;
                y = y + 0;

            }

          //  System.out.println("directia3");
        }
    }

    public void keyPresssed(int key) {

        //int key = e.getKeyCode();
        int left = KeyEvent.VK_LEFT;
        System.out.println("left= "+left);
        System.out.println("key= "+key);
        System.out.println("in keypressed red");
            if (key == KeyEvent.VK_LEFT && direction!=1) {
                 direction = 3; ok=0;
                pressed=false;
            } else if (key == KeyEvent.VK_RIGHT && direction!=3) {
                direction = 1;
                pressed=false; ok=0;
            } else if (key == KeyEvent.VK_UP && direction!=2) {

                direction = 0; ok=0;
                pressed=false;
            } else if (key == KeyEvent.VK_DOWN && direction!=0) {

                pressed=false; ok=0;
                direction = 2;
            } else if (key==KeyEvent.VK_ENTER && turbo!=0)
            {

                turbo--; ok=0;
                speed=10;
                pressed=false;

            }
            else
            {
                pressed=false;
            }

        }


    public void Check(Map map) {

        if (y < 64) {
            System.out.println("sunt aici");
            exit = true;
            pressed = true;
        }
        if (x > 952) {
            System.out.println("sunt aici");
            exit = true;
            pressed = true;
        }
        if (y > 632) {
            System.out.println("sunt aici");
            exit = true;
            pressed = true;
        }
        if (x < 0) {
            System.out.println("sunt aici");
            exit = true;
            pressed = true;
        }
        if(x>952) {
            if (map.level[y / 8 - 1][x / 8 - 1] == 2) {
                System.out.println("l-am lovit");
                exit = true;
                pressed = true;
            }
            if (map.level[y / 8 - 1][x / 8 - 1] == 4) {
                System.out.println("am lovit capul");
                exit = true;
                pressed = true;
            }
            if (map.level[y / 8 - 1][x / 8 - 1] == 1) {
                System.out.println("l-am lovit");
                exit = true;
                pressed = true;
            }
            if (map.level[y / 8 - 1][x / 8 - 1] == 3) {
                System.out.println("am lovit capul");
                exit = true;
                pressed = true;
            }
        }else if(x<0)
        {
            if (map.level[y / 8 + 1][x / 8 + 1] == 2) {
                System.out.println("l-am lovit");
                exit = true;
                pressed = true;
            }
            if (map.level[y / 8 + 1][x / 8 + 1] == 4) {
                System.out.println("am lovit capul");
                exit = true;
                pressed = true;
            }
            if (map.level[y / 8 + 1][x / 8 + 1] == 1) {
                System.out.println("l-am lovit");
                exit = true;
                pressed = true;
            }
            if (map.level[y / 8 + 1][x / 8 + 1] == 3) {
                System.out.println("am lovit capul");
                exit = true;
                pressed = true;
            }
        }else {
            if(x/8!=8) {
                if(y<624) {
                    if (map.level[y / 8][x / 8] == 1) {
                        System.out.println("l-am lovit 12");

                        exit = true;
                        pressed = true;
                    }
                    if (map.level[y / 8][x / 8] == 3) {
                        System.out.println("am lovit capul 13");
                        exit = true;
                        pressed = true;
                    }
                    if (map.level[y / 8][x / 8] == 2) {
                        System.out.println("am lovit capul 14");

                        exit = true;
                        pressed = true;
                    }
                    if (map.level[y / 8][x / 8] == 4) {
                        System.out.println("am lovit capul 15");
                        exit = true;
                        pressed = true;
                    }
                    if (map.level[y / 8][x / 8] == 5) {
                        System.out.println("am lovit capul 15");
                        exit = true;
                        pressed = true;
                    }
                }
                else if(y>624)
                {
                    if (map.level[y / 8-1][x / 8-1] == 1) {
                        System.out.println("l-am lovit 12");

                        exit = true;
                        pressed = true;
                    }
                    if (map.level[y / 8-1][x / 8-1] == 3) {
                        System.out.println("am lovit capul 13");
                        exit = true;
                        pressed = true;
                    }
                    if (map.level[y / 8-1][x / 8-1] == 2) {
                        System.out.println("am lovit capul 14");

                        exit = true;
                        pressed = true;
                    }
                    if (map.level[y / 8-1][x / 8-1] == 4) {
                        System.out.println("am lovit capul 15");
                        exit = true;
                        pressed = true;
                    }
                    if (map.level[y / 8-1][x / 8-1] == 5) {
                        System.out.println("am lovit capul 15");
                        exit = true;
                        pressed = true;
                    }
                }
            }
        }

      //  System.out.println("red = " + map.level[y / 8 - 1][x / 8 - 1]);

    }

}
