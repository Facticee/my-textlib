# componentlib [![](https://jitpack.io/v/Facticee/my-textlib.svg)](https://jitpack.io/#Facticee/my-textlib)

A lightweight Kotlin library for the **Kyori Adventure API**. Built for  Minecraft development.

---

## Features

* Build Components in one line with cmp(...) -> color, bold, italic, strikethrough, underlined
* Hex color support ("FF0000" or "#FF0000")
* String extensions: "hi".toCmp(NamedTextColor.RED) / "hi".toCmp("FF0000")
* Operator adding: use + to append Components and Strings (+ instead of .append)
* Click & hover shortcuts: .addHover(), .addHoverText(), .addUrl(), .addCommand(), .addSuggest(), .addCopy()

## Example
```
val message = "Welcome".toCmp(NamedTextColor.GOLD, bold = true) +
    " to the server!".toCmp("FFAA00")
        .addHoverText("Click to view rules")
        .addUrl("https://example.com/rules")

player.sendMessage(message)

```

---

## Setup
 
This library is hosted on [JitPack](https://jitpack.io/#Facticee/my-textlib). Replace `Tag` with the version/tag you want to use (e.g. a release tag or commit hash ; <br> example release tag that i use: " 1.0.0 ").
 
### Gradle (Groovy DSL)
 
`settings.gradle`:
 
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
 
`build.gradle`:
 
```groovy
dependencies {
    implementation 'com.github.Facticee:my-textlib:Tag'
}
```
<br>

### Gradle (Kotlin DSL)
 
`settings.gradle.kts`:
 
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```
 
`build.gradle.kts`:
 
```kotlin
dependencies {
    implementation("com.github.Facticee:my-textlib:Tag")
}
```
<br>

### Maven
 
`pom.xml`
 
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
 
`dependency`
 
```xml
<dependency>
    <groupId>com.github.Facticee</groupId>
    <artifactId>my-textlib</artifactId>
    <version>Tag</version>
</dependency>
```
<br>

## Local Setup (without JitPack

If you don't want to use JitPack (e.g. offline builds, your own forks, or just don't want to wait on JitPack build times), you can also include the jar locally.

1. Download the jar from the [Releases](https://github.com/Facticee/my-textlib/releases) page (or build it yourself with `./gradlew build`).
2. Put it somewhere in your project, e.g. a `libs/` folder.

#### Gradle (Kotlin DSL)

```kotlin
dependencies {
    implementation(files("libs/my-textlib-1.0.0.jar"))
}
```

#### Gradle (Groovy DSL)

```groovy
dependencies {
    implementation files('libs/my-textlib-1.0.0.jar')
}
```

> Note: if the library itself has dependencies (e.g. Kotlin stdlib, Adventure API), you'll need to add those as separate `implementation(...)` lines too, since `files(...)` doesn't resolve transitive dependencies.

#### Maven

Local jars need to be added via a `system`-scope dependency or a local repo:

```xml
<dependency>
    <groupId>com.github.Facticee</groupId>
    <artifactId>my-textlib</artifactId>
    <version>1.0.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/libs/my-textlib-1.0.0.jar</systemPath>
</dependency>
```

> `system` scope is more of a workaround — cleaner would be `mvn install:install-file` to install the jar into your local `.m2` repo if you want to do it properly.
 
---
 
## License

[CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
 
