package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Arrays;

@ExcelTarget("MesBuildingQhseDataExcelDTO")
public class MesBuildingQhseDataExcelDTO {
   @Excel(name = "序号", width = 5.0)
   private Long orderNo;
   @ApiModelProperty(name = "qhseNumber", value = "质检编号")
   @Excel(name = "质检编号", width = 20.0)
   private String qhseNumber;
   @ApiModelProperty(name = "userName", value = "检查人")
   @Excel(name = "检查人", width = 15.0)
   private String userName;
   @ApiModelProperty(name = "createTime", value = "检查日期")
   @Excel(name = "检查日期", width = 15.0)
   private String createTime;
   @ApiModelProperty(name = "dutyName", value = "责任人")
   @Excel(name = "责任人", width = 15.0)
   private String dutyName;
   @ApiModelProperty(name = "levelOneName", value = "质量分类")
   @Excel(name = "质量分类", width = 20.0)
   private String levelOneName;
   @ApiModelProperty(name = "levelTwoName", value = "子类")
   @Excel(name = "子类", width = 20.0)
   private String levelTwoName;
   @ApiModelProperty(name = "behaviorScore", notes = "扣分")
   @Excel(name = "扣分", width = 10.0)
   private Integer behaviorScore;
   @ApiModelProperty(name = "penalty", value = "罚金")
   @Excel(name = "处罚", width = 10.0)
   private BigDecimal penalty;
   @ApiModelProperty(name = "status", value = "状态")
   @Excel(name = "状态", width = 20.0, replace = {"未回复_1", "已反馈_2", "整改通过_4", "整改未通过_8", "让步接收_16", "让步接收通过_32", "让步接收驳回_64"})
   private Integer status;
   @ApiModelProperty(name = "entranceAttachment", value = "整改前图片")
   @Excel(name = "整改前", width = 25.0, height = 30.0, type = 2, imageType = 2)
   private byte[] entranceAttachment;
   @ApiModelProperty(name = "remark", value = "文字备注")
   @Excel(name = "文字备注", width = 20.0, isWrap = true)
   private String remark;
   @ApiModelProperty(name = "entranceAttachment", value = "整改后图片")
   @Excel(name = "整改后", width = 20.0, height = 30.0, type = 2, imageType = 2)
   private byte[] afterAttachment;
   @ApiModelProperty(name = "remark", value = "文字备注")
   @Excel(name = "文字备注", width = 20.0, isWrap = true)
   private String afterRemark;

   public Long getOrderNo() {
      return this.orderNo;
   }

