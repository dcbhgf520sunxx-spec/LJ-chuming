package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ContractPreRegistrationDTOParam {
   private Long id;
   @ApiModelProperty(name = "preRegistrationNo", value = "合同预登记编号")
   private String preRegistrationNo;
   @ApiModelProperty(name = "partyType", value = "甲方类别")
   private Long partyType;
   @ApiModelProperty(name = "partyName", value = "甲方或业主名称")
   private String partyName;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "contractAmount", value = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "boolBidWinningNotice", value = "是否存在中标通知书")
   private Boolean boolBidWinningNotice;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   private Long structureType;
   @ApiModelProperty(name = "contractualNature", value = "承包性质")
   private Long contractualNature;
   @ApiModelProperty(name = "signerId", value = "签订人ID")
   private Long signerId;
   @ApiModelProperty(name = "signerName", value = "签订人姓名")
   private String signerName;
   @ApiModelProperty(name = "locationId", value = "区域ID")
   private Long locationId;
   @ApiModelProperty(name = "countryId", value = "国家ID")
   private Long countryId;
   @ApiModelProperty(name = "provinceId", value = "省份ID")
   private Long provinceId;
   @ApiModelProperty(name = "cityId", value = "城市ID")
   private Long cityId;
   @ApiModelProperty(name = "regionId", value = "区ID")
   private Long regionId;
   @ApiModelProperty(name = "structureArea", value = "建筑面积（平方米）")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "infoSource", value = "信息来源")
   private Integer infoSource;
   @ApiModelProperty(name = "boolQuote", value = "是否引用")
   private Boolean boolQuote;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "initDataId", value = "初始数据ID")
   private Long initDataId;

   ContractPreRegistrationDTOParam(
      final Long id,
      final String preRegistrationNo,
      final Long partyType,
      final String partyName,
      final String projectName,
      final BigDecimal contractAmount,
      final Boolean boolBidWinningNotice,
      final Long structureType,
      final Long contractualNature,
      final Long signerId,
      final String signerName,
      final Long locationId,
      final Long countryId,
      final Long provinceId,
      final Long cityId,
      final Long regionId,
      final BigDecimal structureArea,
      final Integer infoSource,
      final Boolean boolQuote,
      final String remark,
      final Long initDataId
   ) {
      this.id = id;
      this.preRegistrationNo = preRegistrationNo;
      this.partyType = partyType;
      this.partyName = partyName;
      this.projectName = projectName;
      this.contractAmount = contractAmount;
      this.boolBidWinningNotice = boolBidWinningNotice;
      this.structureType = structureType;
      this.contractualNature = contractualNature;
      this.signerId = signerId;
      this.signerName = signerName;
      this.locationId = locationId;
      this.countryId = countryId;
      this.provinceId = provinceId;
      this.cityId = cityId;
      this.regionId = regionId;
      this.structureArea = structureArea;
      this.infoSource = infoSource;
      this.boolQuote = boolQuote;
      this.remark = remark;
      this.initDataId = initDataId;
   }

   public static ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder builder() {
      return new ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getPreRegistrationNo() {
      return this.preRegistrationNo;
   }

   public Long getPartyType() {
      return this.partyType;
   }

   public String getPartyName() {
      return this.partyName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public Boolean getBoolBidWinningNotice() {
      return this.boolBidWinningNotice;
   }

   public Long getStructureType() {
      return this.structureType;
   }

   public Long getContractualNature() {
      return this.contractualNature;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public Long getLocationId() {
      return this.locationId;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public BigDecimal getStructureArea() {
      return this.structureArea;
   }

   public Integer getInfoSource() {
      return this.infoSource;
   }

   public Boolean getBoolQuote() {
      return this.boolQuote;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getInitDataId() {
      return this.initDataId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPreRegistrationNo(final String preRegistrationNo) {
      this.preRegistrationNo = preRegistrationNo;
   }

   public void setPartyType(final Long partyType) {
      this.partyType = partyType;
   }

   public void setPartyName(final String partyName) {
      this.partyName = partyName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setBoolBidWinningNotice(final Boolean boolBidWinningNotice) {
      this.boolBidWinningNotice = boolBidWinningNotice;
   }

   public void setStructureType(final Long structureType) {
      this.structureType = structureType;
   }

   public void setContractualNature(final Long contractualNature) {
      this.contractualNature = contractualNature;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setLocationId(final Long locationId) {
      this.locationId = locationId;
   }

   public void setCountryId(final Long countryId) {
      this.countryId = countryId;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   public void setRegionId(final Long regionId) {
      this.regionId = regionId;
   }

   public void setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
   }

   public void setInfoSource(final Integer infoSource) {
      this.infoSource = infoSource;
   }

   public void setBoolQuote(final Boolean boolQuote) {
      this.boolQuote = boolQuote;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setInitDataId(final Long initDataId) {
      this.initDataId = initDataId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractPreRegistrationDTOParam)) {
         return false;
      }

      ContractPreRegistrationDTOParam other = (ContractPreRegistrationDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$partyType = this.getPartyType();
         Object other$partyType = other.getPartyType();
         if (this$partyType == null ? other$partyType == null : this$partyType.equals(other$partyType)) {
            Object this$boolBidWinningNotice = this.getBoolBidWinningNotice();
            Object other$boolBidWinningNotice = other.getBoolBidWinningNotice();
            if (this$boolBidWinningNotice == null ? other$boolBidWinningNotice == null : this$boolBidWinningNotice.equals(other$boolBidWinningNotice)) {
               Object this$structureType = this.getStructureType();
               Object other$structureType = other.getStructureType();
               if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                  Object this$contractualNature = this.getContractualNature();
                  Object other$contractualNature = other.getContractualNature();
                  if (this$contractualNature == null ? other$contractualNature == null : this$contractualNature.equals(other$contractualNature)) {
                     Object this$signerId = this.getSignerId();
                     Object other$signerId = other.getSignerId();
                     if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
                        Object this$locationId = this.getLocationId();
                        Object other$locationId = other.getLocationId();
                        if (this$locationId == null ? other$locationId == null : this$locationId.equals(other$locationId)) {
                           Object this$countryId = this.getCountryId();
                           Object other$countryId = other.getCountryId();
                           if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
                              Object this$provinceId = this.getProvinceId();
                              Object other$provinceId = other.getProvinceId();
                              if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
                                 Object this$cityId = this.getCityId();
                                 Object other$cityId = other.getCityId();
                                 if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
                                    Object this$regionId = this.getRegionId();
                                    Object other$regionId = other.getRegionId();
                                    if (this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId)) {
                                       Object this$infoSource = this.getInfoSource();
                                       Object other$infoSource = other.getInfoSource();
                                       if (this$infoSource == null ? other$infoSource == null : this$infoSource.equals(other$infoSource)) {
                                          Object this$boolQuote = this.getBoolQuote();
                                          Object other$boolQuote = other.getBoolQuote();
                                          if (this$boolQuote == null ? other$boolQuote == null : this$boolQuote.equals(other$boolQuote)) {
                                             Object this$initDataId = this.getInitDataId();
                                             Object other$initDataId = other.getInitDataId();
                                             if (this$initDataId == null ? other$initDataId == null : this$initDataId.equals(other$initDataId)) {
                                                Object this$preRegistrationNo = this.getPreRegistrationNo();
                                                Object other$preRegistrationNo = other.getPreRegistrationNo();
                                                if (this$preRegistrationNo == null
                                                   ? other$preRegistrationNo == null
                                                   : this$preRegistrationNo.equals(other$preRegistrationNo)) {
                                                   Object this$partyName = this.getPartyName();
                                                   Object other$partyName = other.getPartyName();
                                                   if (this$partyName == null ? other$partyName == null : this$partyName.equals(other$partyName)) {
                                                      Object this$projectName = this.getProjectName();
                                                      Object other$projectName = other.getProjectName();
                                                      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                         Object this$contractAmount = this.getContractAmount();
                                                         Object other$contractAmount = other.getContractAmount();
                                                         if (this$contractAmount == null
                                                            ? other$contractAmount == null
                                                            : this$contractAmount.equals(other$contractAmount)) {
                                                            Object this$signerName = this.getSignerName();
                                                            Object other$signerName = other.getSignerName();
                                                            if (this$signerName == null ? other$signerName == null : this$signerName.equals(other$signerName)) {
                                                               Object this$structureArea = this.getStructureArea();
                                                               Object other$structureArea = other.getStructureArea();
                                                               if (this$structureArea == null
                                                                  ? other$structureArea == null
                                                                  : this$structureArea.equals(other$structureArea)) {
                                                                  Object this$remark = this.getRemark();
                                                                  Object other$remark = other.getRemark();
                                                                  return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ContractPreRegistrationDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partyType = this.getPartyType();
      result = result * 59 + ($partyType == null ? 43 : $partyType.hashCode());
      Object $boolBidWinningNotice = this.getBoolBidWinningNotice();
      result = result * 59 + ($boolBidWinningNotice == null ? 43 : $boolBidWinningNotice.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $contractualNature = this.getContractualNature();
      result = result * 59 + ($contractualNature == null ? 43 : $contractualNature.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $locationId = this.getLocationId();
      result = result * 59 + ($locationId == null ? 43 : $locationId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $boolQuote = this.getBoolQuote();
      result = result * 59 + ($boolQuote == null ? 43 : $boolQuote.hashCode());
      Object $initDataId = this.getInitDataId();
      result = result * 59 + ($initDataId == null ? 43 : $initDataId.hashCode());
      Object $preRegistrationNo = this.getPreRegistrationNo();
      result = result * 59 + ($preRegistrationNo == null ? 43 : $preRegistrationNo.hashCode());
      Object $partyName = this.getPartyName();
      result = result * 59 + ($partyName == null ? 43 : $partyName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractPreRegistrationDTOParam(id="
         + this.getId()
         + ", preRegistrationNo="
         + this.getPreRegistrationNo()
         + ", partyType="
         + this.getPartyType()
         + ", partyName="
         + this.getPartyName()
         + ", projectName="
         + this.getProjectName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", boolBidWinningNotice="
         + this.getBoolBidWinningNotice()
         + ", structureType="
         + this.getStructureType()
         + ", contractualNature="
         + this.getContractualNature()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", locationId="
         + this.getLocationId()
         + ", countryId="
         + this.getCountryId()
         + ", provinceId="
         + this.getProvinceId()
         + ", cityId="
         + this.getCityId()
         + ", regionId="
         + this.getRegionId()
         + ", structureArea="
         + this.getStructureArea()
         + ", infoSource="
         + this.getInfoSource()
         + ", boolQuote="
         + this.getBoolQuote()
         + ", remark="
         + this.getRemark()
         + ", initDataId="
         + this.getInitDataId()
         + ")";
   }

   public static class ContractPreRegistrationDTOParamBuilder {
      private Long id;
      private String preRegistrationNo;
      private Long partyType;
      private String partyName;
      private String projectName;
      private BigDecimal contractAmount;
      private Boolean boolBidWinningNotice;
      private Long structureType;
      private Long contractualNature;
      private Long signerId;
      private String signerName;
      private Long locationId;
      private Long countryId;
      private Long provinceId;
      private Long cityId;
      private Long regionId;
      private BigDecimal structureArea;
      private Integer infoSource;
      private Boolean boolQuote;
      private String remark;
      private Long initDataId;

      ContractPreRegistrationDTOParamBuilder() {
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder preRegistrationNo(final String preRegistrationNo) {
         this.preRegistrationNo = preRegistrationNo;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder partyType(final Long partyType) {
         this.partyType = partyType;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder partyName(final String partyName) {
         this.partyName = partyName;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder boolBidWinningNotice(final Boolean boolBidWinningNotice) {
         this.boolBidWinningNotice = boolBidWinningNotice;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder structureType(final Long structureType) {
         this.structureType = structureType;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder contractualNature(final Long contractualNature) {
         this.contractualNature = contractualNature;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder locationId(final Long locationId) {
         this.locationId = locationId;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder structureArea(final BigDecimal structureArea) {
         this.structureArea = structureArea;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder infoSource(final Integer infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder boolQuote(final Boolean boolQuote) {
         this.boolQuote = boolQuote;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder initDataId(final Long initDataId) {
         this.initDataId = initDataId;
         return this;
      }

      public ContractPreRegistrationDTOParam build() {
         return new ContractPreRegistrationDTOParam(
            this.id,
            this.preRegistrationNo,
            this.partyType,
            this.partyName,
            this.projectName,
            this.contractAmount,
            this.boolBidWinningNotice,
            this.structureType,
            this.contractualNature,
            this.signerId,
            this.signerName,
            this.locationId,
            this.countryId,
            this.provinceId,
            this.cityId,
            this.regionId,
            this.structureArea,
            this.infoSource,
            this.boolQuote,
            this.remark,
            this.initDataId
         );
      }

      @Override
      public String toString() {
         return "ContractPreRegistrationDTOParam.ContractPreRegistrationDTOParamBuilder(id="
            + this.id
            + ", preRegistrationNo="
            + this.preRegistrationNo
            + ", partyType="
            + this.partyType
            + ", partyName="
            + this.partyName
            + ", projectName="
            + this.projectName
            + ", contractAmount="
            + this.contractAmount
            + ", boolBidWinningNotice="
            + this.boolBidWinningNotice
            + ", structureType="
            + this.structureType
            + ", contractualNature="
            + this.contractualNature
            + ", signerId="
            + this.signerId
            + ", signerName="
            + this.signerName
            + ", locationId="
            + this.locationId
            + ", countryId="
            + this.countryId
            + ", provinceId="
            + this.provinceId
            + ", cityId="
            + this.cityId
            + ", regionId="
            + this.regionId
            + ", structureArea="
            + this.structureArea
            + ", infoSource="
            + this.infoSource
            + ", boolQuote="
            + this.boolQuote
            + ", remark="
            + this.remark
            + ", initDataId="
            + this.initDataId
            + ")";
      }
   }
}
