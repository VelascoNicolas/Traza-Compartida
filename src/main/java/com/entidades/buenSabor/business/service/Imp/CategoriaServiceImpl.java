package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends BaseServiceImp<Categoria,Long> implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public String deleteByID(Long id) {
        if (categoriaRepository.existe(id) == false) {
            deleteById(id);
            return "CATEGORIA ELIMINADA CON EXITO";
        } else {
            return "NO SE PUEDE ELIMINAR POSEE ARTICULOS";
        }
    }

    @Override
    public void asociarSucursalCategoria(Categoria categoria) {
        for (Sucursal s: categoria.getSucursales()) {
            categoriaRepository.insertarSucursalCategoria(s.getId(), categoria.getId());
        }
    }


}
