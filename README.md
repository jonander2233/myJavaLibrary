`build.gradle`

```gradle
repositories {
    mavenCentral()
    maven ("https://jitpack.io")
}
dependencies {
    implementation ("com.github.jonander2233:myJavaLibrary:1.1.5")
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
            <version>1.1.5</version>
        </dependency>
    </dependencies>
```
