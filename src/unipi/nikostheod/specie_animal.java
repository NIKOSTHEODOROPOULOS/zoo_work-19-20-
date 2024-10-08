package unipi.nikostheod;

import java.util.Scanner;

public class specie_animal {
    String Animal_Specie;
    public String getAnimal_Specie() { return Animal_Specie; }

    public void setAnimal_Specie() {
        //εμφάνιση μήνυματων  στον χρήστη ως προτροπή εισαγωγής έγκυρων δεδομένων
        System.out.println("Δώσε ομοταξία,για την ομοταξία που ανήκει το ζώο πληκτρολογήστε ένα από τους ακόλουθους αριθμούς");
        System.out.println("1.Αμφίβια(Amphibian)\n");
        System.out.println("2.Δίθυρα(Bivalvia)\n");
        System.out.println("3.Ερπετά(Reptilia)\n");
        System.out.println("4.Θηλαστικά(Mammal)\n");
        System.out.println("5.Κεφαλόποδα(Cephalopoda)\n");
        System.out.println("6.Μαλακόστρακα(Malacostraca)\n");
        System.out.println("7.Πτηνά(Aves)\n");
        System.out.println("8.Συναψιδωτά(Synapsid)\n");
        System.out.println("9.Τριλοβίτες(Trilobita)\n");
        System.out.println("10.Ψάρια(Fish)\n");
        Scanner animal_tax = new Scanner(System.in);
        int option= animal_tax.nextInt();
        if(option>0 && option<11){
            switch (option) {
                case 1:
                    this.Animal_Specie = "Amphibian";
                    break;
                case 2:
                    this.Animal_Specie = "Bivalvia";
                    break;
                case 3:
                    this.Animal_Specie = "Reptilia";
                    break;
                case 4:
                    this.Animal_Specie = "Mammal";
                    break;
                case 5:
                    this.Animal_Specie = "Cephalopoda";
                    break;
                case 6:
                    this.Animal_Specie = "Malacostraca";
                    break;
                case 7:
                    this.Animal_Specie = "Aves";
                    break;
                case 8:
                    this.Animal_Specie = "Synapsid";
                    break;
                case 9:
                    this.Animal_Specie = "Trilobita";
                    break;
                case 10:
                    this.Animal_Specie = "Fish";
                    break;
            }
        }
        else{
            System.out.println("Wrong Option");
            setAnimal_Specie();
        }

    }
}







