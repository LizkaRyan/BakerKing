<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.transaction.vente.VenteDetails" %>
<%@ page import="mg.itu.bakerking.entity.produit.Categorie" %>
<%@ page import="mg.itu.bakerking.entity.produit.TypeProduit" %>
<%
    List<VenteDetails> details=(List<VenteDetails>)request.getAttribute("details");
    List<TypeProduit> typeProduits = (List<TypeProduit>)request.getAttribute("TypeProduits");
    List<Categorie> categories = (List<Categorie>)request.getAttribute("categories");

    String idCategorie=(String)request.getAttribute("idCategorie");
    String idTypeProduit=(String)request.getAttribute("idTypeProduit");
%>

<div class="row mb-3">
    <div class="col-md-2" style="margin-left: 7%">

    </div>
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Filtre vente</h4>
                <form action="/vente/filter" method="get">
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <select name="idTypeProduit" class="form-select" aria-label="Default select example">
                                <option value="Tous">Toutes types</option>
                                <%
                                    for (TypeProduit i : typeProduits) {
                                %>
                                <option value="<%= i.getIdTypeProduit() %>" <% if(i.getIdTypeProduit().equals(idTypeProduit)){ %> selected <% } %>><%= i.getTypeProduit() %></option>
                                <% } %>
                            </select>
                        </div>
                        <div class="col-md-5">
                            <select name="idCategorie" class="form-select" aria-label="Default select example">
                                <option value="Tous">Toutes catégorie</option>
                                <%
                                    for (Categorie c : categories) {
                                %>
                                <option value="<%= c.getIdCategorie() %>" <% if(c.getIdCategorie().equals(idCategorie)){ %> selected <% } %>><%= c.getCategorie() %></option>
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
    <div class="col-md-2" style="margin-left: 3%">

    </div>
    <div class="col-md-7">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Liste des ventes</h4>
                <table class="table table-hoverable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Montant</th>
                        <th>Quantite</th>
                        <th>Produit</th>
                        <th>Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (VenteDetails detail:details) {
                    %>
                    <tr>
                        <td><%= detail.getIdDetails() %></td>
                        <td><%= detail.getMontant() %></td>
                        <td><%= detail.getQuantite() %></td>
                        <td><%= detail.getProduit().getProduit() %></td>
                        <td><%= detail.getVente().getDateTransaction() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>