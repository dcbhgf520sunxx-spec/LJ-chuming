import { ref as v } from "vue";
import { watch as V } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as B } from "vue";
import { createBlock as C } from "vue";
import { withCtx as o } from "vue";
import { createVNode as s } from "vue";
import { unref as a } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as u } from "vue";
import { isRef as k } from "vue";
import { ElTableColumn as I } from "element-plus";
import { m as N } from "../../../../modules/contract-ledger-2ee7c4ce.js";
import { _ as H, t as M, u as j, o as D, bV as R, p as S } from "../../../../shared/runtime.js";
const T = { __name: "contract-money", props: { modelValue: { type: Boolean, require: true }, projectId: { type: [String, Number], default: void 0 } }, emits: ["success", "update:modelValue"], setup(d, { emit: _ }) {
  const { decimalPrecision: w } = M(), m = d, c = v([]), f = _, { visible: l, handleClose: h } = j({ emit: f, props: m }), { maxHeight: b } = D({ mainBox: ".amount-detail", extraBox: [".el-drawer__header"], wrapperBox: ".el-drawer__body", paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, l);
  V(() => m.projectId, (t) => {
    t ? y() : c.value = [];
  }, { deep: true, immediate: true });
  async function y() {
    try {
      const { content: t } = await N({ projectId: m.projectId });
      c.value = t || [];
    } catch (t) {
      console.log("获取变更金额记录", t);
    }
  }
  return (t, p) => {
    const n = I, x = i("common-table"), g = i("common-drawer");
    return B(), C(g, { "append-to-body": "", modelValue: a(l), "onUpdate:modelValue": p[0] || (p[0] = (e) => k(l) ? l.value = e : null), top: "10vh", width: "600px", "before-close": a(h), title: "合同额", "wrapper-closable": false, "custom-class": "amount-detail", size: "900px" }, { content: o(() => [s(x, { ref: "tableRef", data: c.value, "max-height": a(b), style: { width: "100%" }, "return-source-data": "", showEmptySymbol: false }, { default: o(() => [s(n, { key: "status", prop: "status", "show-overflow-tooltip": true, label: "项目", width: "140px" }, { default: o((e) => [r("span", null, u(e.row.status), 1)]), _: 1 }), s(n, { key: "amount", prop: "amount", "show-overflow-tooltip": true, label: "金额", "min-width": "160px" }, { default: o((e) => [r("span", null, u(e.row.amount ? a(R)(e.row.amount, a(w).contract) : "-"), 1)]), _: 1 }), s(n, { key: "date", prop: "date", "show-overflow-tooltip": true, label: "日期", "min-width": "150px" }, { default: o((e) => [r("span", null, u(e.row.date ? a(S)(e.row.date, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), s(n, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "操作人", "min-width": "150px" }, { default: o((e) => [r("span", null, u(e.row.userName), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, q = H(T, [["__scopeId", "data-v-25107047"]]);
export {
  q as default
};
