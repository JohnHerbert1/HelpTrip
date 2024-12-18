package com.example.HelpTrip.dao;


import com.example.HelpTrip.entidy.AreaPlantacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.ParseException;

import org.locationtech.jts.io.WKTReader;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public class AreaPlantacaoDAO {

    @PersistenceContext
    private EntityManager em;

    private final GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

    @Transactional
    public void salvar(String nome, String descricao,String area) throws ParseException {

        Polygon poligono1 = (Polygon) new WKTReader().read(area);
        Polygon geo = geometryFactory.createPolygon(poligono1.getExteriorRing());
        geo.setSRID(4326);

        AreaPlantacao areaPlantacao = new AreaPlantacao();
        areaPlantacao.setNome(nome);
        areaPlantacao.setDescricao(descricao);
        areaPlantacao.setPolygon(geo);
        em.persist(areaPlantacao);

    }

    @Transactional
    public void deletar(int id){
        AreaPlantacao find = em.find(AreaPlantacao.class, id);

        if(find != null){
            em.remove(find);
        }else{
            System.out.println("Erro ao deletar");
        }

    }

    public List<AreaPlantacao> allAreas(){
      return em.createQuery("from AreaPlantacao", AreaPlantacao.class).getResultList();
    }


    public AreaPlantacao busca(int id){

        AreaPlantacao find = em.find(AreaPlantacao.class, id);

        if(find != null){
            return find;
        }
        System.out.println("Erro ao buscar, valor e null");
        return null;
    }

    @Transactional
  public void update(int id, String nome, String descricao){

       AreaPlantacao area = busca(id);
       if(area != null){
           area.setNome(nome);
           area.setDescricao(descricao);
           em.merge(area);
       }else{
           System.out.println("não existe esta null" + area);
       }


  }



}
