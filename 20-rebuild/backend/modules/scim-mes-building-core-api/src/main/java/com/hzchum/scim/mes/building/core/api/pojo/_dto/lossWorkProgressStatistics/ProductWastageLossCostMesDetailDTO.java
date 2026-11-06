package com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductWastageLossCostMesDetailDTO {
   @ApiModelProperty(name = "workshopName", value = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "produceWorkshopName", value = "生产车间")
   private String produceWorkshopName;
   @ApiModelProperty(name = "productionLineName", value = "产线名称")
   private String productionLineName;
   @ApiModelProperty(name = "groupsName", value = "生产组名称")
   private String groupsName;
   @ApiModelProperty(name = "groupsId", value = "生产组Id")
   private Long groupsId;
   @ApiModelProperty(name = "teamName", value = "班组名称")
   private String teamName;
   @ApiModelProperty(name = "processId", value = "工序id")
   private Long processId;
   @ApiModelProperty(name = "processName", value = "工序名称")
   private String processName;
   @ApiModelProperty(name = "project", value = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "relationType", value = "零件类型")
   private Integer relationType;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "boolAssist", notes = "是否协同")
   @JsonProperty("boolAssist")
   @JSONField(name = "boolAssist")
   private Boolean boolAssist;

   public static ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder builder() {
      return new ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder();
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProduceWorkshopName() {
      return this.produceWorkshopName;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public String getGroupsName() {
      return this.groupsName;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public ProjectInfo getProject() {
      return this.project;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Boolean getBoolAssist() {
      return this.boolAssist;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setProduceWorkshopName(final String produceWorkshopName) {
      this.produceWorkshopName = produceWorkshopName;
   }

   public void setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
   }

   public void setGroupsName(final String groupsName) {
      this.groupsName = groupsName;
   }

   public void setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
   }

   public void setTeamName(final String teamName) {
      this.teamName = teamName;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @JsonProperty("boolAssist")
   public void setBoolAssist(final Boolean boolAssist) {
      this.boolAssist = boolAssist;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductWastageLossCostMesDetailDTO)) {
         return false;
      }

      ProductWastageLossCostMesDetailDTO other = (ProductWastageLossCostMesDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$groupsId = this.getGroupsId();
      Object other$groupsId = other.getGroupsId();
      if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$relationType = this.getRelationType();
               Object other$relationType = other.getRelationType();
               if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                  Object this$boolAssist = this.getBoolAssist();
                  Object other$boolAssist = other.getBoolAssist();
                  if (this$boolAssist == null ? other$boolAssist == null : this$boolAssist.equals(other$boolAssist)) {
                     Object this$workshopName = this.getWorkshopName();
                     Object other$workshopName = other.getWorkshopName();
                     if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                        Object this$produceWorkshopName = this.getProduceWorkshopName();
                        Object other$produceWorkshopName = other.getProduceWorkshopName();
                        if (this$produceWorkshopName == null ? other$produceWorkshopName == null : this$produceWorkshopName.equals(other$produceWorkshopName)) {
                           Object this$productionLineName = this.getProductionLineName();
                           Object other$productionLineName = other.getProductionLineName();
                           if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                              Object this$groupsName = this.getGroupsName();
                              Object other$groupsName = other.getGroupsName();
                              if (this$groupsName == null ? other$groupsName == null : this$groupsName.equals(other$groupsName)) {
                                 Object this$teamName = this.getTeamName();
                                 Object other$teamName = other.getTeamName();
                                 if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                                    Object this$processName = this.getProcessName();
                                    Object other$processName = other.getProcessName();
                                    if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                       Object this$project = this.getProject();
                                       Object other$project = other.getProject();
                                       if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                          Object this$name = this.getName();
                                          Object other$name = other.getName();
                                          if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$length = this.getLength();
                                                   Object other$length = other.getLength();
                                                   if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$netWeight = this.getNetWeight();
                                                         Object other$netWeight = other.getNetWeight();
                                                         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                            Object this$totalNetWeight = this.getTotalNetWeight();
                                                            Object other$totalNetWeight = other.getTotalNetWeight();
                                                            if (this$totalNetWeight == null
                                                               ? other$totalNetWeight == null
                                                               : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                               Object this$grossWeight = this.getGrossWeight();
                                                               Object other$grossWeight = other.getGrossWeight();
                                                               if (this$grossWeight == null
                                                                  ? other$grossWeight == null
                                                                  : this$grossWeight.equals(other$grossWeight)) {
                                                                  Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                  Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                  if (this$totalGrossWeight == null
                                                                     ? other$totalGrossWeight == null
                                                                     : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                     Object this$createTime = this.getCreateTime();
                                                                     Object other$createTime = other.getCreateTime();
                                                                     return this$createTime == null
                                                                        ? other$createTime == null
                                                                        : this$createTime.equals(other$createTime);
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
      return other instanceof ProductWastageLossCostMesDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $boolAssist = this.getBoolAssist();
      result = result * 59 + ($boolAssist == null ? 43 : $boolAssist.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $produceWorkshopName = this.getProduceWorkshopName();
      result = result * 59 + ($produceWorkshopName == null ? 43 : $produceWorkshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $groupsName = this.getGroupsName();
      result = result * 59 + ($groupsName == null ? 43 : $groupsName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProductWastageLossCostMesDetailDTO(workshopName="
         + this.getWorkshopName()
         + ", produceWorkshopName="
         + this.getProduceWorkshopName()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", groupsName="
         + this.getGroupsName()
         + ", groupsId="
         + this.getGroupsId()
         + ", teamName="
         + this.getTeamName()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", project="
         + this.getProject()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", relationType="
         + this.getRelationType()
         + ", createTime="
         + this.getCreateTime()
         + ", boolAssist="
         + this.getBoolAssist()
         + ")";
   }

   public ProductWastageLossCostMesDetailDTO(
      final String workshopName,
      final String produceWorkshopName,
      final String productionLineName,
      final String groupsName,
      final Long groupsId,
      final String teamName,
      final Long processId,
      final String processName,
      final ProjectInfo project,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final Integer relationType,
      final LocalDateTime createTime,
      final Boolean boolAssist
   ) {
      this.workshopName = workshopName;
      this.produceWorkshopName = produceWorkshopName;
      this.productionLineName = productionLineName;
      this.groupsName = groupsName;
      this.groupsId = groupsId;
      this.teamName = teamName;
      this.processId = processId;
      this.processName = processName;
      this.project = project;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.relationType = relationType;
      this.createTime = createTime;
      this.boolAssist = boolAssist;
   }

   public ProductWastageLossCostMesDetailDTO() {
   }

   public static class ProductWastageLossCostMesDetailDTOBuilder {
      private String workshopName;
      private String produceWorkshopName;
      private String productionLineName;
      private String groupsName;
      private Long groupsId;
      private String teamName;
      private Long processId;
      private String processName;
      private ProjectInfo project;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private Integer relationType;
      private LocalDateTime createTime;
      private Boolean boolAssist;

      ProductWastageLossCostMesDetailDTOBuilder() {
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder produceWorkshopName(final String produceWorkshopName) {
         this.produceWorkshopName = produceWorkshopName;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder groupsName(final String groupsName) {
         this.groupsName = groupsName;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("boolAssist")
      public ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder boolAssist(final Boolean boolAssist) {
         this.boolAssist = boolAssist;
         return this;
      }

      public ProductWastageLossCostMesDetailDTO build() {
         return new ProductWastageLossCostMesDetailDTO(
            this.workshopName,
            this.produceWorkshopName,
            this.productionLineName,
            this.groupsName,
            this.groupsId,
            this.teamName,
            this.processId,
            this.processName,
            this.project,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.relationType,
            this.createTime,
            this.boolAssist
         );
      }

      @Override
      public String toString() {
         return "ProductWastageLossCostMesDetailDTO.ProductWastageLossCostMesDetailDTOBuilder(workshopName="
            + this.workshopName
            + ", produceWorkshopName="
            + this.produceWorkshopName
            + ", productionLineName="
            + this.productionLineName
            + ", groupsName="
            + this.groupsName
            + ", groupsId="
            + this.groupsId
            + ", teamName="
            + this.teamName
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", project="
            + this.project
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", relationType="
            + this.relationType
            + ", createTime="
            + this.createTime
            + ", boolAssist="
            + this.boolAssist
            + ")";
      }
   }
}
