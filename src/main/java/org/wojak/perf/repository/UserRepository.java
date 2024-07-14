package org.wojak.perf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wojak.perf.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
