<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.transaction.achat.Achat" %>
<%@ page import="mg.itu.bakerking.entity.produit.Recommandation" %><%
    List<Recommandation> recommandations=(List<Recommandation>)request.getAttribute("recommandations");
%>
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