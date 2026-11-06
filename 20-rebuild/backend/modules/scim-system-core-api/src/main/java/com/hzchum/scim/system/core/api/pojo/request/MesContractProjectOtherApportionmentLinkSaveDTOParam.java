package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("项目其他分摊关联新增类")
public class MesContractProjectOtherApportionmentLinkSaveDTOParam {
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotNull(groups = {Add.class, Update.class}, message = "项目ID不能为空")
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   private Long contractProjectId;
   @NotBlank(groups = {Add.class, Update.class}, message = "类型不能为空")
   @ApiModelProperty(name = "type", value = "类型", notes = "类型")
   private String type;
   @NotNull(groups = {Add.class, Update.class}, message = "工序ID不能为空")
   @ApiModelProperty(name = "processId", value = "工序ID", notes = "工序ID")
   private Long processId;
   @ApiModelProperty(name = "unit", value = "计量单位（统一为吨）", notes = "计量单位")
   private String unit;
   @NotNull(groups = {Add.class, Update.class}, message = "单价不能为空")
   @DecimalMin(groups = {Add.class, Update.class}, value = "0.01", message = "单价不能小于0.01")
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   private BigDecimal price;
   @NotNull(groups = Update.class, message = "状态不能为空")
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   private Boolean status;
   @NotNull(groups = {Add.class, Update.class}, message = "工厂ID不能为空")
   @ApiModelProperty(name = "factoryId", value = "工厂ID", notes = "工厂ID")
   private Long factoryId;

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public String getType() {
      return this.type;
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

   public Boolean getStatus() {
      return this.status;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
   }

   public void setType(final String type) {
      this.type = type;
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

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectOtherApportionmentLinkSaveDTOParam)) {
         return false;
      }

      MesContractProjectOtherApportionmentLinkSaveDTOParam other = (MesContractProjectOtherApportionmentLinkSaveDTOParam)o;
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
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesContractProjectOtherApportionmentLinkSaveDTOParam;
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
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "MesContractProjectOtherApportionmentLinkSaveDTOParam(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", type="
         + this.getType()
         + ", processId="
         + this.getProcessId()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ", status="
         + this.getStatus()
         + ", factoryId="
         + this.getFactoryId()
         + ")";
   }
}
