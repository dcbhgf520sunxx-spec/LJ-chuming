import { ref as o } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as t } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as m } from "vue";
import { unref as c } from "vue";
import { ElTag as V } from "element-plus";
import { ms as y, aa as _, B as M, E as g, t3 as N, t5 as w, t0 as C, t6 as u } from "../../../../../../shared/runtime.js";
import b from "../../../../../supply-chain/components/audit-records.vue.js";
const j = { __name: "header", props: ["APPtotal", "subTotal", "rejTotal"], setup(d) {
  const r = o("XML"), l = d, f = { dataType: y.XML_FILE.V, productType: _.ARTIFACT.V }, s = o(false), e = o({}), { crud: v } = M(f);
  function T(n) {
    const a = n;
    e.value.moduleType = w.PLAN_MANAGEMENT.V, e.value.componentNameList = [C.PLAN_XML_DOCUMENT_MANAGE.V], a === 1 ? (e.value.reviewStatus = u.WITHDRAW.V, e.value.waitMeCheck = true, e.value.meLaunch = false) : a === 2 ? (e.value.reviewStatus = u.WITHDRAW.V, e.value.waitMeCheck = false, e.value.meLaunch = true) : a === 3 && (e.value.reviewStatus = u.REJECT.V, e.value.waitMeCheck = false, e.value.meLaunch = false), s.value = true;
  }
  return (n, a) => {
    const A = V;
    return E(), L("div", null, [t(c(g), null, { viewLeft: i(() => [t(A, { class: "filter-item", effect: "plain", size: "large" }, { default: i(() => [P(" 文件导入仅支持" + m(r.value) + "格式、ZIP压缩包格式（内容为" + m(r.value) + "格式） ", 1)]), _: 1 }), t(b, { APPtotal: l.APPtotal, rejTotal: l.rejTotal, subTotal: l.subTotal, style: { "margin-left": "10px", "padding-right": "10px" }, onOpenAPLists: T }, null, 8, ["APPtotal", "rejTotal", "subTotal"])]), _: 1 }), t(N, { modelValue: s.value, "onUpdate:modelValue": a[0] || (a[0] = (p) => s.value = p), form: e.value, onSuccess: a[1] || (a[1] = (p) => c(v).toQuery()) }, null, 8, ["modelValue", "form"])]);
  };
} };
export {
  j as default
};
