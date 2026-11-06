import { ref as R } from "vue";
import { inject as x } from "vue";
import { computed as te } from "vue";
import { watch as I } from "vue";
import { ElMessage as O } from "element-plus";
import { resolveComponent as q } from "vue";
import { openBlock as c } from "vue";
import { createBlock as f } from "vue";
import { withCtx as u } from "vue";
import { createVNode as d } from "vue";
import { unref as l } from "vue";
import { createTextVNode as V } from "vue";
import { createCommentVNode as E } from "vue";
import { toDisplayString as b } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as le } from "vue";
import { ElTableColumn as ae } from "element-plus";
import { ElInput as oe } from "element-plus";
import { ElInputNumber as re } from "element-plus";
import { ElForm as ie } from "element-plus";
import { _ as ne, ao as de, o as ue, T as i, jx as se, fK as W, D as g } from "../../../../../shared/runtime.js";
const me = { key: 1 }, he = { key: 1 }, ce = { class: "add-row-box" }, pe = { __name: "form", setup(fe) {
  const L = R(), P = R(), y = R({}), D = { list: [] }, B = { key: "id", label: "plateType", value: "id" }, F = { key: "id", label: "serialNumber", value: "id" }, G = { key: "name", label: "name", value: "name" }, N = x("plateOption"), _ = x("technicalTypeStatus"), U = R(), { CRUD: $, crud: o, form: m } = de(D, L), { maxHeight: H } = ue({ mainBox: ".detail", extraBox: [".el-drawer__header"], wrapperBox: ".table-form", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, U), K = (e, r) => o.query.category === i.BENDING.V ? !!e : true, z = (e, r) => o.query.category !== i.BENDING.V ? !!e : true, j = { name: [{ required: true, message: "请输入名称", trigger: "blur" }], serialNumber: [{ required: true, message: "请输入编号", trigger: "blur" }], unfoldedWidth: [{ validator: K, message: "展开宽度必填", trigger: "change" }], width: [{ validator: (e, r) => o.query.category !== i.BENDING.V ? !!e : true, message: "有效宽度必填", trigger: "change" }], thickness: [{ validator: (e, r) => o.query.category !== i.TRUSS_FLOOR_PLATE.V ? !!e : true, message: "厚度必填", trigger: "change" }], length: [{ required: true, message: "单长必填", trigger: "change" }], quantity: [{ required: true, message: "数量必填", trigger: "change" }], totalArea: [{ required: true, message: "总面积必填", trigger: "change" }], totalLength: [{ required: true, message: "总长度必填", trigger: "change" }], bendTimes: [{ validator: (e, r) => o.query.category === i.BENDING.V ? !!e : true, message: "折弯次数必填", trigger: "change" }], color: [{ validator: (e, r) => o.query.category === i.BENDING.V || o.query.category === i.PROFILED_PLATE.V ? !!e : true, message: "请输入颜色", trigger: "blur" }] }, S = te(() => {
    let e = {};
    return _.value ? e = { plateId: [{ validator: z, message: "请选择板型", trigger: "change" }] } : e = { plate: [{ required: true, message: "请选择板型", trigger: "change" }] }, { ...j, ...e };
  });
  I(() => o.query.category, () => {
    M();
  }, { immediate: true }), I(() => _.value, () => {
    M();
  }, { immediate: true });
  async function M() {
    if (y.value = {}, !(_.value || !o.query.category || o.query.category === i.BENDING.V)) try {
      const { content: e = [] } = await se(o.query.category) || {}, r = {};
      o.query.category === i.TRUSS_FLOOR_PLATE.V ? y.value.plate_type = e.map((s) => {
        let a = "", h = "";
        return s == null || s.list.forEach((p) => {
          p.name === "effectiveWidth" && (a = p.value), p.name === "weightMeter" && (h = p.value);
        }), r[s.code] = { effectiveWidth: a, weightMeter: h }, { name: s.code };
      }) : e.forEach((s) => {
        s.name === "plate_type" && ((s.plateTypeList || []).forEach((a) => {
          r[a.plateType] = a;
        }), y.value[s.name] = (s.labels || []).map((a) => ({ name: a })));
      }), y.value.KV = r;
    } catch (e) {
      console.log("获取围护配置信息列表", e);
    }
  }
  function J({ row: e, column: r }) {
    if (!e) return;
    const s = S.value;
    let a = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[r.property] === false && (a = W(r.property, s[r.property], e)), a && (e.verify[r.property] = true)), a ? "" : "mask-td";
  }
  function Q(e) {
    m.list.splice(e, 1);
  }
  function X() {
    m.list.push({ areaId: o.query.areaId });
  }
  function T(e, r) {
    var s;
    if (e.plateId) {
      const a = N.value.find((h) => h.id === e.plateId);
      o.query.category === i.TRUSS_FLOOR_PLATE.V ? (m.list[r].plate = a.serialNumber, m.list[r].weightMeter = a.weightMeter) : (m.list[r].plate = a.plateType, m.list[r].brand = a.brand, m.list[r].thickness = a.thickness, m.list[r].color = a.colour, m.list[r].unfoldedWidth = a.unfoldedWidth), m.list[r].width = a.effectiveWidth;
    } else {
      const a = ((s = y.value.KV) == null ? void 0 : s[e.plate]) || {};
      o.query.category === i.TRUSS_FLOOR_PLATE.V ? (m.list[r].width = +a.effectiveWidth, m.list[r].weightMeter = +a.weightMeter) : (o.query.category === i.PROFILED_PLATE.V || o.query.category === i.PRESSURE_BEARING_PLATE.V) && (m.list[r].width = +a.effectiveWidth, m.list[r].unfoldedWidth = +a.unfoldedWidth);
    }
    v(e);
  }
  function v(e) {
    e.length && e.quantity && (e.totalLength = e.length * e.quantity / 1e3, C(e)), o.query.category === i.BENDING.V || o.query.category === i.PROFILED_PLATE.V || o.query.category === i.PRESSURE_BEARING_PLATE.V ? e.length && e.quantity && e.unfoldedWidth && (e.totalArea = e.unfoldedWidth * e.length * e.quantity / 1e6) : e.length && e.quantity && e.width && (e.totalArea = e.width * e.length * e.quantity / 1e6);
  }
  function C(e) {
    o.query.category === i.BENDING.V || o.query.category === i.PROFILED_PLATE.V || o.query.category === i.PRESSURE_BEARING_PLATE.V ? e.unfoldedWidth && e.thickness && e.totalLength && (e.totalWeight = e.unfoldedWidth / 1e3 * e.thickness * e.totalLength * 7.85) : o.query.category === i.TRUSS_FLOOR_PLATE.V && e.weightMeter && e.totalLength && (e.totalWeight = e.weightMeter * e.totalLength);
  }
  return $.HOOK.beforeValidateCU = (e, r) => {
    if (e.form.list.length <= 0) return O({ message: "请先添加围护信息", type: "error" }), false;
    const s = S.value;
    let a = true;
    if (e.form.list.map((h) => {
      h.verify = {};
      for (const p in s) h.verify[p] = W(p, s[p], h), h.verify[p] || (a = false);
    }), !a) return O.error("请填写表格中标红数据"), false;
    e.form.planId = e.query.enclosurePlanId;
  }, (e, r) => {
    const s = q("common-button"), a = ae, h = oe, p = q("common-select"), w = re, Y = q("common-table"), Z = ie, ee = q("common-drawer");
    return c(), f(ee, { ref_key: "drawerRef", ref: U, "append-to-body": "", "close-on-click-modal": false, "before-close": l(o).cancelCU, visible: l(o).status.cu > 0, title: l(o).status.title, "wrapper-closable": false, "custom-class": "detail", size: "100%" }, { titleRight: u(() => [d(s, { loading: l(o).status.cu === 2, type: "primary", size: "default", onClick: l(o).submitCU }, { default: u(() => r[1] || (r[1] = [V("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: u(() => [d(Z, { ref_key: "formRef", ref: L, model: l(m), size: "default", "label-width": "140px" }, { default: u(() => [d(Y, { ref_key: "detailRef", ref: P, border: "", data: l(m).list, "max-height": l(H) - 150, "return-source-data": "", showEmptySymbol: false, style: { width: "100%" }, class: "table-form", "cell-class-name": J }, { default: u(() => [d(a, { label: "序号", type: "index", align: "center", width: "55", fixed: "left" }), d(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "100" }, { default: u((t) => [d(h, { modelValue: t.row.name, "onUpdate:modelValue": (n) => t.row.name = n, placeholder: "名称", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), d(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "90px" }, { default: u((t) => [d(h, { modelValue: t.row.serialNumber, "onUpdate:modelValue": (n) => t.row.serialNumber = n, placeholder: "编号", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(o).query.category !== l(i).BENDING.V ? (c(), f(a, { key: l(_) ? "plateId" : "plate", prop: l(_) ? "plateId" : "plate", "show-overflow-tooltip": true, label: "板型", "min-width": "100px" }, { default: u((t) => {
      var n;
      return [l(_) ? (c(), f(p, { key: 0, modelValue: t.row.plateId, "onUpdate:modelValue": (k) => t.row.plateId = k, options: l(N), type: "other", dataStructure: l(o).query.category === l(i).TRUSS_FLOOR_PLATE.V ? F : B, size: "default", placeholder: "板型", onChange: (k) => T(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "dataStructure", "onChange"])) : (c(), f(p, { key: 1, modelValue: t.row.plate, "onUpdate:modelValue": (k) => t.row.plate = k, options: (n = y.value) == null ? void 0 : n.plate_type, dataStructure: G, size: "default", placeholder: "板型", onChange: (k) => T(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))];
    }), _: 1 }, 8, ["prop"])) : E("", true), d(a, { key: "weightMeter", prop: "weightMeter", label: "米重(kg/m)", align: "left", width: "100px" }, { default: u((t) => [V(b(t.row.weightMeter ? t.row.weightMeter.toFixed(l(g).COM_WT__KG) : "-"), 1)]), _: 1 }), l(o).query.category !== l(i).BENDING.V ? (c(), f(a, { key: "width", prop: "width", "show-overflow-tooltip": true, label: l(o).query.category === l(i).SANDWICH_BOARD.V ? `宽度
(mm)` : `有效宽度
(mm)`, "min-width": "100px" }, { default: u((t) => [l(o).query.category !== l(i).PROFILED_PLATE.V && l(o).query.category !== l(i).PRESSURE_BEARING_PLATE.V ? (c(), f(w, { key: 0, modelValue: t.row.width, "onUpdate:modelValue": (n) => t.row.width = n, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: l(g).MES_ENCLOSURE_W__MM, placeholder: "有效宽度", "controls-position": "right", style: { width: "100%" }, onChange: (n) => v(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (c(), A("div", me, b(t.row.width ? t.row.width.toFixed(l(g).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 }, 8, ["label"])) : E("", true), l(o).query.category === l(i).BENDING.V || l(o).query.category === l(i).PROFILED_PLATE.V || l(o).query.category === l(i).PRESSURE_BEARING_PLATE.V ? (c(), f(a, { key: "unfoldedWidth", prop: "unfoldedWidth", "show-overflow-tooltip": true, label: `展开宽度
(mm)`, "min-width": "100px" }, { default: u((t) => [l(o).query.category === l(i).BENDING.V ? (c(), f(w, { key: 0, modelValue: t.row.unfoldedWidth, "onUpdate:modelValue": (n) => t.row.unfoldedWidth = n, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: l(g).MES_ENCLOSURE_W__MM, placeholder: "展开宽度", "controls-position": "right", style: { width: "100%" }, onChange: (n) => v(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (c(), A("div", he, b(t.row.unfoldedWidth ? t.row.unfoldedWidth.toFixed(l(g).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 })) : E("", true), l(o).query.category === l(i).BENDING.V ? (c(), f(a, { key: "bendTimes", prop: "bendTimes", "show-overflow-tooltip": true, label: "折弯次数", "min-width": "100px" }, { default: u((t) => [d(w, { modelValue: t.row.bendTimes, "onUpdate:modelValue": (n) => t.row.bendTimes = n, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: 0, placeholder: "折弯次数", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : E("", true), l(o).query.category !== l(i).TRUSS_FLOOR_PLATE.V ? (c(), f(a, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: `板厚
(mm)`, align: "left", "min-width": "100px" }, { default: u((t) => [d(w, { modelValue: t.row.thickness, "onUpdate:modelValue": (n) => t.row.thickness = n, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: l(g).MES_ENCLOSURE_T__MM, placeholder: "板厚", "controls-position": "right", style: { width: "100%" }, onChange: (n) => C(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 })) : E("", true), d(a, { key: "length", prop: "length", "show-overflow-tooltip": true, label: `单长
(㎜)`, align: "left", "min-width": "100px" }, { default: u((t) => [d(w, { modelValue: t.row.length, "onUpdate:modelValue": (n) => t.row.length = n, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: l(g).MES_ENCLOSURE_L__MM, placeholder: "单长", "controls-position": "right", style: { width: "100%" }, onChange: (n) => v(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), d(a, { key: "quantity", prop: "quantity", label: "数量(张)", align: "left", "min-width": "100px" }, { default: u((t) => [d(w, { modelValue: t.row.quantity, "onUpdate:modelValue": (n) => t.row.quantity = n, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: l(g).MES_ENCLOSURE_L__MM, placeholder: "数量", "controls-position": "right", style: { width: "100%" }, onChange: (n) => v(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), d(a, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": true, label: "总面积(㎡)", align: "left", "min-width": "100px" }, { default: u((t) => [V(b(t.row.totalArea ? t.row.totalArea.toFixed(l(g).COM_ENCLOSURE_AREA__M2) : "-"), 1)]), _: 1 }), d(a, { key: "totalLength", prop: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px" }, { default: u((t) => [V(b(t.row.totalLength ? t.row.totalLength.toFixed(l(g).MES_ENCLOSURE_L__M) : "-"), 1)]), _: 1 }), l(o).query.category !== l(i).SANDWICH_BOARD.V ? (c(), f(a, { key: "totalWeight", prop: "totalWeight", label: "总重量(kg)", align: "left", "min-width": "100px" }, { default: u((t) => [V(b(t.row.totalWeight ? t.row.totalWeight.toFixed(l(g).COM_WT__KG) : "-"), 1)]), _: 1 })) : E("", true), d(a, { key: "brand", prop: "brand", "show-overflow-tooltip": true, label: "品牌", width: "100px" }, { default: u((t) => [d(h, { modelValue: t.row.brand, "onUpdate:modelValue": (n) => t.row.brand = n, placeholder: "品牌", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), d(a, { key: "color", prop: "color", "show-overflow-tooltip": true, label: "颜色", width: "100px" }, { default: u((t) => [d(h, { modelValue: t.row.color, "onUpdate:modelValue": (n) => t.row.color = n, placeholder: "颜色", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), d(a, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "100px" }, { default: u((t) => [d(h, { modelValue: t.row.remark, "onUpdate:modelValue": (n) => t.row.remark = n, placeholder: "备注", type: "textarea", maxlength: "200", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), d(a, { label: "操作", align: "center", fixed: "right" }, { default: u((t) => [d(s, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (n) => Q(t.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), le("div", ce, [d(s, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: r[0] || (r[0] = (t) => X()) }, { default: u(() => r[2] || (r[2] = [V("继续添加")])), _: 1, __: [2] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, be = ne(pe, [["__scopeId", "data-v-af240a13"]]);
export {
  be as default
};
