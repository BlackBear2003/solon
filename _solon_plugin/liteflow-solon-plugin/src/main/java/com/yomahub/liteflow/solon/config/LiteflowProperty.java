package com.yomahub.liteflow.solon.config;


import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.util.ResourceUtil;

/**
 * 执行流程主要的参数类
 *
 * @author Bryan.Zhang
 * @author noear
 * @since 2.9
 */
@Inject("${liteflow}")
@Configuration
public class LiteflowProperty {

    //是否装配liteflow
    private boolean enable;

    //流程定义资源地址
    private String ruleSource;

    //流程资源扩展数据
    private String ruleSourceExtData;

    //slot的数量
    private int slotSize;

    //FlowExecutor的execute2Future的线程数
    private int mainExecutorWorks;

    //FlowExecutor的execute2Future的自定义线程池
    private String mainExecutorClass;

    //并行线程执行器class路径
    private String threadExecutorClass;

    //异步线程最大等待描述
    private int whenMaxWaitSeconds;

    //异步线程池最大线程数
    private int whenMaxWorkers;

    //异步线程池最大队列数量
    private int whenQueueLimit;

    //是否在启动时解析规则文件
    //这个参数主要给编码式注册元数据的场景用的，结合FlowBus.addNode一起用
    private boolean parseOnStart;

    //这个属性为true，则支持多种不同的类型的配置
    //但是要注意，不能将主流程和子流程分配在不同类型配置文件中
    private boolean supportMultipleType;

    //重试次数
    private int retryCount;

    //是否打印liteflow banner
    private boolean printBanner;

    // 节点执行器class全名
    private String nodeExecutorClass;

    // requestId 生成器
    private String requestIdGeneratorClass;

    //是否打印执行过程中的日志
    private boolean printExecutionLog;

    //替补组件的class路径
    private String substituteCmpClass;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getRuleSource() {
        return ruleSource;
    }

    public void setRuleSource(String ruleSource) {
        if (ruleSource.contains("*")) {
            this.ruleSource = String.join(",", ResourceUtil.resolvePaths(ruleSource));
        } else {
            this.ruleSource = ruleSource;
        }
    }

    public int getSlotSize() {
        return slotSize;
    }

    public void setSlotSize(int slotSize) {
        this.slotSize = slotSize;
    }

    public int getWhenMaxWaitSeconds() {
        return whenMaxWaitSeconds;
    }

    public void setWhenMaxWaitSeconds(int whenMaxWaitSeconds) {
        this.whenMaxWaitSeconds = whenMaxWaitSeconds;
    }

    public int getWhenMaxWorkers() {
        return whenMaxWorkers;
    }

    public void setWhenMaxWorkers(int whenMaxWorkers) {
        this.whenMaxWorkers = whenMaxWorkers;
    }

    public int getWhenQueueLimit() {
        return whenQueueLimit;
    }

    public void setWhenQueueLimit(int whenQueueLimit) {
        this.whenQueueLimit = whenQueueLimit;
    }

    public boolean isParseOnStart() {
        return parseOnStart;
    }

    public void setParseOnStart(boolean parseOnStart) {
        this.parseOnStart = parseOnStart;
    }

    public boolean isSupportMultipleType() {
        return supportMultipleType;
    }

    public void setSupportMultipleType(boolean supportMultipleType) {
        this.supportMultipleType = supportMultipleType;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public boolean isPrintBanner() {
        return printBanner;
    }

    public void setPrintBanner(boolean printBanner) {
        this.printBanner = printBanner;
    }

    public String getThreadExecutorClass() {
        return threadExecutorClass;
    }

    public void setThreadExecutorClass(String threadExecutorClass) {
        this.threadExecutorClass = threadExecutorClass;
    }

    public String getNodeExecutorClass() {
        return nodeExecutorClass;
    }

    public void setNodeExecutorClass(String nodeExecutorClass) {
        this.nodeExecutorClass = nodeExecutorClass;
    }

    public int getMainExecutorWorks() {
        return mainExecutorWorks;
    }

    public void setMainExecutorWorks(int mainExecutorWorks) {
        this.mainExecutorWorks = mainExecutorWorks;
    }

    public String getMainExecutorClass() {
        return mainExecutorClass;
    }

    public void setMainExecutorClass(String mainExecutorClass) {
        this.mainExecutorClass = mainExecutorClass;
    }

    public boolean isPrintExecutionLog() {
        return printExecutionLog;
    }

    public void setPrintExecutionLog(boolean printExecutionLog) {
        this.printExecutionLog = printExecutionLog;
    }

    public String getRequestIdGeneratorClass() {
        return requestIdGeneratorClass;
    }

    public void setRequestIdGeneratorClass(String requestIdGeneratorClass) {
        this.requestIdGeneratorClass = requestIdGeneratorClass;
    }

    public String getSubstituteCmpClass() {
        return substituteCmpClass;
    }

    public void setSubstituteCmpClass(String substituteCmpClass) {
        this.substituteCmpClass = substituteCmpClass;
    }

    public String getRuleSourceExtData() {
        return ruleSourceExtData;
    }

    public void setRuleSourceExtData(String ruleSourceExtData) {
        this.ruleSourceExtData = ruleSourceExtData;
    }
}
