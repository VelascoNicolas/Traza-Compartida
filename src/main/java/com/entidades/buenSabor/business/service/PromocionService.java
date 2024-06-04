package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Promocion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface PromocionService extends BaseService<Promocion,Long> {
    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByPromocionId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y Long
    ResponseEntity<String> deleteImage(String publicId, Long id);

    Promocion create2(Promocion promocion);

    void asociarArticulo(Long detalleId, Long idArticulo);
    void editarArticulos(Long detalleId, boolean isEliminado, Long idArticulo);
    void eliminarDetalles(Long PromocionId);
    List<Promocion> getPromocionesBySucursalId(Long id);
    void asociarSucursal(Long idPromocion, Long idSucursal);
}
