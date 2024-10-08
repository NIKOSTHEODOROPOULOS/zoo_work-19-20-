package unipi.nikostheod;

import java.io.*;
import java.util.Scanner;

public class edit_data {
    boolean found = false;
    Scanner A = new Scanner(System.in);
    public String ID = A.nextLine();

    public void edit() throws IOException {

        try {
            Scanner check_data = new Scanner(new File("zoo.txt"));
            String[] Cd;

            while (check_data.hasNextLine()) {
                Cd = check_data.nextLine().split(",");
                if (Cd[0].equals("ID:" + ID)) {
                    found = true;
                    System.out.println("Βρέθηκε ζώο");
                    System.out.println("Στοιχεία ζώου");
                    String linetoedit = Cd[0] + "," + Cd[1] + "," + Cd[2] + "," + Cd[3] + "," + Cd[4];
                    System.out.print(linetoedit);
                    System.out.println("Τι αλλαγή θέλετε να πραγματοποιηθεί;\n1.όνομα\n2.βάρος\n3.ομοταξία\n4.ηλικία.\nΟ κωδικός δεν δέχεται επεξεργασία\n");
                    Scanner edit2 = new Scanner(System.in);
                    int i = edit2.nextInt();

                    BufferedReader reader = new BufferedReader(new FileReader("zoo.txt"));
                    PrintWriter writer = new PrintWriter(new FileWriter("myTempFile2.txt"));
                    String currentLine;
                    if (i > 0 && i < 5) {
                        try {
                            switch (i) {
                                case 1:
                                    while ((currentLine = reader.readLine()) != null) {
                                        String trimmedLine = currentLine.trim();
                                        if (trimmedLine.equals(linetoedit)) {
                                            add_animal animal = new add_animal();
                                            animal.Set_Name();
                                            writer.write(Cd[0] + "," + "name:" + animal.getAnimal_name() + "," + Cd[2] + "," + Cd[3] + "," + Cd[4] + System.getProperty("line.separator"));
                                        } else {
                                            writer.write(currentLine + System.getProperty("line.separator"));
                                        }
                                    }
                                    break;
                                case 2:
                                    while ((currentLine = reader.readLine()) != null) {
                                        String trimmedLine = currentLine.trim();
                                        if (trimmedLine.equals(linetoedit)) {
                                            add_animal animal = new add_animal();
                                            animal.Set_Weight();
                                            writer.write(Cd[0] + "," + Cd[1] + "," + Cd[2] + "," + "weight:" + animal.getAnimal_Weight() + "," + Cd[4] + System.getProperty("line.separator"));
                                        } else {
                                            writer.write(currentLine + System.getProperty("line.separator"));
                                        }
                                    }
                                    break;
                                case 3:
                                    while ((currentLine = reader.readLine()) != null) {
                                        String trimmedLine = currentLine.trim();
                                        if (trimmedLine.equals(linetoedit)) {
                                            specie_animal specie = new specie_animal();
                                            specie.setAnimal_Specie();
                                            writer.write(Cd[0] + "," + Cd[1] + "," + Cd[2] + "," + "ομοταξία:" + specie.getAnimal_Specie() + "," + Cd[4] + System.getProperty("line.separator"));
                                        } else {
                                            writer.write(currentLine + System.getProperty("line.separator"));
                                        }
                                    }
                                    break;
                                case 4:
                                    while ((currentLine = reader.readLine()) != null) {
                                        String trimmedLine = currentLine.trim();
                                        if (trimmedLine.equals(linetoedit)) {
                                            add_animal animal = new add_animal();
                                            animal.Set_Age();
                                            writer.write(Cd[0] + "," + Cd[1] + "," + Cd[2] + "," + Cd[3] + "," + "ηλικία" + animal.getAnimal_age() + System.getProperty("line.separator"));
                                        } else {
                                            writer.write(currentLine + System.getProperty("line.separator"));
                                        }
                                    }
                                    break;
                            }


                            writer.close();
                            reader.close();

                            FileInputStream instream = null;
                            FileOutputStream outstream = null;

                            try {
                                File infile = new File("myTempFile2.txt");
                                File outfile = new File("zoo.txt");

                                instream = new FileInputStream(infile);
                                outstream = new FileOutputStream(outfile);

                                byte[] buffer = new byte[1024];

                                int length;
                                while ((length = instream.read(buffer)) > 0) {
                                    outstream.write(buffer, 0, length);
                                }

                                instream.close();
                                outstream.close();


                            } catch (IOException ioe) {
                                ioe.printStackTrace();
                            }


                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Wrong Option");
                        edit();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (found == false) {
            System.out.print("Δεν βρέθηκε ζώο\n");
        }
    }
}








