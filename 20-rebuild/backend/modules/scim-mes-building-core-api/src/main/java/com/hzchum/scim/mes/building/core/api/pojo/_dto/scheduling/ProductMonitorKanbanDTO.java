package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.ProjectDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductMonitorKanbanDTO", description = "项目排期信息 ")
public class ProductMonitorKanbanDTO {
   @ApiModelProperty(name = "workshop", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDTO project;
   @ApiModelProperty(name = "monomer", value = "单体信息")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", value = "区域信息")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务量")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务量(毛重)")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成量")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成量(毛重)")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "status", notes = "排产状态 1:生产中 2:已完成 4暂停")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;

   public static ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder builder() {
      return new ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder();
   }

   public ProductMonitorKanbanDTO() {
   }

   public ProductMonitorKanbanDTO(
      final WorkshopDetailDO workshop,
      final ProjectDetailDTO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final Integer taskQuantity,
      final BigDecimal taskNetWeight,
      final BigDecimal taskGrossWeight,
      final Integer completeQuantity,
      final BigDecimal completeNetWeight,
      final BigDecimal completeGrossWeight,
      final Integer status
   ) {
      this.workshop = workshop;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.taskQuantity = taskQuantity;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.completeQuantity = completeQuantity;
      this.completeNetWeight = completeNetWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.status = status;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProjectDetailDTO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("workshop")
   public ProductMonitorKanbanDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("project")
   public ProductMonitorKanbanDTO setProject(final ProjectDetailDTO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public ProductMonitorKanbanDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public ProductMonitorKanbanDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("taskQuantity")
   public ProductMonitorKanbanDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public ProductMonitorKanbanDTO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public ProductMonitorKanbanDTO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ProductMonitorKanbanDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public ProductMonitorKanbanDTO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public ProductMonitorKanbanDTO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("status")
   public ProductMonitorKanbanDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "ProductMonitorKanbanDTO(workshop="
         + this.getWorkshop()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductMonitorKanbanDTO)) {
         return false;
      }

      ProductMonitorKanbanDTO other = (ProductMonitorKanbanDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskQuantity = this.getTaskQuantity();
      Object other$taskQuantity = other.getTaskQuantity();
      if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$workshop = this.getWorkshop();
               Object other$workshop = other.getWorkshop();
               if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomer = this.getMonomer();
                     Object other$monomer = other.getMonomer();
                     if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                        Object this$area = this.getArea();
                        Object other$area = other.getArea();
                        if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                           Object this$taskNetWeight = this.getTaskNetWeight();
                           Object other$taskNetWeight = other.getTaskNetWeight();
                           if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                              Object this$taskGrossWeight = this.getTaskGrossWeight();
                              Object other$taskGrossWeight = other.getTaskGrossWeight();
                              if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                                 Object this$completeNetWeight = this.getCompleteNetWeight();
                                 Object other$completeNetWeight = other.getCompleteNetWeight();
                                 if (this$completeNetWeight == null ? other$completeNetWeight == null : this$completeNetWeight.equals(other$completeNetWeight)) {
                                    Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                    Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                    return this$completeGrossWeight == null
                                       ? other$completeGrossWeight == null
                                       : this$completeGrossWeight.equals(other$completeGrossWeight);
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
      return other instanceof ProductMonitorKanbanDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      return result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
   }

   public static class ProductMonitorKanbanDTOBuilder {
      private WorkshopDetailDO workshop;
      private ProjectDetailDTO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private Integer taskQuantity;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private Integer completeQuantity;
      private BigDecimal completeNetWeight;
      private BigDecimal completeGrossWeight;
      private Integer status;

      ProductMonitorKanbanDTOBuilder() {
      }

      @JsonProperty("workshop")
      public ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("project")
      public ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder project(final ProjectDetailDTO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("taskQuantity")
      public ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("status")
      public ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProductMonitorKanbanDTO build() {
         return new ProductMonitorKanbanDTO(
            this.workshop,
            this.project,
            this.monomer,
            this.area,
            this.taskQuantity,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.completeQuantity,
            this.completeNetWeight,
            this.completeGrossWeight,
            this.status
         );
      }

      @Override
      public String toString() {
         return "ProductMonitorKanbanDTO.ProductMonitorKanbanDTOBuilder(workshop="
            + this.workshop
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", status="
            + this.status
            + ")";
      }
   }
}
