package com.example.kolaeregister.ui.main
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

object MaskUtil {

    fun insert(editText: EditText, mask: String): TextWatcher {
        return object : TextWatcher {
            var isUpdating = false
            var oldString = ""

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val str = unmask(s.toString())
                var mascara = ""

                if (isUpdating) {
                    oldString = str
                    isUpdating = false
                    return
                }

                var i = 0
                for (m in mask.toCharArray()) {
                    if (m != '#' && str.length > oldString.length) {
                        mascara += m
                        continue
                    }
                    try {
                        mascara += str[i]
                    } catch (e: Exception) {
                        break
                    }
                    i++
                }

                isUpdating = true
                editText.setText(mascara)
                editText.setSelection(mascara.length)
            }


            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}
        }
    }
    fun unmask(s: String): String {
        return s.replace("[^0-9]*".toRegex(), "")
    }
}