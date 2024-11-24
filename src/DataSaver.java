import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataSaver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int id = 1;
        boolean done = false;
        boolean doneInner = false;

                try {

                    do {

                        String fileName = SafeInputs.getNonZeroLenString(in, "What would you like to name this file?");

                        Path writeFile = new File(System.getProperty("user.dir")).toPath();
                        writeFile = writeFile.resolve("src\\" + fileName + ".csv");
                        System.out.println("Path is " + writeFile);

                        OutputStream out =
                                new BufferedOutputStream(Files.newOutputStream(writeFile, CREATE));
                        BufferedWriter writer =
                                new BufferedWriter(new OutputStreamWriter(out));

                        do {

                            String[] line = new String[5];
                            String firstName = SafeInputs.getNonZeroLenString(in, "What is your first name?");
                            String lastName = SafeInputs.getNonZeroLenString(in, "What is your first name?");
                            String email = SafeInputs.getNonZeroLenString(in, "What is your email address?");
                            String yearOfBirth = SafeInputs.getNonZeroLenString(in, "What is your year of birth?");

                            line[0] = "00000" + id;
                            line[1] = firstName;
                            line[2] = lastName;
                            line[3] = email;
                            line[4] = yearOfBirth;

                            id = id + 1;

                            writer.write(line[0] + ", " + line[1] + ", " + line[2] + ", " + line[3] + ", " + line[4] + "\n");
                            writer.newLine();

                            doneInner = SafeInputs.getYNConfirm(in, "Are you done entering data in this file");

                        } while (!doneInner);

                        id = 1;
                        done = SafeInputs.getYNConfirm(in, "Are you done entering data?");

                        System.out.println("File successfully created");
                        writer.close();

                    } while (!done);

                } catch (IOException e) {
                    e.printStackTrace();
                }



    }
}
