# Cassandra Phantom Demo

Sample code showing how to test [Phantom](https://github.com/outworkers/phantom) code using an embedded Cassandra
database managed by the phantom-sbt plugin.

While the [Outworkers' blog post](http://outworkers.com/blog/post/phantom-tips-tip2-testing-with-phantom-sbt) does
describe how to use phantom-sbt in your project it doesn't supply a working sample
project. This repo aims at bridging that gap with one project using a single table Cassandra database. I followed the
pattern from the original blog post that organizes the table into 2 classes and injecting the appropriate database (in
 this case the test database). With that setup the `SensorDatabaseTest` first calls the table's `store()` followed by
 `getById()`. Running it relies solely on sbt, which starts the embedded database in `beforeAll()` and shuts down the
 session in `afterAll()`:
 
    $ sbt test
    [info] Loading project definition from /Users/dam/Code/OSS/phantom-demo/project
    [info] Set current project to root (in build file:/Users/dam/Code/OSS/phantom-demo/)
    Initialize EmbeddedCassandra singleton.
    SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
    SLF4J: Defaulting to no-operation (NOP) logger implementation
    SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
    [info] Starting Cassandra in embedded mode with default configuration.
    [info] Compiling 3 Scala sources to /Users/dam/Code/OSS/phantom-demo/target/scala-2.11/classes...
    [info] Compiling 3 Scala sources to /Users/dam/Code/OSS/phantom-demo/target/scala-2.11/test-classes...
    [info] SensorDatabaseTest:
    [info] - store/retrieve
    [info] ScalaCheck
    [info] Passed: Total 0, Failed 0, Errors 0, Passed 0
    [info] ScalaTest
    [info] Run completed in 6 seconds, 592 milliseconds.
    [info] Total number of tests run: 1
    [info] Suites: completed 1, aborted 0
    [info] Tests: succeeded 1, failed 0, canceled 0, ignored 0, pending 0
    [info] All tests passed.
    [info] Passed: Total 1, Failed 0, Errors 0, Passed 1
    [success] Total time: 13 s, completed Jul 3, 2016 5:28:26 PM 

