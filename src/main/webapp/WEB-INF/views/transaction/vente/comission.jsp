<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.transaction.vente.VenteDetails" %>
<%@ page import="mg.itu.bakerking.entity.produit.Categorie" %>
<%@ page import="mg.itu.bakerking.entity.produit.TypeProduit" %>
<%@ page import="mg.itu.bakerking.dto.transaction.ComissionResponse" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="mg.itu.bakerking.entity.transaction.vente.Commission" %>
<%@ page import="mg.itu.bakerking.dto.transaction.ComissionGenreResponse" %>
<%
    List<ComissionResponse> comissions = (List<ComissionResponse>) request.getAttribute("comissions");
    LocalDate dateMin = (LocalDate) request.getAttribute("dateMin");
    LocalDate dateMax = (LocalDate) request.getAttribute("dateMax");

    List<ComissionGenreResponse> comissionGenreResponses = (List<ComissionGenreResponse>) request.getAttribute("comissionGenre");
%>

<div class="row mb-3">
    <div class="col-md-2" style="margin-left: 7%">

    </div>
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Filtre comission</h4>
                <form action="/vente/comission" method="get">
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input type="date" name="dateMin" class="form-control" required value="<%= dateMin %>" id="floatingInput" placeholder="Date Min">
                                <label for="floatingInput">Date Minimum</label>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="form-floating mb-3">
                                <input type="date" name="dateMax" class="form-control" required value="<%= dateMax %>" id="floatingInput" placeholder="Date Max">
                                <label for="floatingInput">Date Maximum</label>
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

<div class="row mb-3">
    <div class="col-md-2" style="margin-left: 3%">

    </div>
    <div class="col-md-7">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Liste des comissions</h4>
                <table class="table table-hoverable">
                    <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Comission</th>
                        <th>Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (ComissionResponse c:comissions) {
                    %>
                    <tr>
                        <td><%= c.getNom() %></td>
                        <td><%= c.getMontant() %></td>
                        <td><a href="/vente/comission/details?idVendeur=<%= c.getIdVendeur()%>&dateMin=<%= dateMin %>&dateMax=<%= dateMax%>">Voir details</a> </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
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
                <h4 class="card-title">Liste des comissions Par Genre</h4>
                <table class="table table-hoverable">
                    <thead>
                    <tr>
                        <th>Genre</th>
                        <th>Comission</th>
                        <th>Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (ComissionGenreResponse c:comissionGenreResponses) {
                    %>
                    <tr>
                        <td><%= c.getGenre() %></td>
                        <td><%= c.getMontant() %></td>
                        <td><a href="/vente/comission/details/genre?idGenre=<%= c.getIdGenre()%>&dateMin=<%= dateMin %>&dateMax=<%= dateMax%>">Voir details</a> </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>