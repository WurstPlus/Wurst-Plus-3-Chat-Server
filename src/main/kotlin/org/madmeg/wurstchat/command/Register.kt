package org.madmeg.wurstchat.command

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)

annotation class Register(val name: String, val type: Types, val syntax: String){
}

