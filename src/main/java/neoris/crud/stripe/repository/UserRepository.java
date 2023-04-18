package neoris.crud.stripe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import neoris.crud.stripe.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
