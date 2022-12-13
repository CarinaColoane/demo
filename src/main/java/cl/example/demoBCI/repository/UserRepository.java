package cl.example.demoBCI.repository;

import cl.example.demoBCI.entity.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    @Query(
            value = "SELECT COUNT(email)>0 FROM user_info WHERE user_info.email = :email ;",
            nativeQuery = true)
    boolean existByEmail(@Param("email") String email);

}

