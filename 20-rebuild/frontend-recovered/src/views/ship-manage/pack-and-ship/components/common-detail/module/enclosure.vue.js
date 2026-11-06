import { resolveComponent as m } from "vue";
import { openBlock as c } from "vue";
import { createBlock as f } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as l } from "vue";
import { toDisplayString as r } from "vue";
import { unref as n } from "vue";
import { ElTableColumn as w } from "element-plus";
import { bs as s, D as i } from "../../../../../../shared/runtime.js";
const g = { __name: "enclosure", props: { list: { type: Array, default: () => [] }, isSuspend: { type: Boolean, default: false }, maxHeight: { type: [String, Number], default: void 0 } }, setup(p) {
  return (h, _) => {
    const e = w, u = m("common-table");
    return c(), f(u, { data: p.list, "max-height": p.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: a(() => [t(e, { align: "center", label: "序号", type: "index", width: "60" }), t(e, { "show-overflow-tooltip": true, label: "批次", prop: "area.name" }), t(e, { "show-overflow-tooltip": true, label: "名称", prop: "name" }), t(e, { "show-overflow-tooltip": true, label: "编号", prop: "serialNumber" }), t(e, { "show-overflow-tooltip": true, label: "板型", prop: "plate" }), t(e, { align: "center", label: "数量", prop: "showQuantity" }), t(e, { label: `单面积
(m²)`, "show-overflow-tooltip": true, align: "center", prop: "surfaceArea" }, { default: a((o) => [l(r(o.row.surfaceArea), 1)]), _: 1 }), t(e, { label: `单长
(mm)`, "show-overflow-tooltip": true, align: "center", prop: "length" }, { default: a((o) => [l(r(n(s)(o.row.length, n(i).MES_ENCLOSURE_L__MM)), 1)]), _: 1 }), t(e, { label: `总长度
(m)`, "show-overflow-tooltip": true, align: "center", prop: "totalLength", width: "100px" }, { default: a((o) => [l(r(n(s)(o.row.totalLength, n(i).MES_ENCLOSURE_L__M)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, align: "center", label: "包单号", prop: "packSerialNumber" }, { default: a((o) => [l(r(o.row.packSerialNumber || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  g as default
};
