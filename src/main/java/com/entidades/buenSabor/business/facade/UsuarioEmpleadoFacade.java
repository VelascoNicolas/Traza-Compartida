package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.EmpleadoDTO;
import com.entidades.buenSabor.domain.dto.UsuarioEmpleadoDTO;

public interface UsuarioEmpleadoFacade {
    UsuarioEmpleadoDTO createUsuarioEmpleado(UsuarioEmpleadoDTO dto);
    EmpleadoDTO login(String userName, String password);
}
