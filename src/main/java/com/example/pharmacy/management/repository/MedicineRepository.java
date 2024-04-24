package com.example.pharmacy.management.repository;




//import com.example.damar.model.UserClass;
import com.example.pharmacy.management.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

//    List<Medicine> findByMedicineNameContaining(String keyword);
    List<Medicine> findByMedicineNameContaining(String keyword);
}