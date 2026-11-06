package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "WorkshopSummaryDTO", description = "车间报表清单")
public class WorkshopSummaryDTO {
   @ApiModelProperty(name = "taskId", value = "任务ID")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "productId", value = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productionLine", value = "产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groupsId", value = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "groupsName", value = "生产组名称")
   @JsonProperty("groupsName")
   @JSONField(name = "groupsName")
   private String groupsName;
   @ApiModelProperty(name = "teamId", value = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "teamName", value = "班组名")
   @JsonProperty("teamName")
   @JSONField(name = "teamName")
   private String teamName;
   @ApiModelProperty(name = "date", value = "入库时间")
   @JsonProperty("date")
   @JSONField(name = "date")
   private LocalDateTime date;
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", value = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "name", value = "产品名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "length", value = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "netWeight", value = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(m2)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalGrossWeight", value = "总面积(m2)")
   private BigDecimal totalSurfaceArea;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   private String orderNumber;

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public String getGroupsName() {
      return this.groupsName;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public LocalDateTime getDate() {
      return this.date;
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

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalSurfaceArea() {
      return this.totalSurfaceArea;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   @JsonProperty("taskId")
   public WorkshopSummaryDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("productId")
   public WorkshopSummaryDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productionLine")
   public WorkshopSummaryDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groupsId")
   public WorkshopSummaryDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("groupsName")
   public WorkshopSummaryDTO setGroupsName(final String groupsName) {
      this.groupsName = groupsName;
      return this;
   }

   @JsonProperty("teamId")
   public WorkshopSummaryDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("teamName")
   public WorkshopSummaryDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   @JsonProperty("date")
   public WorkshopSummaryDTO setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   @JsonProperty("project")
   public WorkshopSummaryDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public WorkshopSummaryDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public WorkshopSummaryDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("name")
   public WorkshopSummaryDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public WorkshopSummaryDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public WorkshopSummaryDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public WorkshopSummaryDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("length")
   public WorkshopSummaryDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("netWeight")
   public WorkshopSummaryDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public WorkshopSummaryDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("quantity")
   public WorkshopSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public WorkshopSummaryDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public WorkshopSummaryDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public WorkshopSummaryDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public WorkshopSummaryDTO setTotalSurfaceArea(final BigDecimal totalSurfaceArea) {
      this.totalSurfaceArea = totalSurfaceArea;
      return this;
   }

   public WorkshopSummaryDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopSummaryDTO(taskId="
         + this.getTaskId()
         + ", productId="
         + this.getProductId()
         + ", productionLine="
         + this.getProductionLine()
         + ", groupsId="
         + this.getGroupsId()
         + ", groupsName="
         + this.getGroupsName()
         + ", teamId="
         + this.getTeamId()
         + ", teamName="
         + this.getTeamName()
         + ", date="
         + this.getDate()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalSurfaceArea="
         + this.getTotalSurfaceArea()
         + ", orderNumber="
         + this.getOrderNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopSummaryDTO)) {
         return false;
      }

      WorkshopSummaryDTO other = (WorkshopSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$groupsId = this.getGroupsId();
            Object other$groupsId = other.getGroupsId();
            if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$productionLine = this.getProductionLine();
                     Object other$productionLine = other.getProductionLine();
                     if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                        Object this$groupsName = this.getGroupsName();
                        Object other$groupsName = other.getGroupsName();
                        if (this$groupsName == null ? other$groupsName == null : this$groupsName.equals(other$groupsName)) {
                           Object this$teamName = this.getTeamName();
                           Object other$teamName = other.getTeamName();
                           if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                              Object this$date = this.getDate();
                              Object other$date = other.getDate();
                              if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                                 Object this$project = this.getProject();
                                 Object other$project = other.getProject();
                                 if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                    Object this$monomer = this.getMonomer();
                                    Object other$monomer = other.getMonomer();
                                    if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                       Object this$area = this.getArea();
                                       Object other$area = other.getArea();
                                       if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                          Object this$name = this.getName();
                                          Object other$name = other.getName();
                                          if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$material = this.getMaterial();
                                                   Object other$material = other.getMaterial();
                                                   if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                      Object this$length = this.getLength();
                                                      Object other$length = other.getLength();
                                                      if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                         Object this$netWeight = this.getNetWeight();
                                                         Object other$netWeight = other.getNetWeight();
                                                         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                            Object this$grossWeight = this.getGrossWeight();
                                                            Object other$grossWeight = other.getGrossWeight();
                                                            if (this$grossWeight == null
                                                               ? other$grossWeight == null
                                                               : this$grossWeight.equals(other$grossWeight)) {
                                                               Object this$totalNetWeight = this.getTotalNetWeight();
                                                               Object other$totalNetWeight = other.getTotalNetWeight();
                                                               if (this$totalNetWeight == null
                                                                  ? other$totalNetWeight == null
                                                                  : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                  Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                  Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                  if (this$totalGrossWeight == null
                                                                     ? other$totalGrossWeight == null
                                                                     : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                     Object this$surfaceArea = this.getSurfaceArea();
                                                                     Object other$surfaceArea = other.getSurfaceArea();
                                                                     if (this$surfaceArea == null
                                                                        ? other$surfaceArea == null
                                                                        : this$surfaceArea.equals(other$surfaceArea)) {
                                                                        Object this$totalSurfaceArea = this.getTotalSurfaceArea();
                                                                        Object other$totalSurfaceArea = other.getTotalSurfaceArea();
                                                                        if (this$totalSurfaceArea == null
                                                                           ? other$totalSurfaceArea == null
                                                                           : this$totalSurfaceArea.equals(other$totalSurfaceArea)) {
                                                                           Object this$orderNumber = this.getOrderNumber();
                                                                           Object other$orderNumber = other.getOrderNumber();
                                                                           return this$orderNumber == null
                                                                              ? other$orderNumber == null
                                                                              : this$orderNumber.equals(other$orderNumber);
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
      return other instanceof WorkshopSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groupsName = this.getGroupsName();
      result = result * 59 + ($groupsName == null ? 43 : $groupsName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalSurfaceArea = this.getTotalSurfaceArea();
      result = result * 59 + ($totalSurfaceArea == null ? 43 : $totalSurfaceArea.hashCode());
      Object $orderNumber = this.getOrderNumber();
      return result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
   }
}
