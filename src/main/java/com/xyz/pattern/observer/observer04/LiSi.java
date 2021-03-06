package com.xyz.pattern.observer.observer04;

import java.util.Observable;
import java.util.Observer;

/**
 * description: 优化后的观察者
 *
 * @author 非
 * @create 2018-11-10 14:58
 */
public class LiSi implements Observer {
    // 一旦韩非子有活动，他就知道，就要向老板汇报
    public void update(Observable o, Object arg) {
        System.out.println("李斯：观察到韩非子活动，开始向老板汇报了...");
        this.reportToQinShiHuang(arg.toString());
        System.out.println("李斯：汇报完毕。");
    }

    // 汇报给秦始皇
    private void reportToQinShiHuang(String reportContext) {
        System.out.println("李斯：起奏陛下，韩非子有活动了！--->" + reportContext);
    }
}
