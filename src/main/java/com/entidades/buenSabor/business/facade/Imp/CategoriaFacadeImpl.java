package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.CategoriaFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.CategoriaMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.domain.dto.CategoriaDto;
import com.entidades.buenSabor.domain.dto.CategoriaShortDto;
import com.entidades.buenSabor.domain.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaFacadeImpl extends BaseFacadeImp<Categoria, CategoriaDto,Long> implements CategoriaFacade {
    public CategoriaFacadeImpl(BaseService<Categoria, Long> baseService, BaseMapper<Categoria, CategoriaDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public String deleteByID(Long id) {
        return categoriaService.deleteByID(id);
    }

    @Override
    public CategoriaShortDto postCategoria(CategoriaDto categoriaDto) {
        Categoria request = categoriaMapper.toEntity(categoriaDto);
        Categoria save = categoriaService.create(request);
        categoriaService.asociarSucursalCategoria(save);
        return categoriaMapper.toShortDTO(request);
    }
}
