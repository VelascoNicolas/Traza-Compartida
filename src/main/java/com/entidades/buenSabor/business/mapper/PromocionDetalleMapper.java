package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.PromocionDetalleDto;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses={ArticuloMapper.class})
public interface PromocionDetalleMapper extends BaseMapper<PromocionDetalle, PromocionDetalleDto>{
}
