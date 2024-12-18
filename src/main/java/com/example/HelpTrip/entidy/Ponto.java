package com.example.HelpTrip.entidy;


import jakarta.persistence.*;

import org.locationtech.jts.geom.MultiPoint;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import java.util.List;

@Entity
@Table(name = "Ponto")
public class Ponto {



    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @Column(name = "Nome")
    private String nome;
    @Column(name = "Descricao")
    private String descricao;

    @Column(columnDefinition = "geometry(MultiPoint,4326)")
    private MultiPoint localizacoes;


    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public MultiPoint getLocalizacao() {return localizacoes;}
    public void setLocalizacao(MultiPoint localizacao) { this.localizacoes = localizacao;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
}
