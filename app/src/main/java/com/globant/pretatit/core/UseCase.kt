package com.globant.pretatit.core

import com.globant.pretatit.presentation.Task

interface UseCase<in I, out R> {

    suspend operator fun invoke(params: I): Result<List<Task>, Result.Failure>
}