package me.loule.patterns.observer

interface OnClickListener {
    fun onClicked(button: Button)
}

class Button(val label: String) {
    var onClickListener: OnClickListener? = null

    fun press() {
        println("Button $label is pressed")
        onClickListener?.onClicked(this)
    }
}

class Panel : OnClickListener {
    val refreshButton = Button("Refresh")

    init {
        refreshButton.onClickListener = this
    }

    fun display() {
        refreshButton.press()
    }

    override fun onClicked(button: Button) {
        println("Panel => Refresh started")
    }
}

class Window : OnClickListener {
    val loginButton = Button("Login")

    init {
        loginButton.onClickListener = this
    }

    fun display() {
        loginButton.press()
    }

    override fun onClicked(button: Button) {
        println("Window => submit login from to API")
    }
}

fun main() {
    val w = Window()
    w.display()

    val p = Panel()
    p.display()
}
