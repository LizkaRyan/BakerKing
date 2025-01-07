<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.transaction.achat.AchatDetails" %><%
    List<AchatDetails> details=(List<AchatDetails>)request.getAttribute("details");
%>
<div class="row">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Liste des ventes</h4>
                <table class="table table-hoverable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Montant</th>
                        <th>Quantite</th>
                        <th>Produit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (AchatDetails detail:details) {
                    %>
                    <tr>
                        <td><%= detail.getIdDetails() %></td>
                        <td><%= detail.getMontant() %></td>
                        <td><%= detail.getQuantite() %></td>
                        <td><%= detail.getIngredient().getIngredient() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>