   public String getQhseNumber() {
      return this.qhseNumber;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getCreateTime() {
      return this.createTime;
   }

   public String getDutyName() {
      return this.dutyName;
   }

   public String getLevelOneName() {
      return this.levelOneName;
   }

   public String getLevelTwoName() {
      return this.levelTwoName;
   }

   public Integer getBehaviorScore() {
      return this.behaviorScore;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public Integer getStatus() {
      return this.status;
   }

   public byte[] getEntranceAttachment() {
      return this.entranceAttachment;
   }

   public String getRemark() {
      return this.remark;
   }

   public byte[] getAfterAttachment() {
      return this.afterAttachment;
   }

   public String getAfterRemark() {
      return this.afterRemark;
   }

   public void setOrderNo(final Long orderNo) {
      this.orderNo = orderNo;
   }

   public void setQhseNumber(final String qhseNumber) {
      this.qhseNumber = qhseNumber;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setCreateTime(final String createTime) {
      this.createTime = createTime;
   }

   public void setDutyName(final String dutyName) {
      this.dutyName = dutyName;
   }

   public void setLevelOneName(final String levelOneName) {
      this.levelOneName = levelOneName;
   }

   public void setLevelTwoName(final String levelTwoName) {
      this.levelTwoName = levelTwoName;
   }

   public void setBehaviorScore(final Integer behaviorScore) {
      this.behaviorScore = behaviorScore;
   }

   public void setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setEntranceAttachment(final byte[] entranceAttachment) {
      this.entranceAttachment = entranceAttachment;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAfterAttachment(final byte[] afterAttachment) {
      this.afterAttachment = afterAttachment;
   }

   public void setAfterRemark(final String afterRemark) {
      this.afterRemark = afterRemark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseDataExcelDTO)) {
         return false;
      }

      MesBuildingQhseDataExcelDTO other = (MesBuildingQhseDataExcelDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$behaviorScore = this.getBehaviorScore();
         Object other$behaviorScore = other.getBehaviorScore();
         if (this$behaviorScore == null ? other$behaviorScore == null : this$behaviorScore.equals(other$behaviorScore)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$qhseNumber = this.getQhseNumber();
               Object other$qhseNumber = other.getQhseNumber();
               if (this$qhseNumber == null ? other$qhseNumber == null : this$qhseNumber.equals(other$qhseNumber)) {
                  Object this$userName = this.getUserName();
                  Object other$userName = other.getUserName();
                  if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                        Object this$dutyName = this.getDutyName();
                        Object other$dutyName = other.getDutyName();
                        if (this$dutyName == null ? other$dutyName == null : this$dutyName.equals(other$dutyName)) {
                           Object this$levelOneName = this.getLevelOneName();
                           Object other$levelOneName = other.getLevelOneName();
                           if (this$levelOneName == null ? other$levelOneName == null : this$levelOneName.equals(other$levelOneName)) {
                              Object this$levelTwoName = this.getLevelTwoName();
                              Object other$levelTwoName = other.getLevelTwoName();
                              if (this$levelTwoName == null ? other$levelTwoName == null : this$levelTwoName.equals(other$levelTwoName)) {
                                 Object this$penalty = this.getPenalty();
                                 Object other$penalty = other.getPenalty();
                                 if (this$penalty == null ? other$penalty == null : this$penalty.equals(other$penalty)) {
                                    if (!Arrays.equals(this.getEntranceAttachment(), other.getEntranceAttachment())) {
                                       return false;
                                    }

                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       if (!Arrays.equals(this.getAfterAttachment(), other.getAfterAttachment())) {
                                          return false;
                                       }

                                       Object this$afterRemark = this.getAfterRemark();
                                       Object other$afterRemark = other.getAfterRemark();
                                       return this$afterRemark == null ? other$afterRemark == null : this$afterRemark.equals(other$afterRemark);
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingQhseDataExcelDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $behaviorScore = this.getBehaviorScore();
      result = result * 59 + ($behaviorScore == null ? 43 : $behaviorScore.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $qhseNumber = this.getQhseNumber();
      result = result * 59 + ($qhseNumber == null ? 43 : $qhseNumber.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $dutyName = this.getDutyName();
      result = result * 59 + ($dutyName == null ? 43 : $dutyName.hashCode());
      Object $levelOneName = this.getLevelOneName();
      result = result * 59 + ($levelOneName == null ? 43 : $levelOneName.hashCode());
      Object $levelTwoName = this.getLevelTwoName();
      result = result * 59 + ($levelTwoName == null ? 43 : $levelTwoName.hashCode());
      Object $penalty = this.getPenalty();
      result = result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
      result = result * 59 + Arrays.hashCode(this.getEntranceAttachment());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      result = result * 59 + Arrays.hashCode(this.getAfterAttachment());
      Object $afterRemark = this.getAfterRemark();
      return result * 59 + ($afterRemark == null ? 43 : $afterRemark.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingQhseDataExcelDTO(orderNo="
         + this.getOrderNo()
         + ", qhseNumber="
         + this.getQhseNumber()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", dutyName="
         + this.getDutyName()
         + ", levelOneName="
         + this.getLevelOneName()
         + ", levelTwoName="
         + this.getLevelTwoName()
         + ", behaviorScore="
         + this.getBehaviorScore()
         + ", penalty="
         + this.getPenalty()
         + ", status="
         + this.getStatus()
         + ", entranceAttachment="
         + Arrays.toString(this.getEntranceAttachment())
         + ", remark="
         + this.getRemark()
         + ", afterAttachment="
         + Arrays.toString(this.getAfterAttachment())
         + ", afterRemark="
         + this.getAfterRemark()
         + ")";
   }
}
