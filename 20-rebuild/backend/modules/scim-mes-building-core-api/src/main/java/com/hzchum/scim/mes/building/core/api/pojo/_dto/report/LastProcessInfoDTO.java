package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "LastProcessInfoDTO", description = "")
public class LastProcessInfoDTO {
   @ApiModelProperty(name = "number", notes = "number")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "reportQuantity", notes = "批量上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private Integer reportQuantity;
   @ApiModelProperty(name = "lastProcessName", notes = "最后上报工序")
   @JsonProperty("lastProcessName")
   @JSONField(name = "lastProcessName")
   private String lastProcessName;
   @ApiModelProperty(name = "lastProcessTime", notes = "最后上报时间")
   @JsonProperty("lastProcessTime")
   @JSONField(name = "lastProcessTime")
   private LocalDateTime lastProcessTime;
   @ApiModelProperty(name = "reportUserName", notes = "最后上报人")
   @JsonProperty("reportUserName")
   @JSONField(name = "reportUserName")
   private String reportUserName;
   @ApiModelProperty(name = "boolOneCode", value = "是否一物一码", notes = "是否一物一码")
   @JsonProperty("boolOneCode")
   @JSONField(name = "boolOneCode")
   private Boolean boolOneCode;

   public LastProcessInfoDTO(
      final Integer number,
      final Integer reportQuantity,
      final String lastProcessName,
      final LocalDateTime lastProcessTime,
      final String reportUserName,
      final Boolean boolOneCode
   ) {
      this.number = number;
      this.reportQuantity = reportQuantity;
      this.lastProcessName = lastProcessName;
      this.lastProcessTime = lastProcessTime;
      this.reportUserName = reportUserName;
      this.boolOneCode = boolOneCode;
   }

   public LastProcessInfoDTO() {
   }

   public Integer getNumber() {
      return this.number;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public String getLastProcessName() {
      return this.lastProcessName;
   }

   public LocalDateTime getLastProcessTime() {
      return this.lastProcessTime;
   }

   public String getReportUserName() {
      return this.reportUserName;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   @JsonProperty("number")
   public LastProcessInfoDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("reportQuantity")
   public LastProcessInfoDTO setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("lastProcessName")
   public LastProcessInfoDTO setLastProcessName(final String lastProcessName) {
      this.lastProcessName = lastProcessName;
      return this;
   }

   @JsonProperty("lastProcessTime")
   public LastProcessInfoDTO setLastProcessTime(final LocalDateTime lastProcessTime) {
      this.lastProcessTime = lastProcessTime;
      return this;
   }

   @JsonProperty("reportUserName")
   public LastProcessInfoDTO setReportUserName(final String reportUserName) {
      this.reportUserName = reportUserName;
      return this;
   }

   @JsonProperty("boolOneCode")
   public LastProcessInfoDTO setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   @Override
   public String toString() {
      return "LastProcessInfoDTO(number="
         + this.getNumber()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", lastProcessName="
         + this.getLastProcessName()
         + ", lastProcessTime="
         + this.getLastProcessTime()
         + ", reportUserName="
         + this.getReportUserName()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LastProcessInfoDTO)) {
         return false;
      }

      LastProcessInfoDTO other = (LastProcessInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$number = this.getNumber();
      Object other$number = other.getNumber();
      if (this$number == null ? other$number == null : this$number.equals(other$number)) {
         Object this$reportQuantity = this.getReportQuantity();
         Object other$reportQuantity = other.getReportQuantity();
         if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
            Object this$boolOneCode = this.getBoolOneCode();
            Object other$boolOneCode = other.getBoolOneCode();
            if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
               Object this$lastProcessName = this.getLastProcessName();
               Object other$lastProcessName = other.getLastProcessName();
               if (this$lastProcessName == null ? other$lastProcessName == null : this$lastProcessName.equals(other$lastProcessName)) {
                  Object this$lastProcessTime = this.getLastProcessTime();
                  Object other$lastProcessTime = other.getLastProcessTime();
                  if (this$lastProcessTime == null ? other$lastProcessTime == null : this$lastProcessTime.equals(other$lastProcessTime)) {
                     Object this$reportUserName = this.getReportUserName();
                     Object other$reportUserName = other.getReportUserName();
                     return this$reportUserName == null ? other$reportUserName == null : this$reportUserName.equals(other$reportUserName);
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
      return other instanceof LastProcessInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $lastProcessName = this.getLastProcessName();
      result = result * 59 + ($lastProcessName == null ? 43 : $lastProcessName.hashCode());
      Object $lastProcessTime = this.getLastProcessTime();
      result = result * 59 + ($lastProcessTime == null ? 43 : $lastProcessTime.hashCode());
      Object $reportUserName = this.getReportUserName();
      return result * 59 + ($reportUserName == null ? 43 : $reportUserName.hashCode());
   }
}
