/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.ProduitFacade;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author mchanal
 */
@Controller
@Path("client")
public class ClientController {

    @Inject
    ClientFacade facadeCl;

    @Inject
    CommandeFacade facadeC;
    
    @Inject
    Models models;

    @GET
    @View("showAllCommande.jsp")
    public void show() {
        models.put("produits", facadeC.findAll());
    }

}
