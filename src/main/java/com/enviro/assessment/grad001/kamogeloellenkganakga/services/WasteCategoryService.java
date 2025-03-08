package com.enviro.assessment.grad001.kamogeloellenkganakga.services;

import com.enviro.assessment.grad001.kamogeloellenkganakga.entities.WasteCategory;
import com.enviro.assessment.grad001.kamogeloellenkganakga.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.kamogeloellenkganakga.repositories.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    @Autowired 
    
    private WasteCategoryRepository wasteCategoryRepository;

    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory getWasteCategoryById(Long id) {
    return wasteCategoryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Waste Category not found with id: " + id));
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