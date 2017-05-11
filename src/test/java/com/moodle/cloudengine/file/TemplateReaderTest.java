package com.moodle.cloudengine.file;

import com.moodle.cloudengine.template.model.Templates;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class TemplateReaderTest {
    private TemplateReader reader;

    @Before
    public void setup(){
        reader = new TemplateReader();
    }
    @Test
    public void testGetFileString() throws Exception {
        String file = reader.getFileAsString(Optional.of(Templates.VPC));
        assert file.contains(" Type: AWS::EC2::RouteTable");
    }
    @Test
    public void testGetFile2String() throws Exception {
        String file = reader.getFileAsString(Optional.of(Templates.RDS));
        assert file.contains("Type: AWS::RDS::DBInstance\n");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetBadFileString() throws Exception {
        String file = reader.getFileAsString(Optional.ofNullable(null));
    }

}