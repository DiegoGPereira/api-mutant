package br.com.diegopereira.apimutants.controller;

import br.com.diegopereira.apimutants.dto.response.StatsResponse;
import br.com.diegopereira.apimutants.entities.Stats;
import br.com.diegopereira.apimutants.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class StatsController {

    private final StatsService statsService;
    private final ModelMapper modelMapper;

    @GetMapping("/stats")
    public ResponseEntity<StatsResponse> findStats() {

        Stats stats = statsService.findStats();
        StatsResponse statsResponse = modelMapper.map(stats, StatsResponse.class);

        return ResponseEntity.ok().body(statsResponse);
    }
}
