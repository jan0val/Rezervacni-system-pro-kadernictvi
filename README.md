# Rezervační systém pro kadeřnictví

Tento projekt je backendová aplikace s ukázkovým frontendem navržená pro správu a evidenci kadeřnického salonu. Systém umožňuje správu zákazníků, personálu (kadeřníků), ceníku služeb a následnou tvorbu rezervací.

## Použité technologie
* **Backend:** Java, Spring Boot, Spring Data JPA (Hibernate), Maven
* **Databáze:** MySQL (lokálně přes XAMPP / DataGrip)
* **Frontend:** Čisté HTML, CSS a Vanilla JavaScript (Fetch API)

## Co už funguje (Aktuální stav)
Aplikace má momentálně plně funkční základní CRUD operace propojené od databáze až po uživatelské rozhraní v prohlížeči.

* **Zákazníci (`Zakaznik`):** Přidávání a výpis zákazníků (Jméno, Telefon, E-mail) přes `UserController`.
* **Kadeřníci (`Kadernik`):** Přidávání a výpis zaměstnanců (Jméno, Příjmení) přes `KadernikController`.
* **Služby (`Sluzba`):** Tvorba ceníku a druhů střihů (Název služby, Cena v Kč) přes `SluzbaController`.
* **Propojení (CORS):** Backend je připraven na komunikaci s frontendem díky nastavení `@CrossOrigin` v controllerech.

## Architektura projektu
Kód je strukturován do standardních vrstev:
* `entities/` - Definice databázových tabulek (modely).
* `repositories/` - Rozhraní pro komunikaci s MySQL databází.
* `controllers/` - REST API endpointy přijímající požadavky z frontendu (běží na `localhost:8080`).
* `src/main/resources/static/` - Zde se nachází HTML a JS soubory tvořící uživatelské rozhraní.

## Jak aplikaci spustit
1. Zapni MySQL databázi (např. v XAMPP Control Panelu).
2. Otevři projekt v IntelliJ IDEA.
3. Zkontroluj nastavení připojení k databázi v souboru `application.properties` (jméno databáze, port, uživatel root).
4. Spusť hlavní třídu Spring Boot aplikace.
5. Otevři webový prohlížeč a přejdi na adresu `http://localhost:8080/index.html` (nebo jiný HTML soubor ze složky static).

## Co nás čeká (TODO)
* **Rezervace:** Vytvoření `RezervaceController` a `RezervaceService`, které propojí Zákazníka, Kadeřníka a Službu do jednoho konkrétního termínu v čase.
* Frontendový formulář s rozbalovacími seznamy (Select) pro výběr osob a služeb z databáze při tvorbě rezervace.
