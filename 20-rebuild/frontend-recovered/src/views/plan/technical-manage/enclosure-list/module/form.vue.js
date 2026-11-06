import { ref as L } from "vue";
import { inject as A } from "vue";
import { computed as ee } from "vue";
import { watch as I } from "vue";
import { ElMessage as O } from "element-plus";
import { resolveComponent as q } from "vue";
import { openBlock as c } from "vue";
import { createBlock as h } from "vue";
import { withCtx as d } from "vue";
import { createVNode as s } from "vue";
import { unref as t } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as f } from "vue";
import { createElementBlock as M } from "vue";
import { toDisplayString as R } from "vue";
import { createElementVNode as te } from "vue";
import { ElTableColumn as le } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElInputNumber as oe } from "element-plus";
import { ElForm as re } from "element-plus";
import { _ as ne, ao as ie, o as ue, T as r, jx as de, fK as x, D as g } from "../../../../../shared/runtime.js";
const se = { key: 1 }, me = { key: 1 }, ce = { class: "add-row-box" }, pe = { __name: "form", setup(he) {
  const S = L(), P = L(), _ = L({}), D = { list: [] }, W = { key: "id", label: "plateType", value: "id" }, B = { key: "id", label: "serialNumber", value: "id" }, F = { key: "name", label: "name", value: "name" }, N = A("plateOption"), V = A("technicalTypeStatus"), { CRUD: G, crud: a, form: m } = ie(D, S), { maxHeight: $ } = ue({ wrapperBox: ".enclosureForm", paginate: true, extraHeight: 40 }), H = (e, n) => a.query.category === r.BENDING.V ? !!e : true, z = (e, n) => a.query.category !== r.BENDING.V ? !!e : true, K = { serialNumber: [{ required: true, message: "请输入编号", trigger: "blur" }], unfoldedWidth: [{ validator: H, message: "展开宽度必填", trigger: "change" }], width: [{ validator: (e, n) => a.query.category !== r.BENDING.V ? !!e : true, message: "有效宽度必填", trigger: "change" }], thickness: [{ validator: (e, n) => a.query.category !== r.TRUSS_FLOOR_PLATE.V ? !!e : true, message: "厚度必填", trigger: "change" }], length: [{ required: true, message: "单长必填", trigger: "change" }], quantity: [{ required: true, message: "数量必填", trigger: "change" }], totalArea: [{ required: true, message: "总面积必填", trigger: "change" }], totalLength: [{ required: true, message: "总长度必填", trigger: "change" }], bendTimes: [{ validator: (e, n) => a.query.category === r.BENDING.V ? !!e : true, message: "折弯次数必填", trigger: "change" }], color: [{ validator: (e, n) => a.query.category === r.BENDING.V || a.query.category === r.PROFILED_PLATE.V ? !!e : true, message: "请输入颜色", trigger: "blur" }] }, T = ee(() => {
    let e = {};
    return V.value ? e = { plateId: [{ validator: z, message: "请选择板型", trigger: "change" }] } : e = { plate: [{ required: true, message: "请选择板型", trigger: "change" }] }, { ...K, ...e };
  });
  I(() => a.query.category, () => {
    U();
  }, { immediate: true }), I(() => V.value, () => {
    U();
  }, { immediate: true });
  async function U() {
    if (_.value = {}, !(V.value || !a.query.category || a.query.category === r.BENDING.V)) try {
      const { content: e = [] } = await de(a.query.category) || {}, n = {};
      a.query.category === r.TRUSS_FLOOR_PLATE.V ? _.value.plate_type = e.map((u) => {
        let o = "";
        return u == null || u.list.forEach((p) => {
          p.name === "effectiveWidth" && (o = p.value);
        }), n[u.code] = { effectiveWidth: o }, { name: u.code };
      }) : e.forEach((u) => {
        u.name === "plate_type" && ((u.plateTypeList || []).forEach((o) => {
          n[o.plateType] = o;
        }), _.value[u.name] = (u.labels || []).map((o) => ({ name: o })));
      }), _.value.KV = n;
    } catch (e) {
      console.log("获取围护配置信息列表", e);
    }
  }
  function j({ row: e, column: n }) {
    if (!e) return;
    const u = T.value;
    let o = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[n.property] === false && (o = x(n.property, u[n.property], e)), o && (e.verify[n.property] = true)), o ? "" : "mask-td";
  }
  function J(e) {
    m.list.splice(e, 1);
  }
  function Q() {
    m.list.push({ areaId: a.query.areaId });
  }
  function k(e, n) {
    var u;
    if (e.plateId) {
      const o = N.value.find((p) => p.id === e.plateId);
      a.query.category === r.TRUSS_FLOOR_PLATE.V ? (m.list[n].plate = o.serialNumber, m.list[n].weightMeter = o.weightMeter) : (m.list[n].plate = o.plateType, m.list[n].brand = o.brand, m.list[n].thickness = o.thickness, m.list[n].color = o.colour, m.list[n].unfoldedWidth = o.unfoldedWidth), m.list[n].width = o.effectiveWidth, w(e);
    } else {
      const o = ((u = _.value.KV) == null ? void 0 : u[e.plate]) || {};
      a.query.category === r.TRUSS_FLOOR_PLATE.V ? m.list[n].width = +o.effectiveWidth : (a.query.category === r.PROFILED_PLATE.V || a.query.category === r.PRESSURE_BEARING_PLATE.V) && (m.list[n].width = +o.effectiveWidth, m.list[n].unfoldedWidth = +o.unfoldedWidth);
    }
  }
  function w(e) {
    e.length && e.quantity && (e.totalLength = e.length * e.quantity / 1e3, C(e)), a.query.category === r.BENDING.V ? e.length && e.quantity && e.unfoldedWidth && (e.totalArea = e.unfoldedWidth * e.length * e.quantity / 1e6) : e.length && e.quantity && e.width && (e.totalArea = e.width * e.length * e.quantity / 1e6);
  }
  function C(e) {
    a.query.category === r.BENDING.V || a.query.category === r.PROFILED_PLATE.V || a.query.category === r.PRESSURE_BEARING_PLATE.V ? e.unfoldedWidth && e.thickness && e.totalLength && (e.weight = e.unfoldedWidth / 1e3 * e.thickness * e.totalLength * 7.85) : a.query.category === r.TRUSS_FLOOR_PLATE.V && e.weightMeter && e.totalLength && (e.weight = e.weightMeter * e.totalLength);
  }
  return G.HOOK.beforeValidateCU = (e, n) => {
    if (e.form.list.length <= 0) return O({ message: "请先添加围护信息", type: "error" }), false;
    const u = T.value;
    let o = true;
    if (e.form.list.map((p) => {
      p.verify = {};
      for (const y in u) p.verify[y] = x(y, u[y], p), p.verify[y] || (o = false);
    }), !o) return O.error("请填写表格中标红数据"), false;
    e.form.areaId = e.query.areaId;
  }, (e, n) => {
    const u = q("common-button"), o = le, p = ae, y = q("common-select"), E = oe, X = q("common-table"), Y = re, Z = q("common-drawer");
    return c(), h(Z, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(a).cancelCU, visible: t(a).status.cu > 0, title: t(a).query.category ? t(a).status.title + "(" + t(r).VL[t(a).query.category] + ")" : t(a).status.title, "wrapper-closable": false, size: "90%" }, { titleRight: d(() => [s(u, { loading: t(a).status.cu === 2, type: "primary", size: "default", onClick: t(a).submitCU }, { default: d(() => n[1] || (n[1] = [v("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: d(() => [s(Y, { ref_key: "formRef", ref: S, model: t(m), size: "default", "label-width": "140px" }, { default: d(() => [s(X, { ref_key: "detailRef", ref: P, border: "", data: t(m).list, "max-height": t($), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" }, class: "table-form", "cell-class-name": j }, { default: d(() => [s(o, { label: "序号", type: "index", align: "center", width: "55" }), s(o, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "100" }, { default: d((l) => [s(p, { modelValue: l.row.name, "onUpdate:modelValue": (i) => l.row.name = i, placeholder: "名称", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "90px" }, { default: d((l) => [s(p, { modelValue: l.row.serialNumber, "onUpdate:modelValue": (i) => l.row.serialNumber = i, placeholder: "编号", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(a).query.category !== t(r).BENDING.V ? (c(), h(o, { key: t(V) ? "plateId" : "plate", prop: t(V) ? "plateId" : "plate", "show-overflow-tooltip": true, label: "板型", "min-width": "100px" }, { default: d((l) => {
      var i;
      return [t(V) ? (c(), h(y, { key: 0, modelValue: l.row.plateId, "onUpdate:modelValue": (b) => l.row.plateId = b, options: t(N), type: "other", dataStructure: t(a).query.category === t(r).TRUSS_FLOOR_PLATE.V ? B : W, size: "default", placeholder: "板型", onChange: (b) => k(l.row, l.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "dataStructure", "onChange"])) : (c(), h(y, { key: 1, modelValue: l.row.plate, "onUpdate:modelValue": (b) => l.row.plate = b, options: (i = _.value) == null ? void 0 : i.plate_type, dataStructure: F, size: "default", placeholder: "板型", onChange: (b) => k(l.row, l.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))];
    }), _: 1 }, 8, ["prop"])) : f("", true), t(a).query.category !== t(r).BENDING.V ? (c(), h(o, { key: "width", prop: "width", "show-overflow-tooltip": true, label: t(a).query.category === t(r).SANDWICH_BOARD.V ? `宽度
(mm)` : `有效宽度
(mm)`, "min-width": "100px" }, { default: d((l) => [t(a).query.category !== t(r).PROFILED_PLATE.V && t(a).query.category !== t(r).PRESSURE_BEARING_PLATE.V ? (c(), h(E, { key: 0, modelValue: l.row.width, "onUpdate:modelValue": (i) => l.row.width = i, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: t(g).MES_ENCLOSURE_W__MM, placeholder: "有效宽度", "controls-position": "right", style: { width: "100%" }, onChange: (i) => w(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (c(), M("div", se, R(l.row.width ? l.row.width.toFixed(t(g).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 }, 8, ["label"])) : f("", true), t(a).query.category === t(r).BENDING.V || t(a).query.category === t(r).PROFILED_PLATE.V || t(a).query.category === t(r).PRESSURE_BEARING_PLATE.V ? (c(), h(o, { key: "unfoldedWidth", prop: "unfoldedWidth", "show-overflow-tooltip": true, label: `展开宽度
(mm)`, "min-width": "100px" }, { default: d((l) => [t(a).query.category === t(r).BENDING.V ? (c(), h(E, { key: 0, modelValue: l.row.unfoldedWidth, "onUpdate:modelValue": (i) => l.row.unfoldedWidth = i, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: t(g).MES_ENCLOSURE_W__MM, placeholder: "展开宽度", "controls-position": "right", style: { width: "100%" }, onChange: (i) => w(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (c(), M("div", me, R(l.row.unfoldedWidth ? l.row.unfoldedWidth.toFixed(t(g).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 })) : f("", true), t(a).query.category === t(r).BENDING.V ? (c(), h(o, { key: "bendTimes", prop: "bendTimes", "show-overflow-tooltip": true, label: "折弯次数", "min-width": "100px" }, { default: d((l) => [s(E, { modelValue: l.row.bendTimes, "onUpdate:modelValue": (i) => l.row.bendTimes = i, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: 0, placeholder: "折弯次数", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : f("", true), t(a).query.category !== t(r).TRUSS_FLOOR_PLATE.V ? (c(), h(o, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: `板厚
(mm)`, align: "left", "min-width": "100px" }, { default: d((l) => [s(E, { modelValue: l.row.thickness, "onUpdate:modelValue": (i) => l.row.thickness = i, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: t(g).MES_ENCLOSURE_T__MM, placeholder: "板厚", "controls-position": "right", style: { width: "100%" }, onChange: (i) => C(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 })) : f("", true), s(o, { key: "length", prop: "length", "show-overflow-tooltip": true, label: `单长
(㎜)`, align: "left", "min-width": "100px" }, { default: d((l) => [s(E, { modelValue: l.row.length, "onUpdate:modelValue": (i) => l.row.length = i, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: t(g).MES_ENCLOSURE_L__MM, placeholder: "单长", "controls-position": "right", style: { width: "100%" }, onChange: (i) => w(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), s(o, { key: "quantity", prop: "quantity", label: "数量(张)", align: "left", "min-width": "100px" }, { default: d((l) => [s(E, { modelValue: l.row.quantity, "onUpdate:modelValue": (i) => l.row.quantity = i, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: t(g).MES_ENCLOSURE_L__MM, placeholder: "数量", "controls-position": "right", style: { width: "100%" }, onChange: (i) => w(l.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), s(o, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": true, label: "总面积(㎡)", align: "left", "min-width": "100px" }, { default: d((l) => [v(R(l.row.totalArea ? l.row.totalArea.toFixed(t(g).COM_AREA__M2) : "-"), 1)]), _: 1 }), s(o, { key: "totalLength", prop: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px" }, { default: d((l) => [v(R(l.row.totalLength ? l.row.totalLength.toFixed(t(g).MES_ENCLOSURE_L__M) : "-"), 1)]), _: 1 }), t(a).query.category !== t(r).SANDWICH_BOARD.V ? (c(), h(o, { key: "weight", prop: "weight", label: "总重量(kg)", align: "left", "min-width": "100px" }, { default: d((l) => [v(R(l.row.weight ? l.row.weight.toFixed(t(g).COM_WT__KG) : "-"), 1)]), _: 1 })) : f("", true), t(a).query.category !== t(r).SANDWICH_BOARD.V && t(a).query.category !== t(r).TRUSS_FLOOR_PLATE.V ? (c(), h(o, { key: "brand", prop: "brand", "show-overflow-tooltip": true, label: "品牌", width: "100px" }, { default: d((l) => [s(p, { modelValue: l.row.brand, "onUpdate:modelValue": (i) => l.row.brand = i, placeholder: "品牌", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : f("", true), t(a).query.category != t(r).TRUSS_FLOOR_PLATE.V && t(a).query.category != t(r).PRESSURE_BEARING_PLATE.V && t(a).query.category != t(r).PRESSURE_BEARING_PLATE.V && t(a).query.category != t(r).SANDWICH_BOARD.V ? (c(), h(o, { key: "color", prop: "color", "show-overflow-tooltip": true, label: "颜色", width: "100px" }, { default: d((l) => [s(p, { modelValue: l.row.color, "onUpdate:modelValue": (i) => l.row.color = i, placeholder: "颜色", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : f("", true), s(o, { label: "操作", align: "center" }, { default: d((l) => [s(u, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (i) => J(l.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), te("div", ce, [s(u, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: n[0] || (n[0] = (l) => Q()) }, { default: d(() => n[2] || (n[2] = [v("继续添加")])), _: 1, __: [2] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, we = ne(pe, [["__scopeId", "data-v-1a0f2050"]]);
export {
  we as default
};
