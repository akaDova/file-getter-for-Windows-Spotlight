/**
 * file renamer for Windows interesting
 * pulls directory with pictures to Desktop & transforms files to .jpg
 * © akaDova, 28.01.2018
 */
import java.io.File

fun main(args: Array<String>) {
    try {
        println("write user's name")
        val user = readLine()
        val path = "C:\\Users\\$user\\Desktop\\pictures"
        val assetsPath = "C:\\Users\\$user\\AppData\\Local\\Packages\\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets"
        File(path).deleteRecursively()
        val assetsFiles = File(assetsPath)
        assetsFiles.copyRecursively(File("$path"))
        val files = File(path).walkTopDown()
        files.filter { file: File -> file.isFile }.forEach({ file: File -> file.renameTo(File("$path\\${file.name}.jpg")) })
        println("done")
    } catch (e: Exception) {
        println(e.message)
    }
}
