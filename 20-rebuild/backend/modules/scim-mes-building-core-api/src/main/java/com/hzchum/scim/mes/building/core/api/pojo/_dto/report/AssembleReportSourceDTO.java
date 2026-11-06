package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "ArtifactReportSourceDTO", description = "产品溯源生产上报类 ")
public class AssembleReportSourceDTO {
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
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private NameInfo groups;
   @ApiModelProperty(name = "user", notes = "上报人")
   @JsonProperty("user")
   @JSONField(name = "user")
   private NameInfo user;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "sort", notes = "顺序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;

   public static AssembleReportSourceDTO.AssembleReportSourceDTOBuilder builder() {
      return new AssembleReportSourceDTO.AssembleReportSourceDTOBuilder();
   }

   public AssembleReportSourceDTO() {
   }

   public AssembleReportSourceDTO(
      final Long id,
      final ProductionLineDetailDO productionLine,
      final LocalDateTime date,
      final NameInfo process,
      final NameInfo groups,
      final NameInfo user,
      final Integer quantity,
      final Integer sort
   ) {
      this.id = id;
      this.productionLine = productionLine;
      this.date = date;
      this.process = process;
      this.groups = groups;
      this.user = user;
      this.quantity = quantity;
      this.sort = sort;
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

   public NameInfo getGroups() {
      return this.groups;
   }

   public NameInfo getUser() {
      return this.user;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getSort() {
      return this.sort;
   }

   @JsonProperty("id")
   public AssembleReportSourceDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productionLine")
   public AssembleReportSourceDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("date")
   public AssembleReportSourceDTO setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   @JsonProperty("process")
   public AssembleReportSourceDTO setProcess(final NameInfo process) {
      this.process = process;
      return this;
   }

   @JsonProperty("groups")
   public AssembleReportSourceDTO setGroups(final NameInfo groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("user")
   public AssembleReportSourceDTO setUser(final NameInfo user) {
      this.user = user;
      return this;
   }

   @JsonProperty("quantity")
   public AssembleReportSourceDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("sort")
   public AssembleReportSourceDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "AssembleReportSourceDTO(id="
         + this.getId()
         + ", productionLine="
         + this.getProductionLine()
         + ", date="
         + this.getDate()
         + ", process="
         + this.getProcess()
         + ", groups="
         + this.getGroups()
         + ", user="
         + this.getUser()
         + ", quantity="
         + this.getQuantity()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleReportSourceDTO)) {
         return false;
      }

      AssembleReportSourceDTO other = (AssembleReportSourceDTO)o;
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
               Object this$productionLine = this.getProductionLine();
               Object other$productionLine = other.getProductionLine();
               if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                  Object this$date = this.getDate();
                  Object other$date = other.getDate();
                  if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                     Object this$process = this.getProcess();
                     Object other$process = other.getProcess();
                     if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                        Object this$groups = this.getGroups();
                        Object other$groups = other.getGroups();
                        if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                           Object this$user = this.getUser();
                           Object other$user = other.getUser();
                           return this$user == null ? other$user == null : this$user.equals(other$user);
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
      return other instanceof AssembleReportSourceDTO;
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
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $user = this.getUser();
      return result * 59 + ($user == null ? 43 : $user.hashCode());
   }

   public static class AssembleReportSourceDTOBuilder {
      private Long id;
      private ProductionLineDetailDO productionLine;
      private LocalDateTime date;
      private NameInfo process;
      private NameInfo groups;
      private NameInfo user;
      private Integer quantity;
      private Integer sort;

      AssembleReportSourceDTOBuilder() {
      }

      @JsonProperty("id")
      public AssembleReportSourceDTO.AssembleReportSourceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productionLine")
      public AssembleReportSourceDTO.AssembleReportSourceDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("date")
      public AssembleReportSourceDTO.AssembleReportSourceDTOBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      @JsonProperty("process")
      public AssembleReportSourceDTO.AssembleReportSourceDTOBuilder process(final NameInfo process) {
         this.process = process;
         return this;
      }

      @JsonProperty("groups")
      public AssembleReportSourceDTO.AssembleReportSourceDTOBuilder groups(final NameInfo groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("user")
      public AssembleReportSourceDTO.AssembleReportSourceDTOBuilder user(final NameInfo user) {
         this.user = user;
         return this;
      }

      @JsonProperty("quantity")
      public AssembleReportSourceDTO.AssembleReportSourceDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("sort")
      public AssembleReportSourceDTO.AssembleReportSourceDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public AssembleReportSourceDTO build() {
         return new AssembleReportSourceDTO(this.id, this.productionLine, this.date, this.process, this.groups, this.user, this.quantity, this.sort);
      }

      @Override
      public String toString() {
         return "AssembleReportSourceDTO.AssembleReportSourceDTOBuilder(id="
            + this.id
            + ", productionLine="
            + this.productionLine
            + ", date="
            + this.date
            + ", process="
            + this.process
            + ", groups="
            + this.groups
            + ", user="
            + this.user
            + ", quantity="
            + this.quantity
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
