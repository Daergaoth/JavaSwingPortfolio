package org.daergaoth.dev;

import org.daergaoth.build.Build;
import org.daergaoth.staticPackage.StaticObjects;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Build.defaultRootFolder = System.getProperty("user.dir");
        Build.defaultKeyword = Main.class.getName();
        File testFile = new File("src/main/resources/icon.png");
        if(testFile.exists() && testFile.isFile()){
            StaticObjects.LOGOICON = "src/main/resources/icon.png";
        }else{
            testFile = new File("classes/icon.png");
            if(testFile.exists() && testFile.isFile()){
                StaticObjects.LOGOICON = "classes/icon.png";
            }
        }
        Build.build();
    }
}

