package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.UnidadMedidaFacadeImpl;
import com.entidades.buenSabor.business.facade.UnidadMedidaFacade;
import com.entidades.buenSabor.domain.dto.CategoriaDto;
import com.entidades.buenSabor.domain.dto.UnidadMedidaDto;
import com.entidades.buenSabor.domain.entities.UnidadMedida;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidadMedida")
@CrossOrigin(origins="*")
public class UnidadMedidaController extends BaseControllerImp<UnidadMedida, UnidadMedidaDto, Long, UnidadMedidaFacadeImpl> {
    private static final Logger logger = LoggerFactory.getLogger(BaseControllerImp.class);

    @Autowired
    private UnidadMedidaFacade unidadMedidaFacade;

    public UnidadMedidaController(UnidadMedidaFacadeImpl facade) {
        super(facade);
    }
/*
    @PostMapping
    public ResponseEntity<?> postUnidadMedida(@RequestBody UnidadMedidaDto unidadMedidaDto) {
        logger.info("INICIO CREATE {}",unidadMedidaDto.getClass());
        return ResponseEntity.ok(unidadMedidaFacade.createUnidadMedida(unidadMedidaDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCategoria(@PathVariable Long id, @RequestBody UnidadMedidaDto unidadMedidaDto) {
        logger.info("INICIO UPDATE BY Long");
        return ResponseEntity.ok(unidadMedidaFacade.updateUnidadMedida(id, unidadMedidaDto));
    }*/
}
