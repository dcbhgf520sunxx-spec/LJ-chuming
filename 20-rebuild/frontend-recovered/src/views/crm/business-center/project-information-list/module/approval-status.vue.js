import { ref as l } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as n } from "vue";
import { createBlock as i } from "vue";
import { withCtx as m } from "vue";
import { createVNode as t } from "vue";
import { ElTableColumn as s } from "element-plus";
const h = { __name: "approval-status", props: { list: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 } }, setup(a) {
  const o = l([["arrivalTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["approveTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]]]);
  return (c, u) => {
    const e = s, r = p("common-table");
    return n(), i(r, { data: a.list, dataFormat: o.value, "max-height": a.maxHeight, "empty-text": "暂无数据", style: { width: "100%" } }, { default: m(() => [t(e, { align: "center", "show-overflow-tooltip": true, prop: "typeName", label: "节点" }), t(e, { align: "center", "show-overflow-tooltip": true, prop: "userSimpleResponseVOS.name", label: "关联审批人" }), t(e, { align: "center", "show-overflow-tooltip": true, prop: "arrivalTime", label: "到达时间" }), t(e, { align: "center", "show-overflow-tooltip": true, prop: "approveTime", label: "处理时间" }), t(e, { align: "center", "show-overflow-tooltip": true, prop: "opinion", label: "处理意见" })]), _: 1 }, 8, ["data", "dataFormat", "max-height"]);
  };
} };
export {
  h as default
};
