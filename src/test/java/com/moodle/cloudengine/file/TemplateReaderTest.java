package com.moodle.cloudengine.file;

import com.moodle.cloudengine.template.model.Template;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class TemplateReaderTest {
    private TemplateReader reader;
    private String fileName = "vpc_template.yaml";
    private String secondFileName = "rds_db_template.yaml";

    private String badFileName = "emailtemplateasdfasdf.html";

    @Before
    public void setup(){
        reader = new TemplateReader();
    }
    @Test
    public void testGetFileString() throws Exception {
        String file = reader.getFileAsString(fileName);
        assert file.contains(" Type: AWS::EC2::RouteTable");
    }
    @Test
    public void testGetFile2String() throws Exception {
        String file = reader.getFileAsString(secondFileName);
        assert file.contains("Type: AWS::RDS::DBInstance\n");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetBadFileString() throws Exception {
        String file = reader.getFileAsString(badFileName);
    }

//    @Test
//    public void test() throws IOException, URISyntaxException {
//        Template template = reader.getParameters(fileName);
//    }
}