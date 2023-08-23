package com.Link.Link.service

import com.Link.Link.exception.UserException
import com.Link.Link.model.AppUser
import com.Link.Link.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {

    val allUsers: List<Any>
        get() = userRepository.findAll()

    fun getUserById(id: Long): AppUser {
        return userRepository.findById(id)
            .orElseThrow {
                UserException(
                    "User not found"
                )
            }
    }

    fun createUser(appUser: AppUser): AppUser {
        return userRepository.save(appUser)
    } // Other methods for updating and deleting users
}
