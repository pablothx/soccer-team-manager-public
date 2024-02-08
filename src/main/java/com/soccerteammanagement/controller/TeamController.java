
package com.soccerteammanagement.controller;

import com.soccerteammanagement.model.Team;
import com.soccerteammanagement.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        return teamService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.save(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team teamDetails) {
        return teamService.findById(id)
                .map(team -> {
                    team.setName(teamDetails.getName());
                    team.setHistory(teamDetails.getHistory());
                    team.setPictures(teamDetails.getPictures());
                    team.setLogo(teamDetails.getLogo());
                    team.setFoundationDate(teamDetails.getFoundationDate());
                    team.setDescription(teamDetails.getDescription());
                    Team updatedTeam = teamService.save(team);
                    return ResponseEntity.ok(updatedTeam);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id) {
        return teamService.findById(id)
                .map(team -> {
                    teamService.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Team>> searchTeams(@RequestParam String name) {
        List<Team> teams = teamService.searchByName(name);
        return ResponseEntity.ok(teams);
    }

}
