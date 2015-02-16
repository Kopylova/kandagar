package com.kandagar.rls.converter;

import java.util.List;
import java.util.Set;

public interface ModelDaoConverter<T, K> {
    
    public List<T> convertToModelList(List<K> daoList) ;
    
    public List<K> convertToDaoList(List<T> modelList) ;
    
    public Set<T> convertToModelSet(Set<K> daoSet) ;
    
    public Set<K> convertToDaoSet(Set<T> modelSet) ;

    T convertToModel(K dao);

    K convertToDao(T model);
}
