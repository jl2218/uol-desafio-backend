package joao.faria.uolhostbackend.repositories;

import joao.faria.uolhostbackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
