package com.entidades.buenSabor.domain.entities;

import com.entidades.buenSabor.domain.enums.Rol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@Audited
public class Empleado extends Base{
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    @OneToOne
    private UsuarioEmpleado usuarioEmpleado;

    @OneToOne
    @NotAudited
    private ImagenEmpleado imagenEmpleado;


    @OneToMany(mappedBy = "empleado", cascade = CascadeType.REFRESH, orphanRemoval = true)
    @JsonIgnore
    @Builder.Default
    private Set<Pedido> pedidos= new HashSet<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;
}
