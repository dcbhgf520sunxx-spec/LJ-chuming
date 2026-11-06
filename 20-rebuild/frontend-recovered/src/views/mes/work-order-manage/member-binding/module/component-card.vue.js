import { ref as p } from "vue";
import { watch as w } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as t } from "vue";
import { withCtx as s } from "vue";
import { withKeys as v } from "vue";
import { normalizeStyle as C } from "vue";
import { ElInputNumber as N } from "element-plus";
import { ElTableColumn as D } from "element-plus";
import { ElCard as k } from "element-plus";
import { g as E } from "../../../../../modules/member-binding-2f5cdd6e.js";
import "../../../../../shared/runtime.js";
const H = { __name: "component-card", props: { rowData: { type: Object, default: () => {
} }, maxHeight: { type: Number, default: 500 } }, emits: ["componentRowClick"], setup(i, { emit: u }) {
  const o = i, d = u, a = p([]), r = p();
  w(() => o.rowData, () => {
    a.value = [], c();
  });
  const c = async () => {
    try {
      a.value = [];
      const e = await E({ orderId: o.rowData.id, productId: o.rowData.productId, number: r.value });
      a.value = e;
    } catch (e) {
      console.log(e, "构件获取失败");
    }
  }, h = (e) => {
    console.log(e), d("componentRowClick", e);
  };
  return (e, n) => {
    const b = N, l = D, _ = x("common-table"), g = k;
    return f(), y("div", null, [t(g, { style: C({ width: "650px", height: o.maxHeight + "px" }) }, { header: s(() => [t(b, { style: { width: "170px" }, min: 0, max: 99999, precision: 0, controls: false, placeholder: "请输入构件码号搜索", modelValue: r.value, "onUpdate:modelValue": n[0] || (n[0] = (m) => r.value = m), onKeyup: n[1] || (n[1] = v((m) => c(), ["enter"])) }, null, 8, ["modelValue"])]), default: s(() => [t(_, { data: a.value, onSelectionChange: h, "max-height": o.maxHeight - 109 }, { default: s(() => [t(l, { type: "selection", width: "55", align: "center" }), t(l, { label: "码号", align: "center", prop: "number", width: "80" }), t(l, { label: "构件编号", align: "center", prop: "serialNumber" }), t(l, { label: "名称", align: "center", prop: "processName" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["style"])]);
  };
} };
export {
  H as default
};
