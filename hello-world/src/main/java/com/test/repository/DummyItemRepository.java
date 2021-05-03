package com.test.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DummyItemRepository implements ItemRepository {

    @Override
    public long count() {
        return 123L;
    }

}
