package indi.revolutionaryhistory.service;

import indi.revolutionaryhistory.entity.Discuss;

import java.util.List;

public interface DiscussService {
    List<Discuss> getDiscussListByEId(Integer eId);

    boolean saveDiscuss(Discuss discuss);
}
