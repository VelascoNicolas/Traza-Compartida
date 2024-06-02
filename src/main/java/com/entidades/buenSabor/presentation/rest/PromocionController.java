package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.domain.dto.PromocionDto;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.business.facade.Imp.PromocionFacadeImpl;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promocion")
@CrossOrigin("*")
public class PromocionController extends BaseControllerImp<Promocion, PromocionDto,Long, PromocionFacadeImpl> {
    public PromocionController(PromocionFacadeImpl facade) {
        super(facade);
    }

    @PostMapping("/create")
    public ResponseEntity<?> guardarPromocion(@RequestBody PromocionDto dto) {
        return ResponseEntity.ok().body(facade.createPromocion(dto));
    }


}
