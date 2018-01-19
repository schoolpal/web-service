package com.schoolpal.service;

import com.google.gson.Gson;
import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.LogDB;
import com.schoolpal.db.inf.TLogMapper;
import com.schoolpal.db.model.TLogWithBLOBs;
import com.schoolpal.model.ServiceLogRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogService {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private LogDB logDB;

    @Autowired
    private TLogMapper logMapper;

//    private Gson gson = new Gson();

//    public void log(LogLevel level, String message, ServiceLogRecord logRecord) {
//        try {
//            logDB.add(level.toString(), message, logRecord.getUserId(), logRecord.getUserName(), logRecord.getInvocation(),
//                    gson.toJson(logRecord.getArgs()), gson.toJson(logRecord.getReturnVal()), logRecord.getIp());
//        } catch (Exception e) {
//            logger.warn("Failed to write service log - {}", e.getMessage());
//            logger.info("{}, {}, {}", level.toString(), message, gson.toJson(logRecord));
//        }
//    }

    public void log(LogLevel level, String message, TLogWithBLOBs logWithBLOBs) {
        try {
            logWithBLOBs.setDatetime(new Date());
            logWithBLOBs.setLevel(level.toString());
            logWithBLOBs.setMessage(message);
            logMapper.insertOne(logWithBLOBs);
        } catch (Exception e) {
            logger.warn("Failed to write service log - {}", e.getMessage());
            logger.info(logWithBLOBs.toString());
        }
    }

    public void log(String creator, LogLevel type, String title, String desc, String debug, String detail) {
    }

    public void log(String creator, LogLevel type, String title, String desc, String debug) {
    }

    public void log(String creator, LogLevel type, String title, String desc) {
    }
}
