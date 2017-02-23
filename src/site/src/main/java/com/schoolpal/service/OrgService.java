package com.schoolpal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.TOrgMapper;
import com.schoolpal.db.inf.TRoleMapper;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TRole;

@Service
public class OrgService {

	@Autowired
	private TOrgMapper orgDao; 

	@Autowired
	private LogService logServ;

	public List<TOrg> getOrgListByRootId(String id){
		List<TOrg> orgRows = orgDao.selectAll();
		List<TOrg> results = new ArrayList<TOrg>();

		for (TOrg row : orgRows) {
			if (row.getcId().equals(id)) {
				row.setLevel(0);
				results.add(row);
				break;
			}
		}

		int ind = 0;
		while (ind < results.size()) {
			int offset = 0;
			TOrg currRow = results.get(ind);

			for (TOrg row : orgRows) {
				if (row.getcParentId().equals(currRow.getcId()) && !results.contains(row)) {
					row.setLevel(currRow.getLevel() + 1);
					results.add(ind + (++offset), row);
					currRow.setParent(true);
				}
			}

			if (ind < results.size()) {
				ind++;
			}
		}
		return results;
	}

	public List<String> getOrgIdListByRootId(String id){
		List<TOrg> orgRows = orgDao.selectAllIds();
		List<String> results = new ArrayList<String>();

		for (TOrg row : orgRows) {
			if (row.getcId().equals(id)) {
				results.add(row.getcId());
				break;
			}
		}

		int ind = 0;
		while (ind < results.size()) {
			int offset = 0;
			String currId = results.get(ind);

			for (TOrg row : orgRows) {
				if (row.getcParentId().equals(currId) && !results.contains(row.getcId())) {
					results.add(ind + (++offset), row.getcId());
				}
			}

			if (ind < results.size()) {
				ind++;
			}
		}
		return results;
	}

	
}
