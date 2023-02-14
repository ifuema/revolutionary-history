package indi.revolutionaryhistory.service;

import indi.revolutionaryhistory.entity.Collect;

import java.util.List;

public interface CollectService {
    boolean saveCollect(Collect collect);

    boolean checkCollectByCollect(Collect collect);

    boolean removeCollectByCollect(Collect collect);

    List<Collect> getCollectListByUID(Integer uId);
}
