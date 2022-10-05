package com.logvynskyy.aptrental.services;

import com.logvynskyy.aptrental.dao.ApartmentDAO;
import com.logvynskyy.aptrental.entities.Apartment;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApartmentService {
    private final List<Apartment> apartmentList;

    public ApartmentService(ApartmentDAO apartmentDAO) {
        this.apartmentList = apartmentDAO.getApartmentList();
    }

    public List<Apartment> getAllApartments(){
        return apartmentList;
    }

    public List<Apartment> getApartmentsByFeatures(String features){
        String[] keywordsArr = features.split("[,?\\s*]");

        HashSet<String> searchKeywordsSet = new HashSet<>(Arrays.asList(keywordsArr));
        List<Apartment> apartments = getAllApartments();
        ArrayList<Apartment> filteredApts = new ArrayList<>();

        for (Apartment apartment : apartments) {
            Set<String> keywords = apartment.getKeywords();
            if (keywords.containsAll(searchKeywordsSet)) {
                filteredApts.add(apartment);
            }
        }

        return filteredApts;
    }
}
