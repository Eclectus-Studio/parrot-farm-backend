package org.minetrio1256.parrot_farm_backend.filesystem;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.Objects;

public class CopyGameFiles {

    public static void copyResourceFolder(String resourceFolder, String targetFolder) {
        System.out.println("Copying Game Files");
        try {
            // Get the classloader resource URL
            ClassLoader classLoader = CopyGameFiles.class.getClassLoader();
            InputStream resourceStream = classLoader.getResourceAsStream(resourceFolder);

            if (resourceStream == null) {
                System.out.println("Resource folder not found: " + resourceFolder);
                return;
            }

            File targetDir = new File(targetFolder);
            if (!targetDir.exists()) {
                targetDir.mkdirs(); // Create directory if it doesn’t exist
            }

            // Get list of files inside the resource folder
            URL resourceURL = classLoader.getResource(resourceFolder);
            if (resourceURL == null) {
                System.out.println("Could not find resource folder: " + resourceFolder);
                return;
            }

            File resourceDir = new File(resourceURL.toURI());

            for (File file : Objects.requireNonNull(resourceDir.listFiles())) {
                File targetFile = new File(targetDir, file.getName());

                // Copy only if the file doesn't already exist
                if (!targetFile.exists()) {
                    Files.copy(file.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Copied: " + file.getName());
                } else {
                    System.out.println("Skipped (already exists): " + file.getName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

