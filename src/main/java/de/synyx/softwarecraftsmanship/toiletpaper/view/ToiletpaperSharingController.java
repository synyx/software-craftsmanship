package de.synyx.softwarecraftsmanship.toiletpaper.view;

import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import de.synyx.softwarecraftsmanship.toiletpaper.service.ToiletpaperSharingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("toiletpaper")
public class ToiletpaperSharingController {

    ToiletpaperSharingService toiletpaperSharingService;

    public ToiletpaperSharingController(ToiletpaperSharingService toiletpaperSharingService) {
        this.toiletpaperSharingService = toiletpaperSharingService;
    }

    @GetMapping
    public List<Toiletpaper> getAllToiletpaper() {
        return toiletpaperSharingService.getAllAvailableToiletpaper();
    }
}
