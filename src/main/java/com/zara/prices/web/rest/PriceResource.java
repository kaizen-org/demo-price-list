package com.zara.prices.web.rest;

import com.zara.prices.dto.PriceGetDto;
import com.zara.prices.service.PriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class PriceResource {

	private final PriceService priceService;

    public PriceResource(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(path="/price" )
    public ResponseEntity<PriceGetDto> getPrice(@RequestParam(value = "date") Date date,
                                                @RequestParam(value = "productId") Long productId,
                                                @RequestParam(value= "brandId") Long brandId){
        return priceService.getPrice(productId,brandId,date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
