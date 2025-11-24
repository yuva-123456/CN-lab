import java.util.*;

public class StopWait {
    public static void main(String[] a){
        Scanner s=new Scanner(System.in);
        System.out.print("Number of frames: ");
        int n=s.nextInt();
        Random r=new Random();

        for(int seq=0; seq<n; seq++){
            boolean sent = false;

            while(!sent){
                // SENDER SIDE
                System.out.println("Sender: Sending Frame " + seq);

                // Simulate loss
                boolean lost = r.nextInt(4)==0;  // 25% loss chance

                // RECEIVER SIDE
                if(lost){
                    System.out.println("Receiver: Frame " + seq + " LOST");
                    System.out.println("Sender: Timeout! Resending...\n");
                } else {
                    System.out.println("Receiver: Frame " + seq + " received");
                    System.out.println("Receiver: Sending ACK " + seq);
                    System.out.println("Sender: ACK " + seq + " received\n");
                    sent = true;
                }
            }
        }
    }
}
