package com.manipulating.file;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PlayWithPath {
    public static void main(String[] args) throws IOException {

        Path path1 = Paths.get("air1.jpg");
        Path path2 = Path.of("images/kris1.jpg");

        System.out.println("path1 = " +path1);
        System.out.println("path2 = " +path2);
        System.out.println("path1 = " +path1.getClass());

        //Checking Path is Absolute and Getting It's Root Element
        boolean absolute = path1.isAbsolute();
        System.out.println("absolute = " + absolute);

        Path root = path1.getRoot();
        System.out.println("root = " + root);

        //resolve() :: Resolving a Path against Another Path

        //Path resolve = path1.resolve(path2);
        //System.out.println("resolve = " + resolve);

        //resolveSibling() :: Resolving path against another path
        Path path = path1.resolveSibling(path2);
        System.out.println("Path : " + path);

        //relativize() :: Computing a Relative Path
        Path relativize1 = path1.relativize(path2);
        System.out.println("relativize : " + relativize1);

        //normalize() ::
        Path normalize = path1.normalize();
        System.out.println("Normalize :: " + normalize);

        // Getting Path from a File System
        FileSystem fileSystem = path.getFileSystem();
        System.out.println("fileSystem = " + fileSystem);


    }
}
