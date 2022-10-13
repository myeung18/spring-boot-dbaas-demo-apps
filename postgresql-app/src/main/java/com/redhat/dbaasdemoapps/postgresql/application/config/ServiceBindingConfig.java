package com.redhat.dbaasdemoapps.postgresql.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class ServiceBindingConfig {
    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    /**
     * Test only - not used in release
     */
//    @Bean(name = "ServiceBindingDataSource")
//    @Primary
    public DataSource createPostgreSqlDataSource() {
        PropertySource<?> dbBinding = configurableApplicationContext.getEnvironment().getPropertySources().get("kubernetesServiceBindingSpecific");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        if (dbBinding instanceof MapPropertySource) {
            Map<String, Object> map = ((MapPropertySource) dbBinding).getSource();
            dataSourceBuilder.driverClassName((String) map.get("spring.datasource.driver-class-name"));
            dataSourceBuilder.url((String) map.get("spring.datasource.url"));
            dataSourceBuilder.username((String) map.get("spring.datasource.username"));
            dataSourceBuilder.password((String) map.get("spring.datasource.password"));
        }

        return dataSourceBuilder.build();
    }
}
