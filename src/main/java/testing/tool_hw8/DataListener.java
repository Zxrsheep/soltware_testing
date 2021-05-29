package testing.tool_hw8;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

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
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        LOGGER.info("所有数据解析完成！");
    }
}
