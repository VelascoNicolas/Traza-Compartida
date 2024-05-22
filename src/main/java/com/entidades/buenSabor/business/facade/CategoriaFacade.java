package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.CategoriaDto;
import com.entidades.buenSabor.domain.dto.CategoriaShortDto;

import java.util.List;

public interface CategoriaFacade extends BaseFacade<CategoriaDto,Long> {
    String deleteByID(Long id);

    CategoriaShortDto postCategoria(CategoriaDto categoriaDto);

    List<CategoriaShortDto> getCategoriasBySucursal(Long idSucursal);
}
