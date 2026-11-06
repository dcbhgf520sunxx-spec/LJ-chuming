package com.hzchum.scim.plan.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MonomerInfoDTO {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name")
   @JsonProperty("name")
   @JSONField(name = "name")
   @JsonInclude(Include.NON_NULL)
   private String name;
   @ApiModelProperty(name = "startDate", value = "计划结束日期", notes = "计划结束日期")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   @JsonInclude(Include.NON_NULL)
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "计划结束日期", notes = "计划结束日期")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   @JsonInclude(Include.NON_NULL)
   private LocalDate endDate;
   @ApiModelProperty(name = "projectId")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @JsonInclude(Include.NON_NULL)
   private Long projectId;
   @ApiModelProperty(name = "areaList", value = "区域", notes = "区域")
   @JsonProperty("areaList")
   @JSONField(name = "areaList")
   @JsonInclude(Include.NON_NULL)
   private List<AreaInfoDTO> areaList;
   @ApiModelProperty(name = "artifactQuantity", notes = "构件数量")
   @JsonProperty("artifactQuantity")
   @JSONField(name = "artifactQuantity")
   @JsonInclude(Include.NON_NULL)
   private Integer artifactQuantity;
   @ApiModelProperty(name = "artifactMete", notes = "构件量")
   @JsonProperty("artifactMete")
   @JSONField(name = "artifactMete")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal artifactMete;
   @ApiModelProperty(name = "artifactInstallQuantity", notes = "构件数量")
   @JsonProperty("artifactInstallQuantity")
   @JSONField(name = "artifactInstallQuantity")
   @JsonInclude(Include.NON_NULL)
   private Integer artifactInstallQuantity;
   @ApiModelProperty(name = "artifactInstallMete", notes = "构件量")
   @JsonProperty("artifactInstallMete")
   @JSONField(name = "artifactInstallMete")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal artifactInstallMete;
   @ApiModelProperty(name = "enclosureQuantity", notes = "构件数量")
   @JsonProperty("enclosureQuantity")
   @JSONField(name = "enclosureQuantity")
   @JsonInclude(Include.NON_NULL)
   private Integer enclosureQuantity;
   @ApiModelProperty(name = "enclosureMete", notes = "构件量")
   @JsonProperty("enclosureMete")
   @JSONField(name = "enclosureMete")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal enclosureMete;
   @ApiModelProperty(name = "enclosureInstallQuantity", notes = "构件数量")
   @JsonProperty("enclosureInstallQuantity")
   @JSONField(name = "enclosureInstallQuantity")
   @JsonInclude(Include.NON_NULL)
   private Integer enclosureInstallQuantity;
   @ApiModelProperty(name = "enclosureInstallMete", notes = "构件量")
   @JsonProperty("enclosureInstallMete")
   @JSONField(name = "enclosureInstallMete")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal enclosureInstallMete;

   public static MonomerInfoDTO.MonomerInfoDTOBuilder builder() {
      return new MonomerInfoDTO.MonomerInfoDTOBuilder();
   }

   public MonomerInfoDTO() {
   }

   public MonomerInfoDTO(
      final Long id,
      final String name,
      final LocalDate startDate,
      final LocalDate endDate,
      final Long projectId,
      final List<AreaInfoDTO> areaList,
      final Integer artifactQuantity,
      final BigDecimal artifactMete,
      final Integer artifactInstallQuantity,
      final BigDecimal artifactInstallMete,
      final Integer enclosureQuantity,
      final BigDecimal enclosureMete,
      final Integer enclosureInstallQuantity,
      final BigDecimal enclosureInstallMete
   ) {
      this.id = id;
      this.name = name;
      this.startDate = startDate;
      this.endDate = endDate;
      this.projectId = projectId;
      this.areaList = areaList;
      this.artifactQuantity = artifactQuantity;
      this.artifactMete = artifactMete;
      this.artifactInstallQuantity = artifactInstallQuantity;
      this.artifactInstallMete = artifactInstallMete;
      this.enclosureQuantity = enclosureQuantity;
      this.enclosureMete = enclosureMete;
      this.enclosureInstallQuantity = enclosureInstallQuantity;
      this.enclosureInstallMete = enclosureInstallMete;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<AreaInfoDTO> getAreaList() {
      return this.areaList;
   }

   public Integer getArtifactQuantity() {
      return this.artifactQuantity;
   }

   public BigDecimal getArtifactMete() {
      return this.artifactMete;
   }

   public Integer getArtifactInstallQuantity() {
      return this.artifactInstallQuantity;
   }

   public BigDecimal getArtifactInstallMete() {
      return this.artifactInstallMete;
   }

   public Integer getEnclosureQuantity() {
      return this.enclosureQuantity;
   }

   public BigDecimal getEnclosureMete() {
      return this.enclosureMete;
   }

   public Integer getEnclosureInstallQuantity() {
      return this.enclosureInstallQuantity;
   }

   public BigDecimal getEnclosureInstallMete() {
      return this.enclosureInstallMete;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("startDate")
   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   @JsonProperty("endDate")
   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   @JsonProperty("projectId")
   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @JsonProperty("areaList")
   public void setAreaList(final List<AreaInfoDTO> areaList) {
      this.areaList = areaList;
   }

   @JsonProperty("artifactQuantity")
   public void setArtifactQuantity(final Integer artifactQuantity) {
      this.artifactQuantity = artifactQuantity;
   }

   @JsonProperty("artifactMete")
   public void setArtifactMete(final BigDecimal artifactMete) {
      this.artifactMete = artifactMete;
   }

   @JsonProperty("artifactInstallQuantity")
   public void setArtifactInstallQuantity(final Integer artifactInstallQuantity) {
      this.artifactInstallQuantity = artifactInstallQuantity;
   }

   @JsonProperty("artifactInstallMete")
   public void setArtifactInstallMete(final BigDecimal artifactInstallMete) {
      this.artifactInstallMete = artifactInstallMete;
   }

   @JsonProperty("enclosureQuantity")
   public void setEnclosureQuantity(final Integer enclosureQuantity) {
      this.enclosureQuantity = enclosureQuantity;
   }

   @JsonProperty("enclosureMete")
   public void setEnclosureMete(final BigDecimal enclosureMete) {
      this.enclosureMete = enclosureMete;
   }

   @JsonProperty("enclosureInstallQuantity")
   public void setEnclosureInstallQuantity(final Integer enclosureInstallQuantity) {
      this.enclosureInstallQuantity = enclosureInstallQuantity;
   }

   @JsonProperty("enclosureInstallMete")
   public void setEnclosureInstallMete(final BigDecimal enclosureInstallMete) {
      this.enclosureInstallMete = enclosureInstallMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonomerInfoDTO)) {
         return false;
      }

      MonomerInfoDTO other = (MonomerInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$artifactQuantity = this.getArtifactQuantity();
            Object other$artifactQuantity = other.getArtifactQuantity();
            if (this$artifactQuantity == null ? other$artifactQuantity == null : this$artifactQuantity.equals(other$artifactQuantity)) {
               Object this$artifactInstallQuantity = this.getArtifactInstallQuantity();
               Object other$artifactInstallQuantity = other.getArtifactInstallQuantity();
               if (this$artifactInstallQuantity == null
                  ? other$artifactInstallQuantity == null
                  : this$artifactInstallQuantity.equals(other$artifactInstallQuantity)) {
                  Object this$enclosureQuantity = this.getEnclosureQuantity();
                  Object other$enclosureQuantity = other.getEnclosureQuantity();
                  if (this$enclosureQuantity == null ? other$enclosureQuantity == null : this$enclosureQuantity.equals(other$enclosureQuantity)) {
                     Object this$enclosureInstallQuantity = this.getEnclosureInstallQuantity();
                     Object other$enclosureInstallQuantity = other.getEnclosureInstallQuantity();
                     if (this$enclosureInstallQuantity == null
                        ? other$enclosureInstallQuantity == null
                        : this$enclosureInstallQuantity.equals(other$enclosureInstallQuantity)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$startDate = this.getStartDate();
                           Object other$startDate = other.getStartDate();
                           if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                              Object this$endDate = this.getEndDate();
                              Object other$endDate = other.getEndDate();
                              if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                 Object this$areaList = this.getAreaList();
                                 Object other$areaList = other.getAreaList();
                                 if (this$areaList == null ? other$areaList == null : this$areaList.equals(other$areaList)) {
                                    Object this$artifactMete = this.getArtifactMete();
                                    Object other$artifactMete = other.getArtifactMete();
                                    if (this$artifactMete == null ? other$artifactMete == null : this$artifactMete.equals(other$artifactMete)) {
                                       Object this$artifactInstallMete = this.getArtifactInstallMete();
                                       Object other$artifactInstallMete = other.getArtifactInstallMete();
                                       if (this$artifactInstallMete == null
                                          ? other$artifactInstallMete == null
                                          : this$artifactInstallMete.equals(other$artifactInstallMete)) {
                                          Object this$enclosureMete = this.getEnclosureMete();
                                          Object other$enclosureMete = other.getEnclosureMete();
                                          if (this$enclosureMete == null ? other$enclosureMete == null : this$enclosureMete.equals(other$enclosureMete)) {
                                             Object this$enclosureInstallMete = this.getEnclosureInstallMete();
                                             Object other$enclosureInstallMete = other.getEnclosureInstallMete();
                                             return this$enclosureInstallMete == null
                                                ? other$enclosureInstallMete == null
                                                : this$enclosureInstallMete.equals(other$enclosureInstallMete);
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
      return other instanceof MonomerInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $artifactQuantity = this.getArtifactQuantity();
      result = result * 59 + ($artifactQuantity == null ? 43 : $artifactQuantity.hashCode());
      Object $artifactInstallQuantity = this.getArtifactInstallQuantity();
      result = result * 59 + ($artifactInstallQuantity == null ? 43 : $artifactInstallQuantity.hashCode());
      Object $enclosureQuantity = this.getEnclosureQuantity();
      result = result * 59 + ($enclosureQuantity == null ? 43 : $enclosureQuantity.hashCode());
      Object $enclosureInstallQuantity = this.getEnclosureInstallQuantity();
      result = result * 59 + ($enclosureInstallQuantity == null ? 43 : $enclosureInstallQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $areaList = this.getAreaList();
      result = result * 59 + ($areaList == null ? 43 : $areaList.hashCode());
      Object $artifactMete = this.getArtifactMete();
      result = result * 59 + ($artifactMete == null ? 43 : $artifactMete.hashCode());
      Object $artifactInstallMete = this.getArtifactInstallMete();
      result = result * 59 + ($artifactInstallMete == null ? 43 : $artifactInstallMete.hashCode());
      Object $enclosureMete = this.getEnclosureMete();
      result = result * 59 + ($enclosureMete == null ? 43 : $enclosureMete.hashCode());
      Object $enclosureInstallMete = this.getEnclosureInstallMete();
      return result * 59 + ($enclosureInstallMete == null ? 43 : $enclosureInstallMete.hashCode());
   }

   @Override
   public String toString() {
      return "MonomerInfoDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectId="
         + this.getProjectId()
         + ", areaList="
         + this.getAreaList()
         + ", artifactQuantity="
         + this.getArtifactQuantity()
         + ", artifactMete="
         + this.getArtifactMete()
         + ", artifactInstallQuantity="
         + this.getArtifactInstallQuantity()
         + ", artifactInstallMete="
         + this.getArtifactInstallMete()
         + ", enclosureQuantity="
         + this.getEnclosureQuantity()
         + ", enclosureMete="
         + this.getEnclosureMete()
         + ", enclosureInstallQuantity="
         + this.getEnclosureInstallQuantity()
         + ", enclosureInstallMete="
         + this.getEnclosureInstallMete()
         + ")";
   }

   public static class MonomerInfoDTOBuilder {
      private Long id;
      private String name;
      private LocalDate startDate;
      private LocalDate endDate;
      private Long projectId;
      private List<AreaInfoDTO> areaList;
      private Integer artifactQuantity;
      private BigDecimal artifactMete;
      private Integer artifactInstallQuantity;
      private BigDecimal artifactInstallMete;
      private Integer enclosureQuantity;
      private BigDecimal enclosureMete;
      private Integer enclosureInstallQuantity;
      private BigDecimal enclosureInstallMete;

      MonomerInfoDTOBuilder() {
      }

      @JsonProperty("id")
      public MonomerInfoDTO.MonomerInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MonomerInfoDTO.MonomerInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("startDate")
      public MonomerInfoDTO.MonomerInfoDTOBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public MonomerInfoDTO.MonomerInfoDTOBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("projectId")
      public MonomerInfoDTO.MonomerInfoDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("areaList")
      public MonomerInfoDTO.MonomerInfoDTOBuilder areaList(final List<AreaInfoDTO> areaList) {
         this.areaList = areaList;
         return this;
      }

      @JsonProperty("artifactQuantity")
      public MonomerInfoDTO.MonomerInfoDTOBuilder artifactQuantity(final Integer artifactQuantity) {
         this.artifactQuantity = artifactQuantity;
         return this;
      }

      @JsonProperty("artifactMete")
      public MonomerInfoDTO.MonomerInfoDTOBuilder artifactMete(final BigDecimal artifactMete) {
         this.artifactMete = artifactMete;
         return this;
      }

      @JsonProperty("artifactInstallQuantity")
      public MonomerInfoDTO.MonomerInfoDTOBuilder artifactInstallQuantity(final Integer artifactInstallQuantity) {
         this.artifactInstallQuantity = artifactInstallQuantity;
         return this;
      }

      @JsonProperty("artifactInstallMete")
      public MonomerInfoDTO.MonomerInfoDTOBuilder artifactInstallMete(final BigDecimal artifactInstallMete) {
         this.artifactInstallMete = artifactInstallMete;
         return this;
      }

      @JsonProperty("enclosureQuantity")
      public MonomerInfoDTO.MonomerInfoDTOBuilder enclosureQuantity(final Integer enclosureQuantity) {
         this.enclosureQuantity = enclosureQuantity;
         return this;
      }

      @JsonProperty("enclosureMete")
      public MonomerInfoDTO.MonomerInfoDTOBuilder enclosureMete(final BigDecimal enclosureMete) {
         this.enclosureMete = enclosureMete;
         return this;
      }

      @JsonProperty("enclosureInstallQuantity")
      public MonomerInfoDTO.MonomerInfoDTOBuilder enclosureInstallQuantity(final Integer enclosureInstallQuantity) {
         this.enclosureInstallQuantity = enclosureInstallQuantity;
         return this;
      }

      @JsonProperty("enclosureInstallMete")
      public MonomerInfoDTO.MonomerInfoDTOBuilder enclosureInstallMete(final BigDecimal enclosureInstallMete) {
         this.enclosureInstallMete = enclosureInstallMete;
         return this;
      }

      public MonomerInfoDTO build() {
         return new MonomerInfoDTO(
            this.id,
            this.name,
            this.startDate,
            this.endDate,
            this.projectId,
            this.areaList,
            this.artifactQuantity,
            this.artifactMete,
            this.artifactInstallQuantity,
            this.artifactInstallMete,
            this.enclosureQuantity,
            this.enclosureMete,
            this.enclosureInstallQuantity,
            this.enclosureInstallMete
         );
      }

      @Override
      public String toString() {
         return "MonomerInfoDTO.MonomerInfoDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", projectId="
            + this.projectId
            + ", areaList="
            + this.areaList
            + ", artifactQuantity="
            + this.artifactQuantity
            + ", artifactMete="
            + this.artifactMete
            + ", artifactInstallQuantity="
            + this.artifactInstallQuantity
            + ", artifactInstallMete="
            + this.artifactInstallMete
            + ", enclosureQuantity="
            + this.enclosureQuantity
            + ", enclosureMete="
            + this.enclosureMete
            + ", enclosureInstallQuantity="
            + this.enclosureInstallQuantity
            + ", enclosureInstallMete="
            + this.enclosureInstallMete
            + ")";
      }
   }
}
