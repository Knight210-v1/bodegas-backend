package com.example.bodegas.service;

import com.example.bodegas.dto.BodegaDTO;
import com.example.bodegas.dto.ProductoDTO;
import com.example.bodegas.entity.Bodega;
import com.example.bodegas.repository.BodegaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BodegaService {

    private final BodegaRepository bodegaRepository;

    public BodegaService(BodegaRepository bodegaRepository) {
        this.bodegaRepository = bodegaRepository;
    }

    public BodegaDTO registrar(BodegaDTO dto) {
        Bodega bodega = new Bodega(dto.nombre(), dto.ubicacion());
        Bodega guardada = bodegaRepository.save(bodega);
        return convertirADTO(guardada);
    }

    @Transactional(readOnly = true)
    public List<BodegaDTO> listar() {
        return bodegaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private BodegaDTO convertirADTO(Bodega bodega) {
        List<ProductoDTO> productos = bodega.getProductos()
                .stream()
                .map(p -> new ProductoDTO(p.getId(), p.getNombre(), p.getDescripcion(), p.getPrecio(), p.getCantidad()))
                .toList();

        return new BodegaDTO(bodega.getId(), bodega.getNombre(), bodega.getUbicacion(), productos);
    }
}
