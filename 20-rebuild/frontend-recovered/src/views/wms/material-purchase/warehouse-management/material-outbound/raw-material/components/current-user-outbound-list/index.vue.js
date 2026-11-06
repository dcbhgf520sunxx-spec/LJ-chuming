import { inject as V } from "vue";
import { ref as r } from "vue";
import { onMounted as k } from "vue";
import { computed as U } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as u } from "vue";
import { withCtx as l } from "vue";
import { mergeProps as c } from "vue";
import { createTextVNode as x } from "vue";
import { createBlock as A } from "vue";
import { resolveDynamicComponent as B } from "vue";
import { Fragment as D } from "vue";
import { ElBadge as R } from "element-plus";
import { zJ as P, G as T, zK as z, cP as m } from "../../../../../../../../shared/runtime.js";
import F from "./module/list.vue.js";
import M from "./module/manuf-list.vue.js";
import "../../../../../../../../modules/review-a53b87d8.js";
import "../../../../material-inventory/manufactured/manufactured-essential-information/index.vue.js";
import "../../../../material-inventory/manufactured/manufactured-essential-information/module/enclosure.vue.js";
import "../../../../material-inventory/manufactured/manufactured-essential-information/module/structure.vue.js";
const H = { __name: "index", props: { basicClass: { type: Number } }, emits: ["refresh"], setup(p, { expose: d, emit: f }) {
  P();
  const n = f, b = p, v = V("permission"), s = r(0), a = r(false);
  k(async () => {
    o();
  });
  async function o() {
    const e = { boolPartyA: false };
    return T(v.outbound) && (s.value = await z(e)), s.value;
  }
  async function C() {
    const e = s.value, t = await o();
    e !== t && n("refresh");
  }
  function h() {
    a.value = true, C();
  }
  function _() {
    o(), n("refresh");
  }
  const N = U(() => {
    switch (b.basicClass) {
      case m.STRUC_MANUFACTURED.V:
      case m.ENCL_MANUFACTURED.V:
        return M;
      default:
        return F;
    }
  });
  return d({ updateListNumber: o }), (e, t) => {
    const g = E("common-button"), y = R;
    return i(), w(D, null, [u(y, { hidden: s.value <= 0, value: s.value, style: { "margin-right": "6px" } }, { default: l(() => [u(g, c({ icon: "el-icon-tickets", size: "default", type: "success" }, e.$attrs, { onClick: h }), { default: l(() => t[1] || (t[1] = [x(" 出库清单 ")])), _: 1, __: [1] }, 16)]), _: 1 }, 8, ["hidden", "value"]), (i(), A(B(N.value), c({ visible: a.value, "onUpdate:visible": t[0] || (t[0] = (L) => a.value = L) }, e.$attrs, { onRefresh: _ }), null, 16, ["visible"]))], 64);
  };
} };
export {
  H as default
};
