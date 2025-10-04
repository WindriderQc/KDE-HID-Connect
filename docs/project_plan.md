

🧠 Titre du projet
Extension de KDE Connect Android pour le support HID Bluetooth : Transformer un smartphone en clavier/souris universel

🎯 Objectif
Créer une application Android open source, basée sur KDE Connect, qui permet à un smartphone de se comporter comme un périphérique HID Bluetooth (clavier et souris) sans passer par le Wi-Fi ou un logiciel compagnon.

🧱 Structure du plan
1. 📚 Analyse préliminaire
1.1 Étude de KDE Connect
- Architecture modulaire (plugins)
- Gestion des événements clavier/souris via Wi-Fi
- Langage : Kotlin + Java
- Interface : XML + Material Design
1.2 Étude du Bluetooth HID sur Android
- API : BluetoothHidDevice (Android 9+)
- Limitations : nécessite permissions spéciales, non disponible sur tous les appareils
- Types de rapports HID : clavier (usage page 0x07), souris (usage page 0x01)

2. 🏗️ Architecture du projet
2.1 Modules KDE Connect à modifier
- MousePadPlugin.kt → pour les événements de souris
- RemoteKeyboardPlugin.kt → pour les événements clavier
2.2 Nouveau module à créer
- BluetoothHidPlugin.kt : plugin KDE Connect qui encapsule la logique HID
- BluetoothHidService.kt : service Android pour gérer la connexion HID
- HidReportBuilder.kt : utilitaire pour construire les rapports HID
2.3 Interface utilisateur
- Réutiliser l’écran MousePadActivity
- Ajouter un bouton "Activer Bluetooth HID"
- Afficher l’état de la connexion HID (connecté, appairé, en attente)

3. 🔌 Implémentation technique
3.1 Initialisation du profil HID
val sdpSettings = BluetoothHidDeviceAppSdpSettings(
    "KDE HID",
    "Keyboard and Mouse via KDE Connect",
    "KDE Connect",
    BluetoothHidDevice.SUBCLASS1_COMBO,
    byteArrayOf(/* descriptor HID */)
)


3.2 Gestion de la connexion
- Écouter les événements BluetoothProfile.ServiceListener
- Gérer l’appairage avec BluetoothAdapter.getDefaultAdapter().bondedDevices
- Implémenter BluetoothHidDevice.Callback pour suivre l’état
3.3 Envoi des rapports HID
- Clavier : sendReport(device, reportId, keyReport)
- Souris : sendReport(device, reportId, mouseReport)
- Utiliser MotionEvent et KeyEvent pour générer les rapports

4. 🧪 Tests et validation
4.1 Tests unitaires
- Vérifier la construction des rapports HID
- Simuler des événements clavier/souris
4.2 Tests sur appareils
- Windows 10/11
- macOS
- Steam Deck
- Android TV
4.3 Scénarios de test
- Connexion Bluetooth seule
- Envoi de texte via clavier
- Contrôle du curseur via touchpad
- Déconnexion et reconnexion automatique

5. 📦 Packaging et publication
5.1 Licence
- GPLv3 (comme KDE Connect)
5.2 Déploiement
- Fork sur GitHub
- Ajout dans F-Droid
- Documentation complète (README, Wiki, tutoriels)
5.3 Contributions
- Ouverture aux pull requests
- Création d’un canal Discord ou Matrix

🧭 Planification temporelle (exemple sur 8 semaines)
1-Analyse de KDE Connect et Bluetooth HID
2-Création du module BluetoothHidPlugin
3-Implémentation du service HID
4-Intégration des événements clavier/souris
5-Tests unitaires et sur appareils
6-Interface utilisateur et feedback
7-Documentation et packaging
8-Publication et présentation finale





🧠 Compétences mobilisées
- Programmation Android (Kotlin/Java)
- Protocoles HID et Bluetooth
- Architecture logicielle modulaire
- Tests et validation
- Documentation open source

