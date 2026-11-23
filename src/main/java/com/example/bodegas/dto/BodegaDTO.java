package com.example.bodegas.dto;

import java.util.List;

public record BodegaDTO(Long id, String nombre, String ubicacion, List<ProductoDTO> productos) {
}
