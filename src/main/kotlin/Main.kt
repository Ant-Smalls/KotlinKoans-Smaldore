/*
Purpose: Introduction section answers for the Kotlin Koans
Date: 09/12/2024
Author: Anthony Smaldore
 */

import java.lang.IllegalArgumentException

//"Hello, world!" task 1:
//
fun start():String = "OK";

//"Named arguements" task 2:
//
fun joinOptions(options: Collection<String>) =
    options.joinToString(separator = ", ","[","]");

//"Default arguements: task 3:
//
fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.uppercase() else name) + number

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

//"Triple-quoted-strings" task 4:
//
const val question = "life, the universe, and everything"
const val answer = 42

val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin("#")

//"String templates": task 5
//
val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
fun getPattern(): String = """\d{2}\s$month\s\d{4}"""

//"Nullable Types": task 6
//
fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    if(message != null && client?.personalInfo?.email != null)
    {
        val email:String = client.personalInfo.email;
        mailer.sendMessage(email,message);
    }
    else
    {
        return;
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

//"Nothing type": task 7
//
fun failWithWrongAge(age: Int?):Nothing   {
    throw IllegalArgumentException("Wrong age: $age")
}

fun checkAge(age: Int?) {
    if (age == null || age !in 0..150) failWithWrongAge(age)
    println("Congrats! Next year you'll be ${age + 1}.")
}

//"Lambdas": tasks 8
//
fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { it % 2 == 0 }








fun main() {
    //task 1: Hello, world!
    assert(start() == "OK"){"Error with function: start()"};
    //task 2: Named arguements
    assert(joinOptions(listOf("a","b","c")) == "[a, b, c]"){"Error with function: useFoo()"};
    //task 3: Does program compile?
    //No output
    //task 4: Triple quoted strings
    assert('#' !in tripleQuotedString){"Error with triple quoted string"};
    //task 5: String templates
    println(getPattern() + "\n");
    //task 6: Nullable types
    //No output
    //task 7: Nothing type
    checkAge(10);
    println();
    //task 8:
    println(containsEven(listOf(1,3,5)));
    println();
    println(containsEven(listOf(1,2,4,5)));

}