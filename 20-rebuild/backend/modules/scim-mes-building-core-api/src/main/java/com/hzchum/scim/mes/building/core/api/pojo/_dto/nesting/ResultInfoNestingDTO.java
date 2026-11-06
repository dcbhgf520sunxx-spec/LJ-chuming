package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel(value = "MachinePartNestingPdfDTO", description = "车间班组对象")
public class ResultInfoNestingDTO {
   @JsonProperty("IDHash")
   private String IDHash;
   private int amount;
   private String area;
   private int contours_count;
   private String curve_length;
   private String curve_time;
   private String delay_time;
   private String guid;
   private String height;
   private String mark_length;
   private int mark_point;
   private int marks_Count;
   private String move_length;
   private String move_time;
   private String name;
   private String nest_area;
   private String nest_x;
   private String nest_y;
   private String nestedrec_area;
   private int part_amount;
   private List<PartInfoNestingDTO> part_info;
   private String partnet_area;
   private int pierce_count;
   private String pierce_time;
   private String remnant_area;
   private String total_time;
   private String utilization;
   private String uuid;
   private String width;
   private String nest_name;
   private String material;
   private String thickness;
   private String gas;
   private String utilization_slab;
   private String utilization_nestedrec;
   private String utilization_nestedrec_slab;
   private AbnormalInfoDTO abnormal_info;
   private String plate_guid;
   private double density;

   public static ResultInfoNestingDTO.ResultInfoNestingDTOBuilder builder() {
      return new ResultInfoNestingDTO.ResultInfoNestingDTOBuilder();
   }

   public ResultInfoNestingDTO(
      final String IDHash,
      final int amount,
      final String area,
      final int contours_count,
      final String curve_length,
      final String curve_time,
      final String delay_time,
      final String guid,
      final String height,
      final String mark_length,
      final int mark_point,
      final int marks_Count,
      final String move_length,
      final String move_time,
      final String name,
      final String nest_area,
      final String nest_x,
      final String nest_y,
      final String nestedrec_area,
      final int part_amount,
      final List<PartInfoNestingDTO> part_info,
      final String partnet_area,
      final int pierce_count,
      final String pierce_time,
      final String remnant_area,
      final String total_time,
      final String utilization,
      final String uuid,
      final String width,
      final String nest_name,
      final String material,
      final String thickness,
      final String gas,
      final String utilization_slab,
      final String utilization_nestedrec,
      final String utilization_nestedrec_slab,
      final AbnormalInfoDTO abnormal_info,
      final String plate_guid,
      final double density
   ) {
      this.IDHash = IDHash;
      this.amount = amount;
      this.area = area;
      this.contours_count = contours_count;
      this.curve_length = curve_length;
      this.curve_time = curve_time;
      this.delay_time = delay_time;
      this.guid = guid;
      this.height = height;
      this.mark_length = mark_length;
      this.mark_point = mark_point;
      this.marks_Count = marks_Count;
      this.move_length = move_length;
      this.move_time = move_time;
      this.name = name;
      this.nest_area = nest_area;
      this.nest_x = nest_x;
      this.nest_y = nest_y;
      this.nestedrec_area = nestedrec_area;
      this.part_amount = part_amount;
      this.part_info = part_info;
      this.partnet_area = partnet_area;
      this.pierce_count = pierce_count;
      this.pierce_time = pierce_time;
      this.remnant_area = remnant_area;
      this.total_time = total_time;
      this.utilization = utilization;
      this.uuid = uuid;
      this.width = width;
      this.nest_name = nest_name;
      this.material = material;
      this.thickness = thickness;
      this.gas = gas;
      this.utilization_slab = utilization_slab;
      this.utilization_nestedrec = utilization_nestedrec;
      this.utilization_nestedrec_slab = utilization_nestedrec_slab;
      this.abnormal_info = abnormal_info;
      this.plate_guid = plate_guid;
      this.density = density;
   }

