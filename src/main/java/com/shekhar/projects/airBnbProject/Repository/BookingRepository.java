package com.shekhar.projects.airBnbProject.Repository;

import com.shekhar.projects.airBnbProject.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
