package de.synyx.softwarecraftsmanship.toiletpaper.service;

import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import de.synyx.softwarecraftsmanship.toiletpaper.persistence.ToiletpaperRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ToiletpaperSharingService {

    private ToiletpaperRepository toiletpaperRepository;

    public ToiletpaperSharingService(ToiletpaperRepository toiletpaperRepository) {
        this.toiletpaperRepository = toiletpaperRepository;
    }

    public List<Toiletpaper> getAllAvailableToiletpaper() {

        return Arrays.asList(new Toiletpaper(4, 200), new Toiletpaper(3, 200), new Toiletpaper(4, 15));
    }
}
