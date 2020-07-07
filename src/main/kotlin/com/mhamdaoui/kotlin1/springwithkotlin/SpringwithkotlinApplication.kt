package com.mhamdaoui.kotlin1.springwithkotlin

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringwithkotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringwithkotlinApplication>(*args) {
//		setBannerMode(Banner.Mode.OFF)
	}
}
