package indi.revolutionaryhistory.entity;

import java.time.Instant;

public class Discuss {
  private Integer dId;
  private Integer uId;
  private Integer eId;
  private String dBody;
  private Instant dTime;


  @Override
  public String toString() {
    return "Discuss{" +
            "dId=" + dId +
            ", uId=" + uId +
            ", eId=" + eId +
            ", dBody='" + dBody + '\'' +
            ", dTime=" + dTime +
            '}';
  }

  public Integer getdId() {
    return dId;
  }

  public Instant getdTime() {
    return dTime;
  }

  public void setdTime(Instant dTime) {
    this.dTime = dTime;
  }

  public void setdId(Integer dId) {
    this.dId = dId;
  }

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

  public String getdBody() {
    return dBody;
  }

  public void setdBody(String dBody) {
    this.dBody = dBody;
  }
}
