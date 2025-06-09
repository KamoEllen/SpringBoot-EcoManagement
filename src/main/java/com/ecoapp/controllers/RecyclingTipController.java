package com.ecoapp.controllers;

import com.ecoapp.entities.RecyclingTip;
import com.ecoapp.services.RecyclingTipService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public ResponseEntity<RecyclingTip> createRecyclingTip(@Valid @RequestBody RecyclingTip recyclingTip) {
    RecyclingTip createdRecyclingTip = recyclingTipService.createRecyclingTip(recyclingTip);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdRecyclingTip);
}

@PutMapping("/{id}")
public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip recyclingTip) {
    RecyclingTip updatedRecyclingTip = recyclingTipService.updateRecyclingTip(id, recyclingTip);
    return ResponseEntity.ok(updatedRecyclingTip);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }

}