package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.domain.entities.Empleado;
import com.entidades.buenSabor.domain.entities.UsuarioEmpleado;

public interface UsuarioEmpleadoService {
    Empleado login(String userName, String password);
    UsuarioEmpleado saveUsuarioEmpleado(UsuarioEmpleado usuarioEmpleado);
}
