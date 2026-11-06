package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.app.AppTaskProcessArtifactNumberDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "AppTaskProcessDetailsDO", description = "用户可上报的工序详情 ")
public class AppTaskProcessDetailsDO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
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
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "nextProcess", notes = "下一道工序")
   @JsonProperty("nextProcess")
   @JSONField(name = "nextProcess")
   private IdAndNameDO nextProcess;
   @ApiModelProperty(name = "status", notes = "任务状态[0 正常,1暂停(可异常上报),2,暂停(正在处理中,无法上报)]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "technologyStatus", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("technologyStatus")
   @JSONField(name = "technologyStatus")
   private Boolean technologyStatus;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "reportType", notes = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
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
   @ApiModelProperty(name = "artifactNumber", notes = "构件一物一码信息")
   @JsonProperty("artifactNumber")
   @JSONField(name = "artifactNumber")
   @JsonInclude(Include.NON_NULL)
   private List<AppTaskProcessArtifactNumberDTO> artifactNumber;

   public static AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder builder() {
      return new AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder();
   }

   public AppTaskProcessDetailsDO() {
   }

   public AppTaskProcessDetailsDO(
      final Long id,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final IdAndNameDO process,
      final IdAndNameDO nextProcess,
      final Integer status,
      final Boolean technologyStatus,
      final LocalDateTime askCompleteTime,
      final String serialNumber,
      final Integer reportType,
      final String specification,
      final BigDecimal length,
      final String material,
      final List<AppTaskProcessArtifactNumberDTO> artifactNumber
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.process = process;
      this.nextProcess = nextProcess;
      this.status = status;
      this.technologyStatus = technologyStatus;
      this.askCompleteTime = askCompleteTime;
      this.serialNumber = serialNumber;
      this.reportType = reportType;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.artifactNumber = artifactNumber;
   }

   public Long getId() {
      return this.id;
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

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public IdAndNameDO getNextProcess() {
      return this.nextProcess;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Boolean getTechnologyStatus() {
      return this.technologyStatus;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getReportType() {
      return this.reportType;
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

   public List<AppTaskProcessArtifactNumberDTO> getArtifactNumber() {
      return this.artifactNumber;
   }

   @JsonProperty("id")
   public AppTaskProcessDetailsDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public AppTaskProcessDetailsDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public AppTaskProcessDetailsDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public AppTaskProcessDetailsDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("productId")
   public AppTaskProcessDetailsDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public AppTaskProcessDetailsDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public AppTaskProcessDetailsDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("process")
   public AppTaskProcessDetailsDO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("nextProcess")
   public AppTaskProcessDetailsDO setNextProcess(final IdAndNameDO nextProcess) {
      this.nextProcess = nextProcess;
      return this;
   }

   @JsonProperty("status")
   public AppTaskProcessDetailsDO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("technologyStatus")
   public AppTaskProcessDetailsDO setTechnologyStatus(final Boolean technologyStatus) {
      this.technologyStatus = technologyStatus;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AppTaskProcessDetailsDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("serialNumber")
   public AppTaskProcessDetailsDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("reportType")
   public AppTaskProcessDetailsDO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("specification")
   public AppTaskProcessDetailsDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public AppTaskProcessDetailsDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public AppTaskProcessDetailsDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("artifactNumber")
   public AppTaskProcessDetailsDO setArtifactNumber(final List<AppTaskProcessArtifactNumberDTO> artifactNumber) {
      this.artifactNumber = artifactNumber;
      return this;
   }

   @Override
   public String toString() {
      return "AppTaskProcessDetailsDO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", productId="
         + this.getProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", process="
         + this.getProcess()
         + ", nextProcess="
         + this.getNextProcess()
         + ", status="
         + this.getStatus()
         + ", technologyStatus="
         + this.getTechnologyStatus()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", reportType="
         + this.getReportType()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", artifactNumber="
         + this.getArtifactNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppTaskProcessDetailsDO)) {
         return false;
      }

      AppTaskProcessDetailsDO other = (AppTaskProcessDetailsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$technologyStatus = this.getTechnologyStatus();
                     Object other$technologyStatus = other.getTechnologyStatus();
                     if (this$technologyStatus == null ? other$technologyStatus == null : this$technologyStatus.equals(other$technologyStatus)) {
                        Object this$reportType = this.getReportType();
                        Object other$reportType = other.getReportType();
                        if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$monomer = this.getMonomer();
                              Object other$monomer = other.getMonomer();
                              if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                 Object this$area = this.getArea();
                                 Object other$area = other.getArea();
                                 if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                    Object this$process = this.getProcess();
                                    Object other$process = other.getProcess();
                                    if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                       Object this$nextProcess = this.getNextProcess();
                                       Object other$nextProcess = other.getNextProcess();
                                       if (this$nextProcess == null ? other$nextProcess == null : this$nextProcess.equals(other$nextProcess)) {
                                          Object this$askCompleteTime = this.getAskCompleteTime();
                                          Object other$askCompleteTime = other.getAskCompleteTime();
                                          if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)
                                             )
                                           {
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
                                                         Object this$artifactNumber = this.getArtifactNumber();
                                                         Object other$artifactNumber = other.getArtifactNumber();
                                                         return this$artifactNumber == null
                                                            ? other$artifactNumber == null
                                                            : this$artifactNumber.equals(other$artifactNumber);
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
      return other instanceof AppTaskProcessDetailsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $technologyStatus = this.getTechnologyStatus();
      result = result * 59 + ($technologyStatus == null ? 43 : $technologyStatus.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $nextProcess = this.getNextProcess();
      result = result * 59 + ($nextProcess == null ? 43 : $nextProcess.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $artifactNumber = this.getArtifactNumber();
      return result * 59 + ($artifactNumber == null ? 43 : $artifactNumber.hashCode());
   }

   public static class AppTaskProcessDetailsDOBuilder {
      private Long id;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private IdAndNameDO process;
      private IdAndNameDO nextProcess;
      private Integer status;
      private Boolean technologyStatus;
      private LocalDateTime askCompleteTime;
      private String serialNumber;
      private Integer reportType;
      private String specification;
      private BigDecimal length;
      private String material;
      private List<AppTaskProcessArtifactNumberDTO> artifactNumber;

      AppTaskProcessDetailsDOBuilder() {
      }

      @JsonProperty("id")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("productId")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("process")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("nextProcess")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder nextProcess(final IdAndNameDO nextProcess) {
         this.nextProcess = nextProcess;
         return this;
      }

      @JsonProperty("status")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("technologyStatus")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder technologyStatus(final Boolean technologyStatus) {
         this.technologyStatus = technologyStatus;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("serialNumber")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("reportType")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("specification")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("artifactNumber")
      public AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder artifactNumber(final List<AppTaskProcessArtifactNumberDTO> artifactNumber) {
         this.artifactNumber = artifactNumber;
         return this;
      }

      public AppTaskProcessDetailsDO build() {
         return new AppTaskProcessDetailsDO(
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.productId,
            this.taskTypeEnum,
            this.quantity,
            this.process,
            this.nextProcess,
            this.status,
            this.technologyStatus,
            this.askCompleteTime,
            this.serialNumber,
            this.reportType,
            this.specification,
            this.length,
            this.material,
            this.artifactNumber
         );
      }

      @Override
      public String toString() {
         return "AppTaskProcessDetailsDO.AppTaskProcessDetailsDOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", productId="
            + this.productId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", process="
            + this.process
            + ", nextProcess="
            + this.nextProcess
            + ", status="
            + this.status
            + ", technologyStatus="
            + this.technologyStatus
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", serialNumber="
            + this.serialNumber
            + ", reportType="
            + this.reportType
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", artifactNumber="
            + this.artifactNumber
            + ")";
      }
   }
}
