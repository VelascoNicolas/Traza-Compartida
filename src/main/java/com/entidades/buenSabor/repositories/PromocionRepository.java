package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Promocion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PromocionRepository extends BaseRepository<Promocion,Long>{
    @Query("SELECT p FROM Promocion p LEFT JOIN FETCH p.sucursales WHERE p.id = :id")
    Promocion findAllWithSucursales(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PROMOCION_DETALLE SET ARTICULO_ID = :articuloId WHERE ID = :id", nativeQuery = true)
    void updatePromocionDetalle(@Param("id") Long detalleId, @Param("articuloId") Long articuloId);


    @Modifying
    @Transactional
    @Query(value = "UPDATE PROMOCION_DETALLE SET ELIMINADO = TRUE WHERE ID = :id", nativeQuery = true)
    void deletePromocionDetalle(@Param("id") Long detalleId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PROMOCION_DETALLE SET ELIMINADO = TRUE WHERE PROMOCION_ID = :promocion_id", nativeQuery = true)
    void deleteAll(@Param("promocion_id") Long promocionId);
}
