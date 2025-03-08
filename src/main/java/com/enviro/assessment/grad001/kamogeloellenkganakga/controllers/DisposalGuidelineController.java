package com.enviro.assessment.grad001.kamogeloellenkganakga.controllers;

import com.enviro.assessment.grad001.kamogeloellenkganakga.entities.DisposalGuideline;
import com.enviro.assessment.grad001.kamogeloellenkganakga.services.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
   // id, guideline, and wasteType.
    //each waste category (e.g., plastic, glass, organic) will have specific disposal instructions.
    //disposal gide is focus becuase we can retrieve disposal guidelines based on the selected waste category
    //@ManyToOne relationship to WasteCategory
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService disposalGuidelineService;

    @GetMapping
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineService.getAllDisposalGuidelines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {
        DisposalGuideline guideline = disposalGuidelineService.getDisposalGuidelineById(id);
        return ResponseEntity.ok(guideline);
    }

    @GetMapping("/waste-category/{wasteCategoryId}")
    public List<DisposalGuideline> getGuidelinesByWasteCategory(@PathVariable Long wasteCategoryId) {
        return disposalGuidelineService.getGuidelinesByWasteCategory(wasteCategoryId);
    }

    @PostMapping
    public DisposalGuideline createDisposalGuideline(@RequestBody DisposalGuideline guideline) {
        return disposalGuidelineService.createDisposalGuideline(guideline);
    }

    @PutMapping("/{id}")
    public DisposalGuideline updateDisposalGuideline(@PathVariable Long id, @RequestBody DisposalGuideline guideline) {
        return disposalGuidelineService.updateDisposalGuideline(id, guideline);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
