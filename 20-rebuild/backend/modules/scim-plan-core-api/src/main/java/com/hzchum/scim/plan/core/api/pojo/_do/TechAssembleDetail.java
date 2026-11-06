package com.hzchum.scim.plan.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "TechAssembleDetail对象", description = "构件和部件(组立)关联表")
@Entity
@TableName("tech_assemble_detail")
@Table(
   name = "tech_assemble_detail",
   indexes = {@Index(name = "assemble_id", columnList = "assemble_id"), @Index(name = "artifact_id", columnList = "artifact_id")}
)
@org.hibernate.annotations.Table(appliesTo = "tech_assemble_detail", comment = "构件和部件(组立)关联表 ")
public class TechAssembleDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "assembleId", value = "组立id")
   @JsonProperty("assembleId")
   @JSONField(name = "assembleId")
   @TableField("assemble_id")
   @Column(name = "assemble_id", columnDefinition = "bigint(20) comment '组立id'", nullable = false)
   private Long assembleId;
   @ApiModelProperty(name = "artifactId", value = "构件id")
   @JsonProperty("artifactId")
   @JSONField(name = "artifactId")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20) comment '构件id'", nullable = false)
   private Long artifactId;
   @ApiModelProperty(name = "quantity", value = "组立数量和构件数量比例")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  comment '组立数量和构件数量比例'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "remark", value = "该构件内部件备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024) comment '该构件内部件备注'")
   private String remark;

   public static TechAssembleDetail.TechAssembleDetailBuilder builder() {
      return new TechAssembleDetail.TechAssembleDetailBuilder();
   }

   public TechAssembleDetail() {
   }

   public TechAssembleDetail(final Long id, final Long assembleId, final Long artifactId, final Integer quantity, final String remark) {
      this.id = id;
      this.assembleId = assembleId;
      this.artifactId = artifactId;
      this.quantity = quantity;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public TechAssembleDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("assembleId")
   public TechAssembleDetail setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   @JsonProperty("artifactId")
   public TechAssembleDetail setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   @JsonProperty("quantity")
   public TechAssembleDetail setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechAssembleDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "TechAssembleDetail(id="
         + this.getId()
         + ", assembleId="
         + this.getAssembleId()
         + ", artifactId="
         + this.getArtifactId()
         + ", quantity="
         + this.getQuantity()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssembleDetail)) {
         return false;
      }

      TechAssembleDetail other = (TechAssembleDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleId = this.getAssembleId();
         Object other$assembleId = other.getAssembleId();
         if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
            Object this$artifactId = this.getArtifactId();
            Object other$artifactId = other.getArtifactId();
            if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof TechAssembleDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class TechAssembleDetailBuilder {
      private Long id;
      private Long assembleId;
      private Long artifactId;
      private Integer quantity;
      private String remark;

      TechAssembleDetailBuilder() {
      }

      @JsonProperty("id")
      public TechAssembleDetail.TechAssembleDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("assembleId")
      public TechAssembleDetail.TechAssembleDetailBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      @JsonProperty("artifactId")
      public TechAssembleDetail.TechAssembleDetailBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      @JsonProperty("quantity")
      public TechAssembleDetail.TechAssembleDetailBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechAssembleDetail.TechAssembleDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechAssembleDetail build() {
         return new TechAssembleDetail(this.id, this.assembleId, this.artifactId, this.quantity, this.remark);
      }

      @Override
      public String toString() {
         return "TechAssembleDetail.TechAssembleDetailBuilder(id="
            + this.id
            + ", assembleId="
            + this.assembleId
            + ", artifactId="
            + this.artifactId
            + ", quantity="
            + this.quantity
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
