import { ref as k } from "vue";
import { inject as I } from "vue";
import { computed as te } from "vue";
import { watch as O } from "vue";
import { ElMessage as A } from "element-plus";
import { resolveComponent as q } from "vue";
import { openBlock as c } from "vue";
import { createBlock as h } from "vue";
import { withCtx as u } from "vue";
import { createVNode as d } from "vue";
import { unref as l } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as y } from "vue";
import { createElementBlock as M } from "vue";
import { toDisplayString as R } from "vue";
import { createElementVNode as le } from "vue";
import { ElTableColumn as ae } from "element-plus";
import { ElInput as oe } from "element-plus";
import { ElInputNumber as re } from "element-plus";
import { ElForm as ne } from "element-plus";
import { _ as ie, ao as de, o as ue, T as r, jx as se, fK as W, D as f } from "../../../../../shared/runtime.js";
const me = { key: 1 }, pe = { key: 1 }, ce = { class: "add-row-box" }, he = { __name: "form", setup(fe) {
  const L = k(), P = k(), _ = k({}), D = { list: [] }, B = { key: "id", label: "plateType", value: "id" }, F = { key: "id", label: "serialNumber", value: "id" }, G = { key: "name", label: "name", value: "name" }, U = I("plateOption"), V = I("technicalTypeStatus"), N = k(), { CRUD: $, crud: o, form: p } = de(D, L), { maxHeight: H } = ue({ mainBox: ".detail", extraBox: [".el-drawer__header"], wrapperBox: ".table-form", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, N), z = (e, n) => o.query.category === r.BENDING.V ? !!e : true, K = (e, n) => o.query.category !== r.BENDING.V ? !!e : true, j = { name: [{ required: true, message: "请输入名称", trigger: "blur" }], serialNumber: [{ required: true, message: "请输入编号", trigger: "blur" }], unfoldedWidth: [{ validator: z, message: "展开宽度必填", trigger: "change" }], width: [{ validator: (e, n) => o.query.category !== r.BENDING.V ? !!e : true, message: "有效宽度必填", trigger: "change" }], thickness: [{ validator: (e, n) => o.query.category !== r.TRUSS_FLOOR_PLATE.V ? !!e : true, message: "厚度必填", trigger: "change" }], length: [{ required: true, message: "单长必填", trigger: "change" }], quantity: [{ required: true, message: "数量必填", trigger: "change" }], totalArea: [{ required: true, message: "总面积必填", trigger: "change" }], totalLength: [{ required: true, message: "总长度必填", trigger: "change" }], bendTimes: [{ validator: (e, n) => o.query.category === r.BENDING.V ? !!e : true, message: "折弯次数必填", trigger: "change" }], color: [{ validator: (e, n) => o.query.category === r.BENDING.V || o.query.category === r.PROFILED_PLATE.V ? !!e : true, message: "请输入颜色", trigger: "blur" }] }, S = te(() => {
    let e = {};
    return V.value ? e = { plateId: [{ validator: K, message: "请选择板型", trigger: "change" }] } : e = { plate: [{ required: true, message: "请选择板型", trigger: "change" }] }, { ...j, ...e };
  });
  O(() => o.query.category, () => {
    T();
  }, { immediate: true }), O(() => V.value, () => {
    T();
  }, { immediate: true });
  async function T() {
    if (_.value = {}, !(V.value || !o.query.category || o.query.category === r.BENDING.V)) try {
      const { content: e = [] } = await se(o.query.category) || {}, n = {};
      o.query.category === r.TRUSS_FLOOR_PLATE.V ? _.value.plate_type = e.map((s) => {
        let a = "";
        return s == null || s.list.forEach((m) => {
          m.name === "effectiveWidth" && (a = m.value);
        }), n[s.code] = { effectiveWidth: a }, { name: s.code };
      }) : e.forEach((s) => {
        s.name === "plate_type" && ((s.plateTypeList || []).forEach((a) => {
          n[a.plateType] = a;
        }), _.value[s.name] = (s.labels || []).map((a) => ({ name: a })));
      }), _.value.KV = n;
    } catch (e) {
      console.log("获取围护配置信息列表", e);
    }
  }
  function J({ row: e, column: n }) {
    if (!e) return;
    const s = S.value;
    let a = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[n.property] === false && (a = W(n.property, s[n.property], e)), a && (e.verify[n.property] = true)), a ? "" : "mask-td";
  }
  function Q(e) {
    p.list.splice(e, 1);
  }
  function X() {
    p.list.push({ areaId: o.query.areaId });
  }
  function x(e, n) {
    var s;
    if (e.plateId) {
      const a = U.value.find((m) => m.id === e.plateId);
      o.query.category === r.TRUSS_FLOOR_PLATE.V ? (p.list[n].plate = a.serialNumber, p.list[n].weightMeter = a.weightMeter) : (p.list[n].plate = a.plateType, p.list[n].brand = a.brand, p.list[n].thickness = a.thickness, p.list[n].color = a.colour, p.list[n].unfoldedWidth = a.unfoldedWidth), p.list[n].width = a.effectiveWidth;
    } else {
      const a = ((s = _.value.KV) == null ? void 0 : s[e.plate]) || {};
      o.query.category === r.TRUSS_FLOOR_PLATE.V ? p.list[n].width = +a.effectiveWidth : (o.query.category === r.PROFILED_PLATE.V || o.query.category === r.PRESSURE_BEARING_PLATE.V) && (p.list[n].width = +a.effectiveWidth, p.list[n].unfoldedWidth = +a.unfoldedWidth);
    }
    E(e);
  }
  function E(e) {
    e.length && e.quantity && (e.totalLength = e.length * e.quantity / 1e3, C(e)), o.query.category === r.BENDING.V || o.query.category === r.PROFILED_PLATE.V || o.query.category === r.PRESSURE_BEARING_PLATE.V ? e.length && e.quantity && e.unfoldedWidth && (e.totalArea = e.unfoldedWidth * e.length * e.quantity / 1e6) : e.length && e.quantity && e.width && (e.totalArea = e.width * e.length * e.quantity / 1e6);
  }
  function C(e) {
    o.query.category === r.BENDING.V || o.query.category === r.PROFILED_PLATE.V || o.query.category === r.PRESSURE_BEARING_PLATE.V ? e.unfoldedWidth && e.thickness && e.totalLength && (e.totalWeight = e.unfoldedWidth / 1e3 * e.thickness * e.totalLength * 7.85) : o.query.category === r.TRUSS_FLOOR_PLATE.V && e.weightMeter && e.totalLength && (e.totalWeight = e.weightMeter * e.totalLength);
  }
  return $.HOOK.beforeValidateCU = (e, n) => {
    if (e.form.list.length <= 0) return A({ message: "请先添加围护信息", type: "error" }), false;
    const s = S.value;
    let a = true;
    if (e.form.list.map((m) => {
      m.verify = {};
      for (const g in s) m.verify[g] = W(g, s[g], m), m.verify[g] || (a = false);
    }), !a) return A.error("请填写表格中标红数据"), false;
    e.form.planId = e.query.enclosurePlanId;
  }, (e, n) => {
    const s = q("common-button"), a = ae, m = oe, g = q("common-select"), w = re, Y = q("common-table"), Z = ne, ee = q("common-drawer");
    return c(), h(ee, { ref_key: "drawerRef", ref: N, "append-to-body": "", "close-on-click-modal": false, "before-close": l(o).cancelCU, visible: l(o).status.cu > 0, title: l(o).status.title, "wrapper-closable": false, "custom-class": "detail", size: "100%" }, { titleRight: u(() => [d(s, { loading: l(o).status.cu === 2, type: "primary", size: "default", onClick: l(o).submitCU }, { default: u(() => n[1] || (n[1] = [v("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: u(() => [d(Z, { ref_key: "formRef", ref: L, model: l(p), size: "default", "label-width": "140px" }, { default: u(() => [d(Y, { ref_key: "detailRef", ref: P, border: "", data: l(p).list, "max-height": l(H) - 150, "return-source-data": "", showEmptySymbol: false, style: { width: "100%" }, class: "table-form", "cell-class-name": J }, { default: u(() => [d(a, { label: "序号", type: "index", align: "center", width: "55", fixed: "left" }), d(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "100" }, { default: u((t) => [d(m, { modelValue: t.row.name, "onUpdate:modelValue": (i) => t.row.name = i, placeholder: "名称", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), d(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "90px" }, { default: u((t) => [d(m, { modelValue: t.row.serialNumber, "onUpdate:modelValue": (i) => t.row.serialNumber = i, placeholder: "编号", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(o).query.category !== l(r).BENDING.V ? (c(), h(a, { key: l(V) ? "plateId" : "plate", prop: l(V) ? "plateId" : "plate", "show-overflow-tooltip": true, label: "板型", "min-width": "100px" }, { default: u((t) => {
      var i;
      return [l(V) ? (c(), h(g, { key: 0, modelValue: t.row.plateId, "onUpdate:modelValue": (b) => t.row.plateId = b, options: l(U), type: "other", dataStructure: l(o).query.category === l(r).TRUSS_FLOOR_PLATE.V ? F : B, size: "default", placeholder: "板型", onChange: (b) => x(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "dataStructure", "onChange"])) : (c(), h(g, { key: 1, modelValue: t.row.plate, "onUpdate:modelValue": (b) => t.row.plate = b, options: (i = _.value) == null ? void 0 : i.plate_type, dataStructure: G, size: "default", placeholder: "板型", onChange: (b) => x(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))];
    }), _: 1 }, 8, ["prop"])) : y("", true), l(o).query.category !== l(r).BENDING.V ? (c(), h(a, { key: "width", prop: "width", "show-overflow-tooltip": true, label: l(o).query.category === l(r).SANDWICH_BOARD.V ? `宽度
(mm)` : `有效宽度
(mm)`, "min-width": "100px" }, { default: u((t) => [l(o).query.category !== l(r).PROFILED_PLATE.V && l(o).query.category !== l(r).PRESSURE_BEARING_PLATE.V ? (c(), h(w, { key: 0, modelValue: t.row.width, "onUpdate:modelValue": (i) => t.row.width = i, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: l(f).MES_ENCLOSURE_W__MM, placeholder: "有效宽度", "controls-position": "right", style: { width: "100%" }, onChange: (i) => E(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (c(), M("div", me, R(t.row.width ? t.row.width.toFixed(l(f).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 }, 8, ["label"])) : y("", true), l(o).query.category === l(r).BENDING.V || l(o).query.category === l(r).PROFILED_PLATE.V || l(o).query.category === l(r).PRESSURE_BEARING_PLATE.V ? (c(), h(a, { key: "unfoldedWidth", prop: "unfoldedWidth", "show-overflow-tooltip": true, label: `展开宽度
(mm)`, "min-width": "100px" }, { default: u((t) => [l(o).query.category === l(r).BENDING.V ? (c(), h(w, { key: 0, modelValue: t.row.unfoldedWidth, "onUpdate:modelValue": (i) => t.row.unfoldedWidth = i, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: l(f).MES_ENCLOSURE_W__MM, placeholder: "展开宽度", "controls-position": "right", style: { width: "100%" }, onChange: (i) => E(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (c(), M("div", pe, R(t.row.unfoldedWidth ? t.row.unfoldedWidth.toFixed(l(f).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 })) : y("", true), l(o).query.category === l(r).BENDING.V ? (c(), h(a, { key: "bendTimes", prop: "bendTimes", "show-overflow-tooltip": true, label: "折弯次数", "min-width": "100px" }, { default: u((t) => [d(w, { modelValue: t.row.bendTimes, "onUpdate:modelValue": (i) => t.row.bendTimes = i, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: 0, placeholder: "折弯次数", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : y("", true), l(o).query.category !== l(r).TRUSS_FLOOR_PLATE.V ? (c(), h(a, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: `板厚
(mm)`, align: "left", "min-width": "100px" }, { default: u((t) => [d(w, { modelValue: t.row.thickness, "onUpdate:modelValue": (i) => t.row.thickness = i, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: l(f).MES_ENCLOSURE_T__MM, placeholder: "板厚", "controls-position": "right", style: { width: "100%" }, onChange: (i) => C(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 })) : y("", true), d(a, { key: "length", prop: "length", "show-overflow-tooltip": true, label: `单长
(㎜)`, align: "left", "min-width": "100px" }, { default: u((t) => [d(w, { modelValue: t.row.length, "onUpdate:modelValue": (i) => t.row.length = i, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: l(f).MES_ENCLOSURE_L__MM, placeholder: "单长", "controls-position": "right", style: { width: "100%" }, onChange: (i) => E(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), d(a, { key: "quantity", prop: "quantity", label: "数量(张)", align: "left", "min-width": "100px" }, { default: u((t) => [d(w, { modelValue: t.row.quantity, "onUpdate:modelValue": (i) => t.row.quantity = i, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: l(f).MES_ENCLOSURE_L__MM, placeholder: "数量", "controls-position": "right", style: { width: "100%" }, onChange: (i) => E(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), d(a, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": true, label: "总面积(㎡)", align: "left", "min-width": "100px" }, { default: u((t) => [v(R(t.row.totalArea ? t.row.totalArea.toFixed(l(f).COM_ENCLOSURE_AREA__M2) : "-"), 1)]), _: 1 }), d(a, { key: "totalLength", prop: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px" }, { default: u((t) => [v(R(t.row.totalLength ? t.row.totalLength.toFixed(l(f).MES_ENCLOSURE_L__M) : "-"), 1)]), _: 1 }), l(o).query.category !== l(r).SANDWICH_BOARD.V ? (c(), h(a, { key: "totalWeight", prop: "totalWeight", label: "总重量(kg)", align: "left", "min-width": "100px" }, { default: u((t) => [v(R(t.row.totalWeight ? t.row.totalWeight.toFixed(l(f).COM_WT__KG) : "-"), 1)]), _: 1 })) : y("", true), d(a, { key: "coating", prop: "coating", "show-overflow-tooltip": true, label: "涂层", "min-width": "100px" }, { default: u((t) => [d(m, { modelValue: t.row.coating, "onUpdate:modelValue": (i) => t.row.coating = i, placeholder: "涂层", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), d(a, { key: "plating", prop: "plating", "show-overflow-tooltip": true, label: "镀层", "min-width": "100px" }, { default: u((t) => [d(m, { modelValue: t.row.plating, "onUpdate:modelValue": (i) => t.row.plating = i, placeholder: "镀层", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(o).query.category !== l(r).SANDWICH_BOARD.V && l(o).query.category !== l(r).TRUSS_FLOOR_PLATE.V ? (c(), h(a, { key: "brand", prop: "brand", "show-overflow-tooltip": true, label: "品牌", width: "100px" }, { default: u((t) => [d(m, { modelValue: t.row.brand, "onUpdate:modelValue": (i) => t.row.brand = i, placeholder: "品牌", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : y("", true), d(a, { key: "color", prop: "color", "show-overflow-tooltip": true, label: "颜色", width: "100px" }, { default: u((t) => [d(m, { modelValue: t.row.color, "onUpdate:modelValue": (i) => t.row.color = i, placeholder: "颜色", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), d(a, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "100px" }, { default: u((t) => [d(m, { modelValue: t.row.remark, "onUpdate:modelValue": (i) => t.row.remark = i, placeholder: "备注", type: "textarea", maxlength: "200", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), d(a, { label: "操作", align: "center", fixed: "right" }, { default: u((t) => [d(s, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (i) => Q(t.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), le("div", ce, [d(s, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: n[0] || (n[0] = (t) => X()) }, { default: u(() => n[2] || (n[2] = [v("继续添加")])), _: 1, __: [2] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, be = ie(he, [["__scopeId", "data-v-eefb447d"]]);
export {
  be as default
};
