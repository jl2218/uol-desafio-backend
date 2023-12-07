package joao.faria.uolhostbackend.infra;

import joao.faria.uolhostbackend.model.GroupType;
import joao.faria.uolhostbackend.services.NicknameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NicknameHandler {

    @Autowired
    private NicknameService service;

    public String findNickname(GroupType groupType) {
        String firstMatch;
        if (groupType == GroupType.AVENGERS) {
            firstMatch = service.getAvengersNicknameList().stream().findFirst().orElseThrow();
            this.service.getAvengersNicknameList().remove(firstMatch);
        } else {
            firstMatch = service.getJusticeLeagueList().stream().findFirst().orElseThrow();
            this.service.getJusticeLeagueList().remove(firstMatch);
        }
        return firstMatch;
    }

}
