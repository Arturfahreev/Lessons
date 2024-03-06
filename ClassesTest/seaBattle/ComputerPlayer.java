package seaBattle;

public class ComputerPlayer {

    Player player;
    static boolean flagContinue = true;
    static int[][] fieldShips = new int[10][10];
    int[][] fieldShoots = new int[10][10];

    void fillFieldShips () {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        fieldShips[x][y] = 1;
        x = (int) (Math.random() * 10);
        y = (int) (Math.random() * 10);
        fieldShips[x][y] = 1;

        System.out.println("COMPUTER'S SHIPS");

        for (int i = 0; i < fieldShips.length ; i++) {
            for (int j = 0; j < fieldShips[i].length; j++) {
                System.out.print(fieldShips[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean action() {
        boolean flag = false;
        boolean isEmpty = true;
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        if (Player.fieldShips[x][y] == 1) {
            Player.fieldShips[x][y] = 0;
            System.out.println("Player's ship was SANK!!!");


            for (int i = 0; i < Player.fieldShips.length ; i++) {
                for (int j = 0; j < Player.fieldShips[i].length; j++) {
                    if (Player.fieldShips[i][j] == 1) {
                        isEmpty = false;
                        flag = true;
                        return flag;
                    }
                }
            }

            System.out.println("All Player's ships were sank");
            System.out.println("Computer WINS. Game over");
            Player.flagContinue = false;
            return flag;
        }
        System.out.println("Computer MISSED. Your turn!");


        return flag;

    }
}
