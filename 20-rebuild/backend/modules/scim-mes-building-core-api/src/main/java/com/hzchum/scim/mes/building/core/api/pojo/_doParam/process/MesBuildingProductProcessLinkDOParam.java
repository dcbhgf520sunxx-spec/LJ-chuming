package com.hzchum.scim.mes.building.core.api.pojo._doParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingProductProcessLinkDOParam对象", description = "")
public class MesBuildingProductProcessLinkDOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productProcessId", notes = "产品工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "sequence", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;

   public static MesBuildingProductProcessLinkDOParam.MesBuildingProductProcessLinkDOParamBuilder builder() {
      return new MesBuildingProductProcessLinkDOParam.MesBuildingProductProcessLinkDOParamBuilder();
   }

   public MesBuildingProductProcessLinkDOParam() {
   }

   public MesBuildingProductProcessLinkDOParam(final Long id, final Long productProcessId, final Long processId, final Integer sequence) {
      this.id = id;
      this.productProcessId = productProcessId;
      this.processId = processId;
      this.sequence = sequence;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   @JsonProperty("id")
   public MesBuildingProductProcessLinkDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesBuildingProductProcessLinkDOParam setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProductProcessLinkDOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingProductProcessLinkDOParam setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductProcessLinkDOParam(id="
         + this.getId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", processId="
         + this.getProcessId()
         + ", sequence="
         + this.getSequence()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductProcessLinkDOParam)) {
         return false;
      }

      MesBuildingProductProcessLinkDOParam other = (MesBuildingProductProcessLinkDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productProcessId = this.getProductProcessId();
         Object other$productProcessId = other.getProductProcessId();
         if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$sequence = this.getSequence();
               Object other$sequence = other.getSequence();
               return this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductProcessLinkDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $sequence = this.getSequence();
      return result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
   }

   public static class MesBuildingProductProcessLinkDOParamBuilder {
      private Long id;
      private Long productProcessId;
      private Long processId;
      private Integer sequence;

      MesBuildingProductProcessLinkDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductProcessLinkDOParam.MesBuildingProductProcessLinkDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesBuildingProductProcessLinkDOParam.MesBuildingProductProcessLinkDOParamBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProductProcessLinkDOParam.MesBuildingProductProcessLinkDOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingProductProcessLinkDOParam.MesBuildingProductProcessLinkDOParamBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      public MesBuildingProductProcessLinkDOParam build() {
         return new MesBuildingProductProcessLinkDOParam(this.id, this.productProcessId, this.processId, this.sequence);
      }

      @Override
      public String toString() {
         return "MesBuildingProductProcessLinkDOParam.MesBuildingProductProcessLinkDOParamBuilder(id="
            + this.id
            + ", productProcessId="
            + this.productProcessId
            + ", processId="
            + this.processId
            + ", sequence="
            + this.sequence
            + ")";
      }
   }
}
