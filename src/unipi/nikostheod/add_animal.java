package unipi.nikostheod;
import java.io.File;
import java.util.Scanner;

public class add_animal {
    public String Animal_name;
    private String Animal_ID;
    public double Animal_Weight;
    public double Animal_Age;
    public String ID;

    void Set_Name()
    {
        Scanner Animal = new Scanner(System.in);
        System.out.print("Δώσε όνομα ζώου\n");
        Animal_name = Animal.nextLine();

        if(Animal_name.contains(","))
        {
            System.out.print("Λάθος στην εισαγωγή του ονόματος");
            Set_Name();
        }
    }
    void Set_Weight() {
        System.out.println("Δώσε βάρος");
        Scanner Animal2 = new Scanner(System.in);
        Animal_Weight = Animal2.nextDouble();
        if(Animal_Weight==0){
            System.out.print("Μη έγκυρη τιμή\n");
            Set_Weight();
        }
    }

    public double getAnimal_Weight(){return  Math.abs(Animal_Weight);}

    void Set_Age() {
        System.out.println("Δώσε ήλικια");
        Scanner Animal3 = new Scanner(System.in);
        Animal_Age = Animal3.nextDouble();
        if(Animal_Age==0){
            System.out.print("Μη έγκυρη τιμή\n");
            Set_Age();
        }
    }
    public double getAnimal_age() { return Math.abs(Animal_Age);}

    void Set_ID() {
        System.out.print("Δώσε κωδικό ID\n");
        Scanner A = new Scanner(System.in);
        ID = A.nextLine();
        if(ID.contains(","))
        {
            System.out.print("Λάθος στην εισαγωγή του κωδικού");
            Set_ID();
        }
    }


//έλεγχος μοναδικότητας κωδικού ζώου  που εισάγει ο χρήστης
    public void check() {
        try { Scanner check_data= new Scanner(new File("zoo.txt"));
           String[] Cd;
           Cd = check_data.nextLine().split(",");
            while (check_data.hasNextLine()) {
                Cd = check_data.nextLine().split(",");
                if (Cd[0].equals("ID: "+ ID)){
                    System.out.println("this animal with that ID exist");
                    System.out.println(Cd[0]+" "+Cd[1]+" "+Cd[2]+" "+Cd[3]+" "+Cd[4]);
                    this.Animal_name = null;
                    break;
                }
                else {
                    this.Animal_ID = ID;
                }
            }
        } catch (Exception e) {System.out.println(e.getMessage()); }
    }
    public String getAnimal_name() { return Animal_name.replaceAll("[^A-Za-z]+", ""); }
    public String getAnimal_ID() { return Animal_ID; }

}
