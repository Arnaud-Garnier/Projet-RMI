# Compiler MyRMIRegistry
cd MyRMIRegistry
ant

# Compiler classserver
cd ../classserver/classserver
javac *.java

# Compiler Serveur appli RMI
cd ../../Serveur-Miniprojet
ant -lib ../activemq-all-5.13.2.jar

# Compiler Client appli RMI
cd ../Client-Miniprojet
ant -lib ../activemq-all-5.13.2.jar

# Se replacer à la racine du projet
cd ..