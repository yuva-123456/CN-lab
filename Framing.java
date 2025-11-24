import java.util.*;

public class Framing {
    static String charCount(String d){
        return d.length() + d;
    }

    static String charStuff(String d){
        return d.replace("FLAG","ESCFLAG").replace("ESC","ESCESC");
    }

    static String bitStuff(String d){
        StringBuilder r=new StringBuilder(); int c=0;
        for(char x:d.toCharArray()){
            r.append(x);
            if(x=='1'){
                if(++c==5){ r.append('0'); c=0; }
            } else c=0;
        }
        return r.toString();
    }

    public static void main(String[] a){
        Scanner s=new Scanner(System.in);
        System.out.print("Data: ");
        String d=s.nextLine();

        System.out.println("Character Count: " + charCount(d));
        System.out.println("Character Stuffing: " + charStuff(d));
        System.out.println("Bit Stuffing: " + bitStuff(d));
    }
}
