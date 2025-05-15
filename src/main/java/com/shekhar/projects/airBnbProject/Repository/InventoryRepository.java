package com.shekhar.projects.airBnbProject.Repository;

import com.shekhar.projects.airBnbProject.Entity.Hotel;
import com.shekhar.projects.airBnbProject.Entity.Inventory;
import com.shekhar.projects.airBnbProject.Entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.lang.model.type.IntersectionType;
import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    void deleteByRoom(Room room);
    
    @Query("""
            SELECT DISTINCT i.hotel
            FROM Inventory i
            WHERE i.city = :city
                 AND i.date BETWEEN :startDate AND :endDate
                 AND i.closed = false
                 AND (i.totalCount - i.bookedCount) >= :roomsCount
            GROUP BY i.hotel,i.room
            HAVING COUNT(i.date) = :dateCount    
            """)
    Page<Hotel> findHotelsWithAvailableInventory(
            @Param("city") String city,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("roomsCount") Integer roomsCount,
            @Param("dateCount") Long dateCount,
            Pageable pageable
            );
}
