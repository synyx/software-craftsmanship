package de.synyx.softwarecraftsmanship.toiletpaper.persistence;

import de.synyx.softwarecraftsmanship.toiletpaper.model.Toiletpaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToiletpaperRepository extends JpaRepository<Toiletpaper, Long> {
}
