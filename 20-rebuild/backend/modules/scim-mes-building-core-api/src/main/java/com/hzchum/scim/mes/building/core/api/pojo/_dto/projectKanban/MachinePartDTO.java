package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MachinePartDTO", description = "构件工序详情")
public class MachinePartDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "netWeight", notes = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "producedQuantity", notes = "已生产")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "usedQuantity", notes = "已使用")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   private Integer usedQuantity;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "processSummaryDetailsList", notes = "工序汇总")
   @JsonProperty("processSummaryDetailsList")
   @JSONField(name = "processSummaryDetailsList")
   private List<ProcessSummaryDetailsDTO> processSummaryDetailsList;
   @ApiModelProperty(name = "useComplete", notes = "利用完成数")
   @JsonProperty("useComplete")
   @JSONField(name = "useComplete")
   private Integer useComplete;

   public static MachinePartDTO.MachinePartDTOBuilder builder() {
      return new MachinePartDTO.MachinePartDTOBuilder();
   }

   public MachinePartDTO() {
   }

   public MachinePartDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Integer quantity,
      final Integer producedQuantity,
      final Integer usedQuantity,
      final String remark,
      final List<ProcessSummaryDetailsDTO> processSummaryDetailsList,
      final Integer useComplete
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.quantity = quantity;
      this.producedQuantity = producedQuantity;
      this.usedQuantity = usedQuantity;
      this.remark = remark;
      this.processSummaryDetailsList = processSummaryDetailsList;
      this.useComplete = useComplete;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<ProcessSummaryDetailsDTO> getProcessSummaryDetailsList() {
      return this.processSummaryDetailsList;
   }

   public Integer getUseComplete() {
      return this.useComplete;
   }

   @JsonProperty("id")
   public MachinePartDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MachinePartDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MachinePartDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MachinePartDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MachinePartDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MachinePartDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MachinePartDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public MachinePartDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("netWeight")
   public MachinePartDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MachinePartDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("quantity")
   public MachinePartDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public MachinePartDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("usedQuantity")
   public MachinePartDTO setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("remark")
   public MachinePartDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("processSummaryDetailsList")
   public MachinePartDTO setProcessSummaryDetailsList(final List<ProcessSummaryDetailsDTO> processSummaryDetailsList) {
      this.processSummaryDetailsList = processSummaryDetailsList;
      return this;
   }

   @JsonProperty("useComplete")
   public MachinePartDTO setUseComplete(final Integer useComplete) {
      this.useComplete = useComplete;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", quantity="
         + this.getQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", remark="
         + this.getRemark()
         + ", processSummaryDetailsList="
         + this.getProcessSummaryDetailsList()
         + ", useComplete="
         + this.getUseComplete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartDTO)) {
         return false;
      }

      MachinePartDTO other = (MachinePartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$producedQuantity = this.getProducedQuantity();
                     Object other$producedQuantity = other.getProducedQuantity();
                     if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                        Object this$usedQuantity = this.getUsedQuantity();
                        Object other$usedQuantity = other.getUsedQuantity();
                        if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                           Object this$useComplete = this.getUseComplete();
                           Object other$useComplete = other.getUseComplete();
                           if (this$useComplete == null ? other$useComplete == null : this$useComplete.equals(other$useComplete)) {
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
                                             Object this$grossWeight = this.getGrossWeight();
                                             Object other$grossWeight = other.getGrossWeight();
                                             if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                Object this$remark = this.getRemark();
                                                Object other$remark = other.getRemark();
                                                if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                   Object this$processSummaryDetailsList = this.getProcessSummaryDetailsList();
                                                   Object other$processSummaryDetailsList = other.getProcessSummaryDetailsList();
                                                   return this$processSummaryDetailsList == null
                                                      ? other$processSummaryDetailsList == null
                                                      : this$processSummaryDetailsList.equals(other$processSummaryDetailsList);
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
      return other instanceof MachinePartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $useComplete = this.getUseComplete();
      result = result * 59 + ($useComplete == null ? 43 : $useComplete.hashCode());
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
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $processSummaryDetailsList = this.getProcessSummaryDetailsList();
      return result * 59 + ($processSummaryDetailsList == null ? 43 : $processSummaryDetailsList.hashCode());
   }

   public static class MachinePartDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Integer quantity;
      private Integer producedQuantity;
      private Integer usedQuantity;
      private String remark;
      private List<ProcessSummaryDetailsDTO> processSummaryDetailsList;
      private Integer useComplete;

      MachinePartDTOBuilder() {
      }

      @JsonProperty("id")
      public MachinePartDTO.MachinePartDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MachinePartDTO.MachinePartDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MachinePartDTO.MachinePartDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MachinePartDTO.MachinePartDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MachinePartDTO.MachinePartDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MachinePartDTO.MachinePartDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MachinePartDTO.MachinePartDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public MachinePartDTO.MachinePartDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("netWeight")
      public MachinePartDTO.MachinePartDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MachinePartDTO.MachinePartDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("quantity")
      public MachinePartDTO.MachinePartDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public MachinePartDTO.MachinePartDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("usedQuantity")
      public MachinePartDTO.MachinePartDTOBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("remark")
      public MachinePartDTO.MachinePartDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("processSummaryDetailsList")
      public MachinePartDTO.MachinePartDTOBuilder processSummaryDetailsList(final List<ProcessSummaryDetailsDTO> processSummaryDetailsList) {
         this.processSummaryDetailsList = processSummaryDetailsList;
         return this;
      }

      @JsonProperty("useComplete")
      public MachinePartDTO.MachinePartDTOBuilder useComplete(final Integer useComplete) {
         this.useComplete = useComplete;
         return this;
      }

      public MachinePartDTO build() {
         return new MachinePartDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.netWeight,
            this.grossWeight,
            this.quantity,
            this.producedQuantity,
            this.usedQuantity,
            this.remark,
            this.processSummaryDetailsList,
            this.useComplete
         );
      }

      @Override
      public String toString() {
         return "MachinePartDTO.MachinePartDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", quantity="
            + this.quantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", usedQuantity="
            + this.usedQuantity
            + ", remark="
            + this.remark
            + ", processSummaryDetailsList="
            + this.processSummaryDetailsList
            + ", useComplete="
            + this.useComplete
            + ")";
      }
   }
}
