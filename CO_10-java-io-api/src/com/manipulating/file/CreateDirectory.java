package com.manipulating.file;

import java.io.File;
import java.io.IOException;

public class CreateDirectory {
    public static void main(String[] args) throws IOException {
        File file1 = new File("CO_10-java-io-api/files/demo-file.txt");

        //Demo :: Creating File Using createNewFile() method.
        boolean fileCreated = file1.createNewFile();
        System.out.println("fileCreated = " + fileCreated);

        //Demo :: Create Directory Inside File
        File dir = new File("CO_10-java-io-api/files/data");
        boolean dirCreated = dir.mkdir(); //mkdir : Create single directory inside file directory
        System.out.println("dirCreated = " + dirCreated);

        //Demo :: Create a sub-directory inside directory
        File dir1 = new File("CO_10-java-io-api/files/data1/more-data");
        boolean mkdirs = dir1.mkdirs(); //mkdirs:: Create sub-directories or intermediate directories inside directory
        System.out.println("Sub-directory Created :: " + mkdirs);

        //Demo :: Delete Directory
        //boolean delete = dir1.delete();
        //System.out.println("Delete = " + delete);

        /*
         Getting the Name, the Parent and the Path of a File Instance
         */

        dir1 = new File("CO_10-java-io-api/files/data1/more-data");

        String name = dir1.getName();
        String parent = dir1.getParent();
        String path = dir1.getPath();

        System.out.println("Name = " + name);
        System.out.println("Parent = " + parent);
        System.out.println("Path = " + path);

        //Demo :: Canonical Path And Absolute Path
        String absolutePath = dir1.getAbsolutePath();
        String canonicalPath = dir1.getCanonicalPath();
        System.out.println("Absolute Path :: " + absolutePath);
        System.out.println("Canonical Path :: " + canonicalPath);

    }
}
