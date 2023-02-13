package indi.revolutionaryhistory.service;

import indi.revolutionaryhistory.entity.Collect;

public interface CollectService {
    boolean saveCollect(Collect collect);

    boolean checkCollect(Collect collect);
}
