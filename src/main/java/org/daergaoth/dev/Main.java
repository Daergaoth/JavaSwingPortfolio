package org.daergaoth.dev;

import org.daergaoth.build.Build;

public class Main {

    public static void main(String[] args) {
        Build.defaultRootFolder = System.getProperty("user.dir");
        Build.defaultKeyword = Main.class.getName();
        Build.build();
    }
}

