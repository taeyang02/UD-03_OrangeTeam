package com.orange.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationOption {

    private int pageNumber;
    private int pageSize;
    private Sort sort;

}
