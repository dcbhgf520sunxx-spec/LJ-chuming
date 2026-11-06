package com.hzchum.scim.mes.building.core.api.pojo._dto.typesetting;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProcessSummaryDetailsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;

@ApiModel(value = "AssembleTypeSettingDTO", description = "母件信息 ")
public class AssembleTypeSettingDTO {
   @ApiModelProperty(name = "母件id", notes = "母件id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "母件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '母件编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(64)  COMMENT '材质'", nullable = false)
   private String material;
   @ApiModelProperty(name = "length", value = "母材长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '母材长度'", nullable = false)
   private BigDecimal length;
   @ApiModelProperty(name = "netWeight", notes = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "部件", notes = "部件")
   private List<AssembleLinkDTO> assembleLinkDTOS;
   @ApiModelProperty(name = "processSummaryDetailsList", notes = "工序汇总")
   @JsonProperty("processSummaryDetailsList")
   @JSONField(name = "processSummaryDetailsList")
   private List<ProcessSummaryDetailsDTO> processSummaryDetailsList;

   public static AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder builder() {
      return new AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder();
   }

   public AssembleTypeSettingDTO() {
   }

   public AssembleTypeSettingDTO(
      final Long id,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal length,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Integer quantity,
      final ProjectDetailDO project,
      final List<AssembleLinkDTO> assembleLinkDTOS,
      final List<ProcessSummaryDetailsDTO> processSummaryDetailsList
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.quantity = quantity;
      this.project = project;
      this.assembleLinkDTOS = assembleLinkDTOS;
      this.processSummaryDetailsList = processSummaryDetailsList;
   }

   public Long getId() {
      return this.id;
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

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public List<AssembleLinkDTO> getAssembleLinkDTOS() {
      return this.assembleLinkDTOS;
   }

   public List<ProcessSummaryDetailsDTO> getProcessSummaryDetailsList() {
      return this.processSummaryDetailsList;
   }

   @JsonProperty("id")
   public AssembleTypeSettingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public AssembleTypeSettingDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public AssembleTypeSettingDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public AssembleTypeSettingDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("length")
   public AssembleTypeSettingDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("netWeight")
   public AssembleTypeSettingDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public AssembleTypeSettingDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("quantity")
   public AssembleTypeSettingDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("project")
   public AssembleTypeSettingDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   public AssembleTypeSettingDTO setAssembleLinkDTOS(final List<AssembleLinkDTO> assembleLinkDTOS) {
      this.assembleLinkDTOS = assembleLinkDTOS;
      return this;
   }

   @JsonProperty("processSummaryDetailsList")
   public AssembleTypeSettingDTO setProcessSummaryDetailsList(final List<ProcessSummaryDetailsDTO> processSummaryDetailsList) {
      this.processSummaryDetailsList = processSummaryDetailsList;
      return this;
   }

   @Override
   public String toString() {
      return "AssembleTypeSettingDTO(id="
         + this.getId()
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
         + ", project="
         + this.getProject()
         + ", assembleLinkDTOS="
         + this.getAssembleLinkDTOS()
         + ", processSummaryDetailsList="
         + this.getProcessSummaryDetailsList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleTypeSettingDTO)) {
         return false;
      }

      AssembleTypeSettingDTO other = (AssembleTypeSettingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
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
                           if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$assembleLinkDTOS = this.getAssembleLinkDTOS();
                                 Object other$assembleLinkDTOS = other.getAssembleLinkDTOS();
                                 if (this$assembleLinkDTOS == null ? other$assembleLinkDTOS == null : this$assembleLinkDTOS.equals(other$assembleLinkDTOS)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleTypeSettingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
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
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $assembleLinkDTOS = this.getAssembleLinkDTOS();
      result = result * 59 + ($assembleLinkDTOS == null ? 43 : $assembleLinkDTOS.hashCode());
      Object $processSummaryDetailsList = this.getProcessSummaryDetailsList();
      return result * 59 + ($processSummaryDetailsList == null ? 43 : $processSummaryDetailsList.hashCode());
   }

   public static class AssembleTypeSettingDTOBuilder {
      private Long id;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal length;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Integer quantity;
      private ProjectDetailDO project;
      private List<AssembleLinkDTO> assembleLinkDTOS;
      private List<ProcessSummaryDetailsDTO> processSummaryDetailsList;

      AssembleTypeSettingDTOBuilder() {
      }

      @JsonProperty("id")
      public AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("length")
      public AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("netWeight")
      public AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("quantity")
      public AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("project")
      public AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      public AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder assembleLinkDTOS(final List<AssembleLinkDTO> assembleLinkDTOS) {
         this.assembleLinkDTOS = assembleLinkDTOS;
         return this;
      }

      @JsonProperty("processSummaryDetailsList")
      public AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder processSummaryDetailsList(final List<ProcessSummaryDetailsDTO> processSummaryDetailsList) {
         this.processSummaryDetailsList = processSummaryDetailsList;
         return this;
      }

      public AssembleTypeSettingDTO build() {
         return new AssembleTypeSettingDTO(
            this.id,
            this.serialNumber,
            this.specification,
            this.material,
            this.length,
            this.netWeight,
            this.grossWeight,
            this.quantity,
            this.project,
            this.assembleLinkDTOS,
            this.processSummaryDetailsList
         );
      }

      @Override
      public String toString() {
         return "AssembleTypeSettingDTO.AssembleTypeSettingDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", quantity="
            + this.quantity
            + ", project="
            + this.project
            + ", assembleLinkDTOS="
            + this.assembleLinkDTOS
            + ", processSummaryDetailsList="
            + this.processSummaryDetailsList
            + ")";
      }
   }
}
