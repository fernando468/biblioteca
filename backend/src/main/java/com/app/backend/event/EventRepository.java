package com.app.backend.event;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    @Transactional
    @Query(nativeQuery = true, value = "" +
            "UPDATE event " +
            "SET status = :status " +
            "WHERE id = :id" +
            "")
    @Modifying
    void updateStatus(int status, UUID id);
}
