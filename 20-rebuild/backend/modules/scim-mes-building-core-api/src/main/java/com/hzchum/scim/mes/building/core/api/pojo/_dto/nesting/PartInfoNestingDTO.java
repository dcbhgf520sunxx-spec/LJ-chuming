package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel(value = "套料报告单第三部分", description = "套料报告单第三部分")
public class PartInfoNestingDTO {
   @JsonProperty("ID")
   private String ID;
   private int amount;
   private int amount_used;
   private String area;
   private String area_exclude_comp;
   private String curve_length;
   private String curve_time;
   private double height;
   private String inner_area;
   private int inner_count;
   private String inner_length;
   private int mark_count;
   private String mark_length;
   private int mark_point;
   private String name;
   private String out_area;
   private String out_area_exclude_comp;
   private String outline_length;
   private int pierce_count;
   private double width;
   private String guid;
   private String material;
   private String thickness;
   private String gas;
   private double material_price;
   private double hole_price;
   private double cut_price;
   private double mark_price;
   private String thumbnail_url;
   private String job_name;
   private double rect_area;
   private String out_line;
   private String inner_line;
   private int contours_count;
   private double weight;
   private double weight_exclude_comp;
   private double density;
   private List<PropsDTO> props;

   public static PartInfoNestingDTO.PartInfoNestingDTOBuilder builder() {
      return new PartInfoNestingDTO.PartInfoNestingDTOBuilder();
   }

   public PartInfoNestingDTO(
      final String ID,
      final int amount,
      final int amount_used,
      final String area,
      final String area_exclude_comp,
      final String curve_length,
      final String curve_time,
      final double height,
      final String inner_area,
      final int inner_count,
      final String inner_length,
      final int mark_count,
      final String mark_length,
      final int mark_point,
      final String name,
      final String out_area,
      final String out_area_exclude_comp,
      final String outline_length,
      final int pierce_count,
      final double width,
      final String guid,
      final String material,
      final String thickness,
      final String gas,
      final double material_price,
      final double hole_price,
      final double cut_price,
      final double mark_price,
      final String thumbnail_url,
      final String job_name,
      final double rect_area,
      final String out_line,
      final String inner_line,
      final int contours_count,
      final double weight,
      final double weight_exclude_comp,
      final double density,
      final List<PropsDTO> props
   ) {
      this.ID = ID;
      this.amount = amount;
      this.amount_used = amount_used;
      this.area = area;
      this.area_exclude_comp = area_exclude_comp;
      this.curve_length = curve_length;
      this.curve_time = curve_time;
      this.height = height;
      this.inner_area = inner_area;
      this.inner_count = inner_count;
      this.inner_length = inner_length;
      this.mark_count = mark_count;
      this.mark_length = mark_length;
      this.mark_point = mark_point;
      this.name = name;
      this.out_area = out_area;
      this.out_area_exclude_comp = out_area_exclude_comp;
      this.outline_length = outline_length;
      this.pierce_count = pierce_count;
      this.width = width;
      this.guid = guid;
      this.material = material;
      this.thickness = thickness;
      this.gas = gas;
      this.material_price = material_price;
      this.hole_price = hole_price;
      this.cut_price = cut_price;
      this.mark_price = mark_price;
      this.thumbnail_url = thumbnail_url;
      this.job_name = job_name;
      this.rect_area = rect_area;
      this.out_line = out_line;
      this.inner_line = inner_line;
      this.contours_count = contours_count;
      this.weight = weight;
      this.weight_exclude_comp = weight_exclude_comp;
      this.density = density;
      this.props = props;
   }

   public PartInfoNestingDTO() {
   }

   public String getID() {
      return this.ID;
   }

   public int getAmount() {
      return this.amount;
   }

   public int getAmount_used() {
      return this.amount_used;
   }

   public String getArea() {
      return this.area;
   }

   public String getArea_exclude_comp() {
      return this.area_exclude_comp;
   }

   public String getCurve_length() {
      return this.curve_length;
   }

   public String getCurve_time() {
      return this.curve_time;
   }

