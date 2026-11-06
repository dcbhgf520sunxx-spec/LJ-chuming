package com.hzchum.scim.plan.core.api.pojo._doModel.task;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingProduceInspectionTeamReportPaintThicknessLink对象", description = "")
@Entity
@TableName("mes_building_produce_inspection_team_report_paint_thickness_link")
@Table(name = "mes_building_produce_inspection_team_report_paint_thickness_link")
@org.hibernate.annotations.Table(appliesTo = "mes_building_produce_inspection_team_report_paint_thickness_link")
public class MesBuildingProduceInspectionTeamReportPaintThicknessLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "inspectionId", value = "质检记录id", notes = "质检记录id")
   @TableField("inspection_id")
   @Column(name = "inspection_id", columnDefinition = "bigint  COMMENT '质检记录id'", nullable = true)
   private Long inspectionId;
   @ApiModelProperty(name = "name", value = "漆膜检测点位", notes = "漆膜检测点位")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '漆膜检测点位'", nullable = true)
   private String name;
   @ApiModelProperty(name = "detectionTime", value = "检测时间", notes = "检测时间")
   @TableField("detection_time")
   @Column(name = "detection_time", columnDefinition = "datetime  COMMENT '检测时间'", nullable = true)
   private LocalDateTime detectionTime;
   @ApiModelProperty(name = "thickness", value = "漆膜厚度", notes = "漆膜厚度")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(10,2)  COMMENT '漆膜厚度'", nullable = true)
   private BigDecimal thickness;

   public static MesBuildingProduceInspectionTeamReportPaintThicknessLink.MesBuildingProduceInspectionTeamReportPaintThicknessLinkBuilder builder() {
      return new MesBuildingProduceInspectionTeamReportPaintThicknessLink.MesBuildingProduceInspectionTeamReportPaintThicknessLinkBuilder();
   }

   public MesBuildingProduceInspectionTeamReportPaintThicknessLink() {
   }

   public MesBuildingProduceInspectionTeamReportPaintThicknessLink(
      final Long id, final Long inspectionId, final String name, final LocalDateTime detectionTime, final BigDecimal thickness
   ) {
      this.id = id;
      this.inspectionId = inspectionId;
      this.name = name;
      this.detectionTime = detectionTime;
      this.thickness = thickness;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInspectionId() {
      return this.inspectionId;
   }

   public String getName() {
      return this.name;
   }

   public LocalDateTime getDetectionTime() {
      return this.detectionTime;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public MesBuildingProduceInspectionTeamReportPaintThicknessLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingProduceInspectionTeamReportPaintThicknessLink setInspectionId(final Long inspectionId) {
      this.inspectionId = inspectionId;
      return this;
   }

   public MesBuildingProduceInspectionTeamReportPaintThicknessLink setName(final String name) {
      this.name = name;
      return this;
   }

   public MesBuildingProduceInspectionTeamReportPaintThicknessLink setDetectionTime(final LocalDateTime detectionTime) {
      this.detectionTime = detectionTime;
      return this;
   }

   public MesBuildingProduceInspectionTeamReportPaintThicknessLink setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProduceInspectionTeamReportPaintThicknessLink(id="
         + this.getId()
         + ", inspectionId="
         + this.getInspectionId()
         + ", name="
         + this.getName()
         + ", detectionTime="
         + this.getDetectionTime()
         + ", thickness="
         + this.getThickness()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProduceInspectionTeamReportPaintThicknessLink)) {
         return false;
      }

      MesBuildingProduceInspectionTeamReportPaintThicknessLink other = (MesBuildingProduceInspectionTeamReportPaintThicknessLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inspectionId = this.getInspectionId();
         Object other$inspectionId = other.getInspectionId();
         if (this$inspectionId == null ? other$inspectionId == null : this$inspectionId.equals(other$inspectionId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$detectionTime = this.getDetectionTime();
               Object other$detectionTime = other.getDetectionTime();
               if (this$detectionTime == null ? other$detectionTime == null : this$detectionTime.equals(other$detectionTime)) {
                  Object this$thickness = this.getThickness();
                  Object other$thickness = other.getThickness();
                  return this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness);
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
      return other instanceof MesBuildingProduceInspectionTeamReportPaintThicknessLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inspectionId = this.getInspectionId();
      result = result * 59 + ($inspectionId == null ? 43 : $inspectionId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $detectionTime = this.getDetectionTime();
      result = result * 59 + ($detectionTime == null ? 43 : $detectionTime.hashCode());
      Object $thickness = this.getThickness();
      return result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
   }

   public static class MesBuildingProduceInspectionTeamReportPaintThicknessLinkBuilder {
      private Long id;
      private Long inspectionId;
      private String name;
      private LocalDateTime detectionTime;
      private BigDecimal thickness;

      MesBuildingProduceInspectionTeamReportPaintThicknessLinkBuilder() {
      }

      public MesBuildingProduceInspectionTeamReportPaintThicknessLink.MesBuildingProduceInspectionTeamReportPaintThicknessLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingProduceInspectionTeamReportPaintThicknessLink.MesBuildingProduceInspectionTeamReportPaintThicknessLinkBuilder inspectionId(
         final Long inspectionId
      ) {
         this.inspectionId = inspectionId;
         return this;
      }

      public MesBuildingProduceInspectionTeamReportPaintThicknessLink.MesBuildingProduceInspectionTeamReportPaintThicknessLinkBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingProduceInspectionTeamReportPaintThicknessLink.MesBuildingProduceInspectionTeamReportPaintThicknessLinkBuilder detectionTime(
         final LocalDateTime detectionTime
      ) {
         this.detectionTime = detectionTime;
         return this;
      }

      public MesBuildingProduceInspectionTeamReportPaintThicknessLink.MesBuildingProduceInspectionTeamReportPaintThicknessLinkBuilder thickness(
         final BigDecimal thickness
      ) {
         this.thickness = thickness;
         return this;
      }

      public MesBuildingProduceInspectionTeamReportPaintThicknessLink build() {
         return new MesBuildingProduceInspectionTeamReportPaintThicknessLink(this.id, this.inspectionId, this.name, this.detectionTime, this.thickness);
      }

      @Override
      public String toString() {
         return "MesBuildingProduceInspectionTeamReportPaintThicknessLink.MesBuildingProduceInspectionTeamReportPaintThicknessLinkBuilder(id="
            + this.id
            + ", inspectionId="
            + this.inspectionId
            + ", name="
            + this.name
            + ", detectionTime="
            + this.detectionTime
            + ", thickness="
            + this.thickness
            + ")";
      }
   }
}
