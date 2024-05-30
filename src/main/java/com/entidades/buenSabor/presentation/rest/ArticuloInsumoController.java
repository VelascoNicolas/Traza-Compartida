package com.entidades.buenSabor.presentation.rest;


import com.entidades.buenSabor.business.facade.ArticuloInsumoFacade;
import com.entidades.buenSabor.domain.dto.ArticuloInsumoDto;

import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/articuloInsumo")
@CrossOrigin(origins="*")
public class ArticuloInsumoController  {
    private static final Logger logger = LoggerFactory.getLogger(BaseControllerImp.class);
    
    @Autowired
    private ArticuloInsumoFacade articuloInsumoFacade;

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloInsumoDto> getById(@PathVariable Long id){
        logger.info("INICIO GET BY Long {}",id);
        return ResponseEntity.ok(articuloInsumoFacade.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ArticuloInsumoDto>> getAll() {
        logger.info("INICIO GET ALL");
        return ResponseEntity.ok(articuloInsumoFacade.getAll());
    }

    @PostMapping()
    public ResponseEntity<ArticuloInsumoDto> create(@RequestBody ArticuloInsumoDto entity){
        logger.info("INICIO CREATE {}",entity.getClass());
        return ResponseEntity.ok(articuloInsumoFacade.createNew(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticuloInsumoDto> edit(@RequestBody ArticuloInsumoDto entity, @PathVariable Long id){
        logger.info("INICIO EDIT {}",entity.getClass());
        return ResponseEntity.ok(articuloInsumoFacade.update(entity, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        logger.info("INICIO DELETE BY Long");
        return ResponseEntity.ok(articuloInsumoFacade.deleteById(id));
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<?> getArticulosInsumosBySucursal(@PathVariable Long id) {
        logger.info("INICIO GET ARTICULOS INSUMOS BY Sucursal");
        return ResponseEntity.ok(articuloInsumoFacade.getArticuloInsumoBySucursal(id));
    }

    // Método POST para subir imágenes
    @PostMapping("/uploads")
    public ResponseEntity<String> uploadImages(
            @RequestParam(value = "uploads", required = true) MultipartFile[] files,
            @RequestParam(value = "id", required = true) Long idArticulo) {
        try {
            return articuloInsumoFacade.uploadImages(files, idArticulo); // Llama al método del servicio para subir imágenes
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
            return articuloInsumoFacade.deleteImage(publicId, id); // Llama al método del servicio para eliminar la imagen
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
            return articuloInsumoFacade.getAllImagesByArticuloId(id); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }

    @GetMapping("/elaborados")
    public ResponseEntity<List<?>> getElaborados() {
        logger.info("INICIO GET ELABORADOS");
        return ResponseEntity.ok(articuloInsumoFacade.getElaborados());
    }
}
