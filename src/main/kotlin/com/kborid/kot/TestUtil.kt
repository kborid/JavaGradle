package com.kborid.kot

class TestUtil {
    fun printJson(json: String?): String {
        println(json)
        return json!!
    }

    // TestUtil伴生对象
    companion object {
        const val TAG: String = "TestUtil"
    }
}

fun main() {
    val json = "{}"
    println(json)
    TestUtil().printJson(json)
    TestStaticUtil.printJson(json)
}

// 对象生命/单例模式
object TestStaticUtil {
    const val TAG: String = "TestStaticUtil"
    fun printJson(json: String): String {
        println(json)
        return json
    }
}