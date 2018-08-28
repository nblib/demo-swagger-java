package demo.nblib.swagger.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置属性
 */
@Component
@ConfigurationProperties("swagger")
@Validated
public class SwaggerProperties {
    /**
     * 扫描包
     */
    @NotBlank
    private String basepackage;
    /**
     * 接口版本
     */
    @NotBlank
    private String version;
    /**
     * 接口域名
     */
    @NotBlank
    private String serviceUrl;

    /**
     * 全局参数,设置全局参数,测试时,将被自动加到接口参数中
     */
    private List<GlobalParm> globalParms = new ArrayList<>();

    public String getBasepackage() {
        return basepackage;
    }

    public void setBasepackage(String basepackage) {
        this.basepackage = basepackage;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public List<GlobalParm> getGlobalParms() {
        return globalParms;
    }

    public void setGlobalParms(List<GlobalParm> globalParms) {
        this.globalParms = globalParms;
    }

    /**
     * 全局参数
     */
    static class GlobalParm {
        @NotBlank
        private String name;    //参数名
        private String desc;    //描述
        @NotBlank
        private String type;    //类型
        @NotBlank
        private String target;  //参数目标位置,请求头,还是请求参数
        private String def;     //默认值
        private Boolean required;   //是否必须

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getDef() {
            return def;
        }

        public void setDef(String def) {
            this.def = def;
        }

        public Boolean getRequired() {
            return required;
        }

        public void setRequired(Boolean required) {
            this.required = required;
        }
    }
}
