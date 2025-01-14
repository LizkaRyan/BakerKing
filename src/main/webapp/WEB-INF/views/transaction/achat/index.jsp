<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.transaction.achat.Achat" %><%
  List<Achat> achats=(List<Achat>)request.getAttribute("achats");
%>
<div class="row">
  <div class="col-md-6">
    <div class="card">
      <div class="card-body">
        <h4 class="card-title">Liste des achats</h4>
        <table class="table table-hoverable">
          <thead>
          <tr>
            <th>#</th>
            <th>Montant</th>
            <th>Date transaction</th>
            <th>Détails</th>
          </tr>
          </thead>
          <tbody>
          <%
            for (Achat achat:achats) {
          %>
          <tr>
            <td><%= achat.getIdTransaction() %></td>
            <td><%= achat.getMontant() %></td>
            <td><%= achat.getDateTransaction() %></td>
            <td><a href="/achat/details/<%= achat.getIdTransaction() %>">Voir détails</a></td>
          </tr>
          <% } %>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>