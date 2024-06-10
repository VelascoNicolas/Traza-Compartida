package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.UsuarioEmpleadoFacadeImpl;
import com.entidades.buenSabor.business.facade.UsuarioEmpleadoFacade;
import com.entidades.buenSabor.domain.dto.UsuarioEmpleadoDTO;
import com.entidades.buenSabor.domain.entities.UsuarioEmpleado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/usuarioEmpleado")
public class UsuarioEmpleadoController {

    private static final Logger logger = LoggerFactory.getLogger(BaseControllerImp.class);

    @Autowired
    private UsuarioEmpleadoFacade usuarioEmpleadoFacade;

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody UsuarioEmpleadoDTO usuarioEmpleadoDTO) {
        logger.info("INICIO SIGNIN");
        return ResponseEntity.status(HttpStatus.OK).body(usuarioEmpleadoFacade.createUsuarioEmpleado(usuarioEmpleadoDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String userName,
                                   @RequestParam String password) {
        logger.info("INICIO LOGIN");
        return ResponseEntity.status(HttpStatus.OK).body(usuarioEmpleadoFacade.login(userName, password));
    }
}
