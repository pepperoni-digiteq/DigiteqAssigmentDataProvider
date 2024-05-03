package com.digiteqautomotive.elevationmapdataprovider.api.testing

import com.digiteqautomotive.elevationmapdataprovider.implementation.TestDataProviderImpl

/**
 * @param computeAmount - lambda that takes an elevationMap as an argument
 *                        and returns an amount of water it can trap.
 *
 * Example: for elevation map of ["5", "3", "6"], computeAmount should return 2.
 */
fun assertAmount(computeAmount: (List<String>) -> Int) {
    TestDataProviderImpl().getElevation().forEach {
        print("Computing ${it.first}: ${it.third}... ")
        val actual = computeAmount(it.third)
        if(actual != it.second){
            throw AssertionError("Expected result - ${it.second}; Actual result - $actual")
        }
        println("Correct")
    }
    println("Success")
}