

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.data.employee.employeeController","com.data.employee.employeeService",
		"com.data.employee.employeeRepository","com.data.employee.employeeDataModel"})
public class Application
{
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
}
