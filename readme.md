# Embedded Neo4j - At Your Service  
  
## Features  
- [x] Arbitrary number of parallel servers
- [x] Supports external neo4j.conf  
- [x] Supports plugins
- [x] REST API
- [x] Logging using log4j

## End Points
1. [POST] */start* : shall start a server on port specified in request-body.
1. [POST] */stop* : shall stop the server on port specified in request-body.
1. [GET] */terminate* : shall stop all servers and terminate REST server as well.
1. [GET] */ping* : shall reply with "pong".

## Current list of dependencies
Note: some the following jars may be unused - I did not have time to minimize this list.
* activation-1.1.1.jar
* asm-6.2.jar
* asm-analysis-6.2.jar
* asm-tree-6.2.jar
* asm-util-6.2.jar
* bcpkix-jdk15on-1.60.jar
* bcprov-jdk15on-1.60.jar
* caffeine-2.3.3.jar
* commons-codec-1.11.jar
* commons-compress-1.19.jar
* commons-configuration-1.10.jar
* commons-io-2.6.jar
* commons-lang-2.6.jar
* commons-lang3-3.8.jar
* commons-logging-1.2.jar
* commons-text-1.4.jar
* concurrentlinkedhashmap-lru-1.4.2.jar
* conf/
* eclipse-collections-9.2.0.jar
* eclipse-collections-api-9.2.0.jar
* FastInfoset-1.2.16.jar
* httpclient-4.5.6.jar
* httpcore-4.4.10.jar
* istack-commons-runtime-3.0.8.jar
* jackson-core-asl-1.9.13.jar
* jackson-jaxrs-1.9.13.jar
* jackson-mapper-asl-1.9.13.jar
* jakarta.activation-api-1.2.1.jar
* jakarta.xml.bind-api-2.3.2.jar
* javax.servlet-api-3.1.0.jar
* jaxb-api-2.3.0.jar
* jaxb-runtime-2.3.2.jar
* jersey-client-1.19.3.jar
* jersey-core-1.19.3.jar
* jersey-server-1.19.3.jar
* jersey-servlet-1.19.3.jar
* jetty-http-9.4.17.v20190418.jar
* jetty-io-9.4.17.v20190418.jar
* jetty-security-9.4.17.v20190418.jar
* jetty-server-9.4.17.v20190418.jar
* jetty-servlet-9.4.17.v20190418.jar
* jetty-util-9.4.17.v20190418.jar
* jetty-webapp-9.4.17.v20190418.jar
* jetty-xml-9.4.17.v20190418.jar
* jPowerShell-1.9.jar
* jProcesses-1.6.4.jar
* jsr311-api-1.1.2.r612.jar
* log4j-1.2.12.jar
* log4j-api-2.13.0.jar
* log4j-core-2.13.0.jar
* lucene-analyzers-common-5.5.5.jar
* lucene-codecs-5.5.5.jar
* lucene-core-5.5.5.jar
* lucene-queryparser-5.5.5.jar
* meta_info.db
* neo_embedded.jar
* neo4j.conf
* neo4j-3.5.14.jar
* neo4j-annotation-processors-3.5.14.jar
* neo4j-ast-3.5-3.5.14.jar
* neo4j-bolt-3.5.14.jar
* neo4j-browser-3.2.26.jar
* neo4j-codegen-3.5.14.jar
* neo4j-collections-3.5.14.jar
* neo4j-command-line-3.5.14.jar
* neo4j-common-3.5.14.jar
* neo4j-common-3.5.14-tests.jar
* neo4j-concurrent-3.5.14.jar
* neo4j-configuration-3.5.14.jar
* neo4j-consistency-check-3.5.14.jar
* neo4j-csv-3.5.14.jar
* neo4j-cypher-3.5.14.jar
* neo4j-cypher-compiler-2.3-2.3.12.jar
* neo4j-cypher-compiler-3.1-3.1.9.jar
* neo4j-cypher-expression-3.4-3.4.17.jar
* neo4j-cypher-frontend-2.3-2.3.12.jar
* neo4j-cypher-frontend-3.1-3.1.9.jar
* neo4j-cypher-interpreted-runtime-3.5.14.jar
* neo4j-cypher-ir-3.4-3.4.17.jar
* neo4j-cypher-ir-3.5-3.5.14.jar
* neo4j-cypher-logical-plans-3.4-3.4.17.jar
* neo4j-cypher-logical-plans-3.5-3.5.14.jar
* neo4j-cypher-planner-3.4-3.4.17.jar
* neo4j-cypher-planner-3.5-3.5.14.jar
* neo4j-cypher-planner-spi-3.4-3.4.17.jar
* neo4j-cypher-planner-spi-3.5-3.5.14.jar
* neo4j-cypher-runtime-util-3.5.14.jar
* neo4j-cypher-util-3.4-3.4.17.jar
* neo4j-data-collector-3.5.14.jar
* neo4j-dbms-3.5.14.jar
* neo4j-diagnostics-3.5.14.jar
* neo4j-expressions-3.5-3.5.14.jar
* neo4j-front-end-3.5-3.5.14.jar
* neo4j-fulltext-index-3.5.14.jar
* neo4j-graph-algo-3.5.14.jar
* neo4j-graphdb-api-3.5.14.jar
* neo4j-graph-matching-3.1.9.jar
* neo4j-harness-3.5.14.jar
* neo4j-import-tool-3.5.14.jar
* neo4j-index-3.5.14.jar
* neo4j-io-3.5.14.jar
* neo4j-io-3.5.14-tests.jar
* neo4j-jmx-3.5.14.jar
* neo4j-kernel-3.5.14.jar
* neo4j-kernel-3.5.14-tests.jar
* neo4j-kernel-api-3.5.14.jar
* neo4j-legacy-3.5.14.jar
* neo4j-logging-3.5.14.jar
* neo4j-lucene-index-3.5.14.jar
* neo4j-lucene-upgrade-3.5.14.jar
* neo4j-parser-3.5-3.5.14.jar
* neo4j-procedure-api-3.5.14.jar
* neo4j-resource-3.5.14.jar
* neo4j-rewriting-3.5-3.5.14.jar
* neo4j-security-3.5.14.jar
* neo4j-server-3.5.14.jar
* neo4j-server-3.5.14-tests.jar
* neo4j-spatial-index-3.5.14.jar
* neo4j-ssl-3.5.14.jar
* neo4j-udc-3.5.14.jar
* neo4j-unsafe-3.5.14.jar
* neo4j-util-3.5-3.5.14.jar
* neo4j-values-3.5.14.jar
* netty-all-4.1.43.Final.jar
* opencsv-2.3.jar
* openCypher-frontend-1-3.4.17.jar
* original-neo_embedded-1.0.jar
* parboiled-core-1.1.7.jar
* parboiled-scala_2.11-1.1.7.jar
* plugins/
* scala-library-2.11.12.jar
* scala-reflect-2.11.12.jar
* server-api-3.5.14.jar
* stax-ex-1.8.1.jar
* tools.jar
* txw2-2.3.2.jar
* WMI4Java-1.6.1.jar
* zstd-jni-1.3.8-6.jar
* zstd-proxy-3.5.14.jar*
