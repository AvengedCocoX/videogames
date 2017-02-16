/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionesweb.videogames.sessionBeans;

import com.aplicacionesweb.videogames.entity.GameImage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AvengedCocoX
 */
@Local
public interface GameImageFacadeLocal {

    void create(GameImage gameImage);

    void edit(GameImage gameImage);

    void remove(GameImage gameImage);

    GameImage find(Object id);

    List<GameImage> findAll();

    List<GameImage> findRange(int[] range);

    int count();
    
}
