package com.example.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanagement.modal.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
