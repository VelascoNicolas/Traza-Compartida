package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.PromocionDto;
import com.entidades.buenSabor.domain.entities.Promocion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses={SucursalMapper.class,ImagenPromocionMapper.class,PromocionDetalleMapper.class})
public interface PromocionMapper extends BaseMapper<Promocion, PromocionDto>{
}
