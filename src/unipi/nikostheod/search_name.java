package unipi.nikostheod;

import java.io.File;
import java.util.Scanner;

public class search_name {
    Scanner A= new Scanner(System.in);
    public String name=A.nextLine();
    int i=0;
    public void print()
    {
        try {
            Scanner check_data = new Scanner(new File("zoo.txt"));
            String[] Cd;
            Cd = check_data.nextLine().split(",");
            while (check_data.hasNextLine()) {
                Cd = check_data.nextLine().split(",");
                if (Cd[1].equals("name:"+name)){
                    i++;
                    System.out.println("Βρέθηκε ζώο");
                    System.out.println("Στοιχεία ζώου");
                    System.out.println(Cd[0]+" "+Cd[1]+" "+Cd[2]+" "+Cd[3]+" "+Cd[4]);
                }
            }if(i==0){
                System.out.println("Δεν υπάρχει ζώο με όνομα που δώσατε");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

