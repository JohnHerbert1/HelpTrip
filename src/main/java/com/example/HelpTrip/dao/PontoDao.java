package com.example.HelpTrip.dao;

import com.example.HelpTrip.entidy.Ponto;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.geolatte.geom.Polygon;
import org.locationtech.jts.geom.*;
import org.springframework.stereotype.Repository;
import org.w3c.dom.css.ElementCSSInlineStyle;


@Repository
public class PontoDao {

    @PersistenceContext
    EntityManager em;

    private final GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

    @Transactional
    public void salvar(String nome, String descricao, Coordinate[] coordinates){

        Point[] points = new Point[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            points[i] = geometryFactory.createPoint(coordinates[i]);
        }

        MultiPoint point = geometryFactory.createMultiPoint(points);
        Ponto ponto = new Ponto();
        ponto.setNome(nome);
        ponto.setDescricao(descricao);
        ponto.setLocalizacao(point);
        em.persist(ponto);
    }
}
