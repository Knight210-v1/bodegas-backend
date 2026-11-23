package com.example.bodegas.config;

import com.example.bodegas.entity.Bodega;
import com.example.bodegas.entity.Producto;
import com.example.bodegas.repository.BodegaRepository;
import com.example.bodegas.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final BodegaRepository bodegaRepository;
    private final ProductoRepository productoRepository;

    public DataLoader(BodegaRepository bodegaRepository, ProductoRepository productoRepository) {
        this.bodegaRepository = bodegaRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public void run(String... args) {
        Bodega norte = bodegaRepository.save(new Bodega("Bodega Norte", "Calle 170 #45-10"));
        Bodega sur = bodegaRepository.save(new Bodega("Bodega Sur", "Autopista Sur #60-20"));

        productoRepository.save(new Producto("Computador portátil", "Portátil de 15 pulgadas", 2500000.0, 15, norte));
        productoRepository.save(new Producto("Monitor", "Monitor de 24 pulgadas", 750000.0, 20, norte));
        productoRepository.save(new Producto("Impresora", "Impresora láser", 1200000.0, 8, sur));
        productoRepository.save(new Producto("Consola", "Play 5", 2200000.0, 15, sur));
    }
}
