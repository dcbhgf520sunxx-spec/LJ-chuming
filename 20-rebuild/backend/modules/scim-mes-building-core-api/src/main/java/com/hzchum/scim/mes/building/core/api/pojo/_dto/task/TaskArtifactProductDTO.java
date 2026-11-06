package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "TaskArtifactProductDTO", description = "")
public class TaskArtifactProductDTO {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private NameInfo groups;
   @ApiModelProperty(name = "order", notes = "任务工单")
   @JsonProperty("order")
   @JSONField(name = "order")
   private NameInfo order;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "name", value = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "unQuantity", notes = "未完成数量")
   @JsonProperty("unQuantity")
   @JSONField(name = "unQuantity")
   private Integer unQuantity;
   @ApiModelProperty(name = "completeDate", notes = "完成时间")
   @JsonProperty("completeDate")
   @JSONField(name = "completeDate")
   private LocalDateTime completeDate;
   @ApiModelProperty(name = "status", notes = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;

   public static TaskArtifactProductDTO.TaskArtifactProductDTOBuilder builder() {
      return new TaskArtifactProductDTO.TaskArtifactProductDTOBuilder();
   }

   public TaskArtifactProductDTO() {
   }

   public TaskArtifactProductDTO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final ProductionLineDetailDO productionLine,
      final NameInfo groups,
      final NameInfo order,
      final Integer productType,
      final String name,
      final String serialNumber,
      final String specification,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Integer completeQuantity,
      final Integer unQuantity,
      final LocalDateTime completeDate,
      final Integer status
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.productionLine = productionLine;
      this.groups = groups;
      this.order = order;
      this.productType = productType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.completeQuantity = completeQuantity;
      this.unQuantity = unQuantity;
      this.completeDate = completeDate;
      this.status = status;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public NameInfo getGroups() {
      return this.groups;
   }

   public NameInfo getOrder() {
      return this.order;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getUnQuantity() {
      return this.unQuantity;
   }

   public LocalDateTime getCompleteDate() {
      return this.completeDate;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("project")
   public TaskArtifactProductDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public TaskArtifactProductDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public TaskArtifactProductDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("productionLine")
   public TaskArtifactProductDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public TaskArtifactProductDTO setGroups(final NameInfo groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("order")
   public TaskArtifactProductDTO setOrder(final NameInfo order) {
      this.order = order;
      return this;
   }

   @JsonProperty("productType")
   public TaskArtifactProductDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("name")
   public TaskArtifactProductDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public TaskArtifactProductDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TaskArtifactProductDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public TaskArtifactProductDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public TaskArtifactProductDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public TaskArtifactProductDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TaskArtifactProductDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("unQuantity")
   public TaskArtifactProductDTO setUnQuantity(final Integer unQuantity) {
      this.unQuantity = unQuantity;
      return this;
   }

   @JsonProperty("completeDate")
   public TaskArtifactProductDTO setCompleteDate(final LocalDateTime completeDate) {
      this.completeDate = completeDate;
      return this;
   }

   @JsonProperty("status")
   public TaskArtifactProductDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "TaskArtifactProductDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", order="
         + this.getOrder()
         + ", productType="
         + this.getProductType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", unQuantity="
         + this.getUnQuantity()
         + ", completeDate="
         + this.getCompleteDate()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskArtifactProductDTO)) {
         return false;
      }

      TaskArtifactProductDTO other = (TaskArtifactProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$unQuantity = this.getUnQuantity();
               Object other$unQuantity = other.getUnQuantity();
               if (this$unQuantity == null ? other$unQuantity == null : this$unQuantity.equals(other$unQuantity)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$productionLine = this.getProductionLine();
                              Object other$productionLine = other.getProductionLine();
                              if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                 Object this$groups = this.getGroups();
                                 Object other$groups = other.getGroups();
                                 if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                                    Object this$order = this.getOrder();
                                    Object other$order = other.getOrder();
                                    if (this$order == null ? other$order == null : this$order.equals(other$order)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$netWeight = this.getNetWeight();
                                                Object other$netWeight = other.getNetWeight();
                                                if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                   Object this$grossWeight = this.getGrossWeight();
                                                   Object other$grossWeight = other.getGrossWeight();
                                                   if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                      Object this$completeDate = this.getCompleteDate();
                                                      Object other$completeDate = other.getCompleteDate();
                                                      return this$completeDate == null
                                                         ? other$completeDate == null
                                                         : this$completeDate.equals(other$completeDate);
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
      return other instanceof TaskArtifactProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $unQuantity = this.getUnQuantity();
      result = result * 59 + ($unQuantity == null ? 43 : $unQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $order = this.getOrder();
      result = result * 59 + ($order == null ? 43 : $order.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $completeDate = this.getCompleteDate();
      return result * 59 + ($completeDate == null ? 43 : $completeDate.hashCode());
   }

   public static class TaskArtifactProductDTOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private ProductionLineDetailDO productionLine;
      private NameInfo groups;
      private NameInfo order;
      private Integer productType;
      private String name;
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Integer completeQuantity;
      private Integer unQuantity;
      private LocalDateTime completeDate;
      private Integer status;

      TaskArtifactProductDTOBuilder() {
      }

      @JsonProperty("project")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("productionLine")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder groups(final NameInfo groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("order")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder order(final NameInfo order) {
         this.order = order;
         return this;
      }

      @JsonProperty("productType")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("name")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("unQuantity")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder unQuantity(final Integer unQuantity) {
         this.unQuantity = unQuantity;
         return this;
      }

      @JsonProperty("completeDate")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder completeDate(final LocalDateTime completeDate) {
         this.completeDate = completeDate;
         return this;
      }

      @JsonProperty("status")
      public TaskArtifactProductDTO.TaskArtifactProductDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public TaskArtifactProductDTO build() {
         return new TaskArtifactProductDTO(
            this.project,
            this.monomer,
            this.area,
            this.productionLine,
            this.groups,
            this.order,
            this.productType,
            this.name,
            this.serialNumber,
            this.specification,
            this.quantity,
            this.netWeight,
            this.grossWeight,
            this.completeQuantity,
            this.unQuantity,
            this.completeDate,
            this.status
         );
      }

      @Override
      public String toString() {
         return "TaskArtifactProductDTO.TaskArtifactProductDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", order="
            + this.order
            + ", productType="
            + this.productType
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", unQuantity="
            + this.unQuantity
            + ", completeDate="
            + this.completeDate
            + ", status="
            + this.status
            + ")";
      }
   }
}
