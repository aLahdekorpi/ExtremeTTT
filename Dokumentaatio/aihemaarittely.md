###Aihe
Ristinollapeli. Kaksinpelissä pelaaja vastaan pelaaja. Yksinpelissä pelaaja vastaan tekoäly.

###Käyttäjät
- Pelaaja(t) 

###Toiminnot
- yksinpeli
- kaksinpeli

###Määrittelytason Luokkakaavio
![Kaavio](/Dokumentaatio/Luokkakaavio.png)

###Rakennekuvaus
Main luokan käynnistyessä se luo uuden start olion, joka luo StartFramen, josta peli käynnistetään.
StartFramen auetessa luokka luo itselleen kaksi JButtonia(ja lisää niihin ButtonListenerit), joista voi valita joko Single Player, tai Two Players.
Riippuen kumman näistä valitsee, StartFrame kutsuu sitten Startin metodia startGame ja aloittaa joko yksin tai kaksinpelin.
Molempiin peleihin liittyvät luokat:
#####WinChecker
Apuluokka pelin voiton tarkistamiseen
#####Frame
Ikkuna pelille
#####Cell
Luokka, joilla Frame täytetään. Ruutu pelilaudalla.
#####MyMouseListener tai SinglePlayerMouseListener
Luokat, jotka määrittelevä, mitä tehdään kun painat hiirtä pelin aikana.

###Sekvenssikaavio Kaksinpeli
![Sek](/Dokumentaatio/TwoPlayerGameSequence.png)

###Sekvenssikaavio Yksinpeli
![Sek](/Dokumentaatio/SPGameSequence.png)
