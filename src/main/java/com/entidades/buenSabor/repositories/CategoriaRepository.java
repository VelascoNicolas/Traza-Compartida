package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Categoria;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria,Long>{
    @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.sucursales WHERE c.id = :id")
    Categoria findWithSucursalesById(@Param("id") Long id);

    @Query(value = "SELECT EXISTS(\n" +
            "    SELECT 1\n" +
            "    FROM ARTICULO\n" +
            "    WHERE CATEGORIA_ID = ?1 AND ELIMINADO = FALSE\n" +
            ");", nativeQuery = true)
    boolean existe(Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO SUCURSAL_CATEGORIA (SUCURSAL_ID, CATEGORIA_ID)\n" +
            "VALUES (?1, ?2);", nativeQuery = true)
    void insertarSucursalCategoria(Long idSucursal, Long idCategoria);
}
