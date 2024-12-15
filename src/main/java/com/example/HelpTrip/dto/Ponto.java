package com.example.HelpTrip.dto;

import jakarta.persistence.*;
import org.springframework.data.geo.Point;

@Entity
@Table(name = "dto.Ponto")
public class Ponto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String nome;

    private String descricao;

    @Column(columnDefinition = "geography(Point, 4326)")
    private Point localizacao;

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Point getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Point localizacao) {
        this.localizacao = localizacao;
    }



}
