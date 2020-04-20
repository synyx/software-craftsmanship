package de.synyx.softwarecraftsmanship.toiletpaper.service;

import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import org.springframework.stereotype.Component;

import static de.synyx.softwarecraftsmanship.toiletpaper.service.Condition.MINT;

@Component
public class Rollvalidator {

    public boolean validate(Toiletpaper roll) {
        if("iRoll".equals(roll.getBrand())) {
            return false;
        }
        if(roll.getLeaves() < 10 || roll.getLayerCount() < 3) {
            return false;
        }
        return MINT.equals(roll.getCondition());
    }
}
