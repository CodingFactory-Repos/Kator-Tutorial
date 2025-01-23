package me.loule.patterns.observer

/**
 * Le pattern Observer établit une relation un-à-plusieurs entre les objets, permettant de notifier
 * automatiquement tous les objets dépendants lorsqu'un changement d'état se produit.
 *
 * Points clés du pattern Observer :
 * 1. Interface Observer (OnClickListener) définissant la méthode de notification
 * 2. Sujet observable (Button) qui maintient une référence vers son observateur
 * 3. Observateurs concrets (Panel, Window) qui implémentent l'interface Observer
 */

/**
 * Interface définissant le contrat pour les observateurs qui souhaitent être notifiés
 * des clics sur un bouton.
 */
interface OnClickListener {
    fun onClicked(button: Button)
}

/**
 * Classe Button agissant comme le sujet observable. Elle maintient une référence
 * vers son observateur et le notifie lors d'un clic.
 */
class Button(val label: String) {
    var onClickListener: OnClickListener? = null

    fun press() {
        println("Button $label is pressed")
        onClickListener?.onClicked(this)
    }
}

/**
 * Implémentation concrète d'un observateur qui réagit aux clics sur un bouton de rafraîchissement.
 * Démontre comment un observateur peut effectuer des actions spécifiques en réponse à un événement.
 */
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

/**
 * Autre implémentation concrète d'un observateur qui gère les clics sur un bouton de connexion.
 * Illustre comment différents observateurs peuvent réagir différemment au même type d'événement.
 */
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

/**
 * Exemple d'utilisation démontrant l'interaction entre les boutons (sujets) et leurs observateurs.
 * Montre comment différents composants peuvent réagir indépendamment aux événements de clic.
 */
fun main() {
    val w = Window()
    w.display()

    val p = Panel()
    p.display()
}
