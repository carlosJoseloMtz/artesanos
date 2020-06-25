package mx.nopal.commerce.customers;


import mx.nopal.commerce.customers.facades.CompanyFacade;
import mx.nopal.commerce.customers.facades.impl.DefaultCompanyFacade;
import mx.nopal.commerce.customers.repositories.CompanyRepository;
import mx.nopal.commerce.customers.services.CompanyService;
import mx.nopal.commerce.customers.services.impl.DefaultCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "mx.nopal.commerce.customers.repositories")
@EnableTransactionManagement
public class ModuleConfig {

    @Autowired
    private CompanyRepository companyRepository;

    @Bean
    public CompanyService companyService(final CompanyRepository companyRepository) {
        return new DefaultCompanyService(companyRepository);
    }

    @Bean
    public CompanyFacade companyFacade(final CompanyService companyService) {
        return new DefaultCompanyFacade(companyService);
    }


}
