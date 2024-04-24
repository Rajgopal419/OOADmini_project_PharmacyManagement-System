package com.example.pharmacy.management.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.pharmacy.management.Service.MedicineServices;
import com.example.pharmacy.management.model.Medicine;

@Component
public class CreateMedicineCommand implements Command {
    private MedicineServices medicineService;
    private Medicine medicine;
 
    @Autowired
    public CreateMedicineCommand(MedicineServices medicineService) {
        this.medicineService = medicineService;

    } 

    // Setter method to set the medicine
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    @Override
    public void execute() {
        medicineService.save(medicine);
    }


}
