<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.transaction.achat.Achat" %>
<%@ page import="mg.itu.bakerking.entity.produit.Recommandation" %>
<%@ page import="mg.itu.bakerking.entity.produit.Produit" %>
<%@ page import="mg.itu.bakerking.entity.produit.PrixProduit" %><%
    List<Produit> produits=(List<Produit>)request.getAttribute("produits");
    List<PrixProduit> prixProduits = (List<PrixProduit>) request.getAttribute("historique");
%>
<div class="row mb-3">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Recherche produit</h4>
                <form action="/produit/historique/prix" method="get">
                    <div class="row mb-3">
                        <div class="col-md-5">
                            <select name="idProduit" class="form-select" aria-label="Default select example">
                                <% for (int i = 0; i< produits.size(); i++) {
                                %>

                                <option value="<%= produits.get(i).getIdProduit() %>" ><%= produits.get(i).getProduit() %></option>
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
                <h4 class="card-title">Liste des prix produits</h4>
                <table class="table table-hoverable">
                    <thead>
                    <tr>
                        <th>Produit</th>
                        <th>Prix unitaire</th>
                        <th>Date prix</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (PrixProduit prixProduit:prixProduits) {
                    %>
                    <tr>
                        <td><%= prixProduit.getProduit().getProduit() %></td>
                        <td><%= prixProduit.getPrixUnitaire() %></td>
                        <td><%= prixProduit.getDatePrix() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>