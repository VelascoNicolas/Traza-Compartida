package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.PromocionFacade;
import com.entidades.buenSabor.business.mapper.ArticuloMapper;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.PromocionMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.PromocionService;
import com.entidades.buenSabor.domain.dto.PromocionDetalleDto;
import com.entidades.buenSabor.domain.dto.PromocionDto;
import com.entidades.buenSabor.domain.entities.DetallePedido;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class PromocionFacadeImpl extends BaseFacadeImp<Promocion, PromocionDto,Long> implements PromocionFacade {
    public PromocionFacadeImpl(BaseService<Promocion, Long> baseService, BaseMapper<Promocion, PromocionDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    private ArticuloMapper articuloMapper;

    @Autowired
    private PromocionMapper promocionMapper;

    @Autowired
    private PromocionService promocionService;

    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByPromocionId(Long id) {
        return promocionService.getAllImagesByPromocionId(id);
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long id) {
        return promocionService.uploadImages(files,id);
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        return promocionService.deleteImage(publicId, id);
    }

    @Override
    public PromocionDto createPromocion(PromocionDto dto) {
        Promocion promocion = promocionMapper.toEntity(dto);
        Promocion save = promocionService.create2(promocion);
        for (PromocionDetalleDto pd : dto.getPromocionDetalles()) {
            this.asociarArticulo(save.getId(), pd.getArticulo().getId());
        }
        Promocion promo = promocionService.getById(save.getId());
        return promocionMapper.toDTO(promocion);
    }

    @Override
    public void asociarArticulo(Long idPromocion, Long idArticulo) {
        promocionService.asociarArticulo(idPromocion, idArticulo);
    }
}
