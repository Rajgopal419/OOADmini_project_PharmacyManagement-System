package com.example.pharmacy.management.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.example.pharmacy.management.Search.KeywordSearchCriteria;
import com.example.pharmacy.management.Search.MedicineSearchCriteria;
import com.example.pharmacy.management.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.pharmacy.management.model.Medicine;

import com.example.pharmacy.management.repository.MedicineRepository;

@Service
public class MedicineServices {

    @Autowired
    private MedicineRepository repo;

    public List<Medicine> listAll() {
        return repo.findAll();
    }

    public void save(Medicine medicine) {
        repo.save(medicine);
    }

    public Medicine get(Long medicineId) {
        return repo.findById(medicineId).get();
    }

    public void delete(Long medicineId) {
        repo.deleteById(medicineId);
    }

    //public List<Medicine> search(String keyword) {//return repo.findByMedicineNameContaining(keyword);

    public List<Medicine> search(MedicineSearchCriteria criteria) {
        // Implement logic to fetch data from repository based on criteria
        if (criteria instanceof KeywordSearchCriteria) {
            String keyword = ((KeywordSearchCriteria) criteria).getkeyword();
//            String keyword = KeywordSearchCriteria.getkeyword();



            List<Medicine> searchResult=repo.findByMedicineNameContaining(keyword);
            return searchResult; // Return iterator over search results
        } else {
            throw new UnsupportedOperationException("Search criteria not implemented");

        }
    }
}

