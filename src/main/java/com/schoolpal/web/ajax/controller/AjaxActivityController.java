package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TActivity;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.ActivityService;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.UserService;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import javax.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/ajax/mkt/activity")
public class AjaxActivityController extends AjaxBaseController {

    @Autowired
    private UserService userServ;
    @Autowired
    private ActivityService actServ;
    @Autowired
    private OrgService orgServ;

    protected class listTreeResponse {
        private List<TOrg> orgList = null;
        private Map<String, List<TActivity>> actListMap = null;

        public listTreeResponse(List<TOrg> orgList, Map<String, List<TActivity>> actListMap) {
            this.orgList = orgList;
            this.actListMap = actListMap;
        }
    }

    @AjaxControllerLog
    @RequiresPermissions("1")
    @RequestMapping(value = "listTree.do", method = RequestMethod.POST)
    public Object listTree(@NotEmpty String orgId) {

        List<TOrg> orgList = orgServ.queryUpperOrgListByIdLite(orgId);
        Map<String, List<TActivity>> actListMap = new HashMap<String, List<TActivity>>();

        for (TOrg org : orgList) {
            List<TActivity> actList = actServ.queryActivitiesByOrgId(org.getcId());
            actListMap.put(org.getcId(), actList);
        }

        listTreeResponse data = new listTreeResponse(orgList, actListMap);

        return data;
    }

    @AjaxControllerLog
    @RequiresPermissions("1-1")
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public Object list(@NotEmpty String organizationId) {

        List<TActivity> acts = actServ.queryActivitiesByOrgId(organizationId);

        return acts;
    }

    @AjaxControllerLog
    @RequiresPermissions("1-1")
    @RequestMapping(value = "query.do", method = RequestMethod.POST)
    public Object query(@NotEmpty String id) throws AjaxException {

        TActivity act = actServ.queryActivityById(id);
        if (act == null) {
            throw new AjaxException(500, "Failed to query activity");
        }

        return act;
    }

    @AjaxControllerLog
    @RequiresPermissions("1-1-1")
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    @Transactional
    public Object add(@Validated({AjaxControllerAdd.class}) TActivity act) throws AjaxException {

        if (act.getParentId() == null) {
            act.setRootId(null);
        } else {
            TActivity parent = actServ.queryActivityById(act.getParentId());
            if (parent == null) {
                throw new AjaxException(403, "Invalid parent id");
            }
            act.setRootId(parent.getRootId());
        }

        TUser user = userServ.getCachedUser();
        act.setCreatorId(user.getcId());

        if (actServ.addActivity(act) == null) {
            throw new AjaxException(500, "Failed to add activity");
        }

        if (act.getRootId() == null) {
            act.setParentId(act.getId());
            act.setRootId(act.getId());
            if (!actServ.modActivity(act)) {
                throw new AjaxException(501, "Failed to set parent/root id for activity");
            }
        }

        return act.getId();
    }

    @AjaxControllerLog
    @RequiresPermissions("1-1-2")
    @RequestMapping(value = "mod.do", method = RequestMethod.POST)
    @Transactional
    public Object mod(@Validated({AjaxControllerMod.class}) TActivity act) throws AjaxException {

        TActivity current = actServ.queryActivityById(act.getId());
        if (current == null) {
            throw new AjaxException(406, "Failed to find activity");
        }

        if (act.getParentId() != null) {
            TActivity parent = actServ.queryActivityById(act.getParentId());
            if (parent == null) {
                throw new AjaxException(407, "Failed to find parent activity");
            }

            if (!current.getRootId().equals(parent.getRootId())) {
                throw new AjaxException(409, "Invalid parent: root activity not match");
            }

            act.setRootId(parent.getRootId());
        }

        if (!actServ.modActivity(act)) {
            throw new AjaxException(500, "Failed to mod activity");
        }

        return true;
    }

    @AjaxControllerLog
    @RequiresPermissions("1-1-3")
    @RequestMapping(value = "del.do", method = RequestMethod.POST)
    public Object del(@NotEmpty String id) throws AjaxException {

        if (!actServ.delActivityById(id)) {
            throw new AjaxException(500, "Failed to del activity");
        }
        return true;
    }

}
