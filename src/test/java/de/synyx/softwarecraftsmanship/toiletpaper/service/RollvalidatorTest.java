package de.synyx.softwarecraftsmanship.toiletpaper.service;

import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import org.junit.jupiter.api.Test;

import static de.synyx.softwarecraftsmanship.toiletpaper.service.Condition.MINT;
import static de.synyx.softwarecraftsmanship.toiletpaper.service.Condition.RAGGED;
import static org.junit.jupiter.api.Assertions.*;

class RollvalidatorTest {

    private Rollvalidator sut = new Rollvalidator();

    @Test
    void approvesFormidableRoll() {
        Toiletpaper roll = new Toiletpaper(3, 200, "ChromeWipe", MINT);
        assertTrue(sut.validate(roll));
    }

    @Test
    void rejectsCrappyBrands() {
        Toiletpaper roll = new Toiletpaper(3, 200, "iRoll", MINT);
        assertFalse(sut.validate(roll));
    }

    @Test
    void rejectsEmptyRolls() {
        Toiletpaper roll = new Toiletpaper(3, 9, "ChromeWipe", MINT);
        assertFalse(sut.validate(roll));
    }

    @Test
    void rejectsLousyCondition() {
        Toiletpaper roll = new Toiletpaper(3, 200, "ChromeWipe", RAGGED);
        assertFalse(sut.validate(roll));
    }
}