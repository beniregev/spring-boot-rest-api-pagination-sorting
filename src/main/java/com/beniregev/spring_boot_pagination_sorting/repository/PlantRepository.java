package com.beniregev.spring_boot_pagination_sorting.repository;

import com.beniregev.spring_boot_pagination_sorting.model.Plant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends PagingAndSortingRepository<Plant, Long> {
}
