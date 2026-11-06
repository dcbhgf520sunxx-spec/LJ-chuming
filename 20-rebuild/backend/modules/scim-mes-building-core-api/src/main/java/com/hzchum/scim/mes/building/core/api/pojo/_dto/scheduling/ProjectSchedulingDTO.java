package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(value = "ProjectSchedulingDTO", description = "项目排期信息 ")
public class ProjectSchedulingDTO {
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "startDate", value = "开始时间", notes = "开始时间")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "结束时间", notes = "结束时间")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "createTime", notes = "签订日期")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDate createTime;
   @ApiModelProperty(name = "quantity", notes = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", notes = "清单量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "schedulingQuantity", notes = "清单数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "schedulingTotalNetWeight", notes = "清单量")
   @JsonProperty("schedulingTotalNetWeight")
   @JSONField(name = "schedulingTotalNetWeight")
   private BigDecimal schedulingTotalNetWeight;
   @ApiModelProperty(name = "constructionDay", notes = "工期")
   @JsonProperty("constructionDay")
   @JSONField(name = "constructionDay")
   private Integer constructionDay;
   @ApiModelProperty(name = "status", notes = "排产状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "productionSchedulingQuantity", notes = "排产数量")
   private Integer productionSchedulingQuantity;
   @ApiModelProperty(name = "productionSchedulingWeight", notes = "排产重量(kg)")
   private BigDecimal productionSchedulingWeight;

   public static ProjectSchedulingDTO.ProjectSchedulingDTOBuilder builder() {
      return new ProjectSchedulingDTO.ProjectSchedulingDTOBuilder();
   }

   public ProjectSchedulingDTO() {
   }

   public ProjectSchedulingDTO(
      final ProjectDetailDO project,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final LocalDate createTime,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final Integer schedulingQuantity,
      final BigDecimal schedulingTotalNetWeight,
      final Integer constructionDay,
      final Integer status,
      final Integer productionSchedulingQuantity,
      final BigDecimal productionSchedulingWeight
   ) {
      this.project = project;
      this.startDate = startDate;
      this.endDate = endDate;
      this.createTime = createTime;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.schedulingQuantity = schedulingQuantity;
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      this.constructionDay = constructionDay;
      this.status = status;
      this.productionSchedulingQuantity = productionSchedulingQuantity;
      this.productionSchedulingWeight = productionSchedulingWeight;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public LocalDate getCreateTime() {
      return this.createTime;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public BigDecimal getSchedulingTotalNetWeight() {
      return this.schedulingTotalNetWeight;
   }

   public Integer getConstructionDay() {
      return this.constructionDay;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getProductionSchedulingQuantity() {
      return this.productionSchedulingQuantity;
   }

   public BigDecimal getProductionSchedulingWeight() {
      return this.productionSchedulingWeight;
   }

   @JsonProperty("project")
   public ProjectSchedulingDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("startDate")
   public ProjectSchedulingDTO setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public ProjectSchedulingDTO setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("createTime")
   public ProjectSchedulingDTO setCreateTime(final LocalDate createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("quantity")
   public ProjectSchedulingDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProjectSchedulingDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public ProjectSchedulingDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("schedulingTotalNetWeight")
   public ProjectSchedulingDTO setSchedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      return this;
   }

   @JsonProperty("constructionDay")
   public ProjectSchedulingDTO setConstructionDay(final Integer constructionDay) {
      this.constructionDay = constructionDay;
      return this;
   }

   @JsonProperty("status")
   public ProjectSchedulingDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public ProjectSchedulingDTO setProductionSchedulingQuantity(final Integer productionSchedulingQuantity) {
      this.productionSchedulingQuantity = productionSchedulingQuantity;
      return this;
   }

   public ProjectSchedulingDTO setProductionSchedulingWeight(final BigDecimal productionSchedulingWeight) {
      this.productionSchedulingWeight = productionSchedulingWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSchedulingDTO(project="
         + this.getProject()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", createTime="
         + this.getCreateTime()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", schedulingTotalNetWeight="
         + this.getSchedulingTotalNetWeight()
         + ", constructionDay="
         + this.getConstructionDay()
         + ", status="
         + this.getStatus()
         + ", productionSchedulingQuantity="
         + this.getProductionSchedulingQuantity()
         + ", productionSchedulingWeight="
         + this.getProductionSchedulingWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSchedulingDTO)) {
         return false;
      }

      ProjectSchedulingDTO other = (ProjectSchedulingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$schedulingQuantity = this.getSchedulingQuantity();
         Object other$schedulingQuantity = other.getSchedulingQuantity();
         if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
            Object this$constructionDay = this.getConstructionDay();
            Object other$constructionDay = other.getConstructionDay();
            if (this$constructionDay == null ? other$constructionDay == null : this$constructionDay.equals(other$constructionDay)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$productionSchedulingQuantity = this.getProductionSchedulingQuantity();
                  Object other$productionSchedulingQuantity = other.getProductionSchedulingQuantity();
                  if (this$productionSchedulingQuantity == null
                     ? other$productionSchedulingQuantity == null
                     : this$productionSchedulingQuantity.equals(other$productionSchedulingQuantity)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$startDate = this.getStartDate();
                        Object other$startDate = other.getStartDate();
                        if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                           Object this$endDate = this.getEndDate();
                           Object other$endDate = other.getEndDate();
                           if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                              Object this$createTime = this.getCreateTime();
                              Object other$createTime = other.getCreateTime();
                              if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                 Object this$totalNetWeight = this.getTotalNetWeight();
                                 Object other$totalNetWeight = other.getTotalNetWeight();
                                 if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                    Object this$schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
                                    Object other$schedulingTotalNetWeight = other.getSchedulingTotalNetWeight();
                                    if (this$schedulingTotalNetWeight == null
                                       ? other$schedulingTotalNetWeight == null
                                       : this$schedulingTotalNetWeight.equals(other$schedulingTotalNetWeight)) {
                                       Object this$productionSchedulingWeight = this.getProductionSchedulingWeight();
                                       Object other$productionSchedulingWeight = other.getProductionSchedulingWeight();
                                       return this$productionSchedulingWeight == null
                                          ? other$productionSchedulingWeight == null
                                          : this$productionSchedulingWeight.equals(other$productionSchedulingWeight);
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
      return other instanceof ProjectSchedulingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $constructionDay = this.getConstructionDay();
      result = result * 59 + ($constructionDay == null ? 43 : $constructionDay.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $productionSchedulingQuantity = this.getProductionSchedulingQuantity();
      result = result * 59 + ($productionSchedulingQuantity == null ? 43 : $productionSchedulingQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
      result = result * 59 + ($schedulingTotalNetWeight == null ? 43 : $schedulingTotalNetWeight.hashCode());
      Object $productionSchedulingWeight = this.getProductionSchedulingWeight();
      return result * 59 + ($productionSchedulingWeight == null ? 43 : $productionSchedulingWeight.hashCode());
   }

   public static class ProjectSchedulingDTOBuilder {
      private ProjectDetailDO project;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private LocalDate createTime;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private Integer schedulingQuantity;
      private BigDecimal schedulingTotalNetWeight;
      private Integer constructionDay;
      private Integer status;
      private Integer productionSchedulingQuantity;
      private BigDecimal productionSchedulingWeight;

      ProjectSchedulingDTOBuilder() {
      }

      @JsonProperty("project")
      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("startDate")
      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("createTime")
      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder createTime(final LocalDate createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("schedulingTotalNetWeight")
      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder schedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
         this.schedulingTotalNetWeight = schedulingTotalNetWeight;
         return this;
      }

      @JsonProperty("constructionDay")
      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder constructionDay(final Integer constructionDay) {
         this.constructionDay = constructionDay;
         return this;
      }

      @JsonProperty("status")
      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder productionSchedulingQuantity(final Integer productionSchedulingQuantity) {
         this.productionSchedulingQuantity = productionSchedulingQuantity;
         return this;
      }

      public ProjectSchedulingDTO.ProjectSchedulingDTOBuilder productionSchedulingWeight(final BigDecimal productionSchedulingWeight) {
         this.productionSchedulingWeight = productionSchedulingWeight;
         return this;
      }

      public ProjectSchedulingDTO build() {
         return new ProjectSchedulingDTO(
            this.project,
            this.startDate,
            this.endDate,
            this.createTime,
            this.quantity,
            this.totalNetWeight,
            this.schedulingQuantity,
            this.schedulingTotalNetWeight,
            this.constructionDay,
            this.status,
            this.productionSchedulingQuantity,
            this.productionSchedulingWeight
         );
      }

      @Override
      public String toString() {
         return "ProjectSchedulingDTO.ProjectSchedulingDTOBuilder(project="
            + this.project
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", createTime="
            + this.createTime
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", schedulingTotalNetWeight="
            + this.schedulingTotalNetWeight
            + ", constructionDay="
            + this.constructionDay
            + ", status="
            + this.status
            + ", productionSchedulingQuantity="
            + this.productionSchedulingQuantity
            + ", productionSchedulingWeight="
            + this.productionSchedulingWeight
            + ")";
      }
   }
}
