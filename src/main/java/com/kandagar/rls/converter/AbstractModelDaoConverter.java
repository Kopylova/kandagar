package com.kandagar.rls.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

public abstract class AbstractModelDaoConverter<T, K> implements ModelDaoConverter<T, K>{
    
    @Override
    public List<T> convertToModelList(List<K> daoList) {
        List<T> modelList = new ArrayList<>();
        if( CollectionUtils.isNotEmpty( daoList ) ) {
        	for (K dao : daoList) {
        		modelList.add(convertToModel(dao));
        	}
        }
        return modelList;
    }
    
    @Override
    public List<K> convertToDaoList(List<T> modelList) {
        List<K> daoList = new ArrayList<>();
        if( CollectionUtils.isNotEmpty( modelList ) ) {
        	for (T model : modelList) {
        		daoList.add(convertToDao(model));
        	}
        }
        return daoList;
    }
    
    @Override
    public Set<T> convertToModelSet(Set<K> daoSet) {
        Set<T> modelList = new HashSet<>();
        if( CollectionUtils.isNotEmpty( daoSet ) ) {
        	for (K dao : daoSet) {
        		modelList.add(convertToModel(dao));
        	}
        }
        return modelList;
    }
    
    @Override
    public Set<K> convertToDaoSet(Set<T> modelSet) {
        Set<K> daoList = new HashSet<>();
        if( CollectionUtils.isNotEmpty( modelSet ) ) {
        	for (T model : modelSet) {
        		daoList.add(convertToDao(model));
        	}
        }
        return daoList;
    }

}
