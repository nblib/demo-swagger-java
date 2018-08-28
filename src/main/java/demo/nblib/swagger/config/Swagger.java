package demo.nblib.swagger.config;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.validation.annotation.Validated;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
//@ConditionalOnProperty(prefix = "swagger",value = {"enable"},havingValue = "true") //只有配置文件中swagger.enable=true时才加载这个配置文件
@Profile("dev") //只有开发模式才使用swagger
@EnableSwagger2
public class Swagger {


    @Value("${spring.application.name}")
    private String title;   //应用名称,通过spring.application.name设置,必须配置,没有配置将报错

    @Value("${spring.application.description}")
    private String desc;    //应用描述,通过spring.application.description设置,必须配置,没有配置将报错

    @Autowired
    private SwaggerProperties properties;   //配置属性文件

    @Bean(value = "defaultApi")
    @Order(value = 1)
    public Docket createRestApi() {
        //存放全局参数,用于每一个接口
        List<SwaggerProperties.GlobalParm> globalParms = properties.getGlobalParms();
        List<Parameter> parameters = Lists.newArrayList();
        //扫描配置文件中的参数,添加为全局参数
        if (globalParms != null && globalParms.size() > 0) {
            for (SwaggerProperties.GlobalParm parm : globalParms) {
                ParameterBuilder parameterBuilder = new ParameterBuilder();
                parameterBuilder.name(parm.getName()).description(parm.getDesc()).modelRef(new ModelRef(parm.getType()))
                        .parameterType(parm.getTarget()).defaultValue(parm.getDef())
                        .required(parm.getRequired()).build();
                parameters.add(parameterBuilder.build());
            }
        }

        Docket docket = new Docket(DocumentationType.SWAGGER_2) //swagger的版本
                .apiInfo(apiInfo()) //api接口信息
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getBasepackage()))     //接口所在的包,一般为controller所在的包
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameters); //添加全局参数
        return docket;
    }

    private ApiInfo apiInfo() {
        ApiInfo info = new ApiInfoBuilder()
                .title(title)       //标题
                .description(desc)  //描述
                .termsOfServiceUrl(properties.getServiceUrl()) //接口绑定的域名
                .version(properties.getVersion())   //接口版本
                .build();

        return info;
    }
}
