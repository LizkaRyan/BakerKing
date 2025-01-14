<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="mg.itu.bakerking.dto.Chart" %>
<%@ page import="mg.itu.bakerking.dto.transaction.ChiffreAffaireProduit" %>
<%@ page import="java.util.List" %><%
    Double chiffreAffaire=(Double)request.getAttribute("chiffreAffaire");
    LocalDate dateMin=(LocalDate)request.getAttribute("dateMin");
    LocalDate dateMax=(LocalDate)request.getAttribute("dateMax");
    Chart chart=(Chart)request.getAttribute("chiffreAffaireProductsChart");
    List<ChiffreAffaireProduit> chiffreAffaireProduits = (List<ChiffreAffaireProduit>)request.getAttribute("chiffreAffaireProducts");
%>
<div class="row mb-3">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Chiffre affaire</h4>
                <form action="/dashboard" method="get">
                    <div class="row mb-3">
                        <div class="col-md-5">
                            <div class="form-floating mb-3">
                                <input type="date" name="dateMin" class="form-control" id="floatingInput" placeholder="Date minimum">
                                <label for="floatingInput">Date minimum</label>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="form-floating mb-3">
                                <input type="date" name="dateMax" class="form-control" id="floatingInput" placeholder="Date maximum">
                                <label for="floatingInput">Date maximum</label>
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
    <div class="cold-md-1">

    </div>
    <div class="col-md-11">
        <div class="card">
            <div class="row">
                <div class="col-md-3">
                    <div class="card-body">
                        <p class="card-title">Chiffre d'affaire</p>
                        <h1 class="text-primary"><%= chiffreAffaire %> AR</h1>
                        <p class="mb-2 mb-xl-0">Le chiffre d'affaire obtenu durant <%= dateMin.toString() %> jusqu'à <%= dateMax.toString() %></p>
                    </div>
                </div>
                <div class="col-md-1">

                </div>
                <div class="col-md-7">
                    <div class="card-body">
                        <h4 class="card-title">Chiffre d'affaire par produit</h4>
                        <table class="table table-striped-columns">
                            <% for (ChiffreAffaireProduit chiffreAffaireProduit:chiffreAffaireProduits) {
                            %>
                            <tr>
                                <td><%= chiffreAffaireProduit.getProduit() %></td>
                                <td><%= chiffreAffaireProduit.getChiffreAffaire() %> Ar</td>
                            </tr>
                            <% } %>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-7">
        <div class="card-body">
            <h4 class="card-title">Chiffre d'affaire par produit</h4>
            <canvas id="lineChart"></canvas>
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
        var data = {
            labels: ["2013", "2014", "2014", "2015", "2016", "2017"],
            datasets: [{
                label: 'Chiffre affaire',
                data: <%= chart.getDatasets().get(0).getData() %>,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1,
                fill: false
            }]
        };
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