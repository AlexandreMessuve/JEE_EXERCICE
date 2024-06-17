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
Formulaire d'inscription
![Formulaire d'inscription](img/screenshotRegister.png 'register')
Formulaire de connexion
![Formulaire de connexion](img/screenshotLogin.png 'login')
Formulaire d'ajout de produit
![Formulaire d'ajout de produit](img/screenshotAddProduct.png 'add a product')
Liste des produits
![Liste des produits](img/screenshotProductList.png 'product list')
Formulaire de mise à jour d'un produit
![Formulaire de mise a jour d'un produit](img/screenshotUpdateProduct.png 'update product')
Detail d'un produit
![Detail d'un produit](img/screenshotDetailProduct.png 'product detail')
Message d'alerte en cas de suppression d'un produit
![Suppression produit](img/screenshotProductDeleteAlert.png 'confirm delete')
Profile utilisateur
![Profile utilisateur](img/screenshotUserProfile.png 'user profile')
Mise à jour d'un utilisateur
![Mise à jour d'un utilisateur](img/screenshotUserUpdate.png 'register')
Message d'alerte en cas de suppression d'un produit
![Message d'alerte en cas de suppression d'un produit](img/screenshotUserDeleteAlert.png 'register')