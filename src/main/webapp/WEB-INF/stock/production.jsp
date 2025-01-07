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
                <h4 class="card-title">Insertion achats</h4>
                <form action="/produit" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input type="date" name="date" class="form-control" id="floatingInput" placeholder="Date achat">
                                <label for="floatingInput">Date achat</label>
                            </div>
                        </div>
                    </div>
                    <div id="achatDetails">
                        <div class="row">
                            <div class="col-md-6">
                                <select name="stockDTO[0].idProduit" class="form-select" aria-label="Default select example">
                                    <option selected>Produits</option>
                                    <% for (Produit produit:produits) { %>
                                    <option value="<%= produit.getIdProduit() %>"><%= produit.getProduit() %></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <input type="number" name="stockDTO[0].quantite" class="form-control" id="floatingInput" placeholder="Quantite">
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
        achatDetail.innerHTML+=`<div id="achatDetails">
                        <div class="row">
                            <div class="col-md-6">
                                <select name="stockDTO[`+id+`].idProduit" class="form-select" aria-label="Default select example">
                                    <option selected>Open this select menu</option>
                                    <% for (Produit produit:produits) { %>
                                    <option value="<%= produit.getIdProduit() %>"><%= produit.getProduit() %></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <input type="number" name="stockDTO[`+id+`].quantite" class="form-control" id="floatingInput" placeholder="Quantite">
                                    <label for="floatingInput">Quantite</label>
                                </div>
                            </div>
                        </div>
                    </div>`;
        id++;
    }
</script>