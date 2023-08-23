package com.Link.Link.repository

import com.Link.Link.model.AppUser
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<AppUser, Long> {

}
