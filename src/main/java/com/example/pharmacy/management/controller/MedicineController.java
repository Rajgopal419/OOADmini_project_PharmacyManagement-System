package com.example.pharmacy.management.controller;

import java.util.Iterator;
import java.util.List;
//import java.util.Optional;


import com.example.pharmacy.management.Search.KeywordSearchCriteria;
import com.example.pharmacy.management.Search.MedicineSearchCriteria;
import com.example.pharmacy.management.Service.MedicineServices;
import com.example.pharmacy.management.command.CreateMedicineCommand;
import com.example.pharmacy.management.model.Admin;
import com.example.pharmacy.management.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.pharmacy.management.Search.KeywordSearchCriteria;


@Controller
public class MedicineController {

    @Autowired
    private MedicineServices service;
    private Medicine medicine;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Medicine> listMedicines = service.listAll();
        model.addAttribute("listMedicines", listMedicines);


        // Get the Admin instance
        Admin admin = Admin.getInstance();

        // Add the Admin object to the model
        model.addAttribute("admin", admin);
        System.out.print("Get / ");
        return "index";
    }
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "new";
    }
//    @RequestMapping(value = "/save", method = RequestMethod.POST)

    @Autowired
    private CreateMedicineCommand createMedicineCommand;

    @PostMapping("/save")
    public String saveMedicine(@ModelAttribute("medicine") Medicine std) {

        createMedicineCommand.setMedicine(std);
        createMedicineCommand.execute();
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditmedicinePage(@PathVariable(name = "id") Long Medicineid) {
        ModelAndView mav = new ModelAndView("update");
        Medicine std = service.get(Medicineid);
        mav.addObject("medicine", std);
//        mav.addObject("medicine", medicine);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deletemedicine(@PathVariable(name = "id") Long Medicineid) {
        service.delete(Medicineid);
        return "redirect:/";
    }

    @GetMapping("/searchform")
    public String searchform(Model model){
        return "searchform";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        MedicineSearchCriteria criteria = new KeywordSearchCriteria(keyword);
        List<Medicine> searchResultIterator = service.search(criteria);
        model.addAttribute("searchResultsIterator", searchResultIterator);
        model.addAttribute("keyword", keyword);
        return "search_results";
    }


    @PostMapping("/updtsave")
    public String updateMedicine(@ModelAttribute("medicine") Medicine updatedMedicine) {
        // Fetch the existing medicine record from the database
        Long id=updatedMedicine.getId();
        updatedMedicine.setId(id);
        Medicine existingMedicine = service.get(updatedMedicine.getId());
//        medicine.setId(id);
        if (updatedMedicine.getId() == null) {
            // Handle the case where ID is null (e.g., log an error, return an error message)
            // You might want to redirect the user to an error page or display a message
            return "redirect:/error";
        }

        // Update the fields of the existing medicine with the new values
        existingMedicine.setMedicineName(updatedMedicine.getMedicineName());
        existingMedicine.setDateOfManufacture(updatedMedicine.getDateOfManufacture());
        existingMedicine.setPrice(updatedMedicine.getPrice());

        // Save the updated medicine record
        service.save(existingMedicine);

        return "redirect:/";
    }
}
