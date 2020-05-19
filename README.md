# Getting Started

Aby rozpocząć działanie aplikacji bez korzystania z Tomcata lub instalacji IDE, w tym katalogu należy skorzystać z komendy:

./mvnw clean package (Linux)

mvnw.cmd clean package (Windows - chyba powinno działać)

następnie należy wejść do katalogu target i wpisać komendę:

java -jar clothes-shop-1.0.0.jar

Konfiguracja:

Serwer postgreSQL

login: postgres

hasło: qwerty11

baza danych: clothes_shop

Baza danych powinna być pusta. Uruchomienie aplikacji wstawi wszystkie tabele oraz dane

Port: 8080

Rest z dokumentacją restów:
localhost:8080/api/swagger


