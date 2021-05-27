package com.zara.prices.service;

import com.zara.prices.dto.PriceGetDto;
import com.zara.prices.mapper.PriceMapper;
import com.zara.prices.repository.PriceRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * The type Price service.
 */
@Service
public class PriceService {

    private final PriceRepository priceRepository;

    private static final PriceMapper mapper = Mappers.getMapper(PriceMapper.class);

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * Get price optional.
     *
     * @param brandId   the brandId
     * @param brandId   the brand id
     * @param applyDate the apply date
     * @return the optional
     */
    public Optional<PriceGetDto> getPrice(Long brandId, Integer productId, Date applyDate) {
        return priceRepository.findPriceByIdAndBrandBetweenDates(brandId, productId, applyDate).map(mapper::map);
    }
}
