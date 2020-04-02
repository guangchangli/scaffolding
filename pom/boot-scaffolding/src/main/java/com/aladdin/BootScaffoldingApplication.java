package com.aladdin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootScaffoldingApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BootScaffoldingApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

//    @Autowired
//    MongoTemplate mongoTemplate;
//    @Autowired
//    MongoMappingContext mongoMappingContext;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void initIndicesAfterStartup() {
//        IndexOperations indexOps = mongoTemplate.indexOps(Article.class);
//        IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
//        resolver.resolveIndexFor(Article.class).forEach(indexOps::ensureIndex);
//    }
}
