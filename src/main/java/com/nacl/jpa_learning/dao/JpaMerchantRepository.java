package com.nacl.jpa_learning.dao;

import com.nacl.jpa_learning.pojo.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMerchantRepository extends JpaRepository<Merchant,Integer> {
}
