package de.swankeymonkey.production.animalcrossing_checker.backend.models;

import androidx.room.Entity;
import androidx.room.Ignore;

import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishLocation;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishTime;

@Entity
public class Fish extends Animal {
    private int locationId;
    private int timeId;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public FishLocation getLocation() {
        return FishLocation.getLocation(locationId);
    }

    public void setLocation(FishLocation location) {
        setLocationId(location.getId());
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    @Ignore
    public FishTime getTime() {
        return  FishTime.getFishTimes(getTimeId());
    }

    @Ignore
    public void setTime(FishTime fishTime) {
        setTimeId(fishTime.getId());
    }
}
