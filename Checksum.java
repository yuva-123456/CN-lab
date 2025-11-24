import java.util.*;

public class Checksum {
    static String add(String a, String b){
        int carry = 0, n=a.length();
        String r = "";
        for(int i=n-1;i>=0;i--){
            int s = (a.charAt(i)-'0') + (b.charAt(i)-'0') + carry;
            r = (s%2) + r;
            carry = s/2;
        }
        while(carry>0){                // wrap-around
            int s = (r.charAt(n-1)-'0') + 1;
            r = r.substring(0,n-1)+(s%2);
            carry = s/2;
        }
        return r;
    }
    static String comp(String x){
        return x.replace('0','x').replace('1','0').replace('x','1');
    }

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();             // number of segments
        String sum="0".repeat(s.nextInt());  // bit size

        // sender side
        for(int i=0;i<n;i++) sum = add(sum, s.next());
        String checksum = comp(sum);
        System.out.println("Checksum: "+checksum);

        // receiver side
        String recvSum="0".repeat(checksum.length());
        for(int i=0;i<n;i++) recvSum = add(recvSum, s.next());
        recvSum = add(recvSum, checksum);
        System.out.println(comp(recvSum).contains("1") ? "Error" : "No Error");
    }
}
