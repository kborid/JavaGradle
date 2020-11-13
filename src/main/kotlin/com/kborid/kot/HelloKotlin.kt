import com.kborid.kot.UserKotlin
import com.kborid.jav.vo.UserInfo

object HelloKotlin {
    @JvmStatic
    fun main(array: Array<String>) {
        println("HelloKotlin")

        val userInfo = UserInfo()
        val userKotlin = UserKotlin("kborid", 30)
        println(userKotlin.name)
    }
}