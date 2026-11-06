package com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesDailyProductionTaskSumDTO", description = "当日产量统计")
public class MesDailyProductionQuerySumDTO {
   @ApiModelProperty(name = "workShopId", notes = "车间id")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "workShopName", notes = "车间名称")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "teamId", notes = "班组Id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "userName", notes = "班组长名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "totalQuantity", notes = "总数")
   @JsonProperty("totalQuantity")
   @JSONField(name = "totalQuantity")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalMete", notes = "总重(t)")
   @JsonProperty("totalMete")
   @JSONField(name = "totalMete")
   private BigDecimal totalMete;
   @ApiModelProperty(name = "structureClassId", notes = "构件产品种类Id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   private Long structureClassId;
   @ApiModelProperty(name = "name", notes = "构件名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;

   public static MesDailyProductionQuerySumDTO.MesDailyProductionQuerySumDTOBuilder builder() {
      return new MesDailyProductionQuerySumDTO.MesDailyProductionQuerySumDTOBuilder();
   }

   public MesDailyProductionQuerySumDTO() {
   }

   public MesDailyProductionQuerySumDTO(
      final Long workShopId,
      final String workShopName,
      final Long teamId,
      final String userName,
      final Integer totalQuantity,
      final BigDecimal totalMete,
      final Long structureClassId,
      final String name
   ) {
      this.workShopId = workShopId;
      this.workShopName = workShopName;
      this.teamId = teamId;
      this.userName = userName;
      this.totalQuantity = totalQuantity;
      this.totalMete = totalMete;
      this.structureClassId = structureClassId;
      this.name = name;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("workShopId")
   public MesDailyProductionQuerySumDTO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("workShopName")
   public MesDailyProductionQuerySumDTO setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
      return this;
   }

   @JsonProperty("teamId")
   public MesDailyProductionQuerySumDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("userName")
   public MesDailyProductionQuerySumDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("totalQuantity")
   public MesDailyProductionQuerySumDTO setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   @JsonProperty("totalMete")
   public MesDailyProductionQuerySumDTO setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
      return this;
   }

   @JsonProperty("structureClassId")
   public MesDailyProductionQuerySumDTO setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   @JsonProperty("name")
   public MesDailyProductionQuerySumDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "MesDailyProductionQuerySumDTO(workShopId="
         + this.getWorkShopId()
         + ", workShopName="
         + this.getWorkShopName()
         + ", teamId="
         + this.getTeamId()
         + ", userName="
         + this.getUserName()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalMete="
         + this.getTotalMete()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", name="
         + this.getName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesDailyProductionQuerySumDTO)) {
         return false;
      }

      MesDailyProductionQuerySumDTO other = (MesDailyProductionQuerySumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workShopId = this.getWorkShopId();
      Object other$workShopId = other.getWorkShopId();
      if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$totalQuantity = this.getTotalQuantity();
            Object other$totalQuantity = other.getTotalQuantity();
            if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
               Object this$structureClassId = this.getStructureClassId();
               Object other$structureClassId = other.getStructureClassId();
               if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                  Object this$workShopName = this.getWorkShopName();
                  Object other$workShopName = other.getWorkShopName();
                  if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
                     Object this$userName = this.getUserName();
                     Object other$userName = other.getUserName();
                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                        Object this$totalMete = this.getTotalMete();
                        Object other$totalMete = other.getTotalMete();
                        if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesDailyProductionQuerySumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesDailyProductionQuerySumDTOBuilder {
      private Long workShopId;
      private String workShopName;
      private Long teamId;
      private String userName;
      private Integer totalQuantity;
      private BigDecimal totalMete;
      private Long structureClassId;
      private String name;

      MesDailyProductionQuerySumDTOBuilder() {
      }

      @JsonProperty("workShopId")
      public MesDailyProductionQuerySumDTO.MesDailyProductionQuerySumDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      @JsonProperty("workShopName")
      public MesDailyProductionQuerySumDTO.MesDailyProductionQuerySumDTOBuilder workShopName(final String workShopName) {
         this.workShopName = workShopName;
         return this;
      }

      @JsonProperty("teamId")
      public MesDailyProductionQuerySumDTO.MesDailyProductionQuerySumDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("userName")
      public MesDailyProductionQuerySumDTO.MesDailyProductionQuerySumDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("totalQuantity")
      public MesDailyProductionQuerySumDTO.MesDailyProductionQuerySumDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      @JsonProperty("totalMete")
      public MesDailyProductionQuerySumDTO.MesDailyProductionQuerySumDTOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      @JsonProperty("structureClassId")
      public MesDailyProductionQuerySumDTO.MesDailyProductionQuerySumDTOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      @JsonProperty("name")
      public MesDailyProductionQuerySumDTO.MesDailyProductionQuerySumDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesDailyProductionQuerySumDTO build() {
         return new MesDailyProductionQuerySumDTO(
            this.workShopId, this.workShopName, this.teamId, this.userName, this.totalQuantity, this.totalMete, this.structureClassId, this.name
         );
      }

      @Override
      public String toString() {
         return "MesDailyProductionQuerySumDTO.MesDailyProductionQuerySumDTOBuilder(workShopId="
            + this.workShopId
            + ", workShopName="
            + this.workShopName
            + ", teamId="
            + this.teamId
            + ", userName="
            + this.userName
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalMete="
            + this.totalMete
            + ", structureClassId="
            + this.structureClassId
            + ", name="
            + this.name
            + ")";
      }
   }
}
