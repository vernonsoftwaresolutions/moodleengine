package com.moodle.cloudengine.moodle;

import com.moodle.cloudengine.file.TemplateReader;
import com.moodle.cloudengine.stack.VPC;
import com.moodle.cloudengine.template.Template;
import com.moodle.cloudengine.template.model.Templates;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

/**
 * Created by andrewlarsen on 5/9/17.
 */
@Service
public class MoodleService {

    private TemplateReader templateReader;
    private Template template;
    public void createInfrastructure() throws IOException, URISyntaxException {
        //check tier?
        //get VPC Template

        String vpcTemplate = templateReader.getFileAsString(Optional.of(Templates.VPC));
        VPC vpc = new VPC();

        //template.buildStack();
    }
}
