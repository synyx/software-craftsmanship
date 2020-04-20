package de.synyx.softwarecraftsmanship.toiletpaper.view;

import de.synyx.softwarecraftsmanship.toiletpaper.persistence.ToiletpaperRepository;
import de.synyx.softwarecraftsmanship.toiletpaper.service.ToiletpaperSharingService;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class ToiletpaperSharingControllerTest {

    @Test
    void getAllAvailableToiletpaper() {

        ToiletpaperSharingController sut = new ToiletpaperSharingController(new ToiletpaperSharingService(new ToiletpaperRepository()));

        assertThat(sut.getAllToiletpaper().getBody(), hasSize(3));
    }

    // TODO: write a test that makes sure the controller returns 204 when no toiletpaper is found
}