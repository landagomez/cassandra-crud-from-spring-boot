package com.fiserv.training.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.fiserv.training.model.Test;

public interface TestRepository extends CassandraRepository<Test, Long> {

}
