<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.transaction.achat.Achat" %>
<%@ page import="mg.itu.bakerking.entity.produit.Production" %>
<%
    List<Production> productions=(List<Production>)request.getAttribute("production");
%>
<div class="row">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Liste des productions</h4>
                <table class="table table-hoverable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Quantite</th>
                        <th>Date</th>
                        <th>Produit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (Production production: productions) {
                    %>
                    <tr>
                        <td><%= production.getQuantite() %></td>
                        <td><%= production.getDateProduit() %></td>
                        <td><%= production.getProduit().getProduit() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>