package com.schoolpal.web.ajax.controller;

import com.schoolpal.db.model.TStudent;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.RelationService;
import com.schoolpal.service.StudentService;
import com.schoolpal.service.UserService;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;
import javax.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public abstract class AjaxBaseStudentController extends AjaxBaseController{

    @Autowired
    protected UserService userServ;
    @Autowired
    protected StudentService stuServ;
    @Autowired
    protected RelationService relationServ;

    public Object query(@NotEmpty String id) throws AjaxException {

        TStudent contract = stuServ.queryStudentById(id);
        if (contract == null) {
            throw new AjaxException(402, "Invalid student id");
        }

        return contract;
    }

    public Object queryByCode(@NotEmpty String code) throws AjaxException {

        TStudent target = stuServ.queryStudentByCode(code);
        if (target == null) {
            throw new AjaxException(402, "Invalid student code");
        }

        return target;
    }

    public Object list() throws AjaxException {

        TUser user = userServ.getCachedUser();

        List<TStudent> students = stuServ.queryStudentsByExecutiveId(user.getcId());

        return students;
    }

    public Object add(@Validated({AjaxControllerAdd.class}) TStudent student) throws AjaxException {

        TUser user = userServ.getCachedUser();

        student.setCreatorId(user.getcId());
        student.setExecutiveId(user.getcId());
        if (stuServ.addStudent(student) == null) {
            throw new AjaxException(500, "Failed to add student");
        }

        return student.getId();
    }

    public Object mod(@Validated({AjaxControllerMod.class}) TStudent student) throws AjaxException {

        TStudent target = stuServ.queryStudentById(student.getId());
        if (target == null) {
            throw new AjaxException(402, "Invalid student id");
        }

        if (!stuServ.modStudent(student)) {
            throw new AjaxException(500, "Failed to mod student");
        }

        return true;
    }

    @Transactional
    public Object del(@NotEmpty String id) throws AjaxException {

        TStudent target = stuServ.queryStudentById(id);
        if (target == null) {
            throw new AjaxException(402, "Invalid student id");
        }

        if (!stuServ.delStudentById(id)) {
            throw new AjaxException(500, "Failed to del activity");
        }
        relationServ.delRelationsByStuId(id);

        return true;
    }

}
