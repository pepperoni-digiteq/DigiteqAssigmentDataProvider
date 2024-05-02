package com.digiteqautomotive.elevationmapdataprovider.implementation

import com.digiteqautomotive.elevationmapdataprovider.api.DataProviderApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

internal class DataProviderImpl: DataProviderApi {

    //TODO use more basic form of data (byteArray for example)
    override fun getElevation(): Flow<IntArray> = flow {
        val dataFromFile = withContext(Dispatchers.IO) {
            val inputStream =
                this@DataProviderImpl.javaClass.classLoader.getResourceAsStream("raw/elevation_data.txt")
            inputStream?.bufferedReader()?.useLines { lines ->
                lines.map { line ->
                    line.replace(" ", "")
                        .takeIf { it.isNotEmpty() }
                        ?.split(',')
                        ?.map { it.toInt() }
                        ?.toIntArray() ?: intArrayOf()
                }.toList()
            }
        } ?: emptyList()
        delay(1000)
        emitAll(dataFromFile.asFlow())
    }
}

/*
[1,0,0,1]
[0,1,0,2,1,0,1,3,2,1,2,1]
[0,0,0,0,0,0,1,0,1,0,0,0,0,0]
[0]
[0,10,0]
[1,0,1]
[2,0,1]
[1,0,2]
[10,0,1]
[1,0,10]
[]
[1996, 337, 694, 688, 683]
[570, 500, 1898, 361, 1956]
[1145, 287, 1701, 338, 1540]
[765, 757, 1157, 1513, 402]
[1209, 1281, 433, 836, 1634]
[1280, 1689, 1589, 1424, 1271]
[1401, 634, 163, 695, 49]
[1357, 1650, 631, 701, 1794]
[641, 1773, 844, 53, 1126]
[1942, 396, 781, 300, 1322]
[57, 67, 42, 190, 107, 44, 101, 22, 158, 127, 165, 186, 6, 7, 13, 86, 3, 11, 164, 166, 56, 87, 120, 108, 157, 188, 195, 90, 82, 77, 109]
[84, 129, 21, 99, 50, 83, 52, 116, 117, 179, 197, 10, 181, 46, 39, 144, 174, 190, 93, 26, 67, 70, 138, 63, 162, 151, 150, 121, 160, 180, 41]
[72, 110, 162, 186, 189, 143, 112, 85, 175, 188, 13, 139, 92, 35, 193, 12, 124, 174, 55, 158, 32, 145, 66, 48, 70, 41, 154, 120, 37, 89, 94]
[100, 75, 87, 79, 64, 156, 66, 46, 81, 102, 108, 60, 137, 166, 111, 96, 88, 49, 4, 53, 176, 114, 117, 34, 37, 29, 109, 135, 58, 184, 162]
[5, 152, 53, 11, 67, 130, 85, 38, 140, 164, 117, 58, 142, 194, 88, 2, 47, 153, 176, 108, 113, 91, 61, 39, 10, 98, 45, 159, 42, 125, 111]
[79, 186, 10, 103, 120, 161, 198, 139, 167, 21, 15, 26, 188, 173, 77, 141, 149, 101, 131, 85, 16, 87, 128, 65, 30, 115, 63, 40, 145, 176, 36]
[65, 24, 4, 185, 193, 141, 83, 154, 67, 97, 170, 183, 188, 144, 115, 47, 139, 157, 111, 99, 101, 106, 72, 23, 66, 56, 49, 93, 176, 10, 36]
[163, 199, 194, 111, 161, 132, 151, 48, 50, 117, 102, 6, 146, 195, 28, 105, 119, 171, 114, 109, 20, 107, 149, 70, 59, 67, 137, 130, 116, 18, 178]
[120, 136, 182, 117, 9, 11, 86, 132, 75, 25, 93, 88, 188, 124, 53, 110, 113, 82, 10, 115, 108, 101, 29, 163, 71, 85, 135, 106, 146, 50, 99]
[63, 185, 134, 188, 45, 35, 170, 43, 103, 13, 135, 0, 115, 178, 176, 82, 38, 157, 19, 81, 21, 158, 70, 17, 87, 36, 119, 154, 99, 184, 180]
 */