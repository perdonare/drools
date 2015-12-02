package com.bestpay.cf.drools.service;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by perdonare on 2015/12/2.
 */
public class RulesService {
    public void initRules() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("hello world");
        kieBase.getKieSessions();//后面再用

        KieSession kieSession = kieContainer.newKieSession("hello world");

        //设置领域模型
        //放入容器
        //匹配规则
    }

}
