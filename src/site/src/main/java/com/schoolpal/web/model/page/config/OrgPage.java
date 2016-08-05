package com.schoolpal.web.model.page.config;

import java.util.List;

import com.schoolpal.web.model.page.MenuPage;
import com.schoolpal.web.model.page.OrgRow;

public class OrgPage extends MenuPage {
	
	private List<OrgRow> orgRows;

	public List<OrgRow> getOrgRows() {
		return orgRows;
	}
	public void setOrgRows(List<OrgRow> orgRows) {
		this.orgRows = orgRows;
	}

}
