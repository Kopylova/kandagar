package com.kandagar.rls.service;

import java.util.List;

import com.kandagar.rls.domain.criteria.RoleSearchCriteria;
import com.kandagar.rls.model.RoleModel;

public interface RoleService extends BaseService<RoleModel, RoleSearchCriteria > {

	 List<RoleModel> getAll();
}
