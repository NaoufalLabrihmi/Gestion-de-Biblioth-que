# Projet de Gestion de Bibliothèque Municipale

## Contexte du Projet

Une bibliothèque municipale souhaite automatiser ses tâches quotidiennes à travers un système de gestion informatisé. Ce projet consiste à développer une application console en Java 8 permettant de gérer efficacement l'inventaire des livres et des magazines, ainsi que les emprunts et les retours.

## Responsabilités

Votre mission dans ce projet est de :

- Concevoir une architecture en couches (présentation, métier, utilitaire).
- Implémenter les classes principales et leurs fonctionnalités.
- Utiliser les concepts de base de Java, notamment l'héritage.
- Gérer le projet avec Git et JIRA.

## Structure de l'Application

### Couche de Présentation

- **Classe `ConsoleUI`** : Gère l'interface utilisateur via une application console.

### Couche Métier

- **Classe Abstraite `Document`** : Représente un document générique avec des attributs communs.
- **Classe `Livre`** : Hérite de `Document` et ajoute un attribut spécifique pour l'ISBN.
- **Classe `Magazine`** : Hérite de `Document` et ajoute un attribut spécifique pour le numéro du magazine.
- **Classe `Bibliotheque`** : Gère l'inventaire des documents (ajout, emprunt, retour, recherche).

### Couche Utilitaire

- **Classe `DateUtils`** : Gère les opérations de manipulation des dates.

## Contenu des Classes

### Classe Abstraite `Document`

- **Attributs** : `id`, `titre`, `auteur`, `datePublication`, `nombreDePages`.
- **Méthodes Abstraites** : `emprunter()`, `retourner()`, `afficherDetails()`.

### Classe `Livre`

- **Attribut Supplémentaire** : `isbn`.
- **Implémentation des Méthodes Abstraites**.

### Classe `Magazine`

- **Attribut Supplémentaire** : `numero`.
- **Implémentation des Méthodes Abstraites**.

## Fonctionnalités Principales

- **Ajouter un document** (livre ou magazine).
- **Emprunter un document**.
- **Retourner un document**.
- **Afficher tous les documents**.
- **Rechercher un document**.

## Spécifications Techniques

- Utiliser `ArrayList` pour stocker les documents.
- Implémenter une recherche rapide avec `HashMap<String, Document>`.
- Intégrer l'API Java Time pour la gestion des dates.
- Appliquer les expressions lambda pour la manipulation des collections.

## Interface Utilisateur

L'application propose un menu interactif dans la console avec les options suivantes :

1. Ajouter un document.
2. Emprunter un document.
3. Retourner un document.
4. Afficher tous les documents.
5. Rechercher un document.
6. Quitter.

## Contraintes

- Les données persistent en mémoire jusqu'à la fermeture de l'application.
- Implémenter une validation des entrées utilisateur pour gérer les erreurs possibles.

## Prérequis

Avant d'exécuter l'application, assurez-vous que les éléments suivants sont installés sur votre machine :

- **Java Development Kit (JDK) 8** : L'application est développée avec Java 8. Vous pouvez télécharger et installer le JDK depuis le site officiel d'[Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) ou utiliser une distribution alternative comme [OpenJDK](https://openjdk.java.net/).

- **Variable d'environnement `JAVA_HOME`** : Assurez-vous que la variable d'environnement `JAVA_HOME` pointe vers le répertoire d'installation du JDK.

- **Mise à jour du `PATH`** : Ajoutez le répertoire `bin` du JDK à votre variable d'environnement `PATH` pour pouvoir exécuter les commandes Java à partir du terminal.

## Commande pour Exécuter l'Application

Pour exécuter l'application via le fichier JAR, utilisez la commande suivante dans le terminal :

```bash
java -jar Labrihmi_Naoufal_S1_B1_gestionBiblio.jar
