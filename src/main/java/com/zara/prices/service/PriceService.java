package com.zara.prices.service;

import com.zara.prices.dto.PriceGetDto;
import com.zara.prices.mapper.PriceMapper;
import com.zara.prices.repository.PriceRepository;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.Optional;

/**
 * The type Price service.
 */
public class PriceService {

    private final PriceRepository priceRepository;

    private static final PriceMapper mapper = Mappers.getMapper(PriceMapper.class);

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * Get price optional.
     *
     * @param id        the id
     * @param brandId   the brand id
     * @param applyDate the apply date
     * @return the optional
     */
    public Optional<PriceGetDto> getPrice(Long id, Long brandId, Date applyDate){
        return priceRepository.findPriceByIdAndBrandBetweenDates(id,brandId,applyDate).map(mapper::map);
    }
}
