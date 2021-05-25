package testing.tool_hw6;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import testing.Entity.entity_hw6;

public class DataListener extends AnalysisEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataListener.class);

    private static final int BATCH_COUNT = 5;
    List<Object> list = new ArrayList<>();

    @Override
    public void invoke(Object data, AnalysisContext analysisContext) {
        System.out.println(data);
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        // 将整个sheet的数据加到列表
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        /**
         * 这里可以进行一边监听一边写入  看情况用不用吧（目前不会有几万条数据，应该不用）
         */
//        if (list.size() >= BATCH_COUNT) {
//            // saveData();
//            // 存储完成清理 list
//            list.clear();
//        }
    }



    public List<Object> returnList(){
        return list;
    }
//
//    public List<entity_hw6> returnList(){
//        return list;
//    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        // saveData();
        LOGGER.info("所有数据解析完成！");
    }
}
