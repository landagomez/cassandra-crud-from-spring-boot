# Cassandra CRUD from Spring Boot

This is a simple example about a CRUD from Spring Boot using a Cassandra database.
  

## Premise

You should have an available Cassandra Database running.

  
### Actions on database side before execute the Java code:

        CREATE KEYSPACE "fiservkeyspace"  
            WITH REPLICATION =  
                {  
                    'class': 'SimpleStrategy',  
                    'replication_factor': 1
                }  
                AND durable_writes = true;
    
        CREATE TABLE "fiservkeyspace"."test"
                (
                    id int primary key,
                    name varchar
                );
    
        INSERT INTO "fiservkeyspace"."test" (id, name) VALUES (1, 'FirstName');
        
        INSERT INTO "fiservkeyspace"."test" (id, name) VALUES (2, 'SecondName');
        
        SELECT * FROM "fiservkeyspace"."test";


