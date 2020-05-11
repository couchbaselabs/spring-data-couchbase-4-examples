package com.example.sp3;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.index.CompositeQueryIndex;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
@Data
@ToString
public class User {

    @Id
    private String id;
    private String name;
    private String position;
    private String description;
}
