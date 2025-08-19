package cursispringboot.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ExternalizedConfigurations {

    private String name;
    private String version;
    private String Autor;
    private String language;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ExternilizedConfigurations: " + "\n" +
                "nombre= " + this.name + "\n" +
                "pais= " + this.country + "\n" +
                "version= " + this.version + "\n" +
                "idioma= " + this.language + "\n" +
                "autor= " + this.Autor;
    }
}
