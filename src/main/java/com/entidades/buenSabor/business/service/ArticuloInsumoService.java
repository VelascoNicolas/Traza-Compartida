package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo,Long> {
    String deleteLogico(Long id);
    List<ArticuloInsumo> getArticuloInsumoBySucursal(Long idSucursal);

}
