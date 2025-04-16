package com.swaglabs.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtils {
    private FilesUtils() {
        super();
    }

    public static File getlatestFile(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            LogsUtil.warn("No files found in folder: " + folderPath);
            return null;
        }
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        return latestFile;

    }

    public static void deleteFiles(File dirPah) {
        if (dirPah == null || !dirPah.exists()) {
            LogsUtil.warn("Directory does not exist" + dirPah);
            return;
        }
        File[] filesList = dirPah.listFiles();
        if (filesList == null) {
            LogsUtil.warn("Directory is empty" + dirPah);
            return;
        }
        for (File file : filesList) {
            if (file.isDirectory()) {
                deleteFiles(file);
            } else {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    LogsUtil.error("Failed to delete file: " + file);
                }

            }
        }
    }

    public static void cleanDirectory(File file) {
        if (file == null || !file.exists()) {
            LogsUtil.warn("Directory does not exist or is null: " + file);
            return;
        }
        try {
            File[] files = file.listFiles();
            if (files != null) {
                File latestLogFile = null;

                // Find the latest log file
                for (File f : files) {
                    if (f.getName().endsWith(".log")) {
                        if (latestLogFile == null || f.lastModified() > latestLogFile.lastModified()) {
                            latestLogFile = f;
                        }
                    }
                }

                // Delete all files except the latest log file
                for (File f : files) {
                    if (!f.equals(latestLogFile) && f.getName().endsWith(".log")) {
                        FileUtils.forceDelete(f); // Delete old log files
                    } else if (!f.getName().endsWith(".log")) {
                        FileUtils.forceDelete(f); // Delete non-log files
                    }
                }

                LogsUtil.info("Cleaned directory and preserved latest log file: "
                        + (latestLogFile != null ? latestLogFile.getName() : "No logs found"));
            }
        } catch (Exception exception) {
            LogsUtil.error("Error while cleaning directory: " + exception.getMessage());
        }
    }


}
