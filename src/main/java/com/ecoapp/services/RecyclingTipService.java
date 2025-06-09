package com.ecoapp.services;

import com.ecoapp.entities.RecyclingTip;
import com.ecoapp.exceptions.ResourceNotFoundException;
import com.ecoapp.repositories.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }
    public RecyclingTip getRecyclingTipById(Long id) {
    return recyclingTipRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recycling Tip not found with id: " + id));
}

    public RecyclingTip createRecyclingTip(RecyclingTip recyclingTip) {
        return recyclingTipRepository.save(recyclingTip);
    }

    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip recyclingTip) {
        recyclingTip.setId(id);
        return recyclingTipRepository.save(recyclingTip);
    }

    public void deleteRecyclingTip(Long id) {
        recyclingTipRepository.deleteById(id);
    }
}