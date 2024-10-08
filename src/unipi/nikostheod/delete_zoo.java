package unipi.nikostheod;
import java.lang.System;
import java.io.*;
import java.util.Scanner;

public class delete_zoo {
    boolean found=false;
    Scanner A = new Scanner(System.in);
    public String ID = A.nextLine();

    public void d_z() throws IOException {
        try (Scanner in = new Scanner(new File("zoo.txt"))) {
            String[] cd;
            String s[];
            while (in.hasNextLine()) {

                s = in.nextLine().split(",");

                if (s[0].equals("ID:" + ID)) {
                    System.out.println("Βρέθηκε ζώο με αυτόν τον κωδικό");
                    found=true;
                    BufferedReader reader = new BufferedReader(new FileReader("zoo.txt"));
                    PrintWriter writer = new PrintWriter(new FileWriter("myTempFile.txt"));
                    String currentLine;
                    String lineToRemove = s[0] + "," + s[1] + "," + s[2] + "," + s[3] + "," + s[4];
                    System.out.print(lineToRemove);
                    while ((currentLine = reader.readLine()) != null) {
                        String trimmedLine = currentLine.trim();
                        if (trimmedLine.equals(lineToRemove)) continue;
                        writer.write(currentLine + System.getProperty("line.separator"));

                    }
                    writer.close();
                    reader.close();

                    FileInputStream instream = null;
                    FileOutputStream outstream = null;

                    try {
                        File infile = new File("myTempFile.txt");
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
                }
            }if(found==false){
                System.out.print("Δεν βρέθηκε ζώο\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
