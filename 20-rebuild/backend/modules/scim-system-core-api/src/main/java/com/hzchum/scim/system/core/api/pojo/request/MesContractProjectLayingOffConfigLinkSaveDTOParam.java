package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.system.core.api.common.enums.StatisticsConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.common.enums.WageConfigStatisticsModeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("项目下料配置关联新增类")
public class MesContractProjectLayingOffConfigLinkSaveDTOParam {
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotNull(groups = {Add.class, Update.class}, message = "项目ID不能为空")
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   private Long contractProjectId;
   @NotNull(groups = {Add.class, Update.class}, message = "零件类型不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = ProductClassificationEnum.class, message = "零件类型不存在")
   @ApiModelProperty(name = "machinePartType", value = "零件类型", notes = "零件类型")
   private Integer machinePartType;
   @ApiModelProperty(name = "steelClassificationId", value = "零件类型分类ID", notes = "零件类型分类ID")
   private Long steelClassificationId;
   @NotNull(groups = {Add.class, Update.class}, message = "统计模式不能为空")
   @EnumValidator(value = WageConfigStatisticsModeEnum.class, message = "统计模式不存在")
   @ApiModelProperty(name = "statisticsMode", value = "统计模式", notes = "统计模式")
   private Integer statisticsMode;
   @NotNull(groups = {Add.class, Update.class}, message = "是否一口价不能为空")
   @ApiModelProperty(name = "boolFixedPrice", value = "是否一口价", notes = "是否一口价")
   private Boolean boolFixedPrice;
   @ApiModelProperty(name = "processIdList", value = "生产工序", notes = "生产工序")
   private List<Long> processIdList;
   @ApiModelProperty(name = "measurementManner", value = "计量方式", notes = "计量方式")
   private Integer measurementManner;
   @NotNull(groups = {Add.class, Update.class}, message = "编制内单价不能为空")
   @ApiModelProperty(name = "organizationInsidePrice", value = "编制内单价(元)", notes = "编制内单价(元)")
   @Positive(groups = {Add.class, Update.class}, message = "编制内单价要大于0")
   private BigDecimal organizationInsidePrice;
   @NotNull(groups = {Add.class, Update.class}, message = "编制外单价不能为空")
   @ApiModelProperty(name = "organizationOutsidePrice", value = "编制外单价(元)", notes = "编制外单价(元)")
   @Positive(groups = {Add.class, Update.class}, message = "编制外单价要大于0")
   private BigDecimal organizationOutsidePrice;
   @NotNull(groups = {Add.class, Update.class}, message = "统计配置统计模式不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = StatisticsConfigStatisticsModeEnum.class, message = "统计配置统计模式不存在")
   @ApiModelProperty(name = "statisticsConfigStatisticsMode", value = "统计配置统计模式", notes = "统计配置统计模式")
   private Integer statisticsConfigStatisticsMode;

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public Integer getMachinePartType() {
      return this.machinePartType;
   }

   public Long getSteelClassificationId() {
      return this.steelClassificationId;
   }

   public Integer getStatisticsMode() {
      return this.statisticsMode;
   }

   public Boolean getBoolFixedPrice() {
      return this.boolFixedPrice;
   }

   public List<Long> getProcessIdList() {
      return this.processIdList;
   }

   public Integer getMeasurementManner() {
      return this.measurementManner;
   }

   public BigDecimal getOrganizationInsidePrice() {
      return this.organizationInsidePrice;
   }

   public BigDecimal getOrganizationOutsidePrice() {
      return this.organizationOutsidePrice;
   }

   public Integer getStatisticsConfigStatisticsMode() {
      return this.statisticsConfigStatisticsMode;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
   }

   public void setMachinePartType(final Integer machinePartType) {
      this.machinePartType = machinePartType;
   }

   public void setSteelClassificationId(final Long steelClassificationId) {
      this.steelClassificationId = steelClassificationId;
   }

   public void setStatisticsMode(final Integer statisticsMode) {
      this.statisticsMode = statisticsMode;
   }

   public void setBoolFixedPrice(final Boolean boolFixedPrice) {
      this.boolFixedPrice = boolFixedPrice;
   }

   public void setProcessIdList(final List<Long> processIdList) {
      this.processIdList = processIdList;
   }

   public void setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
   }

   public void setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
   }

