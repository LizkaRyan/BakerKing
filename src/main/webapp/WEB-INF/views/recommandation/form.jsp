<%@ page import="mg.itu.bakerking.entity.produit.Ingredient" %>
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
                <h4 class="card-title">Insertion recommandations</h4>
                <form action="/recommandations" method="post">
                    <div class="row">
                        <div class="col-md-5">
                            <select name="mois" class="form-select" aria-label="Default select example">
                                <option value="1">Janvier</option>
                                <option value="2">Fevrier</option>
                                <option value="3">Mars</option>
                                <option value="4">Avril</option>
                                <option value="5">Mai</option>
                                <option value="6">Juin</option>
                                <option value="7">Juillet</option>
                                <option value="8">Aout</option>
                                <option value="9">Septembre</option>
                                <option value="10">Octobre</option>
                                <option value="11">Novembre</option>
                                <option value="12">Decembre</option>
                            </select>
                        </div>
                        <div class="col-md-1">

                        </div>
                        <div class="col-md-5">
                            <div class="form-floating mb-3">
                                <input type="number" name="annee" class="form-control" id="floatingInput" placeholder="Annee">
                                <label for="floatingInput">Annee</label>
                            </div>
                        </div>
                    </div>
                    <div id="achatDetails">
                        <div class="row mb-3">
                            <div class="col-md-5">
                                <select name="idProduit[0]" class="form-select" aria-label="Default select example">
                                    <option selected>Produit</option>
                                    <% for (Produit produit: produits) { %>
                                    <option value="<%= produit.getIdProduit() %>"><%= produit.getProduit() %></option>
                                    <% } %>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">

                        </div>
                        <div class="col-md-3">
                            <button class="btn btn-outline-primary" onclick="addDetails()" type="button">Ajouter produit</button>
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
<script>
    var id=1;
    function addDetails(){
        const achatDetail=document.getElementById("achatDetails");
        achatDetail.innerHTML+=`<div class="row mb-3">
                            <div class="col-md-5">
                                <select name="idProduit[`+id+`]" class="form-select" aria-label="Default select example">
                                    <option selected>Produit</option>
                                    <% for (Produit produit:produits) { %>
                                    <option value="<%= produit.getIdProduit() %>"><%= produit.getProduit() %></option>
                                    <% } %>
                                </select>
                            </div>
                        </div>`;
        id++;
    }
</script>