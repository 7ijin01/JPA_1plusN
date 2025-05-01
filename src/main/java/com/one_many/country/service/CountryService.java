package com.one_many.country.service;


import com.one_many.country.entity.CityEntity;
import com.one_many.country.entity.CountryEntity;
import com.one_many.country.repository.CityRepository;
import com.one_many.country.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public CountryService(CountryRepository countryRepository, CityRepository cityRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    // 국가 추가
    public void createCountry(String countryName) {

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCountry(countryName);

        countryRepository.save(countryEntity);
    }

    // 도시 추가 (국가 연관)
    public void createCity(String countryName, String cityName) {

        CityEntity cityEntity = new CityEntity();
        cityEntity.setCity(cityName);
        cityRepository.save(cityEntity);

        CountryEntity countryEntity = countryRepository.findByCountry(countryName).orElseThrow();
        countryEntity.addCityEntity(cityEntity);

        countryRepository.save(countryEntity);
    }

    public List<CountryEntity> readCountry() {
        return countryRepository.findAll();
    }

    public CityEntity readCity(String cityName) {
        return cityRepository.findByCity(cityName).orElseThrow();
    }

}
