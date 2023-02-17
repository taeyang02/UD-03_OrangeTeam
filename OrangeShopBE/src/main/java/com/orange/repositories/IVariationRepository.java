package com.orange.repositories;

import com.orange.domain.model.Variation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVariationRepository extends JpaRepository<Variation, Long> {
}