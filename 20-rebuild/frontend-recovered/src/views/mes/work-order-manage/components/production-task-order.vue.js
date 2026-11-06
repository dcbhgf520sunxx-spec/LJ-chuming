import { ref as d } from "vue";
import { resolveComponent as u } from "vue";
import { withDirectives as g } from "vue";
import { openBlock as r } from "vue";
import { createBlock as w } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as _ } from "vue";
import { createElementBlock as s } from "vue";
import { ElTableColumn as f } from "element-plus";
import { ElImage as y } from "element-plus";
import { vLoading as b } from "element-plus";
import { _ as k, ba as v } from "../../../../shared/runtime.js";
const x = { class: "error-slot" }, N = { key: 0 }, W = { key: 1 }, B = { __name: "production-task-order", props: { tableData: { type: Array, default: () => [] }, tableLoading: { type: Boolean, default: false }, maxHeight: { type: [String, Number] } }, setup(o) {
  const n = d([["project", "parse-project"]]);
  function p(i) {
    return v(i, { props: ["quantity", "totalNetWeight", "totalGrossWeight"] });
  }
  return (i, E) => {
    const t = f, c = y, m = u("common-table"), h = b;
    return g((r(), w(m, { ref: "table", data: o.tableData, "empty-text": "暂无数据", "show-empty-symbol": false, "data-format": n.value, "max-height": o.maxHeight, style: { width: "100%" }, "show-summary": "", "summary-method": p }, { default: l(() => [e(t, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(t, { "show-overflow-tooltip": true, prop: "project", key: "project.shortName", label: "项目", "min-width": "120" }), e(t, { "show-overflow-tooltip": true, prop: "monomerName", key: "monomerName", label: "单体", "min-width": "100" }), e(t, { "show-overflow-tooltip": true, prop: "areaName", key: "areaName", label: "区域", width: "80" }), e(t, { "show-overflow-tooltip": true, prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "specification", key: "specification", label: "规格", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "material", key: "material", label: "材质", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "quantity", key: "quantity", label: "数量", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "netWeight", key: "netWeight", label: `单净重
（kg）`, align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "grossWeight", key: "grossWeight", label: `单毛重
（kg）`, align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "totalNetWeight", key: "totalNetWeight", label: `总净重
（kg）`, align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "totalGrossWeight", key: "totalGrossWeight", label: `总毛重
（kg）`, align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "picturePath", key: "picturePath", label: "图形", align: "center", width: "150" }, { default: l((a) => [e(c, { style: { width: "100%", height: "50px" }, src: a.row.picturePath, fit: "scale-down", onError: (j) => a.row.imgLoad = false }, { error: l(() => [_("div", x, [a.row.picturePath ? (r(), s("span", N, "加载失败")) : (r(), s("span", W, "未导入DXF"))])]), _: 2 }, 1032, ["src", "onError"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[h, o.tableLoading]]);
  };
} }, L = k(B, [["__scopeId", "data-v-8d5d48e9"]]);
export {
  L as default
};
