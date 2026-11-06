package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "UserProductionDetailDTO", description = " ")
public class UserProductionDetailDTO {
   @ApiModelProperty(name = "name", value = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "processId", value = "工序ID")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", value = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "reportQuantity", value = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private BigDecimal reportQuantity;
   @ApiModelProperty(name = "reportWeight", value = "上报重量")
   @JsonProperty("reportWeight")
   @JSONField(name = "reportWeight")
   private BigDecimal reportWeight;
   @ApiModelProperty(name = "userName", value = "用户名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "reportTime", value = "上报时间")
   @JsonProperty("reportTime")
   @JSONField(name = "reportTime")
   private String reportTime;

   public static UserProductionDetailDTO.UserProductionDetailDTOBuilder builder() {
      return new UserProductionDetailDTO.UserProductionDetailDTOBuilder();
   }

   public UserProductionDetailDTO() {
   }

   public UserProductionDetailDTO(
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final BigDecimal netWeight,
      final Long processId,
      final String processName,
      final BigDecimal reportQuantity,
      final BigDecimal reportWeight,
      final String userName,
      final String reportTime
   ) {
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.netWeight = netWeight;
      this.processId = processId;
      this.processName = processName;
      this.reportQuantity = reportQuantity;
      this.reportWeight = reportWeight;
      this.userName = userName;
      this.reportTime = reportTime;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public BigDecimal getReportQuantity() {
      return this.reportQuantity;
   }

   public BigDecimal getReportWeight() {
      return this.reportWeight;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getReportTime() {
      return this.reportTime;
   }

   @JsonProperty("name")
   public UserProductionDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public UserProductionDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public UserProductionDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public UserProductionDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("netWeight")
   public UserProductionDetailDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("processId")
   public UserProductionDetailDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public UserProductionDetailDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("reportQuantity")
   public UserProductionDetailDTO setReportQuantity(final BigDecimal reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("reportWeight")
   public UserProductionDetailDTO setReportWeight(final BigDecimal reportWeight) {
      this.reportWeight = reportWeight;
      return this;
   }

   @JsonProperty("userName")
   public UserProductionDetailDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("reportTime")
   public UserProductionDetailDTO setReportTime(final String reportTime) {
      this.reportTime = reportTime;
      return this;
   }

   @Override
   public String toString() {
      return "UserProductionDetailDTO(name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportWeight="
         + this.getReportWeight()
         + ", userName="
         + this.getUserName()
         + ", reportTime="
         + this.getReportTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserProductionDetailDTO)) {
         return false;
      }

      UserProductionDetailDTO other = (UserProductionDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$length = this.getLength();
                  Object other$length = other.getLength();
                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                     Object this$netWeight = this.getNetWeight();
                     Object other$netWeight = other.getNetWeight();
                     if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                        Object this$processName = this.getProcessName();
                        Object other$processName = other.getProcessName();
                        if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                           Object this$reportQuantity = this.getReportQuantity();
                           Object other$reportQuantity = other.getReportQuantity();
                           if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
                              Object this$reportWeight = this.getReportWeight();
                              Object other$reportWeight = other.getReportWeight();
                              if (this$reportWeight == null ? other$reportWeight == null : this$reportWeight.equals(other$reportWeight)) {
                                 Object this$userName = this.getUserName();
                                 Object other$userName = other.getUserName();
                                 if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                    Object this$reportTime = this.getReportTime();
                                    Object other$reportTime = other.getReportTime();
                                    return this$reportTime == null ? other$reportTime == null : this$reportTime.equals(other$reportTime);
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
      return other instanceof UserProductionDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $reportWeight = this.getReportWeight();
      result = result * 59 + ($reportWeight == null ? 43 : $reportWeight.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $reportTime = this.getReportTime();
      return result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
   }

   public static class UserProductionDetailDTOBuilder {
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private BigDecimal netWeight;
      private Long processId;
      private String processName;
      private BigDecimal reportQuantity;
      private BigDecimal reportWeight;
      private String userName;
      private String reportTime;

      UserProductionDetailDTOBuilder() {
      }

      @JsonProperty("name")
      public UserProductionDetailDTO.UserProductionDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public UserProductionDetailDTO.UserProductionDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public UserProductionDetailDTO.UserProductionDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public UserProductionDetailDTO.UserProductionDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("netWeight")
      public UserProductionDetailDTO.UserProductionDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("processId")
      public UserProductionDetailDTO.UserProductionDetailDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public UserProductionDetailDTO.UserProductionDetailDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("reportQuantity")
      public UserProductionDetailDTO.UserProductionDetailDTOBuilder reportQuantity(final BigDecimal reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("reportWeight")
      public UserProductionDetailDTO.UserProductionDetailDTOBuilder reportWeight(final BigDecimal reportWeight) {
         this.reportWeight = reportWeight;
         return this;
      }

      @JsonProperty("userName")
      public UserProductionDetailDTO.UserProductionDetailDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("reportTime")
      public UserProductionDetailDTO.UserProductionDetailDTOBuilder reportTime(final String reportTime) {
         this.reportTime = reportTime;
         return this;
      }

      public UserProductionDetailDTO build() {
         return new UserProductionDetailDTO(
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.netWeight,
            this.processId,
            this.processName,
            this.reportQuantity,
            this.reportWeight,
            this.userName,
            this.reportTime
         );
      }

      @Override
      public String toString() {
         return "UserProductionDetailDTO.UserProductionDetailDTOBuilder(name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", reportQuantity="
            + this.reportQuantity
            + ", reportWeight="
            + this.reportWeight
            + ", userName="
            + this.userName
            + ", reportTime="
            + this.reportTime
            + ")";
      }
   }
}
