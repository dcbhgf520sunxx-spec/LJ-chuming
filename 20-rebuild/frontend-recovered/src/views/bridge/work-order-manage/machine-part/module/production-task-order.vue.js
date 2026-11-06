import { ref as m } from "vue";
import { resolveComponent as h } from "vue";
import { withDirectives as u } from "vue";
import { openBlock as d } from "vue";
import { createBlock as w } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as g } from "vue";
import { ElTableColumn as f } from "element-plus";
import { ElImage as b } from "element-plus";
import { vLoading as y } from "element-plus";
import { ba as _ } from "../../../../../shared/runtime.js";
const v = { style: { width: "100%", height: "80px" } }, j = { __name: "production-task-order", props: { tableData: { type: Array, default: () => [] }, tableLoading: { type: Boolean, default: false }, maxHeight: { type: [String, Number] } }, setup(a) {
  const l = m([["project", "parse-project"]]);
  function i(o) {
    return _(o, { props: ["quantity", "weight"] });
  }
  return (o, k) => {
    const t = f, n = b, s = h("common-table"), p = y;
    return u((d(), w(s, { ref: "table", data: a.tableData, "empty-text": "暂无数据", "data-format": l.value, "max-height": a.maxHeight, style: { width: "100%" }, "show-summary": "", "summary-method": i }, { default: r(() => [e(t, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(t, { "show-overflow-tooltip": true, prop: "project", key: "project.shortName", label: "项目", "min-width": "120" }), e(t, { "show-overflow-tooltip": true, prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "specification", key: "specification", label: "规格", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "material", key: "material", label: "材质", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "quantity", key: "quantity", label: "数量", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "weight", key: "weight", label: "重量（kg）", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "picturePath", key: "picturePath", label: "图形", align: "center", width: "150" }, { default: r((c) => [g("div", v, [e(n, { style: { width: "100%", height: "100%" }, src: c.row.picturePath, fit: "scale-down" }, null, 8, ["src"])])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[p, a.tableLoading]]);
  };
} };
export {
  j as default
};
