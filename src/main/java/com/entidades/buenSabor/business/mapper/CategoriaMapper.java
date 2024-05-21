package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.CategoriaDto;
import com.entidades.buenSabor.domain.dto.CategoriaShortDto;
import com.entidades.buenSabor.domain.entities.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ArticuloMapper.class, SucursalMapper.class})
public interface CategoriaMapper extends BaseMapper<Categoria, CategoriaDto> {

    Categoria toEntity(CategoriaDto source);
    CategoriaShortDto toShortDTO(Categoria source);
}
