package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.EmpleadoFacade;
import com.entidades.buenSabor.business.facade.Imp.EmpleadoFacadeImpl;
import com.entidades.buenSabor.business.service.EmpleadoService;
import com.entidades.buenSabor.domain.dto.EmpleadoDTO;
import com.entidades.buenSabor.domain.entities.Empleado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @Autowired
    private EmpleadoFacade empleadoFacade;

    @GetMapping
    public ResponseEntity<?> getEmpleados() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empleadoFacade.getAll());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<?> createEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empleadoFacade.createNew(empleadoDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpleadoById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empleadoFacade.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmpleado(@PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empleadoFacade.update(empleadoDTO, id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // Método POST para subir imágenes
    @PostMapping("/uploads")
    public ResponseEntity<String> uploadImages(
            @RequestParam(value = "uploads", required = true) MultipartFile[] files,
            @RequestParam(value = "id", required = true) Long idEmpresa) {
        try {
            return service.uploadImages(files, idEmpresa); // Llama al método del servicio para subir imágenes
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
            return service.deleteImage(publicId, id); // Llama al método del servicio para eliminar la imagen
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid UUID format"); // Respuesta HTTP 400 si el UUID no es válido
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred"); // Respuesta HTTP 500 si ocurre un error inesperado
        }
    }

    // Método GET para obtener todas las imágenes almacenadas
    @GetMapping("/getImagesByEmpresaId/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        try {
            return service.getAllImagesByEmpleadoId(id); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }
}
