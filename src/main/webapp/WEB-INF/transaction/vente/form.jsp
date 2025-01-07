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
                <h4 class="card-title">Insertion Vente</h4>
                <form action="/vente" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input type="date" name="dateTransaction" class="form-control" id="floatingInput" placeholder="Date vente">
                                <label for="floatingInput">Date vente</label>
                            </div>
                        </div>
                    </div>
                    <div id="achatDetails">
                        <div class="row">
                            <div class="col-md-6">
                                <select name="produits[0].idProduit" class="form-select" aria-label="Default select example">
                                    <option selected>Ingredients</option>
                                    <% for (Produit produit:produits) { %>
                                    <option value="<%= produit.getIdProduit() %>"><%= produit.getProduit() %></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <input type="number" name="produits[0].quantite" class="form-control" id="floatingInput" placeholder="Quantite">
                                    <label for="floatingInput">Quantite</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">

                        </div>
                        <div class="col-md-3">
                            <button class="btn btn-outline-primary" onclick="addDetails()" type="button">Ajouter ingredients</button>
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
        achatDetail.innerHTML+=`<div class="row">
                            <div class="col-md-6">
                                <select name="produits[`+id+`].idProduit" class="form-select" aria-label="Default select example">
                                    <option selected>Ingredients</option>
                                    <% for (Produit produit:produits) { %>
                                    <option value="<%= produit.getIdProduit() %>"><%= produit.getProduit() %></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <input type="number" name="produits[`+id+`].quantite" class="form-control" id="floatingInput" placeholder="Quantite">
                                    <label for="floatingInput">Quantite</label>
                                </div>
                            </div>
                        </div>`;
        id++;
    }
</script>