package br.com.levimendesestudos.spidermagazine.koin

import org.koin.dsl.module

// just declare it
val spiderModule = module {
    single { ApiSpiderModule() }
}