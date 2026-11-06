package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "技术成果-创建审批流时缓存数据子对象", description = "技术成果-创建审批流时缓存数据子对象 ")
public class PlanApproveCacheObjectDTOParam {
   @ApiModelProperty(name = "createUserId", value = "上传人id")
   private Long createUserId;
   @ApiModelProperty("是否是覆盖文件导入（1，图纸，数控，XML。2，变更，施工蓝图）")
   private Integer cover;
   @ApiModelProperty("是否是匹配文件导入")
   private Boolean normal;
   @ApiModelProperty("变更，施工蓝图文件替换接口传入的id")
   private Long dataId;
   @ApiModelProperty("产品id")
   private Long productId;

   public static PlanApproveCacheObjectDTOParam.PlanApproveCacheObjectDTOParamBuilder builder() {
      return new PlanApproveCacheObjectDTOParam.PlanApproveCacheObjectDTOParamBuilder();
   }

   public PlanApproveCacheObjectDTOParam() {
   }

   public PlanApproveCacheObjectDTOParam(final Long createUserId, final Integer cover, final Boolean normal, final Long dataId, final Long productId) {
      this.createUserId = createUserId;
      this.cover = cover;
      this.normal = normal;
      this.dataId = dataId;
      this.productId = productId;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Integer getCover() {
      return this.cover;
   }

   public Boolean getNormal() {
      return this.normal;
   }

   public Long getDataId() {
      return this.dataId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCover(final Integer cover) {
      this.cover = cover;
   }

   public void setNormal(final Boolean normal) {
      this.normal = normal;
   }

   public void setDataId(final Long dataId) {
      this.dataId = dataId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanApproveCacheObjectDTOParam)) {
         return false;
      }

      PlanApproveCacheObjectDTOParam other = (PlanApproveCacheObjectDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createUserId = this.getCreateUserId();
      Object other$createUserId = other.getCreateUserId();
      if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
         Object this$cover = this.getCover();
         Object other$cover = other.getCover();
         if (this$cover == null ? other$cover == null : this$cover.equals(other$cover)) {
            Object this$normal = this.getNormal();
            Object other$normal = other.getNormal();
            if (this$normal == null ? other$normal == null : this$normal.equals(other$normal)) {
               Object this$dataId = this.getDataId();
               Object other$dataId = other.getDataId();
               if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  return this$productId == null ? other$productId == null : this$productId.equals(other$productId);
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
      return other instanceof PlanApproveCacheObjectDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $cover = this.getCover();
      result = result * 59 + ($cover == null ? 43 : $cover.hashCode());
      Object $normal = this.getNormal();
      result = result * 59 + ($normal == null ? 43 : $normal.hashCode());
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $productId = this.getProductId();
      return result * 59 + ($productId == null ? 43 : $productId.hashCode());
   }

   @Override
   public String toString() {
      return "PlanApproveCacheObjectDTOParam(createUserId="
         + this.getCreateUserId()
         + ", cover="
         + this.getCover()
         + ", normal="
         + this.getNormal()
         + ", dataId="
         + this.getDataId()
         + ", productId="
         + this.getProductId()
         + ")";
   }

   public static class PlanApproveCacheObjectDTOParamBuilder {
      private Long createUserId;
      private Integer cover;
      private Boolean normal;
      private Long dataId;
      private Long productId;

      PlanApproveCacheObjectDTOParamBuilder() {
      }

      public PlanApproveCacheObjectDTOParam.PlanApproveCacheObjectDTOParamBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public PlanApproveCacheObjectDTOParam.PlanApproveCacheObjectDTOParamBuilder cover(final Integer cover) {
         this.cover = cover;
         return this;
      }

      public PlanApproveCacheObjectDTOParam.PlanApproveCacheObjectDTOParamBuilder normal(final Boolean normal) {
         this.normal = normal;
         return this;
      }

      public PlanApproveCacheObjectDTOParam.PlanApproveCacheObjectDTOParamBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      public PlanApproveCacheObjectDTOParam.PlanApproveCacheObjectDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public PlanApproveCacheObjectDTOParam build() {
         return new PlanApproveCacheObjectDTOParam(this.createUserId, this.cover, this.normal, this.dataId, this.productId);
      }

      @Override
      public String toString() {
         return "PlanApproveCacheObjectDTOParam.PlanApproveCacheObjectDTOParamBuilder(createUserId="
            + this.createUserId
            + ", cover="
            + this.cover
            + ", normal="
            + this.normal
            + ", dataId="
            + this.dataId
            + ", productId="
            + this.productId
            + ")";
      }
   }
}
