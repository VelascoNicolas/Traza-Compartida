package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long> {
    @Query(value = "SELECT EXISTS(\n" +
            "    SELECT 1\n" +
            "    FROM PROMOCION_DETALLE pd\n" +
            "    WHERE pd.ARTICULO_ID = ?1 AND ELIMINADO = FALSE\n" +
            ");", nativeQuery = true)
    boolean contiene(Long id);
}
