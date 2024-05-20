package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.repositories.ArticuloManufacturadoDetalleRepository;
import com.entidades.buenSabor.repositories.ArticuloManufacturadoRepository;
import com.entidades.buenSabor.repositories.ImagenArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImp<ArticuloInsumo,Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloManufacturadoDetalleRepository detalleRepository;

    @Autowired
    private ImagenArticuloRepository imagenRepo;

    @Override
    public String deleteLogico(Long id) {
        if (detalleRepository.contiene(id) == false) {
            imagenRepo.deleteLogico(id);
            deleteById(id);
            return "ARTICULO ELIMINADO CORRECTAMENTE";
        } else {
            return "ARTICULO NO SE PUEDE ELIMINAR PERTENECE A UN DETALLE";
        }
    }
}
