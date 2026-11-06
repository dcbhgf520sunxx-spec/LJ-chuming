package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import cn.hutool.core.collection.CollUtil;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.mes.building.core.api.enums.quota_config.QuotaConfigMeasureUnitEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMin;
import javax.validation.groups.Default;

@ApiModel("定额配置构件新增编辑Param")
public class MesQuotaConfigArtifactParam {
   @ApiModelProperty("主键ID")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Long id;
   @ApiModelProperty("机构idList")
   @NotEmpty(groups = {Add.class, Update.class}, message = "机构不能为空")
   private List<Long> branchCompanyIdList;
   @ApiModelProperty("车间idList")
   @NotEmpty(groups = {Add.class, Update.class}, message = "车间不能为空")
   private List<Long> workshopIdList;
   @ApiModelProperty("主次构件类型(1:主构件, 2:次构件)")
   @NotNull(groups = {Add.class, Update.class}, message = "主次构件类型不能为空")
   private Integer productClassificationEnum;
   @ApiModelProperty("构件种类idList")
   @NotEmpty(groups = {Add.class, Update.class}, message = "构件种类不能为空")
   private List<Long> artifactClassIdList;
   @ApiModelProperty("构件名称List")
   private List<String> artifactNameList;
   @ApiModelProperty("工序id")
   @NotNull(groups = {Add.class, Update.class}, message = "工序不能为空")
   private Long processId;
   private String processCodename;
   @ApiModelProperty("计量单位")
   @NotBlank(groups = {Add.class, Update.class}, message = "计量单位不能为空")
   private String measureUnit;
   @ApiModelProperty("定额类型(1:恒量定额, 2:变量定额)")
   @NotNull(groups = {Add.class, Update.class}, message = "定额类型不能为空")
   private Integer quotaType;
   @ApiModelProperty("编制内单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "编制内单价不能为空")
   @DecimalMin(value = "0", groups = {Add.class, Update.class, Default.class}, message = "单价不能为负数")
   private BigDecimal organizationInsidePrice;
   @ApiModelProperty("编制外单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "编制外不能为空")
   @DecimalMin(value = "0", groups = {Add.class, Update.class, Default.class}, message = "单价不能为负数")
   private BigDecimal organizationOutsidePrice;
   @ApiModelProperty("条件List")
   @Valid
   private List<MesQuotaConfigArtifactConditionParam> conditionParamList;
   @ApiModelProperty("条件List")
   @Valid
   private List<MesQuotaConfigArtifactConditionParam> conditionList;

   public List<MesQuotaConfigArtifactConditionParam> getConditionParamList() {
      return CollUtil.isEmpty(this.conditionParamList) && CollUtil.isNotEmpty(this.getConditionList()) ? this.getConditionList() : this.conditionParamList;
   }

   @AssertTrue(groups = {Add.class, Update.class}, message = "主次构件类型不存在")
   public boolean isExistsProductClassificationEnum() {
      EnumSet<ProductClassificationEnum> enumSet = EnumSet.of(ProductClassificationEnum.PRIMARY_MEMBER, ProductClassificationEnum.SECONDARY_MEMBER);
      return enumSet.stream().anyMatch(e -> Objects.equals(e.getType(), this.productClassificationEnum));
   }

   @AssertTrue(groups = {Add.class, Update.class}, message = "计量单位不存在")
   public boolean isExistsMeasureUnitEnum() {
      return QuotaConfigMeasureUnitEnum.getTonMeterPieceName().contains(this.measureUnit);
   }

   @AssertTrue(groups = {Add.class, Update.class}, message = "定额类型不存在")
   public boolean isVerifyQuotaType() {
      List<Integer> typeList = CollUtil.newArrayList(1, 2);
      return typeList.contains(this.quotaType);
   }

   public Long getId() {
      return this.id;
   }

   public List<Long> getBranchCompanyIdList() {
      return this.branchCompanyIdList;
   }

   public List<Long> getWorkshopIdList() {
      return this.workshopIdList;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public List<Long> getArtifactClassIdList() {
      return this.artifactClassIdList;
   }

   public List<String> getArtifactNameList() {
      return this.artifactNameList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessCodename() {
      return this.processCodename;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getQuotaType() {
      return this.quotaType;
   }

   public BigDecimal getOrganizationInsidePrice() {
      return this.organizationInsidePrice;
   }

   public BigDecimal getOrganizationOutsidePrice() {
      return this.organizationOutsidePrice;
   }

   public List<MesQuotaConfigArtifactConditionParam> getConditionList() {
      return this.conditionList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBranchCompanyIdList(final List<Long> branchCompanyIdList) {
      this.branchCompanyIdList = branchCompanyIdList;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   public void setArtifactClassIdList(final List<Long> artifactClassIdList) {
      this.artifactClassIdList = artifactClassIdList;
   }

   public void setArtifactNameList(final List<String> artifactNameList) {
      this.artifactNameList = artifactNameList;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProcessCodename(final String processCodename) {
      this.processCodename = processCodename;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setQuotaType(final Integer quotaType) {
      this.quotaType = quotaType;
   }

   public void setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
   }

   public void setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
   }

   public void setConditionParamList(final List<MesQuotaConfigArtifactConditionParam> conditionParamList) {
      this.conditionParamList = conditionParamList;
   }

   public void setConditionList(final List<MesQuotaConfigArtifactConditionParam> conditionList) {
      this.conditionList = conditionList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigArtifactParam)) {
         return false;
      }

      MesQuotaConfigArtifactParam other = (MesQuotaConfigArtifactParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productClassificationEnum = this.getProductClassificationEnum();
         Object other$productClassificationEnum = other.getProductClassificationEnum();
         if (this$productClassificationEnum == null
            ? other$productClassificationEnum == null
            : this$productClassificationEnum.equals(other$productClassificationEnum)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$quotaType = this.getQuotaType();
               Object other$quotaType = other.getQuotaType();
               if (this$quotaType == null ? other$quotaType == null : this$quotaType.equals(other$quotaType)) {
                  Object this$branchCompanyIdList = this.getBranchCompanyIdList();
                  Object other$branchCompanyIdList = other.getBranchCompanyIdList();
                  if (this$branchCompanyIdList == null ? other$branchCompanyIdList == null : this$branchCompanyIdList.equals(other$branchCompanyIdList)) {
                     Object this$workshopIdList = this.getWorkshopIdList();
                     Object other$workshopIdList = other.getWorkshopIdList();
                     if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
                        Object this$artifactClassIdList = this.getArtifactClassIdList();
                        Object other$artifactClassIdList = other.getArtifactClassIdList();
                        if (this$artifactClassIdList == null ? other$artifactClassIdList == null : this$artifactClassIdList.equals(other$artifactClassIdList)) {
                           Object this$artifactNameList = this.getArtifactNameList();
                           Object other$artifactNameList = other.getArtifactNameList();
                           if (this$artifactNameList == null ? other$artifactNameList == null : this$artifactNameList.equals(other$artifactNameList)) {
                              Object this$processCodename = this.getProcessCodename();
                              Object other$processCodename = other.getProcessCodename();
                              if (this$processCodename == null ? other$processCodename == null : this$processCodename.equals(other$processCodename)) {
                                 Object this$measureUnit = this.getMeasureUnit();
                                 Object other$measureUnit = other.getMeasureUnit();
                                 if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                    Object this$organizationInsidePrice = this.getOrganizationInsidePrice();
                                    Object other$organizationInsidePrice = other.getOrganizationInsidePrice();
                                    if (this$organizationInsidePrice == null
                                       ? other$organizationInsidePrice == null
                                       : this$organizationInsidePrice.equals(other$organizationInsidePrice)) {
                                       Object this$organizationOutsidePrice = this.getOrganizationOutsidePrice();
                                       Object other$organizationOutsidePrice = other.getOrganizationOutsidePrice();
                                       if (this$organizationOutsidePrice == null
                                          ? other$organizationOutsidePrice == null
                                          : this$organizationOutsidePrice.equals(other$organizationOutsidePrice)) {
                                          Object this$conditionParamList = this.getConditionParamList();
                                          Object other$conditionParamList = other.getConditionParamList();
                                          if (this$conditionParamList == null
                                             ? other$conditionParamList == null
                                             : this$conditionParamList.equals(other$conditionParamList)) {
                                             Object this$conditionList = this.getConditionList();
                                             Object other$conditionList = other.getConditionList();
                                             return this$conditionList == null ? other$conditionList == null : this$conditionList.equals(other$conditionList);
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
      return other instanceof MesQuotaConfigArtifactParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $quotaType = this.getQuotaType();
      result = result * 59 + ($quotaType == null ? 43 : $quotaType.hashCode());
      Object $branchCompanyIdList = this.getBranchCompanyIdList();
      result = result * 59 + ($branchCompanyIdList == null ? 43 : $branchCompanyIdList.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $artifactClassIdList = this.getArtifactClassIdList();
      result = result * 59 + ($artifactClassIdList == null ? 43 : $artifactClassIdList.hashCode());
      Object $artifactNameList = this.getArtifactNameList();
      result = result * 59 + ($artifactNameList == null ? 43 : $artifactNameList.hashCode());
      Object $processCodename = this.getProcessCodename();
      result = result * 59 + ($processCodename == null ? 43 : $processCodename.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      result = result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
      Object $conditionParamList = this.getConditionParamList();
      result = result * 59 + ($conditionParamList == null ? 43 : $conditionParamList.hashCode());
      Object $conditionList = this.getConditionList();
      return result * 59 + ($conditionList == null ? 43 : $conditionList.hashCode());
   }

   @Override
   public String toString() {
      return "MesQuotaConfigArtifactParam(id="
         + this.getId()
         + ", branchCompanyIdList="
         + this.getBranchCompanyIdList()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", artifactClassIdList="
         + this.getArtifactClassIdList()
         + ", artifactNameList="
         + this.getArtifactNameList()
         + ", processId="
         + this.getProcessId()
         + ", processCodename="
         + this.getProcessCodename()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quotaType="
         + this.getQuotaType()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ", conditionParamList="
         + this.getConditionParamList()
         + ", conditionList="
         + this.getConditionList()
         + ")";
   }
}
