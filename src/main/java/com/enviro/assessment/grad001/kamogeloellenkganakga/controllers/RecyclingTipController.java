package com.enviro.assessment.grad001.kamogeloellenkganakga.controllers;

import com.enviro.assessment.grad001.kamogeloellenkganakga.entities.RecyclingTip;
import com.enviro.assessment.grad001.kamogeloellenkganakga.services.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    @GetMapping
    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipService.getAllRecyclingTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        RecyclingTip recyclingTip = recyclingTipService.getRecyclingTipById(id);
        return ResponseEntity.ok(recyclingTip);
    }

    @PostMapping
    public RecyclingTip createRecyclingTip(@RequestBody RecyclingTip recyclingTip) {
        return recyclingTipService.createRecyclingTip(recyclingTip);
    }

    @PutMapping("/{id}")
    public RecyclingTip updateRecyclingTip(@PathVariable Long id, @RequestBody RecyclingTip recyclingTip) {
        return recyclingTipService.updateRecyclingTip(id, recyclingTip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }
}