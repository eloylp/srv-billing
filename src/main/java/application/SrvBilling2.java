package application;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class SrvBilling2 {

    public static void main(String[] args) {

        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();

        System.out.println(enc.encode("eloylp"));


    }

}
