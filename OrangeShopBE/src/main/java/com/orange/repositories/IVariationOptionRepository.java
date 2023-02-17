package com.orange.repositories;

import com.orange.domain.model.VariationOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVariationOptionRepository extends JpaRepository<VariationOption, Long> {
}