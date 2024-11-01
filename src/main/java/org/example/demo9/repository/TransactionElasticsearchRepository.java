package org.example.demo9.repository;

import org.example.demo9.model.Transaction;
import org.example.demo9.model.TransactionDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionElasticsearchRepository extends ElasticsearchRepository<TransactionDocument, Long> {
    List<TransactionDocument> findBySourceAccountIdOrDestinationAccountId(Long sourceId, Long destId);
    List<TransactionDocument> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
    List<TransactionDocument> findByStatus(String status);
    List<TransactionDocument> findByAmountGreaterThan(BigDecimal amount);
}

