package spm.kotlin.world.opetorExample

object OperatorMain {


    @JvmStatic
    fun main(args: Array<String>) {
//        operator10()
//        operator11()

        useOfLazy()

        useOfLet()

        useOfRun()

        useOfAlso()

        useOfApply()

        useOfWith()

        funUseof_is_as()

        useOfFIlter()
        // we will get to know different type of operator

    }

    // as
    fun funUseof_is_as() {

        var obj = "siba"

        if (obj is String) {
            print(obj.length)
        }

        if (obj !is String) { // same as !(obj is String)
            print("Not a String")
        } else {
            print(obj.length)
        }


        if (obj !is String) return
        print(obj.length) // x is automatically cast to String

        // use of AS

        val x: String

    }

    // in
    fun operator7() {
        var obj: Any = 123
        when (obj) {
            in 1..6 -> {
                print("its between 1 o 6")
            }
            is Int -> print(1 + 1)
            is String -> print("asdasd")
            is IntArray -> print("asdasda")
        }
    }

    // ===
    fun operator8() {
        val a: Int = 10000
        println(a === a) // Prints 'true'
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        println(boxedA === anotherBoxedA) // !!!Prints 'false'!!!
    }

    // ==
    fun operator9() {
        val a: Int = 10000
        println(a == a) // Prints 'true'
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        println(boxedA == anotherBoxedA) // Prints 'true'
    }

    // is
    fun operator10() {
        val a = "sibaprasad"

        println("a is String = ${a is String}") // Prints 'true'
        // println("a is String = ${a is Int}") // Prints false
    }

    // @loop
    fun operator11() {
        loopouter@ for (i in 1..10) {

            innerLoop@ for (j in 1..5) {
                if (i == 8) {
                    break@loopouter
                } else if (j == 3) {
                    break@innerLoop
                }
                if (j == 2) {
                    continue@innerLoop
                }
                println("$i ${j}")
            }

        }
    }

    fun useOfDelegate(){
        println("============use of Delegate==========")
      //  var p: String by Delegates()

    }


    /**
     *
     */
    private fun useOfLazy(){
        println("============use of lazy==========")
        val lazyValue: String by lazy {
            println("computed!")
            "Hello"
        }
        println(lazyValue)
    }
// computed
// Output =  Hello


    /**
     * let
    let is a non-monadic version of map:
    It accepts objects as parameters and returns the result of the lambda.
    Super-useful for conversions:

     - > It doesnot change the object, it only return the value that applied condition
     */

    private fun useOfLet(){
        println("========== use of LET ==============")
        val person = Person("Edmund", 42)
        println(person)
        val result = person.let { it.age * 2 }
        println(person)
        println(result)
    }
    /** OUTPUT
     * Person(name=Edmund, age=42)
        Person(name=Edmund, age=42)
        84
     */

    /**
     * run
    run is another spm.kotlin.world.function literal with receiver.
    It is used with lambdas that do not return values,
    but rather just create some side-effects:
     */

    private fun useOfRun(){

        println("==========use of RUN==============")

        val person = Person("Edmund", 42)
        val result = person.run { age * 2 }
        println(person)
        println(result)
    }
    /** OUTPUT
     * Person(name=Edmund, age=42)
        84
     */

    /**
     * also
    With this spm.kotlin.world.function, you say “also do this with the object.”
    I often use it to add debugging to the call chains or to do some additional processing:
     */

    private fun useOfAlso() {
        println("==========use of ALSO==============")
        val person = Person("Edmund", 42)
        println(person)
        val result = person.also { person -> person.age = 50
            person.name = person.name.capitalize()}
        println("After apply ALso Operator , result is $result")
        println("After apply ALso Operator , the object is $person")
    }
    /** OUTPUT
     *  Person(name=Edmund, age=42)
        After apply ALso Operator , result is Person(name=Edmund, age=50)
        After apply ALso Operator , the object is Person(name=Edmund, age=50)
     */

    /**
     * apply
    apply is used for post-construction configuration.
    It is a spm.kotlin.world.function literal with receiver: The object is not passed as a parameter,
    but rather as this.
    An object passed in such way is called the receiver.
     */

    private fun useOfApply(){
        println("==========use of APPLY==============")
        val person = Person("Edmund", 42)
        println(person)
        val result = person.apply { age = 50 }
        println("After apply "+person)
        println("The Result "+result)
    }

    /** OUTPUT
     *  Person(name=Edmund, age=42)
        After apply Person(name=Edmund, age=50)
        The Result Person(name=Edmund, age=50)
     */

    /**
     * with
        According to Kotlin idioms, with should be used to call multiple methods on an object.
     */

    private fun useOfWith(){
        println("==========use of WITH==============")
        val person = Person("Edmund", 42)
        val result = with(person) {
            age * 2
        }
        println(person)
        println(result)
    }

    /** OUTPUT
     *
     * Person(name=Edmund, age=42)
        84
     */
    private fun useOfFIlter(){
        println("==========use of FILTER==============")
        val originalMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)

        val filteredMap = originalMap.filter { it.value < 2 }

        println(filteredMap) // {key1=1}
// original map has not changed
        println(originalMap) // {key1=1, key2=2, key3=3}
    }
    private fun useofMap(){

    }

}