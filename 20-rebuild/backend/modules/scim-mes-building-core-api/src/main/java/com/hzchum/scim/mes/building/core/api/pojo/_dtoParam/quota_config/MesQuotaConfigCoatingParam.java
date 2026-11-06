package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.enums.quota_config.QuotaConfigMeasureUnitEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMin;
import javax.validation.groups.Default;

@ApiModel("定额配置涂装新增编辑Param")
public class MesQuotaConfigCoatingParam {
   @ApiModelProperty("主键ID")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Long id;
   @ApiModelProperty("机构idList")
   @NotEmpty(groups = {Add.class, Update.class}, message = "机构不能为空")
   private List<Long> branchCompanyIdList;
   @ApiModelProperty("车间idList")
   @NotEmpty(groups = {Add.class, Update.class}, message = "车间不能为空")
   private List<Long> workshopIdList;
   @ApiModelProperty("构件种类idList")
   @NotEmpty(groups = {Add.class, Update.class}, message = "构件种类不能为空")
   private List<Long> artifactClassIdList;
   @ApiModelProperty("工序id")
   @NotNull(groups = {Add.class, Update.class}, message = "工序不能为空")
   private Long processId;
   @ApiModelProperty("计量单位")
   @NotBlank(groups = {Add.class, Update.class}, message = "计量单位不能为空")
   private String measureUnit;
   @ApiModelProperty("漆膜厚度基数(µm)")
   @NotNull(groups = {Add.class, Update.class}, message = "漆膜厚度基数不能为空")
   private BigDecimal paintFilmThicknessBase;
   @ApiModelProperty("起步编制内单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "起步编制内单价不能为空")
   @DecimalMin(value = "0", groups = {Add.class, Update.class, Default.class}, message = "单价不能为负数")
   private BigDecimal startOrganizationInsidePrice;
   @ApiModelProperty("起步编制外单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "起步编制外单价不能为空")
   @DecimalMin(value = "0", groups = {Add.class, Update.class, Default.class}, message = "单价不能为负数")
   private BigDecimal startOrganizationOutsidePrice;
   @ApiModelProperty("起加漆膜厚度(µm)")
   @NotNull(groups = {Add.class, Update.class}, message = "起加漆膜厚度不能为空")
   private BigDecimal startAddPaintFilmThickness;
   @ApiModelProperty("起加编制内单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "起加编制内单价不能为空")
   @DecimalMin(value = "0", groups = {Add.class, Update.class, Default.class}, message = "单价不能为负数")
   private BigDecimal startAddOrganizationInsidePrice;
   @ApiModelProperty("起加编制外单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "起加编制外单价不能为空")
   @DecimalMin(value = "0", groups = {Add.class, Update.class, Default.class}, message = "单价不能为负数")
   private BigDecimal startAddOrganizationOutsidePrice;
   private String processCodename;

   @AssertTrue(groups = {Add.class, Update.class}, message = "计量单位不存在")
   public boolean isExistsMeasureUnitEnum() {
      EnumSet<QuotaConfigMeasureUnitEnum> enumSet = EnumSet.of(QuotaConfigMeasureUnitEnum.SQUARE_METER, QuotaConfigMeasureUnitEnum.TON);
      return enumSet.stream().anyMatch(e -> Objects.equals(e.getName(), this.measureUnit));
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

   public List<Long> getArtifactClassIdList() {
      return this.artifactClassIdList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getPaintFilmThicknessBase() {
      return this.paintFilmThicknessBase;
   }

   public BigDecimal getStartOrganizationInsidePrice() {
      return this.startOrganizationInsidePrice;
   }

   public BigDecimal getStartOrganizationOutsidePrice() {
      return this.startOrganizationOutsidePrice;
   }

   public BigDecimal getStartAddPaintFilmThickness() {
      return this.startAddPaintFilmThickness;
   }

   public BigDecimal getStartAddOrganizationInsidePrice() {
      return this.startAddOrganizationInsidePrice;
   }

   public BigDecimal getStartAddOrganizationOutsidePrice() {
      return this.startAddOrganizationOutsidePrice;
   }

   public String getProcessCodename() {
      return this.processCodename;
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

   public void setArtifactClassIdList(final List<Long> artifactClassIdList) {
      this.artifactClassIdList = artifactClassIdList;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setPaintFilmThicknessBase(final BigDecimal paintFilmThicknessBase) {
      this.paintFilmThicknessBase = paintFilmThicknessBase;
   }

   public void setStartOrganizationInsidePrice(final BigDecimal startOrganizationInsidePrice) {
      this.startOrganizationInsidePrice = startOrganizationInsidePrice;
   }

   public void setStartOrganizationOutsidePrice(final BigDecimal startOrganizationOutsidePrice) {
      this.startOrganizationOutsidePrice = startOrganizationOutsidePrice;
   }

   public void setStartAddPaintFilmThickness(final BigDecimal startAddPaintFilmThickness) {
      this.startAddPaintFilmThickness = startAddPaintFilmThickness;
   }

   public void setStartAddOrganizationInsidePrice(final BigDecimal startAddOrganizationInsidePrice) {
      this.startAddOrganizationInsidePrice = startAddOrganizationInsidePrice;
   }

   public void setStartAddOrganizationOutsidePrice(final BigDecimal startAddOrganizationOutsidePrice) {
      this.startAddOrganizationOutsidePrice = startAddOrganizationOutsidePrice;
   }

   public void setProcessCodename(final String processCodename) {
      this.processCodename = processCodename;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigCoatingParam)) {
         return false;
      }

      MesQuotaConfigCoatingParam other = (MesQuotaConfigCoatingParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$branchCompanyIdList = this.getBranchCompanyIdList();
            Object other$branchCompanyIdList = other.getBranchCompanyIdList();
            if (this$branchCompanyIdList == null ? other$branchCompanyIdList == null : this$branchCompanyIdList.equals(other$branchCompanyIdList)) {
               Object this$workshopIdList = this.getWorkshopIdList();
               Object other$workshopIdList = other.getWorkshopIdList();
               if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
                  Object this$artifactClassIdList = this.getArtifactClassIdList();
                  Object other$artifactClassIdList = other.getArtifactClassIdList();
                  if (this$artifactClassIdList == null ? other$artifactClassIdList == null : this$artifactClassIdList.equals(other$artifactClassIdList)) {
                     Object this$measureUnit = this.getMeasureUnit();
                     Object other$measureUnit = other.getMeasureUnit();
                     if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                        Object this$paintFilmThicknessBase = this.getPaintFilmThicknessBase();
                        Object other$paintFilmThicknessBase = other.getPaintFilmThicknessBase();
                        if (this$paintFilmThicknessBase == null
                           ? other$paintFilmThicknessBase == null
                           : this$paintFilmThicknessBase.equals(other$paintFilmThicknessBase)) {
                           Object this$startOrganizationInsidePrice = this.getStartOrganizationInsidePrice();
                           Object other$startOrganizationInsidePrice = other.getStartOrganizationInsidePrice();
                           if (this$startOrganizationInsidePrice == null
                              ? other$startOrganizationInsidePrice == null
                              : this$startOrganizationInsidePrice.equals(other$startOrganizationInsidePrice)) {
                              Object this$startOrganizationOutsidePrice = this.getStartOrganizationOutsidePrice();
                              Object other$startOrganizationOutsidePrice = other.getStartOrganizationOutsidePrice();
                              if (this$startOrganizationOutsidePrice == null
                                 ? other$startOrganizationOutsidePrice == null
                                 : this$startOrganizationOutsidePrice.equals(other$startOrganizationOutsidePrice)) {
                                 Object this$startAddPaintFilmThickness = this.getStartAddPaintFilmThickness();
                                 Object other$startAddPaintFilmThickness = other.getStartAddPaintFilmThickness();
                                 if (this$startAddPaintFilmThickness == null
                                    ? other$startAddPaintFilmThickness == null
                                    : this$startAddPaintFilmThickness.equals(other$startAddPaintFilmThickness)) {
                                    Object this$startAddOrganizationInsidePrice = this.getStartAddOrganizationInsidePrice();
                                    Object other$startAddOrganizationInsidePrice = other.getStartAddOrganizationInsidePrice();
                                    if (this$startAddOrganizationInsidePrice == null
                                       ? other$startAddOrganizationInsidePrice == null
                                       : this$startAddOrganizationInsidePrice.equals(other$startAddOrganizationInsidePrice)) {
                                       Object this$startAddOrganizationOutsidePrice = this.getStartAddOrganizationOutsidePrice();
                                       Object other$startAddOrganizationOutsidePrice = other.getStartAddOrganizationOutsidePrice();
                                       if (this$startAddOrganizationOutsidePrice == null
                                          ? other$startAddOrganizationOutsidePrice == null
                                          : this$startAddOrganizationOutsidePrice.equals(other$startAddOrganizationOutsidePrice)) {
                                          Object this$processCodename = this.getProcessCodename();
                                          Object other$processCodename = other.getProcessCodename();
                                          return this$processCodename == null
                                             ? other$processCodename == null
                                             : this$processCodename.equals(other$processCodename);
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
      return other instanceof MesQuotaConfigCoatingParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $branchCompanyIdList = this.getBranchCompanyIdList();
      result = result * 59 + ($branchCompanyIdList == null ? 43 : $branchCompanyIdList.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $artifactClassIdList = this.getArtifactClassIdList();
      result = result * 59 + ($artifactClassIdList == null ? 43 : $artifactClassIdList.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $paintFilmThicknessBase = this.getPaintFilmThicknessBase();
      result = result * 59 + ($paintFilmThicknessBase == null ? 43 : $paintFilmThicknessBase.hashCode());
      Object $startOrganizationInsidePrice = this.getStartOrganizationInsidePrice();
      result = result * 59 + ($startOrganizationInsidePrice == null ? 43 : $startOrganizationInsidePrice.hashCode());
      Object $startOrganizationOutsidePrice = this.getStartOrganizationOutsidePrice();
      result = result * 59 + ($startOrganizationOutsidePrice == null ? 43 : $startOrganizationOutsidePrice.hashCode());
      Object $startAddPaintFilmThickness = this.getStartAddPaintFilmThickness();
      result = result * 59 + ($startAddPaintFilmThickness == null ? 43 : $startAddPaintFilmThickness.hashCode());
      Object $startAddOrganizationInsidePrice = this.getStartAddOrganizationInsidePrice();
      result = result * 59 + ($startAddOrganizationInsidePrice == null ? 43 : $startAddOrganizationInsidePrice.hashCode());
      Object $startAddOrganizationOutsidePrice = this.getStartAddOrganizationOutsidePrice();
      result = result * 59 + ($startAddOrganizationOutsidePrice == null ? 43 : $startAddOrganizationOutsidePrice.hashCode());
      Object $processCodename = this.getProcessCodename();
      return result * 59 + ($processCodename == null ? 43 : $processCodename.hashCode());
   }

   @Override
   public String toString() {
      return "MesQuotaConfigCoatingParam(id="
         + this.getId()
         + ", branchCompanyIdList="
         + this.getBranchCompanyIdList()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", artifactClassIdList="
         + this.getArtifactClassIdList()
         + ", processId="
         + this.getProcessId()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", paintFilmThicknessBase="
         + this.getPaintFilmThicknessBase()
         + ", startOrganizationInsidePrice="
         + this.getStartOrganizationInsidePrice()
         + ", startOrganizationOutsidePrice="
         + this.getStartOrganizationOutsidePrice()
         + ", startAddPaintFilmThickness="
         + this.getStartAddPaintFilmThickness()
         + ", startAddOrganizationInsidePrice="
         + this.getStartAddOrganizationInsidePrice()
         + ", startAddOrganizationOutsidePrice="
         + this.getStartAddOrganizationOutsidePrice()
         + ", processCodename="
         + this.getProcessCodename()
         + ")";
   }
}
