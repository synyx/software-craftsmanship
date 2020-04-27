package de.synyx.softwarecraftsmanship.toiletpaper.view;

import de.synyx.softwarecraftsmanship.customer.exceptions.CustomerNotFoundException;
import de.synyx.softwarecraftsmanship.toiletpaper.exceptions.ToiletpaperAlreadyCheckedOutException;
import de.synyx.softwarecraftsmanship.toiletpaper.exceptions.ToiletpaperNotCheckedOutException;
import de.synyx.softwarecraftsmanship.toiletpaper.exceptions.ToiletpaperNotFoundException;
import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import de.synyx.softwarecraftsmanship.toiletpaper.service.ToiletpaperSharingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToiletpaperSharingController {

    ToiletpaperSharingService toiletpaperSharingService;

    public ToiletpaperSharingController(ToiletpaperSharingService toiletpaperSharingService) {
        this.toiletpaperSharingService = toiletpaperSharingService;
    }

    @GetMapping("toiletpaper")
    public ResponseEntity<List<Toiletpaper>> getAllToiletpaper() {
        List<Toiletpaper> allAvailableToiletpaper = toiletpaperSharingService.getAllAvailableToiletpaper();

        if (allAvailableToiletpaper.size() > 0) {
            return ResponseEntity.ok(allAvailableToiletpaper);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("toiletpaper/{toiletpaperId}/checkedOutBy")
    public ResponseEntity<String> checkoutToiletpaper(@PathVariable Long toiletpaperId, @RequestBody Long customerId) {
        try {
            toiletpaperSharingService.checkoutToiletpaper(toiletpaperId, customerId);
        } catch (ToiletpaperNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (CustomerNotFoundException ex) {
            return ResponseEntity.badRequest().body(String.format("Customer with ID %d not found!", customerId));
        } catch (ToiletpaperAlreadyCheckedOutException ex) {
            return ResponseEntity.badRequest().body(String.format("Toiletpaper with ID %d is already checked out!", toiletpaperId));
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("toiletpaper/{toiletpaperId}/checkedOutBy")
    public ResponseEntity<String> returnToiletpaper(@PathVariable Long toiletpaperId) {
        try {
            toiletpaperSharingService.returnToiletpaper(toiletpaperId);
        } catch (ToiletpaperNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (ToiletpaperNotCheckedOutException ex) {
            return ResponseEntity.badRequest().body(String.format("Toiletpaper with ID %d was not checked out!", toiletpaperId));
        }

        return ResponseEntity.ok().build();
    }
}
