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

@ApiModel(value = "MesBuildingNestingJson对象", description = "零件套料json")
@Entity
@TableName("mes_building_nesting_json")
@Table(name = "mes_building_nesting_json")
public class MesBuildingNestingJson extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "teamCode", value = "团队码", notes = "团队码")
   @TableField("team_code")
   @Column(name = "team_code", columnDefinition = "varchar(255)  COMMENT '团队码'", nullable = true)
   private String teamCode;
   @ApiModelProperty(name = "guid", value = "钢板id", notes = "钢板id")
   @Column(name = "guid", columnDefinition = "varchar(255)  COMMENT '钢板id'", nullable = false)
   @TableField("guid")
   private String guid;
   @ApiModelProperty(name = "jobId", value = "作业id", notes = "作业id")
   @TableField("job_id")
   @Column(name = "job_id", columnDefinition = "bigint(20)  COMMENT '作业id'", nullable = false)
   private Integer jobId;
   @ApiModelProperty(name = "jobPartJson", value = "零件信息", notes = "零件信息")
   @TableField("job_part_json")
   @Column(name = "job_part_json", columnDefinition = "mediumblob  COMMENT '零件信息'", nullable = true)
   private byte[] jobPartJson;

   public static MesBuildingNestingJson.MesBuildingNestingJsonBuilder builder() {
      return new MesBuildingNestingJson.MesBuildingNestingJsonBuilder();
   }

   public MesBuildingNestingJson() {
   }

   public MesBuildingNestingJson(final Long id, final String teamCode, final String guid, final Integer jobId, final byte[] jobPartJson) {
      this.id = id;
      this.teamCode = teamCode;
      this.guid = guid;
      this.jobId = jobId;
      this.jobPartJson = jobPartJson;
   }

   public Long getId() {
      return this.id;
   }

   public String getTeamCode() {
      return this.teamCode;
   }

   public String getGuid() {
      return this.guid;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public byte[] getJobPartJson() {
      return this.jobPartJson;
   }

   public MesBuildingNestingJson setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingNestingJson setTeamCode(final String teamCode) {
      this.teamCode = teamCode;
      return this;
   }

   public MesBuildingNestingJson setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public MesBuildingNestingJson setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   public MesBuildingNestingJson setJobPartJson(final byte[] jobPartJson) {
      this.jobPartJson = jobPartJson;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestingJson(id="
         + this.getId()
         + ", teamCode="
         + this.getTeamCode()
         + ", guid="
         + this.getGuid()
         + ", jobId="
         + this.getJobId()
         + ", jobPartJson="
         + Arrays.toString(this.getJobPartJson())
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestingJson)) {
         return false;
      }

      MesBuildingNestingJson other = (MesBuildingNestingJson)o;
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
            Object this$teamCode = this.getTeamCode();
            Object other$teamCode = other.getTeamCode();
            if (this$teamCode == null ? other$teamCode == null : this$teamCode.equals(other$teamCode)) {
               Object this$guid = this.getGuid();
               Object other$guid = other.getGuid();
               return (this$guid == null ? other$guid == null : this$guid.equals(other$guid))
                  ? Arrays.equals(this.getJobPartJson(), other.getJobPartJson())
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
      return other instanceof MesBuildingNestingJson;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $teamCode = this.getTeamCode();
      result = result * 59 + ($teamCode == null ? 43 : $teamCode.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      return result * 59 + Arrays.hashCode(this.getJobPartJson());
   }

   public static class MesBuildingNestingJsonBuilder {
      private Long id;
      private String teamCode;
      private String guid;
      private Integer jobId;
      private byte[] jobPartJson;

      MesBuildingNestingJsonBuilder() {
      }

      public MesBuildingNestingJson.MesBuildingNestingJsonBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingNestingJson.MesBuildingNestingJsonBuilder teamCode(final String teamCode) {
         this.teamCode = teamCode;
         return this;
      }

      public MesBuildingNestingJson.MesBuildingNestingJsonBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public MesBuildingNestingJson.MesBuildingNestingJsonBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public MesBuildingNestingJson.MesBuildingNestingJsonBuilder jobPartJson(final byte[] jobPartJson) {
         this.jobPartJson = jobPartJson;
         return this;
      }

      public MesBuildingNestingJson build() {
         return new MesBuildingNestingJson(this.id, this.teamCode, this.guid, this.jobId, this.jobPartJson);
      }

      @Override
      public String toString() {
         return "MesBuildingNestingJson.MesBuildingNestingJsonBuilder(id="
            + this.id
            + ", teamCode="
            + this.teamCode
            + ", guid="
            + this.guid
            + ", jobId="
            + this.jobId
            + ", jobPartJson="
            + Arrays.toString(this.jobPartJson)
            + ")";
      }
   }
}
