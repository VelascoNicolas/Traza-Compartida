package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.domain.dto.PromocionDto;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.business.facade.Imp.PromocionFacadeImpl;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promocion")
@CrossOrigin("*")
public class PromocionController {
    private PromocionFacadeImpl facade;

    public PromocionController(PromocionFacadeImpl facade) {
        this.facade = facade;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAll() {
        return ResponseEntity.ok().body(facade.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(facade.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> guardarPromocion(@RequestBody PromocionDto dto) {
        return ResponseEntity.ok().body(facade.createPromocion(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPromocion(@RequestBody PromocionDto dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(facade.actualizarPromocion(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPromocion(@PathVariable Long id) {
        return ResponseEntity.ok().body(facade.deleteAll(id));
    }
}
