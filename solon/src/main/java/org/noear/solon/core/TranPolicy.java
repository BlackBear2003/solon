package org.noear.solon.core;

/**
 * 事务策略
 *
 *
 * 加入：指加入一个事务组；不会主动提交事务；
 *      父回滚子必回滚；子回滚父可不回滚；
 *
 * 并入：指成为当前事务的一部分；
 *      父回滚子必回滚；父子一体；
 *
 * 嵌套：指事务独立存在；会主动提交事务；回滚隔离；
 *      父回滚子不回滚；子回滚父可不回滚；
 *
 * 挂起：保存线程状态中的事务；然后移除线程状态；等执行完后，将保存的事务放回线程状态；
 *
 *
 * */
public enum TranPolicy {
    /**
     * 必须（需要入栈）
     *
     * 1.如果当前为事务组，则新建并[加入]
     * 2.否则，如果当前存在同源事务则[并入]
     * 3.否则新建事务并[嵌入]；
     */
    required(1),

    /**
     * 必须新起一个事务（不需要加入组）（需要入栈）
     *
     * 1.如果当前有事务，则[挂起]
     * 2.然后[嵌入]
     */
    requires_new(2),

    /**
     * 必须新起一个事务；且加入事务组；（需要入栈）
     *
     * 1.如果当前为事务组，则[加入]
     * 2.如果当前有事务，则[挂起]
     * 3.然后[嵌入]
     * */
    nested(3),

    /**
     * 当前必须要有（不需要加入组）（不需要入栈）
     *
     * 1.如果当前存在同源事务则[并入]
     * 2.否则出异常
     * */
    mandatory(4),

    /**
     * 支持但不必须（不需要加入组）（不需要入栈）（::它的真正作用是同源检测；否则排除）
     *
     * 1.如果当前存在同源事务则[并入]；
     * 2.否则[挂起]；
     */
    supports(5),

    /**
     * 排除，当前有事务则[挂起]（不需要加入组）（不需要入栈）
     */
    not_supported(6),

    /**
     * 决不，当前有事务则异常（不需要加入组）（不需要入栈）
     */
    never(7);


    public final int code;

    TranPolicy(int code) {
        this.code = code;
    }
}
