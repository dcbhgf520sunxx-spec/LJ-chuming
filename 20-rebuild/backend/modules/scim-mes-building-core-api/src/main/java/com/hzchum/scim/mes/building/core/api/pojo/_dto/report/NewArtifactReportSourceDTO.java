package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "ArtifactReportSourceDTO", description = "产品溯源生产上报类 ")
public class NewArtifactReportSourceDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "date", notes = "时间")
   @JsonProperty("date")
   @JSONField(name = "date")
   private LocalDateTime date;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private NameInfo process;
   @ApiModelProperty(name = "user", notes = "上报人")
   @JsonProperty("user")
   @JSONField(name = "user")
   private NameInfo user;
   @ApiModelProperty(name = "team", notes = "班组")
   @JsonProperty("team")
   @JSONField(name = "team")
   private NameInfo team;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "sort", notes = "顺序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "boolInspect", notes = "是否为质检0否 1是")
   @JsonProperty("boolInspect")
   @JSONField(name = "boolInspect")
   private Boolean boolInspect;

   public static NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder builder() {
      return new NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder();
   }

   public NewArtifactReportSourceDTO() {
   }

   public NewArtifactReportSourceDTO(
      final Long id,
      final ProductionLineDetailDO productionLine,
      final LocalDateTime date,
      final NameInfo process,
      final NameInfo user,
      final NameInfo team,
      final Integer quantity,
      final Integer sort,
      final Boolean boolInspect
   ) {
      this.id = id;
      this.productionLine = productionLine;
      this.date = date;
      this.process = process;
      this.user = user;
      this.team = team;
      this.quantity = quantity;
      this.sort = sort;
      this.boolInspect = boolInspect;
   }

   public Long getId() {
      return this.id;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public NameInfo getProcess() {
      return this.process;
   }

   public NameInfo getUser() {
      return this.user;
   }

   public NameInfo getTeam() {
      return this.team;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getBoolInspect() {
      return this.boolInspect;
   }

   @JsonProperty("id")
   public NewArtifactReportSourceDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productionLine")
   public NewArtifactReportSourceDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("date")
   public NewArtifactReportSourceDTO setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   @JsonProperty("process")
   public NewArtifactReportSourceDTO setProcess(final NameInfo process) {
      this.process = process;
      return this;
   }

   @JsonProperty("user")
   public NewArtifactReportSourceDTO setUser(final NameInfo user) {
      this.user = user;
      return this;
   }

   @JsonProperty("team")
   public NewArtifactReportSourceDTO setTeam(final NameInfo team) {
      this.team = team;
      return this;
   }

   @JsonProperty("quantity")
   public NewArtifactReportSourceDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("sort")
   public NewArtifactReportSourceDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("boolInspect")
   public NewArtifactReportSourceDTO setBoolInspect(final Boolean boolInspect) {
      this.boolInspect = boolInspect;
      return this;
   }

   @Override
   public String toString() {
      return "NewArtifactReportSourceDTO(id="
         + this.getId()
         + ", productionLine="
         + this.getProductionLine()
         + ", date="
         + this.getDate()
         + ", process="
         + this.getProcess()
         + ", user="
         + this.getUser()
         + ", team="
         + this.getTeam()
         + ", quantity="
         + this.getQuantity()
         + ", sort="
         + this.getSort()
         + ", boolInspect="
         + this.getBoolInspect()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NewArtifactReportSourceDTO)) {
         return false;
      }

      NewArtifactReportSourceDTO other = (NewArtifactReportSourceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$boolInspect = this.getBoolInspect();
               Object other$boolInspect = other.getBoolInspect();
               if (this$boolInspect == null ? other$boolInspect == null : this$boolInspect.equals(other$boolInspect)) {
                  Object this$productionLine = this.getProductionLine();
                  Object other$productionLine = other.getProductionLine();
                  if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                     Object this$date = this.getDate();
                     Object other$date = other.getDate();
                     if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                        Object this$process = this.getProcess();
                        Object other$process = other.getProcess();
                        if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                           Object this$user = this.getUser();
                           Object other$user = other.getUser();
                           if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                              Object this$team = this.getTeam();
                              Object other$team = other.getTeam();
                              return this$team == null ? other$team == null : this$team.equals(other$team);
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
      return other instanceof NewArtifactReportSourceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $boolInspect = this.getBoolInspect();
      result = result * 59 + ($boolInspect == null ? 43 : $boolInspect.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $team = this.getTeam();
      return result * 59 + ($team == null ? 43 : $team.hashCode());
   }

   public static class NewArtifactReportSourceDTOBuilder {
      private Long id;
      private ProductionLineDetailDO productionLine;
      private LocalDateTime date;
      private NameInfo process;
      private NameInfo user;
      private NameInfo team;
      private Integer quantity;
      private Integer sort;
      private Boolean boolInspect;

      NewArtifactReportSourceDTOBuilder() {
      }

      @JsonProperty("id")
      public NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productionLine")
      public NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("date")
      public NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      @JsonProperty("process")
      public NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder process(final NameInfo process) {
         this.process = process;
         return this;
      }

      @JsonProperty("user")
      public NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder user(final NameInfo user) {
         this.user = user;
         return this;
      }

      @JsonProperty("team")
      public NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder team(final NameInfo team) {
         this.team = team;
         return this;
      }

      @JsonProperty("quantity")
      public NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("sort")
      public NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("boolInspect")
      public NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder boolInspect(final Boolean boolInspect) {
         this.boolInspect = boolInspect;
         return this;
      }

      public NewArtifactReportSourceDTO build() {
         return new NewArtifactReportSourceDTO(
            this.id, this.productionLine, this.date, this.process, this.user, this.team, this.quantity, this.sort, this.boolInspect
         );
      }

      @Override
      public String toString() {
         return "NewArtifactReportSourceDTO.NewArtifactReportSourceDTOBuilder(id="
            + this.id
            + ", productionLine="
            + this.productionLine
            + ", date="
            + this.date
            + ", process="
            + this.process
            + ", user="
            + this.user
            + ", team="
            + this.team
            + ", quantity="
            + this.quantity
            + ", sort="
            + this.sort
            + ", boolInspect="
            + this.boolInspect
            + ")";
      }
   }
}
