# gps-socket-integration-app
Ce projet consiste à simuler l'envoi de paquets via un réseau TCP en utilisant des sockets, dans un environnement Java. Il modélise un paquet de données envoyé par une carte IoT et propose des mécanismes pour générer, envoyer et lire ces paquets dans une architecture client-serveur.
Tâches à accomplir :

    Création d'une classe Packet :
        Modéliser un paquet de données envoyé par une carte IoT. Ce paquet doit contenir les informations suivantes :
            Une valeur de température mesurée par un capteur.
            Les coordonnées GPS mesurées par un capteur.
            Un identifiant unique de la carte (entier 64 bits).
            Un time frame (entier incrémental de 64 bits représentant un horodatage ou un incrément de temps).
            Un checksum pour valider l'intégrité du paquet.

    Création de deux classes Java (PacketGenerator et CardReader) :
        PacketGenerator : Génère aléatoirement des paquets de données en saisissant un identifiant unique de carte.
        CardReader : Lit et désérialise les paquets reçus, en interprétant les données brutes envoyées sous forme d'octets.

    Création d'une classe Server :
        Développer un serveur TCP capable de recevoir des paquets provenant de plusieurs cartes simultanément. Le serveur écoute sur un port donné, reçoit les paquets de chaque carte, et traite ces informations.

    Création d'une classe Client :
        Développer un client TCP qui envoie des paquets générés au serveur. Ce client peut également filtrer et afficher les paquets reçus du serveur en fonction de certains critères.

Technologies :

    Java pour la programmation de l'application.
    Sockets TCP pour la communication réseau entre le client et le serveur.
    Modélisation orientée objet pour structurer les différentes entités (paquets, cartes, etc.).
