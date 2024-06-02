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
    @Query(value = "UPDATE PROMOCION_DETALLE SET ARTICULO_ID = :articuloId WHERE PROMOCION_ID = :promocionId", nativeQuery = true)
    void updatePromocionDetalle(@Param("promocionId") Long promocionId, @Param("articuloId") Long articuloId);

}
