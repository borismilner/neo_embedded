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

`"C:\Program Files\Java\jdk1.8.0_211\bin\java.exe" -javaagent:C:\Users\borismi\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\193.6015.39\lib\idea_rt.jar=5844:C:\Users\borismi\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\193.6015.39\bin -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_211\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_211\jre\lib\rt.jar;C:\projects\neo_embedded\target\classes;C:\Users\borismi\.m2\repository\org\neo4j\test\neo4j-harness\3.5.14\neo4j-harness-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j\3.5.14\neo4j-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-lucene-index\3.5.14\neo4j-lucene-index-3.5.14.jar;C:\Users\borismi\.m2\repository\org\apache\lucene\lucene-analyzers-common\5.5.5\lucene-analyzers-common-5.5.5.jar;C:\Users\borismi\.m2\repository\org\apache\lucene\lucene-queryparser\5.5.5\lucene-queryparser-5.5.5.jar;C:\Users\borismi\.m2\repository\org\apache\lucene\lucene-codecs\5.5.5\lucene-codecs-5.5.5.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-fulltext-index\3.5.14\neo4j-fulltext-index-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-graph-algo\3.5.14\neo4j-graph-algo-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-udc\3.5.14\neo4j-udc-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-data-collector\3.5.14\neo4j-data-collector-3.5.14.jar;C:\Users\borismi\.m2\repository\org\scala-lang\scala-library\2.11.12\scala-library-2.11.12.jar;C:\Users\borismi\.m2\repository\org\scala-lang\scala-reflect\2.11.12\scala-reflect-2.11.12.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-parser-3.5\3.5.14\neo4j-parser-3.5-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-ast-3.5\3.5.14\neo4j-ast-3.5-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-expressions-3.5\3.5.14\neo4j-expressions-3.5-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-rewriting-3.5\3.5.14\neo4j-rewriting-3.5-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher\3.5.14\neo4j-cypher-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-graph-matching\3.1.9\neo4j-graph-matching-3.1.9.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-codegen\3.5.14\neo4j-codegen-3.5.14.jar;C:\Users\borismi\.m2\repository\org\ow2\asm\asm\6.2\asm-6.2.jar;C:\Users\borismi\.m2\repository\org\ow2\asm\asm-util\6.2\asm-util-6.2.jar;C:\Users\borismi\.m2\repository\org\ow2\asm\asm-analysis\6.2\asm-analysis-6.2.jar;C:\Users\borismi\.m2\repository\org\ow2\asm\asm-tree\6.2\asm-tree-6.2.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-compiler-2.3\2.3.12\neo4j-cypher-compiler-2.3-2.3.12.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-frontend-2.3\2.3.12\neo4j-cypher-frontend-2.3-2.3.12.jar;C:\Users\borismi\.m2\repository\com\googlecode\concurrentlinkedhashmap\concurrentlinkedhashmap-lru\1.4.2\concurrentlinkedhashmap-lru-1.4.2.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-compiler-3.1\3.1.9\neo4j-cypher-compiler-3.1-3.1.9.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-frontend-3.1\3.1.9\neo4j-cypher-frontend-3.1-3.1.9.jar;C:\Users\borismi\.m2\repository\com\github\ben-manes\caffeine\caffeine\2.3.3\caffeine-2.3.3.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-planner-3.4\3.4.17\neo4j-cypher-planner-3.4-3.4.17.jar;C:\Users\borismi\.m2\repository\org\neo4j\openCypher-frontend-1\3.4.17\openCypher-frontend-1-3.4.17.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-util-3.4\3.4.17\neo4j-cypher-util-3.4-3.4.17.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-expression-3.4\3.4.17\neo4j-cypher-expression-3.4-3.4.17.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-ir-3.4\3.4.17\neo4j-cypher-ir-3.4-3.4.17.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-logical-plans-3.4\3.4.17\neo4j-cypher-logical-plans-3.4-3.4.17.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-planner-spi-3.4\3.4.17\neo4j-cypher-planner-spi-3.4-3.4.17.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-legacy\3.5.14\neo4j-legacy-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-util-3.5\3.5.14\neo4j-util-3.5-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-planner-3.5\3.5.14\neo4j-cypher-planner-3.5-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-ir-3.5\3.5.14\neo4j-cypher-ir-3.5-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-front-end-3.5\3.5.14\neo4j-front-end-3.5-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-logical-plans-3.5\3.5.14\neo4j-cypher-logical-plans-3.5-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-planner-spi-3.5\3.5.14\neo4j-cypher-planner-spi-3.5-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-runtime-util\3.5.14\neo4j-cypher-runtime-util-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-cypher-interpreted-runtime\3.5.14\neo4j-cypher-interpreted-runtime-3.5.14.jar;C:\Users\borismi\.m2\repository\org\parboiled\parboiled-scala_2.11\1.1.7\parboiled-scala_2.11-1.1.7.jar;C:\Users\borismi\.m2\repository\org\parboiled\parboiled-core\1.1.7\parboiled-core-1.1.7.jar;C:\Users\borismi\.m2\repository\net\sf\opencsv\opencsv\2.3\opencsv-2.3.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-jmx\3.5.14\neo4j-jmx-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-bolt\3.5.14\neo4j-bolt-3.5.14.jar;C:\Users\borismi\.m2\repository\io\netty\netty-all\4.1.43.Final\netty-all-4.1.43.Final.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-consistency-check\3.5.14\neo4j-consistency-check-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\app\neo4j-server\3.5.14\neo4j-server-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-security\3.5.14\neo4j-security-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-dbms\3.5.14\neo4j-dbms-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-import-tool\3.5.14\neo4j-import-tool-3.5.14.jar;C:\Users\borismi\.m2\repository\org\jprocesses\jProcesses\1.6.4\jProcesses-1.6.4.jar;C:\Users\borismi\.m2\repository\com\profesorfalken\WMI4Java\1.6.1\WMI4Java-1.6.1.jar;C:\Users\borismi\.m2\repository\com\profesorfalken\jPowerShell\1.9\jPowerShell-1.9.jar;C:\Users\borismi\.m2\repository\org\apache\commons\commons-compress\1.19\commons-compress-1.19.jar;C:\Users\borismi\.m2\repository\org\neo4j\licensing-proxy\zstd-proxy\3.5.14\zstd-proxy-3.5.14.jar;C:\Users\borismi\.m2\repository\com\github\luben\zstd-jni\1.3.8-6\zstd-jni-1.3.8-6.jar;C:\Program Files\Java\jdk1.8.0_211\lib\tools.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-command-line\3.5.14\neo4j-command-line-3.5.14.jar;C:\Users\borismi\.m2\repository\org\apache\commons\commons-text\1.4\commons-text-1.4.jar;C:\Users\borismi\.m2\repository\org\neo4j\server-api\3.5.14\server-api-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\3rdparty\javax\ws\rs\jsr311-api\1.1.2.r612\jsr311-api-1.1.2.r612.jar;C:\Users\borismi\.m2\repository\org\neo4j\client\neo4j-browser\3.2.26\neo4j-browser-3.2.26.jar;C:\Users\borismi\.m2\repository\org\eclipse\jetty\jetty-server\9.4.17.v20190418\jetty-server-9.4.17.v20190418.jar;C:\Users\borismi\.m2\repository\javax\servlet\javax.servlet-api\3.1.0\javax.servlet-api-3.1.0.jar;C:\Users\borismi\.m2\repository\org\eclipse\jetty\jetty-http\9.4.17.v20190418\jetty-http-9.4.17.v20190418.jar;C:\Users\borismi\.m2\repository\org\eclipse\jetty\jetty-util\9.4.17.v20190418\jetty-util-9.4.17.v20190418.jar;C:\Users\borismi\.m2\repository\org\eclipse\jetty\jetty-io\9.4.17.v20190418\jetty-io-9.4.17.v20190418.jar;C:\Users\borismi\.m2\repository\org\eclipse\jetty\jetty-webapp\9.4.17.v20190418\jetty-webapp-9.4.17.v20190418.jar;C:\Users\borismi\.m2\repository\org\eclipse\jetty\jetty-xml\9.4.17.v20190418\jetty-xml-9.4.17.v20190418.jar;C:\Users\borismi\.m2\repository\org\eclipse\jetty\jetty-servlet\9.4.17.v20190418\jetty-servlet-9.4.17.v20190418.jar;C:\Users\borismi\.m2\repository\org\eclipse\jetty\jetty-security\9.4.17.v20190418\jetty-security-9.4.17.v20190418.jar;C:\Users\borismi\.m2\repository\com\sun\jersey\jersey-server\1.19.3\jersey-server-1.19.3.jar;C:\Users\borismi\.m2\repository\com\sun\jersey\jersey-servlet\1.19.3\jersey-servlet-1.19.3.jar;C:\Users\borismi\.m2\repository\commons-configuration\commons-configuration\1.10\commons-configuration-1.10.jar;C:\Users\borismi\.m2\repository\commons-lang\commons-lang\2.6\commons-lang-2.6.jar;C:\Users\borismi\.m2\repository\commons-io\commons-io\2.6\commons-io-2.6.jar;C:\Users\borismi\.m2\repository\org\codehaus\jackson\jackson-jaxrs\1.9.13\jackson-jaxrs-1.9.13.jar;C:\Users\borismi\.m2\repository\org\codehaus\jackson\jackson-core-asl\1.9.13\jackson-core-asl-1.9.13.jar;C:\Users\borismi\.m2\repository\org\codehaus\jackson\jackson-mapper-asl\1.9.13\jackson-mapper-asl-1.9.13.jar;C:\Users\borismi\.m2\repository\org\bouncycastle\bcprov-jdk15on\1.60\bcprov-jdk15on-1.60.jar;C:\Users\borismi\.m2\repository\org\bouncycastle\bcpkix-jdk15on\1.60\bcpkix-jdk15on-1.60.jar;C:\Users\borismi\.m2\repository\javax\activation\activation\1.1.1\activation-1.1.1.jar;C:\Users\borismi\.m2\repository\org\glassfish\jaxb\jaxb-runtime\2.3.2\jaxb-runtime-2.3.2.jar;C:\Users\borismi\.m2\repository\jakarta\xml\bind\jakarta.xml.bind-api\2.3.2\jakarta.xml.bind-api-2.3.2.jar;C:\Users\borismi\.m2\repository\org\glassfish\jaxb\txw2\2.3.2\txw2-2.3.2.jar;C:\Users\borismi\.m2\repository\com\sun\istack\istack-commons-runtime\3.0.8\istack-commons-runtime-3.0.8.jar;C:\Users\borismi\.m2\repository\org\jvnet\staxex\stax-ex\1.8.1\stax-ex-1.8.1.jar;C:\Users\borismi\.m2\repository\com\sun\xml\fastinfoset\FastInfoset\1.2.16\FastInfoset-1.2.16.jar;C:\Users\borismi\.m2\repository\jakarta\activation\jakarta.activation-api\1.2.1\jakarta.activation-api-1.2.1.jar;C:\Users\borismi\.m2\repository\javax\xml\bind\jaxb-api\2.3.0\jaxb-api-2.3.0.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-common\3.5.14\neo4j-common-3.5.14-tests.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-kernel\3.5.14\neo4j-kernel-3.5.14-tests.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-annotation-processors\3.5.14\neo4j-annotation-processors-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-graphdb-api\3.5.14\neo4j-graphdb-api-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-resource\3.5.14\neo4j-resource-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-procedure-api\3.5.14\neo4j-procedure-api-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-kernel-api\3.5.14\neo4j-kernel-api-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-diagnostics\3.5.14\neo4j-diagnostics-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-common\3.5.14\neo4j-common-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-values\3.5.14\neo4j-values-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-collections\3.5.14\neo4j-collections-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-io\3.5.14\neo4j-io-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-csv\3.5.14\neo4j-csv-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-logging\3.5.14\neo4j-logging-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-lucene-upgrade\3.5.14\neo4j-lucene-upgrade-3.5.14.jar;C:\Users\borismi\.m2\repository\org\apache\lucene\lucene-core\5.5.5\lucene-core-5.5.5.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-configuration\3.5.14\neo4j-configuration-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-index\3.5.14\neo4j-index-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-spatial-index\3.5.14\neo4j-spatial-index-3.5.14.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-ssl\3.5.14\neo4j-ssl-3.5.14.jar;C:\Users\borismi\.m2\repository\org\eclipse\collections\eclipse-collections\9.2.0\eclipse-collections-9.2.0.jar;C:\Users\borismi\.m2\repository\org\eclipse\collections\eclipse-collections-api\9.2.0\eclipse-collections-api-9.2.0.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-io\3.5.14\neo4j-io-3.5.14-tests.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-unsafe\3.5.14\neo4j-unsafe-3.5.14.jar;C:\Users\borismi\.m2\repository\org\apache\commons\commons-lang3\3.8\commons-lang3-3.8.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-concurrent\3.5.14\neo4j-concurrent-3.5.14.jar;C:\Users\borismi\.m2\repository\com\sun\jersey\jersey-client\1.19.3\jersey-client-1.19.3.jar;C:\Users\borismi\.m2\repository\com\sun\jersey\jersey-core\1.19.3\jersey-core-1.19.3.jar;C:\Users\borismi\.m2\repository\org\neo4j\app\neo4j-server\3.5.14\neo4j-server-3.5.14-tests.jar;C:\Users\borismi\.m2\repository\commons-codec\commons-codec\1.11\commons-codec-1.11.jar;C:\Users\borismi\.m2\repository\org\apache\httpcomponents\httpclient\4.5.6\httpclient-4.5.6.jar;C:\Users\borismi\.m2\repository\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;C:\Users\borismi\.m2\repository\org\apache\httpcomponents\httpcore\4.4.10\httpcore-4.4.10.jar;C:\Users\borismi\.m2\repository\org\neo4j\neo4j-kernel\3.5.14\neo4j-kernel-3.5.14.jar;C:\Users\borismi\.m2\repository\org\apache\logging\log4j\log4j-core\2.13.0\log4j-core-2.13.0.jar;C:\Users\borismi\.m2\repository\org\apache\logging\log4j\log4j-api\2.13.0\log4j-api-2.13.0.jar" server.ServerManager
 14:40:38 [main] INFO - Listening for REST commands on port 2104
 14:40:53 [Thread-2] DEBUG - Got ping, ponging back.
 14:41:05 [Thread-2] INFO - Using configurations in C:\projects\neo_embedded/conf/neo4j.conf
 פבר 08, 2020 2:41:14 PM com.sun.jersey.server.impl.application.WebApplicationImpl _initiate
 INFO: Initiating Jersey application, version 'Jersey: 1.19.3 10/24/2016 03:43 PM'
 פבר 08, 2020 2:41:14 PM com.sun.jersey.server.impl.application.WebApplicationImpl _initiate
 INFO: Initiating Jersey application, version 'Jersey: 1.19.3 10/24/2016 03:43 PM'
 פבר 08, 2020 2:41:15 PM com.sun.jersey.server.impl.application.WebApplicationImpl _initiate
 INFO: Initiating Jersey application, version 'Jersey: 1.19.3 10/24/2016 03:43 PM'
 14:41:15 [Thread-2] DEBUG - Neo4j started on port 7687
 14:41:19 [Thread-2] INFO - Using configurations in C:\projects\neo_embedded/conf/neo4j.conf
 פבר 08, 2020 2:41:24 PM com.sun.jersey.server.impl.application.WebApplicationImpl _initiate
 INFO: Initiating Jersey application, version 'Jersey: 1.19.3 10/24/2016 03:43 PM'
 פבר 08, 2020 2:41:24 PM com.sun.jersey.server.impl.application.WebApplicationImpl _initiate
 INFO: Initiating Jersey application, version 'Jersey: 1.19.3 10/24/2016 03:43 PM'
 פבר 08, 2020 2:41:24 PM com.sun.jersey.server.impl.application.WebApplicationImpl _initiate
 INFO: Initiating Jersey application, version 'Jersey: 1.19.3 10/24/2016 03:43 PM'
 14:41:24 [Thread-2] DEBUG - Neo4j started on port 7688
 14:41:33 [Thread-2] DEBUG - Neo4j stopped on port 7688
 14:41:43 [Thread-2] DEBUG - Neo4j stopped on port 7687`

## Current list of dependencies
Note: some the following may be unused - I did not have time to minimize this list.  
Please notice the **conf** folder, it is hard-coded.
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
    * neo4j.conf
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
    * apoc-3.5.0.6-all.jar
* scala-library-2.11.12.jar
* scala-reflect-2.11.12.jar
* server-api-3.5.14.jar
* stax-ex-1.8.1.jar
* tools.jar
* txw2-2.3.2.jar
* WMI4Java-1.6.1.jar
* zstd-jni-1.3.8-6.jar
* zstd-proxy-3.5.14.jar*
