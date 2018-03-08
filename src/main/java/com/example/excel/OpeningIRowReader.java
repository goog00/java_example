package com.example.excel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OpeningIRowReader extends IRowReader {
    private static final Logger logger = LoggerFactory.getLogger(OpeningIRowReader.class);
    /**
     * 行 读取，具体业务逻辑实现
     *
     * @param sheetIndex
     * @param curRow
     * @param rowList
     */
    @Override
    public void getRows(int sheetIndex, int curRow, List<String> rowList) {
//        if(logger.isDebugEnabled()){
//
//        }
        logger.info("Sheet={},Row={},Data={}",sheetIndex,curRow,rowList);
    }
}