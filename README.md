# Projet-RMI
Membres du binôme :
<ul><li>Arnaud Garnier</li>
<li>Lisa Joanno</li></ul>

Pour compiler les projets par ligne de commande :<br />
```$ ant```

#### Exemple d'utilisation de l'application :
<br />
<img alt="figure1" src="images/figure1.png" />

#### Les étapes pour exécuter le projet :

###### 1 - Lancer le serveur http
Dans le dossier <i>classserver</i> :<br />
```$ java classserver.ClassFileServer portServeurHTTP "../Serveur-Miniprojet/bin/object/"```

###### 2 - Lancer le RMIRegistry
Dans le dossier <i>MyRMIRegistry</i> :<br />
```$ rmiregistry portRMIRegistry -J-Djava.rmi.server.useCodebaseOnly=false```

###### 3 - Lancer notre version du RMIRegistry
Toujours dans <i>MyRMIRegistry</i> :<br />
```$ java main.Main -Djava.rmi.server.codebase="URL serveur HTTP"```

###### 4 - Lancer le serveur RMI de l'application
Dans le dossier <i>Serveur-Miniprojet</i> :<br />
```$ java main.Main -Djava.security.policy="../policy.txt"```
