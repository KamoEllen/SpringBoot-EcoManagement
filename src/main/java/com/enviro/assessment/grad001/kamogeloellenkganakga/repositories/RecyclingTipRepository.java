package com.enviro.assessment.grad001.kamogeloellenkganakga.repositories;

import com.enviro.assessment.grad001.kamogeloellenkganakga.entities.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
}