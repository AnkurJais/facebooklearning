package learning.automation.facebook.utils;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import learning.automation.facebook.config.SeleniumConfig;
import learning.automation.facebook.constants.Directory;

public class YamlReader<T> {

  public T readYaml(Class<T> classOb, String yamlFile) {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    T classOb2 = null;
    try {
      classOb2 = mapper.readValue(new File(yamlFile), classOb);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return classOb2;
  }
}
