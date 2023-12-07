package joao.faria.uolhostbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import joao.faria.uolhostbackend.model.dtos.PlayerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "players")
@Table(name = "players")
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    private String phoneNumber;
    private String nickname;
    private GroupType groupType;

    public Player(PlayerDTO playerDTO) {
        this.name = playerDTO.name();
        this.email = playerDTO.email();
        this.phoneNumber = playerDTO.phoneNumber();
        this.nickname = playerDTO.nickname();
        this.groupType = playerDTO.groupType();
    }
}
