package com.scream.project.repositories;

import com.scream.project.models.Ad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepo extends JpaRepository<Ad,Long> {
    Page<Ad> findByTitle(String title, Pageable pageable);
    @Override
    Page<Ad> findAll(Pageable pageable);
}

