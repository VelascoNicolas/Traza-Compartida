package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDto;

import java.util.List;

public interface ArticuloManufacturadoFacade {
    public ArticuloManufacturadoDto createNew(ArticuloManufacturadoDto request);
    public ArticuloManufacturadoDto getById(Long id);
    public List<ArticuloManufacturadoDto> getAll();
    public String deleteById(Long id);
    public ArticuloManufacturadoDto update(ArticuloManufacturadoDto request, Long id);
}
