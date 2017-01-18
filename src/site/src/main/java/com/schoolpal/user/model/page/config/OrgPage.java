package com.schoolpal.user.model.page.config;

import java.util.List;

import com.schoolpal.user.model.page.MenuPage;
import com.schoolpal.user.model.page.OrgRow;

public class OrgPage extends MenuPage {
	
	private List<OrgRow> orgRows;

	public List<OrgRow> getOrgRows() {
		return orgRows;
	}
	public void setOrgRows(List<OrgRow> orgRows) {
		this.orgRows = orgRows;
	}

}
