package com.teammanager.db;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.DocumentReference;
import java.util.concurrent.ExecutionException;
import com.teammanager.model.TeamTask;

public class ProjectDatabase {

    private Firestore db;

    public ProjectDatabase() {
        // Get the database instance (requires FirebaseInitialize to have run first)
        this.db = FirestoreClient.getFirestore();
    }

    // METHOD 1: Add a new task to Firestore
    public String addTask(TeamTask task) {
        try {
            // "tasks" is the name of the collection (like a table in SQL)
            // .document() with no arguments creates a random unique ID
            DocumentReference docRef = db.collection("tasks").document();
            
            // Set the ID inside the object so we know it later
            task.setId(docRef.getId());
            
            // Write the object to the database
            ApiFuture<WriteResult> result = docRef.set(task);

            // Wait for the result (block until saved)
            return "Update time: " + result.get().getUpdateTime();

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return "Error adding task.";
        }
    }
}