package com.entidades.buenSabor.domain.dto;

import com.entidades.buenSabor.domain.entities.ImagenEmpleado;
import com.entidades.buenSabor.domain.entities.UsuarioEmpleado;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.NotAudited;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmpleadoDTO extends BaseDto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    private UsuarioEmpleado usuarioEmpleado;
    private ImagenEmpleado imagenEmpleado;
}
