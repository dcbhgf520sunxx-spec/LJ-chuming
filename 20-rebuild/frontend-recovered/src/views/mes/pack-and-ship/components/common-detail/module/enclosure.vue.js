import { resolveComponent as h } from "vue";
import { openBlock as m } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createCommentVNode as _ } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as n } from "vue";
import { unref as o } from "vue";
import { ElTableColumn as c } from "element-plus";
import { bs as p, D as s } from "../../../../../../shared/runtime.js";
const E = { __name: "enclosure", props: { list: { type: Array, default: () => [] }, isSuspend: { type: Boolean, default: false }, maxHeight: { type: [String, Number], default: void 0 } }, setup(i) {
  return (d, f) => {
    const e = c, w = h("common-table");
    return m(), u(w, { data: i.list, "max-height": i.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: a(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体" }), i.isSuspend ? (m(), u(e, { key: 0, "show-overflow-tooltip": true, prop: "area.name", label: "区域" })) : _("", true), t(e, { "show-overflow-tooltip": true, prop: "name", label: "名称" }), t(e, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), t(e, { "show-overflow-tooltip": true, prop: "plate", label: "板型" }), t(e, { "show-overflow-tooltip": true, prop: "color", label: "颜色" }), t(e, { "show-overflow-tooltip": true, prop: "thickness", label: `厚度
(mm)`, align: "center" }, { default: a((l) => [r(n(o(p)(l.row.thickness, o(s).MES_ENCLOSURE_T__MM)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "width", label: `有效宽度
(mm)`, align: "center" }, { default: a((l) => [r(n(o(p)(l.row.width, o(s).MES_ENCLOSURE_W__MM)), 1)]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "length", label: `长度
(mm)`, align: "center" }, { default: a((l) => [r(n(o(p)(l.row.length, o(s).MES_ENCLOSURE_L__MM)), 1)]), _: 1 }), t(e, { prop: "showQuantity", label: "数量", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "totalLength", label: `总长度
(m)`, align: "center", width: "100px" }, { default: a((l) => [r(n(o(p)(l.row.totalLength, o(s).MES_ENCLOSURE_L__M)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  E as default
};
