package com.aptech.models;

public class Category {
    int id;
    String name;
    String cratedAt;
    String updatedAt;

    public Category() {
    }

    public Category(int id, String name, String cratedAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.cratedAt = cratedAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(String cratedAt) {
        this.cratedAt = cratedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
