package com.xyz.pattern.mediator.mediator02;

/**
 * @auth: liuyang
 * @date: 2018/9/24 17:21
 */
public class Mediator extends AbstractMediator {
    // 中介者最重要的方法
    @Override
    public void execute(String str, Object... objects) {
        if (str.equals("purchase.buy")) {
            // 采购电脑
            this.buyComputer((Integer) objects[0]);
        } else if (str.equals("sale.sell")) {
            // 销售电脑
            this.saleComputer((Integer) objects[0]);
        } else if (str.equals("sale.offsell")) {
            // 折价销售
            this.offSaleComputer();
        } else if (str.equals("stock.clear")) {
            // 清仓处理
            this.clearStock();
        }
    }

    // 采购电脑
    private void buyComputer(int number) {
        int saleStatus = super.sale.getSaleStatus();
        if (saleStatus > 80) {
            // 销售情况良好
            System.out.println("采购IBM电脑：" + number + "台");
            super.stock.increase(number);
        } else {
            // 销售情况不好
            int buyNumber = number / 2;
            System.out.println("采购IBM电脑：" + buyNumber + "台");
            super.stock.increase(buyNumber);
        }
    }

    // 销售电脑
    private void saleComputer(int number) {
        if (super.stock.getStockNumber() < number) {
            // 库存数量不够销售
            super.purchase.buyIBMComputer(number);
        }
        super.stock.decrease(number);
    }

    // 折价销售电脑
    private void offSaleComputer() {
        int stockNumber = super.stock.getStockNumber();
        System.out.println("折价销售IBM电脑：" + stockNumber + "台");
    }

    // 清仓处理
    private void clearStock() {
        // 要求清仓销售
        super.sale.offSale();
        // 要求采购人员不要采购
        super.purchase.refuseBuyIBMComputer();
    }
}
