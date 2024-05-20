package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.CategoriaFacade;
import com.entidades.buenSabor.business.facade.Imp.CategoriaFacadeImpl;
import com.entidades.buenSabor.domain.dto.CategoriaDto;
import com.entidades.buenSabor.domain.dto.CategoriaShortDto;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins="*")
public class CategoriaController extends BaseControllerImp<Categoria, CategoriaDto,Long, CategoriaFacadeImpl> {
    private static final Logger logger = LoggerFactory.getLogger(BaseControllerImp.class);

    @Autowired
    private CategoriaFacade categoriaFacade;

    public CategoriaController(CategoriaFacadeImpl facade) {super(facade);
    }

   /* @PostMapping("/post")
    public ResponseEntity<?> createCategoria(@RequestBody CategoriaShortDto categoriaShortDto) {
        logger.info("INICIO CREATE {}",categoriaShortDto.getClass());
        return ResponseEntity.ok(categoriaFacade.postCategoria(categoriaShortDto));
    }*/

    /*@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
        logger.info("INICIO DELETE BY Long");
        return ResponseEntity.ok(categoriaFacade.deleteByID(id));
    }*/


}
