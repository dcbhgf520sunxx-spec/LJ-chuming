import { resolveComponent as c } from "vue";
import { openBlock as s } from "vue";
import { createBlock as i } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createCommentVNode as w } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as n } from "vue";
import { unref as a } from "vue";
import { ElTableColumn as h } from "element-plus";
import { bs as u, D as m } from "../../../../../../shared/runtime.js";
const v = { __name: "structure", props: { list: { type: Array, default: () => [] }, isSuspend: { type: Boolean, default: false }, maxHeight: { type: [String, Number], default: void 0 } }, setup(p) {
  return (d, g) => {
    const e = h, f = c("table-cell-tag"), _ = c("common-table");
    return s(), i(_, { data: p.list, "max-height": p.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: l(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体" }), p.isSuspend ? (s(), i(e, { key: 0, "show-overflow-tooltip": true, prop: "area.name", label: "区域" })) : w("", true), t(e, { "show-overflow-tooltip": true, prop: "name", label: "名称" }, { default: l((o) => [o.row.warehouseType === 1 ? (s(), i(f, { key: 0, name: "回厂返修", color: "#e64242", offset: 30 })) : w("", true), r(" " + n(o.row.name), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), t(e, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), t(e, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "length", label: `长度
(mm)`, align: "center" }, { default: l((o) => [r(n(a(u)(o.row.length, a(m).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "grossWeight", label: `毛重
（kg）`, align: "center" }, { default: l((o) => [r(n(a(u)(o.row.grossWeight, a(m).COM_WT__KG)), 1)]), _: 1 }), t(e, { prop: "showQuantity", label: "数量", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "totalWeight", label: `总重
（t）`, align: "center" }, { default: l((o) => [r(n(a(u)(o.row.totalGrossWeight / 1e3, a(m).COM_WT__T)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "packSerialNumber", label: "包单号", align: "center" }, { default: l((o) => [r(n(o.row.packSerialNumber || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  v as default
};
