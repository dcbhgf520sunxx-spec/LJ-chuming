package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory;

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
import javax.persistence.Table;

@ApiModel(value = "MesEnclosureLineInspectionTeamLink对象", description = "生产线质检班组关联关系 ")
@Entity
@TableName("mes_enclosure_line_inspection_team_link")
@Table(name = "mes_enclosure_line_inspection_team_link")
public class MesEnclosureLineInspectionTeamLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "lineId", value = "产线id", notes = "产线id")
   @JsonProperty("lineId")
   @JSONField(name = "line_id")
   @TableField("line_id")
   @Column(name = "line_id", columnDefinition = "bigint(20)  COMMENT '产线id'", nullable = false)
   private Long lineId;
   @ApiModelProperty(name = "inspectionTeamId", value = "车间id", notes = "车间id")
   @JsonProperty("inspectionTeamId")
   @JSONField(name = "inspectionTeamId")
   @TableField("inspection_team_id")
   @Column(name = "inspection_team_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long inspectionTeamId;

   public static MesEnclosureLineInspectionTeamLink.MesEnclosureLineInspectionTeamLinkBuilder builder() {
      return new MesEnclosureLineInspectionTeamLink.MesEnclosureLineInspectionTeamLinkBuilder();
   }

   public MesEnclosureLineInspectionTeamLink() {
   }

   public MesEnclosureLineInspectionTeamLink(final Long id, final Long lineId, final Long inspectionTeamId) {
      this.id = id;
      this.lineId = lineId;
      this.inspectionTeamId = inspectionTeamId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public Long getInspectionTeamId() {
      return this.inspectionTeamId;
   }

   @JsonProperty("id")
   public MesEnclosureLineInspectionTeamLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("lineId")
   public MesEnclosureLineInspectionTeamLink setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   @JsonProperty("inspectionTeamId")
   public MesEnclosureLineInspectionTeamLink setInspectionTeamId(final Long inspectionTeamId) {
      this.inspectionTeamId = inspectionTeamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureLineInspectionTeamLink(id="
         + this.getId()
         + ", lineId="
         + this.getLineId()
         + ", inspectionTeamId="
         + this.getInspectionTeamId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureLineInspectionTeamLink)) {
         return false;
      }

      MesEnclosureLineInspectionTeamLink other = (MesEnclosureLineInspectionTeamLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$lineId = this.getLineId();
         Object other$lineId = other.getLineId();
         if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
            Object this$inspectionTeamId = this.getInspectionTeamId();
            Object other$inspectionTeamId = other.getInspectionTeamId();
            return this$inspectionTeamId == null ? other$inspectionTeamId == null : this$inspectionTeamId.equals(other$inspectionTeamId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureLineInspectionTeamLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $inspectionTeamId = this.getInspectionTeamId();
      return result * 59 + ($inspectionTeamId == null ? 43 : $inspectionTeamId.hashCode());
   }

   public static class MesEnclosureLineInspectionTeamLinkBuilder {
      private Long id;
      private Long lineId;
      private Long inspectionTeamId;

      MesEnclosureLineInspectionTeamLinkBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureLineInspectionTeamLink.MesEnclosureLineInspectionTeamLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("lineId")
      public MesEnclosureLineInspectionTeamLink.MesEnclosureLineInspectionTeamLinkBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      @JsonProperty("inspectionTeamId")
      public MesEnclosureLineInspectionTeamLink.MesEnclosureLineInspectionTeamLinkBuilder inspectionTeamId(final Long inspectionTeamId) {
         this.inspectionTeamId = inspectionTeamId;
         return this;
      }

      public MesEnclosureLineInspectionTeamLink build() {
         return new MesEnclosureLineInspectionTeamLink(this.id, this.lineId, this.inspectionTeamId);
      }

      @Override
      public String toString() {
         return "MesEnclosureLineInspectionTeamLink.MesEnclosureLineInspectionTeamLinkBuilder(id="
            + this.id
            + ", lineId="
            + this.lineId
            + ", inspectionTeamId="
            + this.inspectionTeamId
            + ")";
      }
   }
}
