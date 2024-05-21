package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.CategoriaDto;
import com.entidades.buenSabor.domain.dto.CategoriaShortDto;

public interface CategoriaFacade extends BaseFacade<CategoriaDto,Long> {
    String deleteByID(Long id);

    CategoriaShortDto postCategoria(CategoriaDto categoriaDto);
}
