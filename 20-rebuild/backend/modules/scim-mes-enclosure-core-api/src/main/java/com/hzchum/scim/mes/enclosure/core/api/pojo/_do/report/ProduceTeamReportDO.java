package com.hzchum.scim.mes.enclosure.core.api.pojo._do.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProduceTeamReportDTO", description = "班组生产上报记录表 ")
public class ProduceTeamReportDO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "length", value = "单长")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "productName", notes = "产品名称")
   @JsonProperty("productName")
   @JSONField(name = "productName")
   private String productName;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "plan", notes = "区域")
   @JsonProperty("plan")
   @JSONField(name = "plan")
   private AreaDetailDO plan;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "teams", notes = "生产组")
   @JsonProperty("teams")
   @JSONField(name = "teams")
   private GroupsCurrencyDO teams;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "user", notes = "上报人")
   @JsonProperty("user")
   @JSONField(name = "user")
   private IdAndNameDO user;

   public static ProduceTeamReportDO.ProduceTeamReportDOBuilder builder() {
      return new ProduceTeamReportDO.ProduceTeamReportDOBuilder();
   }

   public ProduceTeamReportDO() {
   }

   public ProduceTeamReportDO(
      final Long id,
      final Long productId,
      final Integer quantity,
      final BigDecimal length,
      final String serialNumber,
      final String productName,
      final ProjectDetailDO project,
      final NameInfo monomer,
      final AreaDetailDO area,
      final AreaDetailDO plan,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO teams,
      final IdAndNameDO process,
      final IdAndNameDO user
   ) {
      this.id = id;
      this.productId = productId;
      this.quantity = quantity;
      this.length = length;
      this.serialNumber = serialNumber;
      this.productName = productName;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.plan = plan;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.teams = teams;
      this.process = process;
      this.user = user;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProductName() {
      return this.productName;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public AreaDetailDO getPlan() {
      return this.plan;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public GroupsCurrencyDO getTeams() {
      return this.teams;
   }

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public IdAndNameDO getUser() {
      return this.user;
   }

   @JsonProperty("id")
   public ProduceTeamReportDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public ProduceTeamReportDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public ProduceTeamReportDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("length")
   public ProduceTeamReportDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProduceTeamReportDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("productName")
   public ProduceTeamReportDO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("project")
   public ProduceTeamReportDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public ProduceTeamReportDO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public ProduceTeamReportDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("plan")
   public ProduceTeamReportDO setPlan(final AreaDetailDO plan) {
      this.plan = plan;
      return this;
   }

   @JsonProperty("workshop")
   public ProduceTeamReportDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public ProduceTeamReportDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("teams")
   public ProduceTeamReportDO setTeams(final GroupsCurrencyDO teams) {
      this.teams = teams;
      return this;
   }

   @JsonProperty("process")
   public ProduceTeamReportDO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("user")
   public ProduceTeamReportDO setUser(final IdAndNameDO user) {
      this.user = user;
      return this;
   }

   @Override
   public String toString() {
      return "ProduceTeamReportDO(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productName="
         + this.getProductName()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", plan="
         + this.getPlan()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", teams="
         + this.getTeams()
         + ", process="
         + this.getProcess()
         + ", user="
         + this.getUser()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceTeamReportDO)) {
         return false;
      }

      ProduceTeamReportDO other = (ProduceTeamReportDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$length = this.getLength();
               Object other$length = other.getLength();
               if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$productName = this.getProductName();
                     Object other$productName = other.getProductName();
                     if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$monomer = this.getMonomer();
                           Object other$monomer = other.getMonomer();
                           if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                              Object this$area = this.getArea();
                              Object other$area = other.getArea();
                              if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                 Object this$plan = this.getPlan();
                                 Object other$plan = other.getPlan();
                                 if (this$plan == null ? other$plan == null : this$plan.equals(other$plan)) {
                                    Object this$workshop = this.getWorkshop();
                                    Object other$workshop = other.getWorkshop();
                                    if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                       Object this$productionLine = this.getProductionLine();
                                       Object other$productionLine = other.getProductionLine();
                                       if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                          Object this$teams = this.getTeams();
                                          Object other$teams = other.getTeams();
                                          if (this$teams == null ? other$teams == null : this$teams.equals(other$teams)) {
                                             Object this$process = this.getProcess();
                                             Object other$process = other.getProcess();
                                             if (this$process == null ? other$process == null : this$process.equals(other$process)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProduceTeamReportDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $plan = this.getPlan();
      result = result * 59 + ($plan == null ? 43 : $plan.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $teams = this.getTeams();
      result = result * 59 + ($teams == null ? 43 : $teams.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $user = this.getUser();
      return result * 59 + ($user == null ? 43 : $user.hashCode());
   }

   public static class ProduceTeamReportDOBuilder {
      private Long id;
      private Long productId;
      private Integer quantity;
      private BigDecimal length;
      private String serialNumber;
      private String productName;
      private ProjectDetailDO project;
      private NameInfo monomer;
      private AreaDetailDO area;
      private AreaDetailDO plan;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO teams;
      private IdAndNameDO process;
      private IdAndNameDO user;

      ProduceTeamReportDOBuilder() {
      }

      @JsonProperty("id")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("productName")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("project")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("plan")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder plan(final AreaDetailDO plan) {
         this.plan = plan;
         return this;
      }

      @JsonProperty("workshop")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("teams")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder teams(final GroupsCurrencyDO teams) {
         this.teams = teams;
         return this;
      }

      @JsonProperty("process")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("user")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder user(final IdAndNameDO user) {
         this.user = user;
         return this;
      }

      public ProduceTeamReportDO build() {
         return new ProduceTeamReportDO(
            this.id,
            this.productId,
            this.quantity,
            this.length,
            this.serialNumber,
            this.productName,
            this.project,
            this.monomer,
            this.area,
            this.plan,
            this.workshop,
            this.productionLine,
            this.teams,
            this.process,
            this.user
         );
      }

      @Override
      public String toString() {
         return "ProduceTeamReportDO.ProduceTeamReportDOBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", length="
            + this.length
            + ", serialNumber="
            + this.serialNumber
            + ", productName="
            + this.productName
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", plan="
            + this.plan
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", teams="
            + this.teams
            + ", process="
            + this.process
            + ", user="
            + this.user
            + ")";
      }
   }
}
