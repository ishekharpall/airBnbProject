package com.shekhar.projects.airBnbProject.Repository;


import com.shekhar.projects.airBnbProject.Entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}