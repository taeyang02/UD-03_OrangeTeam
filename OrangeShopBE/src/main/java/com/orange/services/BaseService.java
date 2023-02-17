package com.orange.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T, ID>{

    T create(T dto);
    T update(T dto);
    T delete(T dto);
    Page<?> fillAll(Pageable pageable);

    T fillById(ID id);
}
