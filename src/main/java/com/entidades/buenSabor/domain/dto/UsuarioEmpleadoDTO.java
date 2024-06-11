package com.entidades.buenSabor.domain.dto;

import com.entidades.buenSabor.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioEmpleadoDTO {
    private Long id;
    private boolean eliminado;
    private String password;
    private String userName;
    private Rol tipoEmpleado;
}