   public ResultInfoNestingDTO() {
   }

   public String getIDHash() {
      return this.IDHash;
   }

   public int getAmount() {
      return this.amount;
   }

   public String getArea() {
      return this.area;
   }

   public int getContours_count() {
      return this.contours_count;
   }

   public String getCurve_length() {
      return this.curve_length;
   }

   public String getCurve_time() {
      return this.curve_time;
   }

   public String getDelay_time() {
      return this.delay_time;
   }

   public String getGuid() {
      return this.guid;
   }

   public String getHeight() {
      return this.height;
   }

   public String getMark_length() {
      return this.mark_length;
   }

   public int getMark_point() {
      return this.mark_point;
   }

   public int getMarks_Count() {
      return this.marks_Count;
   }

   public String getMove_length() {
      return this.move_length;
   }

   public String getMove_time() {
      return this.move_time;
   }

   public String getName() {
      return this.name;
   }

   public String getNest_area() {
      return this.nest_area;
   }

   public String getNest_x() {
      return this.nest_x;
   }

   public String getNest_y() {
      return this.nest_y;
   }

   public String getNestedrec_area() {
      return this.nestedrec_area;
   }

   public int getPart_amount() {
      return this.part_amount;
   }

   public List<PartInfoNestingDTO> getPart_info() {
      return this.part_info;
   }

   public String getPartnet_area() {
      return this.partnet_area;
   }

   public int getPierce_count() {
      return this.pierce_count;
   }

   public String getPierce_time() {
      return this.pierce_time;
   }

   public String getRemnant_area() {
      return this.remnant_area;
   }

   public String getTotal_time() {
      return this.total_time;
   }

   public String getUtilization() {
      return this.utilization;
   }

   public String getUuid() {
      return this.uuid;
   }

   public String getWidth() {
      return this.width;
   }

