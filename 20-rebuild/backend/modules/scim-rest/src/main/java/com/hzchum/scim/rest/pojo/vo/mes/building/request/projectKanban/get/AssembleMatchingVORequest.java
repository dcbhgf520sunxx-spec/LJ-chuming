package com.hzchum.scim.rest.pojo.vo.mes.building.request.projectKanban.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ElementMatchingVORequest", description = "产品看板请求类")
public class AssembleMatchingVORequest {
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
   @ApiModelProperty(name = "areaBatchId", notes = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   private Long areaBatchId;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
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
   @ApiModelProperty(name = "structureClassId", notes = "构件种类Id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   private Long structureClassId;
   @ApiModelProperty(name = "status", notes = "齐套状态:1不齐套 2部分齐套  4完全齐套")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;

   public static AssembleMatchingVORequest.AssembleMatchingVORequestBuilder builder() {
      return new AssembleMatchingVORequest.AssembleMatchingVORequestBuilder();
   }

   public AssembleMatchingVORequest() {
   }

   public AssembleMatchingVORequest(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Long structureClassId,
      final Integer status
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.structureClassId = structureClassId;
      this.status = status;
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

   public Long getAreaBatchId() {
      return this.areaBatchId;
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

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("projectId")
   public AssembleMatchingVORequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public AssembleMatchingVORequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public AssembleMatchingVORequest setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public AssembleMatchingVORequest setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("name")
   public AssembleMatchingVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public AssembleMatchingVORequest setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public AssembleMatchingVORequest setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public AssembleMatchingVORequest setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("structureClassId")
   public AssembleMatchingVORequest setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   @JsonProperty("status")
   public AssembleMatchingVORequest setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "AssembleMatchingVORequest(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleMatchingVORequest)) {
         return false;
      }

      AssembleMatchingVORequest other = (AssembleMatchingVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$areaBatchId = this.getAreaBatchId();
               Object other$areaBatchId = other.getAreaBatchId();
               if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                  Object this$structureClassId = this.getStructureClassId();
                  Object other$structureClassId = other.getStructureClassId();
                  if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
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
                                 return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof AssembleMatchingVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   public static class AssembleMatchingVORequestBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Long structureClassId;
      private Integer status;

      AssembleMatchingVORequestBuilder() {
      }

      @JsonProperty("projectId")
      public AssembleMatchingVORequest.AssembleMatchingVORequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public AssembleMatchingVORequest.AssembleMatchingVORequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public AssembleMatchingVORequest.AssembleMatchingVORequestBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public AssembleMatchingVORequest.AssembleMatchingVORequestBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("name")
      public AssembleMatchingVORequest.AssembleMatchingVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public AssembleMatchingVORequest.AssembleMatchingVORequestBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public AssembleMatchingVORequest.AssembleMatchingVORequestBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public AssembleMatchingVORequest.AssembleMatchingVORequestBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("structureClassId")
      public AssembleMatchingVORequest.AssembleMatchingVORequestBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      @JsonProperty("status")
      public AssembleMatchingVORequest.AssembleMatchingVORequestBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public AssembleMatchingVORequest build() {
         return new AssembleMatchingVORequest(
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.structureClassId,
            this.status
         );
      }

      @Override
      public String toString() {
         return "AssembleMatchingVORequest.AssembleMatchingVORequestBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", structureClassId="
            + this.structureClassId
            + ", status="
            + this.status
            + ")";
      }
   }
}
