<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.transaction.vente.Vente" %>
<%@ page import="mg.itu.bakerking.entity.personne.Client" %><%
  List<Vente> ventes=(List<Vente>)request.getAttribute("ventes");

%>
<div class="row">
  <div class="col-md-2">

  </div>
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