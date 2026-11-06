package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import com.hzchum.scim.common.core.api.pojo.common.ProductInfo;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("人工填报DTO")
public class MesManualReportDTO {
   @ApiModelProperty("是否协同")
   private Boolean boolAssist;
   @ApiModelProperty("任务id")
   private Long taskId;
   @ApiModelProperty("任务工序id")
   private Long taskProcessId;
   @ApiModelProperty("项目")
   private ShowInfo project;
   @ApiModelProperty("单体")
   private ShowInfo monomer;
   @ApiModelProperty("区域")
   private ShowInfo area;
   @ApiModelProperty("产品")
   private ProductInfo product;
   @ApiModelProperty("未上报数")
   private BigDecimal unreportedQuantity;
   @ApiModelProperty("协同任务任务上报生产线id")
   private Long assistLineId;
   @ApiModelProperty("下一道工序id")
   private Long nextProcessId;

   public Boolean getBoolAssist() {
      return this.boolAssist;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public ShowInfo getProject() {
      return this.project;
   }

   public ShowInfo getMonomer() {
      return this.monomer;
   }

   public ShowInfo getArea() {
      return this.area;
   }

   public ProductInfo getProduct() {
      return this.product;
   }

   public BigDecimal getUnreportedQuantity() {
      return this.unreportedQuantity;
   }

   public Long getAssistLineId() {
      return this.assistLineId;
   }

   public Long getNextProcessId() {
      return this.nextProcessId;
   }

   public void setBoolAssist(final Boolean boolAssist) {
      this.boolAssist = boolAssist;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
   }

   public void setProject(final ShowInfo project) {
      this.project = project;
   }

   public void setMonomer(final ShowInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final ShowInfo area) {
      this.area = area;
   }

   public void setProduct(final ProductInfo product) {
      this.product = product;
   }

   public void setUnreportedQuantity(final BigDecimal unreportedQuantity) {
      this.unreportedQuantity = unreportedQuantity;
   }

   public void setAssistLineId(final Long assistLineId) {
      this.assistLineId = assistLineId;
   }

   public void setNextProcessId(final Long nextProcessId) {
      this.nextProcessId = nextProcessId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesManualReportDTO)) {
         return false;
      }

      MesManualReportDTO other = (MesManualReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolAssist = this.getBoolAssist();
      Object other$boolAssist = other.getBoolAssist();
      if (this$boolAssist == null ? other$boolAssist == null : this$boolAssist.equals(other$boolAssist)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$taskProcessId = this.getTaskProcessId();
            Object other$taskProcessId = other.getTaskProcessId();
            if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
               Object this$assistLineId = this.getAssistLineId();
               Object other$assistLineId = other.getAssistLineId();
               if (this$assistLineId == null ? other$assistLineId == null : this$assistLineId.equals(other$assistLineId)) {
                  Object this$nextProcessId = this.getNextProcessId();
                  Object other$nextProcessId = other.getNextProcessId();
                  if (this$nextProcessId == null ? other$nextProcessId == null : this$nextProcessId.equals(other$nextProcessId)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$product = this.getProduct();
                              Object other$product = other.getProduct();
                              if (this$product == null ? other$product == null : this$product.equals(other$product)) {
                                 Object this$unreportedQuantity = this.getUnreportedQuantity();
                                 Object other$unreportedQuantity = other.getUnreportedQuantity();
                                 return this$unreportedQuantity == null
                                    ? other$unreportedQuantity == null
                                    : this$unreportedQuantity.equals(other$unreportedQuantity);
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
      return other instanceof MesManualReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolAssist = this.getBoolAssist();
      result = result * 59 + ($boolAssist == null ? 43 : $boolAssist.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $assistLineId = this.getAssistLineId();
      result = result * 59 + ($assistLineId == null ? 43 : $assistLineId.hashCode());
      Object $nextProcessId = this.getNextProcessId();
      result = result * 59 + ($nextProcessId == null ? 43 : $nextProcessId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $product = this.getProduct();
      result = result * 59 + ($product == null ? 43 : $product.hashCode());
      Object $unreportedQuantity = this.getUnreportedQuantity();
      return result * 59 + ($unreportedQuantity == null ? 43 : $unreportedQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "MesManualReportDTO(boolAssist="
         + this.getBoolAssist()
         + ", taskId="
         + this.getTaskId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", product="
         + this.getProduct()
         + ", unreportedQuantity="
         + this.getUnreportedQuantity()
         + ", assistLineId="
         + this.getAssistLineId()
         + ", nextProcessId="
         + this.getNextProcessId()
         + ")";
   }
}
