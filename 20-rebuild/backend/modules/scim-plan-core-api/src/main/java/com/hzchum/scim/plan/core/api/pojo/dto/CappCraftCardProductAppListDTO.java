package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP  app产品列表查询 请求参数")
public class CappCraftCardProductAppListDTO {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   private String productSerialNumber;
   @ApiModelProperty(
      name = "techCappProductTaskWorkType",
      value = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum",
      notes = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum"
   )
   private Integer techCappProductTaskWorkType;
   @ApiModelProperty(name = "pageNumber", value = "页码", notes = "页码")
   private Integer pageNumber;
   @ApiModelProperty(name = "pageSize", value = "每页数量", notes = "每页数量")
   private Integer pageSize;

   CappCraftCardProductAppListDTO(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String productSerialNumber,
      final Integer techCappProductTaskWorkType,
      final Integer pageNumber,
      final Integer pageSize
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productSerialNumber = productSerialNumber;
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
   }

   public static CappCraftCardProductAppListDTO.CappCraftCardProductAppListDTOBuilder builder() {
      return new CappCraftCardProductAppListDTO.CappCraftCardProductAppListDTOBuilder();
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

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Integer getTechCappProductTaskWorkType() {
      return this.techCappProductTaskWorkType;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setTechCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductAppListDTO)) {
         return false;
      }

      CappCraftCardProductAppListDTO other = (CappCraftCardProductAppListDTO)o;
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
               Object this$techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
               Object other$techCappProductTaskWorkType = other.getTechCappProductTaskWorkType();
               if (this$techCappProductTaskWorkType == null
                  ? other$techCappProductTaskWorkType == null
                  : this$techCappProductTaskWorkType.equals(other$techCappProductTaskWorkType)) {
                  Object this$pageNumber = this.getPageNumber();
                  Object other$pageNumber = other.getPageNumber();
                  if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                     Object this$pageSize = this.getPageSize();
                     Object other$pageSize = other.getPageSize();
                     if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                        Object this$productSerialNumber = this.getProductSerialNumber();
                        Object other$productSerialNumber = other.getProductSerialNumber();
                        return this$productSerialNumber == null
                           ? other$productSerialNumber == null
                           : this$productSerialNumber.equals(other$productSerialNumber);
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
      return other instanceof CappCraftCardProductAppListDTO;
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
      Object $techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
      result = result * 59 + ($techCappProductTaskWorkType == null ? 43 : $techCappProductTaskWorkType.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      return result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductAppListDTO(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", techCappProductTaskWorkType="
         + this.getTechCappProductTaskWorkType()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ")";
   }

   public static class CappCraftCardProductAppListDTOBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String productSerialNumber;
      private Integer techCappProductTaskWorkType;
      private Integer pageNumber;
      private Integer pageSize;

      CappCraftCardProductAppListDTOBuilder() {
      }

      public CappCraftCardProductAppListDTO.CappCraftCardProductAppListDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public CappCraftCardProductAppListDTO.CappCraftCardProductAppListDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public CappCraftCardProductAppListDTO.CappCraftCardProductAppListDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public CappCraftCardProductAppListDTO.CappCraftCardProductAppListDTOBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public CappCraftCardProductAppListDTO.CappCraftCardProductAppListDTOBuilder techCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
         this.techCappProductTaskWorkType = techCappProductTaskWorkType;
         return this;
      }

      public CappCraftCardProductAppListDTO.CappCraftCardProductAppListDTOBuilder pageNumber(final Integer pageNumber) {
         this.pageNumber = pageNumber;
         return this;
      }

      public CappCraftCardProductAppListDTO.CappCraftCardProductAppListDTOBuilder pageSize(final Integer pageSize) {
         this.pageSize = pageSize;
         return this;
      }

      public CappCraftCardProductAppListDTO build() {
         return new CappCraftCardProductAppListDTO(
            this.projectId, this.monomerId, this.areaId, this.productSerialNumber, this.techCappProductTaskWorkType, this.pageNumber, this.pageSize
         );
      }

      @Override
      public String toString() {
         return "CappCraftCardProductAppListDTO.CappCraftCardProductAppListDTOBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", techCappProductTaskWorkType="
            + this.techCappProductTaskWorkType
            + ", pageNumber="
            + this.pageNumber
            + ", pageSize="
            + this.pageSize
            + ")";
      }
   }
}
