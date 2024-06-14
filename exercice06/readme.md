# Exercice 6

## Sujet d'Exercice : Gestion de Produits avec WebServlets et Utilisateur

### Objectif
Créer une application web en Java EE permettant de gérer la création et l'affichage de produits. L'application doit accessible par une gestion des utilisateurs.Les produits et les utilisteurs seront stockées en BDD à l'aide d'hibernate.

## Description du Projet
Vous devez développer une application web qui permet les fonctionnalités suivantes :

Création de produits : Un utilisateur authentifié peut ajouter un nouveau produit.
Affichage des produits : Tout utilisateur connecté peut voir la liste des produits disponibles.
Gestion des utilisateurs : Un système de connexion et de déconnexion permettant d'acceder à l'application.

Un utilisateur sera défini par (au moins) :
- un email
- un nom
- un password (en clair dans la bdd pour l'instant)

Un produit sera défini par (au moins) :
- une marque
- une reference
- une date d'achat
- un prix
- un stock


## Résultat
Formulaire de connexion
![](screenshotLogin.png 'login')
Formulaire d'ajout de produit
![Formulaire d'ajout de produit](screenshotAddProduct.png 'add a product')
Liste des produits
![Liste des produits](screenshotProductList.png 'product list')
Formulaire de mise à jour d'un produit
![Formulaire de mise a jour d'un produit](screenshotUpdateProduct.png 'update product')
Detail d'un produit
![Detail d'un produit](screenshotDetailProduct.png 'product detail')
Message d'alert en cas de suppression d'un produit
![Suppression produit](screenshotConfirmDelete.png 'confirm delete')
