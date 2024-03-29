package com.servicio.usuarios.controller;

import com.servicio.usuarios.models.entity.Usuario;
import com.servicio.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    private List<String> errores = new ArrayList<>();
    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        Map<String,Object> mensajes = new HashMap<>();
        List<Usuario> usuarioList = service.findAll();

        if(usuarioList.isEmpty()){
            mensajes.put("respuesta","no hay registro de usuario");
            return new ResponseEntity<Map<String,Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Usuario>>(usuarioList,HttpStatus.ACCEPTED);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtener(@PathVariable(name = "id")Long id){
        Map<String,Object> mensajes= new HashMap<>();
        Optional<Usuario> obtener = service.findById(id);
        if (!obtener.isPresent()){
            mensajes.put("respuesta","No existe usuario con ese id ="+id);
            return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Usuario>(obtener.get(),HttpStatus.ACCEPTED);
    }

    @PostMapping("/crear")
    public ResponseEntity< ?> crear(@RequestBody @Valid Usuario usuario, BindingResult validar){
        Map<String,Object> mensajes= new HashMap<>();

        if (validar.hasErrors()){
            return validacion(validar, mensajes);
        }if(!usuario.getMail().isEmpty() && service.existsByMail(usuario.getMail())){
            mensajes.put("respuesta","Ya existe un usuario con ese correo electronico");
            return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Usuario>(service.save(usuario),HttpStatus.CREATED);

    }



    @PutMapping("/modificar/{id}")
    public ResponseEntity< ?> editar(@RequestBody @Valid Usuario usuario, BindingResult validar,@PathVariable(name = "id") Long id){
        Map<String,Object> mensajes= new HashMap<>();
        Optional<Usuario> obtener =service.findById(id);
        if (validar.hasErrors()){
            return validacion(validar, mensajes);
        }

        if (obtener.isPresent()){
            Usuario usuario1 = obtener.get();
            if(!usuario.getMail().isEmpty() && !usuario.getMail().equalsIgnoreCase(obtener.get().getMail())
                    && service.findByMail(usuario1.getMail()).isPresent()){
                mensajes.put("respuesta","Ya existe un usuario con ese correo electronico");
                return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.BAD_REQUEST);
            }
            usuario1.setNombre(usuario.getNombre());
            usuario1.setMail(usuario.getMail());
            usuario1.setPassword(usuario.getPassword());
            return new ResponseEntity<Usuario>(service.save(usuario1),HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable(name = "id")Long id){
        Optional<Usuario> obtener =service.findById(id);
        Map<String,Object> mensajes= new HashMap<>();
        if (obtener.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            mensajes.put("respuesta","no se encontro el usuario con el id "+id);
            return  new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/usuarios-por-curso")
    public ResponseEntity<?> usuarioPoCurso(@RequestParam List<Long>ids){
        Map<String,Object> mensajes= new HashMap<>();
        List<Usuario> listarPorIds = service.listarPorIds(ids);
        if (listarPorIds.isEmpty()){
            mensajes.put("respuesta","No existe esos usuario");
            return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Usuario>>(listarPorIds,HttpStatus.ACCEPTED);
    }


    private ResponseEntity<Map<String, Object>> validacion(BindingResult validar, Map<String, Object> mensajes) {
        errores.clear();
        for (FieldError errorCampos: validar.getFieldErrors()) {
            errores.add("El campo '"+errorCampos.getField()+"' "+errorCampos.getDefaultMessage());
        }
        mensajes.put("error",errores);
        return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
