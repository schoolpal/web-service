package com.schoolpal.service;

import com.schoolpal.db.inf.TFunctionMapper;
import com.schoolpal.db.model.TFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionService {

	@Autowired
	private TFunctionMapper funcDao; 

//	@Autowired
//	private LogService logServ;

	public List<TFunction> queryRootFuncList(){
		return funcDao.selectAllRoots();
	}

	public List<TFunction> queryAllFuncList(){
		return funcDao.selectAll();
	}

	public List<TFunction> queryFuncListByRootId(String id){
		return funcDao.selectManyByRootId(id);
	}
	
	public List<String> queryFuncIdListByRootId(String id){
		return funcDao.selectIdsByRootId(id);
	}
	
	public String getFunctionIdByActionPath(String actionPath){
		return funcDao.selectIdByAction(actionPath);
	}
}
