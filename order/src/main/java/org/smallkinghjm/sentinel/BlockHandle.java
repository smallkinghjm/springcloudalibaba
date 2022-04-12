package org.smallkinghjm.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class BlockHandle {

    /**
     * 一定要是public
     * 返回值一定要和源方法保持一致,包含源方法参数
     * 参数在最后加上
     * 和SentinelResource不在同一个类时，要变为静态方法
     * @return
     */
    public static String orderAdd(BlockException e){
        e.printStackTrace();
        return "流控！！！";
    }
}
