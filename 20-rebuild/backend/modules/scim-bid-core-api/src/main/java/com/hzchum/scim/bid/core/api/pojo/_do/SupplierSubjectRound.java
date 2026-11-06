package com.hzchum.scim.bid.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "供应商-招标科目和轮次关联表", description = "")
@TableName("supplier_subject_round")
@Table(name = "supplier_subject_round")
public class SupplierSubjectRound implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "supplierId", value = "招标项目-供应商关联表主键id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id")
   private Long supplierId;
   @ApiModelProperty(name = "projectId", value = "招标项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "projectSubjectId", value = "招标科目表主键id")
   @JsonProperty("projectSubjectId")
   @JSONField(name = "projectSubjectId")
   @TableField("project_subject_id")
   @Column(name = "project_subject_id")
   private Long projectSubjectId;
   @ApiModelProperty(name = "round", value = "当前轮次")
   @JsonProperty("round")
   @JSONField(name = "round")
   @TableField("round")
   @Column(name = "round")
   private Integer round;

   public static SupplierSubjectRound.SupplierSubjectRoundBuilder builder() {
      return new SupplierSubjectRound.SupplierSubjectRoundBuilder();
   }

   public SupplierSubjectRound() {
   }

   public SupplierSubjectRound(final Long id, final Long supplierId, final Long projectId, final Long projectSubjectId, final Integer round) {
      this.id = id;
      this.supplierId = supplierId;
      this.projectId = projectId;
      this.projectSubjectId = projectSubjectId;
      this.round = round;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getProjectSubjectId() {
      return this.projectSubjectId;
   }

   public Integer getRound() {
      return this.round;
   }

   @JsonProperty("id")
   public SupplierSubjectRound setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("supplierId")
   public SupplierSubjectRound setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("projectId")
   public SupplierSubjectRound setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("projectSubjectId")
   public SupplierSubjectRound setProjectSubjectId(final Long projectSubjectId) {
      this.projectSubjectId = projectSubjectId;
      return this;
   }

   @JsonProperty("round")
   public SupplierSubjectRound setRound(final Integer round) {
      this.round = round;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSubjectRound)) {
         return false;
      }

      SupplierSubjectRound other = (SupplierSubjectRound)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$projectSubjectId = this.getProjectSubjectId();
               Object other$projectSubjectId = other.getProjectSubjectId();
               if (this$projectSubjectId == null ? other$projectSubjectId == null : this$projectSubjectId.equals(other$projectSubjectId)) {
                  Object this$round = this.getRound();
                  Object other$round = other.getRound();
                  return this$round == null ? other$round == null : this$round.equals(other$round);
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
      return other instanceof SupplierSubjectRound;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectSubjectId = this.getProjectSubjectId();
      result = result * 59 + ($projectSubjectId == null ? 43 : $projectSubjectId.hashCode());
      Object $round = this.getRound();
      return result * 59 + ($round == null ? 43 : $round.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSubjectRound(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", projectId="
         + this.getProjectId()
         + ", projectSubjectId="
         + this.getProjectSubjectId()
         + ", round="
         + this.getRound()
         + ")";
   }

   public static class SupplierSubjectRoundBuilder {
      private Long id;
      private Long supplierId;
      private Long projectId;
      private Long projectSubjectId;
      private Integer round;

      SupplierSubjectRoundBuilder() {
      }

      @JsonProperty("id")
      public SupplierSubjectRound.SupplierSubjectRoundBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("supplierId")
      public SupplierSubjectRound.SupplierSubjectRoundBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("projectId")
      public SupplierSubjectRound.SupplierSubjectRoundBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("projectSubjectId")
      public SupplierSubjectRound.SupplierSubjectRoundBuilder projectSubjectId(final Long projectSubjectId) {
         this.projectSubjectId = projectSubjectId;
         return this;
      }

      @JsonProperty("round")
      public SupplierSubjectRound.SupplierSubjectRoundBuilder round(final Integer round) {
         this.round = round;
         return this;
      }

      public SupplierSubjectRound build() {
         return new SupplierSubjectRound(this.id, this.supplierId, this.projectId, this.projectSubjectId, this.round);
      }

      @Override
      public String toString() {
         return "SupplierSubjectRound.SupplierSubjectRoundBuilder(id="
            + this.id
            + ", supplierId="
            + this.supplierId
            + ", projectId="
            + this.projectId
            + ", projectSubjectId="
            + this.projectSubjectId
            + ", round="
            + this.round
            + ")";
      }
   }
}
