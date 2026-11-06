package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

@ApiModel("项目树 合同")
public class ProjectTreeResponseVO {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "serialNumber", value = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建筑钢结构 2桥梁钢结构 3立体停车库 4围护材料")
   private Integer projectType;
   @ApiModelProperty(name = "productCategory", notes = "项目产品类型")
   private Integer productCategory;
   @ApiModelProperty(name = "startDate", notes = "约定开工日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", notes = "约定完工时期")
   private LocalDate endDate;
   @ApiModelProperty(name = "lumpSumSystemType", notes = "包干制项目管理选项 参考枚举：LumpSumSystemEnum 0 其他 1.无管控，需加工 2.无管控，无加工 3.需加工，需管控 4.需加工，无需管控")
   private Integer lumpSumSystemType;
   @ApiModelProperty("工期(天)")
   private Long duration;
   @ApiModelProperty("订单类型")
   private Integer orderType;
   @ApiModelProperty(name = "status", notes = "项目状态  1：进行中，2：已暂停，4：已完工 ")
   private Integer status;
   @ApiModelProperty(name = "children", value = "单体列表")
   private List<MonomerTreeResponseVO> children;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductCategory() {
      return this.productCategory;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getLumpSumSystemType() {
      return this.lumpSumSystemType;
   }

   public Long getDuration() {
      return this.duration;
   }

   public Integer getOrderType() {
      return this.orderType;
   }

   public Integer getStatus() {
      return this.status;
   }

   public List<MonomerTreeResponseVO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProductCategory(final Integer productCategory) {
      this.productCategory = productCategory;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setLumpSumSystemType(final Integer lumpSumSystemType) {
      this.lumpSumSystemType = lumpSumSystemType;
   }

   public void setDuration(final Long duration) {
      this.duration = duration;
   }

   public void setOrderType(final Integer orderType) {
      this.orderType = orderType;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setChildren(final List<MonomerTreeResponseVO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectTreeResponseVO)) {
         return false;
      }

      ProjectTreeResponseVO other = (ProjectTreeResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$productCategory = this.getProductCategory();
            Object other$productCategory = other.getProductCategory();
            if (this$productCategory == null ? other$productCategory == null : this$productCategory.equals(other$productCategory)) {
               Object this$lumpSumSystemType = this.getLumpSumSystemType();
               Object other$lumpSumSystemType = other.getLumpSumSystemType();
               if (this$lumpSumSystemType == null ? other$lumpSumSystemType == null : this$lumpSumSystemType.equals(other$lumpSumSystemType)) {
                  Object this$duration = this.getDuration();
                  Object other$duration = other.getDuration();
                  if (this$duration == null ? other$duration == null : this$duration.equals(other$duration)) {
                     Object this$orderType = this.getOrderType();
                     Object other$orderType = other.getOrderType();
                     if (this$orderType == null ? other$orderType == null : this$orderType.equals(other$orderType)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$shortName = this.getShortName();
                              Object other$shortName = other.getShortName();
                              if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$startDate = this.getStartDate();
                                    Object other$startDate = other.getStartDate();
                                    if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                       Object this$endDate = this.getEndDate();
                                       Object other$endDate = other.getEndDate();
                                       if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                          Object this$children = this.getChildren();
                                          Object other$children = other.getChildren();
                                          return this$children == null ? other$children == null : this$children.equals(other$children);
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
      return other instanceof ProjectTreeResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productCategory = this.getProductCategory();
      result = result * 59 + ($productCategory == null ? 43 : $productCategory.hashCode());
      Object $lumpSumSystemType = this.getLumpSumSystemType();
      result = result * 59 + ($lumpSumSystemType == null ? 43 : $lumpSumSystemType.hashCode());
      Object $duration = this.getDuration();
      result = result * 59 + ($duration == null ? 43 : $duration.hashCode());
      Object $orderType = this.getOrderType();
      result = result * 59 + ($orderType == null ? 43 : $orderType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectTreeResponseVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectType="
         + this.getProjectType()
         + ", productCategory="
         + this.getProductCategory()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", lumpSumSystemType="
         + this.getLumpSumSystemType()
         + ", duration="
         + this.getDuration()
         + ", orderType="
         + this.getOrderType()
         + ", status="
         + this.getStatus()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