   public String getNest_name() {
      return this.nest_name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getGas() {
      return this.gas;
   }

   public String getUtilization_slab() {
      return this.utilization_slab;
   }

   public String getUtilization_nestedrec() {
      return this.utilization_nestedrec;
   }

   public String getUtilization_nestedrec_slab() {
      return this.utilization_nestedrec_slab;
   }

   public AbnormalInfoDTO getAbnormal_info() {
      return this.abnormal_info;
   }

   public String getPlate_guid() {
      return this.plate_guid;
   }

   public double getDensity() {
      return this.density;
   }

   @JsonProperty("IDHash")
   public ResultInfoNestingDTO setIDHash(final String IDHash) {
      this.IDHash = IDHash;
      return this;
   }

   public ResultInfoNestingDTO setAmount(final int amount) {
      this.amount = amount;
      return this;
   }

   public ResultInfoNestingDTO setArea(final String area) {
      this.area = area;
      return this;
   }

   public ResultInfoNestingDTO setContours_count(final int contours_count) {
      this.contours_count = contours_count;
      return this;
   }

   public ResultInfoNestingDTO setCurve_length(final String curve_length) {
      this.curve_length = curve_length;
      return this;
   }

   public ResultInfoNestingDTO setCurve_time(final String curve_time) {
      this.curve_time = curve_time;
      return this;
   }

   public ResultInfoNestingDTO setDelay_time(final String delay_time) {
      this.delay_time = delay_time;
      return this;
   }

   public ResultInfoNestingDTO setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public ResultInfoNestingDTO setHeight(final String height) {
      this.height = height;
      return this;
   }

   public ResultInfoNestingDTO setMark_length(final String mark_length) {
      this.mark_length = mark_length;
      return this;
   }

   public ResultInfoNestingDTO setMark_point(final int mark_point) {
      this.mark_point = mark_point;
      return this;
   }

   public ResultInfoNestingDTO setMarks_Count(final int marks_Count) {
      this.marks_Count = marks_Count;
      return this;
   }

   public ResultInfoNestingDTO setMove_length(final String move_length) {
      this.move_length = move_length;
      return this;
   }

   public ResultInfoNestingDTO setMove_time(final String move_time) {
      this.move_time = move_time;
      return this;
   }

   public ResultInfoNestingDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ResultInfoNestingDTO setNest_area(final String nest_area) {
      this.nest_area = nest_area;
      return this;
   }

   public ResultInfoNestingDTO setNest_x(final String nest_x) {
      this.nest_x = nest_x;
      return this;
   }

   public ResultInfoNestingDTO setNest_y(final String nest_y) {
      this.nest_y = nest_y;
      return this;
   }

   public ResultInfoNestingDTO setNestedrec_area(final String nestedrec_area) {
      this.nestedrec_area = nestedrec_area;
      return this;
   }

   public ResultInfoNestingDTO setPart_amount(final int part_amount) {
      this.part_amount = part_amount;
      return this;
   }

   public ResultInfoNestingDTO setPart_info(final List<PartInfoNestingDTO> part_info) {
      this.part_info = part_info;
      return this;
   }

   public ResultInfoNestingDTO setPartnet_area(final String partnet_area) {
      this.partnet_area = partnet_area;
      return this;
   }

   public ResultInfoNestingDTO setPierce_count(final int pierce_count) {
      this.pierce_count = pierce_count;
      return this;
   }

   public ResultInfoNestingDTO setPierce_time(final String pierce_time) {
      this.pierce_time = pierce_time;
      return this;
   }

   public ResultInfoNestingDTO setRemnant_area(final String remnant_area) {
      this.remnant_area = remnant_area;
      return this;
   }

   public ResultInfoNestingDTO setTotal_time(final String total_time) {
      this.total_time = total_time;
      return this;
   }

   public ResultInfoNestingDTO setUtilization(final String utilization) {
      this.utilization = utilization;
      return this;
   }

   public ResultInfoNestingDTO setUuid(final String uuid) {
      this.uuid = uuid;
      return this;
   }

   public ResultInfoNestingDTO setWidth(final String width) {
      this.width = width;
      return this;
   }

   public ResultInfoNestingDTO setNest_name(final String nest_name) {
      this.nest_name = nest_name;
      return this;
   }

   public ResultInfoNestingDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public ResultInfoNestingDTO setThickness(final String thickness) {
      this.thickness = thickness;
      return this;
   }

   public ResultInfoNestingDTO setGas(final String gas) {
      this.gas = gas;
      return this;
   }

   public ResultInfoNestingDTO setUtilization_slab(final String utilization_slab) {
      this.utilization_slab = utilization_slab;
      return this;
   }

   public ResultInfoNestingDTO setUtilization_nestedrec(final String utilization_nestedrec) {
      this.utilization_nestedrec = utilization_nestedrec;
      return this;
   }

   public ResultInfoNestingDTO setUtilization_nestedrec_slab(final String utilization_nestedrec_slab) {
      this.utilization_nestedrec_slab = utilization_nestedrec_slab;
      return this;
   }

   public ResultInfoNestingDTO setAbnormal_info(final AbnormalInfoDTO abnormal_info) {
      this.abnormal_info = abnormal_info;
      return this;
   }

   public ResultInfoNestingDTO setPlate_guid(final String plate_guid) {
      this.plate_guid = plate_guid;
      return this;
   }

   public ResultInfoNestingDTO setDensity(final double density) {
      this.density = density;
      return this;
   }

   @Override
   public String toString() {
      return "ResultInfoNestingDTO(IDHash="
         + this.getIDHash()
         + ", amount="
         + this.getAmount()
         + ", area="
         + this.getArea()
         + ", contours_count="
         + this.getContours_count()
         + ", curve_length="
         + this.getCurve_length()
         + ", curve_time="
         + this.getCurve_time()
         + ", delay_time="
         + this.getDelay_time()
         + ", guid="
         + this.getGuid()
         + ", height="
         + this.getHeight()
         + ", mark_length="
         + this.getMark_length()
         + ", mark_point="
         + this.getMark_point()
         + ", marks_Count="
         + this.getMarks_Count()
         + ", move_length="
         + this.getMove_length()
         + ", move_time="
         + this.getMove_time()
         + ", name="
         + this.getName()
         + ", nest_area="
         + this.getNest_area()
         + ", nest_x="
         + this.getNest_x()
         + ", nest_y="
         + this.getNest_y()
         + ", nestedrec_area="
         + this.getNestedrec_area()
         + ", part_amount="
         + this.getPart_amount()
         + ", part_info="
         + this.getPart_info()
         + ", partnet_area="
         + this.getPartnet_area()
         + ", pierce_count="
         + this.getPierce_count()
         + ", pierce_time="
         + this.getPierce_time()
         + ", remnant_area="
         + this.getRemnant_area()
         + ", total_time="
         + this.getTotal_time()
         + ", utilization="
         + this.getUtilization()
         + ", uuid="
         + this.getUuid()
         + ", width="
         + this.getWidth()
         + ", nest_name="
         + this.getNest_name()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", gas="
         + this.getGas()
         + ", utilization_slab="
         + this.getUtilization_slab()
         + ", utilization_nestedrec="
         + this.getUtilization_nestedrec()
         + ", utilization_nestedrec_slab="
         + this.getUtilization_nestedrec_slab()
         + ", abnormal_info="
         + this.getAbnormal_info()
         + ", plate_guid="
         + this.getPlate_guid()
         + ", density="
         + this.getDensity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ResultInfoNestingDTO)) {
         return false;
      }

