package com.schoolpal.web.ajax.controller;

import com.schoolpal.db.model.TParent;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.ParentService;
import com.schoolpal.service.RelationService;
import com.schoolpal.service.UserService;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
public abstract class AjaxBaseParentController extends AjaxBaseController{

    @Autowired
    protected UserService userServ;
    @Autowired
    protected ParentService parServ;
    @Autowired
    protected RelationService relationServ;

    public Object query(@NotEmpty String id) throws AjaxException {

        TParent parent = parServ.queryParentById(id);
        if (parent == null) {
            throw new AjaxException(402, "Invalid contact id");
        }

        return parent;
    }

    public Object list() throws AjaxException {

        TUser user = userServ.getCachedUser();
        List<TParent> parents = parServ.queryParentsByExecutiveId(user.getcId());

        return parents;
    }

    public Object add(TParent parent) throws AjaxException {

        TUser user = userServ.getCachedUser();

        parent.setCreatorId(user.getcId());
        parent.setExecutiveId(user.getcId());
        if (parServ.addParent(parent) == null) {
            throw new AjaxException(500, "Failed to add parent");
        }

        return parent.getId();
    }

    public Object mod(TParent parent) throws AjaxException {

        TParent target = parServ.queryParentById(parent.getId());
        if (target == null) {
            throw new AjaxException(402, "Invalid contact id");
        }

        if (!parServ.modParent(parent)) {
            throw new AjaxException(500, "Failed to mod parent");
        }

        return true;
    }

    @Transactional
    public Object del(@NotEmpty String id) throws AjaxException {

        TParent target = parServ.queryParentById(id);
        if (target == null) {
            throw new AjaxException(412, "Invalid contact id");
        }

        if (!parServ.delParentById(id)) {
            throw new AjaxException(500, "Failed to del parent");
        }
        relationServ.delRelationsByParId(id);

        return true;
    }

}