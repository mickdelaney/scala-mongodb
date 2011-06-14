resolvers += "Web plugin repo" at "http://siasia.github.com/maven2"

//Following means libraryDependencies += "com.github.siasia" %% "xsbt-web-plugin" % <sbt version>

libraryDependencies <+= sbtVersion("com.github.siasia" %% "xsbt-web-plugin" % _)

libraryDependencies += "org.scala-tools.testing" %% "scalacheck" % "1.8" % "test"

resolvers += "less is" at "http://repo.lessis.me"

libraryDependencies += "me.lessis" %% "sbt-growl-plugin" % "0.1.0"