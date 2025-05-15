package com.shekhar.projects.airBnbProject.Repository;

import com.shekhar.projects.airBnbProject.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
    
}
