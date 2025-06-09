package com.ecoapp.repositories;

import com.ecoapp.entities.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {

    List<DisposalGuideline> findByWasteCategoryId(@Param("wasteCategoryId") Long wasteCategoryId);
}