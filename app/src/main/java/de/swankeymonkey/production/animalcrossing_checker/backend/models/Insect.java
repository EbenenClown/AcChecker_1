package de.swankeymonkey.production.animalcrossing_checker.backend.models;

import androidx.room.Entity;

@Entity
public class Insect extends Animal {
    private int location;
    private int time;

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
