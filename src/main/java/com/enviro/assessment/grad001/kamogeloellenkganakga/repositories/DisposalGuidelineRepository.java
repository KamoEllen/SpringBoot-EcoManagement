package com.enviro.assessment.grad001.kamogeloellenkganakga.repositories;

import com.enviro.assessment.grad001.kamogeloellenkganakga.entities.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {

    List<DisposalGuideline> findByWasteCategoryId(@Param("wasteCategoryId") Long wasteCategoryId);
}