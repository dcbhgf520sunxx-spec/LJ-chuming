package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingNestingPlateJson对象", description = "零件套料json")
@Entity
@TableName("mes_building_nesting_plate_json")
@Table(name = "mes_building_nesting_plate_json")
public class MesBuildingNestingPlateJson extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "guid", value = "钢板id", notes = "钢板id")
   @Column(name = "guid", columnDefinition = "varchar(255)  COMMENT '钢板id'", nullable = false)
   @TableField("guid")
   private String guid;
   @ApiModelProperty(name = "jobPartJson", value = "零件信息", notes = "零件信息")
   @TableField("job_part_json")
   @Column(name = "job_part_json", columnDefinition = "mediumblob  COMMENT '零件信息'", nullable = true)
   private byte[] jobPartJson;
   @ApiModelProperty(name = "teamCode", value = "团队码", notes = "团队码")
   @TableField("team_code")
   @Column(name = "team_code", columnDefinition = "varchar(255)  COMMENT '团队码'", nullable = true)
   private String teamCode;
   @ApiModelProperty(name = "jobId", value = "作业id", notes = "作业id")
   @TableField("job_id")
   @Column(name = "job_id", columnDefinition = "bigint(20)  COMMENT '作业id'", nullable = false)
   private Integer jobId;
   @ApiModelProperty(name = "plateDrawing", value = "钢板图纸", notes = "钢板图纸")
   @TableField("plate_drawing")
   @Column(name = "plate_drawing", columnDefinition = "mediumblob  COMMENT '钢板图纸'", nullable = true)
   private byte[] plateDrawing;

   public static MesBuildingNestingPlateJson.MesBuildingNestingPlateJsonBuilder builder() {
      return new MesBuildingNestingPlateJson.MesBuildingNestingPlateJsonBuilder();
   }

   public MesBuildingNestingPlateJson() {
   }

   public MesBuildingNestingPlateJson(
      final Long id, final String guid, final byte[] jobPartJson, final String teamCode, final Integer jobId, final byte[] plateDrawing
   ) {
      this.id = id;
      this.guid = guid;
      this.jobPartJson = jobPartJson;
      this.teamCode = teamCode;
      this.jobId = jobId;
      this.plateDrawing = plateDrawing;
   }

   public Long getId() {
      return this.id;
   }

   public String getGuid() {
      return this.guid;
   }

   public byte[] getJobPartJson() {
      return this.jobPartJson;
   }

   public String getTeamCode() {
      return this.teamCode;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public byte[] getPlateDrawing() {
      return this.plateDrawing;
   }

   public MesBuildingNestingPlateJson setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingNestingPlateJson setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public MesBuildingNestingPlateJson setJobPartJson(final byte[] jobPartJson) {
      this.jobPartJson = jobPartJson;
      return this;
   }

   public MesBuildingNestingPlateJson setTeamCode(final String teamCode) {
      this.teamCode = teamCode;
      return this;
   }

   public MesBuildingNestingPlateJson setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   public MesBuildingNestingPlateJson setPlateDrawing(final byte[] plateDrawing) {
      this.plateDrawing = plateDrawing;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestingPlateJson(id="
         + this.getId()
         + ", guid="
         + this.getGuid()
         + ", jobPartJson="
         + Arrays.toString(this.getJobPartJson())
         + ", teamCode="
         + this.getTeamCode()
         + ", jobId="
         + this.getJobId()
         + ", plateDrawing="
         + Arrays.toString(this.getPlateDrawing())
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestingPlateJson)) {
         return false;
      }

      MesBuildingNestingPlateJson other = (MesBuildingNestingPlateJson)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$jobId = this.getJobId();
         Object other$jobId = other.getJobId();
         if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
            Object this$guid = this.getGuid();
            Object other$guid = other.getGuid();
            if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
               if (!Arrays.equals(this.getJobPartJson(), other.getJobPartJson())) {
                  return false;
               }

               Object this$teamCode = this.getTeamCode();
               Object other$teamCode = other.getTeamCode();
               return (this$teamCode == null ? other$teamCode == null : this$teamCode.equals(other$teamCode))
                  ? Arrays.equals(this.getPlateDrawing(), other.getPlateDrawing())
                  : false;
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
      return other instanceof MesBuildingNestingPlateJson;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      result = result * 59 + Arrays.hashCode(this.getJobPartJson());
      Object $teamCode = this.getTeamCode();
      result = result * 59 + ($teamCode == null ? 43 : $teamCode.hashCode());
      return result * 59 + Arrays.hashCode(this.getPlateDrawing());
   }

   public static class MesBuildingNestingPlateJsonBuilder {
      private Long id;
      private String guid;
      private byte[] jobPartJson;
      private String teamCode;
      private Integer jobId;
      private byte[] plateDrawing;

      MesBuildingNestingPlateJsonBuilder() {
      }

      public MesBuildingNestingPlateJson.MesBuildingNestingPlateJsonBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingNestingPlateJson.MesBuildingNestingPlateJsonBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public MesBuildingNestingPlateJson.MesBuildingNestingPlateJsonBuilder jobPartJson(final byte[] jobPartJson) {
         this.jobPartJson = jobPartJson;
         return this;
      }

      public MesBuildingNestingPlateJson.MesBuildingNestingPlateJsonBuilder teamCode(final String teamCode) {
         this.teamCode = teamCode;
         return this;
      }

      public MesBuildingNestingPlateJson.MesBuildingNestingPlateJsonBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public MesBuildingNestingPlateJson.MesBuildingNestingPlateJsonBuilder plateDrawing(final byte[] plateDrawing) {
         this.plateDrawing = plateDrawing;
         return this;
      }

      public MesBuildingNestingPlateJson build() {
         return new MesBuildingNestingPlateJson(this.id, this.guid, this.jobPartJson, this.teamCode, this.jobId, this.plateDrawing);
      }

      @Override
      public String toString() {
         return "MesBuildingNestingPlateJson.MesBuildingNestingPlateJsonBuilder(id="
            + this.id
            + ", guid="
            + this.guid
            + ", jobPartJson="
            + Arrays.toString(this.jobPartJson)
            + ", teamCode="
            + this.teamCode
            + ", jobId="
            + this.jobId
            + ", plateDrawing="
            + Arrays.toString(this.plateDrawing)
            + ")";
      }
   }
}