      ResultInfoNestingDTO other = (ResultInfoNestingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getAmount() != other.getAmount()) {
         return false;
      }

      if (this.getContours_count() != other.getContours_count()) {
         return false;
      }

      if (this.getMark_point() != other.getMark_point()) {
         return false;
      }

      if (this.getMarks_Count() != other.getMarks_Count()) {
         return false;
      }

      if (this.getPart_amount() != other.getPart_amount()) {
         return false;
      }

      if (this.getPierce_count() != other.getPierce_count()) {
         return false;
      }

      if (Double.compare(this.getDensity(), other.getDensity()) != 0) {
         return false;
      }

      Object this$IDHash = this.getIDHash();
      Object other$IDHash = other.getIDHash();
      if (this$IDHash == null ? other$IDHash == null : this$IDHash.equals(other$IDHash)) {
         Object this$area = this.getArea();
         Object other$area = other.getArea();
         if (this$area == null ? other$area == null : this$area.equals(other$area)) {
            Object this$curve_length = this.getCurve_length();
            Object other$curve_length = other.getCurve_length();
            if (this$curve_length == null ? other$curve_length == null : this$curve_length.equals(other$curve_length)) {
               Object this$curve_time = this.getCurve_time();
               Object other$curve_time = other.getCurve_time();
               if (this$curve_time == null ? other$curve_time == null : this$curve_time.equals(other$curve_time)) {
                  Object this$delay_time = this.getDelay_time();
                  Object other$delay_time = other.getDelay_time();
                  if (this$delay_time == null ? other$delay_time == null : this$delay_time.equals(other$delay_time)) {
                     Object this$guid = this.getGuid();
                     Object other$guid = other.getGuid();
                     if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                        Object this$height = this.getHeight();
                        Object other$height = other.getHeight();
                        if (this$height == null ? other$height == null : this$height.equals(other$height)) {
                           Object this$mark_length = this.getMark_length();
                           Object other$mark_length = other.getMark_length();
                           if (this$mark_length == null ? other$mark_length == null : this$mark_length.equals(other$mark_length)) {
                              Object this$move_length = this.getMove_length();
                              Object other$move_length = other.getMove_length();
                              if (this$move_length == null ? other$move_length == null : this$move_length.equals(other$move_length)) {
                                 Object this$move_time = this.getMove_time();
                                 Object other$move_time = other.getMove_time();
                                 if (this$move_time == null ? other$move_time == null : this$move_time.equals(other$move_time)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$nest_area = this.getNest_area();
                                       Object other$nest_area = other.getNest_area();
                                       if (this$nest_area == null ? other$nest_area == null : this$nest_area.equals(other$nest_area)) {
                                          Object this$nest_x = this.getNest_x();
                                          Object other$nest_x = other.getNest_x();
                                          if (this$nest_x == null ? other$nest_x == null : this$nest_x.equals(other$nest_x)) {
                                             Object this$nest_y = this.getNest_y();
                                             Object other$nest_y = other.getNest_y();
                                             if (this$nest_y == null ? other$nest_y == null : this$nest_y.equals(other$nest_y)) {
                                                Object this$nestedrec_area = this.getNestedrec_area();
                                                Object other$nestedrec_area = other.getNestedrec_area();
                                                if (this$nestedrec_area == null
                                                   ? other$nestedrec_area == null
                                                   : this$nestedrec_area.equals(other$nestedrec_area)) {
                                                   Object this$part_info = this.getPart_info();
                                                   Object other$part_info = other.getPart_info();
                                                   if (this$part_info == null ? other$part_info == null : this$part_info.equals(other$part_info)) {
                                                      Object this$partnet_area = this.getPartnet_area();
                                                      Object other$partnet_area = other.getPartnet_area();
                                                      if (this$partnet_area == null ? other$partnet_area == null : this$partnet_area.equals(other$partnet_area)
                                                         )
                                                       {
                                                         Object this$pierce_time = this.getPierce_time();
                                                         Object other$pierce_time = other.getPierce_time();
                                                         if (this$pierce_time == null ? other$pierce_time == null : this$pierce_time.equals(other$pierce_time)) {
                                                            Object this$remnant_area = this.getRemnant_area();
                                                            Object other$remnant_area = other.getRemnant_area();
                                                            if (this$remnant_area == null
                                                               ? other$remnant_area == null
                                                               : this$remnant_area.equals(other$remnant_area)) {
                                                               Object this$total_time = this.getTotal_time();
                                                               Object other$total_time = other.getTotal_time();
                                                               if (this$total_time == null
                                                                  ? other$total_time == null
                                                                  : this$total_time.equals(other$total_time)) {
                                                                  Object this$utilization = this.getUtilization();
                                                                  Object other$utilization = other.getUtilization();
                                                                  if (this$utilization == null
                                                                     ? other$utilization == null
                                                                     : this$utilization.equals(other$utilization)) {
                                                                     Object this$uuid = this.getUuid();
                                                                     Object other$uuid = other.getUuid();
                                                                     if (this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid)) {
                                                                        Object this$width = this.getWidth();
                                                                        Object other$width = other.getWidth();
                                                                        if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                           Object this$nest_name = this.getNest_name();
                                                                           Object other$nest_name = other.getNest_name();
                                                                           if (this$nest_name == null
                                                                              ? other$nest_name == null
                                                                              : this$nest_name.equals(other$nest_name)) {
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
                                                                                    Object this$gas = this.getGas();
                                                                                    Object other$gas = other.getGas();
                                                                                    if (this$gas == null ? other$gas == null : this$gas.equals(other$gas)) {
                                                                                       Object this$utilization_slab = this.getUtilization_slab();
                                                                                       Object other$utilization_slab = other.getUtilization_slab();
                                                                                       if (this$utilization_slab == null
                                                                                          ? other$utilization_slab == null
                                                                                          : this$utilization_slab.equals(other$utilization_slab)) {
                                                                                          Object this$utilization_nestedrec = this.getUtilization_nestedrec();
                                                                                          Object other$utilization_nestedrec = other.getUtilization_nestedrec();
                                                                                          if (this$utilization_nestedrec == null
                                                                                             ? other$utilization_nestedrec == null
                                                                                             : this$utilization_nestedrec.equals(other$utilization_nestedrec)) {
                                                                                             Object this$utilization_nestedrec_slab = this.getUtilization_nestedrec_slab();
                                                                                             Object other$utilization_nestedrec_slab = other.getUtilization_nestedrec_slab();
                                                                                             if (this$utilization_nestedrec_slab == null
                                                                                                ? other$utilization_nestedrec_slab == null
                                                                                                : this$utilization_nestedrec_slab.equals(
                                                                                                   other$utilization_nestedrec_slab
                                                                                                )) {
                                                                                                Object this$abnormal_info = this.getAbnormal_info();
                                                                                                Object other$abnormal_info = other.getAbnormal_info();
                                                                                                if (this$abnormal_info == null
                                                                                                   ? other$abnormal_info == null
                                                                                                   : this$abnormal_info.equals(other$abnormal_info)) {
                                                                                                   Object this$plate_guid = this.getPlate_guid();
                                                                                                   Object other$plate_guid = other.getPlate_guid();
                                                                                                   return this$plate_guid == null
                                                                                                      ? other$plate_guid == null
                                                                                                      : this$plate_guid.equals(other$plate_guid);
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
      return other instanceof ResultInfoNestingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getAmount();
      result = result * 59 + this.getContours_count();
      result = result * 59 + this.getMark_point();
      result = result * 59 + this.getMarks_Count();
      result = result * 59 + this.getPart_amount();
      result = result * 59 + this.getPierce_count();
      long $density = Double.doubleToLongBits(this.getDensity());
      result = result * 59 + (int)($density >>> 32 ^ $density);
      Object $IDHash = this.getIDHash();
      result = result * 59 + ($IDHash == null ? 43 : $IDHash.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $curve_length = this.getCurve_length();
      result = result * 59 + ($curve_length == null ? 43 : $curve_length.hashCode());
      Object $curve_time = this.getCurve_time();
      result = result * 59 + ($curve_time == null ? 43 : $curve_time.hashCode());
      Object $delay_time = this.getDelay_time();
      result = result * 59 + ($delay_time == null ? 43 : $delay_time.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $height = this.getHeight();
      result = result * 59 + ($height == null ? 43 : $height.hashCode());
      Object $mark_length = this.getMark_length();
      result = result * 59 + ($mark_length == null ? 43 : $mark_length.hashCode());
      Object $move_length = this.getMove_length();
      result = result * 59 + ($move_length == null ? 43 : $move_length.hashCode());
      Object $move_time = this.getMove_time();
      result = result * 59 + ($move_time == null ? 43 : $move_time.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $nest_area = this.getNest_area();
      result = result * 59 + ($nest_area == null ? 43 : $nest_area.hashCode());
      Object $nest_x = this.getNest_x();
      result = result * 59 + ($nest_x == null ? 43 : $nest_x.hashCode());
      Object $nest_y = this.getNest_y();
      result = result * 59 + ($nest_y == null ? 43 : $nest_y.hashCode());
      Object $nestedrec_area = this.getNestedrec_area();
      result = result * 59 + ($nestedrec_area == null ? 43 : $nestedrec_area.hashCode());
      Object $part_info = this.getPart_info();
      result = result * 59 + ($part_info == null ? 43 : $part_info.hashCode());
      Object $partnet_area = this.getPartnet_area();
      result = result * 59 + ($partnet_area == null ? 43 : $partnet_area.hashCode());
      Object $pierce_time = this.getPierce_time();
      result = result * 59 + ($pierce_time == null ? 43 : $pierce_time.hashCode());
      Object $remnant_area = this.getRemnant_area();
      result = result * 59 + ($remnant_area == null ? 43 : $remnant_area.hashCode());
      Object $total_time = this.getTotal_time();
      result = result * 59 + ($total_time == null ? 43 : $total_time.hashCode());
      Object $utilization = this.getUtilization();
      result = result * 59 + ($utilization == null ? 43 : $utilization.hashCode());
      Object $uuid = this.getUuid();
      result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $nest_name = this.getNest_name();
      result = result * 59 + ($nest_name == null ? 43 : $nest_name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $gas = this.getGas();
      result = result * 59 + ($gas == null ? 43 : $gas.hashCode());
      Object $utilization_slab = this.getUtilization_slab();
      result = result * 59 + ($utilization_slab == null ? 43 : $utilization_slab.hashCode());
      Object $utilization_nestedrec = this.getUtilization_nestedrec();
      result = result * 59 + ($utilization_nestedrec == null ? 43 : $utilization_nestedrec.hashCode());
      Object $utilization_nestedrec_slab = this.getUtilization_nestedrec_slab();
      result = result * 59 + ($utilization_nestedrec_slab == null ? 43 : $utilization_nestedrec_slab.hashCode());
      Object $abnormal_info = this.getAbnormal_info();
      result = result * 59 + ($abnormal_info == null ? 43 : $abnormal_info.hashCode());
      Object $plate_guid = this.getPlate_guid();
      return result * 59 + ($plate_guid == null ? 43 : $plate_guid.hashCode());
   }

   public static class ResultInfoNestingDTOBuilder {
      private String IDHash;
      private int amount;
      private String area;
      private int contours_count;
      private String curve_length;
      private String curve_time;
      private String delay_time;
      private String guid;
      private String height;
      private String mark_length;
      private int mark_point;
      private int marks_Count;
      private String move_length;
      private String move_time;
      private String name;
      private String nest_area;
      private String nest_x;
      private String nest_y;
      private String nestedrec_area;
      private int part_amount;
      private List<PartInfoNestingDTO> part_info;
      private String partnet_area;
      private int pierce_count;
      private String pierce_time;
      private String remnant_area;
      private String total_time;
      private String utilization;
      private String uuid;
      private String width;
      private String nest_name;
      private String material;
      private String thickness;
      private String gas;
      private String utilization_slab;
      private String utilization_nestedrec;
      private String utilization_nestedrec_slab;
      private AbnormalInfoDTO abnormal_info;
      private String plate_guid;
      private double density;

      ResultInfoNestingDTOBuilder() {
      }

      @JsonProperty("IDHash")
      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder IDHash(final String IDHash) {
         this.IDHash = IDHash;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder amount(final int amount) {
         this.amount = amount;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder area(final String area) {
         this.area = area;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder contours_count(final int contours_count) {
         this.contours_count = contours_count;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder curve_length(final String curve_length) {
         this.curve_length = curve_length;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder curve_time(final String curve_time) {
         this.curve_time = curve_time;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder delay_time(final String delay_time) {
         this.delay_time = delay_time;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder height(final String height) {
         this.height = height;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder mark_length(final String mark_length) {
         this.mark_length = mark_length;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder mark_point(final int mark_point) {
         this.mark_point = mark_point;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder marks_Count(final int marks_Count) {
         this.marks_Count = marks_Count;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder move_length(final String move_length) {
         this.move_length = move_length;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder move_time(final String move_time) {
         this.move_time = move_time;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder nest_area(final String nest_area) {
         this.nest_area = nest_area;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder nest_x(final String nest_x) {
         this.nest_x = nest_x;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder nest_y(final String nest_y) {
         this.nest_y = nest_y;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder nestedrec_area(final String nestedrec_area) {
         this.nestedrec_area = nestedrec_area;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder part_amount(final int part_amount) {
         this.part_amount = part_amount;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder part_info(final List<PartInfoNestingDTO> part_info) {
         this.part_info = part_info;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder partnet_area(final String partnet_area) {
         this.partnet_area = partnet_area;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder pierce_count(final int pierce_count) {
         this.pierce_count = pierce_count;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder pierce_time(final String pierce_time) {
         this.pierce_time = pierce_time;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder remnant_area(final String remnant_area) {
         this.remnant_area = remnant_area;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder total_time(final String total_time) {
         this.total_time = total_time;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder utilization(final String utilization) {
         this.utilization = utilization;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder uuid(final String uuid) {
         this.uuid = uuid;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder width(final String width) {
         this.width = width;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder nest_name(final String nest_name) {
         this.nest_name = nest_name;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder gas(final String gas) {
         this.gas = gas;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder utilization_slab(final String utilization_slab) {
         this.utilization_slab = utilization_slab;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder utilization_nestedrec(final String utilization_nestedrec) {
         this.utilization_nestedrec = utilization_nestedrec;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder utilization_nestedrec_slab(final String utilization_nestedrec_slab) {
         this.utilization_nestedrec_slab = utilization_nestedrec_slab;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder abnormal_info(final AbnormalInfoDTO abnormal_info) {
         this.abnormal_info = abnormal_info;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder plate_guid(final String plate_guid) {
         this.plate_guid = plate_guid;
         return this;
      }

      public ResultInfoNestingDTO.ResultInfoNestingDTOBuilder density(final double density) {
         this.density = density;
         return this;
      }

      public ResultInfoNestingDTO build() {
         return new ResultInfoNestingDTO(
            this.IDHash,
            this.amount,
            this.area,
            this.contours_count,
            this.curve_length,
            this.curve_time,
            this.delay_time,
            this.guid,
            this.height,
            this.mark_length,
            this.mark_point,
            this.marks_Count,
            this.move_length,
            this.move_time,
            this.name,
            this.nest_area,
            this.nest_x,
            this.nest_y,
            this.nestedrec_area,
            this.part_amount,
            this.part_info,
            this.partnet_area,
            this.pierce_count,
            this.pierce_time,
            this.remnant_area,
            this.total_time,
            this.utilization,
            this.uuid,
            this.width,
            this.nest_name,
            this.material,
            this.thickness,
            this.gas,
            this.utilization_slab,
            this.utilization_nestedrec,
            this.utilization_nestedrec_slab,
            this.abnormal_info,
            this.plate_guid,
            this.density
         );
      }

      @Override
      public String toString() {
         return "ResultInfoNestingDTO.ResultInfoNestingDTOBuilder(IDHash="
            + this.IDHash
            + ", amount="
            + this.amount
            + ", area="
            + this.area
            + ", contours_count="
            + this.contours_count
            + ", curve_length="
            + this.curve_length
            + ", curve_time="
            + this.curve_time
            + ", delay_time="
            + this.delay_time
            + ", guid="
            + this.guid
            + ", height="
            + this.height
            + ", mark_length="
            + this.mark_length
            + ", mark_point="
            + this.mark_point
            + ", marks_Count="
            + this.marks_Count
            + ", move_length="
            + this.move_length
            + ", move_time="
            + this.move_time
            + ", name="
            + this.name
            + ", nest_area="
            + this.nest_area
            + ", nest_x="
            + this.nest_x
            + ", nest_y="
            + this.nest_y
            + ", nestedrec_area="
            + this.nestedrec_area
            + ", part_amount="
            + this.part_amount
            + ", part_info="
            + this.part_info
            + ", partnet_area="
            + this.partnet_area
            + ", pierce_count="
            + this.pierce_count
            + ", pierce_time="
            + this.pierce_time
            + ", remnant_area="
            + this.remnant_area
            + ", total_time="
            + this.total_time
            + ", utilization="
            + this.utilization
            + ", uuid="
            + this.uuid
            + ", width="
            + this.width
            + ", nest_name="
            + this.nest_name
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", gas="
            + this.gas
            + ", utilization_slab="
            + this.utilization_slab
            + ", utilization_nestedrec="
            + this.utilization_nestedrec
            + ", utilization_nestedrec_slab="
            + this.utilization_nestedrec_slab
            + ", abnormal_info="
            + this.abnormal_info
            + ", plate_guid="
            + this.plate_guid
            + ", density="
            + this.density
            + ")";
      }
   }
}
