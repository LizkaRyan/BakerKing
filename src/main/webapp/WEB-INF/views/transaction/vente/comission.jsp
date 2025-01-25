<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mg.itu.bakerking.dto.transaction.ComissionResponse" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="mg.itu.bakerking.dto.transaction.CommissionGenre" %>
<%
    List<ComissionResponse> comissions = (List<ComissionResponse>) request.getAttribute("comissions");
    LocalDate dateMin = (LocalDate) request.getAttribute("dateMin");
    LocalDate dateMax = (LocalDate) request.getAttribute("dateMax");
    String chartCommissionGenre = (String) request.getAttribute("chart");

    List<CommissionGenre> comissionGenreResponses = (List<CommissionGenre>) request.getAttribute("comissionGenre");
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
<div class="row">
    <div class="col-md-6">
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
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Commission par genre</h4>
                <canvas id="lineChart"></canvas>
            </div>
        </div>
    </div>
</div>
<script src="/public/vendors/js/vendor.bundle.base.js"></script>
<script src="/public/vendors/chart.js/Chart.min.js"></script>
<script>
    $(function() {
        /* ChartJS
         * -------
         * Data and config for chartjs
         */
        'use strict';
        var data = <%= chartCommissionGenre %>
        console.log(data);
        var options = {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            },
            legend: {
                display: false
            },
            elements: {
                point: {
                    radius: 0
                }
            },
            onClick: (event, elements) => {
                if (elements.length > 0) {
                    // Obtenir l'index de l'élément cliqué
                    const index = elements[0].index;

                    const label = elements[0]._model.label;

                    // Rediriger vers une URL (adaptée au contexte)
                    const url = `http://localhost:8080/vente/comission/details/genre?genre=`+label+`&dateMin=2024-12-31&dateMax=2025-01-25`;
                    window.location.href = url;
                }
            }
        };
        // Get context with jQuery - using jQuery's .get() method.
        if ($("#lineChart").length) {
            var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
            var lineChart = new Chart(lineChartCanvas, {
                type: 'bar',
                data: data,
                options: options
            });
        }
    });
</script>