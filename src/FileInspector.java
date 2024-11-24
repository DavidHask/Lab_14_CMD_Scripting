import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public class FileInspector {
    public static void main(String[] args) {

        int numLines = 0;
        int numWords = 0;
        int numChars = 0;
        String line = "";
        String[] splitLine = new String[5];

        JFileChooser chooser = new JFileChooser();
        File selectedFile = null;
        File currentDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(currentDirectory);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            selectedFile = chooser.getSelectedFile();
            Path file = selectedFile.toPath();

            try {

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));


                while (reader.ready()) {
                    line = reader.readLine();
                    System.out.println(line);
                    splitLine = line.split(" ");
                    numLines = numLines + 1;
                    numWords = numWords + splitLine.length;

                    for (int i = 0; i < splitLine.length; i++) {
                        numChars = numChars + splitLine[i].length();
                    }

                }
                reader.close();

            } catch (IOException e){
                System.out.println("Error occurred");
                e.printStackTrace();
            }

        } else {

            System.out.println("You must select a file");

        }

        System.out.println("The name of the file is " + selectedFile);
        System.out.println("The number of lines in the file is " + numLines);
        System.out.println("The number of words in the file is " + numWords);
        System.out.println("The number of characters in the file is " + numChars);

    }
}
