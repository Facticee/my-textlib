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
 
---
 
## License

[CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
 
