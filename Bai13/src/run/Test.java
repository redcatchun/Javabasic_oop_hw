package run;

import exception.EmailException;

public class Test {
    public static void main(String[] args) {
        boolean ok = false;
        String email = "aajflaj.@dajdk.van.joj";
        String editM = email.trim();
        int l = editM.length() - 1;
        if (l > 5) {
            boolean check1 = (editM.charAt(0) > 64 && editM.charAt(0) < 91) || (editM.charAt(0) > 96 && editM.charAt(0) < 123);
            boolean check2 = (editM.charAt(l) > 64 && editM.charAt(l) < 91) || (editM.charAt(l) > 96 && editM.charAt(l) < 123);
            if (check1 && check2) {
                System.out.println("oke done");
                String[] mailPart = email.split("@");
                if (mailPart.length == 2) {
                    System.out.println("0 "+mailPart[1]);
                    String[] dotCom = mailPart[1].split("\\.");
                    System.out.println("1: "+dotCom[0]);
                    if (dotCom.length > 1 && dotCom[0].length() > 0) {
                        System.out.println("oke");
                        ok = true;
                    }
                }
            }
        }
        if (!ok) System.out.println("ko jop le");
    }
}
