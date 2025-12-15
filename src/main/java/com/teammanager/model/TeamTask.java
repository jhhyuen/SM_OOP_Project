package com.teammanager.model;

public class TeamTask {
    private String id;          // Unique ID for the task
    private String memberName;  // Who is doing it
    private String taskDescription;
    private String status;      // e.g., "In Progress", "Done"

    // 1. Empty constructor is REQUIRED for Firebase to read data back
    public TeamTask() {}

    // 2. Constructor for creating new tasks
    public TeamTask(String memberName, String taskDescription, String status) {
        this.memberName = memberName;
        this.taskDescription = taskDescription;
        this.status = status;
    }

    // 3. Getters and Setters are REQUIRED
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public String getTaskDescription() { return taskDescription; }
    public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}