package com.example.HelpTrip.entidy;


import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Polygon;
import org.springframework.data.util.QTypeContributor;

@Entity
@Table(name = "Plantacao")
public class AreaPlantacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descrição")
    private String descricao;


    @Column(columnDefinition = "geometry(Polygon,4326)")
    private Polygon area;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao){ this.descricao = descricao; }

    public Polygon getPolygon() {
        return area;
    }

        public void setPolygon(Polygon polygon) { this.area = polygon; }
}
