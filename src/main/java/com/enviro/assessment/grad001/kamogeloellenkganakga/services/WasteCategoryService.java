package com.enviro.assessment.grad001.kamogeloellenkganakga.services;

import com.enviro.assessment.grad001.kamogeloellenkganakga.entities.WasteCategory;
import com.enviro.assessment.grad001.kamogeloellenkganakga.repositories.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//used at class level only
//indicates class as service
//implements domain specific business logic , no states
//the annotated class will be atodetected through classpath scanning
//spring will create an instance of the class, which is then managed in the managed bean
//the bean will be eligible for dependency injectio(via @autowired field)

public class WasteCategoryService {

    @Autowired 
    
    private WasteCategoryRepository wasteCategoryRepository;

    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Waste Category not found"));
    }

    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    public WasteCategory updateWasteCategory(Long id, WasteCategory wasteCategory) {
        wasteCategory.setId(id);
        return wasteCategoryRepository.save(wasteCategory);
    }

    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}