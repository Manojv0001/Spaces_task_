package com.example.spaces_task.core

import android.text.Html
import androidx.appcompat.widget.AppCompatTextView

fun AppCompatTextView.htmlText(text: String?) {
    this.text = if (!validateHtml(text)) {
        text
    } else {
        Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
    }
}
