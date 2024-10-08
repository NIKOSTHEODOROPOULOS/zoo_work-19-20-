package unipi.nikostheod;

import java.io.File;
import java.util.Scanner;

public class search_code {
    boolean found=false;
    Scanner A= new Scanner(System.in);
    public String ID=A.nextLine();
    public void print()
    {
        try {
            Scanner check_data = new Scanner(new File("zoo.txt"));
            String[] Cd;
            while (check_data.hasNextLine()) {
                Cd = check_data.nextLine().split(",");
                if (Cd[0].equals("ID:"+ID)){
                    found=true;
                    System.out.println("Βρέθηκε ζώο");
                    System.out.println(Cd[0]+" "+Cd[1]+" "+Cd[2]+" "+Cd[3]+" "+Cd[4]);
                    break;
                }

            }if(found==false){
                System.out.println("Δεν βρέθηκε ζώο με αυτό το ID");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}