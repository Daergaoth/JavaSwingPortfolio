package org.daergaoth.prod;

import org.daergaoth.build.Build;
import org.daergaoth.staticPackage.StaticObjects;

import java.io.File;

public class Main {
    public static void main(String[] args) {
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
