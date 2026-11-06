package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "TeamProduceDTO", description = "产线下班组生产汇总返回类")
public class TeamProduceDTO {
   @ApiModelProperty(name = "project", notes = "项目", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;
   @ApiModelProperty(name = "workshop", notes = "车间", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private IdAndNameDO workshop;
   @ApiModelProperty(name = "line", notes = "生产线", value = "生产线")
   @JsonProperty("line")
   @JSONField(name = "line")
   private IdAndNameDO line;
   @ApiModelProperty(name = "teamId", notes = "班组id", value = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "LeaderName", notes = "组长名", value = "组长名")
   @JsonProperty("LeaderName")
   @JSONField(name = "LeaderName")
   private String LeaderName;
   @ApiModelProperty(name = "totalLength", notes = "总长", value = "总长")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalQuantity", notes = "总数", value = "总数")
   @JsonProperty("totalQuantity")
   @JSONField(name = "totalQuantity")
   private BigDecimal totalQuantity;
   @ApiModelProperty(name = "price", value = "工价 每米")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static TeamProduceDTO.TeamProduceDTOBuilder builder() {
      return new TeamProduceDTO.TeamProduceDTOBuilder();
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public IdAndNameDO getWorkshop() {
      return this.workshop;
   }

   public IdAndNameDO getLine() {
      return this.line;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getLeaderName() {
      return this.LeaderName;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("project")
   public TeamProduceDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @JsonProperty("workshop")
   public TeamProduceDTO setWorkshop(final IdAndNameDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("line")
   public TeamProduceDTO setLine(final IdAndNameDO line) {
      this.line = line;
      return this;
   }

   @JsonProperty("teamId")
   public TeamProduceDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("LeaderName")
   public TeamProduceDTO setLeaderName(final String LeaderName) {
      this.LeaderName = LeaderName;
      return this;
   }

   @JsonProperty("totalLength")
   public TeamProduceDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalQuantity")
   public TeamProduceDTO setTotalQuantity(final BigDecimal totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   @JsonProperty("price")
   public TeamProduceDTO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamProduceDTO)) {
         return false;
      }

      TeamProduceDTO other = (TeamProduceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teamId = this.getTeamId();
      Object other$teamId = other.getTeamId();
      if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$workshop = this.getWorkshop();
            Object other$workshop = other.getWorkshop();
            if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
               Object this$line = this.getLine();
               Object other$line = other.getLine();
               if (this$line == null ? other$line == null : this$line.equals(other$line)) {
                  Object this$LeaderName = this.getLeaderName();
                  Object other$LeaderName = other.getLeaderName();
                  if (this$LeaderName == null ? other$LeaderName == null : this$LeaderName.equals(other$LeaderName)) {
                     Object this$totalLength = this.getTotalLength();
                     Object other$totalLength = other.getTotalLength();
                     if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                        Object this$totalQuantity = this.getTotalQuantity();
                        Object other$totalQuantity = other.getTotalQuantity();
                        if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                           Object this$price = this.getPrice();
                           Object other$price = other.getPrice();
                           return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof TeamProduceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $line = this.getLine();
      result = result * 59 + ($line == null ? 43 : $line.hashCode());
      Object $LeaderName = this.getLeaderName();
      result = result * 59 + ($LeaderName == null ? 43 : $LeaderName.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "TeamProduceDTO(project="
         + this.getProject()
         + ", workshop="
         + this.getWorkshop()
         + ", line="
         + this.getLine()
         + ", teamId="
         + this.getTeamId()
         + ", LeaderName="
         + this.getLeaderName()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", price="
         + this.getPrice()
         + ")";
   }

   public TeamProduceDTO(
      final ProjectInfo project,
      final IdAndNameDO workshop,
      final IdAndNameDO line,
      final Long teamId,
      final String LeaderName,
      final BigDecimal totalLength,
      final BigDecimal totalQuantity,
      final BigDecimal price
   ) {
      this.project = project;
      this.workshop = workshop;
      this.line = line;
      this.teamId = teamId;
      this.LeaderName = LeaderName;
      this.totalLength = totalLength;
      this.totalQuantity = totalQuantity;
      this.price = price;
   }

   public TeamProduceDTO() {
   }

   public static class TeamProduceDTOBuilder {
      private ProjectInfo project;
      private IdAndNameDO workshop;
      private IdAndNameDO line;
      private Long teamId;
      private String LeaderName;
      private BigDecimal totalLength;
      private BigDecimal totalQuantity;
      private BigDecimal price;

      TeamProduceDTOBuilder() {
      }

      @JsonProperty("project")
      public TeamProduceDTO.TeamProduceDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("workshop")
      public TeamProduceDTO.TeamProduceDTOBuilder workshop(final IdAndNameDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("line")
      public TeamProduceDTO.TeamProduceDTOBuilder line(final IdAndNameDO line) {
         this.line = line;
         return this;
      }

      @JsonProperty("teamId")
      public TeamProduceDTO.TeamProduceDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("LeaderName")
      public TeamProduceDTO.TeamProduceDTOBuilder LeaderName(final String LeaderName) {
         this.LeaderName = LeaderName;
         return this;
      }

      @JsonProperty("totalLength")
      public TeamProduceDTO.TeamProduceDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalQuantity")
      public TeamProduceDTO.TeamProduceDTOBuilder totalQuantity(final BigDecimal totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      @JsonProperty("price")
      public TeamProduceDTO.TeamProduceDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public TeamProduceDTO build() {
         return new TeamProduceDTO(this.project, this.workshop, this.line, this.teamId, this.LeaderName, this.totalLength, this.totalQuantity, this.price);
      }

      @Override
      public String toString() {
         return "TeamProduceDTO.TeamProduceDTOBuilder(project="
            + this.project
            + ", workshop="
            + this.workshop
            + ", line="
            + this.line
            + ", teamId="
            + this.teamId
            + ", LeaderName="
            + this.LeaderName
            + ", totalLength="
            + this.totalLength
            + ", totalQuantity="
            + this.totalQuantity
            + ", price="
            + this.price
            + ")";
      }
   }
}
