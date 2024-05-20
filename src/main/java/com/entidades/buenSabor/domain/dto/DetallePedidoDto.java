package com.entidades.buenSabor.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoDto extends BaseDto{
    private Integer cantidad;
    private Double subTotal;
    private ArticuloDto articulo;
}
