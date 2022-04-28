package com.b2birest_reprocess_api.config;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BlobConfig {

//    @Value("${spring.cloud.azure.storage.blob.account-name}")
//    private String accountName;
//
//
//    @Value("${spring.cloud.azure.blob.storage.account-key}")
//    private String accountKey;
//
//    @Value("${spring.cloud.azure.storage.blob-endpoint}")
//    private String url;

    @Value("${azure.myblob.url}")
    private String url;

    @Value("${azure.storage.container-name}")
    private String container;



    @Bean
    public BlobServiceClient getBlobServiceClient(){
//        StorageSharedKeyCredential credential = new StorageSharedKeyCredential(accountName, accountKey);
//        String endpoint = String.format(Locale.ROOT, url, accountName);
        return new BlobServiceClientBuilder().connectionString(url).buildClient();
    }

    @Bean
    public BlobContainerClient getBlobContainerClient(BlobServiceClient getBlobServiceClient){
        return getBlobServiceClient.getBlobContainerClient(container);

    }
}
