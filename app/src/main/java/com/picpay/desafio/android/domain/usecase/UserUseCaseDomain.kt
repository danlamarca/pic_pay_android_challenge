package com.picpay.desafio.android.domain.usecase

import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.domain.repository.UserDomainInterface
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserUseCaseDomain {
    companion object {
        suspend operator fun invoke(defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
                            userDomainInterface: UserDomainInterface): List<User> {

            return withContext(defaultDispatcher) {
                userDomainInterface.showUsers().sortedBy { it.comparator() }
            }
        }
    }
}