# Rezervační systém pro kadeřnictví

Tento projekt je backendová aplikace s ukázkovým frontendem navržená pro správu a evidenci kadeřnického salonu. Systém umožňuje kompletní správu zákazníků, personálu, ceníku služeb a následnou tvorbu propojených rezervací.

## Použité technologie
* **Backend:** Java, Spring Boot, Spring Data JPA (Hibernate), Maven
* **Databáze:** MySQL (lokálně přes XAMPP / DataGrip)
* **Frontend:** Čisté HTML, CSS a Vanilla JavaScript (Fetch API)

## Co už funguje (Aktuální stav)
Aplikace má plně funkční databázové operace s napojením na uživatelské rozhraní:

* **Zákazníci (`Zakaznik`):** Přidávání a výpis zákazníků (Jméno, Telefon, E-mail) přes `UserController`.
* **Kadeřníci (`Kadernik`):** Přidávání a výpis zaměstnanců přes `KadernikController`.
* **Služby (`Sluzba`):** Tvorba ceníku a druhů střihů přes `SluzbaController`.
* **Rezervace (`Rezervace`):** Srdce systému. Propojuje konkrétního zákazníka, kadeřníka a službu v čase. Využívá `RezervaceDTO` pro bezpečný přenos dat z frontendu a `RezervaceService` pro automatický výpočet konce rezervace podle délky zvolené služby.
* **Dynamický frontend:** Webové formuláře se při načtení automaticky dotazují backendu a plní rozbalovací seznamy (Selecty) aktuálními daty z databáze.

## Architektura projektu
Kód je strukturován do standardních vrstev (vícevrstvá architektura):
* `entities/` - Definice databázových tabulek (modely).
* `repositories/` - Data Access Layer pro komunikaci s databází.
* `services/` - Business Layer obsahující aplikační logiku a výpočty (zpracování DTO objektů).
* `controllers/` - Application Layer obsahující REST API endpointy (s povoleným `@CrossOrigin`).
* `src/main/resources/static/` - Presentation Layer, kde se nachází HTML a JS soubory tvořící uživatelské rozhraní.

## Jak aplikaci spustit
1. Zapni MySQL databázi (např. v XAMPP Control Panelu).
2. Otevři projekt v IntelliJ IDEA.
3. Zkontroluj nastavení připojení k databázi v souboru `application.properties` (jméno databáze, port, uživatel root).
4. Spusť hlavní třídu Spring Boot aplikace.
5. Otevři webový prohlížeč a přejdi na adresu `http://localhost:8080/index.html`.

## Co nás čeká dál (TODO)
Nyní máme základní, plně funkční aplikaci (tzv. Beta release). Pro přípravu na reálný provoz jsou v plánu následující vylepšení:
* **Pokročilá validace a byznys logika:** Zamezení rezervacím v minulosti a ošetření překrývání termínů (aby si dva zákazníci nemohli rezervovat stejného kadeřníka na stejný čas).
* **Zabezpečení (Spring Security):** Vytvoření uživatelských rolí (Administrátor vs. Běžný zákazník) a ochrana citlivých dat.
* **Vylepšení vzhledu (UI/UX):** Nasazení moderního CSS frameworku (např. Bootstrap) pro responzivní a profesionální design na počítači i mobilu.
