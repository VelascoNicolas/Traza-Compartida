package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.PromocionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

public interface PromocionFacade extends BaseFacade<PromocionDto,Long> {
    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByPromocionId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y UUID
    ResponseEntity<String> deleteImage(String publicId, Long id);

    PromocionDto createPromocion(PromocionDto dto);
    void asociarArticulo(Long idPromocion, Long idArticulo);

    PromocionDto actualizarPromocion(PromocionDto dto, Long id);
    void editarArticulos(Long idDetalle, boolean eliminado, Long idArticulo);
    String deleteAll(Long id);
    List<PromocionDto> getPromocionesBySucursalId(Long id);
}
