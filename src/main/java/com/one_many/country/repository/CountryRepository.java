package com.one_many.country.repository;



import com.one_many.country.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

    Optional<CountryEntity> findByCountry(String country);

    @Query("SELECT co from CountryEntity co " +
            "JOIN FETCH co.cityEntities ci")
    List<CountryEntity> findAllFetch();
}
