<%@ page import="mg.itu.bakerking.entity.produit.Ingredient" %>
<%@ page import="java.util.List" %><%
    List<Ingredient> ingredients=(List<Ingredient>)request.getAttribute("ingredients");
%>
<div class="row">
    <div class="col-md-2">

    </div>
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Insertion achats</h4>
                <form action="/vente" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input type="date" name="dateTransaction" class="form-control" id="floatingInput" placeholder="Date achat">
                                <label for="floatingInput">Date achat</label>
                            </div>
                        </div>
                    </div>
                    <div id="achatDetails">
                        <div class="row">
                            <div class="col-md-6">
                                <select name="ingredients[0].idIngredient" class="form-select" aria-label="Default select example">
                                    <option selected>Ingredients</option>
                                    <% for (Ingredient ingredient:ingredients) { %>
                                    <option value="<%= ingredient.getIdIngredient() %>"><%= ingredient.getIngredient() %></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <input type="number" name="ingredients[0].quantite" class="form-control" id="floatingInput" placeholder="Quantite">
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
                                <select name="ingredients[`+id+`].idIngredient" class="form-select" aria-label="Default select example">
                                    <option selected>Open this select menu</option>
                                    <% for (Ingredient ingredient:ingredients) { %>
                                    <option value="<%= ingredient.getIdIngredient() %>"><%= ingredient.getIngredient() %></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <input type="number" name="ingredients[`+id+`].quantite" class="form-control" id="floatingInput" placeholder="Quantite">
                                    <label for="floatingInput">Quantite</label>
                                </div>
                            </div>
                        </div>`;
        id++;
    }
</script>