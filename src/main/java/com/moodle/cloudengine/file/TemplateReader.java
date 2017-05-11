package com.moodle.cloudengine.file;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.moodle.cloudengine.template.model.Templates;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by andrewlarsen on 5/7/17.
 */
@Component
public class TemplateReader {

    private static final Logger log = Logger.getLogger(TemplateReader.class);

    private static final String EC_TEMPLATE = "ec_memcached_template.yaml";
    private static final String EFS_TEMPLATE = "efs_mount_template.yaml";
    private static final String RDS_TEMPLATE = "rds_db_template.yaml";
    private static final String VPC_TEMPLATE = "vpc_template.yaml";

    /**
     * Method to read in file and return as string
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public String getFileAsString(Optional<Templates> template) throws IOException, URISyntaxException, RuntimeException {
        String fileName = null;
        if (!template.isPresent()) {
            throw new IllegalArgumentException("\"Cannot match template type \"");
        }

        switch (template.get()){
            case VPC:
                fileName = VPC_TEMPLATE;
                break;
            case RDS:
                fileName = RDS_TEMPLATE;
                break;
            case EFS:
                fileName = EFS_TEMPLATE;
                break;
            case EC:
                fileName = EC_TEMPLATE;
                break;
            default:
                throw new IllegalArgumentException("Cannot match template type ");
        }
        URL url = getClass().getClassLoader()
                .getResource(fileName);
        if(url == null){
            //I thought it was shipped with core java.....
            throw new IllegalArgumentException("File does not exist");

        }
        log.debug("File url " + url);

        Path path = Paths.get(url.toURI());

        StringBuilder data = new StringBuilder();
        Stream<String> lines = Files.lines(path);
        lines.forEach(line -> data.append(line).append("\n"));
        lines.close();

        return data.toString();
    }
//
//    public Template getParameters(String fileName) throws IOException, URISyntaxException {
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource(fileName).getFile());
//
//        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        Template template = mapper.readValue(file, Template.class);
//        return template;
//    }
}
