/*
 * Copyright 2022 Maximillian Leonov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.maximillianleonov.cinemax.core.presentation.util

import com.maximillianleonov.cinemax.core.presentation.R
import com.maximillianleonov.cinemax.core.presentation.model.ErrorMessage
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toJavaLocalDate
import java.io.IOException
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

internal object Utils {
    internal fun getMessageFromThrowable(error: Throwable) = when (error) {
        is IOException -> R.string.no_internet_connection
        else -> R.string.unknown_error
    }
}

fun Throwable.toErrorMessage() = ErrorMessage(
    error = this,
    messageResourceId = Utils.getMessageFromThrowable(this)
)

fun LocalDate.format(pattern: String): String =
    toJavaLocalDate().format(DateTimeFormatter.ofPattern(pattern))

internal fun Double.roundToOneDecimal() =
    (this * ONE_DECIMAL_ARGUMENT).roundToInt() / ONE_DECIMAL_ARGUMENT

private const val ONE_DECIMAL_ARGUMENT = 10.0
