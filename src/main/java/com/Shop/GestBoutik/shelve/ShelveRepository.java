package com.Shop.GestBoutik.shelve;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shop.GestBoutik.models.Shelve;

@Repository
public interface ShelveRepository extends JpaRepository<Shelve, Long> {

}
