/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionesweb.videogames.sessionBeans;

import com.aplicacionesweb.videogames.entity.Platform;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AvengedCocoX
 */
@Local
public interface PlatformFacadeLocal {

    void create(Platform platform);

    void edit(Platform platform);

    void remove(Platform platform);

    Platform find(Object id);

    List<Platform> findAll();

    List<Platform> findRange(int[] range);

    int count();
    
}