   public double getHeight() {
      return this.height;
   }

   public String getInner_area() {
      return this.inner_area;
   }

   public int getInner_count() {
      return this.inner_count;
   }

   public String getInner_length() {
      return this.inner_length;
   }

   public int getMark_count() {
      return this.mark_count;
   }

   public String getMark_length() {
      return this.mark_length;
   }

   public int getMark_point() {
      return this.mark_point;
   }

   public String getName() {
      return this.name;
   }

   public String getOut_area() {
      return this.out_area;
   }

   public String getOut_area_exclude_comp() {
      return this.out_area_exclude_comp;
   }

   public String getOutline_length() {
      return this.outline_length;
   }

   public int getPierce_count() {
      return this.pierce_count;
   }

   public double getWidth() {
      return this.width;
   }

   public String getGuid() {
      return this.guid;
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

   public double getMaterial_price() {
      return this.material_price;
   }

   public double getHole_price() {
      return this.hole_price;
   }

   public double getCut_price() {
      return this.cut_price;
   }

   public double getMark_price() {
      return this.mark_price;
   }

   public String getThumbnail_url() {
      return this.thumbnail_url;
   }

   public String getJob_name() {
      return this.job_name;
   }

   public double getRect_area() {
      return this.rect_area;
   }

   public String getOut_line() {
      return this.out_line;
   }

   public String getInner_line() {
      return this.inner_line;
   }

   public int getContours_count() {
      return this.contours_count;
   }

   public double getWeight() {
      return this.weight;
   }

   public double getWeight_exclude_comp() {
      return this.weight_exclude_comp;
   }

   public double getDensity() {
      return this.density;
   }

   public List<PropsDTO> getProps() {
      return this.props;
   }

   @JsonProperty("ID")
   public PartInfoNestingDTO setID(final String ID) {
      this.ID = ID;
      return this;
   }

   public PartInfoNestingDTO setAmount(final int amount) {
      this.amount = amount;
      return this;
   }

   public PartInfoNestingDTO setAmount_used(final int amount_used) {
      this.amount_used = amount_used;
      return this;
   }

   public PartInfoNestingDTO setArea(final String area) {
      this.area = area;
      return this;
   }

   public PartInfoNestingDTO setArea_exclude_comp(final String area_exclude_comp) {
      this.area_exclude_comp = area_exclude_comp;
      return this;
   }

   public PartInfoNestingDTO setCurve_length(final String curve_length) {
      this.curve_length = curve_length;
      return this;
   }

   public PartInfoNestingDTO setCurve_time(final String curve_time) {
      this.curve_time = curve_time;
      return this;
   }

   public PartInfoNestingDTO setHeight(final double height) {
      this.height = height;
      return this;
   }

   public PartInfoNestingDTO setInner_area(final String inner_area) {
      this.inner_area = inner_area;
      return this;
   }

   public PartInfoNestingDTO setInner_count(final int inner_count) {
      this.inner_count = inner_count;
      return this;
   }

   public PartInfoNestingDTO setInner_length(final String inner_length) {
      this.inner_length = inner_length;
      return this;
   }

   public PartInfoNestingDTO setMark_count(final int mark_count) {
      this.mark_count = mark_count;
      return this;
   }

   public PartInfoNestingDTO setMark_length(final String mark_length) {
      this.mark_length = mark_length;
      return this;
   }

   public PartInfoNestingDTO setMark_point(final int mark_point) {
      this.mark_point = mark_point;
      return this;
   }

   public PartInfoNestingDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public PartInfoNestingDTO setOut_area(final String out_area) {
      this.out_area = out_area;
      return this;
   }

   public PartInfoNestingDTO setOut_area_exclude_comp(final String out_area_exclude_comp) {
      this.out_area_exclude_comp = out_area_exclude_comp;
      return this;
   }

   public PartInfoNestingDTO setOutline_length(final String outline_length) {
      this.outline_length = outline_length;
      return this;
   }

   public PartInfoNestingDTO setPierce_count(final int pierce_count) {
      this.pierce_count = pierce_count;
      return this;
   }

   public PartInfoNestingDTO setWidth(final double width) {
      this.width = width;
      return this;
   }

   public PartInfoNestingDTO setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public PartInfoNestingDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public PartInfoNestingDTO setThickness(final String thickness) {
      this.thickness = thickness;
      return this;
   }

   public PartInfoNestingDTO setGas(final String gas) {
      this.gas = gas;
      return this;
   }

   public PartInfoNestingDTO setMaterial_price(final double material_price) {
      this.material_price = material_price;
      return this;
   }

   public PartInfoNestingDTO setHole_price(final double hole_price) {
      this.hole_price = hole_price;
      return this;
   }

   public PartInfoNestingDTO setCut_price(final double cut_price) {
      this.cut_price = cut_price;
      return this;
   }

   public PartInfoNestingDTO setMark_price(final double mark_price) {
      this.mark_price = mark_price;
      return this;
   }

   public PartInfoNestingDTO setThumbnail_url(final String thumbnail_url) {
      this.thumbnail_url = thumbnail_url;
      return this;
   }

   public PartInfoNestingDTO setJob_name(final String job_name) {
      this.job_name = job_name;
      return this;
   }

   public PartInfoNestingDTO setRect_area(final double rect_area) {
      this.rect_area = rect_area;
      return this;
   }

   public PartInfoNestingDTO setOut_line(final String out_line) {
      this.out_line = out_line;
      return this;
   }

   public PartInfoNestingDTO setInner_line(final String inner_line) {
      this.inner_line = inner_line;
      return this;
   }

   public PartInfoNestingDTO setContours_count(final int contours_count) {
      this.contours_count = contours_count;
      return this;
   }

   public PartInfoNestingDTO setWeight(final double weight) {
      this.weight = weight;
      return this;
   }

   public PartInfoNestingDTO setWeight_exclude_comp(final double weight_exclude_comp) {
      this.weight_exclude_comp = weight_exclude_comp;
      return this;
   }

   public PartInfoNestingDTO setDensity(final double density) {
      this.density = density;
      return this;
   }

   public PartInfoNestingDTO setProps(final List<PropsDTO> props) {
      this.props = props;
      return this;
   }

   @Override
   public String toString() {
      return "PartInfoNestingDTO(ID="
         + this.getID()
         + ", amount="
         + this.getAmount()
         + ", amount_used="
         + this.getAmount_used()
         + ", area="
         + this.getArea()
         + ", area_exclude_comp="
         + this.getArea_exclude_comp()
         + ", curve_length="
         + this.getCurve_length()
         + ", curve_time="
         + this.getCurve_time()
         + ", height="
         + this.getHeight()
         + ", inner_area="
         + this.getInner_area()
         + ", inner_count="
         + this.getInner_count()
         + ", inner_length="
         + this.getInner_length()
         + ", mark_count="
         + this.getMark_count()
         + ", mark_length="
         + this.getMark_length()
         + ", mark_point="
         + this.getMark_point()
         + ", name="
         + this.getName()
         + ", out_area="
         + this.getOut_area()
         + ", out_area_exclude_comp="
         + this.getOut_area_exclude_comp()
         + ", outline_length="
         + this.getOutline_length()
         + ", pierce_count="
         + this.getPierce_count()
         + ", width="
         + this.getWidth()
         + ", guid="
         + this.getGuid()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", gas="
         + this.getGas()
         + ", material_price="
         + this.getMaterial_price()
         + ", hole_price="
         + this.getHole_price()
         + ", cut_price="
         + this.getCut_price()
         + ", mark_price="
         + this.getMark_price()
         + ", thumbnail_url="
         + this.getThumbnail_url()
         + ", job_name="
         + this.getJob_name()
         + ", rect_area="
         + this.getRect_area()
         + ", out_line="
         + this.getOut_line()
         + ", inner_line="
         + this.getInner_line()
         + ", contours_count="
         + this.getContours_count()
         + ", weight="
         + this.getWeight()
         + ", weight_exclude_comp="
         + this.getWeight_exclude_comp()
         + ", density="
         + this.getDensity()
         + ", props="
         + this.getProps()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartInfoNestingDTO)) {
         return false;
      }

