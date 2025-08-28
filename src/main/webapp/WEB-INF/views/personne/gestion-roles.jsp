<%@ page import="mg.itu.bakerking.entity.personne.Vendeur" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.entity.personne.Role" %><%
    List<Vendeur> vendeurs = (List<Vendeur>) request.getAttribute("vendeurs");
    Role[] roles = (Role[]) request.getAttribute("roles");
%>
<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Gestion des rôles des collaborateurs</h4>
                <p class="card-description">
                    Modifier les rôles des vendeurs/collaborateurs du système
                </p>
                <div class="table-responsive">
                    <table class="table table-hoverable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Genre</th>
                            <th>Rôle actuel</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% for (Vendeur vendeur : vendeurs) { %>
                        <tr>
                            <td><%= vendeur.getIdVendeur() %></td>
                            <td><%= vendeur.getNom() %></td>
                            <td><%= vendeur.getGenre() != null ? vendeur.getGenre().getGenre() : "Non défini" %></td>
                            <td>
                                <span class="badge <%= vendeur.getRole() == Role.ADMIN ? "badge-danger" : "badge-primary" %>">
                                    <%= vendeur.getRole().getDisplayName() %>
                                </span>
                            </td>
                            <td>
                                <form action="/vendeur/update-role" method="post" style="display: inline;">
                                    <input type="hidden" name="vendeurId" value="<%= vendeur.getIdVendeur() %>">
                                    <select name="role" class="form-select form-select-sm d-inline" style="width: auto; display: inline;">
                                        <% for (Role role : roles) { %>
                                        <option value="<%= role.name() %>" <%= vendeur.getRole() == role ? "selected" : "" %>>
                                            <%= role.getDisplayName() %>
                                        </option>
                                        <% } %>
                                    </select>
                                    <button type="submit" class="btn btn-outline-primary btn-sm">Modifier</button>
                                </form>
                            </td>
                        </tr>
                        <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>