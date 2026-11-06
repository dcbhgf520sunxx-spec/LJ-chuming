package com.hzchum.scim.mes.enclosure.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;

@ApiModel(value = "ProjectSchedulingDO", description = "项目排期信息 ")
public class ProjectSchedulingDO {
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "startDate", value = "开始时间", notes = "开始时间")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   @TableField("start_date")
   @Column(name = "start_date", columnDefinition = "datetime  COMMENT '开始时间'", nullable = false)
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "结束时间", notes = "结束时间")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   @TableField("end_date")
   @Column(name = "end_date", columnDefinition = "datetime  COMMENT '结束时间'", nullable = false)
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

   public static ProjectSchedulingDO.ProjectSchedulingDOBuilder builder() {
      return new ProjectSchedulingDO.ProjectSchedulingDOBuilder();
   }

   public ProjectSchedulingDO() {
   }

   public ProjectSchedulingDO(
      final ProjectDetailDO project,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final LocalDate createTime,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final Integer schedulingQuantity,
      final BigDecimal schedulingTotalNetWeight,
      final Integer constructionDay,
      final Integer status
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

   @JsonProperty("project")
   public ProjectSchedulingDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("startDate")
   public ProjectSchedulingDO setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public ProjectSchedulingDO setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("createTime")
   public ProjectSchedulingDO setCreateTime(final LocalDate createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("quantity")
   public ProjectSchedulingDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProjectSchedulingDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public ProjectSchedulingDO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("schedulingTotalNetWeight")
   public ProjectSchedulingDO setSchedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      return this;
   }

   @JsonProperty("constructionDay")
   public ProjectSchedulingDO setConstructionDay(final Integer constructionDay) {
      this.constructionDay = constructionDay;
      return this;
   }

   @JsonProperty("status")
   public ProjectSchedulingDO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSchedulingDO(project="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSchedulingDO)) {
         return false;
      }

      ProjectSchedulingDO other = (ProjectSchedulingDO)o;
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
                                 return this$schedulingTotalNetWeight == null
                                    ? other$schedulingTotalNetWeight == null
                                    : this$schedulingTotalNetWeight.equals(other$schedulingTotalNetWeight);
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
      return other instanceof ProjectSchedulingDO;
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
      return result * 59 + ($schedulingTotalNetWeight == null ? 43 : $schedulingTotalNetWeight.hashCode());
   }

   public static class ProjectSchedulingDOBuilder {
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

      ProjectSchedulingDOBuilder() {
      }

      @JsonProperty("project")
      public ProjectSchedulingDO.ProjectSchedulingDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("startDate")
      public ProjectSchedulingDO.ProjectSchedulingDOBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public ProjectSchedulingDO.ProjectSchedulingDOBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("createTime")
      public ProjectSchedulingDO.ProjectSchedulingDOBuilder createTime(final LocalDate createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectSchedulingDO.ProjectSchedulingDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProjectSchedulingDO.ProjectSchedulingDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public ProjectSchedulingDO.ProjectSchedulingDOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("schedulingTotalNetWeight")
      public ProjectSchedulingDO.ProjectSchedulingDOBuilder schedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
         this.schedulingTotalNetWeight = schedulingTotalNetWeight;
         return this;
      }

      @JsonProperty("constructionDay")
      public ProjectSchedulingDO.ProjectSchedulingDOBuilder constructionDay(final Integer constructionDay) {
         this.constructionDay = constructionDay;
         return this;
      }

      @JsonProperty("status")
      public ProjectSchedulingDO.ProjectSchedulingDOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectSchedulingDO build() {
         return new ProjectSchedulingDO(
            this.project,
            this.startDate,
            this.endDate,
            this.createTime,
            this.quantity,
            this.totalNetWeight,
            this.schedulingQuantity,
            this.schedulingTotalNetWeight,
            this.constructionDay,
            this.status
         );
      }

      @Override
      public String toString() {
         return "ProjectSchedulingDO.ProjectSchedulingDOBuilder(project="
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
            + ")";
      }
   }
}
