package unipi.nikostheod;
import java.io.*;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

            boolean Exit = true;

            while (Exit == true) {
                try {
                    System.out.println("Παρακαλώ επιλέξτε από το παρακάτω menu επιλογών\n");
                    System.out.println("------------------------------------------\n");
                    System.out.println("1.Προβολή όλων των διαθέσιμων ζώων του ζωολογικού κήπου\n");
                    System.out.println("2. Προσθήκη νέου ζώου\n");
                    System.out.println("3. Αναζήτηση ζώου βάσει ονόματος\n");
                    System.out.println("4. Αναζήτηση ζώου βάσει κωδικόυ\n");
                    System.out.println("5. Επεξεργασία ζώου βάσει κωδικόυ\n");
                    System.out.println("6. Διαγραφή ζώου βάσει κωδικού\n");
                    System.out.println("7. Έξοδος από την εφαρμογή\n");
                    Scanner selectedoption = new Scanner(System.in);
                int i = selectedoption.nextInt();
                switch (i) {
                    case 1:
                        int countLine = 0; //Count lines*
                        try (BufferedReader br = new BufferedReader(new FileReader("zoo.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                countLine++;
                                System.out.println(countLine + ". " + line);
                            }
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        //εμφάνιση μήνυματων  στον χρήστη ως προτροπή εισαγωγής έγκυρων δεδομένων
                        specie_animal specie =new specie_animal();
                        specie.setAnimal_Specie();

                        add_animal animal=new add_animal();
                        animal.Set_ID();
                        animal.Set_Name();
                        animal.Set_Weight();
                        animal.Set_Age();
                        try (PrintWriter pw = new PrintWriter(new FileWriter("zoo.txt", true))){
                            animal.check();
                            if(animal.getAnimal_name()==null)
                            {
                                System.out.print("Λάθος στην εισαγωγή δεδομένων\n");
                                break;
                            }

                            else
                                {   System.out.print("Το ζώο προστέθηκε\n");
                                    pw.println("ID:"+ animal.getAnimal_ID()+","+"name:" +animal.getAnimal_name()+","+"ομοταξία:"+ specie.getAnimal_Specie() + "," +"Weight:"+ animal.getAnimal_Weight() + "," +"max age:"+ animal.getAnimal_age());

                            }
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Δώσε όνομα ζώου για αναζήτηση");
                        search_name s2_animal =new search_name();
                        s2_animal.print();
                        break;
                    case 4:
                        System.out.println("Δώσε κωδικό ζώου για αναζήτηση");
                        search_code s_animal =new search_code();
                        s_animal.print();
                        break;
                    case 5:
                        System.out.println("Δώσε κωδικό ζώου");
                        edit_data A =new edit_data();
                        A.edit();
                        break;
                    case 6:
                        System.out.println("Δώσε κωδικό ζώου για διαγραφή");
                        delete_zoo An =new delete_zoo();
                        An.d_z();
                        break;
                    case 7:
                        Exit = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Δώσατε λάθος επιλογή.Δοκιμάστε ξανά");
            }
        }
    }
}

