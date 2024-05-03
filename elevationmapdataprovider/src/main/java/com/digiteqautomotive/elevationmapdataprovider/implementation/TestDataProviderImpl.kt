package com.digiteqautomotive.elevationmapdataprovider.implementation

internal class TestDataProviderImpl {

    fun getElevation(): List<Triple<String, Int, List<String>>> {
        val inputStream =
            this@TestDataProviderImpl.javaClass.classLoader.getResourceAsStream("raw/elevation_data.csv")
        return inputStream?.bufferedReader()?.useLines { lines ->
            lines
                .mapIndexed { index, s ->
                    val lineWithName = s.split(',')
                    val line = lineWithName.subList(1, lineWithName.size)
                    val name = lineWithName.first()
                    val amount = expectedAmountMap[index].second
                    Triple(name, amount, line)
                }
                .toList()
        } ?: emptyList()
    }

    private val expectedAmountMap = listOf(
        Pair("New York City", 2),
        Pair("Tokyo", 6),
        Pair("London", 1),
        Pair("Paris", 0),
        Pair("Sydney", 0),
        Pair("Rio de Janeiro", 1),
        Pair("Moscow", 1),
        Pair("Cairo", 1),
        Pair("Beijing", 1),
        Pair("Rome", 1),
        Pair("Istanbul", 0),
        Pair("Mumbai", 357),
        Pair("Mexico City", 1607),
        Pair("Seoul", 2060),
        Pair("Berlin", 8),
        Pair("Buenos Aires", 1293),
        Pair("Johannesburg", 0),
        Pair("Toronto", 593),
        Pair("Dubai", 1968),
        Pair("Bangkok", 1355),
        Pair("Barcelona", 2489),
        Pair("Jakarta", 2201),
        Pair("Lagos", 1690),
        Pair("Karachi", 1618),
        Pair("Los Angeles", 1957),
        Pair("Amsterdam", 1919),
        Pair("Lima", 2192),
        Pair("Riyadh", 1811),
        Pair("Singapore", 2256),
        Pair("Madrid", 2023),
        Pair("Kuala Lumpur", 2500)
    )
}