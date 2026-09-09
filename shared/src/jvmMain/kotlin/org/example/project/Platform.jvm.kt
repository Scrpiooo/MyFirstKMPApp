package org.example.project

class JVMPlatform: Platform {
    override val name: String = "Dekstop"
}

actual fun getPlatform(): Platform = JVMPlatform()