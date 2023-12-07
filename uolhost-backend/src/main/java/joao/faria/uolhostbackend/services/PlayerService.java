package joao.faria.uolhostbackend.services;

import joao.faria.uolhostbackend.infra.NicknameHandler;
import joao.faria.uolhostbackend.model.GroupType;
import joao.faria.uolhostbackend.model.Player;
import joao.faria.uolhostbackend.model.dtos.PlayerDTO;
import joao.faria.uolhostbackend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private NicknameHandler nicknameHandler;

    public Player create(PlayerDTO player) {
        Player newPlayer = new Player(player);
        String nickname = getNickname(player.groupType());
        newPlayer.setNickname(nickname);
        return playerRepository.save(newPlayer);
    }

    public List<Player> list() {
        return playerRepository.findAll();
    }

    private String getNickname(GroupType groupType) {
        return nicknameHandler.findNickname(groupType);
    }
}
