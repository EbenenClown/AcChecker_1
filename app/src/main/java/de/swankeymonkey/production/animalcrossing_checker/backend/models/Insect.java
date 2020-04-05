package de.swankeymonkey.production.animalcrossing_checker.backend.models;

import androidx.room.Entity;
import androidx.room.Ignore;

import de.swankeymonkey.production.animalcrossing_checker.backend.enums.InsectLocation;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.InsectTime;

@Entity
public class Insect extends Animal {
    private int locationId;
    private int timeId;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public InsectLocation getLocation() {
        return InsectLocation.getLocation(locationId);
    }

    public void setLocation(InsectLocation location) {
        setLocationId(location.getId());
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    @Ignore
    public InsectTime getTime() {
        return  InsectTime.getTime(getTimeId());
    }

    @Ignore
    public void setTime(InsectTime fishTime) {
        setTimeId(fishTime.getId());
    }
}
