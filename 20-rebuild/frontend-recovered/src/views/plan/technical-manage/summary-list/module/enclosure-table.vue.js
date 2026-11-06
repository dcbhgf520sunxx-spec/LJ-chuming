import { ref as g } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as i } from "vue";
import { withCtx as a } from "vue";
import { unref as t } from "vue";
import { createBlock as c } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as f } from "vue";
import { ElTableColumn as x } from "element-plus";
import { _ as E, o as k, T as d, D as _ } from "../../../../../shared/runtime.js";
const S = { __name: "enclosure-table", props: { enclosureData: { type: Array, default: () => [] }, category: { type: [String, Number], default: void 0 }, blankText: { type: [String], default: "暂无数据" } }, setup(l) {
  const w = g(), p = l, { maxHeight: h } = k({ wrapperBox: ".enclosureTable", paginate: true, extraHeight: 40 });
  return (T, v) => {
    const o = x, y = m("common-table");
    return u(), b("div", null, [i(y, { ref_key: "tableRef", ref: w, data: l.enclosureData, "empty-text": l.blankText, "max-height": t(h), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: a(() => [i(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), p.category !== t(d).BENDING.V ? (u(), c(o, { key: "plateId", prop: "plateId", "show-overflow-tooltip": true, label: "板型" }, { default: a((e) => [n("div", null, r(e.row.plate ? e.row.plate : "-"), 1)]), _: 1 })) : s("", true), l.category === t(d).BENDING.V ? (u(), c(o, { key: "unfoldedWidth", prop: "unfoldedWidth", "show-overflow-tooltip": true, label: "展开宽度(mm)" }, { default: a((e) => [n("div", null, r(e.row.unfoldedWidth ? e.row.unfoldedWidth.toFixed(t(_).MES_ENCLOSURE_W__MM) : "-"), 1)]), _: 1 })) : s("", true), l.category !== t(d).TRUSS_FLOOR_PLATE.V ? (u(), c(o, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: "板厚(mm)", align: "left" }, { default: a((e) => [n("span", null, r(e.row.thickness ? e.row.thickness.toFixed(t(_).MES_ENCLOSURE_T__MM) : "-"), 1)]), _: 1 })) : s("", true), l.category != t(d).TRUSS_FLOOR_PLATE.V && l.category != t(d).PRESSURE_BEARING_PLATE.V ? (u(), c(o, { key: "color", prop: "color", "show-overflow-tooltip": true, label: "颜色" }, { default: a((e) => [n("div", null, r(e.row.color ? e.row.color : "-"), 1)]), _: 1 })) : s("", true), l.category !== t(d).SANDWICH_BOARD.V && l.category !== t(d).TRUSS_FLOOR_PLATE.V ? (u(), c(o, { key: "brand", prop: "brand", "show-overflow-tooltip": true, label: "品牌" }, { default: a((e) => [n("div", null, r(e.row.brand ? e.row.brand : "-"), 1)]), _: 1 })) : s("", true), i(o, { key: "quantity", prop: "quantity", label: "数量(张)", align: "left" }, { default: a((e) => [n("span", null, r(e.row.quantity), 1)]), _: 1 }), i(o, { key: "totalLength", prop: "totalLength", label: "总长度(m)", align: "left" }, { default: a((e) => [f(r(e.row.totalLength ? e.row.totalLength.toFixed(t(_).MES_ENCLOSURE_L__M) : "-"), 1)]), _: 1 }), i(o, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": true, label: "总面积(㎡)", align: "left" }, { default: a((e) => [f(r(e.row.totalArea ? e.row.totalArea.toFixed(t(_).COM_AREA__M2) : "-"), 1)]), _: 1 }), i(o, { key: "weight", prop: "weight", "show-overflow-tooltip": true, label: "重量(kg)" }, { default: a((e) => [n("div", null, r(e.row.weight ? e.row.weight.toFixed(t(_).COM_WT__KG) : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])]);
  };
} }, L = E(S, [["__scopeId", "data-v-3078cb7a"]]);
export {
  L as default
};
