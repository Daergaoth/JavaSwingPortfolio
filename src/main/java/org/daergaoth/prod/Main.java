package org.daergaoth.prod;

import org.daergaoth.build.Build;
import org.daergaoth.staticPackage.StaticObjects;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        StaticObjects.LOGOICON = "target/classes/icon.png";
        File test = new File("target/classes/icon.png");
        System.out.println(test.exists());
        Build.build();
    }
}
