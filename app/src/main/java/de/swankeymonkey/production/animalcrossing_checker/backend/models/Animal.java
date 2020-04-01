package de.swankeymonkey.production.animalcrossing_checker.backend.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public abstract class Animal {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private ArrayList<String> months;
    private int price;
    private boolean isCatched;

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

    public ArrayList<String> getMonths() {
        return months;
    }

    public void setMonths(ArrayList<String> months) {
        this.months = months;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isCatched() {
        return isCatched;
    }

    public void setCatched(boolean catched) {
        isCatched = catched;
    }


}