      PartInfoNestingDTO other = (PartInfoNestingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getAmount() != other.getAmount()) {
         return false;
      }

      if (this.getAmount_used() != other.getAmount_used()) {
         return false;
      }

      if (Double.compare(this.getHeight(), other.getHeight()) != 0) {
         return false;
      }

      if (this.getInner_count() != other.getInner_count()) {
         return false;
      }

      if (this.getMark_count() != other.getMark_count()) {
         return false;
      }

      if (this.getMark_point() != other.getMark_point()) {
         return false;
      }

      if (this.getPierce_count() != other.getPierce_count()) {
         return false;
      }

      if (Double.compare(this.getWidth(), other.getWidth()) != 0) {
         return false;
      }

      if (Double.compare(this.getMaterial_price(), other.getMaterial_price()) != 0) {
         return false;
      }

      if (Double.compare(this.getHole_price(), other.getHole_price()) != 0) {
         return false;
      }

      if (Double.compare(this.getCut_price(), other.getCut_price()) != 0) {
         return false;
      }

      if (Double.compare(this.getMark_price(), other.getMark_price()) != 0) {
         return false;
      }

      if (Double.compare(this.getRect_area(), other.getRect_area()) != 0) {
         return false;
      }

      if (this.getContours_count() != other.getContours_count()) {
         return false;
      }

