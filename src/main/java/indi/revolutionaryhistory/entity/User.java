package indi.revolutionaryhistory.entity;

import indi.revolutionaryhistory.entity.groups.Login;
import indi.revolutionaryhistory.entity.groups.Register;
import jakarta.validation.constraints.*;

public class User {
  //用户编号
  private Integer uId;
  //用户昵称
  @NotBlank(message = "昵称不能为空！", groups = {Register.class})
  @Size(max = 8, message = "昵称过长！", groups = {Register.class})
  private String uName;
  //用户账号
  @NotNull(message = "电话不能为空！", groups = {Register.class})
  @PositiveOrZero(message = "电话格式不正确！", groups = {Register.class})
  @DecimalMax(value = "99999999999", message = "电话号码过长！", groups = {Register.class})
  private Long uAccount;
  //用户密码
  @NotBlank(message = "密码不能为空！", groups = {Login.class, Register.class})
  private String uPassword;
  //用户邮箱
  @Email(message = "邮箱格式不正确！", groups = {Register.class})
  private String uEmail;
  //用户地址
  @NotBlank(message = "地址不能为空！", groups = {Register.class})
  @Size(max = 255, message = "地址过长！", groups = {Register.class})
  private String uAddress;
  private String uImg;


  public String getuImg() {
    return uImg;
  }

  public void setuImg(String uImg) {
    this.uImg = uImg;
  }

  public Integer getuId() {
    return uId;
  }

  public void setuId(Integer uId) {
    this.uId = uId;
  }

  public String getuName() {
    return uName;
  }

  public void setuName(String uName) {
    this.uName = uName;
  }

  public Long getuAccount() {
    return uAccount;
  }

  public void setuAccount(Long uAccount) {
    this.uAccount = uAccount;
  }

  public String getuPassword() {
    return uPassword;
  }

  public void setuPassword(String uPassword) {
    this.uPassword = uPassword;
  }

  public String getuEmail() {
    return uEmail;
  }

  public void setuEmail(String uEmail) {
    this.uEmail = uEmail;
  }

  public String getuAddress() {
    return uAddress;
  }

  public void setuAddress(String uAddress) {
    this.uAddress = uAddress;
  }

  @Override
  public String toString() {
    return "User{" +
            "uId=" + uId +
            ", uName='" + uName + '\'' +
            ", uAccount=" + uAccount +
            ", uPassword='" + uPassword + '\'' +
            ", uEmail='" + uEmail + '\'' +
            ", uAddress='" + uAddress + '\'' +
            ", uImg='" + uImg + '\'' +
            '}';
  }
}
