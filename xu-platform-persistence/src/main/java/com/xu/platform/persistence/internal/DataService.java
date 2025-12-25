package com.xu.platform.persistence.internal;

import com.xu.platform.persistence.IDataService;
import com.xu.platform.persistence.model.IPObject;
import com.xu.platform.persistence.model.IPObjectList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class DataService implements IDataService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <T extends IPObject> IPObjectList<T> sqlSearch(String sql) {
        return null;
    }
}
