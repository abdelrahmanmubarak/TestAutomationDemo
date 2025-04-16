package com.swaglabs.pages;

public class SystemPropertiesExample {
    public static void main(String[] args) {
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("User Name: " + System.getProperty("user.name"));
        System.out.println("File Separator: " + System.getProperty("file.separator"));
        System.out.println("User Name: " + System.getProperty("user.name"));
        System.out.println("User dir: " + System.getProperty("user.dir"));
        System.out.println("Os Arch: " + System.getProperty("os.arch"));
        System.out.println("Os Arch: " + System.getProperty("browserType"));
    }

}
