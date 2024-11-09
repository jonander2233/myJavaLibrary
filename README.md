`build.gradle`

```gradle
repositories {
    mavenCentral()
    maven ("https://jitpack.io")
}
dependencies {
    implementation ("com.github.jonander2233:myJavaLibrary:1.0.0")
}
```
`Maven`
```
<repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
    <dependencies>
        <dependency>
            <groupId>com.github.jonander2233</groupId>
            <artifactId>myJavaLibrary</artifactId>
            <version>1.0.1</version>
        </dependency>
        <dependency>
            <groupId>net.datafaker</groupId>
            <artifactId>datafaker</artifactId>
            <version>2.4.1</version>
        </dependency>
    </dependencies>
```
