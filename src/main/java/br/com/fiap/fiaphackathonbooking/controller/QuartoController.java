package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.QuartoDTO;
import br.com.fiap.fiaphackathonbooking.service.QuartoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quartos")
@AllArgsConstructor
public class QuartoController {

    private final QuartoService quartoService;

    @PostMapping
    public ResponseEntity<QuartoDTO> adicionarQuarto(@RequestBody QuartoDTO quartoDTO) {
        QuartoDTO novoQuarto = quartoService.adicionarQuarto(quartoDTO);
        return new ResponseEntity<>(novoQuarto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuartoDTO> atualizarQuarto(@PathVariable Long id, @RequestBody QuartoDTO quartoDTO) {
        QuartoDTO atualizado = quartoService.atualizarQuarto(id, quartoDTO);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarQuarto(@PathVariable Long id) {
        quartoService.deletarQuarto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<QuartoDTO>> listarTodosOsQuartos() {
        List<QuartoDTO> quartos = quartoService.listarTodos();
        return ResponseEntity.ok(quartos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuartoDTO> buscarQuartoPorId(@PathVariable Long id) {
        QuartoDTO quarto = quartoService.buscarPorId(id);
        return ResponseEntity.ok(quarto);
    }
}
