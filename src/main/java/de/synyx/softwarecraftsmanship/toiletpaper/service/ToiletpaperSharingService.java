package de.synyx.softwarecraftsmanship.toiletpaper.service;

import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import de.synyx.softwarecraftsmanship.toiletpaper.persistence.ToiletpaperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToiletpaperSharingService {

    private ToiletpaperRepository toiletpaperRepository;

    public ToiletpaperSharingService(ToiletpaperRepository toiletpaperRepository) {
        this.toiletpaperRepository = toiletpaperRepository;
    }

    public List<Toiletpaper> getAllAvailableToiletpaper() {

        return toiletpaperRepository.findAll();
    }
}
