package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado,Long> {
    @Query(value = "SELECT * FROM EMPLEADO WHERE USUARIO_EMPLEADO_ID = :id", nativeQuery = true)
    public Empleado getEmpleado(@Param("id") Long id);
}
