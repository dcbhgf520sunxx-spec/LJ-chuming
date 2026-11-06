package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureProductProcessLinkDOParam对象", description = "")
public class MesEnclosureProductProcessLinkDTO extends BaseEntity<Long> {
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
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "sequence", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   @NotNull(message = "工序顺序不能为空")
   private Integer sequence;
   @ApiModelProperty(name = "name", notes = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "nodeTime", notes = "时间节点")
   @JsonProperty("nodeTime")
   @JSONField(name = "nodeTime")
   private Integer nodeTime;

   public static MesEnclosureProductProcessLinkDTO.MesEnclosureProductProcessLinkDTOBuilder builder() {
      return new MesEnclosureProductProcessLinkDTO.MesEnclosureProductProcessLinkDTOBuilder();
   }

   public MesEnclosureProductProcessLinkDTO() {
   }

   public MesEnclosureProductProcessLinkDTO(
      final Long id, final Long productProcessId, final Long processId, final Integer sequence, final String name, final Integer nodeTime
   ) {
      this.id = id;
      this.productProcessId = productProcessId;
      this.processId = processId;
      this.sequence = sequence;
      this.name = name;
      this.nodeTime = nodeTime;
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

   public String getName() {
      return this.name;
   }

   public Integer getNodeTime() {
      return this.nodeTime;
   }

   @JsonProperty("id")
   public MesEnclosureProductProcessLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesEnclosureProductProcessLinkDTO setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureProductProcessLinkDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("sequence")
   public MesEnclosureProductProcessLinkDTO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureProductProcessLinkDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("nodeTime")
   public MesEnclosureProductProcessLinkDTO setNodeTime(final Integer nodeTime) {
      this.nodeTime = nodeTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductProcessLinkDTO(id="
         + this.getId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", processId="
         + this.getProcessId()
         + ", sequence="
         + this.getSequence()
         + ", name="
         + this.getName()
         + ", nodeTime="
         + this.getNodeTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductProcessLinkDTO)) {
         return false;
      }

      MesEnclosureProductProcessLinkDTO other = (MesEnclosureProductProcessLinkDTO)o;
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
               if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                  Object this$nodeTime = this.getNodeTime();
                  Object other$nodeTime = other.getNodeTime();
                  if (this$nodeTime == null ? other$nodeTime == null : this$nodeTime.equals(other$nodeTime)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     return this$name == null ? other$name == null : this$name.equals(other$name);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProductProcessLinkDTO;
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
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $nodeTime = this.getNodeTime();
      result = result * 59 + ($nodeTime == null ? 43 : $nodeTime.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesEnclosureProductProcessLinkDTOBuilder {
      private Long id;
      private Long productProcessId;
      private Long processId;
      private Integer sequence;
      private String name;
      private Integer nodeTime;

      MesEnclosureProductProcessLinkDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProductProcessLinkDTO.MesEnclosureProductProcessLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesEnclosureProductProcessLinkDTO.MesEnclosureProductProcessLinkDTOBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureProductProcessLinkDTO.MesEnclosureProductProcessLinkDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("sequence")
      public MesEnclosureProductProcessLinkDTO.MesEnclosureProductProcessLinkDTOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureProductProcessLinkDTO.MesEnclosureProductProcessLinkDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("nodeTime")
      public MesEnclosureProductProcessLinkDTO.MesEnclosureProductProcessLinkDTOBuilder nodeTime(final Integer nodeTime) {
         this.nodeTime = nodeTime;
         return this;
      }

      public MesEnclosureProductProcessLinkDTO build() {
         return new MesEnclosureProductProcessLinkDTO(this.id, this.productProcessId, this.processId, this.sequence, this.name, this.nodeTime);
      }

      @Override
      public String toString() {
         return "MesEnclosureProductProcessLinkDTO.MesEnclosureProductProcessLinkDTOBuilder(id="
            + this.id
            + ", productProcessId="
            + this.productProcessId
            + ", processId="
            + this.processId
            + ", sequence="
            + this.sequence
            + ", name="
            + this.name
            + ", nodeTime="
            + this.nodeTime
            + ")";
      }
   }
}
