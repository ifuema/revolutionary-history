package indi.revolutionaryhistory.entity;

import indi.revolutionaryhistory.entity.groups.Register;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.Instant;

public class People {
  private Integer pId;
  @NotBlank(message = "名字不能为空！", groups = {Register.class})
  @Size(max = 32, message = "名字过长！", groups = {Register.class})
  private String pName;
  private String pAlias;
  @NotBlank(message = "国籍不能为空！", groups = {Register.class})
  @Size(max = 16, message = "国籍过长！", groups = {Register.class})
  private String pCitizenship;
  @Size(max = 32, message = "民族过长！", groups = {Register.class})
  private String pNationality;
  private Instant pBirth;
  private Instant pDeath;
  private String pUniversity;
  @NotBlank(message = "职业不能为空！", groups = {Register.class})
  private String pOccupation;
  private String pWork;
  @NotBlank(message = "成就不能为空！", groups = {Register.class})
  private String pAchievement;
  @Size(max = 32, message = "原名过长！", groups = {Register.class})
  private String pOriginalName;
  @Size(max = 16, message = "字号过长！", groups = {Register.class})
  private String pCharacter;
  @NotBlank(message = "经历不能为空！", groups = {Register.class})
  private String pExperience;
  @NotBlank(message = "生活不能为空！", groups = {Register.class})
  private String pLife;
  @NotBlank(message = "评价不能为空！", groups = {Register.class})
  private String pEvaluate;
  @NotBlank(message = "影响不能为空！", groups = {Register.class})
  private String pInfluence;
  private String pCommemoration;
  @NotBlank(message = "图片不能为空！", groups = {Register.class})
  private String pImg;


  @Override
  public String toString() {
    return "People{" +
            "pId=" + pId +
            ", pName='" + pName + '\'' +
            ", pAlias='" + pAlias + '\'' +
            ", pCitizenship='" + pCitizenship + '\'' +
            ", pNationality='" + pNationality + '\'' +
            ", pBirth=" + pBirth +
            ", pDeath=" + pDeath +
            ", pUniversity='" + pUniversity + '\'' +
            ", pOccupation='" + pOccupation + '\'' +
            ", pWork='" + pWork + '\'' +
            ", pAchievement='" + pAchievement + '\'' +
            ", pOriginalName='" + pOriginalName + '\'' +
            ", pCharacter='" + pCharacter + '\'' +
            ", pExperience='" + pExperience + '\'' +
            ", pLife='" + pLife + '\'' +
            ", pEvaluate='" + pEvaluate + '\'' +
            ", pInfluence='" + pInfluence + '\'' +
            ", pCommemoration='" + pCommemoration + '\'' +
            ", pImg='" + pImg + '\'' +
            '}';
  }

  public String getpImg() {
    return pImg;
  }

  public void setpImg(String pImg) {
    this.pImg = pImg;
  }

  public Integer getpId() {
    return pId;
  }

  public void setpId(Integer pId) {
    this.pId = pId;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public String getpAlias() {
    return pAlias;
  }

  public void setpAlias(String pAlias) {
    this.pAlias = pAlias;
  }

  public String getpCitizenship() {
    return pCitizenship;
  }

  public void setpCitizenship(String pCitizenship) {
    this.pCitizenship = pCitizenship;
  }

  public String getpNationality() {
    return pNationality;
  }

  public void setpNationality(String pNationality) {
    this.pNationality = pNationality;
  }

  public Instant getpBirth() {
    return pBirth;
  }

  public void setpBirth(Instant pBirth) {
    this.pBirth = pBirth;
  }

  public Instant getpDeath() {
    return pDeath;
  }

  public void setpDeath(Instant pDeath) {
    this.pDeath = pDeath;
  }

  public String getpUniversity() {
    return pUniversity;
  }

  public void setpUniversity(String pUniversity) {
    this.pUniversity = pUniversity;
  }

  public String getpOccupation() {
    return pOccupation;
  }

  public void setpOccupation(String pOccupation) {
    this.pOccupation = pOccupation;
  }

  public String getpWork() {
    return pWork;
  }

  public void setpWork(String pWork) {
    this.pWork = pWork;
  }

  public String getpAchievement() {
    return pAchievement;
  }

  public void setpAchievement(String pAchievement) {
    this.pAchievement = pAchievement;
  }

  public String getpOriginalName() {
    return pOriginalName;
  }

  public void setpOriginalName(String pOriginalName) {
    this.pOriginalName = pOriginalName;
  }

  public String getpCharacter() {
    return pCharacter;
  }

  public void setpCharacter(String pCharacter) {
    this.pCharacter = pCharacter;
  }

  public String getpExperience() {
    return pExperience;
  }

  public void setpExperience(String pExperience) {
    this.pExperience = pExperience;
  }

  public String getpLife() {
    return pLife;
  }

  public void setpLife(String pLife) {
    this.pLife = pLife;
  }

  public String getpEvaluate() {
    return pEvaluate;
  }

  public void setpEvaluate(String pEvaluate) {
    this.pEvaluate = pEvaluate;
  }

  public String getpInfluence() {
    return pInfluence;
  }

  public void setpInfluence(String pInfluence) {
    this.pInfluence = pInfluence;
  }

  public String getpCommemoration() {
    return pCommemoration;
  }

  public void setpCommemoration(String pCommemoration) {
    this.pCommemoration = pCommemoration;
  }
}
