package paoo.Game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {
    Connection con;
    Statement state;
    public String sql;
    public int count=0;
    public DataBase(Connection con, Statement state)
    {
        this.con=con;
        this.state=state;

    }
    public void newDatabase()
    {
        try { Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:jocPAOO.db");
            state = con.createStatement(); String sql = "CREATE TABLE TRONGAME "
                    + "(ROUND TEXT  NULL,"
                    + " WINNER TEXT NULL, "
                    + " PLAYER_1_COLOR TEXT NULL, "
                    + " PLAYER_2_COLOR TEXT NULL, "
                    + " MAP INT NULL, "+
                    " PLAYER_1_WINS INT NULL, "+
                    " PLAYER_2_WINS INT NULL)";
            state.executeUpdate(sql);
            state.close(); con.close();
        } catch ( Exception e )
        { System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0); }
        System.out.println("Table created successfully");
    }
    public void InsertEverywhere(int round,int winner,int color1, int color2, int mapnr, int firstgame,int p1wins, int p2wins) {
        try {
           // con.setAutoCommit(false);
           // state = con.prepareStatement();
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:jocPAOO.db");
            state = con.createStatement();
            if (firstgame == 1) {
                sql = "INSERT INTO TRONGAME (ROUND) " +
                        "VALUES ('New Game');";
                state.executeUpdate(sql);
            }
            if (winner == 1) {
                InsertColors(round,winner,color1,color2,mapnr,p1wins,p2wins);
                count++;
            } else if (winner == 2) {

                InsertColors(round,winner,color1,color2,mapnr,p1wins,p2wins);
                count++;
            } else if (winner == 3) {

                InsertColors(round,winner,color1,color2,mapnr,p1wins,p2wins);
                count++;
            }
            state.executeUpdate(sql);
            state.close();
           // con.commit();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Am eroare exceptie");
        }

    }

    public void InsertColors(int round, int winner, int color1, int color2, int mapnr, int p1wins, int p2wins) {
        if (winner != 3) {
            if (color1 == 1 && color2 == 1) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Cyan','Red',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 1 && color2 == 2) {

                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Cyan','Purple',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 1 && color2 == 3) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Cyan','Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 1 && color2 == 4) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Cyan','Brown',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 1 && color2 == 5) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Cyan','Dark Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 2 && color2 == 1) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Yellow','Red',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 2 && color2 == 2) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Yellow','Purple',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 2 && color2 == 3) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Yellow','Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 2 && color2 == 4) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Yellow','Brown',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 2 && color2 == 5) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Yellow','Dark Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 3 && color2 == 1) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Pink','Red',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 3 && color2 == 2) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Pink','Purple',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 3 && color2 == 3) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Pink','Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 3 && color2 == 4) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Pink','Brown',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 3 && color2 == 5) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Pink','Dark Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 4 && color2 == 1) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','White','Red',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 4 && color2 == 2) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','White','Purple',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 4 && color2 == 3) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','White','Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 4 && color2 == 4) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','White','Brown',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 4 && color2 == 5) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','White','Dark Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 5 && color2 == 1) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Dark Blue','Red',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 5 && color2 == 2) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Dark Blue','Purple',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 5 && color2 == 3) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Dark Blue','Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 5 && color2 == 4) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Dark Blue','Brown',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 5 && color2 == 5) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Player " + winner + "','Dark Blue','Dark Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
        }
        else
        {
            if (color1 == 1 && color2 == 1) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Cyan','Red',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 1 && color2 == 2) {

                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Cyan','Purple',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 1 && color2 == 3) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Cyan','Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 1 && color2 == 4) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Cyan','Brown',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 1 && color2 == 5) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Cyan','Dark Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 2 && color2 == 1) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Yellow','Red',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 2 && color2 == 2) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Yellow','Purple',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 2 && color2 == 3) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Yellow','Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 2 && color2 == 4) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Yellow','Brown',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 2 && color2 == 5) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Yellow','Dark Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 3 && color2 == 1) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Pink','Red',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 3 && color2 == 2) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Pink','Purple',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 3 && color2 == 3) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Pink','Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 3 && color2 == 4) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Pink','Brown',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 3 && color2 == 5) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Pink','Dark Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 4 && color2 == 1) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','White','Red',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 4 && color2 == 2) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','White','Purple',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 4 && color2 == 3) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','White','Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 4 && color2 == 4) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','White','Brown',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 4 && color2 == 5) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','White','Dark Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 5 && color2 == 1) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Dark Blue','Red',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 5 && color2 == 2) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Dark Blue','Purple',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 5 && color2 == 3) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Dark Blue','Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 5 && color2 == 4) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Dark Blue','Brown',"+mapnr+","+p1wins+","+p2wins+");";
            }
            if (color1 == 5 && color2 == 5) {
                sql = "INSERT INTO TRONGAME (ROUND, WINNER,PLAYER_1_COLOR,PLAYER_2_COLOR,MAP,PLAYER_1_WINS,PLAYER_2_WINS) " +
                        "VALUES ('" + round + "','Draw','Dark Blue','Dark Green',"+mapnr+","+p1wins+","+p2wins+");";
            }
        }
    }
}
