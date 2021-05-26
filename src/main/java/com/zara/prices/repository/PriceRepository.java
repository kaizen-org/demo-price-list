package com.zara.prices.repository;

import com.zara.prices.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    /**
     * Find price by id and brand between dates .
     *
     * @param id        the id
     * @param brandId   the brand id
     * @param applyDate the apply date
     * @return the optional
     */
    @Query("SELECT p FROM Price p WHERE p.id= ?0 and p.brand.id = ?1 and p.startDate <= ?2 and p.endDate>= ?2 ORDER BY p.priority DESC")
    Optional<Price> findPriceByIdAndBrandBetweenDates(Long id, Long brandId, Date applyDate);
}
