package com.entidades.buenSabor.domain.dto;

import com.entidades.buenSabor.domain.enums.Rol;

public class UsuarioEmpleadoDTO extends BaseDto{
    private String password;
    private String userName;
    private Rol tipoEmpleado;
}
