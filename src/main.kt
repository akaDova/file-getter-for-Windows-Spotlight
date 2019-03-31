/**
 * file getter for Windows Spotlight
 * pulls directory with pictures to Desktop & transforms files to .jpg
 * © akaDova, 28.01.2018
 */
import java.io.File
import java.nio.file.Files

fun main(args: Array<String>) {
    try {
        /*TODO: get paths from args*/
        println("write user's name")

        val user = readLine()

        if (Files.notExists(File("C:\\Users\\$user\\Desktop").toPath())) {
            println("user have not found")
            return
        }

        val path = "C:\\Users\\$user\\Desktop\\spotlight-pictures"
        val assetsPath = "C:\\Users\\$user\\AppData\\Local\\Packages\\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets"
        val assetsDir = File(assetsPath)

        File(path).deleteRecursively()
        if (Files.exists(assetsDir.toPath())) {
            assetsDir.copyRecursively(File(path))

            val files = File(path).walkTopDown()
            files.filter { it.isFile }.forEach({ it.renameTo(File("$path\\${it.name}.jpg")) })

            println("done")
        } else {
            println("Spotlight pictures have not found")
        }
    } catch (e: Exception) {
        println(e.message)
    }
}
