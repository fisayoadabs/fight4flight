package io.group02.fight4flight.repository;

import io.group02.fight4flight.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Here, you can define custom query methods if needed, for example:
    Admin findByUsername(String username);

    // Other custom methods can be added as per your requirements
}
