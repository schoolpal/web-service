package com.schoolpal.service;

import com.schoolpal.aop.ServiceLog;
import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.inf.TStudentMapper;
import com.schoolpal.db.model.TStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private TIndexMapper idxDao;
    @Autowired
    private TStudentMapper studentDao;

    public TStudent queryStudentById(String id) {
        TStudent ret = studentDao.selectOneById(id);
        return ret;
    }

    public TStudent queryStudentByCode(String code) {
        TStudent ret = studentDao.selectOneByCode(code);
        return ret;
    }

    public List<TStudent> queryStudentsByExecutiveId(String id) {
        List<TStudent> ret = studentDao.selectManyByExectiveId(id);
        return ret;
    }

    @ServiceLog
    public String addStudent(TStudent student) {

        String id = idxDao.selectNextId("t_student");
        student.setId(id);
        student.setCreateTime(new Date());
        student.setLastUpdate(new Date());
        studentDao.insertOne(student);

        return student.getId();
    }

    public void modStudent(TStudent student) {

        student.setLastUpdate(new Date());
        studentDao.updateOne(student);
    }

    public void delStudentById(String id) {
        studentDao.deleteOneById(id);
    }

}
