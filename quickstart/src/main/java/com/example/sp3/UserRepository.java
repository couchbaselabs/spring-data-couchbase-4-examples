package com.example.sp3;

import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CouchbaseRepository<User, String> {

    @ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
    List<User> findByName(String name);


    /**
     * By default, all queries have a Scan Consistency NOT_BOUNDED
     * IN this case we do want the method findall
     * @return
     */
    @Override
    @ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
    List<User> findAll();
}
