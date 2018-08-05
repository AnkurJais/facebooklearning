package learning.automation.facebook.config;

import java.util.Map;

public class SeleniumConfig {

  private Map<String, String> gridConf;
  
  public void setGrid(Map<String, String> gridConf) {
    this.gridConf = gridConf;
  }

  public Map<String, String> getGrid() {
      return gridConf;
  }
}
