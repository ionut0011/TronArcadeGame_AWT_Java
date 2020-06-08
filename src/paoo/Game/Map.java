package paoo.Game;
import java.*;
import java.util.Scanner;
import java.util.Arrays;
import java.awt.*;
import java.io.*;

public class Map {
    public static final int BOARD_WIDTH = 8 * 120;
    public static final int BOARD_HEIGHT = 8 * 80 + 28;
    public int is=0,nr;
    public int[][] level = new int[80][120];
    public void setMap(int nr) {

        System.out.println("sunt in setmap");
        if(is==0 && nr==0) {
            for (int i = 0; i < 80; i++) {
                for (int j = 0; j < 120; j++) {
                    level[i][j] = 0;
                }
            }
        }
        if(is==0 && nr==1) {
           try {
               System.out.println("sunt in scanner");
               Scanner sc = new Scanner(new BufferedReader(new FileReader("backg1.txt")));
               while (sc.hasNextLine()) {
                   for (int i = 0; i < 80; i++) {
                       String[] line = sc.nextLine().trim().split("");
                       for (int j = 0; j < 120; j++) {
                           level[i][j] = Integer.parseInt(line[j]);
                           //System.out.println("level["+i+"]["+j+"]= "+level[i][j]);
                       }
                   }
               }
           }catch(Exception e1){
               System.out.println("exceptie= " +e1);
           }
        }
        if(is==0 && nr==2)
        {
            try {
                System.out.println("sunt in scanner");
                Scanner sc = new Scanner(new BufferedReader(new FileReader("backg2.txt")));
                while (sc.hasNextLine()) {
                    for (int i = 0; i < 80; i++) {
                        String[] line = sc.nextLine().trim().split("");
                        for (int j = 0; j < 120; j++) {
                            level[i][j] = Integer.parseInt(line[j]);
                            System.out.println("level["+i+"]["+j+"]= "+level[i][j]);
                        }
                    }
                }
            }catch(Exception e1){
                System.out.println("exceptie= " +e1);
            }
        }
        if(is==0 && nr==3)
        {
            try {
                System.out.println("sunt in scanner");
                Scanner sc = new Scanner(new BufferedReader(new FileReader("backg3.txt")));
                while (sc.hasNextLine()) {
                    for (int i = 0; i < 80; i++) {
                        String[] line = sc.nextLine().trim().split("");
                        for (int j = 0; j < 120; j++) {
                            level[i][j] = Integer.parseInt(line[j]);
                           // System.out.println("level["+i+"]["+j+"]= "+level[i][j]);
                        }
                    }
                }
            }catch(Exception e1){
                System.out.println("exceptie= " +e1);
            }
        }
        if(is==0 && nr==4)
        {
            try {
                System.out.println("sunt in scanner");
                Scanner sc = new Scanner(new BufferedReader(new FileReader("backg4.txt")));
                while (sc.hasNextLine()) {
                    for (int i = 0; i < 80; i++) {
                        String[] line = sc.nextLine().trim().split("");
                        for (int j = 0; j < 120; j++) {
                            level[i][j] = Integer.parseInt(line[j]);
                           // System.out.println("level["+i+"]["+j+"]= "+level[i][j]);
                        }
                    }
                }

            }catch(Exception e1){
                System.out.println("exceptie= " +e1);
            }
        }
        is=1;
    }
}
