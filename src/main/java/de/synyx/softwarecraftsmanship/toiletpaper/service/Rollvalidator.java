package de.synyx.softwarecraftsmanship.toiletpaper.service;

import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import org.springframework.stereotype.Component;

import static de.synyx.softwarecraftsmanship.toiletpaper.service.Condition.MINT;

@Component
public class Rollvalidator {

    public boolean validate(Toiletpaper roll) {
        if(roll.getBrand().equals("iRoll")) {
            return false;
        }
        if (!(roll.getLeaves() >= 10 || !(roll.getLayerCount() >= 3))) {
            return false;
        }
        if(roll.getCondition() != MINT) {
            return false;
        }
        return true;
    }
}
