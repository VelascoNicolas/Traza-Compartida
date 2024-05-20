package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.ImagenPromocionFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.ImagenPromocionDto;
import com.entidades.buenSabor.domain.entities.ImagenPromocion;
import org.springframework.stereotype.Service;

@Service
public class ImagenPromocionFacadeImpl extends BaseFacadeImp<ImagenPromocion, ImagenPromocionDto,Long> implements ImagenPromocionFacade {
    public ImagenPromocionFacadeImpl(BaseService<ImagenPromocion, Long> baseService, BaseMapper<ImagenPromocion, ImagenPromocionDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
