# Projet-RMI
Membres du binôme :
<ul><li>Arnaud Garnier</li>
<li>Lisa Joanno</li></ul>

Pour compiler les projets par ligne de commande :<br />
```$ ant```

#### Exemple d'utilisation de l'application :
<br />
<img alt="figure1" src="images/figure1.png" />
<br />

#### Les étapes pour exécuter le projet (pour le téléchargement dynamique de classes) :

###### 1 - Lancer le RMIRegistry
Lancer dans n'importe quel dossier le rmiregistry :<br />
```$ rmiregistry -J-Djava.rmi.server.useCodebaseOnly=false 1098```

###### 2 - Lancer le serveur HTTP
Dans le dossier <i>classserver</i> :<br />
```$ java classserver.ClassFileServer 4000 ../Serveur-Miniprojet/bin/```

###### 3 - Lancer le serveur de l'application RMI
Dans le dossier <i>Serveur-Miniprojet</i> :<br />
```$ java -Djava.rmi.server.codebase="http://localhost:4000/" main.Main ```
