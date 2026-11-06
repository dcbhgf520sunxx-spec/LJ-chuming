package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingProductionTaskDO", description = "任务清单 ")
public class MesBuildingProductionTaskDO {
   @ApiModelProperty(name = "project", value = "项目")
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
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "completeTime", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "taskType", notes = "任务属性")
   @JsonProperty("taskType")
   @JSONField(name = "taskType")
   private Integer taskType;
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "inProductionQuantity", notes = "进入生产数量")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "netWeight", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", notes = "单面积(m2)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalSurfaceArea", notes = "总面积(m2)")
   private BigDecimal totalSurfaceArea;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "taskId", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "artifactName", notes = "构件名称", value = "构件名称")
   @JsonProperty("artifactName")
   @JSONField(name = "artifactName")
   private String artifactName;
   @ApiModelProperty(name = "boolPrint", notes = "是否打印", value = "是否打印")
   @JsonProperty("boolPrint")
   @JSONField(name = "boolPrint")
   private Boolean boolPrint;

   public static MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder builder() {
      return new MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder();
   }

   public MesBuildingProductionTaskDO() {
   }

   public MesBuildingProductionTaskDO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal length,
      final LocalDateTime completeTime,
      final Integer taskType,
      final Integer quantity,
      final Integer inProductionQuantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final BigDecimal totalSurfaceArea,
      final Long productId,
      final Long taskId,
      final String artifactName,
      final Boolean boolPrint
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.completeTime = completeTime;
      this.taskType = taskType;
      this.quantity = quantity;
      this.inProductionQuantity = inProductionQuantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.totalSurfaceArea = totalSurfaceArea;
      this.productId = productId;
      this.taskId = taskId;
      this.artifactName = artifactName;
      this.boolPrint = boolPrint;
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

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
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

   public Long getProductId() {
      return this.productId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public String getArtifactName() {
      return this.artifactName;
   }

   public Boolean getBoolPrint() {
      return this.boolPrint;
   }

   @JsonProperty("project")
   public MesBuildingProductionTaskDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingProductionTaskDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public MesBuildingProductionTaskDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingProductionTaskDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingProductionTaskDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingProductionTaskDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingProductionTaskDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingProductionTaskDO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("taskType")
   public MesBuildingProductionTaskDO setTaskType(final Integer taskType) {
      this.taskType = taskType;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingProductionTaskDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public MesBuildingProductionTaskDO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingProductionTaskDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesBuildingProductionTaskDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingProductionTaskDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesBuildingProductionTaskDO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public MesBuildingProductionTaskDO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public MesBuildingProductionTaskDO setTotalSurfaceArea(final BigDecimal totalSurfaceArea) {
      this.totalSurfaceArea = totalSurfaceArea;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingProductionTaskDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingProductionTaskDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("artifactName")
   public MesBuildingProductionTaskDO setArtifactName(final String artifactName) {
      this.artifactName = artifactName;
      return this;
   }

   @JsonProperty("boolPrint")
   public MesBuildingProductionTaskDO setBoolPrint(final Boolean boolPrint) {
      this.boolPrint = boolPrint;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductionTaskDO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", completeTime="
         + this.getCompleteTime()
         + ", taskType="
         + this.getTaskType()
         + ", quantity="
         + this.getQuantity()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalSurfaceArea="
         + this.getTotalSurfaceArea()
         + ", productId="
         + this.getProductId()
         + ", taskId="
         + this.getTaskId()
         + ", artifactName="
         + this.getArtifactName()
         + ", boolPrint="
         + this.getBoolPrint()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionTaskDO)) {
         return false;
      }

      MesBuildingProductionTaskDO other = (MesBuildingProductionTaskDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskType = this.getTaskType();
      Object other$taskType = other.getTaskType();
      if (this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$inProductionQuantity = this.getInProductionQuantity();
            Object other$inProductionQuantity = other.getInProductionQuantity();
            if (this$inProductionQuantity == null ? other$inProductionQuantity == null : this$inProductionQuantity.equals(other$inProductionQuantity)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$taskId = this.getTaskId();
                  Object other$taskId = other.getTaskId();
                  if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                     Object this$boolPrint = this.getBoolPrint();
                     Object other$boolPrint = other.getBoolPrint();
                     if (this$boolPrint == null ? other$boolPrint == null : this$boolPrint.equals(other$boolPrint)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$monomer = this.getMonomer();
                           Object other$monomer = other.getMonomer();
                           if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                              Object this$area = this.getArea();
                              Object other$area = other.getArea();
                              if (this$area == null ? other$area == null : this$area.equals(other$area)) {
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
                                             Object this$completeTime = this.getCompleteTime();
                                             Object other$completeTime = other.getCompleteTime();
                                             if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                                                Object this$netWeight = this.getNetWeight();
                                                Object other$netWeight = other.getNetWeight();
                                                if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                   Object this$grossWeight = this.getGrossWeight();
                                                   Object other$grossWeight = other.getGrossWeight();
                                                   if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
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
                                                                  Object this$artifactName = this.getArtifactName();
                                                                  Object other$artifactName = other.getArtifactName();
                                                                  return this$artifactName == null
                                                                     ? other$artifactName == null
                                                                     : this$artifactName.equals(other$artifactName);
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
      return other instanceof MesBuildingProductionTaskDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskType = this.getTaskType();
      result = result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $boolPrint = this.getBoolPrint();
      result = result * 59 + ($boolPrint == null ? 43 : $boolPrint.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
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
      Object $artifactName = this.getArtifactName();
      return result * 59 + ($artifactName == null ? 43 : $artifactName.hashCode());
   }

   public static class MesBuildingProductionTaskDOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal length;
      private LocalDateTime completeTime;
      private Integer taskType;
      private Integer quantity;
      private Integer inProductionQuantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private BigDecimal totalSurfaceArea;
      private Long productId;
      private Long taskId;
      private String artifactName;
      private Boolean boolPrint;

      MesBuildingProductionTaskDOBuilder() {
      }

      @JsonProperty("project")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("taskType")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder taskType(final Integer taskType) {
         this.taskType = taskType;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder totalSurfaceArea(final BigDecimal totalSurfaceArea) {
         this.totalSurfaceArea = totalSurfaceArea;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("artifactName")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder artifactName(final String artifactName) {
         this.artifactName = artifactName;
         return this;
      }

      @JsonProperty("boolPrint")
      public MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder boolPrint(final Boolean boolPrint) {
         this.boolPrint = boolPrint;
         return this;
      }

      public MesBuildingProductionTaskDO build() {
         return new MesBuildingProductionTaskDO(
            this.project,
            this.monomer,
            this.area,
            this.serialNumber,
            this.specification,
            this.material,
            this.length,
            this.completeTime,
            this.taskType,
            this.quantity,
            this.inProductionQuantity,
            this.netWeight,
            this.grossWeight,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.totalSurfaceArea,
            this.productId,
            this.taskId,
            this.artifactName,
            this.boolPrint
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductionTaskDO.MesBuildingProductionTaskDOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", completeTime="
            + this.completeTime
            + ", taskType="
            + this.taskType
            + ", quantity="
            + this.quantity
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalSurfaceArea="
            + this.totalSurfaceArea
            + ", productId="
            + this.productId
            + ", taskId="
            + this.taskId
            + ", artifactName="
            + this.artifactName
            + ", boolPrint="
            + this.boolPrint
            + ")";
      }
   }
}
