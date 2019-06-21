import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter a base of 10 or less:");
        int base = read.nextInt();
        System.out.println("Enter a number:");
        int number = read.nextInt();
        if (base > 10) {
            System.out.println("Error! Base is too high!");
            return;
        }
        int paladins = 0;
        int currNum = 0;
        while (paladins < number) {
            String currS = String.valueOf(currNum);
            int pos = currS.length() - 1;
            boolean quit = false;
            while (pos >= 0 && !quit) {
                int replace = (Integer.parseInt(currS.charAt(pos) + "") + 1);
                if (replace >= base) {
                    replace = 0;
                } else {
                    quit = true;
                }
                currS = currS.substring(0, pos) + replace + currS.substring(pos + 1, currS.length());
                pos--;
            }
            if (pos < 0 && !quit) {
                currS = "1" + currS;
            }
            currNum = Integer.parseInt(currS);
            if (currNum < 10) {
                // Do nothing
            } else {
                int mid;
                if (currS.length() % 2 == 0) {
                    mid = currS.length() / 2;
                } else {
                    mid = (currS.length() + 1) / 2;
                }
                boolean isPaladin = true;
                for (int i = 0; i < mid; i++) {
                    if (currS.charAt(i) != currS.charAt((currS.length() - 1) - i)) {
                        isPaladin = false;
                        break;
                    }
                }
                if (isPaladin) {
                    System.out.print(currNum + " ");
                    paladins++;
                }
            }
        }
    }
}
