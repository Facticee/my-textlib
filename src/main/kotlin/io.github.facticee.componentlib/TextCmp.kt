package io.github.facticee.textlib

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

