package com.enviro.assessment.grad001.kamogeloellenkganakga.services;

import com.enviro.assessment.grad001.kamogeloellenkganakga.entities.DisposalGuideline;
import com.enviro.assessment.grad001.kamogeloellenkganakga.repositories.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    public DisposalGuideline getDisposalGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disposal Guideline not found"));
    }

    public List<DisposalGuideline> getGuidelinesByWasteCategory(Long wasteCategoryId) {
        return disposalGuidelineRepository.findByWasteCategoryId(wasteCategoryId);
    }

    public DisposalGuideline createDisposalGuideline(DisposalGuideline guideline) {
        return disposalGuidelineRepository.save(guideline);
    }

    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline guideline) {
        guideline.setId(id);
        return disposalGuidelineRepository.save(guideline);
    }

    public void deleteDisposalGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }
}