package com.enviro.assessment.grad001.kamogeloellenkganakga.controllers;

import com.enviro.assessment.grad001.kamogeloellenkganakga.entities.WasteCategory;
import com.enviro.assessment.grad001.kamogeloellenkganakga.services.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//used only on classes , indicates class has role of a restful web contoller
//this annotation has 1.controller and 2.2responsebody
//1.controller allows the controller to hndle web requests with handler methods annotatef with 2.requestmapping annotation
//2responsebody allowsthe object returned by the handler methods to be serielazedto json/xml in the esponse body

@RequestMapping("/api/waste-categories")
//requestmapping annotation is used to map to web requests to spring cotroller methods
//can be applied to the controller class as well as handler methods

public class WasteCategoryController {

    @Autowired
    //Autowired annotation is used toinject the bean automaically
    //is used in constructor injection,setter injection and field injection
    private WasteCategoryService wasteCategoryService;

    @GetMapping
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryService.getAllWasteCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        WasteCategory wasteCategory = wasteCategoryService.getWasteCategoryById(id);
        return ResponseEntity.ok(wasteCategory);
    }

    @PostMapping
    public WasteCategory createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        return wasteCategoryService.createWasteCategory(wasteCategory);
    }

    @PutMapping("/{id}")
    public WasteCategory updateWasteCategory(@PathVariable Long id, @RequestBody WasteCategory wasteCategory) {
        return wasteCategoryService.updateWasteCategory(id, wasteCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}