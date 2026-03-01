package cz.osu.kadernistvi;

import cz.osu.kadernistvi.entities.Zakaznik;
import cz.osu.kadernistvi.repositories.ZakaznikRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(ZakaznikRepository zakaznikRepository) {
        return args -> {
            // Vytvoříme testovacího zákazníka
            Zakaznik z = new Zakaznik();
            z.setJmeno("Jan Novák");
            z.setTel("123456789");
            z.setEmail("jan.novak@example.com");

            // Uložíme ho pomocí repozitáře
            zakaznikRepository.save(z);

            System.out.println(">>> První zákazník úspěšně uložen do databáze! <<<");
        };
    }
}