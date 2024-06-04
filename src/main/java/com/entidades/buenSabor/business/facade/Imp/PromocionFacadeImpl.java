package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.PromocionFacade;
import com.entidades.buenSabor.business.mapper.ArticuloMapper;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.PromocionMapper;
import com.entidades.buenSabor.business.mapper.SucursalMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.PromocionService;
import com.entidades.buenSabor.domain.dto.PromocionDetalleDto;
import com.entidades.buenSabor.domain.dto.PromocionDto;
import com.entidades.buenSabor.domain.dto.SucursalDto;
import com.entidades.buenSabor.domain.entities.DetallePedido;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.repositories.PromocionRepository;
import com.entidades.buenSabor.repositories.SucursalRepository;
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
    private SucursalRepository sucursalRepository;

    @Autowired
    private PromocionRepository promocionRepository;

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
        ArrayList<Long> detallitos = new ArrayList<>();
        for (PromocionDetalle pd: save.getPromocionDetalles()) {
            detallitos.add(pd.getId());
        }
        int i = 0;
        for(PromocionDetalleDto pd: dto.getPromocionDetalles()) {
            this.asociarArticulo(detallitos.get(i), pd.getArticulo().getId());
            i++;
        }
        for (SucursalDto suc : dto.getSucursales()) {
            this.asociarSucursal(save.getId(), suc.getId());
        }
        return promocionMapper.toDTO(save);
    }

    @Override
    public void asociarArticulo(Long detalleId, Long idArticulo) {
        promocionService.asociarArticulo(detalleId, idArticulo);
    }

    public void asociarSucursal(Long promocionId, Long idSucursal) {
        Sucursal sucursalId1 = sucursalRepository.findWithPromocionesById(idSucursal);
        Promocion promocionId1 = promocionRepository.findAllWithSucursales(promocionId);
        sucursalId1.getPromociones().add(promocionId1);
        promocionId1.getSucursales().add(sucursalId1);
        sucursalRepository.save(sucursalId1);
        promocionRepository.save(promocionId1);
    }

    @Override
    public PromocionDto actualizarPromocion(PromocionDto dto, Long id) {
        Promocion promocion = promocionMapper.toEntity(dto);
        Promocion save = promocionService.create2(promocion);
        ArrayList<Long> detallitos = new ArrayList<>();
        for (PromocionDetalle pd: save.getPromocionDetalles()) {
            detallitos.add(pd.getId());
        }
        int i = 0;
        for(PromocionDetalleDto pd: dto.getPromocionDetalles()) {
            this.editarArticulos(detallitos.get(i), pd.isEliminado(), pd.getArticulo().getId());
            i++;
        }
        promocionRepository.resetSucursales(id);
        for (SucursalDto suc : dto.getSucursales()) {
            this.asociarSucursal(save.getId(), suc.getId());
        }

        return promocionMapper.toDTO(save);
    }

    @Override
    public void editarArticulos(Long idDetalle, boolean isEliminado, Long idArticulo) {
        promocionService.editarArticulos(idDetalle, isEliminado, idArticulo);
    }

    @Override
    public String deleteAll(Long id) {
        this.deleteById(id);
        promocionService.eliminarDetalles(id);
        return "PROMOCION ELIMINADA SATISFACTORIAMENTE";
    }

    @Override
    public List<PromocionDto> getPromocionesBySucursalId(Long id) {
        List<Promocion> listado = promocionService.getPromocionesBySucursalId(id);
        return promocionMapper.toDTOsList(listado);
    }


}
