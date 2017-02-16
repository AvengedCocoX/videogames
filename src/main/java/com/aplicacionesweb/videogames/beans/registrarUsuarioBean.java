package com.aplicacionesweb.videogames.beans;

import com.aplicacionesweb.videogames.entity.User;
import com.aplicacionesweb.videogames.sessionBeans.UserFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class registrarUsuarioBean implements Serializable{
    
    @EJB
    private UserFacadeLocal userEjb;
    
    private User user;
    
    @PostConstruct
    public void init() {
        user = new User();
    }
    
    //G&S
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    //Registrar usuario
    public void registrar() {
        List<User> listaUsuarios;

        try {
            listaUsuarios = userEjb.findAll();
            boolean usuarioExiste = false;

            for (User us : listaUsuarios) 
            {
                if (us.getUsername().equals(this.user.getUsername())) 
                {
                    //Mensaje de error
                    usuarioExiste = true;
                }
            }

            if (usuarioExiste == true) 
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Nombre de usuario existente en la aplicación"));
            } 
            else 
            {
                userEjb.create(user);
                
                clear();

                //Mensaje de exito
                if(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() == null)
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro correcto", "Ya puede iniciar sesión en VG-Games"));
                }
                else
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Usuario registrado correctamente"));
                }
            }

        } catch (Exception e) {
            //Mensaje de error
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error en el registro de usuario"));
        }
    }

   //Dejar campos vacíos al registrar un usuario
    public void clear() 
    {
        user.setUsername(null);
        user.setName(null);
        user.setPassword(null);

    }
    
    
    
    
}
