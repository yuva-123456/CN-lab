import java.util.*;

public class GoBackN {
    public static void main(String[] a){
        Scanner s=new Scanner(System.in);
        System.out.print("Total Frames: ");
        int n=s.nextInt();
        System.out.print("Window Size: ");
        int w=s.nextInt();

        Random r=new Random();
        int base=0; // first frame in window

        while(base<n){
            System.out.println("\nSender Window: " + base + " to " + Math.min(base+w-1,n-1));

            // send all frames in window
            for(int i=base;i<Math.min(base+w,n);i++)
                System.out.println("Sender: Sending Frame " + i);

            // simulate receiver
            int error = r.nextInt(w);  // random frame lost in window
            int lostFrame = base + error;
            if(lostFrame >= n) lostFrame = n-1;

            System.out.println("Receiver: Frame " + lostFrame + " LOST");
            System.out.println("Sender: Timeout! Go-Back-N Retransmit\n");

            // retransmission from lostFrame
            base = lostFrame;  
        }

        System.out.println("All Frames Sent Successfully!");
    }
}
