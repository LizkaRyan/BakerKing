<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.transaction.vente.Vente" %>
<%@ page import="mg.itu.bakerking.entity.transaction.vente.Client" %><%
    List<Vente> ventes=(List<Vente>)request.getAttribute("ventes");
    List<Client> clients = (List<Client>) request.getAttribute("clients");
%>
<div class="row mb-3">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Recherche vente</h4>
                <form action="/vente" method="get">
                    <div class="row mb-3">
                        <div class="col-md-5">
                            <select name="idClient" class="form-select" aria-label="Default select example">
                                <option value="Tous">Tous</option>
                                <% for (int i = 0; i< clients.size(); i++) { %>
                                <option value="<%= clients.get(i).getIdClient() %>" <% if(((String)request.getAttribute("client")).equals(clients.get(i).getIdClient())) {%> selected <% } %>> <%= clients.get(i).getNom() %></option>
                                <% } %>
                            </select>
                        </div>
                        <div class="col-md-1">

                        </div>
                        <div class="col-md-5">
                            <div class="form-floating mb-3">
                                <input type="date" value="<%= request.getAttribute("date") %>" name="date" class="form-control" id="floatingInput" placeholder="Date">
                                <label for="floatingInput">Date</label>
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
    <div class="col-md-8">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Liste des ventes</h4>
                <table class="table table-hoverable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Montant</th>
                        <th>Date transaction</th>
                        <th>Client</th>
                        <th>Détails</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (Vente vente:ventes) {
                    %>
                    <tr>
                        <td><%= vente.getIdTransaction() %></td>
                        <td><%= vente.getMontant() %></td>
                        <td><%= vente.getDateTransaction() %></td>
                        <td><%= vente.getClient().getNom() %></td>
                        <td><a href="/vente/details/<%= vente.getIdTransaction() %>">Voir détails</a></td>

                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>