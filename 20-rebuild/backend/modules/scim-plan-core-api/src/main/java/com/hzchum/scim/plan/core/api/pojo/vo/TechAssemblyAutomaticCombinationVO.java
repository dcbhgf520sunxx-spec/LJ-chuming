package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("翼腹板组合部件VO")
public class TechAssemblyAutomaticCombinationVO {
   @ApiModelProperty(name = "inventoryOperationId", value = "清单导入记录Id", notes = "清单导入记录Id")
   @NotNull(message = "清单导入记录Id不可为空")
   private Long inventoryOperationId;
   @ApiModelProperty(name = "rangeOfActionEnum", value = "作用范围", notes = "作用范围")
   @NotNull(message = "作用范围不可为空")
   private Integer rangeOfActionEnum;
   @ApiModelProperty(name = "templatePanelAssemblyConfigVOS", value = "板拼部件模板配置VO", notes = "板拼部件模板配置VO")
   @NotEmpty(message = "板拼部件模板配置不可为空")
   @Valid
   private List<TemplatePanelAssemblyConfigVO> templatePanelAssemblyConfigVOS;

   public Long getInventoryOperationId() {
      return this.inventoryOperationId;
   }

   public Integer getRangeOfActionEnum() {
      return this.rangeOfActionEnum;
   }

   public List<TemplatePanelAssemblyConfigVO> getTemplatePanelAssemblyConfigVOS() {
      return this.templatePanelAssemblyConfigVOS;
   }

   public void setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
   }

   public void setRangeOfActionEnum(final Integer rangeOfActionEnum) {
      this.rangeOfActionEnum = rangeOfActionEnum;
   }

   public void setTemplatePanelAssemblyConfigVOS(final List<TemplatePanelAssemblyConfigVO> templatePanelAssemblyConfigVOS) {
      this.templatePanelAssemblyConfigVOS = templatePanelAssemblyConfigVOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssemblyAutomaticCombinationVO)) {
         return false;
      }

      TechAssemblyAutomaticCombinationVO other = (TechAssemblyAutomaticCombinationVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inventoryOperationId = this.getInventoryOperationId();
      Object other$inventoryOperationId = other.getInventoryOperationId();
      if (this$inventoryOperationId == null ? other$inventoryOperationId == null : this$inventoryOperationId.equals(other$inventoryOperationId)) {
         Object this$rangeOfActionEnum = this.getRangeOfActionEnum();
         Object other$rangeOfActionEnum = other.getRangeOfActionEnum();
         if (this$rangeOfActionEnum == null ? other$rangeOfActionEnum == null : this$rangeOfActionEnum.equals(other$rangeOfActionEnum)) {
            Object this$templatePanelAssemblyConfigVOS = this.getTemplatePanelAssemblyConfigVOS();
            Object other$templatePanelAssemblyConfigVOS = other.getTemplatePanelAssemblyConfigVOS();
            return this$templatePanelAssemblyConfigVOS == null
               ? other$templatePanelAssemblyConfigVOS == null
               : this$templatePanelAssemblyConfigVOS.equals(other$templatePanelAssemblyConfigVOS);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechAssemblyAutomaticCombinationVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inventoryOperationId = this.getInventoryOperationId();
      result = result * 59 + ($inventoryOperationId == null ? 43 : $inventoryOperationId.hashCode());
      Object $rangeOfActionEnum = this.getRangeOfActionEnum();
      result = result * 59 + ($rangeOfActionEnum == null ? 43 : $rangeOfActionEnum.hashCode());
      Object $templatePanelAssemblyConfigVOS = this.getTemplatePanelAssemblyConfigVOS();
      return result * 59 + ($templatePanelAssemblyConfigVOS == null ? 43 : $templatePanelAssemblyConfigVOS.hashCode());
   }

   @Override
   public String toString() {
      return "TechAssemblyAutomaticCombinationVO(inventoryOperationId="
         + this.getInventoryOperationId()
         + ", rangeOfActionEnum="
         + this.getRangeOfActionEnum()
         + ", templatePanelAssemblyConfigVOS="
         + this.getTemplatePanelAssemblyConfigVOS()
         + ")";
   }
}
