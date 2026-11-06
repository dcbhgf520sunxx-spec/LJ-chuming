package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("项目栓钉套筒关联新增类")
public class MesContractProjectBoltSleeveLinkSaveDTOParam {
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotNull(groups = {Add.class, Update.class}, message = "项目ID不能为空")
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   private Long contractProjectId;
   @NotEmpty(groups = {Add.class, Update.class}, message = "类型不能为空")
   @ApiModelProperty(name = "typeNameList", value = "类型集合", notes = "类型集合")
   private List<String> typeNameList;
   @NotNull(groups = {Add.class, Update.class}, message = "工序ID不能为空")
   @ApiModelProperty(name = "processId", value = "工序ID", notes = "工序ID")
   private Long processId;
   @ApiModelProperty(name = "unit", value = "计量单位", notes = "计量单位")
   private String unit;
   @NotNull(groups = {Add.class, Update.class}, message = "单价不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "单价要大于0")
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   private BigDecimal price;

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public List<String> getTypeNameList() {
      return this.typeNameList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
   }

   public void setTypeNameList(final List<String> typeNameList) {
      this.typeNameList = typeNameList;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectBoltSleeveLinkSaveDTOParam)) {
         return false;
      }

      MesContractProjectBoltSleeveLinkSaveDTOParam other = (MesContractProjectBoltSleeveLinkSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$typeNameList = this.getTypeNameList();
               Object other$typeNameList = other.getTypeNameList();
               if (this$typeNameList == null ? other$typeNameList == null : this$typeNameList.equals(other$typeNameList)) {
                  Object this$unit = this.getUnit();
                  Object other$unit = other.getUnit();
                  if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesContractProjectBoltSleeveLinkSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $typeNameList = this.getTypeNameList();
      result = result * 59 + ($typeNameList == null ? 43 : $typeNameList.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "MesContractProjectBoltSleeveLinkSaveDTOParam(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", typeNameList="
         + this.getTypeNameList()
         + ", processId="
         + this.getProcessId()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ")";
   }
}
