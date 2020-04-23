package de.synyx.softwarecraftsmanship.toiletpaper.service;

import de.synyx.softwarecraftsmanship.customer.model.Customer;
import de.synyx.softwarecraftsmanship.customer.service.CustomerService;
import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import de.synyx.softwarecraftsmanship.toiletpaper.persistence.ToiletpaperRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToiletpaperSharingService {

    private ToiletpaperRepository toiletpaperRepository;

    private CustomerService customerService;

    public ToiletpaperSharingService(ToiletpaperRepository toiletpaperRepository) {
        this.toiletpaperRepository = toiletpaperRepository;
    }

    public List<Toiletpaper> getAllAvailableToiletpaper() {

        return toiletpaperRepository.findAll();
    }
    
    public void checkoutToiletpaper(Long toiletpaperId, Long customerId) {
        
        
    }
}
