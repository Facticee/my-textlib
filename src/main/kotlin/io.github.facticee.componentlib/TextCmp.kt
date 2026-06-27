package io.github.facticee.componentlib

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent


fun cmp(
    content: String,
    color: TextColor = NamedTextColor.GRAY,
    bold: Boolean = false,
    italic: Boolean = false,
    strikethrough: Boolean = false,
    underlined: Boolean = false
): Component {
    return text(content).style { builder ->
        builder.color(color)
        builder.decoration(TextDecoration.BOLD, bold)
        builder.decoration(TextDecoration.ITALIC, italic)
        builder.decoration(TextDecoration.STRIKETHROUGH, strikethrough)
        builder.decoration(TextDecoration.UNDERLINED, underlined)
    }
}

fun cmp(
    content: String,
    hex: String,
    bold: Boolean = false,
    italic: Boolean = false,
    strikethrough: Boolean = false,
    underlined: Boolean = false
): Component {
    // Falls das # nicht vorhanden ist
    val formattedHex = if (hex.startsWith("#")) hex else "#$hex"
    val color = TextColor.fromHexString(formattedHex) ?: NamedTextColor.GRAY
    return cmp(content, color, bold, italic, strikethrough, underlined)
}

// shortcut (irgendein string + .toCmp()) bsp: "hi".toCmp(NamedTextColor.RED)
fun String.toCmp(
    color: TextColor = NamedTextColor.GRAY,
    bold: Boolean = false,
    italic: Boolean = false,
    strikethrough: Boolean = false,
    underlined: Boolean = false
): Component = cmp(this, color, bold, italic, strikethrough, underlined)

// Shortcut für Hex-Codes: "hi".toCmp("FF0000")
fun String.toCmp(
    hex: String,
    bold: Boolean = false,
    italic: Boolean = false,
    strikethrough: Boolean = false,
    underlined: Boolean = false
): Component = cmp(this, hex, bold, italic, strikethrough, underlined)

// .append -> +
operator fun Component.plus(other: Component): Component = this.append(other)
operator fun Component.plus(other: String): Component = this.append(other.toCmp())
operator fun String.plus(other: Component): Component = this.toCmp() + other

// Hover text
fun Component.addHover(display: Component): Component =
    this.hoverEvent(HoverEvent.showText(display))

fun Component.addHoverText(hover: String): Component =
    this.addHover(hover.toCmp())


fun Component.addUrl(url: String): Component = this.clickEvent(ClickEvent.openUrl(url))
fun Component.addCommand(command: String): Component = this.clickEvent(ClickEvent.runCommand(command))
fun Component.addSuggest(suggestion: String): Component = this.clickEvent(ClickEvent.suggestCommand(suggestion))
fun Component.addCopy(copyPrompt: String): Component = this.clickEvent(ClickEvent.copyToClipboard(copyPrompt))