package indi.revolutionaryhistory.entity;

public class Collect {
    //用户id
    private Integer uId;
    //文章id
    private Integer eId;


    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    @Override
    public String toString() {
        return "UserEssay{" +
                "uId=" + uId +
                ", eId=" + eId +
                '}';
    }
}
