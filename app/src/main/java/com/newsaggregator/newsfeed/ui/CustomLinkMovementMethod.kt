package com.newsaggregator.newsfeed.ui

import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.view.MotionEvent
import android.widget.TextView

class CustomLinkMovementMethod(private val onLinkClick: (String) -> Unit) : LinkMovementMethod() {
    override fun onTouchEvent(textView: TextView?, buffer: Spannable?, event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_UP) {
            // Содержит кординаты точки касания относительно левой части экрана
            // по горизонтали и учитывает отсутп, если он есть, если нет считает что отсуп 0
            val x = event.x.toInt() - (textView?.totalPaddingLeft ?: 0)
            val y = event.y.toInt() - (textView?.totalPaddingTop ?: 0)

            val layout = textView?.layout ?: return false
            val line = layout.getLineForVertical(y) // Получаем номер строки по верт.
            val offset = layout.getOffsetForHorizontal(line, x.toFloat()) // Получаем номер символа по гориз.

            // Получает все сслыки вы указанном диапазоне
            val links = buffer?.getSpans(offset, offset, URLSpan::class.java)

            if (links?.isNotEmpty() == true) {
                val url = links.first().url // Сохраняем первую встреченную ссылку
                onLinkClick(url)
                return true
            }
        }
        return super.onTouchEvent(textView, buffer, event)
    }
}
