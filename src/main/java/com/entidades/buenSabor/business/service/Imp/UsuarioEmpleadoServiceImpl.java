package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.UsuarioEmpleadoService;
import com.entidades.buenSabor.domain.entities.Empleado;
import com.entidades.buenSabor.domain.entities.UsuarioEmpleado;
import com.entidades.buenSabor.repositories.EmpleadoRepository;
import com.entidades.buenSabor.repositories.UsuarioEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEmpleadoServiceImpl implements UsuarioEmpleadoService {

    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public Empleado login(String userName, String password) {
        if (usuarioEmpleadoRepository.existeUsuario(userName)) {
            String pass = usuarioEmpleadoRepository.getPasswords(userName);
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(password, pass)) {
                Long idUser = usuarioEmpleadoRepository.getId(userName);
                return empleadoRepository.getEmpleado(idUser);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public UsuarioEmpleado saveUsuarioEmpleado(UsuarioEmpleado usuarioEmpleado) {
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            usuarioEmpleado.setPassword(passwordEncoder.encode(usuarioEmpleado.getPassword()));
            return usuarioEmpleadoRepository.save(usuarioEmpleado);
        } catch (Exception e) {
            return null;
        }
    }
}
