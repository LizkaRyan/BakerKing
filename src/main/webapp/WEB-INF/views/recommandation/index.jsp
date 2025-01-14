<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.transaction.achat.Achat" %>
<%@ page import="mg.itu.bakerking.entity.produit.Recommandation" %><%
    List<Recommandation> recommandations=(List<Recommandation>)request.getAttribute("recommandations");
    int mois=(int)request.getAttribute("mois");
    int annee = (int)request.getAttribute("annee");
%>
<div class="row mb-3">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Recherche production</h4>
                <form action="/recommandations" method="get">
                    <div class="row mb-3">
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
                                <input type="number" value="<%=annee%>" name="annee" class="form-control" id="floatingInput" placeholder="Annee">
                                <label for="floatingInput">Annee</label>
                            </div>
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
                <h4 class="card-title">Liste des Recommandations</h4>
                <table class="table table-hoverable">
                    <thead>
                    <tr>
                        <th>Produit</th>
                        <th>Prix unitaire</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (Recommandation recommandation:recommandations) {
                    %>
                    <tr>
                        <td><%= recommandation.getProduit().getProduit() %></td>
                        <td><%= recommandation.getProduit().getPrixUnitaire() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>