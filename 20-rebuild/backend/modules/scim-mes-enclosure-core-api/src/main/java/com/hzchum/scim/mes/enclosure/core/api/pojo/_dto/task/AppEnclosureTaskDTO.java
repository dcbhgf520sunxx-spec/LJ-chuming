package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureTeamDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosurePlanDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;

@ApiModel(value = "AppTaskProcessDO", description = "用户可上报的工序类 ")
public class AppEnclosureTaskDTO {
   @ApiModelProperty(name = "id", notes = "任务id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "orderNumber", notes = "任务工单")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   @JsonInclude(Include.NON_NULL)
   private String orderNumber;
   @ApiModelProperty(name = "orderId", notes = "工单id")
   @JsonProperty("orderId")
   @JSONField(name = "orderId")
   private String orderId;
   @ApiModelProperty(name = "factory", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   @JsonInclude(Include.NON_NULL)
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   @JsonInclude(Include.NON_NULL)
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   @JsonInclude(Include.NON_NULL)
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "teams", notes = "班组")
   @JsonProperty("teams")
   @JSONField(name = "teams")
   private MesEnclosureTeamDTO teams;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private NameInfo monomer;
   @ApiModelProperty(name = "plan", notes = "区域")
   @JsonProperty("plan")
   @JSONField(name = "plan")
   private EnclosurePlanDTO plan;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaInfoDTO area;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "taskQuantity", notes = "总任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "canReportQuantity", notes = "可上报数")
   @JsonProperty("canReportQuantity")
   @JSONField(name = "canReportQuantity")
   private Integer canReportQuantity;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "plate", value = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   @TableField("plate")
   @Column(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color")
   private String color;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material")
   private String material;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "coating", value = "涂层")
   @JsonProperty("coating")
   @JSONField(name = "coating")
   @TableField("coating")
   @Column(name = "coating")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   @JsonProperty("plating")
   @JSONField(name = "plating")
   @TableField("plating")
   @Column(name = "plating")
   private String plating;

   public static AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder builder() {
      return new AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder();
   }

   public AppEnclosureTaskDTO() {
   }

   public AppEnclosureTaskDTO(
      final Long id,
      final ProjectDetailDO project,
      final String orderNumber,
      final String orderId,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final MesEnclosureTeamDTO teams,
      final NameInfo monomer,
      final EnclosurePlanDTO plan,
      final AreaInfoDTO area,
      final Long productId,
      final String name,
      final BigDecimal length,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final Integer canReportQuantity,
      final IdAndNameDO process,
      final LocalDateTime askCompleteTime,
      final String serialNumber,
      final Integer category,
      final String plate,
      final String color,
      final String material,
      final BigDecimal thickness,
      final String coating,
      final String plating
   ) {
      this.id = id;
      this.project = project;
      this.orderNumber = orderNumber;
      this.orderId = orderId;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.teams = teams;
      this.monomer = monomer;
      this.plan = plan;
      this.area = area;
      this.productId = productId;
      this.name = name;
      this.length = length;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.canReportQuantity = canReportQuantity;
      this.process = process;
      this.askCompleteTime = askCompleteTime;
      this.serialNumber = serialNumber;
      this.category = category;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.thickness = thickness;
      this.coating = coating;
      this.plating = plating;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getOrderId() {
      return this.orderId;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public MesEnclosureTeamDTO getTeams() {
      return this.teams;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public EnclosurePlanDTO getPlan() {
      return this.plan;
   }

   public AreaInfoDTO getArea() {
      return this.area;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getCanReportQuantity() {
      return this.canReportQuantity;
   }

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getCategory() {
      return this.category;
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

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getCoating() {
      return this.coating;
   }

   public String getPlating() {
      return this.plating;
   }

   @JsonProperty("id")
   public AppEnclosureTaskDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public AppEnclosureTaskDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("orderNumber")
   public AppEnclosureTaskDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("orderId")
   public AppEnclosureTaskDTO setOrderId(final String orderId) {
      this.orderId = orderId;
      return this;
   }

   @JsonProperty("factory")
   public AppEnclosureTaskDTO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public AppEnclosureTaskDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AppEnclosureTaskDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("teams")
   public AppEnclosureTaskDTO setTeams(final MesEnclosureTeamDTO teams) {
      this.teams = teams;
      return this;
   }

   @JsonProperty("monomer")
   public AppEnclosureTaskDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("plan")
   public AppEnclosureTaskDTO setPlan(final EnclosurePlanDTO plan) {
      this.plan = plan;
      return this;
   }

   @JsonProperty("area")
   public AppEnclosureTaskDTO setArea(final AreaInfoDTO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("productId")
   public AppEnclosureTaskDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("name")
   public AppEnclosureTaskDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("length")
   public AppEnclosureTaskDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("taskQuantity")
   public AppEnclosureTaskDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public AppEnclosureTaskDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("canReportQuantity")
   public AppEnclosureTaskDTO setCanReportQuantity(final Integer canReportQuantity) {
      this.canReportQuantity = canReportQuantity;
      return this;
   }

   @JsonProperty("process")
   public AppEnclosureTaskDTO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AppEnclosureTaskDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("serialNumber")
   public AppEnclosureTaskDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("category")
   public AppEnclosureTaskDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("plate")
   public AppEnclosureTaskDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public AppEnclosureTaskDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("material")
   public AppEnclosureTaskDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("thickness")
   public AppEnclosureTaskDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("coating")
   public AppEnclosureTaskDTO setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   @JsonProperty("plating")
   public AppEnclosureTaskDTO setPlating(final String plating) {
      this.plating = plating;
      return this;
   }

   @Override
   public String toString() {
      return "AppEnclosureTaskDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", orderId="
         + this.getOrderId()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", teams="
         + this.getTeams()
         + ", monomer="
         + this.getMonomer()
         + ", plan="
         + this.getPlan()
         + ", area="
         + this.getArea()
         + ", productId="
         + this.getProductId()
         + ", name="
         + this.getName()
         + ", length="
         + this.getLength()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", canReportQuantity="
         + this.getCanReportQuantity()
         + ", process="
         + this.getProcess()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", category="
         + this.getCategory()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppEnclosureTaskDTO)) {
         return false;
      }

      AppEnclosureTaskDTO other = (AppEnclosureTaskDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$taskQuantity = this.getTaskQuantity();
            Object other$taskQuantity = other.getTaskQuantity();
            if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
               Object this$completeQuantity = this.getCompleteQuantity();
               Object other$completeQuantity = other.getCompleteQuantity();
               if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                  Object this$canReportQuantity = this.getCanReportQuantity();
                  Object other$canReportQuantity = other.getCanReportQuantity();
                  if (this$canReportQuantity == null ? other$canReportQuantity == null : this$canReportQuantity.equals(other$canReportQuantity)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$orderNumber = this.getOrderNumber();
                           Object other$orderNumber = other.getOrderNumber();
                           if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                              Object this$orderId = this.getOrderId();
                              Object other$orderId = other.getOrderId();
                              if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
                                 Object this$factory = this.getFactory();
                                 Object other$factory = other.getFactory();
                                 if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                                    Object this$workshop = this.getWorkshop();
                                    Object other$workshop = other.getWorkshop();
                                    if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                       Object this$productionLine = this.getProductionLine();
                                       Object other$productionLine = other.getProductionLine();
                                       if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                          Object this$teams = this.getTeams();
                                          Object other$teams = other.getTeams();
                                          if (this$teams == null ? other$teams == null : this$teams.equals(other$teams)) {
                                             Object this$monomer = this.getMonomer();
                                             Object other$monomer = other.getMonomer();
                                             if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                Object this$plan = this.getPlan();
                                                Object other$plan = other.getPlan();
                                                if (this$plan == null ? other$plan == null : this$plan.equals(other$plan)) {
                                                   Object this$area = this.getArea();
                                                   Object other$area = other.getArea();
                                                   if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                      Object this$name = this.getName();
                                                      Object other$name = other.getName();
                                                      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                         Object this$length = this.getLength();
                                                         Object other$length = other.getLength();
                                                         if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                            Object this$process = this.getProcess();
                                                            Object other$process = other.getProcess();
                                                            if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                                               Object this$askCompleteTime = this.getAskCompleteTime();
                                                               Object other$askCompleteTime = other.getAskCompleteTime();
                                                               if (this$askCompleteTime == null
                                                                  ? other$askCompleteTime == null
                                                                  : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                  Object this$serialNumber = this.getSerialNumber();
                                                                  Object other$serialNumber = other.getSerialNumber();
                                                                  if (this$serialNumber == null
                                                                     ? other$serialNumber == null
                                                                     : this$serialNumber.equals(other$serialNumber)) {
                                                                     Object this$plate = this.getPlate();
                                                                     Object other$plate = other.getPlate();
                                                                     if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                                                        Object this$color = this.getColor();
                                                                        Object other$color = other.getColor();
                                                                        if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                           Object this$material = this.getMaterial();
                                                                           Object other$material = other.getMaterial();
                                                                           if (this$material == null
                                                                              ? other$material == null
                                                                              : this$material.equals(other$material)) {
                                                                              Object this$thickness = this.getThickness();
                                                                              Object other$thickness = other.getThickness();
                                                                              if (this$thickness == null
                                                                                 ? other$thickness == null
                                                                                 : this$thickness.equals(other$thickness)) {
                                                                                 Object this$coating = this.getCoating();
                                                                                 Object other$coating = other.getCoating();
                                                                                 if (this$coating == null
                                                                                    ? other$coating == null
                                                                                    : this$coating.equals(other$coating)) {
                                                                                    Object this$plating = this.getPlating();
                                                                                    Object other$plating = other.getPlating();
                                                                                    return this$plating == null
                                                                                       ? other$plating == null
                                                                                       : this$plating.equals(other$plating);
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
      return other instanceof AppEnclosureTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $canReportQuantity = this.getCanReportQuantity();
      result = result * 59 + ($canReportQuantity == null ? 43 : $canReportQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $teams = this.getTeams();
      result = result * 59 + ($teams == null ? 43 : $teams.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $plan = this.getPlan();
      result = result * 59 + ($plan == null ? 43 : $plan.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      return result * 59 + ($plating == null ? 43 : $plating.hashCode());
   }

   public static class AppEnclosureTaskDTOBuilder {
      private Long id;
      private ProjectDetailDO project;
      private String orderNumber;
      private String orderId;
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private MesEnclosureTeamDTO teams;
      private NameInfo monomer;
      private EnclosurePlanDTO plan;
      private AreaInfoDTO area;
      private Long productId;
      private String name;
      private BigDecimal length;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private Integer canReportQuantity;
      private IdAndNameDO process;
      private LocalDateTime askCompleteTime;
      private String serialNumber;
      private Integer category;
      private String plate;
      private String color;
      private String material;
      private BigDecimal thickness;
      private String coating;
      private String plating;

      AppEnclosureTaskDTOBuilder() {
      }

      @JsonProperty("id")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("orderNumber")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("orderId")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder orderId(final String orderId) {
         this.orderId = orderId;
         return this;
      }

      @JsonProperty("factory")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("teams")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder teams(final MesEnclosureTeamDTO teams) {
         this.teams = teams;
         return this;
      }

      @JsonProperty("monomer")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("plan")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder plan(final EnclosurePlanDTO plan) {
         this.plan = plan;
         return this;
      }

      @JsonProperty("area")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder area(final AreaInfoDTO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("productId")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("name")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("length")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("taskQuantity")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("canReportQuantity")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder canReportQuantity(final Integer canReportQuantity) {
         this.canReportQuantity = canReportQuantity;
         return this;
      }

      @JsonProperty("process")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("serialNumber")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("category")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("plate")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("material")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("thickness")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("coating")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      @JsonProperty("plating")
      public AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      public AppEnclosureTaskDTO build() {
         return new AppEnclosureTaskDTO(
            this.id,
            this.project,
            this.orderNumber,
            this.orderId,
            this.factory,
            this.workshop,
            this.productionLine,
            this.teams,
            this.monomer,
            this.plan,
            this.area,
            this.productId,
            this.name,
            this.length,
            this.taskQuantity,
            this.completeQuantity,
            this.canReportQuantity,
            this.process,
            this.askCompleteTime,
            this.serialNumber,
            this.category,
            this.plate,
            this.color,
            this.material,
            this.thickness,
            this.coating,
            this.plating
         );
      }

      @Override
      public String toString() {
         return "AppEnclosureTaskDTO.AppEnclosureTaskDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", orderNumber="
            + this.orderNumber
            + ", orderId="
            + this.orderId
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", teams="
            + this.teams
            + ", monomer="
            + this.monomer
            + ", plan="
            + this.plan
            + ", area="
            + this.area
            + ", productId="
            + this.productId
            + ", name="
            + this.name
            + ", length="
            + this.length
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", canReportQuantity="
            + this.canReportQuantity
            + ", process="
            + this.process
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", serialNumber="
            + this.serialNumber
            + ", category="
            + this.category
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ")";
      }
   }
}
