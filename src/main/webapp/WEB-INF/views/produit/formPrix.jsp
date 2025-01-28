<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.produit.Produit" %><%
    List<Produit> produits=(List<Produit>)request.getAttribute("produits");
%>
<div class="row">
    <div class="col-md-2">

    </div>
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Insertion production</h4>
                <form action="/produit/prix" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input type="date" name="datePrix" class="form-control" id="floatingInput" placeholder="Date prix">
                                <label for="floatingInput">Date prix</label>
                            </div>
                        </div>
                    </div>
                    <div id="achatDetails">
                        <div class="row">
                            <div class="col-md-6">
                                <select name="idProduit" class="form-select" aria-label="Default select example">
                                    <option selected>Produits</option>
                                    <% for (Produit produit:produits) { %>
                                    <option value="<%= produit.getIdProduit() %>"><%= produit.getProduit() %></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <input type="number" name="prixUnitaire" class="form-control" id="floatingInput" placeholder="Prix Unitaire">
                                    <label for="floatingInput">Prix Unitaire</label>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-9">

                        </div>
                        <div class="col-md-3">
                            <button class="btn btn-outline-primary" type="submit">Ajouter</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>