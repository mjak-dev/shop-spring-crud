import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FtpFiles {

    @Test
    public void createNewTextFileWithName() throws IOException {
        File file = new File("names.txt");
        FileWriter fileWriter = new FileWriter(file);

        for (int i = 1; i <= 46 ; i++) {
            String number = "";
            if (i < 100) {
                int digit = 3 - (i+"").length();

                for (int j = 0; j < digit; j++) {
                    number += "0";
                }
            }

            number += i;

            String line = String.format("https://bernilo.com/wp-content/uploads/3dAnimation/Mobile2/ezgif-frame-%s.jpg, ",number);
            System.out.println(line);
            fileWriter.write(line);
        }

        fileWriter.flush();
        fileWriter.close();
    }

}
