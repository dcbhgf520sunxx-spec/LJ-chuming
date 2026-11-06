package com.hzchum.scim.mes.building.core.api.pojo._do.teamForm;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "TeamFormDO", description = "")
public class TeamFormEnclosureDetailsDO {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "areaDetail", notes = "区域")
   @JsonProperty("areaDetail")
   @JSONField(name = "areaDetail")
   private AreaDetailDO areaDetail;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "width", notes = "宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "thickness", notes = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskLength", notes = "任务长度")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "taskArea", notes = "任务面积")
   @JsonProperty("taskArea")
   @JSONField(name = "taskArea")
   private BigDecimal taskArea;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeLength", notes = "完成长度")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;
   @ApiModelProperty(name = "completeArea", notes = "完成面积")
   @JsonProperty("completeArea")
   @JSONField(name = "completeArea")
   private BigDecimal completeArea;
   @ApiModelProperty(name = "completeTime", notes = "完成面积")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;

   public static TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder builder() {
      return new TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder();
   }

   public TeamFormEnclosureDetailsDO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO areaDetail,
      final String name,
      final String serialNumber,
      final String plate,
      final String color,
      final String material,
      final BigDecimal width,
      final BigDecimal length,
      final Integer category,
      final BigDecimal thickness,
      final Integer taskQuantity,
      final BigDecimal taskLength,
      final BigDecimal taskArea,
      final Integer completeQuantity,
      final BigDecimal completeLength,
      final BigDecimal completeArea,
      final LocalDateTime completeTime
   ) {
      this.project = project;
      this.monomer = monomer;
      this.areaDetail = areaDetail;
      this.name = name;
      this.serialNumber = serialNumber;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.width = width;
      this.length = length;
      this.category = category;
      this.thickness = thickness;
      this.taskQuantity = taskQuantity;
      this.taskLength = taskLength;
      this.taskArea = taskArea;
      this.completeQuantity = completeQuantity;
      this.completeLength = completeLength;
      this.completeArea = completeArea;
      this.completeTime = completeTime;
   }

   public TeamFormEnclosureDetailsDO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getAreaDetail() {
      return this.areaDetail;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getCategory() {
      return this.category;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getTaskArea() {
      return this.taskArea;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public BigDecimal getCompleteArea() {
      return this.completeArea;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   @JsonProperty("project")
   public TeamFormEnclosureDetailsDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public TeamFormEnclosureDetailsDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public TeamFormEnclosureDetailsDO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("name")
   public TeamFormEnclosureDetailsDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public TeamFormEnclosureDetailsDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("plate")
   public TeamFormEnclosureDetailsDO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public TeamFormEnclosureDetailsDO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("material")
   public TeamFormEnclosureDetailsDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("width")
   public TeamFormEnclosureDetailsDO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("length")
   public TeamFormEnclosureDetailsDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("category")
   public TeamFormEnclosureDetailsDO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("thickness")
   public TeamFormEnclosureDetailsDO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("taskQuantity")
   public TeamFormEnclosureDetailsDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskLength")
   public TeamFormEnclosureDetailsDO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("taskArea")
   public TeamFormEnclosureDetailsDO setTaskArea(final BigDecimal taskArea) {
      this.taskArea = taskArea;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TeamFormEnclosureDetailsDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeLength")
   public TeamFormEnclosureDetailsDO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("completeArea")
   public TeamFormEnclosureDetailsDO setCompleteArea(final BigDecimal completeArea) {
      this.completeArea = completeArea;
      return this;
   }

   @JsonProperty("completeTime")
   public TeamFormEnclosureDetailsDO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @Override
   public String toString() {
      return "TeamFormEnclosureDetailsDO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", areaDetail="
         + this.getAreaDetail()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", category="
         + this.getCategory()
         + ", thickness="
         + this.getThickness()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskLength="
         + this.getTaskLength()
         + ", taskArea="
         + this.getTaskArea()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeLength="
         + this.getCompleteLength()
         + ", completeArea="
         + this.getCompleteArea()
         + ", completeTime="
         + this.getCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamFormEnclosureDetailsDO)) {
         return false;
      }

      TeamFormEnclosureDetailsDO other = (TeamFormEnclosureDetailsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$category = this.getCategory();
      Object other$category = other.getCategory();
      if (this$category == null ? other$category == null : this$category.equals(other$category)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$monomer = this.getMonomer();
                  Object other$monomer = other.getMonomer();
                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                     Object this$areaDetail = this.getAreaDetail();
                     Object other$areaDetail = other.getAreaDetail();
                     if (this$areaDetail == null ? other$areaDetail == null : this$areaDetail.equals(other$areaDetail)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$plate = this.getPlate();
                              Object other$plate = other.getPlate();
                              if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                 Object this$color = this.getColor();
                                 Object other$color = other.getColor();
                                 if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                       Object this$width = this.getWidth();
                                       Object other$width = other.getWidth();
                                       if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$thickness = this.getThickness();
                                             Object other$thickness = other.getThickness();
                                             if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                Object this$taskLength = this.getTaskLength();
                                                Object other$taskLength = other.getTaskLength();
                                                if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
                                                   Object this$taskArea = this.getTaskArea();
                                                   Object other$taskArea = other.getTaskArea();
                                                   if (this$taskArea == null ? other$taskArea == null : this$taskArea.equals(other$taskArea)) {
                                                      Object this$completeLength = this.getCompleteLength();
                                                      Object other$completeLength = other.getCompleteLength();
                                                      if (this$completeLength == null
                                                         ? other$completeLength == null
                                                         : this$completeLength.equals(other$completeLength)) {
                                                         Object this$completeArea = this.getCompleteArea();
                                                         Object other$completeArea = other.getCompleteArea();
                                                         if (this$completeArea == null
                                                            ? other$completeArea == null
                                                            : this$completeArea.equals(other$completeArea)) {
                                                            Object this$completeTime = this.getCompleteTime();
                                                            Object other$completeTime = other.getCompleteTime();
                                                            return this$completeTime == null
                                                               ? other$completeTime == null
                                                               : this$completeTime.equals(other$completeTime);
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
      return other instanceof TeamFormEnclosureDetailsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $areaDetail = this.getAreaDetail();
      result = result * 59 + ($areaDetail == null ? 43 : $areaDetail.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $taskArea = this.getTaskArea();
      result = result * 59 + ($taskArea == null ? 43 : $taskArea.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $completeArea = this.getCompleteArea();
      result = result * 59 + ($completeArea == null ? 43 : $completeArea.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class TeamFormEnclosureDetailsDOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO areaDetail;
      private String name;
      private String serialNumber;
      private String plate;
      private String color;
      private String material;
      private BigDecimal width;
      private BigDecimal length;
      private Integer category;
      private BigDecimal thickness;
      private Integer taskQuantity;
      private BigDecimal taskLength;
      private BigDecimal taskArea;
      private Integer completeQuantity;
      private BigDecimal completeLength;
      private BigDecimal completeArea;
      private LocalDateTime completeTime;

      TeamFormEnclosureDetailsDOBuilder() {
      }

      @JsonProperty("project")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("name")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("plate")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("material")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("width")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("length")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("category")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("thickness")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("taskQuantity")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskLength")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("taskArea")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder taskArea(final BigDecimal taskArea) {
         this.taskArea = taskArea;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeLength")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("completeArea")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder completeArea(final BigDecimal completeArea) {
         this.completeArea = completeArea;
         return this;
      }

      @JsonProperty("completeTime")
      public TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      public TeamFormEnclosureDetailsDO build() {
         return new TeamFormEnclosureDetailsDO(
            this.project,
            this.monomer,
            this.areaDetail,
            this.name,
            this.serialNumber,
            this.plate,
            this.color,
            this.material,
            this.width,
            this.length,
            this.category,
            this.thickness,
            this.taskQuantity,
            this.taskLength,
            this.taskArea,
            this.completeQuantity,
            this.completeLength,
            this.completeArea,
            this.completeTime
         );
      }

      @Override
      public String toString() {
         return "TeamFormEnclosureDetailsDO.TeamFormEnclosureDetailsDOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", areaDetail="
            + this.areaDetail
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", material="
            + this.material
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", category="
            + this.category
            + ", thickness="
            + this.thickness
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskLength="
            + this.taskLength
            + ", taskArea="
            + this.taskArea
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeLength="
            + this.completeLength
            + ", completeArea="
            + this.completeArea
            + ", completeTime="
            + this.completeTime
            + ")";
      }
   }
}
