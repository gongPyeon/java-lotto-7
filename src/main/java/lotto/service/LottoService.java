package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Constants;
import lotto.domain.Lotto;

import java.util.List;

public class LottoService {

    private List<Lotto> lottoList;

    public int purchaseLotto(int lottoPrice) {
        int lottoNum = lottoPrice / Constants.PURCHASE_FORM;

        return lottoNum;
    }

    public List<Lotto> randomLottoNum(int lottoNum) {
        for(int i=0; i<lottoNum; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
        return lottoList;
    }
}
