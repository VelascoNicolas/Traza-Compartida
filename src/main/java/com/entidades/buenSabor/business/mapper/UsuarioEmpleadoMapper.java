package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.UsuarioEmpleadoDTO;
import com.entidades.buenSabor.domain.entities.UsuarioEmpleado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioEmpleadoMapper extends BaseMapper<UsuarioEmpleado, UsuarioEmpleadoDTO> {
    UsuarioEmpleado toEntity(UsuarioEmpleadoDTO source);
    UsuarioEmpleadoDTO toDTO(UsuarioEmpleado source);
}
