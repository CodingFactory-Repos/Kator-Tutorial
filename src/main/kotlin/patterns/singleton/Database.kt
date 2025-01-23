package me.loule.patterns.singleton

/**
 * Le pattern Singleton garantit qu'une classe n'a qu'une seule instance et fournit un point d'accès
 * global à cette instance. Utilisé ici pour gérer une connexion unique à la base de données.
 *
 * Points clés du Singleton :
 * 1. Constructeur privé pour empêcher l'instanciation directe
 * 2. Instance unique stockée dans une variable statique
 * 3. Méthode statique pour accéder à l'instance unique
 */
class Database private constructor() {

    companion object {
        // Instance unique de la base de données
        private var instance: Database? = null

        /**
         * Point d'accès global à l'instance unique. Crée l'instance si elle n'existe pas (lazy
         * initialization).
         */
        fun getInstance(): Database {
            if (instance == null) {
                instance = Database()
                instance!!.open()
            }
            return instance!!
        }
    }

    // État de la connexion
    private var opened = false

    /**
     * Simule l'ouverture d'une connexion à la base de données. Grâce au Singleton, on s'assure
     * qu'une seule connexion est ouverte.
     */
    fun open() {
        if (opened) {
            println("Database connection already opened")
            return
        }

        println("Opening Database connection")
        opened = true
    }
}

/**
 * Exemple d'utilisation démontrant que plusieurs appels à getInstance() retournent la même instance
 * de Database.
 */
fun main() {
    // Module 1
    val database = Database.getInstance()
    database.open()
    database.open()

    // Module 2
    val database2 = Database.getInstance()
    database2.open()
}
