package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CrmTechEntrustLinkListDTO {
   private Long id;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "userName", value = "用户名称", notes = "用户名称")
   private String userName;
   @ApiModelProperty(name = "crmProjectInformationWarehousingSerialNumber", value = "项目编号", notes = "项目编号")
   private String crmProjectInformationWarehousingSerialNumber;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", value = "项目名称", notes = "项目名称")
   private String crmProjectInformationWarehousingName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "所属公司名称", notes = "所属公司名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "regionNames", value = "所属区域名称", notes = "所属区域名称")
   private String regionNames;
   @ApiModelProperty(name = "structureTypeConfigurationName", value = "结构类型名称", notes = "结构类型名称")
   private String structureTypeConfigurationName;
   @ApiModelProperty(name = "crmSettlementBusinessTypeEnum", value = "直营非直营类型", notes = "直营非直营类型")
   private Integer crmSettlementBusinessTypeEnum;
   @ApiModelProperty(name = "estimatedCost", value = "预估造价", notes = "预估造价")
   private BigDecimal estimatedCost;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;

   public CrmTechEntrustLinkListDTO() {
   }

   public CrmTechEntrustLinkListDTO(
      final Long id,
      final LocalDateTime createTime,
      final String userName,
      final String crmProjectInformationWarehousingSerialNumber,
      final String crmProjectInformationWarehousingName,
      final String crmEnterpriseWarehousingName,
      final String regionNames,
      final String structureTypeConfigurationName,
      final Integer crmSettlementBusinessTypeEnum,
      final BigDecimal estimatedCost,
      final String createUserName
   ) {
      this.id = id;
      this.createTime = createTime;
      this.userName = userName;
      this.crmProjectInformationWarehousingSerialNumber = crmProjectInformationWarehousingSerialNumber;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.regionNames = regionNames;
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
      this.estimatedCost = estimatedCost;
      this.createUserName = createUserName;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getCrmProjectInformationWarehousingSerialNumber() {
      return this.crmProjectInformationWarehousingSerialNumber;
   }

   public String getCrmProjectInformationWarehousingName() {
      return this.crmProjectInformationWarehousingName;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public String getRegionNames() {
      return this.regionNames;
   }

   public String getStructureTypeConfigurationName() {
      return this.structureTypeConfigurationName;
   }

   public Integer getCrmSettlementBusinessTypeEnum() {
      return this.crmSettlementBusinessTypeEnum;
   }

   public BigDecimal getEstimatedCost() {
      return this.estimatedCost;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setCrmProjectInformationWarehousingSerialNumber(final String crmProjectInformationWarehousingSerialNumber) {
      this.crmProjectInformationWarehousingSerialNumber = crmProjectInformationWarehousingSerialNumber;
   }

   public void setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
   }

   public void setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
   }

   public void setRegionNames(final String regionNames) {
      this.regionNames = regionNames;
   }

   public void setStructureTypeConfigurationName(final String structureTypeConfigurationName) {
      this.structureTypeConfigurationName = structureTypeConfigurationName;
   }

   public void setCrmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
   }

   public void setEstimatedCost(final BigDecimal estimatedCost) {
      this.estimatedCost = estimatedCost;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmTechEntrustLinkListDTO)) {
         return false;
      }

      CrmTechEntrustLinkListDTO other = (CrmTechEntrustLinkListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
         Object other$crmSettlementBusinessTypeEnum = other.getCrmSettlementBusinessTypeEnum();
         if (this$crmSettlementBusinessTypeEnum == null
            ? other$crmSettlementBusinessTypeEnum == null
            : this$crmSettlementBusinessTypeEnum.equals(other$crmSettlementBusinessTypeEnum)) {
            Object this$createTime = this.getCreateTime();
            Object other$createTime = other.getCreateTime();
            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                  Object this$crmProjectInformationWarehousingSerialNumber = this.getCrmProjectInformationWarehousingSerialNumber();
                  Object other$crmProjectInformationWarehousingSerialNumber = other.getCrmProjectInformationWarehousingSerialNumber();
                  if (this$crmProjectInformationWarehousingSerialNumber == null
                     ? other$crmProjectInformationWarehousingSerialNumber == null
                     : this$crmProjectInformationWarehousingSerialNumber.equals(other$crmProjectInformationWarehousingSerialNumber)) {
                     Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
                     Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
                     if (this$crmProjectInformationWarehousingName == null
                        ? other$crmProjectInformationWarehousingName == null
                        : this$crmProjectInformationWarehousingName.equals(other$crmProjectInformationWarehousingName)) {
                        Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                        Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                        if (this$crmEnterpriseWarehousingName == null
                           ? other$crmEnterpriseWarehousingName == null
                           : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                           Object this$regionNames = this.getRegionNames();
                           Object other$regionNames = other.getRegionNames();
                           if (this$regionNames == null ? other$regionNames == null : this$regionNames.equals(other$regionNames)) {
                              Object this$structureTypeConfigurationName = this.getStructureTypeConfigurationName();
                              Object other$structureTypeConfigurationName = other.getStructureTypeConfigurationName();
                              if (this$structureTypeConfigurationName == null
                                 ? other$structureTypeConfigurationName == null
                                 : this$structureTypeConfigurationName.equals(other$structureTypeConfigurationName)) {
                                 Object this$estimatedCost = this.getEstimatedCost();
                                 Object other$estimatedCost = other.getEstimatedCost();
                                 if (this$estimatedCost == null ? other$estimatedCost == null : this$estimatedCost.equals(other$estimatedCost)) {
                                    Object this$createUserName = this.getCreateUserName();
                                    Object other$createUserName = other.getCreateUserName();
                                    return this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName);
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
      return other instanceof CrmTechEntrustLinkListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
      result = result * 59 + ($crmSettlementBusinessTypeEnum == null ? 43 : $crmSettlementBusinessTypeEnum.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $crmProjectInformationWarehousingSerialNumber = this.getCrmProjectInformationWarehousingSerialNumber();
      result = result * 59 + ($crmProjectInformationWarehousingSerialNumber == null ? 43 : $crmProjectInformationWarehousingSerialNumber.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      result = result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $regionNames = this.getRegionNames();
      result = result * 59 + ($regionNames == null ? 43 : $regionNames.hashCode());
      Object $structureTypeConfigurationName = this.getStructureTypeConfigurationName();
      result = result * 59 + ($structureTypeConfigurationName == null ? 43 : $structureTypeConfigurationName.hashCode());
      Object $estimatedCost = this.getEstimatedCost();
      result = result * 59 + ($estimatedCost == null ? 43 : $estimatedCost.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   @Override
   public String toString() {
      return "CrmTechEntrustLinkListDTO(id="
         + this.getId()
         + ", createTime="
         + this.getCreateTime()
         + ", userName="
         + this.getUserName()
         + ", crmProjectInformationWarehousingSerialNumber="
         + this.getCrmProjectInformationWarehousingSerialNumber()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", regionNames="
         + this.getRegionNames()
         + ", structureTypeConfigurationName="
         + this.getStructureTypeConfigurationName()
         + ", crmSettlementBusinessTypeEnum="
         + this.getCrmSettlementBusinessTypeEnum()
         + ", estimatedCost="
         + this.getEstimatedCost()
         + ", createUserName="
         + this.getCreateUserName()
         + ")";
   }
}
