### Liste vente viennoiserie nature

Création table type_produit
    -   id_type_produit
    -   type_produit

Ajout de id_type_produit dans la table produit

Création Entité TypeProduit
    -   idTypeProduit
    -   typeProduit

Modification Entité Produit
    -   TypeProduit @ManyToOne

Creation TypeProduitRepository

VenteService
    -   List<VenteDetails> findVenteDetailsByCategorie(String idTypeProduit, String idCategorie)

VenteController
    -   ModelAndView filter(String idTypeProduit,String idCategorie)
            -   url:"/vente/filter"
            -   dispatch: "transaction/vente/listFilter"

listFilter.jsp
    -   Formulaire
        -   select: categorie
        -   select: type_produit
    -   Liste vente
        -   Tableau

### Insertion vente

form.jsp
    -   Formulaire vente
        -   input type date: dateTransaction
        -   Un ou plusieurs select: produit
        -   Un ou plusieurs input type number: quantite

Creation classe ProduitDTO
    -   idProduit
    -   quantite

Creation classe VenteDTO
    -   dateTransaction
    -   produitDTOList

VenteService
    -   Vente save(VenteDTO venteDTO)

VenteController
    -   String save(VenteDTO venteDTO)