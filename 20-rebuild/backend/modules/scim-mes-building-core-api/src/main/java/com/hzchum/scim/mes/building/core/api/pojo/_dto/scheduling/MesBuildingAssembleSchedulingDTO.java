package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingAssembleSchedulingDTO", description = "构件排产所需部件信息")
public class MesBuildingAssembleSchedulingDTO {
   @ApiModelProperty(name = "workShopId", value = "车间id")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "workShopName", value = "车间名称")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "productId", value = "构件id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "assembleConfigId", value = "部件配置表id")
   @JsonProperty("assembleConfigId")
   @JSONField(name = "assembleConfigId")
   private Long assembleConfigId;
   @ApiModelProperty(name = "assembleConfigName", value = "部件配置表名称")
   @JsonProperty("assembleConfigName")
   @JSONField(name = "assembleConfigName")
   private String assembleConfigName;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序")
   @JsonProperty("boolProcess")
   @JSONField(name = "boolProcess")
   private Boolean boolProcess;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [false 否, true 是]", notes = "是否成品型材 [false 否, true 是]]")
   @JsonProperty("boolSectionSteel")
   @JSONField(name = "boolSectionSteel")
   private Boolean boolSectionSteel;
   @ApiModelProperty(name = "typesettingAssembleTypeEnum", value = "材料属性")
   @JsonProperty("typesettingAssembleTypeEnum")
   @JSONField(name = "typesettingAssembleTypeEnum")
   private Integer typesettingAssembleTypeEnum;
   @ApiModelProperty(name = "boolOneCode", value = "是否一物一码 [false 否, true 是]", notes = "是否一物一码 [false 否, true 是]]")
   @JsonProperty("boolOneCode")
   @JSONField(name = "boolOneCode")
   private Boolean boolOneCode;
   @ApiModelProperty(name = "boolMainAssemble", value = "是否主部件 true是 false否")
   @JsonProperty("boolMainAssemble")
   @JSONField(name = "boolMainAssemble")
   private Boolean boolMainAssemble;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @JsonProperty("mesProductEnum")
   @JSONField(name = "mesProductEnum")
   private Integer mesProductEnum;
   @ApiModelProperty("构件要求完成日期")
   @JsonProperty("artifactAskCompleteTime")
   @JSONField(name = "artifactAskCompleteTime")
   private LocalDateTime artifactAskCompleteTime;
   @ApiModelProperty(name = "schedulingLineTree", value = "车间产线列表")
   @JsonProperty("schedulingLineTree")
   @JSONField(name = "schedulingLineTree")
   private List<MesBuildingFactoryDTO> schedulingLineTree;

   MesBuildingAssembleSchedulingDTO(
      final Long workShopId,
      final String workShopName,
      final Long productId,
      final Long projectId,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final Long assembleConfigId,
      final String assembleConfigName,
      final Boolean boolProcess,
      final Boolean boolSectionSteel,
      final Integer typesettingAssembleTypeEnum,
      final Boolean boolOneCode,
      final Boolean boolMainAssemble,
      final Integer mesProductEnum,
      final LocalDateTime artifactAskCompleteTime,
      final List<MesBuildingFactoryDTO> schedulingLineTree
   ) {
      this.workShopId = workShopId;
      this.workShopName = workShopName;
      this.productId = productId;
      this.projectId = projectId;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.assembleConfigId = assembleConfigId;
      this.assembleConfigName = assembleConfigName;
      this.boolProcess = boolProcess;
      this.boolSectionSteel = boolSectionSteel;
      this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
      this.boolOneCode = boolOneCode;
      this.boolMainAssemble = boolMainAssemble;
      this.mesProductEnum = mesProductEnum;
      this.artifactAskCompleteTime = artifactAskCompleteTime;
      this.schedulingLineTree = schedulingLineTree;
   }

   public static MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder builder() {
      return new MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder();
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public String getAssembleConfigName() {
      return this.assembleConfigName;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Boolean getBoolSectionSteel() {
      return this.boolSectionSteel;
   }

   public Integer getTypesettingAssembleTypeEnum() {
      return this.typesettingAssembleTypeEnum;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public Boolean getBoolMainAssemble() {
      return this.boolMainAssemble;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public LocalDateTime getArtifactAskCompleteTime() {
      return this.artifactAskCompleteTime;
   }

   public List<MesBuildingFactoryDTO> getSchedulingLineTree() {
      return this.schedulingLineTree;
   }

   @JsonProperty("workShopId")
   public MesBuildingAssembleSchedulingDTO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("workShopName")
   public MesBuildingAssembleSchedulingDTO setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingAssembleSchedulingDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingAssembleSchedulingDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingAssembleSchedulingDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingAssembleSchedulingDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingAssembleSchedulingDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingAssembleSchedulingDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingAssembleSchedulingDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingAssembleSchedulingDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingAssembleSchedulingDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("assembleConfigId")
   public MesBuildingAssembleSchedulingDTO setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
      return this;
   }

   @JsonProperty("assembleConfigName")
   public MesBuildingAssembleSchedulingDTO setAssembleConfigName(final String assembleConfigName) {
      this.assembleConfigName = assembleConfigName;
      return this;
   }

   @JsonProperty("boolProcess")
   public MesBuildingAssembleSchedulingDTO setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   @JsonProperty("boolSectionSteel")
   public MesBuildingAssembleSchedulingDTO setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
      return this;
   }

   @JsonProperty("typesettingAssembleTypeEnum")
   public MesBuildingAssembleSchedulingDTO setTypesettingAssembleTypeEnum(final Integer typesettingAssembleTypeEnum) {
      this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
      return this;
   }

   @JsonProperty("boolOneCode")
   public MesBuildingAssembleSchedulingDTO setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   @JsonProperty("boolMainAssemble")
   public MesBuildingAssembleSchedulingDTO setBoolMainAssemble(final Boolean boolMainAssemble) {
      this.boolMainAssemble = boolMainAssemble;
      return this;
   }

   @JsonProperty("mesProductEnum")
   public MesBuildingAssembleSchedulingDTO setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @JsonProperty("artifactAskCompleteTime")
   public MesBuildingAssembleSchedulingDTO setArtifactAskCompleteTime(final LocalDateTime artifactAskCompleteTime) {
      this.artifactAskCompleteTime = artifactAskCompleteTime;
      return this;
   }

   @JsonProperty("schedulingLineTree")
   public MesBuildingAssembleSchedulingDTO setSchedulingLineTree(final List<MesBuildingFactoryDTO> schedulingLineTree) {
      this.schedulingLineTree = schedulingLineTree;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleSchedulingDTO(workShopId="
         + this.getWorkShopId()
         + ", workShopName="
         + this.getWorkShopName()
         + ", productId="
         + this.getProductId()
         + ", projectId="
         + this.getProjectId()
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
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", assembleConfigName="
         + this.getAssembleConfigName()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", typesettingAssembleTypeEnum="
         + this.getTypesettingAssembleTypeEnum()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", boolMainAssemble="
         + this.getBoolMainAssemble()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ", artifactAskCompleteTime="
         + this.getArtifactAskCompleteTime()
         + ", schedulingLineTree="
         + this.getSchedulingLineTree()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleSchedulingDTO)) {
         return false;
      }

      MesBuildingAssembleSchedulingDTO other = (MesBuildingAssembleSchedulingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workShopId = this.getWorkShopId();
      Object other$workShopId = other.getWorkShopId();
      if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$assembleConfigId = this.getAssembleConfigId();
                  Object other$assembleConfigId = other.getAssembleConfigId();
                  if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
                     Object this$boolProcess = this.getBoolProcess();
                     Object other$boolProcess = other.getBoolProcess();
                     if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                        Object this$boolSectionSteel = this.getBoolSectionSteel();
                        Object other$boolSectionSteel = other.getBoolSectionSteel();
                        if (this$boolSectionSteel == null ? other$boolSectionSteel == null : this$boolSectionSteel.equals(other$boolSectionSteel)) {
                           Object this$typesettingAssembleTypeEnum = this.getTypesettingAssembleTypeEnum();
                           Object other$typesettingAssembleTypeEnum = other.getTypesettingAssembleTypeEnum();
                           if (this$typesettingAssembleTypeEnum == null
                              ? other$typesettingAssembleTypeEnum == null
                              : this$typesettingAssembleTypeEnum.equals(other$typesettingAssembleTypeEnum)) {
                              Object this$boolOneCode = this.getBoolOneCode();
                              Object other$boolOneCode = other.getBoolOneCode();
                              if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                                 Object this$boolMainAssemble = this.getBoolMainAssemble();
                                 Object other$boolMainAssemble = other.getBoolMainAssemble();
                                 if (this$boolMainAssemble == null ? other$boolMainAssemble == null : this$boolMainAssemble.equals(other$boolMainAssemble)) {
                                    Object this$mesProductEnum = this.getMesProductEnum();
                                    Object other$mesProductEnum = other.getMesProductEnum();
                                    if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                                       Object this$workShopName = this.getWorkShopName();
                                       Object other$workShopName = other.getWorkShopName();
                                       if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
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
                                                            Object this$assembleConfigName = this.getAssembleConfigName();
                                                            Object other$assembleConfigName = other.getAssembleConfigName();
                                                            if (this$assembleConfigName == null
                                                               ? other$assembleConfigName == null
                                                               : this$assembleConfigName.equals(other$assembleConfigName)) {
                                                               Object this$artifactAskCompleteTime = this.getArtifactAskCompleteTime();
                                                               Object other$artifactAskCompleteTime = other.getArtifactAskCompleteTime();
                                                               if (this$artifactAskCompleteTime == null
                                                                  ? other$artifactAskCompleteTime == null
                                                                  : this$artifactAskCompleteTime.equals(other$artifactAskCompleteTime)) {
                                                                  Object this$schedulingLineTree = this.getSchedulingLineTree();
                                                                  Object other$schedulingLineTree = other.getSchedulingLineTree();
                                                                  return this$schedulingLineTree == null
                                                                     ? other$schedulingLineTree == null
                                                                     : this$schedulingLineTree.equals(other$schedulingLineTree);
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
      return other instanceof MesBuildingAssembleSchedulingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $typesettingAssembleTypeEnum = this.getTypesettingAssembleTypeEnum();
      result = result * 59 + ($typesettingAssembleTypeEnum == null ? 43 : $typesettingAssembleTypeEnum.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $boolMainAssemble = this.getBoolMainAssemble();
      result = result * 59 + ($boolMainAssemble == null ? 43 : $boolMainAssemble.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
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
      Object $assembleConfigName = this.getAssembleConfigName();
      result = result * 59 + ($assembleConfigName == null ? 43 : $assembleConfigName.hashCode());
      Object $artifactAskCompleteTime = this.getArtifactAskCompleteTime();
      result = result * 59 + ($artifactAskCompleteTime == null ? 43 : $artifactAskCompleteTime.hashCode());
      Object $schedulingLineTree = this.getSchedulingLineTree();
      return result * 59 + ($schedulingLineTree == null ? 43 : $schedulingLineTree.hashCode());
   }

   public static class MesBuildingAssembleSchedulingDTOBuilder {
      private Long workShopId;
      private String workShopName;
      private Long productId;
      private Long projectId;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private Long assembleConfigId;
      private String assembleConfigName;
      private Boolean boolProcess;
      private Boolean boolSectionSteel;
      private Integer typesettingAssembleTypeEnum;
      private Boolean boolOneCode;
      private Boolean boolMainAssemble;
      private Integer mesProductEnum;
      private LocalDateTime artifactAskCompleteTime;
      private List<MesBuildingFactoryDTO> schedulingLineTree;

      MesBuildingAssembleSchedulingDTOBuilder() {
      }

      @JsonProperty("workShopId")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      @JsonProperty("workShopName")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder workShopName(final String workShopName) {
         this.workShopName = workShopName;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("assembleConfigId")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      @JsonProperty("assembleConfigName")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder assembleConfigName(final String assembleConfigName) {
         this.assembleConfigName = assembleConfigName;
         return this;
      }

      @JsonProperty("boolProcess")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      @JsonProperty("boolSectionSteel")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      @JsonProperty("typesettingAssembleTypeEnum")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder typesettingAssembleTypeEnum(final Integer typesettingAssembleTypeEnum) {
         this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
         return this;
      }

      @JsonProperty("boolOneCode")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      @JsonProperty("boolMainAssemble")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder boolMainAssemble(final Boolean boolMainAssemble) {
         this.boolMainAssemble = boolMainAssemble;
         return this;
      }

      @JsonProperty("mesProductEnum")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      @JsonProperty("artifactAskCompleteTime")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder artifactAskCompleteTime(final LocalDateTime artifactAskCompleteTime) {
         this.artifactAskCompleteTime = artifactAskCompleteTime;
         return this;
      }

      @JsonProperty("schedulingLineTree")
      public MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder schedulingLineTree(final List<MesBuildingFactoryDTO> schedulingLineTree) {
         this.schedulingLineTree = schedulingLineTree;
         return this;
      }

      public MesBuildingAssembleSchedulingDTO build() {
         return new MesBuildingAssembleSchedulingDTO(
            this.workShopId,
            this.workShopName,
            this.productId,
            this.projectId,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.assembleConfigId,
            this.assembleConfigName,
            this.boolProcess,
            this.boolSectionSteel,
            this.typesettingAssembleTypeEnum,
            this.boolOneCode,
            this.boolMainAssemble,
            this.mesProductEnum,
            this.artifactAskCompleteTime,
            this.schedulingLineTree
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleSchedulingDTO.MesBuildingAssembleSchedulingDTOBuilder(workShopId="
            + this.workShopId
            + ", workShopName="
            + this.workShopName
            + ", productId="
            + this.productId
            + ", projectId="
            + this.projectId
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
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", assembleConfigName="
            + this.assembleConfigName
            + ", boolProcess="
            + this.boolProcess
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", typesettingAssembleTypeEnum="
            + this.typesettingAssembleTypeEnum
            + ", boolOneCode="
            + this.boolOneCode
            + ", boolMainAssemble="
            + this.boolMainAssemble
            + ", mesProductEnum="
            + this.mesProductEnum
            + ", artifactAskCompleteTime="
            + this.artifactAskCompleteTime
            + ", schedulingLineTree="
            + this.schedulingLineTree
            + ")";
      }
   }
}
