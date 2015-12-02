/**
 * @Title: Bootstrap.java
 * @Package cn.com.bestpay.financing.financing
 * @Description: 启动类
 * @author Gary
 * @date 2013年12月23日 下午1:17:07
 * @version V1.0
 */
package com.bestpay.cf.drools;

import com.google.common.util.concurrent.AbstractIdleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: Bootstrap
 * @Description: 启动类   支持jar包启动
 * @author Gary
 * @date 2013年12月23日 下午1:17:07
 *
 */
public class Bootstrap extends AbstractIdleService {
    private final static Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    private ClassPathXmlApplicationContext context;

    /*
     * <p>Title: startUp</p> <p>Description:启动服务 </p>
     *
     * @throws Exception
     *
     * @see com.google.common.util.concurrent.AbstractIdleService#startUp()
     */
    @Override
    protected void startUp() throws Exception {
        context = new ClassPathXmlApplicationContext(new String[] { "application-config.xml" });
        context.start();
        context.registerShutdownHook();
        logger.info("cf-scheduler orange service started successfully");

    }

    /*
     * <p>Title: shutDown</p> <p>Description:停止服务 </p>
     *
     * @throws Exception
     *
     * @see com.google.common.util.concurrent.AbstractIdleService#shutDown()
     */
    @Override
    protected void shutDown() throws Exception {
        context.stop();
        logger.info("cf-scheduler orange service stopped successfully");

    }

    /**
     *
     * @Title: main
     * @Description: 主方法
     * @param args
     * @throws
     */
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.startAsync();
        try {
            Object lock = new Object();
            synchronized (lock) {
                while (true) {
                    lock.wait();
                }
            }
        } catch (InterruptedException ex) {
            logger.error("ignore interruption");
        }
    }
}
