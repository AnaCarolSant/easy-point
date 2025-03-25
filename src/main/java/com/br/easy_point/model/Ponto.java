package com.br.easy_point.model;

import java.util.Date;

public class Ponto {

    private Long id;
    private String funcionario;
    private Date data;
    private String horaEntrada;
    private String horaSaida;
    
    public Ponto(Long id, String funcionario, Date data, String horaEntrada, String horaSaida) {
        this.id = id;
        this.funcionario = funcionario;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }



    public Long getId() {
        return id;
    }
    

    public void setId(Long id) {
        this.id = id;
    }



    public String getFuncionario() {
        return funcionario;
    }



    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }



    public Date getData() {
        return data;
    }



    public void setData(Date data) {
        this.data = data;
    }


    

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    
}
