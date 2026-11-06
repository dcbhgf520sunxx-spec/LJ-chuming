package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.WageConfigStatisticsModeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("项目组焊配置关联新增类")
public class MesContractProjectGroupWeldingConfigLinkSaveDTOParam {
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotNull(groups = {Add.class, Update.class}, message = "项目ID不能为空")
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   private Long contractProjectId;
   @NotNull(groups = {Add.class, Update.class}, message = "部件类型ID不能为空")
   @ApiModelProperty(name = "assembleConfigId", value = "部件类型ID", notes = "部件类型ID")
   private Long assembleConfigId;
   @NotEmpty(groups = {Add.class, Update.class}, message = "生产工序不能为空")
   @ApiModelProperty(name = "processIdList", value = "生产工序", notes = "生产工序")
   private List<Long> processIdList;
   @NotNull(groups = {Add.class, Update.class}, message = "统计模式不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = WageConfigStatisticsModeEnum.class, message = "统计模式不存在")
   @ApiModelProperty(name = "statisticsMode", value = "统计模式", notes = "统计模式")
   private Integer statisticsMode;
   @NotNull(groups = {Add.class, Update.class}, message = "计量方式不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = WageQuotaTypeEnum.class, message = "计量方式不存在")
   @ApiModelProperty(name = "measurementManner", value = "计量方式", notes = "计量方式")
   private Integer measurementManner;
   @Positive(groups = {Add.class, Update.class}, message = "编制内单价要大于0")
   @ApiModelProperty(name = "organizationInsidePrice", value = "编制内单价(元)", notes = "编制内单价(元)")
   private BigDecimal organizationInsidePrice;
   @Positive(groups = {Add.class, Update.class}, message = "编制外单价要大于0")
   @ApiModelProperty(name = "organizationOutsidePrice", value = "编制外单价(元)", notes = "编制外单价(元)")
   private BigDecimal organizationOutsidePrice;

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public List<Long> getProcessIdList() {
      return this.processIdList;
   }

   public Integer getStatisticsMode() {
      return this.statisticsMode;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
   }

   public void setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
   }

   public void setProcessIdList(final List<Long> processIdList) {
      this.processIdList = processIdList;
   }

   public void setStatisticsMode(final Integer statisticsMode) {
      this.statisticsMode = statisticsMode;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectGroupWeldingConfigLinkSaveDTOParam)) {
         return false;
      }

      MesContractProjectGroupWeldingConfigLinkSaveDTOParam other = (MesContractProjectGroupWeldingConfigLinkSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
            Object this$assembleConfigId = this.getAssembleConfigId();
            Object other$assembleConfigId = other.getAssembleConfigId();
            if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
               Object this$statisticsMode = this.getStatisticsMode();
               Object other$statisticsMode = other.getStatisticsMode();
               if (this$statisticsMode == null ? other$statisticsMode == null : this$statisticsMode.equals(other$statisticsMode)) {
                  Object this$measurementManner = this.getMeasurementManner();
                  Object other$measurementManner = other.getMeasurementManner();
                  if (this$measurementManner == null ? other$measurementManner == null : this$measurementManner.equals(other$measurementManner)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesContractProjectGroupWeldingConfigLinkSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $statisticsMode = this.getStatisticsMode();
      result = result * 59 + ($statisticsMode == null ? 43 : $statisticsMode.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $processIdList = this.getProcessIdList();
      result = result * 59 + ($processIdList == null ? 43 : $processIdList.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      return result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
   }

   @Override
   public String toString() {
      return "MesContractProjectGroupWeldingConfigLinkSaveDTOParam(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", processIdList="
         + this.getProcessIdList()
         + ", statisticsMode="
         + this.getStatisticsMode()
         + ", measurementManner="
         + this.getMeasurementManner()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ")";
   }
}
