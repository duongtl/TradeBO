package com.bo.trade.repository;

import com.bo.trade.entity.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Long> {
    ResultEntity findFirstByMethodIdOrderByIdDesc(Long methodId);
}
