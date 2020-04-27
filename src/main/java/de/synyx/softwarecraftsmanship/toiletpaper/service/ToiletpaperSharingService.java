package de.synyx.softwarecraftsmanship.toiletpaper.service;

import de.synyx.softwarecraftsmanship.customer.exceptions.CustomerNotFoundException;
import de.synyx.softwarecraftsmanship.customer.service.CustomerService;
import de.synyx.softwarecraftsmanship.toiletpaper.exceptions.ToiletpaperAlreadyCheckedOutException;
import de.synyx.softwarecraftsmanship.toiletpaper.exceptions.ToiletpaperNotCheckedOutException;
import de.synyx.softwarecraftsmanship.toiletpaper.exceptions.ToiletpaperNotFoundException;
import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import de.synyx.softwarecraftsmanship.toiletpaper.persistence.ToiletpaperRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToiletpaperSharingService {

    private ToiletpaperRepository toiletpaperRepository;

    private CustomerService customerService;

    public ToiletpaperSharingService(ToiletpaperRepository toiletpaperRepository, CustomerService customerService) {
        this.toiletpaperRepository = toiletpaperRepository;
        this.customerService = customerService;
    }

    public List<Toiletpaper> getAllAvailableToiletpaper() {

        return toiletpaperRepository.findAll();
    }
    
    public void checkoutToiletpaper(Long toiletpaperId, Long customerId) {
        
        Toiletpaper toiletpaper = toiletpaperRepository.findById(toiletpaperId)
            .orElseThrow(() -> new ToiletpaperNotFoundException());

        if (toiletpaper.getCheckedOutByCustomerId() != null) {
            throw new ToiletpaperAlreadyCheckedOutException();
        }

        if (!customerService.exists(customerId)) {
            throw new CustomerNotFoundException();
        }

        toiletpaper.setCheckedOutByCustomerId(customerId);

        toiletpaperRepository.save(toiletpaper);
    }

	public void returnToiletpaper(Long toiletpaperId) {
        Toiletpaper toiletpaper = toiletpaperRepository.findById(toiletpaperId)
            .orElseThrow(() -> new ToiletpaperNotFoundException());

        if (toiletpaper.getCheckedOutByCustomerId() == null) {
            throw new ToiletpaperNotCheckedOutException();
        }

        toiletpaper.setCheckedOutByCustomerId(null);

        toiletpaperRepository.save(toiletpaper);
	}
}
