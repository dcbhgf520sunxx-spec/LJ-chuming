import { resolveComponent as a } from "vue";
import { openBlock as r } from "vue";
import { createBlock as n } from "vue";
import { withCtx as i } from "vue";
import { createVNode as t } from "vue";
import { ElTableColumn as p } from "element-plus";
const u = { __name: "auxiliary-material", props: { list: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 } }, setup(o) {
  return (s, m) => {
    const e = p, l = a("common-table");
    return r(), n(l, { data: o.list, "max-height": o.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: i(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), t(e, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体" }), t(e, { "show-overflow-tooltip": true, prop: "fullClassName", label: "辅材类别", width: "280px" }), t(e, { prop: "unit", label: "单位", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "color", label: "颜色" }), t(e, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), t(e, { prop: "showQuantity", label: "数量", align: "center" })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  u as default
};
