package com.xyz.pattern.observer.observer03;

/**
 * description: 观察者宙斯
 *
 * @author 非
 * @create 2018-11-10 14:33
 */
public class ZhouSi implements IObserver {
    // 一旦韩非子有活动，他就知道，就要向老板汇报
    public void update(String context) {
        System.out.println("宙斯：观察到韩非子活动，自己也开始活动了...");
        this.reportToQinShiHuang(context);
        System.out.println("宙斯：乐死了。");
    }

    // 一看到韩非子有活动，他就痛苦
    private void reportToQinShiHuang(String reportContext) {
        System.out.println("宙斯：因为" + reportContext + "，--所以我快乐呀！");
    }
}
