package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.UsuarioEmpleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioEmpleadoRepository extends BaseRepository<UsuarioEmpleado,Long> {
    @Query(value = "SELECT EXISTS (SELECT 1 FROM USUARIO_EMPLEADO WHERE USER_NAME = :usuario)", nativeQuery = true)
    public boolean existeUsuario(@Param("usuario") String usuario);

    @Query(value = "SELECT PASSWORD FROM USUARIO_EMPLEADO WHERE USER_NAME = :usuario", nativeQuery = true)
    public String getPasswords(@Param("usuario") String usuario);

    @Query(value = "SELECT ID FROM USUARIO_EMPLEADO WHERE USER_NAME = ?1", nativeQuery = true)
    public Long getId(String userName);
}
