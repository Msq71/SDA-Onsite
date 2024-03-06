package day11;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class C02FileExist {

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        System.out.println("userDir = " + userDir);
        System.out.println("separator = " + separator);


        String path = userDir + separator + "FileExist";

        System.out.println("path = " + path);
        boolean isExists = Files.exists(Path.of(path));
        System.out.println("isExists = " + isExists);
    }

}