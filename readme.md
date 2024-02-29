# Project-Charity
Projekt ten to aplikacja pozwalająca oddać niepotrzebne rzeczy, np. ubrania, na zweryfikowane fundacje charytatywne. Eleminuje problem weryfikacji, kompletowania i transportu. 
Użytkownik, po stworzeniu własnego konta, może stworzyć własną darowizne w której skład wchodzi:
- ilość liczona w workach
- rodzaj przedmotów
- organizacja do której darowizna ma trafić
- dane dla kuriera
Na koniec całość jest podsumowana w jednym miejscu dla weryfikacji poprawności danych.
Aplikacja posiada osobny widok dostępny tylko dla adminów. Posiadają oni dodatkowe uprawnienia np. edycje użytkowników, dodanie kolejnych adminów.

Technologie użyte w projekcie:
- Spring Boot
- Spring Data JPA
- Spring Web MVC
- Spring Security
- Hibernate
- MySQL
- Jsp/CSS
- NBP Web API
- JavaScript
- Maven

Konfiguracja:
- Przejdź do folderu src/main/resources
- Otwórz plik application.properties
- Zmień spring.datasource.username na swoją nazwę użytkownika MySQL
- Zmień spring.datasource.password na swoje hasło MySQL
