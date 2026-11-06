import { _ as P, u as B, c1 as c, j0 as i } from "../../../../../../shared/runtime.js";
import { ref as m } from "vue";
import { inject as N } from "vue";
import { computed as f } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as v } from "vue";
import { createBlock as V } from "vue";
import { createSlots as S } from "vue";
import { unref as t } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as n } from "vue";
import { toDisplayString as U } from "vue";
import { resolveDynamicComponent as G } from "vue";
import { isRef as z } from "vue";
import { defineAsyncComponent as r } from "vue";
import { ElTag as K } from "element-plus";
import { ElRadioButton as M } from "element-plus";
import { ElRadioGroup as $ } from "element-plus";
const q = { __name: "index", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(y, { emit: b }) {
  const E = y, x = m(), k = b, { visible: _, handleClose: w } = B({ emit: k, props: E, field: "visible", showHook: D, closeHook: j }), { projectName: R, itemData: u } = N("common"), T = f(() => `项目：${R.value}`), s = m();
  function D() {
    s.value = "collection";
  }
  function j() {
    g();
  }
  const A = { collection: r(() => i(() => import("./collection/index.vue.js"), ["static/js/index-4b597aa4.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-1f7d934b.js", "static/js/useTableTotal-3d22365a.js", "static/css/index-7aaf4a01.css"])), capital_injection: r(() => i(() => import("./capital_injection/index.vue.js"), ["static/js/index-58ca06c0.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/detail-59bd8a62.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-1f7d934b.js", "static/js/capital-de0d42db.js", "static/css/detail-d4cbdf30.css", "static/js/use-detail-964507bd.js", "static/js/purchase-select-6f5eca32.js", "static/css/purchase-select-c1372fb5.css", "static/css/use-detail-72208c16.css", "static/css/index-6d25ba75.css", "static/css/el-radio-group-3b9ac3ad.css"])), fee: r(() => i(() => import("./management-assurance/index.vue.js"), ["static/js/index-70185ffa.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/management-f1357e4c.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-1f7d934b.js", "static/js/assurance-e4f35fa3.js", "static/js/dialog-84267a40.js", "static/js/data-039b7fd9.js", "static/css/dialog-1d14610e.css", "static/css/el-radio-group-3b9ac3ad.css", "static/js/contract-9b18cc88.js", "static/css/index-a92eebed.css"])), interest: r(() => i(() => import("./interest-on-funds/index.vue.js"), ["static/js/index-ad680509.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/interest-on-funds-096f2ac3.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/detail-c0b7c620.js"])) }, C = f(() => A[s.value]), p = m();
  function g() {
    p.value = Math.random();
  }
  return (F, e) => {
    const I = K, l = M, L = $, O = H("common-drawer");
    return v(), V(O, { key: p.value, ref_key: "drawerRef", ref: x, modelValue: t(_), "onUpdate:modelValue": e[1] || (e[1] = (d) => z(_) ? _.value = d : null), "append-to-body": true, "before-close": t(w), title: T.value, size: "100%" }, S({ content: o(() => [a(L, { modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (d) => s.value = d), class: "box-container" }, { default: o(() => [a(l, { value: "collection" }, { default: o(() => e[2] || (e[2] = [n("收支台账")])), _: 1, __: [2] }), a(l, { value: "capital_injection" }, { default: o(() => e[3] || (e[3] = [n("注资明细")])), _: 1, __: [3] }), a(l, { value: "fee" }, { default: o(() => e[4] || (e[4] = [n("管理费&保证金")])), _: 1, __: [4] }), a(l, { value: "interest" }, { default: o(() => e[5] || (e[5] = [n("资金利息")])), _: 1, __: [5] })]), _: 1 }, 8, ["modelValue"]), (v(), V(G(C.value)))]), _: 2 }, [t(u).status ? { name: "titleAfter", fn: o(() => [a(I, { type: t(c).V[t(u).status].TAG }, { default: o(() => [n(U(t(c).VL[t(u).status]), 1)]), _: 1 }, 8, ["type"])]), key: "0" } : void 0]), 1032, ["modelValue", "before-close", "title"]);
  };
} }, X = P(q, [["__scopeId", "data-v-e0a0673c"]]);
export {
  X as default
};
