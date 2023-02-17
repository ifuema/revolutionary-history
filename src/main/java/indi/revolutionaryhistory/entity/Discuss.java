package indi.revolutionaryhistory.entity;

public class Discuss {
  private Integer dId;
  private Integer uId;
  private Integer eId;
  private String dBody;


  @Override
  public String toString() {
    return "Discuss{" +
            "dId=" + dId +
            ", uId=" + uId +
            ", eId=" + eId +
            ", dBody='" + dBody + '\'' +
            '}';
  }

  public Integer getdId() {
    return dId;
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
