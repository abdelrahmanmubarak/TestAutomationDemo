package com.swaglabs.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtils {
    private FilesUtils(){
        super();
    }

    public static File getlatestFile(String folderPath){
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if(files == null || files.length == 0) {
            LogsUtil.warn("No files found in folder: " + folderPath);
            return null;
        }
        File latestFile = files[0];
        for(File file : files) {
            if(file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;

    }

    public static void deleteFiles(File dirPah){
        if(dirPah == null || !dirPah.exists()) {
            LogsUtil.warn("Directory does not exist" + dirPah);
            return;
        }
        File[] filesList = dirPah.listFiles();
        if(filesList == null) {
            LogsUtil.warn("Directory is empty" + dirPah);
            return;
        }
        for(File file : filesList) {
            if(file.isDirectory()) {
                deleteFiles(file);
            } else {
                try {
                    Files.delete(file.toPath());
                }
                catch (IOException e) {
                    LogsUtil.error("Failed to delete file: " + file);
                }

            }
        }
    }
}
