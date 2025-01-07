<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="/produit/form">
                <i class="icon-grid menu-icon"></i>
                <span class="menu-title">Production</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/produit?idCategorie=CAT001&idIngredient=ING001">
                <i class="icon-grid menu-icon"></i>
                <span class="menu-title">Liste production</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                <i class="icon-layout menu-icon"></i>
                <span class="menu-title">Achat</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="/achat">Liste des achats</a></li>
                    <li class="nav-item"> <a class="nav-link" href="/achat/form">Insertion achat</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#form-elements" aria-expanded="false" aria-controls="form-elements">
                <i class="icon-columns menu-icon"></i>
                <span class="menu-title">Vente</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="form-elements">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"><a class="nav-link" href="/vente">Liste des ventes</a></li>
                    <li class="nav-item"><a class="nav-link" href="/vente/form">Insertion vente</a></li>
                </ul>
            </div>
        </li>
    </ul>
</nav>