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

#### Les étapes pour exécuter le projet :

###### 1 - Lancer le RMIRegistry
Lancer dans n'importe quel dossier le RMI registry :<br />
```$ rmiregistry -J-Djava.rmi.server.useCodebaseOnly=false 1098```

###### 2 - Lancer le serveur HTTP
Dans le dossier <i>classserver</i> :<br />
```$ java classserver.ClassFileServer 4000 ../Serveur-Miniprojet/bin/```

###### 3 - Lancer le RMI registry personnalisé
Dans le dossier <i>MyRMIRegistry</i> :<br />
```$ java -Djava.rmi.server.codebase="http://localhost:4000/" main.Main ```

###### 4 - Lancer le serveur de l'application
Importer le projet <i>Serveur-Miniprojet</i>.<br />
Sous Eclipse, ajouter la librairie activemq-all-5.13.2.jar (présente à la racine du projet), ajouter dans Run configuration -> Arguments -> VM arguments ```-Djava.rmi.server.codebase="http://localhost:4000/" main.Main ```.

###### 5 - Lancer le client de l'application
Importer le projet <i>Client-Miniprojet</i>.<br />
Sous Eclipse, ajouter la librairie activemq-all-5.13.2.jar (présente à la racine du projet), ajouter dans Run configuration -> Arguments -> VM arguments ``` -Djava.security.policy="policy.txt"```.
