package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.ImagenEmpleadoDTO;
import com.entidades.buenSabor.domain.entities.ImagenEmpleado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImagenEmpleadoMapper extends BaseMapper<ImagenEmpleado, ImagenEmpleadoDTO> {
}
