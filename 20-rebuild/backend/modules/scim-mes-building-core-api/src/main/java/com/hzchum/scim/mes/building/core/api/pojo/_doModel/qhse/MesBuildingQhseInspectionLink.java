package com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse;

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

@ApiModel(value = "MesBuildingQhseInspectionLink对象", description = "问题曝光 ")
@Entity
@TableName("mes_building_qhse_inspection_link")
@Table(name = "mes_building_qhse_inspection_link")
public class MesBuildingQhseInspectionLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "qhseId", value = "项目id", notes = "项目id")
   @JsonProperty("qhseId")
   @JSONField(name = "qhseId")
   @TableField("qhse_id")
   @Column(name = "qhse_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = true)
   private Long qhseId;
   @ApiModelProperty(name = "inspectionReportId", value = "质检上报id", notes = "质检上报id")
   @JsonProperty("inspectionReportId")
   @JSONField(name = "inspectionReportId")
   @TableField("inspection_report_id")
   @Column(name = "inspection_report_id", columnDefinition = "bigint(20)  COMMENT '质检上报id'", nullable = true)
   private Long inspectionReportId;
   @ApiModelProperty(name = "qhseReportId", value = "问题上报记录id", notes = "问题上报记录id")
   @JsonProperty("qhseReportId")
   @JSONField(name = "qhseReportId")
   @TableField("qhse_report_id")
   @Column(name = "qhse_report_id", columnDefinition = "bigint(20)  COMMENT '问题上报记录id'", nullable = true)
   private Long qhseReportId;
   @ApiModelProperty(name = "number", value = "上报序号", notes = "上报序号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '上报序号'", nullable = true)
   private Integer number;

   public static MesBuildingQhseInspectionLink.MesBuildingQhseInspectionLinkBuilder builder() {
      return new MesBuildingQhseInspectionLink.MesBuildingQhseInspectionLinkBuilder();
   }

   public MesBuildingQhseInspectionLink() {
   }

   public MesBuildingQhseInspectionLink(final Long id, final Long qhseId, final Long inspectionReportId, final Long qhseReportId, final Integer number) {
      this.id = id;
      this.qhseId = qhseId;
      this.inspectionReportId = inspectionReportId;
      this.qhseReportId = qhseReportId;
      this.number = number;
   }

   public Long getId() {
      return this.id;
   }

   public Long getQhseId() {
      return this.qhseId;
   }

   public Long getInspectionReportId() {
      return this.inspectionReportId;
   }

   public Long getQhseReportId() {
      return this.qhseReportId;
   }

   public Integer getNumber() {
      return this.number;
   }

   @JsonProperty("id")
   public MesBuildingQhseInspectionLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("qhseId")
   public MesBuildingQhseInspectionLink setQhseId(final Long qhseId) {
      this.qhseId = qhseId;
      return this;
   }

   @JsonProperty("inspectionReportId")
   public MesBuildingQhseInspectionLink setInspectionReportId(final Long inspectionReportId) {
      this.inspectionReportId = inspectionReportId;
      return this;
   }

   @JsonProperty("qhseReportId")
   public MesBuildingQhseInspectionLink setQhseReportId(final Long qhseReportId) {
      this.qhseReportId = qhseReportId;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingQhseInspectionLink setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQhseInspectionLink(id="
         + this.getId()
         + ", qhseId="
         + this.getQhseId()
         + ", inspectionReportId="
         + this.getInspectionReportId()
         + ", qhseReportId="
         + this.getQhseReportId()
         + ", number="
         + this.getNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseInspectionLink)) {
         return false;
      }

      MesBuildingQhseInspectionLink other = (MesBuildingQhseInspectionLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$qhseId = this.getQhseId();
         Object other$qhseId = other.getQhseId();
         if (this$qhseId == null ? other$qhseId == null : this$qhseId.equals(other$qhseId)) {
            Object this$inspectionReportId = this.getInspectionReportId();
            Object other$inspectionReportId = other.getInspectionReportId();
            if (this$inspectionReportId == null ? other$inspectionReportId == null : this$inspectionReportId.equals(other$inspectionReportId)) {
               Object this$qhseReportId = this.getQhseReportId();
               Object other$qhseReportId = other.getQhseReportId();
               if (this$qhseReportId == null ? other$qhseReportId == null : this$qhseReportId.equals(other$qhseReportId)) {
                  Object this$number = this.getNumber();
                  Object other$number = other.getNumber();
                  return this$number == null ? other$number == null : this$number.equals(other$number);
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
      return other instanceof MesBuildingQhseInspectionLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $qhseId = this.getQhseId();
      result = result * 59 + ($qhseId == null ? 43 : $qhseId.hashCode());
      Object $inspectionReportId = this.getInspectionReportId();
      result = result * 59 + ($inspectionReportId == null ? 43 : $inspectionReportId.hashCode());
      Object $qhseReportId = this.getQhseReportId();
      result = result * 59 + ($qhseReportId == null ? 43 : $qhseReportId.hashCode());
      Object $number = this.getNumber();
      return result * 59 + ($number == null ? 43 : $number.hashCode());
   }

   public static class MesBuildingQhseInspectionLinkBuilder {
      private Long id;
      private Long qhseId;
      private Long inspectionReportId;
      private Long qhseReportId;
      private Integer number;

      MesBuildingQhseInspectionLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQhseInspectionLink.MesBuildingQhseInspectionLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("qhseId")
      public MesBuildingQhseInspectionLink.MesBuildingQhseInspectionLinkBuilder qhseId(final Long qhseId) {
         this.qhseId = qhseId;
         return this;
      }

      @JsonProperty("inspectionReportId")
      public MesBuildingQhseInspectionLink.MesBuildingQhseInspectionLinkBuilder inspectionReportId(final Long inspectionReportId) {
         this.inspectionReportId = inspectionReportId;
         return this;
      }

      @JsonProperty("qhseReportId")
      public MesBuildingQhseInspectionLink.MesBuildingQhseInspectionLinkBuilder qhseReportId(final Long qhseReportId) {
         this.qhseReportId = qhseReportId;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingQhseInspectionLink.MesBuildingQhseInspectionLinkBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesBuildingQhseInspectionLink build() {
         return new MesBuildingQhseInspectionLink(this.id, this.qhseId, this.inspectionReportId, this.qhseReportId, this.number);
      }

      @Override
      public String toString() {
         return "MesBuildingQhseInspectionLink.MesBuildingQhseInspectionLinkBuilder(id="
            + this.id
            + ", qhseId="
            + this.qhseId
            + ", inspectionReportId="
            + this.inspectionReportId
            + ", qhseReportId="
            + this.qhseReportId
            + ", number="
            + this.number
            + ")";
      }
   }
}
