package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "AppTaskProcessDetailsDTO", description = "用户可上报的工序详情 ")
public class AppTeamReportDetailsDTO {
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", value = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "team", value = "生产组长", notes = "生产组长")
   @JsonProperty("team")
   @JSONField(name = "team")
   private IdAndNameDO team;
   @ApiModelProperty(name = "orderNumber", notes = "任务工单")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "firstProcess", notes = "是否是第一道工序")
   @JsonProperty("firstProcess")
   @JSONField(name = "firstProcess")
   private Boolean boolFirstProcess;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "围护长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "reportType", notes = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(name = "artifactNumberList", notes = "构件一物一码信息")
   @JsonProperty("artifactNumberList")
   @JSONField(name = "artifactNumberList")
   private List<AppTaskProcessArtifactNumberDTO> artifactNumberList;
   @ApiModelProperty(name = "factory", value = "工厂", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private IdAndNameDO factory;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private IdAndNameDO workshop;
   @ApiModelProperty(name = "productionLine", value = "产线", notes = "产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private IdAndNameDO productionLine;
   @ApiModelProperty(name = "groups", value = "生产组", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private IdAndNameDO groups;
   @ApiModelProperty("扫码方式 1:一物一码  2:一码多物(批量) 枚举: CodingTypeEnum")
   @JsonProperty("codingType")
   @JSONField(name = "codingType")
   @JsonInclude(Include.NON_NULL)
   private Integer codingType;

   public static AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder builder() {
      return new AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder();
   }

   public AppTeamReportDetailsDTO() {
   }

   public AppTeamReportDetailsDTO(
      final Long taskId,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final IdAndNameDO team,
      final String orderNumber,
      final IdAndNameDO process,
      final Boolean boolFirstProcess,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer reportType,
      final List<AppTaskProcessArtifactNumberDTO> artifactNumberList,
      final IdAndNameDO factory,
      final IdAndNameDO workshop,
      final IdAndNameDO productionLine,
      final IdAndNameDO groups,
      final Integer codingType
   ) {
      this.taskId = taskId;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.team = team;
      this.orderNumber = orderNumber;
      this.process = process;
      this.boolFirstProcess = boolFirstProcess;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.reportType = reportType;
      this.artifactNumberList = artifactNumberList;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.codingType = codingType;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public IdAndNameDO getTeam() {
      return this.team;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public Boolean getBoolFirstProcess() {
      return this.boolFirstProcess;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public List<AppTaskProcessArtifactNumberDTO> getArtifactNumberList() {
      return this.artifactNumberList;
   }

   public IdAndNameDO getFactory() {
      return this.factory;
   }

   public IdAndNameDO getWorkshop() {
      return this.workshop;
   }

   public IdAndNameDO getProductionLine() {
      return this.productionLine;
   }

   public IdAndNameDO getGroups() {
      return this.groups;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   @JsonProperty("taskId")
   public AppTeamReportDetailsDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("productId")
   public AppTeamReportDetailsDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public AppTeamReportDetailsDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public AppTeamReportDetailsDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("project")
   public AppTeamReportDetailsDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public AppTeamReportDetailsDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public AppTeamReportDetailsDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("team")
   public AppTeamReportDetailsDTO setTeam(final IdAndNameDO team) {
      this.team = team;
      return this;
   }

   @JsonProperty("orderNumber")
   public AppTeamReportDetailsDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("process")
   public AppTeamReportDetailsDTO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("firstProcess")
   public AppTeamReportDetailsDTO setBoolFirstProcess(final Boolean boolFirstProcess) {
      this.boolFirstProcess = boolFirstProcess;
      return this;
   }

   @JsonProperty("serialNumber")
   public AppTeamReportDetailsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public AppTeamReportDetailsDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public AppTeamReportDetailsDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public AppTeamReportDetailsDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("reportType")
   public AppTeamReportDetailsDTO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("artifactNumberList")
   public AppTeamReportDetailsDTO setArtifactNumberList(final List<AppTaskProcessArtifactNumberDTO> artifactNumberList) {
      this.artifactNumberList = artifactNumberList;
      return this;
   }

   @JsonProperty("factory")
   public AppTeamReportDetailsDTO setFactory(final IdAndNameDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public AppTeamReportDetailsDTO setWorkshop(final IdAndNameDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AppTeamReportDetailsDTO setProductionLine(final IdAndNameDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public AppTeamReportDetailsDTO setGroups(final IdAndNameDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("codingType")
   public AppTeamReportDetailsDTO setCodingType(final Integer codingType) {
      this.codingType = codingType;
      return this;
   }

   @Override
   public String toString() {
      return "AppTeamReportDetailsDTO(taskId="
         + this.getTaskId()
         + ", productId="
         + this.getProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", team="
         + this.getTeam()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", process="
         + this.getProcess()
         + ", boolFirstProcess="
         + this.getBoolFirstProcess()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", reportType="
         + this.getReportType()
         + ", artifactNumberList="
         + this.getArtifactNumberList()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", codingType="
         + this.getCodingType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppTeamReportDetailsDTO)) {
         return false;
      }

      AppTeamReportDetailsDTO other = (AppTeamReportDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$boolFirstProcess = this.getBoolFirstProcess();
                  Object other$boolFirstProcess = other.getBoolFirstProcess();
                  if (this$boolFirstProcess == null ? other$boolFirstProcess == null : this$boolFirstProcess.equals(other$boolFirstProcess)) {
                     Object this$reportType = this.getReportType();
                     Object other$reportType = other.getReportType();
                     if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                        Object this$codingType = this.getCodingType();
                        Object other$codingType = other.getCodingType();
                        if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$monomer = this.getMonomer();
                              Object other$monomer = other.getMonomer();
                              if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                 Object this$area = this.getArea();
                                 Object other$area = other.getArea();
                                 if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                    Object this$team = this.getTeam();
                                    Object other$team = other.getTeam();
                                    if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                                       Object this$orderNumber = this.getOrderNumber();
                                       Object other$orderNumber = other.getOrderNumber();
                                       if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                          Object this$process = this.getProcess();
                                          Object other$process = other.getProcess();
                                          if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$length = this.getLength();
                                                   Object other$length = other.getLength();
                                                   if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$artifactNumberList = this.getArtifactNumberList();
                                                         Object other$artifactNumberList = other.getArtifactNumberList();
                                                         if (this$artifactNumberList == null
                                                            ? other$artifactNumberList == null
                                                            : this$artifactNumberList.equals(other$artifactNumberList)) {
                                                            Object this$factory = this.getFactory();
                                                            Object other$factory = other.getFactory();
                                                            if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                                                               Object this$workshop = this.getWorkshop();
                                                               Object other$workshop = other.getWorkshop();
                                                               if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                                  Object this$productionLine = this.getProductionLine();
                                                                  Object other$productionLine = other.getProductionLine();
                                                                  if (this$productionLine == null
                                                                     ? other$productionLine == null
                                                                     : this$productionLine.equals(other$productionLine)) {
                                                                     Object this$groups = this.getGroups();
                                                                     Object other$groups = other.getGroups();
                                                                     return this$groups == null ? other$groups == null : this$groups.equals(other$groups);
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
      return other instanceof AppTeamReportDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolFirstProcess = this.getBoolFirstProcess();
      result = result * 59 + ($boolFirstProcess == null ? 43 : $boolFirstProcess.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $artifactNumberList = this.getArtifactNumberList();
      result = result * 59 + ($artifactNumberList == null ? 43 : $artifactNumberList.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      return result * 59 + ($groups == null ? 43 : $groups.hashCode());
   }

   public static class AppTeamReportDetailsDTOBuilder {
      private Long taskId;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private IdAndNameDO team;
      private String orderNumber;
      private IdAndNameDO process;
      private Boolean boolFirstProcess;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer reportType;
      private List<AppTaskProcessArtifactNumberDTO> artifactNumberList;
      private IdAndNameDO factory;
      private IdAndNameDO workshop;
      private IdAndNameDO productionLine;
      private IdAndNameDO groups;
      private Integer codingType;

      AppTeamReportDetailsDTOBuilder() {
      }

      @JsonProperty("taskId")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("productId")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("project")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("team")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder team(final IdAndNameDO team) {
         this.team = team;
         return this;
      }

      @JsonProperty("orderNumber")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("process")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("firstProcess")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder boolFirstProcess(final Boolean boolFirstProcess) {
         this.boolFirstProcess = boolFirstProcess;
         return this;
      }

      @JsonProperty("serialNumber")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("reportType")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("artifactNumberList")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder artifactNumberList(final List<AppTaskProcessArtifactNumberDTO> artifactNumberList) {
         this.artifactNumberList = artifactNumberList;
         return this;
      }

      @JsonProperty("factory")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder factory(final IdAndNameDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder workshop(final IdAndNameDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder productionLine(final IdAndNameDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder groups(final IdAndNameDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("codingType")
      public AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder codingType(final Integer codingType) {
         this.codingType = codingType;
         return this;
      }

      public AppTeamReportDetailsDTO build() {
         return new AppTeamReportDetailsDTO(
            this.taskId,
            this.productId,
            this.taskTypeEnum,
            this.quantity,
            this.project,
            this.monomer,
            this.area,
            this.team,
            this.orderNumber,
            this.process,
            this.boolFirstProcess,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.reportType,
            this.artifactNumberList,
            this.factory,
            this.workshop,
            this.productionLine,
            this.groups,
            this.codingType
         );
      }

      @Override
      public String toString() {
         return "AppTeamReportDetailsDTO.AppTeamReportDetailsDTOBuilder(taskId="
            + this.taskId
            + ", productId="
            + this.productId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", team="
            + this.team
            + ", orderNumber="
            + this.orderNumber
            + ", process="
            + this.process
            + ", boolFirstProcess="
            + this.boolFirstProcess
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", reportType="
            + this.reportType
            + ", artifactNumberList="
            + this.artifactNumberList
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", codingType="
            + this.codingType
            + ")";
      }
   }
}
