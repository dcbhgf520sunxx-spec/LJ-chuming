import { _ as d, aR as r, k4 as b, jG as f, bl as e, k5 as h, k6 as u } from "../../../../../../../shared/runtime.js";
import w from "./module/quantity-info.vue.js";
import _ from "./module/size-info.vue.js";
import { ref as x } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as C } from "vue";
import { createBlock as E } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
const k = { __name: "index", props: { basicClass: { type: Number }, list: { type: Array, default: () => [] }, maxHeight: { type: Number } }, setup(s) {
  const i = s, l = x([]);
  return (p, n) => {
    const m = y("common-table");
    return C(), E(m, { ref: "tableRef", data: s.list, "max-height": s.maxHeight, "expand-row-keys": l.value, "row-key": "id" }, { default: o(() => [a(r, { data: s.list, "expand-row-keys": l.value, "onUpdate:expandRowKeys": n[0] || (n[0] = (c) => l.value = c), "row-key": "id", fixed: "left" }, { default: o(({ row: c }) => [a(b, { "basic-class": c.basicClass, row: c, "show-batch-no": false, "show-remark": "", "show-graphics": "" }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["data", "expand-row-keys"]), a(f, { "basic-class": s.basicClass, "show-length": ![t(e).STEEL_PLATE.V, t(e).SECTION_STEEL.V].includes(s.basicClass), "show-width": s.basicClass !== t(e).STEEL_PLATE.V, "show-thickness": s.basicClass !== t(e).STEEL_PLATE.V, fixed: "left" }, null, 8, ["basic-class", "show-length", "show-width", "show-thickness"]), a(h, { "basic-class": s.basicClass }, null, 8, ["basic-class"]), a(_, { "basic-class": i.basicClass }, null, 8, ["basic-class"]), a(w, { "basic-class": i.basicClass, "show-quantity": s.basicClass !== t(e).STEEL_COIL.V }, null, 8, ["basic-class", "show-quantity"]), a(u, { "show-project": "" })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys"]);
  };
} }, S = d(k, [["__scopeId", "data-v-cfea5a28"]]);
export {
  S as default
};
