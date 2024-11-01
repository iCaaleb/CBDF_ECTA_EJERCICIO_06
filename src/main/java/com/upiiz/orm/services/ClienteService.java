package com.upiiz.orm.services;

import com.upiiz.orm.models.ClienteEntity;
import com.upiiz.orm.repository.ClienteRepository;
import com.upiiz.orm.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    //Listar todos
    public List<ClienteEntity> obtenerTodos() {
        return clienteRepository.findAll();
    }

    //Listar uno
    public Optional<ClienteEntity> obtenerUno(Long id) {
        return clienteRepository.findById(id);
    }

    //Guardar
    public ClienteEntity guardarCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    //Actualizar
    public Optional<ClienteEntity> actualizarCliente(Long id, ClienteEntity cliente) {
        return clienteRepository.findById(id).map(clienteExistente -> {
            // Aquí se actualizan solo los campos necesarios
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setEmail(cliente.getEmail());
            // Agrega más setters si necesitas actualizar otros campos

            return clienteRepository.save(clienteExistente);
        });
    }

    //Delete
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }


}