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

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins="*")
public class CategoriaController {
    private static final Logger logger = LoggerFactory.getLogger(BaseControllerImp.class);

    @Autowired
    private CategoriaFacade categoriaFacade;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> getAll() {
        logger.info("INICIO GET ALL{}");
        return ResponseEntity.ok(categoriaFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> getById(@PathVariable Long id) {
        logger.info("INICIO GET BY Long {}", id);
        return ResponseEntity.ok(categoriaFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> createCategoria(@RequestBody CategoriaDto categoriaDto) {
        logger.info("INICIO CREATE {}",categoriaDto.getClass());
        return ResponseEntity.ok(categoriaFacade.postCategoria(categoriaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
        logger.info("INICIO DELETE BY Long");
        return ResponseEntity.ok(categoriaFacade.deleteByID(id));
    }


}
