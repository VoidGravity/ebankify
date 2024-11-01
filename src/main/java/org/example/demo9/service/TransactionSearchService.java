
package org.example.demo9.service;

import lombok.RequiredArgsConstructor;
import org.example.demo9.mapper.TransactionDocumentMapper;
import org.example.demo9.model.Transaction;
import org.example.demo9.model.TransactionDocument;
import org.example.demo9.repository.TransactionElasticsearchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionSearchService {
    private final TransactionElasticsearchRepository elasticsearchRepository;
    private final TransactionDocumentMapper documentMapper;

    public void indexTransaction(Transaction transaction) {
        TransactionDocument document = documentMapper.toDocument(transaction);
        elasticsearchRepository.save(document);
    }

    public List<Transaction> findTransactionsByAccount(Long accountId) {
        return elasticsearchRepository
                .findBySourceAccountIdOrDestinationAccountId(accountId, accountId)
                .stream()
                .map(documentMapper::toEntity)
                .collect(Collectors.toList());
    }

    public List<Transaction> findTransactionsByDateRange(LocalDateTime start, LocalDateTime end) {
        return elasticsearchRepository
                .findByTimestampBetween(start, end)
                .stream()
                .map(documentMapper::toEntity)
                .collect(Collectors.toList());
    }

    public List<Transaction> findTransactionsByStatus(String status) {
        return elasticsearchRepository
                .findByStatus(status)
                .stream()
                .map(documentMapper::toEntity)
                .collect(Collectors.toList());
    }
}