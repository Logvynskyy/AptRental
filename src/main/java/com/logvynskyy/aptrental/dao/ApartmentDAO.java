package com.logvynskyy.aptrental.dao;

import com.logvynskyy.aptrental.beans.Apartment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApartmentDAO {
    private List<Apartment> apartmentList = new ArrayList<>();
    private static int counter = 0;

    public List<Apartment> getAllApartments(){
        return apartmentList;
    }

    public Apartment getApartment(int id){
        return apartmentList.stream().filter(apartment -> apartment.getId() == id).findAny().orElse(null);
    }

    public void addApartment(Apartment apartment){
        apartment.setId(counter++);
        apartmentList.add(apartment);
    }

    public void editApartment(int id, Apartment apartment){
        Apartment editedApt = getApartment(id);
        editedApt.setName(apartment.getName());
        editedApt.setKeywords(apartment.getKeywords());
        editedApt.setKeywordsInString(apartment.getKeywordsInString());
        editedApt.setDescription(apartment.getDescription());
    }

    public void deleteApartment(int id){
        apartmentList.removeIf(apt -> apt.getId() == id);
    }
}
