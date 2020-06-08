package paoo.Game;

import javax.swing.*;
import paoo.Items.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends javax.swing.JFrame {

    public int colorp1 = 0, colorp2 = 0, gogogo = 0, mapchoiced;
    public boolean gameisready2go = false;
    ImageIcon image0 = new ImageIcon("images/backg00.png");
    ImageIcon image1 = new ImageIcon("images/backg01.png");
    ImageIcon image2 = new ImageIcon("images/backg02.png");
    ImageIcon image3 = new ImageIcon("images/backg03.png");
    ImageIcon image4 = new ImageIcon("images/backg04.png");

    public javax.swing.JPanel gamePanel;
    public JButton start = new JButton("START GAME");
    public JButton options = new JButton("CUSTOM GAME");
    public JButton quit = new JButton("QUIT GAME");


    public JLabel label = new JLabel("CHOICE YOUR COLOR");
    public JLabel cplayer1 = new JLabel("Player 1");
    public JLabel cplayer2 = new JLabel("Player 2");
    public JLabel vs = new JLabel("vs");
    public JLabel maplabel = new JLabel("CHOICE YOUR MAP");

    public JButton ready = new JButton("READY");

    public JButton map1 = new JButton(image0);
    public JButton map2 = new JButton(image1);
    public JButton map3 = new JButton(image2);
    public JButton map4 = new JButton(image3);
    public JButton map5 = new JButton(image4);


    public JButton colorp1c = new JButton();
    public JButton colorp2c = new JButton();
    public JButton color1p1 = new JButton();
    public JButton color2p1 = new JButton();
    public JButton color3p1 = new JButton();
    public JButton color4p1 = new JButton();
    public JButton color5p1 = new JButton();
    public JButton color1p2 = new JButton();
    public JButton color2p2 = new JButton();
    public JButton color3p2 = new JButton();
    public JButton color4p2 = new JButton();
    public JButton color5p2 = new JButton();


    public void Destroy() {
        gamePanel.remove(start);
        gamePanel.remove(options);
        gamePanel.remove(quit);
        gamePanel.remove(label);
        gamePanel.remove(cplayer1);
        gamePanel.remove(cplayer2);
        gamePanel.remove(vs);
        gamePanel.remove(maplabel);
        gamePanel.remove(colorp1c);
        gamePanel.remove(colorp2c);

        gamePanel.remove(map5);
        gamePanel.remove(map4);
        gamePanel.remove(map3);
        gamePanel.remove(map2);
        gamePanel.remove(map1);
        gamePanel.remove(ready);

        gamePanel.remove(color1p1);
        gamePanel.remove(color1p2);
        gamePanel.remove(color2p1);
        gamePanel.remove(color2p2);
        gamePanel.remove(color3p1);
        gamePanel.remove(color3p2);
        gamePanel.remove(color4p1);
        gamePanel.remove(color4p2);
        gamePanel.remove(color5p1);
        gamePanel.remove(color5p2);

        gamePanel.setLayout(new java.awt.GridLayout(1, 0));
        update(getGraphics());
    }

    public GameView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameView().setVisible(true);
            }
        });
    }

    private void initComponents() {

        gamePanel = new JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paoo game template");
        setPreferredSize(new java.awt.Dimension(Map.BOARD_WIDTH + 16, Map.BOARD_HEIGHT + 30));

        gamePanel.setMinimumSize(new java.awt.Dimension(Map.BOARD_WIDTH + 16, Map.BOARD_HEIGHT + 30));
        gamePanel.setSize(new java.awt.Dimension(Map.BOARD_WIDTH + 16, Map.BOARD_HEIGHT + 30));
        //gamePanel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


        pack();

    }


    public void MainMenu() {
        gamePanel.setLayout(null);
        start.setBackground(Color.blue);
        options.setBackground(Color.blue);
        quit.setBackground(Color.blue);
        options.setBounds(380, 275, 200, 75);
        quit.setBounds(380, 425, 200, 75);
        start.setBounds(380, 125, 200, 75);
        gamePanel.add(start);
        gamePanel.add(quit);
        gamePanel.add(options);
        Pressed();
        update(getGraphics());
    }

    public void testfunct() {
        start.setBounds(10, 15, 200, 75);
        gamePanel.add(start);
        update(getGraphics());
    }

    public void OptionsPressed() {
        setColors();
        label.setBounds(400, 25, 1000, 100);
        cplayer1.setBounds(205, 75, 1000, 100);
        cplayer2.setBounds(695, 75, 1000, 100);
        vs.setBounds(460, 140, 1000, 100);
        maplabel.setBounds(410, 290, 1000, 100);
        ready.setBounds(405, 300, 125, 25);
        ready.setBackground(Color.red);
        gamePanel.add(label);
        gamePanel.add(cplayer1);
        gamePanel.add(cplayer2);
        gamePanel.add(vs);
        gamePanel.add(maplabel);
        gamePanel.add(ready);

        update(getGraphics());
    }

    public void Pressed() {
        options.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          Destroy();
                                          OptionsPressed();
                                      }
                                  }
        );
        ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ready.setBackground(Color.green);
                if (colorp1 == 0) {
                    Random rand = new Random();
                    colorp1 = rand.nextInt(6);
                    while (colorp1 == 0) {
                        colorp1 = rand.nextInt(6);

                    }
                }
                if (colorp2 == 0) {
                    Random rand = new Random();
                    colorp2 = rand.nextInt(6);
                    while (colorp2 == 0) {
                        colorp2 = rand.nextInt(6);
                    }
                }
                DoColor();
                gogogo = 1;
            }
        });
        map1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (gogogo == 1) {
                    mapchoiced = 1;
                    gameisready2go = true;
                }
            }
        });
        map2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (gogogo == 1) {
                    mapchoiced = 2;
                    gameisready2go = true;
                }
            }
        });
        map3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (gogogo == 1) {
                    mapchoiced = 3;
                    gameisready2go = true;
                }
            }
        });
        map4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (gogogo == 1) {
                    mapchoiced = 4;
                    gameisready2go = true;
                }
            }
        });
        map5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (gogogo == 1) {
                    mapchoiced = 5;
                    gameisready2go = true;
                }
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                mapchoiced = rand.nextInt(6);
                rand = new Random();
                colorp1 = rand.nextInt(6);
                rand = new Random();
                colorp2 = rand.nextInt(6);
                while (mapchoiced == 0) {
                    rand = new Random();
                    mapchoiced = rand.nextInt(6);
                }
                while (colorp1 == 0) {
                    rand = new Random();
                    colorp1 = rand.nextInt(6);
                }
                while (colorp2 == 0) {
                    rand = new Random();
                    colorp2 = rand.nextInt(6);
                }
                gameisready2go = true;
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        color1p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorp1 = 1;
                ready.setBackground(Color.red);
                gogogo = 0;
                DoColor();
            }
        });
        color2p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorp1 = 2;
                ready.setBackground(Color.red);
                gogogo = 0;
                DoColor();
            }
        });
        color3p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorp1 = 3;
                ready.setBackground(Color.red);
                gogogo = 0;
                DoColor();
            }
        });
        color4p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorp1 = 4;
                ready.setBackground(Color.red);
                gogogo = 0;
                DoColor();
            }
        });
        color5p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorp1 = 5;
                ready.setBackground(Color.red);
                gogogo = 0;
                DoColor();
            }
        });
        color1p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorp2 = 1;
                ready.setBackground(Color.red);
                gogogo = 0;
                DoColor();
            }
        });
        color2p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorp2 = 2;
                ready.setBackground(Color.red);
                gogogo = 0;
                DoColor();
            }
        });
        color3p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorp2 = 3;
                ready.setBackground(Color.red);
                gogogo = 0;
                DoColor();
            }
        });
        color4p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorp2 = 4;
                ready.setBackground(Color.red);
                gogogo = 0;
                DoColor();
            }
        });
        color5p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorp2 = 5;
                ready.setBackground(Color.red);
                gogogo = 0;
                DoColor();
            }
        });

    }

    public void DoColor() {
        if (colorp1 == 1) {
            colorp1c.setBackground(new Color(102, 178, 255));
        } else if (colorp1 == 2) {
            colorp1c.setBackground(new Color(255, 255, 0));
        } else if (colorp1 == 3) {
            colorp1c.setBackground(Color.pink);
        } else if (colorp1 == 4) {
            colorp1c.setBackground(Color.white);
        } else if (colorp1 == 5) {
            colorp1c.setBackground(new Color(0, 0, 153));
        }


        if (colorp2 == 1) {
            colorp2c.setBackground(new Color(255, 0, 0));
        } else if (colorp2 == 2) {
            colorp2c.setBackground(new Color(153, 40, 123));
        } else if (colorp2 == 3) {
            colorp2c.setBackground(new Color(128, 255, 0));
        } else if (colorp2 == 4) {
            colorp2c.setBackground(new Color(102, 51, 0));
        } else if (colorp2 == 5) {
            colorp2c.setBackground(new Color(0, 153, 0));
        }
    }

    public void setColors() {
        color1p1.setBackground(new Color(102, 178, 255));
        color2p1.setBackground(new Color(255, 255, 0));
        color3p1.setBackground(Color.pink);
        color4p1.setBackground(Color.white);
        color5p1.setBackground(new Color(0, 0, 153));

        color1p2.setBackground(new Color(255, 0, 0));
        color2p2.setBackground(new Color(153, 40, 123));
        color3p2.setBackground(new Color(128, 255, 0));
        color4p2.setBackground(new Color(102, 51, 0));
        color5p2.setBackground(new Color(0, 153, 0));

        map1.setBounds(190, 360, 180, 120);
        map2.setBounds(390, 360, 180, 120);
        map3.setBounds(590, 360, 180, 120);
        map4.setBounds(290, 500, 180, 120);
        map5.setBounds(490, 500, 180, 120);


        colorp1c.setBounds(400, 170, 40, 40);
        colorp2c.setBounds(495, 170, 40, 40);

        color1p1.setBounds(195, 150, 25, 25);
        color2p1.setBounds(235, 150, 25, 25);
        color3p1.setBounds(195, 190, 25, 25);
        color4p1.setBounds(235, 190, 25, 25);
        color5p1.setBounds(215, 230, 25, 25);

        color1p2.setBounds(685, 150, 25, 25);
        color2p2.setBounds(725, 150, 25, 25);
        color3p2.setBounds(685, 190, 25, 25);
        color4p2.setBounds(725, 190, 25, 25);
        color5p2.setBounds(705, 230, 25, 25);

        gamePanel.add(map1);
        gamePanel.add(map2);
        gamePanel.add(map3);
        gamePanel.add(map4);
        gamePanel.add(map5);

        gamePanel.add(color1p1);
        gamePanel.add(color2p1);
        gamePanel.add(color3p1);
        gamePanel.add(color4p1);
        gamePanel.add(color5p1);

        gamePanel.add(color1p2);
        gamePanel.add(color2p2);
        gamePanel.add(color3p2);
        gamePanel.add(color4p2);
        gamePanel.add(color5p2);

        gamePanel.add(colorp1c);
        gamePanel.add(colorp2c);
    }

    public JPanel getPanel() {
        return gamePanel;
    }

}
