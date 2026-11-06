package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota_management.MachinePartCalculationWayEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("零件定额配置新增编辑Param")
public class MesMachinePartQuotaConfigParam {
   @ApiModelProperty("主键ID")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Long id;
   @ApiModelProperty("车间ID列表")
   @NotEmpty(groups = {Add.class, Update.class}, message = "车间ID不能为空")
   private List<Long> workshopIdList;
   @ApiModelProperty("零件分类(4: 成品型材/型材, 8: 钢板/板材)")
   @NotNull(groups = {Add.class, Update.class}, message = "零件分类不能为空")
   private Integer machinePartType;
   @ApiModelProperty("零件类型IDs")
   @NotEmpty(groups = {Add.class, Update.class}, message = "零件类型不能为空")
   private List<Long> machinePartClassIdList;
   @ApiModelProperty("工序ID")
   @NotNull(groups = {Add.class, Update.class}, message = "工序不能为空")
   private Long processId;
   @ApiModelProperty("工序名称")
   private String processName;
   @ApiModelProperty("计算方式")
   @NotNull(groups = {Add.class, Update.class}, message = "计算方式不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = MachinePartCalculationWayEnum.class, message = "计算方式不存在")
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

   public Integer getMachinePartType() {
      return this.machinePartType;
   }

   public List<Long> getMachinePartClassIdList() {
      return this.machinePartClassIdList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
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

   public void setMachinePartType(final Integer machinePartType) {
      this.machinePartType = machinePartType;
   }

   public void setMachinePartClassIdList(final List<Long> machinePartClassIdList) {
      this.machinePartClassIdList = machinePartClassIdList;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
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

      if (!(o instanceof MesMachinePartQuotaConfigParam)) {
         return false;
      }

      MesMachinePartQuotaConfigParam other = (MesMachinePartQuotaConfigParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$machinePartType = this.getMachinePartType();
         Object other$machinePartType = other.getMachinePartType();
         if (this$machinePartType == null ? other$machinePartType == null : this$machinePartType.equals(other$machinePartType)) {
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
                        Object this$machinePartClassIdList = this.getMachinePartClassIdList();
                        Object other$machinePartClassIdList = other.getMachinePartClassIdList();
                        if (this$machinePartClassIdList == null
                           ? other$machinePartClassIdList == null
                           : this$machinePartClassIdList.equals(other$machinePartClassIdList)) {
                           Object this$processName = this.getProcessName();
                           Object other$processName = other.getProcessName();
                           if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesMachinePartQuotaConfigParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $machinePartType = this.getMachinePartType();
      result = result * 59 + ($machinePartType == null ? 43 : $machinePartType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $calculationWay = this.getCalculationWay();
      result = result * 59 + ($calculationWay == null ? 43 : $calculationWay.hashCode());
      Object $boolSpecificationClass = this.getBoolSpecificationClass();
      result = result * 59 + ($boolSpecificationClass == null ? 43 : $boolSpecificationClass.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $machinePartClassIdList = this.getMachinePartClassIdList();
      result = result * 59 + ($machinePartClassIdList == null ? 43 : $machinePartClassIdList.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "MesMachinePartQuotaConfigParam(id="
         + this.getId()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", machinePartType="
         + this.getMachinePartType()
         + ", machinePartClassIdList="
         + this.getMachinePartClassIdList()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
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
