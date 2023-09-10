package org.daergaoth.dev;

import org.daergaoth.build.Build;

public class Main {

    public static void main(String[] args) {
        Build.defaultRootFolder = "E:\\Programming\\Java\\CheckFileContent";
        Build.defaultKeyword = "myButtonOne";
        Build.build();
    }
}

