package io.github.jassonluizjr.clientes.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class InternacionalisacaoConfig {

	// Configuração do arquivo de menssagem
	@Bean
	public MessageSource messageSoure() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("ISO-8859-1");
		messageSource.setDefaultLocale(Locale.getDefault());
		return messageSource;
	}
	
	// Configuração do Bean Validation
	@Bean
	public LocalValidatorFactoryBean validatorFactoryBean() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSoure());
		return bean;
	}
}
