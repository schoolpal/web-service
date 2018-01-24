package com.schoolpal.web.ajax.controller;

import com.schoolpal.db.model.TParent;
import com.schoolpal.db.model.TStudent;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.ParentService;
import com.schoolpal.service.RelationService;
import com.schoolpal.service.StudentService;
import com.schoolpal.service.UserService;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
public abstract class AjaxBaseParentController extends AjaxBaseController {

    @Autowired
    protected UserService userServ;
    @Autowired
    protected ParentService parServ;
    @Autowired
    protected StudentService stuServ;
    @Autowired
    protected RelationService relationServ;

    public Object query(@NotEmpty String id) throws AjaxException {

        TParent parent = parServ.queryParentById(id);
        if (parent == null) {
            throw new AjaxException(402, "Invalid contact id");
        }

        return parent;
    }

    public Object queryListByStudentId(@NotEmpty String id) throws AjaxException {

        List<TParent> parents = parServ.queryParentsByStudentId(id);

        return parents;
    }

    public Object list() throws AjaxException {

        TUser user = userServ.getCachedUser();
        List<TParent> parents = parServ.queryParentsByExecutiveId(user.getcId());

        return parents;
    }

    @Transactional
    public Object add(TParent parent, String studentId) throws AjaxException {

        if (!StringUtils.isEmpty(parent.getRelation()) && !StringUtils.isEmpty(studentId)) {
            TStudent student = stuServ.queryStudentById(studentId);
            if (student == null) {
                throw new AjaxException(401, "Student not exists");
            }
        }

        TUser user = userServ.getCachedUser();
        try {
            parent.setCreatorId(user.getcId());
            parent.setExecutiveId(user.getcId());
            parServ.addParent(parent);
            if (!StringUtils.isEmpty(parent.getRelation()) && !StringUtils.isEmpty(studentId)) {
                relationServ.addRelation(parent.getId(), studentId, parent.getRelation());
            }
        } catch (Exception e) {
            throw new AjaxException(500, "Failed to add parent", e);
        }

        return parent.getId();
    }

    @Transactional
    public Object mod(TParent parent, String studentId) throws AjaxException {

        TParent target = parServ.queryParentById(parent.getId());
        if (target == null) {
            throw new AjaxException(402, "Parent not found");
        }
        if (!StringUtils.isEmpty(parent.getRelation()) && !StringUtils.isEmpty(studentId)) {
            TStudent student = stuServ.queryStudentById(studentId);
            if (student == null) {
                throw new AjaxException(401, "Student not exists");
            }
        }

        try {
            parServ.modParent(parent);
            if (!StringUtils.isEmpty(parent.getRelation()) && !StringUtils.isEmpty(studentId)) {
                relationServ.modRelation(parent.getId(), studentId, parent.getRelation());
            }
        } catch (Exception e) {
            throw new AjaxException(500, "Failed to mod parent", e);
        }

        return true;
    }

    @Transactional
    public Object del(@NotEmpty String id) throws AjaxException {

        TParent target = parServ.queryParentById(id);
        if (target == null) {
            throw new AjaxException(412, "Invalid contact id");
        }

        try {
            parServ.delParentById(id);
            relationServ.delRelationsByParId(id);
        } catch (Exception e) {
            throw new AjaxException(500, "Failed to del parent");
        }

        return true;
    }

}
