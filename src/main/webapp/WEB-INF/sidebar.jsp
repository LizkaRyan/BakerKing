<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="/dashboard">
                <i class="icon-grid menu-icon"></i>
                <span class="menu-title">Dashboard</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#production" aria-expanded="false" aria-controls="ui-basic">
                <i class="icon-layout menu-icon"></i>
                <span class="menu-title">Production</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="production">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="/production">Liste production</a></li>
                    <li class="nav-item"> <a class="nav-link" href="/production/form_production">Insertion production</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#achat" aria-expanded="false" aria-controls="ui-basic">
                <i class="icon-layout menu-icon"></i>
                <span class="menu-title">Achat</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="achat">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="/achat/form_achat">Insertion achat</a></li>
                    <li class="nav-item"> <a class="nav-link" href="/achat">Liste des achats</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#vente" aria-expanded="false" aria-controls="form-elements">
                <i class="icon-columns menu-icon"></i>
                <span class="menu-title">Vente</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="vente">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"><a class="nav-link" href="/vente/form_vente">Insertion vente</a></li>
                    <li class="nav-item"><a class="nav-link" href="/vente">Liste des ventes</a></li>
                    <li class="nav-item"><a class="nav-link" href="/vente/filter?idTypeProduit=Tous&idCategorie=Tous">Liste vente avec filtre</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#recommandation" aria-expanded="false" aria-controls="ui-basic">
                <i class="icon-layout menu-icon"></i>
                <span class="menu-title">Recommandation</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="recommandation">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="/recommandations">Liste des recommandations</a></li>
                    <li class="nav-item"> <a class="nav-link" href="/recommandations/form-recommandation">Insertion recommandation</a></li>
                </ul>
            </div>
        </li>
    </ul>
</nav>