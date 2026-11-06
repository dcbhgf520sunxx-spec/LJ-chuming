package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectContentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@ApiModel(value = "ProjectDO", description = "项目基础信息")
public class ProjectDetailDO {
   @ApiModelProperty(name = "id", notes = "项目id", value = "项目id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectContent", notes = "项目内容", value = "项目内容")
   @JsonProperty("projectContent")
   @JSONField(name = "projectContent")
   private String projectContent;
   @ApiModelProperty(name = "name", notes = "项目名", value = "项目名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "项目编号", value = "项目编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "shortName", notes = "项目简称", value = "项目简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "type", notes = "项目类型", value = "项目类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "monomerList", notes = "单体信息", value = "单体信息")
   @JsonProperty("monomerList")
   @JSONField(name = "monomerList")
   @JsonInclude(Include.NON_NULL)
   private List<MonomerDetailDO> monomerList;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "总净重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "projectContentList", notes = "项目内容列表")
   private List<ProjectContentDTO> projectContentList;

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         ProjectDetailDO that = (ProjectDetailDO)o;
         return Objects.equals(this.id, that.getId()) && Objects.equals(this.name, that.getName());
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.id, this.name);
   }

   public static ProjectDetailDO.ProjectDetailDOBuilder builder() {
      return new ProjectDetailDO.ProjectDetailDOBuilder();
   }

   public ProjectDetailDO() {
   }

   public ProjectDetailDO(
      final Long id,
      final String projectContent,
      final String name,
      final String serialNumber,
      final String shortName,
      final Integer type,
      final List<MonomerDetailDO> monomerList,
      final Integer quantity,
      final BigDecimal netWeight,
      final List<ProjectContentDTO> projectContentList
   ) {
      this.id = id;
      this.projectContent = projectContent;
      this.name = name;
      this.serialNumber = serialNumber;
      this.shortName = shortName;
      this.type = type;
      this.monomerList = monomerList;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.projectContentList = projectContentList;
   }

   public Long getId() {
      return this.id;
   }

   public String getProjectContent() {
      return this.projectContent;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Integer getType() {
      return this.type;
   }

   public List<MonomerDetailDO> getMonomerList() {
      return this.monomerList;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public List<ProjectContentDTO> getProjectContentList() {
      return this.projectContentList;
   }

   @JsonProperty("id")
   public ProjectDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectContent")
   public ProjectDetailDO setProjectContent(final String projectContent) {
      this.projectContent = projectContent;
      return this;
   }

   @JsonProperty("name")
   public ProjectDetailDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProjectDetailDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("shortName")
   public ProjectDetailDO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("type")
   public ProjectDetailDO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("monomerList")
   public ProjectDetailDO setMonomerList(final List<MonomerDetailDO> monomerList) {
      this.monomerList = monomerList;
      return this;
   }

   @JsonProperty("quantity")
   public ProjectDetailDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public ProjectDetailDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public ProjectDetailDO setProjectContentList(final List<ProjectContentDTO> projectContentList) {
      this.projectContentList = projectContentList;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectDetailDO(id="
         + this.getId()
         + ", projectContent="
         + this.getProjectContent()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", shortName="
         + this.getShortName()
         + ", type="
         + this.getType()
         + ", monomerList="
         + this.getMonomerList()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", projectContentList="
         + this.getProjectContentList()
         + ")";
   }

   public static class ProjectDetailDOBuilder {
      private Long id;
      private String projectContent;
      private String name;
      private String serialNumber;
      private String shortName;
      private Integer type;
      private List<MonomerDetailDO> monomerList;
      private Integer quantity;
      private BigDecimal netWeight;
      private List<ProjectContentDTO> projectContentList;

      ProjectDetailDOBuilder() {
      }

      @JsonProperty("id")
      public ProjectDetailDO.ProjectDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectContent")
      public ProjectDetailDO.ProjectDetailDOBuilder projectContent(final String projectContent) {
         this.projectContent = projectContent;
         return this;
      }

      @JsonProperty("name")
      public ProjectDetailDO.ProjectDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectDetailDO.ProjectDetailDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("shortName")
      public ProjectDetailDO.ProjectDetailDOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("type")
      public ProjectDetailDO.ProjectDetailDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("monomerList")
      public ProjectDetailDO.ProjectDetailDOBuilder monomerList(final List<MonomerDetailDO> monomerList) {
         this.monomerList = monomerList;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectDetailDO.ProjectDetailDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ProjectDetailDO.ProjectDetailDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProjectDetailDO.ProjectDetailDOBuilder projectContentList(final List<ProjectContentDTO> projectContentList) {
         this.projectContentList = projectContentList;
         return this;
      }

      public ProjectDetailDO build() {
         return new ProjectDetailDO(
            this.id,
            this.projectContent,
            this.name,
            this.serialNumber,
            this.shortName,
            this.type,
            this.monomerList,
            this.quantity,
            this.netWeight,
            this.projectContentList
         );
      }

      @Override
      public String toString() {
         return "ProjectDetailDO.ProjectDetailDOBuilder(id="
            + this.id
            + ", projectContent="
            + this.projectContent
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", shortName="
            + this.shortName
            + ", type="
            + this.type
            + ", monomerList="
            + this.monomerList
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", projectContentList="
            + this.projectContentList
            + ")";
      }
   }
}
