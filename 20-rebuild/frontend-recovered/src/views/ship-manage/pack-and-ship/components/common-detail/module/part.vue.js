import { resolveComponent as c } from "vue";
import { openBlock as m } from "vue";
import { createBlock as u } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as n } from "vue";
import { unref as a } from "vue";
import { ElTableColumn as f } from "element-plus";
import { bs as p, D as s } from "../../../../../../shared/runtime.js";
const v = { __name: "part", props: { list: { type: Array, default: () => [] }, isSuspend: { type: Boolean, default: false }, maxHeight: { type: [String, Number], default: void 0 } }, setup(i) {
  return (b, g) => {
    const e = f, w = c("table-cell-tag"), _ = c("common-table");
    return m(), u(_, { data: i.list, "max-height": i.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: l(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { "show-overflow-tooltip": true, prop: "monomer.name", align: "center", label: "单体" }, { default: l(({ row: o }) => [t(w, { show: o.boolAllPartSendDirectly, name: "檩条直发", color: "#f56c6c" }, null, 8, ["show"]), h("span", null, r(o.monomer.name), 1)]), _: 1 }), i.isSuspend ? (m(), u(e, { key: 0, "show-overflow-tooltip": true, prop: "area.name", label: "区域" })) : d("", true), t(e, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), t(e, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), t(e, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "length", label: `长度
(mm)`, align: "center" }, { default: l((o) => [n(r(a(p)(o.row.length, a(s).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "weight", label: `单重
（kg）`, align: "center" }, { default: l((o) => [n(r(a(p)(o.row.weight, a(s).COM_WT__KG)), 1)]), _: 1 }), t(e, { prop: "showQuantity", label: "数量", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "totalWeight", label: `总重
（t）`, align: "center" }, { default: l((o) => [n(r(a(p)(o.row.totalWeight, a(s).COM_WT__T)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "packSerialNumber", label: "包单号", align: "center" }, { default: l((o) => [n(r(o.row.packSerialNumber || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  v as default
};
