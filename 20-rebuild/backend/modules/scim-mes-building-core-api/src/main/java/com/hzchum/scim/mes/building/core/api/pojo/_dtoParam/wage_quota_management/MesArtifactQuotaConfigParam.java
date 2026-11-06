package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.ArtifactCalculationWayEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("构件定额配置新增编辑Param")
public class MesArtifactQuotaConfigParam {
   @ApiModelProperty("主键ID")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Long id;
   @ApiModelProperty("车间ID列表")
   @NotEmpty(groups = {Add.class, Update.class}, message = "车间ID不能为空")
   private List<Long> workshopIdList;
   @ApiModelProperty("构件类型ID列表")
   @NotEmpty(groups = {Add.class, Update.class}, message = "构件类型不能为空")
   private List<Long> artifactClassIdList;
   @ApiModelProperty("工序ID")
   @NotNull(groups = {Add.class, Update.class}, message = "工序不能为空")
   private Long processId;
   @ApiModelProperty("计算方式")
   @NotNull(groups = {Add.class, Update.class}, message = "计算方式不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = ArtifactCalculationWayEnum.class, message = "计算方式不存在")
   private Integer calculationWay;
   @ApiModelProperty("规格分类(true: 需分类, false: 无需分类)")
   @NotNull(groups = {Add.class, Update.class}, message = "规格分类不能为空")
   private Boolean boolSpecificationClass;
   @ApiModelProperty("单价(元)")
   @Positive(groups = {Add.class, Update.class}, message = "单价不能小于等于0")
   private BigDecimal price;
   @ApiModelProperty("详情列表")
   @Valid
   private List<QuotaConfigDetailParam> detailList;

   public Long getId() {
      return this.id;
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

   public Integer getCalculationWay() {
      return this.calculationWay;
   }

   public Boolean getBoolSpecificationClass() {
      return this.boolSpecificationClass;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public List<QuotaConfigDetailParam> getDetailList() {
      return this.detailList;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setCalculationWay(final Integer calculationWay) {
      this.calculationWay = calculationWay;
   }

   public void setBoolSpecificationClass(final Boolean boolSpecificationClass) {
      this.boolSpecificationClass = boolSpecificationClass;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setDetailList(final List<QuotaConfigDetailParam> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesArtifactQuotaConfigParam)) {
         return false;
      }

      MesArtifactQuotaConfigParam other = (MesArtifactQuotaConfigParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$calculationWay = this.getCalculationWay();
            Object other$calculationWay = other.getCalculationWay();
            if (this$calculationWay == null ? other$calculationWay == null : this$calculationWay.equals(other$calculationWay)) {
               Object this$boolSpecificationClass = this.getBoolSpecificationClass();
               Object other$boolSpecificationClass = other.getBoolSpecificationClass();
               if (this$boolSpecificationClass == null
                  ? other$boolSpecificationClass == null
                  : this$boolSpecificationClass.equals(other$boolSpecificationClass)) {
                  Object this$workshopIdList = this.getWorkshopIdList();
                  Object other$workshopIdList = other.getWorkshopIdList();
                  if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
                     Object this$artifactClassIdList = this.getArtifactClassIdList();
                     Object other$artifactClassIdList = other.getArtifactClassIdList();
                     if (this$artifactClassIdList == null ? other$artifactClassIdList == null : this$artifactClassIdList.equals(other$artifactClassIdList)) {
                        Object this$price = this.getPrice();
                        Object other$price = other.getPrice();
                        if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                           Object this$detailList = this.getDetailList();
                           Object other$detailList = other.getDetailList();
                           return this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList);
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
      return other instanceof MesArtifactQuotaConfigParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $calculationWay = this.getCalculationWay();
      result = result * 59 + ($calculationWay == null ? 43 : $calculationWay.hashCode());
      Object $boolSpecificationClass = this.getBoolSpecificationClass();
      result = result * 59 + ($boolSpecificationClass == null ? 43 : $boolSpecificationClass.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $artifactClassIdList = this.getArtifactClassIdList();
      result = result * 59 + ($artifactClassIdList == null ? 43 : $artifactClassIdList.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "MesArtifactQuotaConfigParam(id="
         + this.getId()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", artifactClassIdList="
         + this.getArtifactClassIdList()
         + ", processId="
         + this.getProcessId()
         + ", calculationWay="
         + this.getCalculationWay()
         + ", boolSpecificationClass="
         + this.getBoolSpecificationClass()
         + ", price="
         + this.getPrice()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }
}
