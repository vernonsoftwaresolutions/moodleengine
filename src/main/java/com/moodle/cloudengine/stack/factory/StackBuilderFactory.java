package com.moodle.cloudengine.stack.factory;

import com.moodle.cloudengine.file.TemplateReader;
import com.moodle.cloudengine.stack.builder.*;
import com.moodle.cloudengine.template.model.Templates;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;


/**
 * Created by andrewlarsen on 5/10/17.
 */
@Component
public class StackBuilderFactory {
    private TemplateReader fileReader;


    public StackBuilderFactory(TemplateReader fileReader) {
        this.fileReader = fileReader;
    }

    public StackBuilder getBuilder(Optional<Templates> template) throws IOException, URISyntaxException {
        String templateBody = fileReader.getFileAsString(template);
        StackBuilder builder = null;
        if(!template.isPresent()){
            throw new IllegalArgumentException("Cannot match template type to available stack builders");

        }
        switch (template.get()){
            case VPC:
                builder = VPCBuilder.fromTemplateBody(templateBody);
                break;
            case RDS:
                builder = RDSBuilder.fromTemplateBody(templateBody);
                break;
            case EFS:
                builder = EFSBuilder.fromTemplateBody(templateBody);
                break;
            case EC:
                builder = ElasticCacheBuilder.fromTemplateBody(templateBody);
                break;
            default:
                throw new IllegalArgumentException("Cannot match template type to available stack builders");
        }

        return builder;
    }
}
