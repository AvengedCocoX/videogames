/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionesweb.videogames.sessionBeans;

import com.aplicacionesweb.videogames.entity.Game;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AvengedCocoX
 */
@Local
public interface GameFacadeLocal {

    void create(Game game);

    void edit(Game game);

    void remove(Game game);

    Game find(Object id);

    List<Game> findAll();

    List<Game> findRange(int[] range);

    int count();
    
}
