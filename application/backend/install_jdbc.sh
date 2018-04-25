# Should only be used when first adding the JDBC dependancy - delete otherwise

mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=11.2.0 -Dpackaging=jar -Dfile=../../../../Desktop/ojdbc14.jar
