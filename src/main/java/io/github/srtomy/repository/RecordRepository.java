package io.github.srtomy.repository;

import io.github.srtomy.model.Record;

import java.util.List;

public interface RecordRepository extends Repository{
    void create(io.github.srtomy.model.Record record);
    List<Record>findTopRecords();
}
