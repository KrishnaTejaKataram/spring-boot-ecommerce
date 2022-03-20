package com.kt.ecommerce.config;

import com.kt.ecommerce.entity.Product;
import com.kt.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unSupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //disable HTTP Methods for Product: PUT, POST, DELETE
        config.getExposureConfiguration().forDomainType(Product.class)
                .withItemExposure((metaData, httpMethods) ->  httpMethods.disable(unSupportedActions))
                .withCollectionExposure((metaData, httpMethods) ->  httpMethods.disable(unSupportedActions));

        //disable HTTP Methods for ProductCategory: PUT, POST, DELETE
        config.getExposureConfiguration().forDomainType(ProductCategory.class)
                .withItemExposure((metaData, httpMethods) ->  httpMethods.disable(unSupportedActions))
                .withCollectionExposure((metaData, httpMethods) ->  httpMethods.disable(unSupportedActions));
    }
}
