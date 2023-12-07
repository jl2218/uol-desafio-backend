package joao.faria.uolhostbackend.controller;

import jakarta.validation.Valid;
import joao.faria.uolhostbackend.model.Player;
import joao.faria.uolhostbackend.model.dtos.PlayerDTO;
import joao.faria.uolhostbackend.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<?> createPlayer(@RequestBody @Valid PlayerDTO player) {
        Player newPlayer = playerService.create(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(playerService.list(), HttpStatus.OK);
    }
}
