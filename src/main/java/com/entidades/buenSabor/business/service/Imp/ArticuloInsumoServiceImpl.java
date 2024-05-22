package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImp<ArticuloInsumo,Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloManufacturadoDetalleRepository detalleRepository;

    @Autowired
    private ArticuloInsumoRepository articuloRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

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

    @Override
    public List<ArticuloInsumo> getArticuloInsumoBySucursal(Long idSucursal) {
        List<Categoria> categorias = categoriaRepository.getCategoriasBySucursal(idSucursal);
        List<ArticuloInsumo> articulos = new ArrayList<>();
        for (Categoria categoria : categorias) {
            List<ArticuloInsumo> x = articuloRepository.getArticulosByCategoria(categoria.getId());
            for (ArticuloInsumo articulo : x) {
                articulos.add(articulo);
            }
        }
        return articulos;
    }
}
