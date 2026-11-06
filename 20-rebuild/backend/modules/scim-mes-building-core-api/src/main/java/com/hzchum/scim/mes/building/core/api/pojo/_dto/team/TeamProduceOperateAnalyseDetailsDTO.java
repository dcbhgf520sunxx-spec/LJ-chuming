package com.hzchum.scim.mes.building.core.api.pojo._dto.team;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "运营分析班组产量详情", description = "运营分析班组产量详情")
public class TeamProduceOperateAnalyseDetailsDTO {
   @ApiModelProperty(name = "projectInfo", value = "项目")
   @JsonProperty("projectInfo")
   @JSONField(name = "projectInfo")
   private ProjectInfo projectInfo;
   @ApiModelProperty(name = "name", value = "姓名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
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
   @ApiModelProperty(name = "序号", value = "序号(下载使用)")
   @JsonProperty("index")
   @JSONField(name = "index")
   @JsonInclude(Include.NON_NULL)
   private Long index;
   @ApiModelProperty(name = "projectSimpleInfo", value = "项目编号家简称")
   @JsonProperty("projectSimpleInfo")
   @JSONField(name = "projectSimpleInfo")
   @JsonInclude(Include.NON_NULL)
   private String projectSimpleInfo;

   public static TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder builder() {
      return new TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder();
   }

   public TeamProduceOperateAnalyseDetailsDTO() {
   }

   public TeamProduceOperateAnalyseDetailsDTO(
      final ProjectInfo projectInfo,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final Long index,
      final String projectSimpleInfo
   ) {
      this.projectInfo = projectInfo;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.index = index;
      this.projectSimpleInfo = projectSimpleInfo;
   }

   public ProjectInfo getProjectInfo() {
      return this.projectInfo;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Long getIndex() {
      return this.index;
   }

   public String getProjectSimpleInfo() {
      return this.projectSimpleInfo;
   }

   @JsonProperty("projectInfo")
   public TeamProduceOperateAnalyseDetailsDTO setProjectInfo(final ProjectInfo projectInfo) {
      this.projectInfo = projectInfo;
      return this;
   }

   @JsonProperty("name")
   public TeamProduceOperateAnalyseDetailsDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public TeamProduceOperateAnalyseDetailsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TeamProduceOperateAnalyseDetailsDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public TeamProduceOperateAnalyseDetailsDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public TeamProduceOperateAnalyseDetailsDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public TeamProduceOperateAnalyseDetailsDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TeamProduceOperateAnalyseDetailsDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("index")
   public TeamProduceOperateAnalyseDetailsDTO setIndex(final Long index) {
      this.index = index;
      return this;
   }

   @JsonProperty("projectSimpleInfo")
   public TeamProduceOperateAnalyseDetailsDTO setProjectSimpleInfo(final String projectSimpleInfo) {
      this.projectSimpleInfo = projectSimpleInfo;
      return this;
   }

   @Override
   public String toString() {
      return "TeamProduceOperateAnalyseDetailsDTO(projectInfo="
         + this.getProjectInfo()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", index="
         + this.getIndex()
         + ", projectSimpleInfo="
         + this.getProjectSimpleInfo()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamProduceOperateAnalyseDetailsDTO)) {
         return false;
      }

      TeamProduceOperateAnalyseDetailsDTO other = (TeamProduceOperateAnalyseDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$index = this.getIndex();
         Object other$index = other.getIndex();
         if (this$index == null ? other$index == null : this$index.equals(other$index)) {
            Object this$projectInfo = this.getProjectInfo();
            Object other$projectInfo = other.getProjectInfo();
            if (this$projectInfo == null ? other$projectInfo == null : this$projectInfo.equals(other$projectInfo)) {
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
                           Object this$netWeight = this.getNetWeight();
                           Object other$netWeight = other.getNetWeight();
                           if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                              Object this$totalNetWeight = this.getTotalNetWeight();
                              Object other$totalNetWeight = other.getTotalNetWeight();
                              if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                 Object this$projectSimpleInfo = this.getProjectSimpleInfo();
                                 Object other$projectSimpleInfo = other.getProjectSimpleInfo();
                                 return this$projectSimpleInfo == null
                                    ? other$projectSimpleInfo == null
                                    : this$projectSimpleInfo.equals(other$projectSimpleInfo);
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
      return other instanceof TeamProduceOperateAnalyseDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $projectInfo = this.getProjectInfo();
      result = result * 59 + ($projectInfo == null ? 43 : $projectInfo.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $projectSimpleInfo = this.getProjectSimpleInfo();
      return result * 59 + ($projectSimpleInfo == null ? 43 : $projectSimpleInfo.hashCode());
   }

   public static class TeamProduceOperateAnalyseDetailsDTOBuilder {
      private ProjectInfo projectInfo;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private Long index;
      private String projectSimpleInfo;

      TeamProduceOperateAnalyseDetailsDTOBuilder() {
      }

      @JsonProperty("projectInfo")
      public TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder projectInfo(final ProjectInfo projectInfo) {
         this.projectInfo = projectInfo;
         return this;
      }

      @JsonProperty("name")
      public TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("index")
      public TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder index(final Long index) {
         this.index = index;
         return this;
      }

      @JsonProperty("projectSimpleInfo")
      public TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder projectSimpleInfo(final String projectSimpleInfo) {
         this.projectSimpleInfo = projectSimpleInfo;
         return this;
      }

      public TeamProduceOperateAnalyseDetailsDTO build() {
         return new TeamProduceOperateAnalyseDetailsDTO(
            this.projectInfo,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.index,
            this.projectSimpleInfo
         );
      }

      @Override
      public String toString() {
         return "TeamProduceOperateAnalyseDetailsDTO.TeamProduceOperateAnalyseDetailsDTOBuilder(projectInfo="
            + this.projectInfo
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", index="
            + this.index
            + ", projectSimpleInfo="
            + this.projectSimpleInfo
            + ")";
      }
   }
}
