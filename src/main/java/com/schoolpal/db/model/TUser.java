package com.schoolpal.db.model;

import java.util.*;

public class TUser {
    private String cId;

    private String cLoginName;

    private String cLoginPass;

    private String cRealName;

    private String cNickName;

    private String cPhone;

    private String cEmail;

    private String cQq;

    private Boolean cAvailable;

    private String cOrgId;

    private String cOrgRootId;

    private String cCreator;

    private Date cCreateTime;

    private Date cLastVisitTime;

    private String cLastVisitIp;

    private TOrg org;

    private List<TRole> roles;

    private Map<String, TRole> roleIndex = new HashMap<String, TRole>();

    private boolean marketingPermission;
    private boolean salesPermission;
    private boolean servicePermission;
    private boolean financePermission;
    private boolean administrationPermission;
    private boolean techingPermission;
    private boolean systemPermission;

    public TRole getRoleById(String roleId) {
        return this.roleIndex.get(roleId);
    }

    public List<String> getRoleIds() {
        return new ArrayList<String>(this.roleIndex.keySet());
    }

    public List<TFunction> getFuncs() {
        List<TFunction> funcs = new ArrayList<TFunction>();
        for (TRole role : roles) {
            funcs.addAll(role.getFunctions());
        }
        return funcs;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcLoginName() {
        return cLoginName;
    }

    public void setcLoginName(String cLoginName) {
        this.cLoginName = cLoginName == null ? null : cLoginName.trim();
    }

    public String getcLoginPass() {
        return cLoginPass;
    }

    public void setcLoginPass(String cLoginPass) {
        this.cLoginPass = cLoginPass == null ? null : cLoginPass.trim();
    }

    public String getcRealName() {
        return cRealName;
    }

    public void setcRealName(String cRealName) {
        this.cRealName = cRealName == null ? null : cRealName.trim();
    }

    public String getcNickName() {
        return cNickName;
    }

    public void setcNickName(String cNickName) {
        this.cNickName = cNickName == null ? null : cNickName.trim();
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }

    public String getcQq() {
        return cQq;
    }

    public void setcQq(String cQq) {
        this.cQq = cQq == null ? null : cQq.trim();
    }

    public Boolean getcAvailable() {
        return cAvailable;
    }

    public void setcAvailable(Boolean cAvailable) {
        this.cAvailable = cAvailable;
    }

    public String getcOrgId() {
        return cOrgId;
    }

    public void setcOrgId(String cOrgId) {
        this.cOrgId = cOrgId == null ? null : cOrgId.trim();
    }

    public String getcOrgRootId() {
        return cOrgRootId;
    }

    public void setcOrgRootId(String cOrgRootId) {
        this.cOrgRootId = cOrgRootId == null ? null : cOrgRootId.trim();
    }

    public String getcCreator() {
        return cCreator;
    }

    public void setcCreator(String cCreator) {
        this.cCreator = cCreator == null ? null : cCreator.trim();
    }

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public Date getcLastVisitTime() {
        return cLastVisitTime;
    }

    public void setcLastVisitTime(Date cLastVisitTime) {
        this.cLastVisitTime = cLastVisitTime;
    }

    public String getcLastVisitIp() {
        return cLastVisitIp;
    }

    public void setcLastVisitIp(String cLastVisitIp) {
        this.cLastVisitIp = cLastVisitIp == null ? null : cLastVisitIp.trim();
    }

    public TOrg getOrg() {
        return org;
    }

    public void setOrg(TOrg org) {
        this.org = org;
    }

    public List<TRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TRole> roles) {
        this.roles = roles;
        this.roleIndex.clear();
        for (TRole r : roles) {
            this.roleIndex.put(r.getcId(), r);
        }

        this.refreshPermissionFlags();
    }

    protected void refreshPermissionFlags(){

        this.marketingPermission = false;
        this.salesPermission = false;
        this.servicePermission = false;
        this.financePermission = false;
        this.administrationPermission = false;
        this.techingPermission = false;
        this.systemPermission = false;

        this.roles.forEach(r -> {
            r.getAllFuncIds().forEach(f -> {
                switch (f){
                    case "1":
                        this.marketingPermission = true;
                        break;
                    case "2":
                        this.salesPermission = true;
                        break;
                    case "3":
                        this.servicePermission = true;
                        break;
                    case "4":
                        this.financePermission = true;
                        break;
                    case "5":
                        this.administrationPermission = true;
                        break;
                    case "6":
                        this.techingPermission = true;
                        break;
                    case "7":
                        this.systemPermission = true;
                        break;
                    default:
                        break;
                }
            });
        });

    }

    public boolean hasMarketingPermission() {
        return marketingPermission;
    }

    public void setMarketingPermission(boolean marketingPermission) {
        this.marketingPermission = marketingPermission;
    }

    public boolean hasSalesPermission() {
        return salesPermission;
    }

    public void setSalesPermission(boolean salesPermission) {
        this.salesPermission = salesPermission;
    }

    public boolean hasServicePermission() {
        return servicePermission;
    }

    public void setServicePermission(boolean servicePermission) {
        this.servicePermission = servicePermission;
    }

    public boolean hasFinancePermission() {
        return financePermission;
    }

    public void setFinancePermission(boolean financePermission) {
        this.financePermission = financePermission;
    }

    public boolean hasAdministrationPermission() {
        return administrationPermission;
    }

    public void setAdministrationPermission(boolean administrationPermission) {
        this.administrationPermission = administrationPermission;
    }

    public boolean hasTechingPermission() {
        return techingPermission;
    }

    public void setTechingPermission(boolean techingPermission) {
        this.techingPermission = techingPermission;
    }

    public boolean hasSystemPermission() {
        return systemPermission;
    }

    public void setSystemPermission(boolean systemPermission) {
        this.systemPermission = systemPermission;
    }

    public int getLowestRank() {
        int rank = 0;
        if (this.roles != null) {
            rank = this.roles.stream().max(Comparator.comparing(TRole::getcRankId)).get().getcRankId();
        }
        return rank;
    }

    public int getHighestRank() {
        int rank = 0;
        if (this.roles != null) {
            rank = this.roles.stream().min(Comparator.comparing(TRole::getcRankId)).get().getcRankId();
        }
        return rank;
    }

    public boolean hasSystemRank() {
        boolean ret = false;
        if (this.roles != null) {
            ret =  this.roles.stream().filter(r -> (r.getcRankId() == 4)).limit(1).count() > 0;
        }
        return ret;
    }

    public boolean hasSystemRankOnly() {
        boolean ret = false;
        if (this.roles != null && this.roles.size() == 1) {
            ret = this.roles.get(0).getcRankId() == 4;
        }
        return ret;
    }

//    public boolean hasPermissionById(String funcId) {
//        boolean ret = false;
//        if (this.roles != null) {
//            ret =  this.roles.stream().filter(r -> (
//                        r.getAllFuncIds().stream().filter(f -> f == funcId).limit(1).count() > 0
//                    )).limit(1).count() > 0;
//        }
//        return ret;
//    }
//
}