package com.sportpanda.sportgatewayservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class SportGatewayServiceApplication

fun main(args: Array<String>) {
    runApplication<SportGatewayServiceApplication>(*args)
}
