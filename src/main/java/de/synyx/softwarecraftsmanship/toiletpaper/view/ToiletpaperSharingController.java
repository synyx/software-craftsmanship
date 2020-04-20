package de.synyx.softwarecraftsmanship.toiletpaper.view;

import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import de.synyx.softwarecraftsmanship.toiletpaper.persistence.ToiletpaperRepository;
import de.synyx.softwarecraftsmanship.toiletpaper.service.ToiletpaperSharingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToiletpaperSharingController {

    ToiletpaperSharingService toiletpaperSharingService;

    public ToiletpaperSharingController(ToiletpaperSharingService toiletpaperSharingService) {
        this.toiletpaperSharingService = new ToiletpaperSharingService(new ToiletpaperRepository());
    }

    @GetMapping("toiletpaper")
    public ResponseEntity<List<Toiletpaper>> getAllToiletpaper() {
        List<Toiletpaper> allAvailableToiletpaper = toiletpaperSharingService.getAllAvailableToiletpaper();

        if (allAvailableToiletpaper.size() > 0) {
            return ResponseEntity.ok(allAvailableToiletpaper);
        }

        return ResponseEntity.noContent().build();
    }
}
