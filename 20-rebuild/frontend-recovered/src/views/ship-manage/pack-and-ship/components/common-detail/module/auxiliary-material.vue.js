import { resolveComponent as u } from "vue";
import { openBlock as i } from "vue";
import { createBlock as s } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as c } from "vue";
import { createTextVNode as d } from "vue";
import { ElTableColumn as f } from "element-plus";
const g = { __name: "auxiliary-material", props: { list: { type: Array, default: () => [] }, isSuspend: { type: Boolean, default: false }, maxHeight: { type: [String, Number], default: void 0 } }, setup(p) {
  return (h, b) => {
    const t = f, m = u("common-table");
    return i(), s(m, { data: p.list, "show-empty-symbol": false, "max-height": p.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: o(() => [a(t, { label: "序号", type: "index", align: "center", width: "60" }), a(t, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体" }, { default: o(({ row: e }) => {
      var l;
      return [n("span", null, r(e.monomer ? (l = e.monomer) == null ? void 0 : l.name : "-"), 1)];
    }), _: 1 }), p.isSuspend ? (i(), s(t, { key: 0, "show-overflow-tooltip": true, prop: "area.name", label: "区域" }, { default: o(({ row: e }) => {
      var l;
      return [n("span", null, r(e.area ? (l = e.area) == null ? void 0 : l.name : "-"), 1)];
    }), _: 1 })) : c("", true), a(t, { "show-overflow-tooltip": true, prop: "name", label: "名称" }), a(t, { "show-overflow-tooltip": true, prop: "color", label: "颜色" }, { default: o(({ row: e }) => [n("span", null, r(e.color ? e.color : "-"), 1)]), _: 1 }), a(t, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), a(t, { "show-overflow-tooltip": true, prop: "measureUnit", label: "计量单位", align: "center" }), a(t, { prop: "showQuantity", label: "数量", align: "center" }), a(t, { "show-overflow-tooltip": true, prop: "accountingUnit", label: "核算单位", align: "center" }), a(t, { prop: "shipMete", label: "核算量", align: "center" }, { default: o(({ row: e }) => [n("span", null, r(e.shipMete ? e.shipMete : e.packageMete), 1)]), _: 1 }), a(t, { "show-overflow-tooltip": true, prop: "packSerialNumber", label: "包单号", align: "center" }, { default: o((e) => [d(r(e.row.packSerialNumber || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  g as default
};
