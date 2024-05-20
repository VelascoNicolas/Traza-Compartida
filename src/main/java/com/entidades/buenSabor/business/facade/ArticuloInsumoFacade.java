package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;

import java.util.List;

public interface ArticuloInsumoFacade  {
    public ArticuloInsumoDto createNew(ArticuloInsumoDto request);
    public ArticuloInsumoDto getById(Long id);
    public List<ArticuloInsumoDto> getAll();
    public String deleteById(Long id);
    public ArticuloInsumoDto update(ArticuloInsumoDto request, Long id);
}
