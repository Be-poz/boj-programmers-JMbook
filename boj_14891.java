import java.util.Scanner;

public class boj_14891 {
    static int[][] wheel = new int[4][8];
    static int k;
    static int[][] commands;

    // 시계방향 : 1,  반시계방향 : -1
    public static void main(String[] args) {
        valueInsert();
        for (int i = 0; i < k; i++) {
            int wheelIndex = commands[i][0] - 1;
            int dir = commands[i][1];
            rotate(wheelIndex, dir);
        }
    }

    // 2,6을 조사해야함
    public static void rotate(int wheelIndex, int dir) {

    }

    public static void valueInsert(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                wheel[i][j] = sc.nextInt();
            }
        }
        k = sc.nextInt();
        commands = new int[k][2];
        for (int i = 0; i < k; i++) {
            commands[i][0] = sc.nextInt();
            commands[i][1] = sc.nextInt();
        }
    }
}
