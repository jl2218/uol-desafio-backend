package joao.faria.uolhostbackend.model.dtos;

import joao.faria.uolhostbackend.model.GroupType;

public record PlayerDTO(String name, String email, String phoneNumber, String nickname, GroupType groupType) {
}
