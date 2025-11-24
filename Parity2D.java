import java.util.*;

public class Main {
    public static void main(String[] a){
        Scanner s = new Scanner(System.in);

        int r = s.nextInt(), c = s.nextInt();
        int[][] send = new int[r][c];
        int[][] recv = new int[r][c];

        // Sender matrix
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                send[i][j] = s.nextInt();

        // Sender parity
        int[] rp = new int[r], cp = new int[c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++){
                rp[i] ^= send[i][j];
                cp[j] ^= send[i][j];
            }

        // Receiver matrix (possibly corrupted)
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                recv[i][j] = s.nextInt();

        // Receiver parity
        int[] rr = new int[r], cr = new int[c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++){
                rr[i] ^= recv[i][j];
                cr[j] ^= recv[i][j];
            }

        System.out.println(
            Arrays.equals(rp, rr) && Arrays.equals(cp, cr)
            ? "No Error" : "Error Detected"
        );
    }
}
