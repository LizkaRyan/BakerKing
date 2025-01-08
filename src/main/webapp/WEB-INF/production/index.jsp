<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.produit.Production" %>
<%@ page import="mg.itu.bakerking.entity.produit.Ingredient" %>
<%@ page import="mg.itu.bakerking.entity.produit.Categorie" %>
<%
    List<Production> productions=(List<Production>)request.getAttribute("production");
    List<Ingredient> ingredients = (List<Ingredient>) request.getAttribute("ingredients");
    List<Categorie> categories = (List<Categorie>)request.getAttribute("categories");
    String idCategorie=(String)request.getAttribute("idCategorie");
    String idIngredient=(String)request.getAttribute("idIngredient");
%>
<div class="row mb-3">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Recherche production</h4>
                <form action="/production" method="get">
                    <div class="row mb-3">
                        <div class="col-md-5">
                            <select name="idIngredient" class="form-select" aria-label="Default select example">
                                <option value="Tous">Tous</option>
                                <%
                                    for (Ingredient i : ingredients) {
                                %>
                                <option value="<%= i.getIdIngredient() %>" <% if(idIngredient.equals(i.getIdIngredient())){ %> selected <% } %>><%= i.getIngredient() %></option>
                                <% } %>
                            </select>
                        </div>
                        <div class="col-md-5">
                            <select name="idCategorie" class="form-select" aria-label="Default select example">
                                <option value="Tous">Tous</option>
                                <%
                                    for (Categorie c : categories) {
                                %>
                                <option value="<%= c.getIdCategorie() %>" <% if(idCategorie.equals(c.getIdCategorie())){ %> selected <% } %>><%= c.getCategorie() %></option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                        </div>
                        <div class="col-md-3">
                            <button type="submit" class="btn btn-outline-primary">Valider</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Liste des productions</h4>
                <table class="table table-hoverable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Quantite</th>
                        <th>Date</th>
                        <th>Produit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (Production production: productions) {
                    %>
                    <tr>
                        <td><%= production.getIdProduction() %></td>
                        <td><%= production.getQuantite() %></td>
                        <td><%= production.getDateProduction() %></td>
                        <td><%= production.getProduit().getProduit() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>