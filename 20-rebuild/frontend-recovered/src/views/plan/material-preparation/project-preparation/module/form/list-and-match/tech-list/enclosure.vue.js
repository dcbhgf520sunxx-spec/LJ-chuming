import { ref as r } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as m } from "vue";
import { createBlock as u } from "vue";
import { withCtx as d } from "vue";
import { createVNode as s } from "vue";
import { mergeProps as f } from "vue";
import { ElTableColumn as _ } from "element-plus";
import { _ as b, jN as p, jG as h, sO as y, k5 as g } from "../../../../../../../../shared/runtime.js";
const C = { __name: "enclosure", props: { height: { type: Number, default: 250 }, list: { type: Array, default: () => [] }, techPrepMeteKV: { type: Object, default: () => ({}) }, editMode: { type: Boolean, default: false } }, setup(a) {
  const l = a, o = r(), t = [["listMete", ["to-fixed", p.weight.precision]]];
  return (e, w) => {
    const n = _, c = i("common-table");
    return m(), u(c, f({ class: "list-table" }, e.$attrs, { ref_key: "tableRef", ref: o, data: a.list, "data-format": t, height: l.height, "row-key": "id" }), { default: d(() => [s(n, { label: "序号", type: "index", align: "center", width: "60" }), s(h, { columns: e.columns, "basic-class": e.basicClass, "show-frozen-tip": "", "frozen-viewable": "", sortable: "", fixed: "left", onRefresh: e.handleRefresh }, null, 8, ["columns", "basic-class", "onRefresh"]), s(y, { columns: e.columns, "basic-class": e.basicClass, "equal-disabled": "" }, null, 8, ["columns", "basic-class"]), s(g, { columns: e.columns, "basic-class": e.basicClass }, null, 8, ["columns", "basic-class"])]), _: 1 }, 16, ["data", "height"]);
  };
} }, B = b(C, [["__scopeId", "data-v-a2999d63"]]);
export {
  B as default
};
