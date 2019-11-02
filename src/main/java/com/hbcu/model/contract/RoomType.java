package com.hbcu.model.contract;

public enum RoomType {

    OFFICE("Офис"), STORE("Склад"), TRADE("Торговое"), SERVER("Серверное");

    private String description;

    RoomType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "description='" + description + '\'' +
                '}';
    }
}
