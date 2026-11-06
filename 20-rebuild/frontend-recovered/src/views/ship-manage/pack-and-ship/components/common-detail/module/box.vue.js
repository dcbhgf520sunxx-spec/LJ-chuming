import { resolveComponent as c } from "vue";
import { openBlock as m } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createCommentVNode as h } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as n } from "vue";
import { unref as l } from "vue";
import { ElTableColumn as f } from "element-plus";
import { bs as p, D as s } from "../../../../../../shared/runtime.js";
const x = { __name: "box", props: { list: { type: Array, default: () => [] }, isSuspend: { type: Boolean, default: false }, maxHeight: { type: [String, Number], default: void 0 } }, setup(i) {
  return (d, _) => {
    const e = f, w = c("common-table");
    return m(), u(w, { data: i.list, "max-height": i.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: a(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体" }), i.isSuspend ? (m(), u(e, { key: 0, "show-overflow-tooltip": true, prop: "area.name", label: "区域" })) : h("", true), t(e, { "show-overflow-tooltip": true, prop: "name", label: "名称" }), t(e, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), t(e, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), t(e, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "length", label: `长度
(mm)`, align: "center" }, { default: a((o) => [r(n(l(p)(o.row.length, l(s).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "weight", label: `单重
（kg）`, align: "center" }, { default: a((o) => [r(n(l(p)(o.row.weight, l(s).COM_WT__KG)), 1)]), _: 1 }), t(e, { prop: "showQuantity", label: "数量", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "totalWeight", label: `总重
（t）`, align: "center" }, { default: a((o) => [r(n(l(p)(o.row.totalWeight, l(s).COM_WT__T)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "packSerialNumber", label: "包单号", align: "center" }, { default: a((o) => [r(n(o.row.packSerialNumber || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  x as default
};
