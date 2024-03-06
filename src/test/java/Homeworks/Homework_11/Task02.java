package Homeworks.Homework_11;

import java.nio.file.Files;
import java.nio.file.Path;

public class Task02 {
    /*
    Create a File on Desktop
    Verify that the file exists
     */
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String userHome = System.getProperty("user.home");
        String fileName = "HwFile";

        //"C:\Users\Msqx7\Desktop\HwFile"
       /* System.out.println("userDir = " + userDir);
        System.out.println("separator = " + separator);
        System.out.println("userHome = " + userHome);
        */
        String path = userHome + separator + "Desktop" + separator + fileName;
        System.out.println("path = " + path);

        boolean isExist = Files.exists(Path.of(path));
        System.out.println("isExist = " + isExist);

    }
}
