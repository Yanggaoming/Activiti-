import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class TestActi {

    //生成工作流的表
    public void createTable(){
        ProcessEngineConfiguration configuration=ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://localhost:3306/activity?characterEncoding=utf-8");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("123456");

        //设置支持表的更新
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        //得到流程引擎对象
        ProcessEngine processEngine =configuration.buildProcessEngine();
    }


    //通过spring 配置创建Activiti表
    public void createTableWithXml(){
        //加载ctiviti.cfg.xml 配置文件
        ProcessEngineConfiguration configuration=  ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine =configuration.buildProcessEngine();
    }

    public static  void main(String []agrs){
        TestActi testActi = new TestActi();
        testActi.createTableWithXml();
    }
}
