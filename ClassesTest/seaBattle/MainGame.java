package seaBattle;

import java.util.Scanner;

public class MainGame {

    public static void main(String[] args) {
        Player player = new Player();
        ComputerPlayer computerPlayer = new ComputerPlayer();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x to set ship:");
        int x = sc.nextInt();
        System.out.println("Enter y to set ship:");
        int y = sc.nextInt();
        player.fillFieldShips(x, y);

        System.out.println("Enter x to set ship:");
        x = sc.nextInt();
        System.out.println("Enter y to set ship:");
        y = sc.nextInt();

        player.fillFieldShips(x, y);
        computerPlayer.fillFieldShips();


        while (player.flagContinue && computerPlayer.flagContinue) {
            do {
                System.out.println("Enter x to SHOOT:");
                x = sc.nextInt();
                System.out.println("Enter y to SHOOT:");
                y = sc.nextInt();
            }
            while (player.action(x, y));

            if (computerPlayer.flagContinue == false) {
                return;
            }
            do {
                System.out.println("Computer is shooting...");
            }
            while (computerPlayer.action());

            if (player.flagContinue == false) {
                return;
            }
        }
    }
}
