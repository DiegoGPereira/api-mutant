package br.com.diegopereira.apimutants.controller;

import br.com.diegopereira.apimutants.dto.response.StatsResponse;
import br.com.diegopereira.apimutants.entities.Stats;
import br.com.diegopereira.apimutants.service.StatsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
@Slf4j
public class StatsController {

    private final StatsService statsService;
    private final ModelMapper modelMapper;

    @GetMapping("/stats")
    public ResponseEntity<StatsResponse> findStats() {
        log.info("Starting fetch stats from database!");

        Stats stats = statsService.findStats();
        StatsResponse statsResponse = modelMapper.map(stats, StatsResponse.class);

        log.info("Finished fetch stats from database!");

        return ResponseEntity.ok().body(statsResponse);
    }
}
