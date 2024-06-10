package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.UsuarioEmpleadoFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.EmpleadoMapper;
import com.entidades.buenSabor.business.mapper.UsuarioEmpleadoMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.UsuarioEmpleadoService;
import com.entidades.buenSabor.domain.dto.EmpleadoDTO;
import com.entidades.buenSabor.domain.dto.UsuarioEmpleadoDTO;
import com.entidades.buenSabor.domain.entities.Empleado;
import com.entidades.buenSabor.domain.entities.UsuarioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEmpleadoFacadeImpl implements UsuarioEmpleadoFacade {

    @Autowired
    private UsuarioEmpleadoMapper usuarioEmpleadoMapper;

    @Autowired
    private EmpleadoMapper empleadoMapper;

    @Autowired
    private UsuarioEmpleadoService usuarioEmpleadoService;

    @Override
    public UsuarioEmpleadoDTO createUsuarioEmpleado(UsuarioEmpleadoDTO dto) {
        UsuarioEmpleado request = usuarioEmpleadoMapper.toEntity(dto);
        UsuarioEmpleado save = usuarioEmpleadoService.saveUsuarioEmpleado(request);
        return usuarioEmpleadoMapper.toDTO(save);
    }

    @Override
    public EmpleadoDTO login(String userName, String password) {
        Empleado empleado = usuarioEmpleadoService.login(userName, password);
        return empleadoMapper.toDTO(empleado);
    }
}
