package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureProductProcessLinkDOParam对象", description = "")
public class MesEnclosureProductProcessLinkDTOParam {
   @ApiModelProperty(name = "id", notes = "工序id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "sequence", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;
   @ApiModelProperty(name = "nodeTime", value = "时间节点", notes = "时间节点")
   @JsonProperty("nodeTime")
   @JSONField(name = "nodeTime")
   private Integer nodeTime;

   public static MesEnclosureProductProcessLinkDTOParam.MesEnclosureProductProcessLinkDTOParamBuilder builder() {
      return new MesEnclosureProductProcessLinkDTOParam.MesEnclosureProductProcessLinkDTOParamBuilder();
   }

   public MesEnclosureProductProcessLinkDTOParam() {
   }

   public MesEnclosureProductProcessLinkDTOParam(final Long id, final Integer sequence, final Integer nodeTime) {
      this.id = id;
      this.sequence = sequence;
      this.nodeTime = nodeTime;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public Integer getNodeTime() {
      return this.nodeTime;
   }

   @JsonProperty("id")
   public MesEnclosureProductProcessLinkDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("sequence")
   public MesEnclosureProductProcessLinkDTOParam setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("nodeTime")
   public MesEnclosureProductProcessLinkDTOParam setNodeTime(final Integer nodeTime) {
      this.nodeTime = nodeTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductProcessLinkDTOParam(id=" + this.getId() + ", sequence=" + this.getSequence() + ", nodeTime=" + this.getNodeTime() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductProcessLinkDTOParam)) {
         return false;
      }

      MesEnclosureProductProcessLinkDTOParam other = (MesEnclosureProductProcessLinkDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sequence = this.getSequence();
         Object other$sequence = other.getSequence();
         if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
            Object this$nodeTime = this.getNodeTime();
            Object other$nodeTime = other.getNodeTime();
            return this$nodeTime == null ? other$nodeTime == null : this$nodeTime.equals(other$nodeTime);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProductProcessLinkDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $nodeTime = this.getNodeTime();
      return result * 59 + ($nodeTime == null ? 43 : $nodeTime.hashCode());
   }

   public static class MesEnclosureProductProcessLinkDTOParamBuilder {
      private Long id;
      private Integer sequence;
      private Integer nodeTime;

      MesEnclosureProductProcessLinkDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProductProcessLinkDTOParam.MesEnclosureProductProcessLinkDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("sequence")
      public MesEnclosureProductProcessLinkDTOParam.MesEnclosureProductProcessLinkDTOParamBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("nodeTime")
      public MesEnclosureProductProcessLinkDTOParam.MesEnclosureProductProcessLinkDTOParamBuilder nodeTime(final Integer nodeTime) {
         this.nodeTime = nodeTime;
         return this;
      }

      public MesEnclosureProductProcessLinkDTOParam build() {
         return new MesEnclosureProductProcessLinkDTOParam(this.id, this.sequence, this.nodeTime);
      }

      @Override
      public String toString() {
         return "MesEnclosureProductProcessLinkDTOParam.MesEnclosureProductProcessLinkDTOParamBuilder(id="
            + this.id
            + ", sequence="
            + this.sequence
            + ", nodeTime="
            + this.nodeTime
            + ")";
      }
   }
}
