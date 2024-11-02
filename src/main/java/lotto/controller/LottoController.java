package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private LottoService lottoService;
    private InputView inputView;
    private OutputView outputView;

    public LottoController() {
        lottoService = new LottoService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        String lottoPrice = inputView.inputLottoPrice();
        int lottoPriceInt = lottoService.validateLottoPrice(lottoPrice);

        int lottoNum = lottoService.purchaseLotto(lottoPriceInt);
        List<Lotto> lotto = lottoService.randomLottoNum(lottoNum);
        outputView.printLotto(lotto, lottoNum);

        String lottoWinningNumbers = inputView.inputLottoWinningNumbers();
        lottoService.validateWinningNumbers(lottoWinningNumbers);
        List<Integer> winningNumbers = lottoService.splitLottoWinningNumbers(lottoWinningNumbers);

        String lottoBonusNumber = inputView.inputLottoBonusNumber();
        lottoService.validateBonusNumbers(lottoBonusNumber);
        int bonusNumber = lottoService.convertBonusNumberInt(lottoBonusNumber);
        lottoService.winningLotto(winningNumbers, bonusNumber);

        Map<LottoRank, Integer> lottoResult = lottoService.resultWinningLotto(lottoNum);
        double rate = lottoService.calculateRate(lottoResult, lottoPriceInt);

        outputView.totalLotto(lottoResult, rate);
    }
}
