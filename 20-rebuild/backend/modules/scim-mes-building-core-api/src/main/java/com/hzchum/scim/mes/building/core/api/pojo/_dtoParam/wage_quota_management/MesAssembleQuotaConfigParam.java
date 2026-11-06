package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.AssembleCalculationWayEnum;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.AssembleClassificationWayEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("部件定额配置新增编辑Param")
public class MesAssembleQuotaConfigParam {
   @ApiModelProperty("主键ID")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Long id;
   @ApiModelProperty("车间ID列表")
   @NotEmpty(groups = {Add.class, Update.class}, message = "车间ID不能为空")
   private List<Long> workshopIdList;
   @ApiModelProperty("部件类型ID列表")
   @NotEmpty(groups = {Add.class, Update.class}, message = "部件类型不能为空")
   private List<Long> assembleClassIdList;
   @ApiModelProperty("工序ID")
   @NotNull(groups = {Add.class, Update.class}, message = "工序不能为空")
   private Long processId;
   @ApiModelProperty("计算方式")
   @NotNull(groups = {Add.class, Update.class}, message = "计算方式不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = AssembleCalculationWayEnum.class, message = "计算方式不存在")
   private Integer calculationWay;
   @ApiModelProperty("规格分类(true: 需分类, false: 无需分类)")
   @NotNull(groups = {Add.class, Update.class}, message = "规格分类不能为空")
   private Boolean boolSpecificationClass;
   @ApiModelProperty("分类方式")
   @NotNull(groups = {Add.class, Update.class}, message = "分类方式不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = AssembleClassificationWayEnum.class, message = "分类方式不存在")
   private Integer classificationWayEnum;
   @ApiModelProperty("单价(元)")
   @Positive(groups = {Add.class, Update.class}, message = "单价不能小于等于0")
   private BigDecimal price;
   @ApiModelProperty("详情列表")
   @Valid
   private List<MesAssembleQuotaConfigDetailParam> detailList;

   public Long getId() {
      return this.id;
   }

   public List<Long> getWorkshopIdList() {
      return this.workshopIdList;
   }

   public List<Long> getAssembleClassIdList() {
      return this.assembleClassIdList;
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

   public Integer getClassificationWayEnum() {
      return this.classificationWayEnum;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public List<MesAssembleQuotaConfigDetailParam> getDetailList() {
      return this.detailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setAssembleClassIdList(final List<Long> assembleClassIdList) {
      this.assembleClassIdList = assembleClassIdList;
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

   public void setClassificationWayEnum(final Integer classificationWayEnum) {
      this.classificationWayEnum = classificationWayEnum;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setDetailList(final List<MesAssembleQuotaConfigDetailParam> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAssembleQuotaConfigParam)) {
         return false;
      }

      MesAssembleQuotaConfigParam other = (MesAssembleQuotaConfigParam)o;
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
                  Object this$classificationWayEnum = this.getClassificationWayEnum();
                  Object other$classificationWayEnum = other.getClassificationWayEnum();
                  if (this$classificationWayEnum == null ? other$classificationWayEnum == null : this$classificationWayEnum.equals(other$classificationWayEnum)
                     )
                   {
                     Object this$workshopIdList = this.getWorkshopIdList();
                     Object other$workshopIdList = other.getWorkshopIdList();
                     if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
                        Object this$assembleClassIdList = this.getAssembleClassIdList();
                        Object other$assembleClassIdList = other.getAssembleClassIdList();
                        if (this$assembleClassIdList == null ? other$assembleClassIdList == null : this$assembleClassIdList.equals(other$assembleClassIdList)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesAssembleQuotaConfigParam;
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
      Object $classificationWayEnum = this.getClassificationWayEnum();
      result = result * 59 + ($classificationWayEnum == null ? 43 : $classificationWayEnum.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $assembleClassIdList = this.getAssembleClassIdList();
      result = result * 59 + ($assembleClassIdList == null ? 43 : $assembleClassIdList.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "MesAssembleQuotaConfigParam(id="
         + this.getId()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", assembleClassIdList="
         + this.getAssembleClassIdList()
         + ", processId="
         + this.getProcessId()
         + ", calculationWay="
         + this.getCalculationWay()
         + ", boolSpecificationClass="
         + this.getBoolSpecificationClass()
         + ", classificationWayEnum="
         + this.getClassificationWayEnum()
         + ", price="
         + this.getPrice()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }
}
