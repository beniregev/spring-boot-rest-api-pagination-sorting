package com.beniregev.spring_boot_pagination_sorting;


import com.beniregev.spring_boot_pagination_sorting.model.PageSettings;
import com.beniregev.spring_boot_pagination_sorting.model.Plant;
import com.beniregev.spring_boot_pagination_sorting.repository.PlantRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PlantService {

    private PlantRepository plantRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Page<Plant> getPlantPage(@NonNull PageSettings pageSetting) {

        Sort plantSort = pageSetting.buildSort();
        Pageable plantPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage(), plantSort);

        return plantRepository.findAll(plantPage);
    }
}
