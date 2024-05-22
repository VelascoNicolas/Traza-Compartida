package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;

import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado,Long> {
    String deleteCascade(Long id);
    List<ArticuloManufacturado> getBySucursal(Long id);
}
