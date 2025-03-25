package com.br.easy_point.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.br.easy_point.model.Ponto;


@Repository
public class PontoDAO {
    private List<Ponto> registros = new ArrayList<>();



    public void registrarPonto(Ponto ponto) {
        registros.add(ponto);
    }




    
    public List<Ponto> listarPontos() {
        return registros;
    }






    public List<Ponto> buscarPontosPorFuncionario(String funcionario) {
        return registros.stream()
                .filter(ponto -> ponto.getFuncionario().equalsIgnoreCase(funcionario))
                .collect(Collectors.toList());
    }



    public void deletarPonto(Long id) {
        registros.removeIf(ponto -> ponto.getId().equals(id));
    }




    public void atualizarPonto(Long id, Ponto pontoAtualizado) {
        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).getId().equals(id)) {
                registros.set(i, pontoAtualizado);
                break;
            }
        }
    }
}