package haromszogek;

import felulet.Felulet;
import haromszogek.logika.DHaromszog;

public class Haromszogek {

    public static void main(String[] args) {
        
        Felulet f = new Felulet();
        
        try {
            DHaromszog d1 = new DHaromszog("3 4 5", 1);
            DHaromszog d2 = new DHaromszog("1,1 2,2 4,5", 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
