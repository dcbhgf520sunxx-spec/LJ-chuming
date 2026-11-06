import { ref as M } from "vue";
import { watch as k } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as r } from "vue";
import { createBlock as f } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as t } from "vue";
import { toDisplayString as l } from "vue";
import { unref as c } from "vue";
import { createElementBlock as p } from "vue";
import { createCommentVNode as N } from "vue";
import { ElTableColumn as x } from "element-plus";
import { _ as T, D as s } from "../../../../../shared/runtime.js";
const W = { class: "sandwich-cell-top" }, B = { class: "sandwich-cell-bottom" }, D = { class: "sandwich-cell-top" }, R = { class: "sandwich-cell-bottom" }, P = { class: "sandwich-cell-top" }, F = { class: "sandwich-cell-bottom" }, L = { class: "sandwich-cell-top" }, O = { class: "sandwich-cell-bottom" }, U = { class: "sandwich-cell-top" }, $ = { class: "sandwich-cell-bottom" }, V = { class: "sandwich-cell-top" }, q = { class: "sandwich-cell-bottom" }, z = { class: "sandwich-cell-top" }, A = { class: "sandwich-cell-bottom" }, I = { class: "sandwich-cell-top" }, j = { class: "sandwich-cell-bottom" }, G = { __name: "sandwich-table", props: { tableData: { type: Array, default: () => [] }, isShow: { type: Boolean, default: true } }, emits: ["edit"], setup(_, { emit: b }) {
  const h = _, v = b;
  function g({ row: i, column: w, rowIndex: o, columnIndex: d }) {
    if (d >= 5 && d <= 12) return { padding: "0px" };
  }
  const u = M([]);
  k(() => h.tableData, (i) => {
    u.value = h.tableData;
  }, { deep: true, immediate: true });
  function E(i) {
    u.value.splice(i, 1);
  }
  function S(i, w) {
    v("edit", w), u.value.splice(i, 1);
  }
  return (i, w) => {
    const o = x, d = m("common-button"), y = m("common-table");
    return r(), f(y, { data: _.tableData, "return-source-data": "", showEmptySymbol: false, "cell-style": g }, { default: n(() => [a(o, { label: "序号", type: "index", align: "center", width: "55" }), a(o, { prop: "plateType", "show-overflow-tooltip": true, align: "center", label: "板型" }, { default: n((e) => [t("span", null, l(e.row.plateType), 1)]), _: 1 }), a(o, { prop: "thickness", "show-overflow-tooltip": true, align: "center", label: `厚度
(mm)` }, { default: n((e) => [t("span", null, l(e.row.thickness ? Number(e.row.thickness).toFixed(c(s).MES_ENCLOSURE_T__MM) : ""), 1)]), _: 1 }), a(o, { prop: "effectiveWidth", "show-overflow-tooltip": true, align: "center", label: `有效宽度
(mm)` }, { default: n((e) => [t("span", null, l(e.row.effectiveWidth ? Number(e.row.effectiveWidth).toFixed(c(s).MES_ENCLOSURE_W__MM) : ""), 1)]), _: 1 }), a(o, { align: "center", label: "钢板信息" }, { default: n(() => [a(o, { align: "center", label: "内外板" }, { default: n((e) => [(r(), p("div", { class: "sandwich-cell-top", key: e.$index }, "外板")), (r(), p("div", { class: "sandwich-cell-bottom", key: e.$index }, "内板"))]), _: 1 }), a(o, { align: "center", label: "板形状" }, { default: n((e) => [t("div", W, l(e.row.outPlateShape), 1), t("div", B, l(e.row.intPlateShape), 1)]), _: 1 }), a(o, { align: "center", label: "材质" }, { default: n((e) => [t("div", D, l(e.row.outMaterial), 1), t("div", R, l(e.row.intMaterial), 1)]), _: 1 }), a(o, { align: "center", label: "品牌" }, { default: n((e) => [t("div", P, l(e.row.outSteelPlateBrand), 1), t("div", F, l(e.row.intSteelPlateBrand), 1)]), _: 1 }), a(o, { align: "center", label: "厚度(mm)" }, { default: n((e) => [t("div", L, l(e.row.outThickness ? Number(e.row.outThickness).toFixed(c(s).MES_ENCLOSURE_T__MM) : ""), 1), t("div", O, l(e.row.intThickness ? Number(e.row.intThickness).toFixed(c(s).MES_ENCLOSURE_T__MM) : ""), 1)]), _: 1 }), a(o, { align: "center", label: "宽度" }, { default: n((e) => [t("div", U, l(e.row.outEffectiveWidth ? Number(e.row.outEffectiveWidth).toFixed(c(s).MES_ENCLOSURE_W__MM) : ""), 1), t("div", $, l(e.row.intEffectiveWidth ? Number(e.row.intEffectiveWidth).toFixed(c(s).MES_ENCLOSURE_W__MM) : ""), 1)]), _: 1 }), a(o, { align: "center", label: "镀层" }, { default: n((e) => [t("div", V, l(e.row.outPlating), 1), t("div", q, l(e.row.intPlating), 1)]), _: 1 }), a(o, { align: "center", label: "涂层" }, { default: n((e) => [t("div", z, l(e.row.outCoating), 1), t("div", A, l(e.row.intCoating), 1)]), _: 1 }), a(o, { align: "center", label: "颜色" }, { default: n((e) => [t("div", I, l(e.row.outColour), 1), t("div", j, l(e.row.intColour), 1)]), _: 1 })]), _: 1 }), a(o, { align: "center", label: "芯材信息" }, { default: n(() => [a(o, { prop: "coreBrand", "show-overflow-tooltip": true, align: "center", label: "品牌" }, { default: n((e) => [t("span", null, l(e.row.coreBrand), 1)]), _: 1 }), a(o, { prop: "typeName", "show-overflow-tooltip": true, align: "center", label: "种类" }, { default: n((e) => [t("span", null, l(e.row.typeName), 1)]), _: 1 }), a(o, { prop: "unitWeight", "show-overflow-tooltip": true, align: "center", label: `容重
(kg/m³)` }, { default: n((e) => [t("span", null, l(e.row.unitWeight), 1)]), _: 1 }), a(o, { prop: "quantity", "show-overflow-tooltip": true, align: "center", label: "数量(m)" }, { default: n((e) => [t("span", null, l(e.row.quantity), 1)]), _: 1 })]), _: 1 }), _.isShow ? N("", true) : (r(), f(o, { key: 0, label: "操作", align: "center", width: "110" }, { default: n((e) => [a(d, { size: "default", icon: "el-icon-edit", type: "primary", onClick: (C) => S(e.$index, e.row) }, null, 8, ["onClick"]), a(d, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (C) => E(e.$index) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 8, ["data"]);
  };
} }, Q = T(G, [["__scopeId", "data-v-c7d0a549"]]);
export {
  Q as default
};
