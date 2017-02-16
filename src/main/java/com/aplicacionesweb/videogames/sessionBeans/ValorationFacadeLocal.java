/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionesweb.videogames.sessionBeans;

import com.aplicacionesweb.videogames.entity.Valoration;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AvengedCocoX
 */
@Local
public interface ValorationFacadeLocal {

    void create(Valoration valoration);

    void edit(Valoration valoration);

    void remove(Valoration valoration);

    Valoration find(Object id);

    List<Valoration> findAll();

    List<Valoration> findRange(int[] range);

    int count();
    
}