   public void setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
   }

   public void setStatisticsConfigStatisticsMode(final Integer statisticsConfigStatisticsMode) {
      this.statisticsConfigStatisticsMode = statisticsConfigStatisticsMode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectLayingOffConfigLinkSaveDTOParam)) {
         return false;
      }

      MesContractProjectLayingOffConfigLinkSaveDTOParam other = (MesContractProjectLayingOffConfigLinkSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
            Object this$machinePartType = this.getMachinePartType();
            Object other$machinePartType = other.getMachinePartType();
            if (this$machinePartType == null ? other$machinePartType == null : this$machinePartType.equals(other$machinePartType)) {
               Object this$steelClassificationId = this.getSteelClassificationId();
               Object other$steelClassificationId = other.getSteelClassificationId();
               if (this$steelClassificationId == null ? other$steelClassificationId == null : this$steelClassificationId.equals(other$steelClassificationId)) {
                  Object this$statisticsMode = this.getStatisticsMode();
                  Object other$statisticsMode = other.getStatisticsMode();
                  if (this$statisticsMode == null ? other$statisticsMode == null : this$statisticsMode.equals(other$statisticsMode)) {
                     Object this$boolFixedPrice = this.getBoolFixedPrice();
                     Object other$boolFixedPrice = other.getBoolFixedPrice();
                     if (this$boolFixedPrice == null ? other$boolFixedPrice == null : this$boolFixedPrice.equals(other$boolFixedPrice)) {
                        Object this$measurementManner = this.getMeasurementManner();
                        Object other$measurementManner = other.getMeasurementManner();
                        if (this$measurementManner == null ? other$measurementManner == null : this$measurementManner.equals(other$measurementManner)) {
                           Object this$statisticsConfigStatisticsMode = this.getStatisticsConfigStatisticsMode();
                           Object other$statisticsConfigStatisticsMode = other.getStatisticsConfigStatisticsMode();
                           if (this$statisticsConfigStatisticsMode == null
                              ? other$statisticsConfigStatisticsMode == null
                              : this$statisticsConfigStatisticsMode.equals(other$statisticsConfigStatisticsMode)) {
                              Object this$processIdList = this.getProcessIdList();
                              Object other$processIdList = other.getProcessIdList();
                              if (this$processIdList == null ? other$processIdList == null : this$processIdList.equals(other$processIdList)) {
                                 Object this$organizationInsidePrice = this.getOrganizationInsidePrice();
                                 Object other$organizationInsidePrice = other.getOrganizationInsidePrice();
                                 if (this$organizationInsidePrice == null
                                    ? other$organizationInsidePrice == null
                                    : this$organizationInsidePrice.equals(other$organizationInsidePrice)) {
                                    Object this$organizationOutsidePrice = this.getOrganizationOutsidePrice();
                                    Object other$organizationOutsidePrice = other.getOrganizationOutsidePrice();
                                    return this$organizationOutsidePrice == null
                                       ? other$organizationOutsidePrice == null
                                       : this$organizationOutsidePrice.equals(other$organizationOutsidePrice);
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
      return other instanceof MesContractProjectLayingOffConfigLinkSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $machinePartType = this.getMachinePartType();
      result = result * 59 + ($machinePartType == null ? 43 : $machinePartType.hashCode());
      Object $steelClassificationId = this.getSteelClassificationId();
      result = result * 59 + ($steelClassificationId == null ? 43 : $steelClassificationId.hashCode());
      Object $statisticsMode = this.getStatisticsMode();
      result = result * 59 + ($statisticsMode == null ? 43 : $statisticsMode.hashCode());
      Object $boolFixedPrice = this.getBoolFixedPrice();
      result = result * 59 + ($boolFixedPrice == null ? 43 : $boolFixedPrice.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $statisticsConfigStatisticsMode = this.getStatisticsConfigStatisticsMode();
      result = result * 59 + ($statisticsConfigStatisticsMode == null ? 43 : $statisticsConfigStatisticsMode.hashCode());
      Object $processIdList = this.getProcessIdList();
      result = result * 59 + ($processIdList == null ? 43 : $processIdList.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      return result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
   }

   @Override
   public String toString() {
      return "MesContractProjectLayingOffConfigLinkSaveDTOParam(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", machinePartType="
         + this.getMachinePartType()
         + ", steelClassificationId="
         + this.getSteelClassificationId()
         + ", statisticsMode="
         + this.getStatisticsMode()
         + ", boolFixedPrice="
         + this.getBoolFixedPrice()
         + ", processIdList="
         + this.getProcessIdList()
         + ", measurementManner="
         + this.getMeasurementManner()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ", statisticsConfigStatisticsMode="
         + this.getStatisticsConfigStatisticsMode()
         + ")";
   }
}
