package com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesDailyProductionArtifactSumDTO", description = "当日产量统计")
public class MesDailyProductionArtifactSumDTO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "totalQuantity", notes = "焊接总数")
   @JsonProperty("totalQuantity")
   @JSONField(name = "totalQuantity")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalMete", notes = "焊接总重(t)")
   @JsonProperty("totalMete")
   @JSONField(name = "totalMete")
   private BigDecimal totalMete;
   @ApiModelProperty(name = "dayTotalQuantity", notes = "当日焊接总数")
   @JsonProperty("dayTotalQuantity")
   @JSONField(name = "dayTotalQuantity")
   private Integer dayTotalQuantity;
   @ApiModelProperty(name = "dayTotalMete", notes = "当日焊接总重")
   @JsonProperty("dayTotalMete")
   @JSONField(name = "dayTotalMete")
   private BigDecimal dayTotalMete;
   @ApiModelProperty(name = "totalPackMete", notes = "累计打包")
   @JsonProperty("totalPackMete")
   @JSONField(name = "totalPackMete")
   private BigDecimal totalPackMete;
   @ApiModelProperty(name = "dayTotalPackMete", notes = "当日打包")
   @JsonProperty("dayTotalPackMete")
   @JSONField(name = "dayTotalPackMete")
   private BigDecimal dayTotalPackMete;
   @ApiModelProperty(name = "teamArtifactSumDTOS", notes = "班组生产详情")
   @JsonProperty("teamArtifactSumDTOS")
   @JSONField(name = "teamArtifactSumDTOS")
   private List<MesDailyProductionArtifactSumDTO> teamArtifactSumDTOS;

   public static MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder builder() {
      return new MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder();
   }

   public MesDailyProductionArtifactSumDTO() {
   }

   public MesDailyProductionArtifactSumDTO(
      final Long id,
      final String name,
      final Integer totalQuantity,
      final BigDecimal totalMete,
      final Integer dayTotalQuantity,
      final BigDecimal dayTotalMete,
      final BigDecimal totalPackMete,
      final BigDecimal dayTotalPackMete,
      final List<MesDailyProductionArtifactSumDTO> teamArtifactSumDTOS
   ) {
      this.id = id;
      this.name = name;
      this.totalQuantity = totalQuantity;
      this.totalMete = totalMete;
      this.dayTotalQuantity = dayTotalQuantity;
      this.dayTotalMete = dayTotalMete;
      this.totalPackMete = totalPackMete;
      this.dayTotalPackMete = dayTotalPackMete;
      this.teamArtifactSumDTOS = teamArtifactSumDTOS;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public Integer getDayTotalQuantity() {
      return this.dayTotalQuantity;
   }

   public BigDecimal getDayTotalMete() {
      return this.dayTotalMete;
   }

   public BigDecimal getTotalPackMete() {
      return this.totalPackMete;
   }

   public BigDecimal getDayTotalPackMete() {
      return this.dayTotalPackMete;
   }

   public List<MesDailyProductionArtifactSumDTO> getTeamArtifactSumDTOS() {
      return this.teamArtifactSumDTOS;
   }

   @JsonProperty("id")
   public MesDailyProductionArtifactSumDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesDailyProductionArtifactSumDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("totalQuantity")
   public MesDailyProductionArtifactSumDTO setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   @JsonProperty("totalMete")
   public MesDailyProductionArtifactSumDTO setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
      return this;
   }

   @JsonProperty("dayTotalQuantity")
   public MesDailyProductionArtifactSumDTO setDayTotalQuantity(final Integer dayTotalQuantity) {
      this.dayTotalQuantity = dayTotalQuantity;
      return this;
   }

   @JsonProperty("dayTotalMete")
   public MesDailyProductionArtifactSumDTO setDayTotalMete(final BigDecimal dayTotalMete) {
      this.dayTotalMete = dayTotalMete;
      return this;
   }

   @JsonProperty("totalPackMete")
   public MesDailyProductionArtifactSumDTO setTotalPackMete(final BigDecimal totalPackMete) {
      this.totalPackMete = totalPackMete;
      return this;
   }

   @JsonProperty("dayTotalPackMete")
   public MesDailyProductionArtifactSumDTO setDayTotalPackMete(final BigDecimal dayTotalPackMete) {
      this.dayTotalPackMete = dayTotalPackMete;
      return this;
   }

   @JsonProperty("teamArtifactSumDTOS")
   public MesDailyProductionArtifactSumDTO setTeamArtifactSumDTOS(final List<MesDailyProductionArtifactSumDTO> teamArtifactSumDTOS) {
      this.teamArtifactSumDTOS = teamArtifactSumDTOS;
      return this;
   }

   @Override
   public String toString() {
      return "MesDailyProductionArtifactSumDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalMete="
         + this.getTotalMete()
         + ", dayTotalQuantity="
         + this.getDayTotalQuantity()
         + ", dayTotalMete="
         + this.getDayTotalMete()
         + ", totalPackMete="
         + this.getTotalPackMete()
         + ", dayTotalPackMete="
         + this.getDayTotalPackMete()
         + ", teamArtifactSumDTOS="
         + this.getTeamArtifactSumDTOS()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesDailyProductionArtifactSumDTO)) {
         return false;
      }

      MesDailyProductionArtifactSumDTO other = (MesDailyProductionArtifactSumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$totalQuantity = this.getTotalQuantity();
         Object other$totalQuantity = other.getTotalQuantity();
         if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
            Object this$dayTotalQuantity = this.getDayTotalQuantity();
            Object other$dayTotalQuantity = other.getDayTotalQuantity();
            if (this$dayTotalQuantity == null ? other$dayTotalQuantity == null : this$dayTotalQuantity.equals(other$dayTotalQuantity)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$totalMete = this.getTotalMete();
                  Object other$totalMete = other.getTotalMete();
                  if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
                     Object this$dayTotalMete = this.getDayTotalMete();
                     Object other$dayTotalMete = other.getDayTotalMete();
                     if (this$dayTotalMete == null ? other$dayTotalMete == null : this$dayTotalMete.equals(other$dayTotalMete)) {
                        Object this$totalPackMete = this.getTotalPackMete();
                        Object other$totalPackMete = other.getTotalPackMete();
                        if (this$totalPackMete == null ? other$totalPackMete == null : this$totalPackMete.equals(other$totalPackMete)) {
                           Object this$dayTotalPackMete = this.getDayTotalPackMete();
                           Object other$dayTotalPackMete = other.getDayTotalPackMete();
                           if (this$dayTotalPackMete == null ? other$dayTotalPackMete == null : this$dayTotalPackMete.equals(other$dayTotalPackMete)) {
                              Object this$teamArtifactSumDTOS = this.getTeamArtifactSumDTOS();
                              Object other$teamArtifactSumDTOS = other.getTeamArtifactSumDTOS();
                              return this$teamArtifactSumDTOS == null
                                 ? other$teamArtifactSumDTOS == null
                                 : this$teamArtifactSumDTOS.equals(other$teamArtifactSumDTOS);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesDailyProductionArtifactSumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $dayTotalQuantity = this.getDayTotalQuantity();
      result = result * 59 + ($dayTotalQuantity == null ? 43 : $dayTotalQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $dayTotalMete = this.getDayTotalMete();
      result = result * 59 + ($dayTotalMete == null ? 43 : $dayTotalMete.hashCode());
      Object $totalPackMete = this.getTotalPackMete();
      result = result * 59 + ($totalPackMete == null ? 43 : $totalPackMete.hashCode());
      Object $dayTotalPackMete = this.getDayTotalPackMete();
      result = result * 59 + ($dayTotalPackMete == null ? 43 : $dayTotalPackMete.hashCode());
      Object $teamArtifactSumDTOS = this.getTeamArtifactSumDTOS();
      return result * 59 + ($teamArtifactSumDTOS == null ? 43 : $teamArtifactSumDTOS.hashCode());
   }

   public static class MesDailyProductionArtifactSumDTOBuilder {
      private Long id;
      private String name;
      private Integer totalQuantity;
      private BigDecimal totalMete;
      private Integer dayTotalQuantity;
      private BigDecimal dayTotalMete;
      private BigDecimal totalPackMete;
      private BigDecimal dayTotalPackMete;
      private List<MesDailyProductionArtifactSumDTO> teamArtifactSumDTOS;

      MesDailyProductionArtifactSumDTOBuilder() {
      }

      @JsonProperty("id")
      public MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("totalQuantity")
      public MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      @JsonProperty("totalMete")
      public MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      @JsonProperty("dayTotalQuantity")
      public MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder dayTotalQuantity(final Integer dayTotalQuantity) {
         this.dayTotalQuantity = dayTotalQuantity;
         return this;
      }

      @JsonProperty("dayTotalMete")
      public MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder dayTotalMete(final BigDecimal dayTotalMete) {
         this.dayTotalMete = dayTotalMete;
         return this;
      }

      @JsonProperty("totalPackMete")
      public MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder totalPackMete(final BigDecimal totalPackMete) {
         this.totalPackMete = totalPackMete;
         return this;
      }

      @JsonProperty("dayTotalPackMete")
      public MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder dayTotalPackMete(final BigDecimal dayTotalPackMete) {
         this.dayTotalPackMete = dayTotalPackMete;
         return this;
      }

      @JsonProperty("teamArtifactSumDTOS")
      public MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder teamArtifactSumDTOS(
         final List<MesDailyProductionArtifactSumDTO> teamArtifactSumDTOS
      ) {
         this.teamArtifactSumDTOS = teamArtifactSumDTOS;
         return this;
      }

      public MesDailyProductionArtifactSumDTO build() {
         return new MesDailyProductionArtifactSumDTO(
            this.id,
            this.name,
            this.totalQuantity,
            this.totalMete,
            this.dayTotalQuantity,
            this.dayTotalMete,
            this.totalPackMete,
            this.dayTotalPackMete,
            this.teamArtifactSumDTOS
         );
      }

      @Override
      public String toString() {
         return "MesDailyProductionArtifactSumDTO.MesDailyProductionArtifactSumDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalMete="
            + this.totalMete
            + ", dayTotalQuantity="
            + this.dayTotalQuantity
            + ", dayTotalMete="
            + this.dayTotalMete
            + ", totalPackMete="
            + this.totalPackMete
            + ", dayTotalPackMete="
            + this.dayTotalPackMete
            + ", teamArtifactSumDTOS="
            + this.teamArtifactSumDTOS
            + ")";
      }
   }
}
