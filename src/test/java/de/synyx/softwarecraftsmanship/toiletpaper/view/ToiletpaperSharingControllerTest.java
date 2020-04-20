package de.synyx.softwarecraftsmanship.toiletpaper.view;

import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import de.synyx.softwarecraftsmanship.toiletpaper.service.ToiletpaperSharingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToiletpaperSharingControllerTest {

    private ToiletpaperSharingService mockToiletpaperSharingService;

    @BeforeEach
    void setUp() {
        mockToiletpaperSharingService = mock(ToiletpaperSharingService.class);
        when(mockToiletpaperSharingService.getAllAvailableToiletpaper())
                .thenReturn(Arrays.asList(createToiletpaper(4, 200),
                        createToiletpaper(3, 200),
                        createToiletpaper(4, 15)));
    }

    @Test
    void getAllAvailableToiletpaper() {

        ToiletpaperSharingController sut = new ToiletpaperSharingController(mockToiletpaperSharingService);

        assertThat(sut.getAllToiletpaper().getStatusCode(), is(HttpStatus.OK));
        assertThat(sut.getAllToiletpaper().getBody(), hasSize(3));
    }

    @Test
    void getAllAvailableToiletpaper_returns204WhenNoTPAvailable() {

        when(mockToiletpaperSharingService.getAllAvailableToiletpaper()).thenReturn(Collections.emptyList());

        ToiletpaperSharingController sut = new ToiletpaperSharingController(mockToiletpaperSharingService);

        assertThat(sut.getAllToiletpaper().getStatusCode(), is(HttpStatus.NO_CONTENT));
    }

    private Toiletpaper createToiletpaper(int layerCount, int leaves) {
        Toiletpaper tp = new Toiletpaper();
        tp.setLayerCount(layerCount);
        tp.setLeaves(leaves);
        return tp;
    }
}