package com.entidades.buenSabor.domain.dto;

import com.entidades.buenSabor.domain.entities.ImagenEmpleado;
import com.entidades.buenSabor.domain.entities.UsuarioEmpleado;
import jakarta.persistence.OneToOne;
import org.hibernate.envers.NotAudited;

import java.time.LocalDate;

public class EmpleadoDTO extends BaseDto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    private UsuarioEmpleadoDTO usuarioEmpleadoDTO;
    private ImagenEmpleadoDTO imagenEmpleadoDTO;
}
