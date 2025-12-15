package com.teammanager.db;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.IOException;
import java.io.InputStream;

public class FirebaseInitialize {

    public static void initialize() {
        try {
            // 1. Try to load the file from the classpath root
            InputStream serviceAccount = FirebaseInitialize.class
                    .getClassLoader()
                    .getResourceAsStream("serviceAccountKey.json");

            // 2. SAFETY CHECK: If file is null, STOP EVERYTHING!
            if (serviceAccount == null) {
                throw new RuntimeException("🔥 CRITICAL ERROR: Could not find 'serviceAccountKey.json'. \n"
                        + "Please ensure it is in 'src/main/resources' and 'Project > Clean' has been run.");
            }

            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("✅ Firebase Application Initialized Successfully!");
            }

        } catch (IOException e) {
            // Re-throw the error as a RuntimeException to crash the app intentionally
            throw new RuntimeException("Failed to read the key file!", e);
        }
    }
}