package com.Link.Link.controller

import com.Link.Link.exception.UserException
import com.Link.Link.model.AppUser
import com.Link.Link.repository.UserRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {

    @GetMapping
    fun userList(): List<AppUser> {
        return userRepository.findAll()
    }

    @GetMapping("/{id}")
    fun userDetails(@PathVariable id: Long): AppUser {
        return userRepository.findById(id)
            .orElseThrow { UserException("User not found") }
    }

    @PostMapping
    fun createUser(@RequestBody appUser: AppUser): AppUser {
        return userRepository.save(appUser)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody appUser: AppUser): AppUser {
        if (!userRepository.existsById(id)) {
            throw UserException("User not found")
        }
        appUser.id = id
        return userRepository.save(appUser)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        if (!userRepository.existsById(id)) {
            throw UserException("User not found")
        }
        userRepository.deleteById(id)
    }
}
