package indi.revolutionaryhistory.entity;

import indi.revolutionaryhistory.entity.groups.Register;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class Discuss {
  private Integer dId;
  private Integer uId;
  @NotNull(message = "文章id不能为空！", groups = {Register.class})
  private Integer eId;
  @NotBlank(message = "内容不能为空！", groups = {Register.class})
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
