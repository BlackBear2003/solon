package org.noear.nami.annotation;

import org.noear.nami.NamiConfiguration;
import org.noear.nami.NamiConfigurationDefault;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NamiClient {
    /**
     * uri:
     * 1. http://x.x.x/x/x/ (url)
     * 2. name:/x/x/ (name:path)
     * 3. name
     * */
    //@Deprecated
    //String value() default "";

    /**
     * 完整的url地址（url）
     * */
    String url() default "";

    /**
     * 服务组
     * */
    String group() default "";

    /**
     * 服务名（name + path）
     * */
    String name() default "";

    /**
     * 路径（name + path）
     * */
    String path() default "";

    /**
     * 添加头信息
     *
     * 例：{"xxx=xxx","yyy=yyy"}
     * */
    String[] headers() default {};

    /**
     * 负载（用于方便演示，设定固定负载）
     * */
    String[] upstream() default {};

//    int timeout() default 0;
//
//    boolean check() default true;

    /**
     * 指定配置器
     * */
    Class<? extends NamiConfiguration> configuration() default NamiConfigurationDefault.class;
}

