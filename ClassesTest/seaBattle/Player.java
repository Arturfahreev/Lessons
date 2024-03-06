package seaBattle;

public class Player {

    ComputerPlayer computerPlayer;
    static boolean flagContinue = true;
    static int[][] fieldShips = new int[10][10];
    int[][] fieldShoots = new int[10][10];

    boolean action(int x, int y) {
        boolean flag = false;
        boolean isEmpty = true;
        if (ComputerPlayer.fieldShips[x][y] == 1) {
            ComputerPlayer.fieldShips[x][y] = 0;
            fieldShoots[x][y] = 2;
            System.out.println("Computer's ship was SANK !!!");


            for (int i = 0; i < ComputerPlayer.fieldShips.length ; i++) {
                for (int j = 0; j < ComputerPlayer.fieldShips[i].length; j++) {
                    if (ComputerPlayer.fieldShips[i][j] == 1) {
                        isEmpty = false;
                        flag = true;
                        return flag;
                    }
                }
            }

            System.out.println("All Computer's ships were sank");
            System.out.println("Player WINS. Game over");
            ComputerPlayer.flagContinue = false;
            return flag;
        }
        System.out.println("You MISSED. Computer's turn!");

        return flag;
    }

    void fillFieldShips (int x, int y) {
        fieldShips[x][y] = 1;
        System.out.println("PLAYER'S SHIPS");

        for (int i = 0; i < fieldShips.length ; i++) {
            for (int j = 0; j < fieldShips[i].length; j++) {
                System.out.print(fieldShips[i][j] + " ");
            }
            System.out.println();
        }

    }



}
