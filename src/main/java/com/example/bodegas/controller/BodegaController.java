package com.example.bodegas.controller;

import com.example.bodegas.dto.BodegaDTO;
import com.example.bodegas.service.BodegaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bodegas")
@CrossOrigin(origins = "http://localhost:4200")
public class BodegaController {

    private final BodegaService bodegaService;

    public BodegaController(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }

    @PostMapping
    public ResponseEntity<BodegaDTO> registrar(@RequestBody BodegaDTO bodega) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bodegaService.registrar(bodega));
    }

    @GetMapping
    public List<BodegaDTO> listar() {
        return bodegaService.listar();
    }
}
