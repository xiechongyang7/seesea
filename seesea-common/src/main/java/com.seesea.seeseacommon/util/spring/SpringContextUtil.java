//package com.seesea.seeseacommon.util.spring;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * @Description
// * @Since JDK1.8
// * @Createtime 2018/10/11 下午 9:44
// * @Author xiechongyang
// */
//public class SpringContextUtil extends PropertyPlaceholderConfigurer implements ApplicationContextAware {
//
//    private static ApplicationContext applicationContext;
//
//    private static Map<String, String> PropertiesMap;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//
//    @Override
//    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
//        super.processProperties(beanFactoryToProcess, props);
//        PropertiesMap = new HashMap<>();
//        for (Object key : props.keySet()) {
//            String keyStr = key.toString();
//            String value = props.getProperty(keyStr);
//            PropertiesMap.put(keyStr, value);
//        }
//    }
//
//    /**
//     * 按bean-id与类型从spring 容器中得到bean实例
//     *
//     * @param id
//     * @param type
//     * @param <T>
//     * @return
//     */
//    public static <T> T getBean(String id, Class<T> type) {
//        return applicationContext.getBean(id, type);
//    }
//
//    /**
//     * 按bean类型从spring 容器中获取实例
//     *
//     * @param type
//     * @param <T>
//     * @return
//     */
//    public static <T> T getBean(Class<T> type) {
//        return applicationContext.getBean(type);
//    }
//
//    /**
//     * 按bean类型从spring环境中取得bean实例列表
//     *
//     * @param type
//     * @param <T>
//     * @return
//     */
//    public static <T> Map<String, T> getBeans(Class<T> type) {
//        return applicationContext.getBeansOfType(type);
//    }
//
//    /**
//     * 获取配置文件中的参数
//     *
//     * @param name
//     * @return
//     */
//    public static String getProperty(String name) {
//        return PropertiesMap.get(name);
//    }
//
//    public static Map<String, String> getPropertiesMap() {
//        return PropertiesMap;
//    }
//}