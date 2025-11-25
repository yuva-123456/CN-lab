import java.util.*;

public class GoBackN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Total Frames: "); int total = sc.nextInt();
        System.out.print("Window Size: ");  int w = sc.nextInt();

        int base = 0;
        Random rnd = new Random();

        while (base < total) {
            int end = Math.min(base + w, total);
            System.out.println("\nSending Window: " + base + " to " + (end - 1));
            for (int i = base; i < end; i++) System.out.println("Sent Frame " + i);

            // 30% chance some frame in window is lost; 70% chance all OK
            if (rnd.nextInt(100) < 30) {
                int lost = base + rnd.nextInt(end - base); // [base, end-1]
                System.out.println("Receiver: Frame " + lost + " LOST");
                System.out.println("Sender: TIMEOUT → retransmit from Frame " + lost);
                base = lost; // go-back-n: retransmit from first unacked (lost) frame
            } else {
                System.out.println("Receiver: ACK all frames up to " + (end - 1));
                base = end; // slide window past acknowledged frames
            }
        }
        System.out.println("\nAll Frames Sent Successfully!");
    }
}
