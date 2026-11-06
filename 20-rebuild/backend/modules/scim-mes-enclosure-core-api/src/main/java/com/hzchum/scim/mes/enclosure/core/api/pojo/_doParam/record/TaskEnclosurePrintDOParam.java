package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.record;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("打印围护查询类")
public class TaskEnclosurePrintDOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("区域id")
   @NotNull(message = "区域id不能为空")
   private Long planId;
   @ApiModelProperty("生产线id")
   @NotNull(message = "生产线id不能为空")
   private Long productionLineId;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("版型")
   private String plate;
   @ApiModelProperty("颜色")
   private String color;
   @ApiModelProperty("任务状态 [0 正常,1暂停(可异常上报),2,暂停(正在处理中,无法上报)]")
   private Integer status;
   @ApiModelProperty("构件状态 [0 暂停, 1 正常]")
   private Boolean technologyStatus;
   @ApiModelProperty("页码")
   private Integer pageNumber = 1;
   @ApiModelProperty("页数")
   private Integer pageSize = 10;
   @ApiModelProperty("排序")
   private List<String> sort;

   public Long getPlanId() {
      return this.planId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Boolean getTechnologyStatus() {
      return this.technologyStatus;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public List<String> getSort() {
      return this.sort;
   }

   public void setPlanId(final Long planId) {
      this.planId = planId;
   }

   public void setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setTechnologyStatus(final Boolean technologyStatus) {
      this.technologyStatus = technologyStatus;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   public void setSort(final List<String> sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskEnclosurePrintDOParam)) {
         return false;
      }

      TaskEnclosurePrintDOParam other = (TaskEnclosurePrintDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$planId = this.getPlanId();
      Object other$planId = other.getPlanId();
      if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$technologyStatus = this.getTechnologyStatus();
               Object other$technologyStatus = other.getTechnologyStatus();
               if (this$technologyStatus == null ? other$technologyStatus == null : this$technologyStatus.equals(other$technologyStatus)) {
                  Object this$pageNumber = this.getPageNumber();
                  Object other$pageNumber = other.getPageNumber();
                  if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                     Object this$pageSize = this.getPageSize();
                     Object other$pageSize = other.getPageSize();
                     if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$plate = this.getPlate();
                              Object other$plate = other.getPlate();
                              if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                 Object this$color = this.getColor();
                                 Object other$color = other.getColor();
                                 if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                    Object this$sort = this.getSort();
                                    Object other$sort = other.getSort();
                                    return this$sort == null ? other$sort == null : this$sort.equals(other$sort);
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
      return other instanceof TaskEnclosurePrintDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $technologyStatus = this.getTechnologyStatus();
      result = result * 59 + ($technologyStatus == null ? 43 : $technologyStatus.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "TaskEnclosurePrintDOParam(planId="
         + this.getPlanId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", status="
         + this.getStatus()
         + ", technologyStatus="
         + this.getTechnologyStatus()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