      if (Double.compare(this.getWeight(), other.getWeight()) != 0) {
         return false;
      }

      if (Double.compare(this.getWeight_exclude_comp(), other.getWeight_exclude_comp()) != 0) {
         return false;
      }

      if (Double.compare(this.getDensity(), other.getDensity()) != 0) {
         return false;
      }

      Object this$ID = this.getID();
      Object other$ID = other.getID();
      if (this$ID == null ? other$ID == null : this$ID.equals(other$ID)) {
         Object this$area = this.getArea();
         Object other$area = other.getArea();
         if (this$area == null ? other$area == null : this$area.equals(other$area)) {
            Object this$area_exclude_comp = this.getArea_exclude_comp();
            Object other$area_exclude_comp = other.getArea_exclude_comp();
            if (this$area_exclude_comp == null ? other$area_exclude_comp == null : this$area_exclude_comp.equals(other$area_exclude_comp)) {
               Object this$curve_length = this.getCurve_length();
               Object other$curve_length = other.getCurve_length();
               if (this$curve_length == null ? other$curve_length == null : this$curve_length.equals(other$curve_length)) {
                  Object this$curve_time = this.getCurve_time();
                  Object other$curve_time = other.getCurve_time();
                  if (this$curve_time == null ? other$curve_time == null : this$curve_time.equals(other$curve_time)) {
                     Object this$inner_area = this.getInner_area();
                     Object other$inner_area = other.getInner_area();
                     if (this$inner_area == null ? other$inner_area == null : this$inner_area.equals(other$inner_area)) {
                        Object this$inner_length = this.getInner_length();
                        Object other$inner_length = other.getInner_length();
                        if (this$inner_length == null ? other$inner_length == null : this$inner_length.equals(other$inner_length)) {
                           Object this$mark_length = this.getMark_length();
                           Object other$mark_length = other.getMark_length();
                           if (this$mark_length == null ? other$mark_length == null : this$mark_length.equals(other$mark_length)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$out_area = this.getOut_area();
                                 Object other$out_area = other.getOut_area();
                                 if (this$out_area == null ? other$out_area == null : this$out_area.equals(other$out_area)) {
                                    Object this$out_area_exclude_comp = this.getOut_area_exclude_comp();
                                    Object other$out_area_exclude_comp = other.getOut_area_exclude_comp();
                                    if (this$out_area_exclude_comp == null
                                       ? other$out_area_exclude_comp == null
                                       : this$out_area_exclude_comp.equals(other$out_area_exclude_comp)) {
                                       Object this$outline_length = this.getOutline_length();
                                       Object other$outline_length = other.getOutline_length();
                                       if (this$outline_length == null ? other$outline_length == null : this$outline_length.equals(other$outline_length)) {
                                          Object this$guid = this.getGuid();
                                          Object other$guid = other.getGuid();
                                          if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                                             Object this$material = this.getMaterial();
                                             Object other$material = other.getMaterial();
                                             if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                Object this$thickness = this.getThickness();
                                                Object other$thickness = other.getThickness();
                                                if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                   Object this$gas = this.getGas();
                                                   Object other$gas = other.getGas();
                                                   if (this$gas == null ? other$gas == null : this$gas.equals(other$gas)) {
                                                      Object this$thumbnail_url = this.getThumbnail_url();
                                                      Object other$thumbnail_url = other.getThumbnail_url();
                                                      if (this$thumbnail_url == null
                                                         ? other$thumbnail_url == null
                                                         : this$thumbnail_url.equals(other$thumbnail_url)) {
                                                         Object this$job_name = this.getJob_name();
                                                         Object other$job_name = other.getJob_name();
                                                         if (this$job_name == null ? other$job_name == null : this$job_name.equals(other$job_name)) {
                                                            Object this$out_line = this.getOut_line();
                                                            Object other$out_line = other.getOut_line();
                                                            if (this$out_line == null ? other$out_line == null : this$out_line.equals(other$out_line)) {
                                                               Object this$inner_line = this.getInner_line();
                                                               Object other$inner_line = other.getInner_line();
                                                               if (this$inner_line == null
                                                                  ? other$inner_line == null
                                                                  : this$inner_line.equals(other$inner_line)) {
                                                                  Object this$props = this.getProps();
                                                                  Object other$props = other.getProps();
                                                                  return this$props == null ? other$props == null : this$props.equals(other$props);
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
      return other instanceof PartInfoNestingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getAmount();
      result = result * 59 + this.getAmount_used();
      long $height = Double.doubleToLongBits(this.getHeight());
      result = result * 59 + (int)($height >>> 32 ^ $height);
      result = result * 59 + this.getInner_count();
      result = result * 59 + this.getMark_count();
      result = result * 59 + this.getMark_point();
      result = result * 59 + this.getPierce_count();
      long $width = Double.doubleToLongBits(this.getWidth());
      result = result * 59 + (int)($width >>> 32 ^ $width);
      long $material_price = Double.doubleToLongBits(this.getMaterial_price());
      result = result * 59 + (int)($material_price >>> 32 ^ $material_price);
      long $hole_price = Double.doubleToLongBits(this.getHole_price());
      result = result * 59 + (int)($hole_price >>> 32 ^ $hole_price);
      long $cut_price = Double.doubleToLongBits(this.getCut_price());
      result = result * 59 + (int)($cut_price >>> 32 ^ $cut_price);
      long $mark_price = Double.doubleToLongBits(this.getMark_price());
      result = result * 59 + (int)($mark_price >>> 32 ^ $mark_price);
      long $rect_area = Double.doubleToLongBits(this.getRect_area());
      result = result * 59 + (int)($rect_area >>> 32 ^ $rect_area);
      result = result * 59 + this.getContours_count();
      long $weight = Double.doubleToLongBits(this.getWeight());
      result = result * 59 + (int)($weight >>> 32 ^ $weight);
      long $weight_exclude_comp = Double.doubleToLongBits(this.getWeight_exclude_comp());
      result = result * 59 + (int)($weight_exclude_comp >>> 32 ^ $weight_exclude_comp);
      long $density = Double.doubleToLongBits(this.getDensity());
      result = result * 59 + (int)($density >>> 32 ^ $density);
      Object $ID = this.getID();
      result = result * 59 + ($ID == null ? 43 : $ID.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $area_exclude_comp = this.getArea_exclude_comp();
      result = result * 59 + ($area_exclude_comp == null ? 43 : $area_exclude_comp.hashCode());
      Object $curve_length = this.getCurve_length();
      result = result * 59 + ($curve_length == null ? 43 : $curve_length.hashCode());
      Object $curve_time = this.getCurve_time();
      result = result * 59 + ($curve_time == null ? 43 : $curve_time.hashCode());
      Object $inner_area = this.getInner_area();
      result = result * 59 + ($inner_area == null ? 43 : $inner_area.hashCode());
      Object $inner_length = this.getInner_length();
      result = result * 59 + ($inner_length == null ? 43 : $inner_length.hashCode());
      Object $mark_length = this.getMark_length();
      result = result * 59 + ($mark_length == null ? 43 : $mark_length.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $out_area = this.getOut_area();
      result = result * 59 + ($out_area == null ? 43 : $out_area.hashCode());
      Object $out_area_exclude_comp = this.getOut_area_exclude_comp();
      result = result * 59 + ($out_area_exclude_comp == null ? 43 : $out_area_exclude_comp.hashCode());
      Object $outline_length = this.getOutline_length();
      result = result * 59 + ($outline_length == null ? 43 : $outline_length.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $gas = this.getGas();
      result = result * 59 + ($gas == null ? 43 : $gas.hashCode());
      Object $thumbnail_url = this.getThumbnail_url();
      result = result * 59 + ($thumbnail_url == null ? 43 : $thumbnail_url.hashCode());
      Object $job_name = this.getJob_name();
      result = result * 59 + ($job_name == null ? 43 : $job_name.hashCode());
      Object $out_line = this.getOut_line();
      result = result * 59 + ($out_line == null ? 43 : $out_line.hashCode());
      Object $inner_line = this.getInner_line();
      result = result * 59 + ($inner_line == null ? 43 : $inner_line.hashCode());
      Object $props = this.getProps();
      return result * 59 + ($props == null ? 43 : $props.hashCode());
   }

   public static class PartInfoNestingDTOBuilder {
      private String ID;
      private int amount;
      private int amount_used;
      private String area;
      private String area_exclude_comp;
      private String curve_length;
      private String curve_time;
      private double height;
      private String inner_area;
      private int inner_count;
      private String inner_length;
      private int mark_count;
      private String mark_length;
      private int mark_point;
      private String name;
      private String out_area;
      private String out_area_exclude_comp;
      private String outline_length;
      private int pierce_count;
      private double width;
      private String guid;
      private String material;
      private String thickness;
      private String gas;
      private double material_price;
      private double hole_price;
      private double cut_price;
      private double mark_price;
      private String thumbnail_url;
      private String job_name;
      private double rect_area;
      private String out_line;
      private String inner_line;
      private int contours_count;
      private double weight;
      private double weight_exclude_comp;
      private double density;
      private List<PropsDTO> props;

      PartInfoNestingDTOBuilder() {
      }

      @JsonProperty("ID")
      public PartInfoNestingDTO.PartInfoNestingDTOBuilder ID(final String ID) {
         this.ID = ID;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder amount(final int amount) {
         this.amount = amount;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder amount_used(final int amount_used) {
         this.amount_used = amount_used;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder area(final String area) {
         this.area = area;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder area_exclude_comp(final String area_exclude_comp) {
         this.area_exclude_comp = area_exclude_comp;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder curve_length(final String curve_length) {
         this.curve_length = curve_length;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder curve_time(final String curve_time) {
         this.curve_time = curve_time;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder height(final double height) {
         this.height = height;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder inner_area(final String inner_area) {
         this.inner_area = inner_area;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder inner_count(final int inner_count) {
         this.inner_count = inner_count;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder inner_length(final String inner_length) {
         this.inner_length = inner_length;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder mark_count(final int mark_count) {
         this.mark_count = mark_count;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder mark_length(final String mark_length) {
         this.mark_length = mark_length;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder mark_point(final int mark_point) {
         this.mark_point = mark_point;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder out_area(final String out_area) {
         this.out_area = out_area;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder out_area_exclude_comp(final String out_area_exclude_comp) {
         this.out_area_exclude_comp = out_area_exclude_comp;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder outline_length(final String outline_length) {
         this.outline_length = outline_length;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder pierce_count(final int pierce_count) {
         this.pierce_count = pierce_count;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder width(final double width) {
         this.width = width;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder gas(final String gas) {
         this.gas = gas;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder material_price(final double material_price) {
         this.material_price = material_price;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder hole_price(final double hole_price) {
         this.hole_price = hole_price;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder cut_price(final double cut_price) {
         this.cut_price = cut_price;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder mark_price(final double mark_price) {
         this.mark_price = mark_price;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder thumbnail_url(final String thumbnail_url) {
         this.thumbnail_url = thumbnail_url;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder job_name(final String job_name) {
         this.job_name = job_name;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder rect_area(final double rect_area) {
         this.rect_area = rect_area;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder out_line(final String out_line) {
         this.out_line = out_line;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder inner_line(final String inner_line) {
         this.inner_line = inner_line;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder contours_count(final int contours_count) {
         this.contours_count = contours_count;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder weight(final double weight) {
         this.weight = weight;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder weight_exclude_comp(final double weight_exclude_comp) {
         this.weight_exclude_comp = weight_exclude_comp;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder density(final double density) {
         this.density = density;
         return this;
      }

      public PartInfoNestingDTO.PartInfoNestingDTOBuilder props(final List<PropsDTO> props) {
         this.props = props;
         return this;
      }

      public PartInfoNestingDTO build() {
         return new PartInfoNestingDTO(
            this.ID,
            this.amount,
            this.amount_used,
            this.area,
            this.area_exclude_comp,
            this.curve_length,
            this.curve_time,
            this.height,
            this.inner_area,
            this.inner_count,
            this.inner_length,
            this.mark_count,
            this.mark_length,
            this.mark_point,
            this.name,
            this.out_area,
            this.out_area_exclude_comp,
            this.outline_length,
            this.pierce_count,
            this.width,
            this.guid,
            this.material,
            this.thickness,
            this.gas,
            this.material_price,
            this.hole_price,
            this.cut_price,
            this.mark_price,
            this.thumbnail_url,
            this.job_name,
            this.rect_area,
            this.out_line,
            this.inner_line,
            this.contours_count,
            this.weight,
            this.weight_exclude_comp,
            this.density,
            this.props
         );
      }

      @Override
      public String toString() {
         return "PartInfoNestingDTO.PartInfoNestingDTOBuilder(ID="
            + this.ID
            + ", amount="
            + this.amount
            + ", amount_used="
            + this.amount_used
            + ", area="
            + this.area
            + ", area_exclude_comp="
            + this.area_exclude_comp
            + ", curve_length="
            + this.curve_length
            + ", curve_time="
            + this.curve_time
            + ", height="
            + this.height
            + ", inner_area="
            + this.inner_area
            + ", inner_count="
            + this.inner_count
            + ", inner_length="
            + this.inner_length
            + ", mark_count="
            + this.mark_count
            + ", mark_length="
            + this.mark_length
            + ", mark_point="
            + this.mark_point
            + ", name="
            + this.name
            + ", out_area="
            + this.out_area
            + ", out_area_exclude_comp="
            + this.out_area_exclude_comp
            + ", outline_length="
            + this.outline_length
            + ", pierce_count="
            + this.pierce_count
            + ", width="
            + this.width
            + ", guid="
            + this.guid
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", gas="
            + this.gas
            + ", material_price="
            + this.material_price
            + ", hole_price="
            + this.hole_price
            + ", cut_price="
            + this.cut_price
            + ", mark_price="
            + this.mark_price
            + ", thumbnail_url="
            + this.thumbnail_url
            + ", job_name="
            + this.job_name
            + ", rect_area="
            + this.rect_area
            + ", out_line="
            + this.out_line
            + ", inner_line="
            + this.inner_line
            + ", contours_count="
            + this.contours_count
            + ", weight="
            + this.weight
            + ", weight_exclude_comp="
            + this.weight_exclude_comp
            + ", density="
            + this.density
            + ", props="
            + this.props
            + ")";
      }
   }
}
