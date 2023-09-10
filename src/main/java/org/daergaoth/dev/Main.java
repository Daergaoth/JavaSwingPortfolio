package org.daergaoth.dev;

import org.daergaoth.build.Build;
import org.daergaoth.staticPackage.StaticObjects;

public class Main {

    public static void main(String[] args) {
        Build.defaultRootFolder = System.getProperty("user.dir");
        Build.defaultKeyword = Main.class.getName();
        StaticObjects.LOGOICON = "resources/icon.png";
        Build.build();
    }
}

