package com.chengfu.android.utils.demo.bean;

public class MainItem {
    private String name;
    private String description;
    private Class<?> targetActivity;

    public MainItem() {
    }

    public MainItem(String name, String description, Class<?> targetActivity) {
        this.name = name;
        this.description = description;
        this.targetActivity = targetActivity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Class<?> getTargetActivity() {
        return targetActivity;
    }

    public void setTargetActivity(Class<?> targetActivity) {
        this.targetActivity = targetActivity;
    }

    @Override
    public String toString() {
        return "MainItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", targetActivity=" + targetActivity +
                '}';
    }
}
