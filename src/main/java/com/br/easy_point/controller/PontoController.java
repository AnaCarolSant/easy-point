package com.br.easy_point.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.br.easy_point.dao.PontoDAO;
import com.br.easy_point.model.Ponto;

@RestController
@RequestMapping("/api/pontos")
public class PontoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PontoDAO pontoDAO;

    @GetMapping
    public ResponseEntity<List<Ponto>> index() {
        List<Ponto> pontos = pontoDAO.listarPontos();
        return ResponseEntity.ok(pontos);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Ponto ponto) {
        pontoDAO.registrarPonto(ponto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ponto cadastrado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable Long id) {
        try {
            Ponto ponto = getPontoById(id);
            return ResponseEntity.ok(ponto);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getReason());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroy(@PathVariable Long id) {
        try {
            pontoDAO.deletarPonto(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Ponto deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar: Ponto não encontrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Ponto pontoAtualizado) {
        try {
            getPontoById(id);
            pontoAtualizado.setId(id); 
            pontoDAO.atualizarPonto(id, pontoAtualizado);
            return ResponseEntity.ok("Ponto atualizado com sucesso!");
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getReason());
        }
    }

    private Ponto getPontoById(Long id) {
        return pontoDAO.listarPontos().stream()
                .filter(ponto -> ponto.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ponto do funcionario com ID " + id + " não encontrado"));
    }
}