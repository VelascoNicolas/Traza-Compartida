package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.domain.dto.PromocionDto;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.business.facade.Imp.PromocionFacadeImpl;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/promocion")
@CrossOrigin("*")
public class PromocionController {
    private PromocionFacadeImpl facade;

    public PromocionController(PromocionFacadeImpl facade) {
        this.facade = facade;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAll() {
        return ResponseEntity.ok().body(facade.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(facade.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> guardarPromocion(@RequestBody PromocionDto dto) {
        return ResponseEntity.ok().body(facade.createPromocion(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPromocion(@RequestBody PromocionDto dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(facade.actualizarPromocion(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPromocion(@PathVariable Long id) {
        return ResponseEntity.ok().body(facade.deleteAll(id));
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<?>> getPromocionesBySucursalId(@PathVariable Long id) {
        return ResponseEntity.ok().body(facade.getPromocionesBySucursalId(id));
    }

    // Método POST para subir imágenes
    @PostMapping("/uploads")
    public ResponseEntity<String> uploadImages(
            @RequestParam(value = "uploads", required = true) MultipartFile[] files,
            @RequestParam(value = "id", required = true) Long idPromocion) {
        try {
            return facade.uploadImages(files, idPromocion); // Llama al método del servicio para subir imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }

    // Método POST para eliminar imágenes por su publicId y Long
    @PostMapping("/deleteImg")
    public ResponseEntity<String> deleteById(
            @RequestParam(value = "publicId", required = true) String publicId,
            @RequestParam(value = "id", required = true) Long id) {
        try {
            return facade.deleteImage(publicId, id); // Llama al método del servicio para eliminar la imagen
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid UUID format"); // Respuesta HTTP 400 si el UUID no es válido
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred"); // Respuesta HTTP 500 si ocurre un error inesperado
        }
    }

    // Método GET para obtener todas las imágenes almacenadas
    @GetMapping("/getImagesByArticuloId/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        try {
            return facade.getAllImagesByPromocionId(id); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }
}
