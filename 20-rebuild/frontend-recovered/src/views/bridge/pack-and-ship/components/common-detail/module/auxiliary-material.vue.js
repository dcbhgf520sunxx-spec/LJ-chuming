import { resolveComponent as n } from "vue";
import { openBlock as l } from "vue";
import { createBlock as a } from "vue";
import { withCtx as p } from "vue";
import { createVNode as t } from "vue";
import { createCommentVNode as i } from "vue";
import { ElTableColumn as s } from "element-plus";
const d = { __name: "auxiliary-material", props: { list: { type: Array, default: () => [] }, isSuspend: { type: Boolean, default: false }, maxHeight: { type: [String, Number], default: void 0 } }, setup(o) {
  return (m, u) => {
    const e = s, r = n("common-table");
    return l(), a(r, { data: o.list, "max-height": o.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: p(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体" }), o.isSuspend ? (l(), a(e, { key: 0, "show-overflow-tooltip": true, prop: "area.name", label: "区域" })) : i("", true), t(e, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), t(e, { "show-overflow-tooltip": true, prop: "fullClassName", label: "辅材类别", width: "280px" }), t(e, { prop: "unit", label: "单位", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "color", label: "颜色" }), t(e, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), t(e, { prop: "showQuantity", label: "数量", align: "center" })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  d as default
};
