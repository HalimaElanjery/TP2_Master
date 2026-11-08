# Utilisation de l'IA dans le TP 2

Auteur : Halima Elanjery, groupe G2, n° 10

J'ai utilisé un assistant IA (Claude, d'Anthropic) comme aide pendant ce TP.
Cette page décrit honnêtement ce que j'ai fait moi-même et ce pour quoi
l'IA m'a aidée.

## Ce que j'ai fait moi-même

- Création du projet Maven et du dépôt GitHub.
- Écriture et exécution des classes de test (Test1 à Test7, TestMeteo).
- Lecture et compréhension du code fourni dans l'énoncé (RAG, MeteoTool).
- Lancement de chaque test, observation des résultats et copie des réponses
  du LLM dans le mail.
- Gestion de Git (commits par test, push vers GitHub).

## Aide de l'IA

### Compréhension de l'énoncé et du cours
- Explication de notions : tokens, embeddings, similarité cosinus, RAG,
  outils (@Tool), logging des requêtes.
- Aide pour comprendre l'enchaînement des échanges avec le LLM quand deux
  outils sont utilisés.

### Correction et débogage du code
- Aide pour comprendre des erreurs de compilation ou d'exécution et
  proposer des corrections, par exemple :
    - l'erreur de délai (timeout) du modèle d'embeddings Google ;
    - le conflit de dépendances entre le modèle d'embeddings BGE et easy-rag
      dans pom.xml ;
    - les avertissements de logging SLF4J / Log4j.
- Relecture de mon code (Test7Outils, MeteoTool) pour vérifier la cohérence
  avec l'énoncé (seuilPluie, annotations @Tool et @P, logging).
- Suggestion d'améliorations, par exemple l'encodage de l'URL dans
  getCoordonnees pour les noms de villes avec espaces.
- Dans tous les cas, j'ai relu les corrections, je les ai testées en
  exécutant le programme, et je les ai adaptées moi-même avant de les
  garder.

### Git et environnement
- Aide pour les commandes Git et PowerShell : .gitignore (.idea/, target/),
  suppression d'un fichier parasite, vérification qu'aucune clé API n'a été
  commitée.

### Rédaction du mail
- Aide pour organiser le mail et vérifier que tout ce que l'énoncé demande
  y figure, et pour relire les calculs (coût en tokens, total des tokens).
- Les résultats (réponses du LLM, similarités, tokens) viennent de mes
  propres exécutions.

## Ce que l'IA n'a pas fait

- L'IA n'a pas lancé mes programmes à ma place : les résultats viennent de
  mes exécutions.
- La clé Gemini n'est pas dans le dépôt : elle est lue avec System.getenv.

## Limites et vérification

Je ne considère pas les réponses de l'IA comme exactes par défaut : j'ai
vérifié les calculs et testé le code moi-même.