import { resolveComponent as c } from "vue";
import { openBlock as r } from "vue";
import { createBlock as i } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as u } from "vue";
import { ElTableColumn as d } from "element-plus";
const g = { __name: "auxiliary-material", props: { list: { type: Array, default: () => [] }, isSuspend: { type: Boolean, default: false }, maxHeight: { type: [String, Number], default: void 0 } }, setup(l) {
  return (f, h) => {
    const e = d, p = c("common-table");
    return r(), i(p, { data: l.list, "max-height": l.maxHeight, "show-empty-symbol": false, "empty-text": "暂无数据", style: { width: "100%" } }, { default: n(() => [a(e, { label: "序号", type: "index", align: "center", width: "60" }), a(e, { "show-overflow-tooltip": true, prop: "monomer.name", align: "center", label: "单体" }, { default: n(({ row: t }) => {
      var o;
      return [s("span", null, m(t.monomer ? (o = t.monomer) == null ? void 0 : o.name : "-"), 1)];
    }), _: 1 }), l.isSuspend ? (r(), i(e, { key: 0, align: "center", "show-overflow-tooltip": true, prop: "area.name", label: "区域" }, { default: n(({ row: t }) => {
      var o;
      return [s("span", null, m(t.area ? (o = t.area) == null ? void 0 : o.name : "-"), 1)];
    }), _: 1 })) : u("", true), a(e, { "show-overflow-tooltip": true, align: "center", prop: "name", label: "名称" }), a(e, { prop: "measureUnit", label: "单位", align: "center" }), a(e, { "show-overflow-tooltip": true, align: "center", prop: "specification", label: "规格" }), a(e, { prop: "showQuantity", label: "数量", align: "center" })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  g as default
};
