/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionesweb.videogames.sessionBeans;

import com.aplicacionesweb.videogames.entity.Valoration;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AvengedCocoX
 */
@Stateless
public class ValorationFacade extends AbstractFacade<Valoration> implements ValorationFacadeLocal {
    @PersistenceContext(unitName = "com.aplicacionesWeb_videogames_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValorationFacade() {
        super(Valoration.class);
    }
    
}
