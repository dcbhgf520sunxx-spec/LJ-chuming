package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureProductProcessLinkDOParam对象", description = "")
public class MesEnclosureProductProcessLinkDOParam extends BaseEntity<Long> {
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

   public static MesEnclosureProductProcessLinkDOParam.MesEnclosureProductProcessLinkDOParamBuilder builder() {
      return new MesEnclosureProductProcessLinkDOParam.MesEnclosureProductProcessLinkDOParamBuilder();
   }

   public MesEnclosureProductProcessLinkDOParam() {
   }

   public MesEnclosureProductProcessLinkDOParam(final Long id, final Long productProcessId, final Long processId, final Integer sequence) {
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
   public MesEnclosureProductProcessLinkDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesEnclosureProductProcessLinkDOParam setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureProductProcessLinkDOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("sequence")
   public MesEnclosureProductProcessLinkDOParam setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductProcessLinkDOParam(id="
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

      if (!(o instanceof MesEnclosureProductProcessLinkDOParam)) {
         return false;
      }

      MesEnclosureProductProcessLinkDOParam other = (MesEnclosureProductProcessLinkDOParam)o;
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
      return other instanceof MesEnclosureProductProcessLinkDOParam;
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

   public static class MesEnclosureProductProcessLinkDOParamBuilder {
      private Long id;
      private Long productProcessId;
      private Long processId;
      private Integer sequence;

      MesEnclosureProductProcessLinkDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProductProcessLinkDOParam.MesEnclosureProductProcessLinkDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesEnclosureProductProcessLinkDOParam.MesEnclosureProductProcessLinkDOParamBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureProductProcessLinkDOParam.MesEnclosureProductProcessLinkDOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("sequence")
      public MesEnclosureProductProcessLinkDOParam.MesEnclosureProductProcessLinkDOParamBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      public MesEnclosureProductProcessLinkDOParam build() {
         return new MesEnclosureProductProcessLinkDOParam(this.id, this.productProcessId, this.processId, this.sequence);
      }

      @Override
      public String toString() {
         return "MesEnclosureProductProcessLinkDOParam.MesEnclosureProductProcessLinkDOParamBuilder(id="
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
