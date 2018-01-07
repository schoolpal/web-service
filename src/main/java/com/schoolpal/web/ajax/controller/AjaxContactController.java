package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TContact;
import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.ContactService;
import com.schoolpal.service.LeadsService;
import com.schoolpal.service.UserService;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;
import com.schoolpal.web.helper.AuthorizationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/ajax/contact")
public class AjaxContactController extends AjaxBaseController{

    @Autowired
    private UserService userServ;
    @Autowired
    private LeadsService leadsServ;
    @Autowired
    private ContactService contactServ;

    @AjaxControllerLog
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public Object list(@NotEmpty String leadsId) throws AjaxException {

        String permId = this.getQueryPermIdByLeadsId(leadsId);
        if (!AuthorizationHelper.CheckPermissionById(permId)) {
            throw new AjaxException(401, "No permission to list contacts");
        }

        List<TContact> acts = contactServ.queryContactsByLeadsId(leadsId);

        return acts;
    }

    @AjaxControllerLog
    @RequestMapping(value = "query.do", method = RequestMethod.POST)
    public Object query(@NotEmpty String id) throws AjaxException {

        TContact contact = contactServ.queryContactById(id);
        if (contact == null) {
            throw new AjaxException(402, "Invalid contact id");
        }

        String permId = this.getModPermIdByLeadsId(contact.getLeadsId());
        if (!AuthorizationHelper.CheckPermissionById(permId)) {
            throw new AjaxException(401, "No permission to query contact");
        }

        return contact;
    }

    private String getQueryPermIdByLeadsId(String id) {
        String permId = "";

        TLeads leads = leadsServ.queryLeadsById(id);
        if (leads != null) {
            switch (leads.getTypeId()) {
                case 1:
                    permId = "1-2";
                    break;
                case 2:
                    permId = "2-1";
                    break;
                case 3:
                    permId = "2-2";
                    break;
                default:
                    permId = "";
                    break;
            }
        }

        return permId;
    }

    private String getModPermIdByLeadsId(String id) {
        String permId = "";

        TLeads leads = leadsServ.queryLeadsById(id);
        if (leads != null) {
            switch (leads.getTypeId()) {
                case 1:
                    permId = "1-2-2";
                    break;
                case 2:
                    permId = "2-1-2";
                    break;
                case 3:
                    permId = "2-2-2";
                    break;
                default:
                    permId = "";
                    break;
            }
        }

        return permId;
    }

    @AjaxControllerLog
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    public Object add(@Validated({AjaxControllerAdd.class}) TContact contact) throws AjaxException {

        String permId = this.getModPermIdByLeadsId(contact.getLeadsId());
        if (!AuthorizationHelper.CheckPermissionById(permId)) {
            throw new AjaxException(401, "No permission to add contact");
        }

        TUser user = userServ.getCachedUser();
        contact.setExecutiveId(user.getcId());

        if (contactServ.addContact(contact) == null) {
            throw new AjaxException(500, "Failed to add activity");
        }

        return contact.getId();
    }

    @AjaxControllerLog
    @RequestMapping(value = "mod.do", method = RequestMethod.POST)
    public Object mod(@Validated({AjaxControllerMod.class}) TContact contact) throws AjaxException {

        TContact target = contactServ.queryContactById(contact.getId());
        if (target == null) {
            throw new AjaxException(402, "Invalid contact id");
        }

        String permId = this.getModPermIdByLeadsId(target.getLeadsId());
        if (!AuthorizationHelper.CheckPermissionById(permId)) {
            throw new AjaxException(401, "No permission to mod contact");
        }

        if (!contactServ.modContact(contact)) {
            throw new AjaxException(500, "Failed to mod activity");
        }

        return true;
    }

    @AjaxControllerLog
    @RequestMapping(value = "del.do", method = RequestMethod.POST)
    public Object del(@NotEmpty String id) throws AjaxException {

        TContact contact = contactServ.queryContactById(id);
        if (contact == null) {
            throw new AjaxException(402, "Invalid contact id");
        }

        String permId = this.getModPermIdByLeadsId(contact.getLeadsId());
        if (!AuthorizationHelper.CheckPermissionById(permId)) {
            throw new AjaxException(401, "No permission to del contact");
        }

        if (!contactServ.delContactById(id)) {
            throw new AjaxException(500, "Failed to del contact");
        }

        return true;
    }

}
