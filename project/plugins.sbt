// http://outworkers.com/blog/post/phantom-tips-tip2-testing-with-phantom-sbt
resolvers ++= Seq(
  Resolver.bintrayRepo("websudos", "oss-releases"),
  Resolver.url("Outworkers OSS", url("http://dl.bintray.com/websudos/oss-releases"))(Resolver.ivyStylePatterns)
)

addSbtPlugin("com.websudos" %% "phantom-sbt" % "1.22.0")